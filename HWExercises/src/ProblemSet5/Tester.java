package ProblemSet5;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ilya on 14/11/16.
 */
public class Tester {
    public static void main(String[] args) {
        //System.out.println(evaluate("4pt+(3in*2.4) "));

    }
    public String evaluate(String expression) {
        Lexer lexer = new Lexer(expression);
        Parser parser = new Parser(lexer);
        return parser.evaluate().toString();
    }
}


class Lexer {

    ArrayList<Token> tokenList = new ArrayList<Token>();
    /**
     * Token in the stream.
     */
    public static class Token {
        final Type type;
        final String text;

        Token(Type type, String text) {
            this.type = type;
            this.text = text;
        }

        Token(Type type) {
            this(type, null);
        }
    }

    @SuppressWarnings("serial")
    static class TokenMismatchException extends Exception {
    }

    // TODO write method spec
    public Lexer(String input) {
        input = input.replaceAll(" ", "");
        Pattern unitPattern = Pattern.compile("in|pt");
        Matcher  unitMatcher = unitPattern.matcher(input);
        int count = 0;
        while (unitMatcher.find())
            count++;
        if(count == 1){
            if(input.contains("i")){
                input = "("+input.substring(0,input.indexOf("i"))+")"+input.substring(input.indexOf("i"));
            }else{
                input = "("+input.substring(0,input.indexOf("p"))+")"+input.substring(input.indexOf("p"));
            }
        }
        Pattern patternBrackets = Pattern.compile("\\([0-9\\+\\-\\*\\/ inpt.]+\\)");
        Matcher matcher = patternBrackets.matcher(input);
        if(matcher.find()){
            String bracketContent = matcher.group(0);
            tokenList.addAll(splitter(bracketContent.replace("(", "").replace(")", "")));
            input=input.replace(bracketContent.toString(), "");
            ArrayList<Token> tmp = splitter(input);
            if(tmp.size()>0 && tmp.get(0).text.matches("\\d[ptin\\+\\-\\*\\/]*")){
                tokenList.add(0, new Token(tmp.get(0).type,"0"));
                Collections.reverse(tmp);
            }
            tokenList.addAll(tmp);
        }else{
            tokenList = splitter(input);
        }
    }

    private ArrayList<Token> splitter(String in){
        Pattern patternSingle = Pattern.compile("(pt|in)|([0-9.]+)(pt|in|)|([\\+\\-\\*\\/])");
        Matcher matcherSingle = patternSingle.matcher(in);
        ArrayList<Token> tokens = new ArrayList<Token>();
        while(matcherSingle.find()){
            if(matcherSingle.group(0).contains("in")){
                tokens.add(new Token(Type.INCH,matcherSingle.group(0)));
            }else if (matcherSingle.group(0).contains("pt")){
                tokens.add(new Token(Type.POINT,matcherSingle.group(0)));
            }else if(matcherSingle.group(0).contains("+")){
                tokens.add(new Token(Type.PLUS,matcherSingle.group(0)));
            }else if(matcherSingle.group(0).contains("-")){
                tokens.add(new Token(Type.MINUS,matcherSingle.group(0)));
            }else if(matcherSingle.group(0).contains("*")){
                tokens.add(new Token(Type.TIMES,matcherSingle.group(0)));
            }else if(matcherSingle.group(0).contains("/")){
                tokens.add(new Token(Type.DIVIDE,matcherSingle.group(0)));
            }else{
                tokens.add(new Token(Type.NUMBER,matcherSingle.group(0)));
            }
        }
        return tokens;
    }
}

class Parser {

    @SuppressWarnings("serial")
    static class ParserException extends RuntimeException {
    }

    /**
     * Type of values.
     */
    private enum ValueType {
        POINTS, INCHES, SCALAR
    };

    /**
     * Internal value is always in points.
     */
    public class Value {
        final double value;
        final ValueType type;

        Value(double value, ValueType type) {
            this.value = value;
            this.type = type;
        }

        @Override
        public String toString() {
            BigDecimal bd;
            switch (type) {
                case INCHES:
                    bd = new BigDecimal(value);
                    bd = bd.setScale(1, RoundingMode.HALF_UP);
                    if(value > 1.0){
                        BigDecimal svntwo = new BigDecimal(PT_PER_IN);
                        bd = bd.divide(svntwo,2,BigDecimal.ROUND_HALF_UP);}

                    return bd.doubleValue()+ " in";
                case POINTS:
                    if(lexer.tokenList.size() == 2){
                        return value + " pt";
                    }
                    bd = new BigDecimal(value);
                    bd = bd.setScale(1, RoundingMode.HALF_UP);
                    return bd.doubleValue() + " pt";
                default:
                    bd = new BigDecimal(value);
                    bd = bd.setScale(1, RoundingMode.HALF_UP);
                    return "" + bd.doubleValue();
            }
        }
    }

    private static final double PT_PER_IN = 72;
    private final Lexer lexer;

    // TODO write method spec
    public Parser(Lexer lex) {
        this.lexer = lex;
        for (int i = 0;i<lexer.tokenList.size();i++){
            System.out.println(lexer.tokenList.get(i).text);
        }
    }

    // TODO write method spec
    public Value evaluate() {
        double val = 0.0;
        ValueType unitType = ValueType.SCALAR;
        Iterator<Lexer.Token> itr = lexer.tokenList.iterator();
        while(itr.hasNext()){
            Lexer.Token ptr = itr.next();
            if(val == 0.0){
                if(ptr.type == Type.INCH){
                    val = Double.parseDouble(ptr.text.replace("in", ""))*PT_PER_IN;
                    if(unitType == ValueType.SCALAR)
                        unitType = ValueType.INCHES;
                }
                else if(ptr.type == Type.POINT){
                    val = Double.parseDouble(ptr.text.replace("pt",""));
                    if(unitType == ValueType.SCALAR)
                        unitType = ValueType.POINTS;
                }else{
                    val = Double.parseDouble(ptr.text);
                }
            }
            else if(ptr.type == Type.PLUS){
                Lexer.Token nextnum = itr.next();
                if(nextnum.type == Type.INCH){
                    if(unitType == ValueType.SCALAR){
                        unitType = ValueType.INCHES;
                    }
                    val += Double.parseDouble(nextnum.text.replace("in", ""))*PT_PER_IN;
                }
                else if (nextnum.type == Type.POINT){
                    if(unitType == ValueType.SCALAR){
                        unitType = ValueType.POINTS;
                    }
                    val += Double.parseDouble(nextnum.text.replace("pt",""));
                }else{
                    val += Double.parseDouble(nextnum.text);
                }
            }
            else if(ptr.type == Type.MINUS){
                Lexer.Token nextnum = itr.next();
                if(nextnum.type == Type.INCH){
                    if(unitType == ValueType.SCALAR){
                        unitType = ValueType.INCHES;
                    }
                    val -= Double.parseDouble(nextnum.text.replace("in", ""))*PT_PER_IN;
                }
                else if (nextnum.type == Type.POINT){
                    if(unitType == ValueType.SCALAR){
                        unitType = ValueType.POINTS;
                    }
                    val -= Double.parseDouble(nextnum.text.replace("pt",""));
                }else{
                    val -= Double.parseDouble(nextnum.text);
                }
            }
            else if(ptr.type == Type.TIMES){
                Lexer.Token nextnum = itr.next();
                if(nextnum.type == Type.INCH){
                    if(unitType == ValueType.INCHES ){
                        val *= Double.parseDouble(nextnum.text.replace("in", ""));
                    }else{
                        val *= Double.parseDouble(nextnum.text.replace("in", ""))*PT_PER_IN;}
                }
                else if (nextnum.type == Type.POINT){
                    if(unitType == ValueType.SCALAR){
                        unitType = ValueType.POINTS;
                        val *= Double.parseDouble(nextnum.text.replace("pt",""));
                    }else if(unitType == ValueType.INCHES){
                        val *= Double.parseDouble(nextnum.text.replace("pt", ""))/ 72;
                    }
                }else{
                    val *= Double.parseDouble(nextnum.text);
                }
            }
            else if(ptr.type == Type.DIVIDE){
                Lexer.Token nextnum = itr.next();
                if(nextnum.type == Type.INCH){
                    if(unitType == ValueType.INCHES || unitType == ValueType.POINTS){
                        unitType = ValueType.SCALAR;
                    }else{
                        unitType = ValueType.INCHES;
                    }
                    val /= Double.parseDouble(nextnum.text.replace("in", ""))*PT_PER_IN;
                }
                else if (nextnum.type == Type.POINT){
                    if(unitType == ValueType.INCHES || unitType == ValueType.POINTS){
                        unitType = ValueType.SCALAR;
                    }else{
                        unitType = ValueType.POINTS;
                    }
                    val /= Double.parseDouble(nextnum.text.replace("pt",""));
                }else{
                    val /= Double.parseDouble(nextnum.text);
                }
            }
            else if(ptr.type == Type.INCH){
                val *= PT_PER_IN;
                unitType = ValueType.INCHES;
            }
            else if(ptr.type == Type.POINT){
                unitType = ValueType.POINTS;
            }
        }
        return new Value(val,unitType);
    }
}

enum Type {
    L_PAREN,	// it means (
    R_PAREN,	// it means )
    NUMBER,		// 1, 2, 3, 4...
    INCH,
    POINT,
    PLUS,		// +
    MINUS,		// -
    TIMES,		// *
    DIVIDE		// /
}
////****

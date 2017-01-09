//package ProblemSet5;
///**
// * Created by Ilya on 14/11/16.
// */
//public class MultiUnit{
//    public String evaluate(String expression) {
//        Lexer lexer = new Lexer(expression);
//        Parser parser = new Parser(lexer);
//        return parser.evaluate().toString();
//    }
//}
//
//class Lexer{
//    public static class Token {
//        final Type type;
//        final String text;
//
//        Token(Type type, String text) {
//            this.type = type;
//            this.text = text;
//        }
//
//        Token(Type type) {
//            this(type, null);
//        }
//    }
//
//    @SuppressWarnings("serial")
//    static class TokenMismatchException extends Exception {
//    }
//
//    // TODO write method spec
//    public Lexer(String input) {
//       // Remove all empty spaces
//         input = input.replaceAll(" ","");
//        input.
//    }
//}
//
//class Parser{
//
//    @SuppressWarnings("serial")
//    static class ParserException extends RuntimeException {
//    }
//
//    /**
//     * Type of values.
//     */
//    private enum ValueType {
//        POINTS, INCHES, SCALAR
//    };
//
//    /**
//     * Internal value is always in points.
//     */
//    public class Value {
//        final double value;
//        final Parser.ValueType type;
//
//        Value(double value, Parser.ValueType type) {
//            this.value = value;
//            this.type = type;
//        }
//
//        @Override
//        public String toString() {
//            switch (type) {
//                case INCHES:
//                    return value / PT_PER_IN + " in";
//                case POINTS:
//                    return value + " pt";
//                default:
//                    return "" + value;
//            }
//        }
//    }
//
//    private static final double PT_PER_IN = 72;
//    private final Lexer lexer;
//
//    // TODO write method spec
//    Parser(Lexer lexer) {
//        // TODO implement for Problem
//    }
//
//    // TODO write method spec
//    public Parser.Value evaluate() {
//        // TODO implement for Problem
//    }
//}
//
//enum Type {
//    L_PAREN,	// it means (
//    R_PAREN,	// it means )
//    NUMBER,		// 1, 2, 3, 4...
//    INCH,
//    POINT,
//    PLUS,		// +
//    MINUS,		// -
//    TIMES,		// *
//    DIVIDE		// /
//}

package ProblemSet4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ilya on 19/10/16.
 */
public class WordMatchRecursive {
    public static void main(String[] args) {
        System.out.println(sentenceMatch("left","this stressful time on the twelfth felt strangely uneventful"));
    }

    public static String sentenceMatch(String in1, String in2){
        String word = in2.substring(0,in2.indexOf(" "));
        StringBuilder sb = new StringBuilder();
            if (wordMatch(in1,word)){
                sb.append(word);
                if(in2.length() == 0){
                    return sb.toString();
                }
        }
        return sentenceMatch(in1,in2.substring(in2.indexOf(" ")+1,in2.length()),sb);

    }
    // Overloaded method recursion
    public static String sentenceMatch(String in1, String in2, StringBuilder matching_words){
        if(in2.indexOf(" ") < 0){
            if (wordMatch(in1,in2)){
                matching_words.append(in2);
            }
            return matching_words.toString();
        }else{
            String word = in2.substring(0,in2.indexOf(" "));
            if (wordMatch(in1,word)){
                matching_words.append(word+",");

            }
        }
        return sentenceMatch(in1,in2.substring(in2.indexOf(" ")+1,in2.length()),matching_words);
    }
    public static boolean wordMatch(String in1, String in2) {
        for(char a:in1.toCharArray()){
            int x = in2.indexOf(a);
            if (in2.indexOf(a) <  0){
                return false;
            }
        }
        return true;
    }
}

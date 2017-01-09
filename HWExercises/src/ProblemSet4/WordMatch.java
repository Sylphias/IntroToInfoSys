package ProblemSet4;

/**
 * Created by Ilya on 19/10/16.
 */
public class WordMatch {
    public static void main(String[] args) {
        System.out.println(wordMatch("elf","whiteleaf"));
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

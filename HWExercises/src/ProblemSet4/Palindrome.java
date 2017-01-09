package ProblemSet4;

/**
 * Created by Ilya on 19/10/16.
 */
public class Palindrome {
    public static void main(String[] args) {
        char [] a  = {'a','b','b','a'};
        char [] b  = {'Z','Z','a','Z','Z'};
        char [] c  = {'1','2','3','4','3'};
        System.out.println(isPalindrome(a));
        System.out.println(isPalindrome(b));
        System.out.println(isPalindrome(c));
    }
    public static boolean isPalindrome (char[] S) {
        StringBuilder  sb = new StringBuilder();
        if(S.length == 1 || S.length == 0){
            return true;
        }
        else{
            if(S[0] == S[S.length-1]){
                sb.append(S);
                char [] x = new char[S.length-2];
                sb.getChars(1,S.length-1,x,0);
                return isPalindrome(x);
            }
            return false;
        }

    }
}

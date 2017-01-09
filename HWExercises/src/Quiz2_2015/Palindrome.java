package Quiz2_2015;

/**
 * Created by Ilya on 19/10/16.
 */
public class Palindrome {
    public static boolean recurPalindrome (String strSubmitted) {
        if(strSubmitted.length() == 1 || strSubmitted.length() == 0){
            return true;
        }else{
            if(strSubmitted.charAt(0) != strSubmitted.charAt(strSubmitted.length()-1)){
                return false;
            }
        }
        return recurPalindrome(strSubmitted.substring(1,strSubmitted.length()-1));
    }
}





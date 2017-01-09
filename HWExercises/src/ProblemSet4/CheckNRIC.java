package ProblemSet4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ilya on 19/10/16.
 */
public class CheckNRIC {
    public static void main(String[] args) {
        System.out.println(chkNRIC( "A3317213R 1963"));
        System.out.println(chkNRIC( "S7931123G 1979"));
        System.out.println(chkNRIC( "T2279982L 1999"));
        System.out.println(chkNRIC( "T1245336V 2012"));
    }

    public static String chkNRIC (String input) {
        String has_error;
        StringBuilder sb = new StringBuilder();
        String pattern = "(^[SF]+(\\d\\d).{6}\\s1\\d\\2$)|(^[TG]+(\\d\\d).{6}\\s20\\4$)";
        if(input.matches(pattern)){
            has_error = "No Error";
        }
        else{
            has_error = "Error";
        }
         return input + " - "+has_error;

    }



}

package ProblemSet4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ilya on 19/10/16.
 */
public class CheckSentence {
    public static void main(String[] args) {
        System.out.println(chkNumber("8698 9823"));
        System.out.println(chkNumber("+65 90013321"));
        System.out.println(chkNumber("88 62319001"));
        System.out.println(chkNumber("911"));
        System.out.println(chkNumber("+6590010331443"));
        System.out.println(chkNumber("001 65 6488 7771"));
        System.out.println(chkNumber("+656565 6565"));

    }
    public static String chkSentence(String input) {
        String pattern = "[,?-]s\\s|.*[,?-]$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        if (m.find()) {
            return "Found bad sentence: ";
        } else {
            return "Found good sentence: ";
        }
    }

    public static String chkNumber(String input) {
        String pattern = "\\A(\\+65)?(\\s)?([869]{1}[0-9]{3}[\\s]*[0-9]{4})$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        if (m.find()) {
            return "Found good phone number: ";
        } else {
            return "Found bad phone number: ";
        }

    }
}

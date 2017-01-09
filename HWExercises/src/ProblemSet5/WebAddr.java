package ProblemSet5;

/**
 * Created by Ilya on 14/11/16.
 */
////****
public class WebAddr{
    public static boolean webValidate (String input){
        return input.matches("^((https)|(http)|(ftp)):\\/\\/((www\\.)|(m\\.))*([a-zA-z0-9\\-\\_]{1,})(\\.com|\\.edu|\\.net)");
    }
}
////****

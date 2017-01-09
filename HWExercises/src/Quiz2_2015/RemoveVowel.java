package Quiz2_2015;

/**
 * Created by Ilya on 20/10/16.
 */
public class RemoveVowel {
    public static void main(String[] args) {
        System.out.println(RemoveVowel.recurRemoveVowel("It is said ..."));
        System.out.println(RemoveVowel.recurRemoveVowel(""));
        System.out.println(RemoveVowel.recurRemoveVowel("GCD"));
        System.out.println(RemoveVowel.recurRemoveVowel("Hello Java"));
    }

    public static String recurRemoveVowel(String s) {
        String pattern = "a|e|i|o|u|A|E|I|O|U";
        if(s.length() == 1){
            if(s.substring(0).matches(pattern)){
                return recurRemoveVowel(s.substring(1,s.length()));
            }
        }else if (s.length() == 0 ){
            return "";
        }
        if(s.substring(0,1).matches(pattern)){
            return recurRemoveVowel(s.substring(1,s.length()));
        }
        return s.substring(0,1) + recurRemoveVowel(s.substring(1,s.length()));
    }
}

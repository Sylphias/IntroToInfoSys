package Quiz2_2015;

/**
 * Created by Ilya on 19/10/16.
 */
public class CountVowel {

    public static void main(String[] args) {
        System.out.println(CountVowel.recurCountVowel("It is said ..."));
        System.out.println(CountVowel.recurCountVowel(""));
        System.out.println(CountVowel.recurCountVowel("GCD"));
        System.out.println(CountVowel.recurCountVowel("Hello Java"));
    }

    public static int recurCountVowel(String s){
        String pattern="a|e|i|o|u";
        if(s.length() == 1){
            if (s.substring(0).matches(pattern)) {
                return 1;
            }
            else{
                return 0;
            }
        }
        else if (s.length() == 0){
            return 0;
        }
        else{
            if(s.substring(0,1).matches(pattern)){
                return 1+recurCountVowel(s.substring(1));
            }
        }
        return recurCountVowel(s.substring(1));
    }


}

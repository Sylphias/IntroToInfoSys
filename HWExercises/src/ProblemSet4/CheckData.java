package ProblemSet4;

/**
 * Created by Ilya on 19/10/16.
 */
public class CheckData {
    public static void main(String[] args) {
        System.out.println(chkData("16:01:04 12-04-1995 SpO2"));
        System.out.println(chkData("23:56:55 11-13-2001 SpO3"));
        System.out.println(chkData("04:11:455 13-11-2001 HR"));
    }
    public static String chkData (String inp) {
        String pattern ="^(\\d{2}:\\d{2}:\\d{2})\\s(\\d{2}-\\d{2}-\\d{4})\\s(SpO2|Resp|HR|ABP)$";
        if(inp.matches(pattern)){
            return  "No Error";
        }else{
            return "Error";
        }
    }
}

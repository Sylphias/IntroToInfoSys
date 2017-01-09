package Quiz2_2015;

/**
 * Created by Ilya on 20/10/16.
 */
public class Combination {
    public static String recurCombination(String[][] data, String[] oneline, int group) {
        if (group > data.length - 1) {
            String rt = "";
            for (String s: oneline) {
                rt += s + " ";
            }
            return rt+"\n";
        } else {
            String rt = "";

            for (String s: data[group]) {
                oneline[group] = s;
                rt += recurCombination(data, oneline, group + 1);
            }

            return rt;
        }
    }
}

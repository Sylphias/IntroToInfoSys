package Extras;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilya on 17/11/16.
 */
public class ExhaustiveSEarch {
    public static void main(String[] args) {
        ArrayList<Integer> locations = new ArrayList<Integer>();
        locations.add(1);
        locations.add(2);
        locations.add(3);
        List<List<Integer>> test =  generatePerm(locations);

    }
    public static List<List<Integer>> generatePerm(List<Integer> original) {
        if (original.size() == 0) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            result.add(new ArrayList<Integer>());
            return result;
        }
        Integer firstElement = original.remove(0);
        List<List<Integer>> returnValue = new ArrayList<List<Integer>>();
        List<List<Integer>> permutations = generatePerm(original);
        for (List<Integer> smallerPermutated : permutations) {
            for (int index=0; index <= smallerPermutated.size(); index++) {
                List<Integer> temp = new ArrayList<Integer>(smallerPermutated);
                temp.add(index, firstElement);
                returnValue.add(temp);
            }
        }
        return returnValue;
    }

}

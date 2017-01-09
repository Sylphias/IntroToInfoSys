package Extras;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ilya on 23/11/16.
 */
public class TestStronglyConnected {
    public static void main (String[] args){
//            Here nodecount is the number of nodes (vertices) in the graph,
//            linkcount is the number of links (edges), and each pair of Integer x,
//            y in listOfLink is a directed edge from x to y.  For example,
//            the above graph can be represented and passed to the method as follows:
        int nodecount= 6;
        int linkcount=7;
        ArrayList<Integer> listOfLink = new ArrayList<Integer> ( Arrays.asList(0,1, 1,2,  2,3 , 3,0 , 2,4, 4,1, 4,5 ));
        System.out.println(StronglyConnected.isStronglyConnected(nodecount, linkcount, listOfLink));
//        int nodecounts=5;
//        int linkcounts=5;
//        ArrayList<Integer> listOfLinks = new ArrayList<Integer> ( Arrays.asList(0,1,  1,2,  2,3,  3,4,  4,0));
//        System.out.println(StronglyConnected.isStronglyConnected(nodecounts, linkcounts, listOfLinks));

    }
}

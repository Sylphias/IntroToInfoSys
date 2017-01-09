package Extras;

import java.util.*;

/**
 * Created by Ilya on 23/11/16.
 */
public class StronglyConnected {
    // Use a stack implementation, add the node in when it appears as a destination and pop it when we arrive at it again
    public static boolean isStronglyConnected(int nodecount, int linkcount,ArrayList<Integer> listOfLink) {
        Stack<Integer> stacker = new Stack<Integer>();
        stacker.push(listOfLink.get(0));
        if(linkcount ==0 && stacker.size() == 0){
            return true;
        }else if (linkcount !=0 ) {
            if (stacker.contains(listOfLink.get(0))) {
                while (listOfLink.get(0) != stacker.peek() && !stacker.empty()) {
                    stacker.pop();
                }
            } else {
                stacker.push(listOfLink.get(0));
            }
            listOfLink.remove(0);
            listOfLink.remove(0);
            return isStronglyConnected(nodecount, linkcount - 1, listOfLink,stacker);
            }
        return  false;
    }
    public static boolean isStronglyConnected(int nodecount, int linkcount,ArrayList<Integer> listOfLink, Stack<Integer> visited) {
        if (linkcount == 0 && visited.size() == 0) {
            return true;
        } else if (linkcount != 0 && listOfLink.size() >= 2) {
            if (visited.contains(listOfLink.get(1)) && listOfLink.size() >= 3) {
                while ( visited.size() != 0 && listOfLink.get(2) != visited.peek()) {
                    visited.pop();
                }
            }else if(visited.contains(listOfLink.get(1))){
                while ( visited.size() != 0 ) {
                    visited.pop();
                }
            }
            else {
                visited.push(listOfLink.get(1));
            }
            listOfLink.remove(0);
            listOfLink.remove(0);
            return isStronglyConnected(nodecount, linkcount - 1, listOfLink, visited);

        }
        return false;


    }

    }

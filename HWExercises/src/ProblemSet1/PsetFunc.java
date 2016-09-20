package ProblemSet1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ilya on 18/9/16.
 */
public class PsetFunc {
    public static void main(String[] args){
        MyRectangle2D r = new MyRectangle2D(2,2,6,6);
        MyRectangle2D r1 = new MyRectangle2D(4,4,6,6);
        MyRectangle2D r2 = new MyRectangle2D(4,4,6,6);
        System.out.println(r.getHeight());
        System.out.println(r.getWidth());
        System.out.println(r.contains(3,3));
        System.out.println(r.overlaps(r2));
        System.out.println(r.contains(r1));
    }

    public static int calYearOfBirth(int yearCurrent, int age) {
        return yearCurrent - age;
    }

    public static String printNums() {
        StringBuilder sb = new StringBuilder();
        for (int x=1; x<129; x*=2){
            sb.append(x);
            if(x!=128){
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public static int isPrime(int num){
        // Refer to wikipedia's test on primality
        for (int i=0 ; i<(num/2); i++){
            if (num==(6*i+1) || num == (6*i-1)){
                return 1;
            }
        }
        return 0;
    }
    public static int Counter(int n) {
        int counter = 0;
        while (n!=1){
            if (n%2 == 0){
                n /= 2;
            }
            else{
                n = 3*n +1;
            }
            counter++;
        }
        return counter;
    }
    public static int[] bubbleSort(int[] inarray){
        for(int i = 0; i< inarray.length ; i++){
            for(int j = i+1; j < inarray.length ; j++){
                if (inarray[i]> inarray[j]){
                    int holder = inarray[i];
                    inarray[i] = inarray[j];
                    inarray[j] = holder;
                }
            }
        }
        return inarray;

    }
    public static List<String> listTrim(List<String> strings) {
        for(int i = 0 ; i < strings.size(); i ++){
             strings.set(i,strings.get(i).trim());
        }
        return strings;
    }

}


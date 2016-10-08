package ProblemSet4;

/**
 * Created by Ilya on 6/10/16.
 */
import java.util.*;
public class CatchingExceptionsv6 {

    public static void main(String[] args) throws Throwable {
        try {
            method1();
            System.out.println("Statement1");
        }
        catch (NullPointerException ex) {
            System.out.println(ex);
        }
        finally  {

        }

        System.out.println("Statement2");
    }
    public static void method1() throws Exception {
        try {
            method2();
            System.out.println("Statement3");
        }
        catch(NullPointerException ex1){
            System.out.println(ex1);
        }
        System.out.println("Statement4");
    }
    public static void method2() throws Exception {
        try {
            method3();
            System.out.println("Statement5");
        }
        catch(NullPointerException ex2){
            System.out.println(ex2);
        }
        System.out.println("Statement6");
    }
    public static void method3() throws Exception {
        throw new IllegalArgumentException("Info from method2");
    }

}


package ProblemSet4;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

/**
 * Created by Ilya on 4/10/16.
 */
public class ModularProgram {
    public int ModIntegers(){
        System.out.println("Welcome to the modulus computer");
        int output = 0;
        int x =0;
        int y =0;
        String n = "y";
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        while(n.equals("y")){
            try {
                System.out.println("Enter two integer values: ");
                x = reader.nextInt();
                y = reader.nextInt();
                try{
                    output = x%y;
                }
                catch(Exception e){
                    System.out.println("Sorry, cannot compute mod by 0");
                }
            }
            catch (Exception e){
                reader.next();
                System.out.println("Sorry, you must enter two integer values");
            }
            System.out.println("Do another pair of values ? (y)");
            n = reader.next();
        }
        return output;
    }

}

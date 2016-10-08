package ProblemSet4;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.*;
/**
 * Created by Ilya on 6/10/16.
 */
public class Scheduler2 {

    public static void main(String[] args) throws InvalidTimeException{
        System.out.println("Welcome to the Appointment Scheduler");
        System.out.println("You can schedule an appointment at 1 or 2 pm.");

        Scanner reader = new Scanner(System.in);

        String appointments[] = new String[3];
        int appointmentsMade = 0;
        while(appointments[1]==null || appointments[2]==null){
            System.out.println("What is your name?");
            String name = reader.next();
            System.out.println("What time would you like the appointment?");
            int x = reader.nextInt();
            try {
                if(x != 1 && x!=2){
                    throw new InvalidTimeException("Sorry, that is not a legal time");
                }
                try{
                    if(appointments[x]!=null){
                        throw new TimeInUseException("Sorry, that time is already in use");
                    }
                    appointments[x] = name;
                }catch(TimeInUseException tiue){
                    System.out.println(tiue);
                }
            }catch(InvalidTimeException ite){
                System.out.println(ite);
            }

        }
        System.out.println("All appointments made");
        System.out.println("At 1 pm:" + appointments[1]);
        System.out.println("At 2 pm:" + appointments[2]);


    }

    public static class InvalidTimeException extends Exception{
        public InvalidTimeException(String message){
            super(message);
        }
    }
    public static class TimeInUseException extends Exception{
        public TimeInUseException(String message){
            super(message);
        }

    }

}

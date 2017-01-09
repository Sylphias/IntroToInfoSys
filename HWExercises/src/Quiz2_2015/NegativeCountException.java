package Quiz2_2015;

import com.sun.org.apache.xpath.internal.operations.Neg;

/**
 * Created by Ilya on 19/10/16.
 */


public class NegativeCountException extends Exception {
    private int count=0;
    public NegativeCountException() {
        super();
    }

    public NegativeCountException(String message) {
        super(message);
    }

    public void addPerson(){
        ++this.count;
    }

    public void removePerson() throws NegativeCountException{
        if(count == 0){
            throw new NegativeCountException("Cannot Remove a person");
        }else{
            --this.count;
        }
    }

    public int getCount(){
        return this.count;
    }

}

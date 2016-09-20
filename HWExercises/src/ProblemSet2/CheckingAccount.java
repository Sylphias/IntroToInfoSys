package ProblemSet2;
import ProblemSet1.Account;
/**
 * Created by Ilya on 19/9/16.
 */
public class CheckingAccount extends Account{

    public CheckingAccount() {
        super();
    }

    public CheckingAccount(int id, double balance) {
        super(id, balance);
    }

    public void withdraw(double amount){
        if ((getBalance()-amount) >= -5000){
            this.setBalance(getBalance() - amount);
        }
        else{
            System.out.println("over limit");
        }
    }
}

/**
 * Created by Ilya on 18/9/16.
 */
package ProblemSet1;
public class tester {
    public static void main(String[]args){
        Account account = new Account(1122, 20000);
        account.setAnnualInterestRate(4.5);
        account.withdraw(2500);
        account.deposit(3000);
        System.out.println("Balance is " + account.getBalance()); System.out.println("Monthly interest is " + account.getMonthlyInterest());

    }
}

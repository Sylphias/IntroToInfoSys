/**
 * Created by Ilya on 18/9/16.
 */
package ProblemSet1;

import java.util.Date;

public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;

//  Constructors
    public Account(){
        this.id = 0;
        this.balance = 0.0;
        this.annualInterestRate = 0.0;
        this.dateCreated = new Date();
    }
    public Account(int id, double balance){
        this.id = id;
        this.balance = balance;
    }

//  Getters
    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    //  Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate/100.0;
    }

    // Class Methods
    public double getMonthlyInterestRate(){
        return this.annualInterestRate/12.0;
    }

    public double getMonthlyInterest(){
        return balance*(this.annualInterestRate/12.0);
    }
    public void withdraw(double amount){
        this.balance -= amount;
    }
    public double deposit(double amount){
        this.balance += amount;
        return balance;
    }
}

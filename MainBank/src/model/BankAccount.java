
package model;
import java.io.Serializable;

public class BankAccount implements Account, Serializable {
    
    public BankAccount(){};
    
      private double balance=0;
      private Owner owner;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public void deposit(double amount) {
        this.setBalance(this.getBalance()+amount);
        
    }

    @Override
    public void withdraw(double amount) {
      this.setBalance(this.getBalance()-amount);
    }
    
    
    private double interest;

    public double getInterest() {
        return interest;
    }

    public void setInterest(double amount) {};

    public double addInterest(double balance, double deposit) {        
        return interest;
    }
  }


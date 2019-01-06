
package model;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Exceptions.InvalidAmountException;

public class BankAccount implements Account, Serializable {
    
    public BankAccount(){};
    
      private float balance=0;
      private Owner owner;

    public float getBalance() {
        return balance;
    }

<<<<<<< HEAD
    public void setBalance(float balance) {        
        
        this.balance = balance;
=======
    public void setBalance(float balance) throws InvalidAmountException{        
        if (balance <0){
             throw new InvalidAmountException();
        }
        else this.balance = balance;
>>>>>>> volk
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public void deposit(float amount) {
<<<<<<< HEAD
       
            this.setBalance(this.getBalance()+amount);
        
=======
        try {
            this.setBalance(this.getBalance()+amount);
        } catch (InvalidAmountException ex) {
            Logger.getLogger(BankAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
>>>>>>> volk
        
    }

    @Override
    public void withdraw(float amount) {
<<<<<<< HEAD
       
            this.setBalance(this.getBalance()-amount);
       
=======
        try {
            this.setBalance(this.getBalance()-amount);
        } catch (InvalidAmountException ex) {
            Logger.getLogger(BankAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
>>>>>>> volk
    }
    
    
    private double interest;

    public double getInterest() {
        return interest;
    }

    public void setInterest(float amount) {};

    public double addInterest(float balance, float deposit) {        
        return interest;
    }
  }


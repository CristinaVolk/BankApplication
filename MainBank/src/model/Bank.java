package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Bank implements Serializable {
     
    ArrayList <BankAccount> accounts;
    
    public ArrayList <BankAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList <BankAccount> accounts) {
        this.accounts = accounts;
    }
    
    public BankAccount AddAccount(BankAccount bA){
        for (BankAccount bankA : this.getAccounts()){
            if (bA.getOwner().getFirstName().equals(bankA.getOwner().getFirstName())){             
                bA=null;
            }           
        }  
        this.getAccounts().add(bA);
        return bA;
    }
}

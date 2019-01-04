package model;

import java.io.Serializable;
import java.util.ArrayList;
import model.Exceptions.AccNotFoundException;

public class Bank implements Serializable {
     
    ArrayList <BankAccount> accounts;
    
    public ArrayList <BankAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList <BankAccount> accounts) {
        this.accounts = accounts;
    }
    
    public void AddAccount(BankAccount bA){
            if(this.getAccounts().contains(bA)){
                System.out.println("The bank account has already existed!\n");
            }
            else {
                   this.getAccounts().add(bA);
            }
    }
}


package controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;
import model.Exceptions.InvalidAmountException;
import model.Exceptions.InsufficientFundsException;
import view.Menu;

public class BusinessLogic {
    private IOBank disc;    
    private Bank bank=null;
    
   public BusinessLogic(){
        this.disc = new IOBank();
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }



    public IOBank getDisc() {
        return disc;
    }

    public void setDisc(IOBank disc) {
        this.disc = disc;
    }
    
    public BankAccount newAccount (BankAccount bankAcc){
        System.out.println("Epta! adding new account");
        Bank banK = this.getBank();
        if (banK.getAccounts()==null){   
           
            ArrayList bankAccList = new ArrayList();            
            banK.setAccounts(bankAccList);
        }                  
     
            this.getBank().AddAccount(bankAcc);
            return bankAcc;
    }
    
    public void removeAccount(BankAccount bankAcc){
        this.getBank().getAccounts().remove(bankAcc);
    }
    
    public void makeDeposit(double amount, BankAccount account) throws InvalidAmountException{
        if (amount<0){
            throw new InvalidAmountException();            
        }
        account.deposit(amount);
    }
    
    public void withdraw (double amount, BankAccount account) throws InsufficientFundsException{
        if (amount > account.getBalance()){
            throw new InsufficientFundsException();            
        }
        account.withdraw(amount);
    }
    
    public void saveOnDisk( String filename, Bank bank) throws FileNotFoundException, IOException{
        try {
            try (FileOutputStream fOut = new FileOutputStream(filename)) {
                ObjectOutputStream objOut = new ObjectOutputStream(fOut);
                this.getDisc().save(objOut, (Object)bank);
            }
        }
        catch (FileNotFoundException ex){
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex){
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    
    public void saveOnDisk( String filename, BankAccount bankAccount) throws FileNotFoundException, IOException{
        try {           
            if (this.getBank().getAccounts()!=null){
                if (!(this.getBank().getAccounts().contains(bankAccount))){
                this.getBank().getAccounts().add(bankAccount);
               }
            }             
            else {
                ArrayList accounts = new ArrayList();
                this.getBank().setAccounts(accounts);
                this.getBank().getAccounts().add(bankAccount);       
            }            
                FileOutputStream fOut = new FileOutputStream(filename);
                ObjectOutputStream objOut = new ObjectOutputStream(fOut);
                this.getDisc().save(objOut, (Object)this.getBank());
            
        }          
             catch (FileNotFoundException ex){
                 Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
             catch (IOException ex){
                 Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
     public Bank readFromDisk (File file) throws FileNotFoundException, IOException, ClassNotFoundException{
                  Object bankObject=null;
                   try {
                       
                    FileInputStream fIn = new FileInputStream(file);
                    ObjectInputStream objIn = new ObjectInputStream(fIn);
                    bankObject = this.getDisc().read(objIn);
                    if (bankObject instanceof Bank){
                        if (this.getBank().getAccounts()==null){
                            this.getBank().setAccounts(((Bank)bankObject).getAccounts());
                             }
                        else  {
                           for (BankAccount bAc : ((Bank)bankObject).getAccounts()){  
                                 if(!this.getBank().getAccounts().contains(bAc)){                                   
                                 this.getBank().getAccounts().add(bAc);
                               }
                         }
                      }
                   }
                   
                   else if (bankObject instanceof BankAccount){
                       if (this.getBank().getAccounts()==null){
                           ArrayList accounts = new ArrayList();
                           this.getBank().setAccounts(accounts);
                           this.getBank().getAccounts().add((BankAccount)bankObject);
                       }
                       else if(!this.getBank().getAccounts().contains(bankObject)){
                            this.getBank().getAccounts().add((BankAccount)bankObject);
                       }
                   }                    
                    
                    fIn.close();
                }
                   
                     catch (IOException | ClassNotFoundException ex){
                            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                          }
       
                  return this.getBank();
     }
     

     

     
}
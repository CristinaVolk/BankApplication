
package controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.*;
import model.Exceptions.BankException;
import model.Exceptions.InvalidAmountException;
import model.Exceptions.InsufficientFundsException;

public class BusinessLogic {
    private IOBank disc;    
    private Bank bank=null;
    
   public BusinessLogic(){
        this.disc = new IOBank();
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) throws BankException {
        if (bank == null){
            throw new BankException();
        }
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
     
            BankAccount bankAc = this.getBank().AddAccount(bankAcc);
            return bankAc;
    }
    
    public void removeAccount(BankAccount bankAcc){
        this.getBank().getAccounts().remove(bankAcc);
    }
    
    public void makeDeposit(float amount, BankAccount account) throws InvalidAmountException{
        if (amount<0){
<<<<<<< HEAD
            throw new InvalidAmountException();  
=======
            InvalidAmountException inVal = new InvalidAmountException();  
>>>>>>> volk
        }
        account.deposit(amount);
    }
    
    public void withdraw (float amount, BankAccount account) throws InsufficientFundsException{
        if (amount > account.getBalance()){
            throw new InsufficientFundsException();            
        }
        account.withdraw(amount);
    }
    
    public void saveOnDisk( String filename, Bank bank) throws FileNotFoundException, IOException{
       
                FileOutputStream fOut = new FileOutputStream(filename);
                ObjectOutputStream objOut = new ObjectOutputStream(fOut);
                this.getDisc().save(objOut, (Object)bank);
    }
    
    public void saveOnDisk( String filename, BankAccount bankAccount) throws FileNotFoundException, IOException{
                   
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
    
     public Bank readFromDisk (File file) throws FileNotFoundException, IOException, ClassNotFoundException{
                  Object bankObject=null;
                       
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
                   
       
                  return this.getBank();
     }
     

     

     
}

package controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.*;
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
        System.out.println("Epta!");
        Bank banK = this.getBank();
        if (banK.getAccounts()==null){   
           
            ArrayList <BankAccount> bankAccList = new ArrayList <>();            
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
        
          FileOutputStream fOut = new FileOutputStream(filename);
          ObjectOutputStream objOut = new ObjectOutputStream(fOut);
          this.getDisc().save(objOut, bank);
          fOut.close();
    }
    
    public void saveOnDisk( String filename, BankAccount bankAccount) throws FileNotFoundException, IOException{
        FileOutputStream fOut = new FileOutputStream(filename);
          ObjectOutputStream objOut = new ObjectOutputStream(fOut);
          this.getDisc().save(objOut, bankAccount);
          fOut.close();
    }
    
     public Bank readFromDisk (File file) throws FileNotFoundException, IOException, ClassNotFoundException{
                   
                    FileInputStream fIn = new FileInputStream(file);
                    ObjectInputStream objIn = new ObjectInputStream(fIn);
                    Bank bankObject = this.getDisc().read(objIn);
                    if (bankObject!=null){
                    if (this.getBank().getAccounts()==null){
                        this.getBank().setAccounts(bankObject.getAccounts());
                    }
                    else  {
                    for (BankAccount bAc : bankObject.getAccounts()){             
                       this.getBank().getAccounts().add(bAc);
                     }
                    }
                    }
                    
                    fIn.close();
               return bankObject;     
        }
}

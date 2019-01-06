
import view.Menu;
import controller.*;
import model.*;
import model.Exceptions.BankException;

public class MainBank {

   
    public static void main(String[] args) {
        
        Bank mainBank = new Bank();  
        BusinessLogic BLcontroller = new BusinessLogic();
        Menu menu = new Menu();
        
        menu.setBisLogic(BLcontroller); 
        try {
            BLcontroller.setBank(mainBank); 
        menu.setBank(mainBank);
        }
        catch (BankException ex){
            System.out.println(ex);
        }
        
        
    }
  }
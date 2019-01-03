
import view.Menu;
import controller.*;
import model.*;

public class MainBank {

   
    public static void main(String[] args) {
        
        Bank mainBank = new Bank();  
        BusinessLogic BLcontroller = new BusinessLogic();
        Menu menu = new Menu();
        
        menu.setBisLogic(BLcontroller);      
        BLcontroller.setBank(mainBank); 
        menu.setBank(mainBank);
        
        
    }
  }
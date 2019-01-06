
package model.Exceptions;

import javax.swing.JOptionPane;


public class InsufficientFundsException extends Exception {
    public InsufficientFundsException() {      
        System.out.println("You have insufficient funds to complete the transaction.");       
            
    }
   
}

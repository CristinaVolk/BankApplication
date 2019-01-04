
package model.Exceptions;


public class InsufficientFundsException extends Exception {
    public InsufficientFundsException() {       
    } 

    public InsufficientFundsException(String msg) {
         super("You have insufficient funds to complete the transaction.");
    }

   
}

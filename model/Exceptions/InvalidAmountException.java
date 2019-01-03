
package model.Exceptions;


public class InvalidAmountException extends Exception {
    public InvalidAmountException() {       
    } 

    public InvalidAmountException(String msg) {
        super("Invalid amount for transaction");
    }

   
}

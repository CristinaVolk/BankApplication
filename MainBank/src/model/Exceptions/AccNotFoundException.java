
package model.Exceptions;

public class AccNotFoundException extends Exception {

    public AccNotFoundException() {
        System.out.println("Account has already existed");
    }
}


package model;

import java.io.Serializable;

public class Owner implements Serializable {
    
    private String firstName;
    private String lastName;

    public Owner(){
    }
    
    @Override
    public String toString(){
        return "\nCustomer Information\n" +
                "First Name: " + getFirstName() + "\n" + 
                "Last Name: " + getLastName();
               
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    
}

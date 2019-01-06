
package model;

import java.io.Serializable;

public class Owner implements Serializable {
    
    private String firstName;
    private String lastName;

    public Owner(){
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


package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import model.Bank;
import model.BankAccount;



public class IOBank {
    
        public void save (ObjectOutputStream objOut, Object objectToSave) throws  IOException{
            
                objOut.writeObject(objectToSave);
                System.out.println("DDAAAVAAAAI");
                objOut.close();
                
        }
        
        public Object read(ObjectInputStream objIn) throws  ClassNotFoundException, IOException{
                  
                    Object dataFromFile = objIn.readObject();
                    if (dataFromFile!=null ){ 
                        System.out.println("DDAAAVAAAAI xxxx");
                    }
                    else {                    
                        System.out.println("pusto w file xxx");
                    } 
                    objIn.close(); 
                    return dataFromFile;
    }
}

  
  
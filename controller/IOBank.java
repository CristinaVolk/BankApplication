
package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import model.Bank;



public class IOBank {
    
        public void save (ObjectOutputStream objOut, Object objectToSave) throws FileNotFoundException, IOException{
           
              
                objOut.writeObject(objectToSave);
                System.out.println("DDAAAVAAAAI");
                objOut.close();
                
        }
        
        public Bank read(ObjectInputStream objIn) throws FileNotFoundException, IOException, ClassNotFoundException{
                   Bank bankFromFile=null;
                    Object bankData = objIn.readObject();
                    if ( bankData!=null && bankData instanceof Bank){
                        bankFromFile = (Bank)bankData; 
                        System.out.println("DDAAAVAAAAI xxxx");
                    }
                    else {
                    
                        System.out.println("pusto w file xxx");
                    } ;
                    objIn.close();
               return bankFromFile;     
        }
    }

  
  
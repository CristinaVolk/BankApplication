package model;


public class SavingAccount extends BankAccount implements Saving {
     public SavingAccount(){
         super();
     }
    private double interest;

    @Override
    public double getInterest() {
        return interest;
    }

    @Override
    public void setInterest(float amount) {
        double initialInterest = 0;
        if (amount > 10000) {
            initialInterest = 0.05;
        } else {
            initialInterest = 0.02;
        }
        this.interest =initialInterest;
    }
  


    @Override
    public double addInterest(float balance, float amount) {
        
        double addedInterest=0;
        if (balance + amount > 10000){
            addedInterest = 0.05;
        }
        else {
            addedInterest = 0.02;
        }
        return addedInterest; 
    }
}

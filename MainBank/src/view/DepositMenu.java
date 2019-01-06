
package view;

import controller.BusinessLogic;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.BankAccount;
import model.Exceptions.InvalidAmountException;
import model.SavingAccount;
import model.Saving;

public class DepositMenu extends javax.swing.JDialog {
    private BusinessLogic bisLogic;
    private BankAccount bankAcc;

    public DepositMenu(java.awt.Frame parent, boolean modal, BusinessLogic bisLogic, BankAccount bankAcc) {
        super(parent, modal);
        setLocationRelativeTo(parent);
        initComponents();
        this.bisLogic = bisLogic;
        this.bankAcc= bankAcc;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        amountLabel = new javax.swing.JLabel();
        amountField = new javax.swing.JTextField();
        depositButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Deposit Menu");
        getContentPane().setLayout(new java.awt.GridLayout(2, 2, 1, 1));

        amountLabel.setText("Deposit Amount");
        getContentPane().add(amountLabel);

        amountField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountFieldActionPerformed(evt);
            }
        });
        getContentPane().add(amountField);

        depositButton.setText("Deposit");
        depositButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositButtonActionPerformed(evt);
            }
        });
        getContentPane().add(depositButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void amountFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountFieldActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
       this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void depositButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositButtonActionPerformed
        //verify deposit is not empty
        if (amountField.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Deposit amount is required", "Input error", JOptionPane.WARNING_MESSAGE);
        }
        else {
            float deposit=0;
            int result=0;
            //verify if it's a positive number
            try{
                deposit = Float.parseFloat(amountField.getText());
                
                if (bankAcc instanceof SavingAccount){
                  
                result = JOptionPane.showConfirmDialog(this, "Deposit $" + String.format("%.2f", deposit)
                        + " to the account?\nInterest Earned: $" +
                        String.format("%.2f", (bankAcc.addInterest(bankAcc.getBalance(),deposit) * deposit)));
                bisLogic.makeDeposit(deposit, bankAcc);
                }                
                
                if(result == JOptionPane.OK_OPTION){
                    result = JOptionPane.showConfirmDialog(this, "Deposit $" + String.format("%.2f", deposit)
                        + " to the account?\n");
                bisLogic.makeDeposit(deposit, bankAcc);
                this.dispose();
             }
            }
             catch (NumberFormatException ex){
                 JOptionPane.showMessageDialog(this, "Deposit must be a nubmer", "Input error", JOptionPane.WARNING_MESSAGE);
             } catch (InvalidAmountException ex) {  
                Logger.getLogger(DepositMenu.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Deposit must be positive", "Input error", JOptionPane.WARNING_MESSAGE);
            }  
        }
    }//GEN-LAST:event_depositButtonActionPerformed


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountField;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton depositButton;
    // End of variables declaration//GEN-END:variables
}


package view;

import controller.BusinessLogic;
import javax.swing.JOptionPane;
import model.BankAccount;
import model.Exceptions.InsufficientFundsException;

public class WithdrawalMenu extends javax.swing.JDialog {
    private final BusinessLogic bisLogic;
    private final BankAccount bankAcc;

    public WithdrawalMenu(java.awt.Frame parent, boolean modal, BusinessLogic bisLogic, BankAccount bankAcc) {
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
        withdrawalButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Deposit Menu");
        getContentPane().setLayout(new java.awt.GridLayout(2, 2, 1, 1));

        amountLabel.setText("Withdrawal Amount");
        getContentPane().add(amountLabel);

        amountField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountFieldActionPerformed(evt);
            }
        });
        getContentPane().add(amountField);

        withdrawalButton.setText("Withdraw");
        withdrawalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawalButtonActionPerformed(evt);
            }
        });
        getContentPane().add(withdrawalButton);

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

    private void withdrawalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawalButtonActionPerformed
        //verify deposit is not empty
        if (amountField.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Withdrawal amount is required", "Input error", JOptionPane.WARNING_MESSAGE);
        }
        else {
            float amount=0;
            //verify if it's a positive number
            try{
                amount = Float.parseFloat(amountField.getText());
                int result  = JOptionPane.showConfirmDialog(this, "Withdraw $"+ amount+" from the account?");
                if(result == JOptionPane.OK_OPTION){
                bisLogic.withdraw(amount, bankAcc);
                this.dispose();
             }
            }
             catch (NumberFormatException ex){
                 JOptionPane.showMessageDialog(this, "Withdrawal must be a nubmer", "Input error", JOptionPane.WARNING_MESSAGE);
             } catch (InsufficientFundsException ex) {      
                JOptionPane.showMessageDialog(this, "Withdrawal is invalid","Withdrawal warnings", JOptionPane.WARNING_MESSAGE);
            }      
        }
    }//GEN-LAST:event_withdrawalButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountField;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton withdrawalButton;
    // End of variables declaration//GEN-END:variables
}

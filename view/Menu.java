
package view;

import controller.BusinessLogic;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Bank;
import model.BankAccount;

public class Menu extends javax.swing.JFrame {
    
    private Bank bank;
    
    private BusinessLogic bisLogic;
    DefaultTableModel model;

    public BusinessLogic getBisLogic() {
        return bisLogic;
    }

    public void setBisLogic(BusinessLogic bisLogic) {
        this.bisLogic = bisLogic;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
    
    public Menu() {
        initComponents();
        setSize(600,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);      
       // this.bank = new Bank();
        model = (DefaultTableModel) accountTable.getModel();
        //reloadTable();
    }     
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();
        addAccount = new javax.swing.JButton();
        deposit = new javax.swing.JButton();
        withdraw = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        accountTable = new javax.swing.JTable();
        MainMenu = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        SaveAccountMenuItem = new javax.swing.JMenuItem();
        saveAllMenuItem = new javax.swing.JMenuItem();
        ExitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bank Application");

        addAccount.setText("Add an Account");
        addAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAccountActionPerformed(evt);
            }
        });

        deposit.setText("Make a Deposit");
        deposit.setEnabled(false);
        deposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositActionPerformed(evt);
            }
        });

        withdraw.setText("Withdraw money");
        withdraw.setEnabled(false);
        withdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawActionPerformed(evt);
            }
        });

        removeButton.setText("Remove Account");
        removeButton.setEnabled(false);
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        accountTable.setAutoCreateRowSorter(true);
        accountTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name", "Last Name", "Balance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        accountTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        accountTable.getTableHeader().setReorderingAllowed(false);
        accountTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accountTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(accountTable);
        if (accountTable.getColumnModel().getColumnCount() > 0) {
            accountTable.getColumnModel().getColumn(0).setResizable(false);
            accountTable.getColumnModel().getColumn(1).setResizable(false);
            accountTable.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(addAccount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deposit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(withdraw)
                        .addGap(14, 14, 14)
                        .addComponent(removeButton)
                        .addGap(4, 4, 4)))
                .addContainerGap())
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addAccount)
                        .addComponent(deposit)
                        .addComponent(withdraw))
                    .addComponent(removeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fileMenu.setText("File");

        openMenuItem.setText("Open");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        SaveAccountMenuItem.setText("Save Account");
        SaveAccountMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveAccountMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(SaveAccountMenuItem);

        saveAllMenuItem.setText("Save All");
        saveAllMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAllMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveAllMenuItem);

        ExitMenuItem.setText("Exit");
        ExitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(ExitMenuItem);

        MainMenu.add(fileMenu);

        editMenu.setText("Edit");
        MainMenu.add(editMenu);

        setJMenuBar(MainMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAccountActionPerformed
        
          AddAccountMenu menu = new AddAccountMenu(this, true, getBisLogic());
        menu.setVisible(true);
    
        if(menu.getBankAcc()!=null){
        addAccountToTable(menu.getBankAcc());
        } 
        
    }//GEN-LAST:event_addAccountActionPerformed

    private void depositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositActionPerformed
              int selectedRow = accountTable.getSelectedRow(); 
          System.out.println(selectedRow);
          BankAccount bankAcc = bank.getAccounts().get(selectedRow);
        
        if ( bankAcc != null){
            DepositMenu menu = new DepositMenu(this, true, getBisLogic(), bankAcc);
            menu.setVisible(true);
            reloadCustomerRowData(selectedRow, bankAcc);
        }
    }//GEN-LAST:event_depositActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
       
       
        int selectedRow = accountTable.getSelectedRow(); 
        if (selectedRow >= 0){
            if(this.getBank()==null){
                System.out.println("AAA");
            }             
        BankAccount bankAcc = this.getBank().getAccounts().get(selectedRow);
        if (bankAcc != null){
           int result = JOptionPane.showConfirmDialog(this, "Are you sure to remove your account?");
           if(result == JOptionPane.OK_OPTION){
        getBisLogic().removeAccount(bankAcc);
        removeAccountFromTheTable(selectedRow);
          }
        }
       }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void withdrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawActionPerformed
        int selectedRow = accountTable.getSelectedRow(); 
        BankAccount bankAcc = this.getBank().getAccounts().get(selectedRow);
        if ( bankAcc != null){
            WithdrawalMenu menu = new WithdrawalMenu(this, true, getBisLogic(), bankAcc);
            menu.setVisible(true);
            reloadCustomerRowData(selectedRow, bankAcc);
        }
    }//GEN-LAST:event_withdrawActionPerformed

    private void accountTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountTableMouseClicked
        // TODO add your handling code here:
        setAccountButtonsActive(true);
    }//GEN-LAST:event_accountTableMouseClicked

    private void saveAllMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAllMenuItemActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showSaveDialog(this);
        if(result == JFileChooser.APPROVE_OPTION){
            File file= chooser.getSelectedFile();
            String fileName = file.toString();
            if(!fileName.toLowerCase().endsWith(".bof")){
                fileName +=".bof";
            }
          
            try {
                //this.setBank(bisLogic.readFromDisk(file));
                bisLogic.saveOnDisk(fileName, this.getBank());
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("DDAAAVAAAAI ZA ZHIZN");
           
        }
    }//GEN-LAST:event_saveAllMenuItemActionPerformed

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
       
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION){
            File file= chooser.getSelectedFile();
            String fileName = file.toString();
            if(!fileName.toLowerCase().endsWith(".bof")){                
                JOptionPane.showMessageDialog(this, "Unsupported type of file selected","Unsupported file", JOptionPane.ERROR_MESSAGE);
                
            }
            else {
                
                try {
                   
                   Bank bankObject = bisLogic.readFromDisk(file);
                   if(bankObject != null){
                    reloadTable(bankObject);
                   }
                    
                } catch (IOException ex) {
                    Logger.getLogger(GraphicalInterface.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(GraphicalInterface.class.getName()).log(Level.SEVERE, null, ex);
                }     
            }
        }
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void ExitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitMenuItemActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_ExitMenuItemActionPerformed

    private void SaveAccountMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveAccountMenuItemActionPerformed
             
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showSaveDialog(this);
        if(result == JFileChooser.APPROVE_OPTION){
            File file= chooser.getSelectedFile();
            String fileName = file.toString();
            if(!fileName.toLowerCase().endsWith(".bof")){
                fileName +=".bof";
            }
          
            try {
                    int selectedRow = accountTable.getSelectedRow(); 
                    BankAccount bankAcc = this.getBank().getAccounts().get(selectedRow);
                    if ( bankAcc != null){
                        bisLogic.saveOnDisk(fileName, bankAcc);
                        System.out.println("DDAAAVAAAAI ZA ZHIZN");
                    }
                
            } catch (IOException ex) {
                Logger.getLogger(GraphicalInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
    }//GEN-LAST:event_SaveAccountMenuItemActionPerformed

    
        private void reloadCustomerRowData(int selectedRow, BankAccount bankAcc) {
            
        model = (DefaultTableModel)accountTable.getModel();
        model.setValueAt(bankAcc.getOwner().getFirstName(), selectedRow, 0);
        model.setValueAt(bankAcc.getOwner().getLastName(), selectedRow, 1);
        model.setValueAt(String.format("%.2f", bankAcc.getBalance()), selectedRow, 2);
    }
        
        private void reloadTable(Bank bankData) {
            
                     boolean exist = false;
                        DefaultTableModel model = (DefaultTableModel) accountTable.getModel();
                        int size = model.getRowCount();
                        System.out.println(size);
                        if(!bankData.getAccounts().isEmpty()){
                        for(BankAccount bA : bankData.getAccounts()){
                   
                           for ( int i=0; i<size; i++){
                            exist = false;
                            System.out.println(bA.getOwner().getFirstName()+" name from file");
                            System.out.println(model.getValueAt(i, 0)+" name from table");
                            String name  = bA.getOwner().getFirstName();
                            String NAME = model.getValueAt(i, 0).toString();
                             if(name.equals(NAME)){
                               exist=true;  
                               System.out.println("bla bla");
                               break;
                          }
                        }
                        
            if(exist == false){
            addAccountToTable(bA);
     }
    }
   }
 }
    

        private void setAccountButtonsActive(boolean active) { 
            deposit.setEnabled(active);
            withdraw.setEnabled(active);
            removeButton.setEnabled(active);
            
        }
                
       private void addAccountToTable(BankAccount bankAcc) {
        model = (DefaultTableModel) accountTable.getModel();
        model.addRow(new Object[]{});
        reloadCustomerRowData(model.getRowCount()-1, bankAcc);
    }

       
       public void removeAccountFromTheTable(int row){
           model = (DefaultTableModel) accountTable.getModel();
           model.removeRow(row);
           JOptionPane.showMessageDialog(this, "Successfully removed!" );
       }
       


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ExitMenuItem;
    private javax.swing.JMenuBar MainMenu;
    private javax.swing.JMenuItem SaveAccountMenuItem;
    private javax.swing.JTable accountTable;
    private javax.swing.JButton addAccount;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton deposit;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JButton removeButton;
    private javax.swing.JMenuItem saveAllMenuItem;
    private javax.swing.JButton withdraw;
    // End of variables declaration//GEN-END:variables

 

    

    }

 




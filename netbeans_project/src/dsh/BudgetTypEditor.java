/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BudgetTypEditor.java
 *
 * Created on Jan 4, 2013, 12:03:22 PM
 */
package dsh;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author maak
 */
public class BudgetTypEditor extends javax.swing.JFrame {
        private DefaultTableModel myBTtable;
        private int colContainingID=0;
        private Model myModel;
        private BudgetTyp myBudgetTyp;

    /** Creates new form BudgetTypEditor */
    public BudgetTypEditor() {
        initComponents();
        initBudgetTypEditor ();
    }
    
    public void initBudgetTypEditor (){
        myModel=DshApp.getModel();
        myBudgetTyp = new BudgetTyp ();
        refreshBTtable();
        loadBTintoEditor();
    }
    
    private void refreshBTtable () {
        myBTtable=myModel.getTableBudgetTyp();
        if (myBTtable!=null) {
            tableExistingBudgetTypen.setModel(myBTtable);
            tableExistingBudgetTypen.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            TableModelHelper.packColumns(tableExistingBudgetTypen);
        } else {
            JOptionPane.showMessageDialog(this, "Tabelle Ausgabe-Typ konnte NICHT geladen werden!");
        }
    }
    
    private void loadBTintoEditor (){
        if (myBudgetTyp.getId()==-1 || myBudgetTyp.isBudgetTypSuccesfullyLoaded()) {
            textFieldBudgetTypName.setText(myBudgetTyp.getBTname());
        } else {
            JOptionPane.showMessageDialog(this, "Ausgabe-Typ konnte NICHT geladen werden!");
        }       
    }
    
    private String errorOnFillingEntriesIntoBT () {
        String entriesValidationError = "";
        if (textFieldBudgetTypName.getText().equals("")) entriesValidationError="Bezeichnerfeld ist leer.";
        return entriesValidationError;
    }
    private boolean succesfullySavedDataToDB () {
        String fieldsErrorCode = errorOnFillingEntriesIntoBT(); // Einträge valide?
        if (fieldsErrorCode.equals("")) { 
            myBudgetTyp.setBTname(textFieldBudgetTypName.getText());
            return myBudgetTyp.successfullySavedToDB(); // Budget Objekt kümmert sich ums speichern
        } else {
           JOptionPane.showMessageDialog(this, fieldsErrorCode+": Bitte überprüfen Sie Ihre Eingabe.");
           System.out.println ("** Eingabefehler: "+fieldsErrorCode);
        }
        return false;
    } 

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableExistingBudgetTypen = new javax.swing.JTable();
        buttonEdit = new javax.swing.JButton();
        buttonLoeschen = new javax.swing.JButton();
        textFieldBudgetTypName = new javax.swing.JTextField();
        buttonSpeichern = new javax.swing.JButton();
        buttonSchliessen = new javax.swing.JButton();
        buttonNeu = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N

        jPanel1.setName("jPanel1"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(dsh.DshApp.class).getContext().getResourceMap(BudgetTypEditor.class);
        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        tableExistingBudgetTypen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableExistingBudgetTypen.setName("tableExistingBudgetTypen"); // NOI18N
        jScrollPane2.setViewportView(tableExistingBudgetTypen);

        buttonEdit.setText(resourceMap.getString("buttonEdit.text")); // NOI18N
        buttonEdit.setName("buttonEdit"); // NOI18N
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
            }
        });

        buttonLoeschen.setText(resourceMap.getString("buttonLoeschen.text")); // NOI18N
        buttonLoeschen.setName("buttonLoeschen"); // NOI18N
        buttonLoeschen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoeschenActionPerformed(evt);
            }
        });

        textFieldBudgetTypName.setText(resourceMap.getString("textFieldBudgetTypName.text")); // NOI18N
        textFieldBudgetTypName.setName("textFieldBudgetTypName"); // NOI18N

        buttonSpeichern.setText(resourceMap.getString("buttonSpeichern.text")); // NOI18N
        buttonSpeichern.setName("buttonSpeichern"); // NOI18N
        buttonSpeichern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSpeichernActionPerformed(evt);
            }
        });

        buttonSchliessen.setText(resourceMap.getString("buttonSchliessen.text")); // NOI18N
        buttonSchliessen.setName("buttonSchliessen"); // NOI18N
        buttonSchliessen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSchliessenActionPerformed(evt);
            }
        });

        buttonNeu.setText(resourceMap.getString("buttonNeu.text")); // NOI18N
        buttonNeu.setName("buttonNeu"); // NOI18N
        buttonNeu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNeuActionPerformed(evt);
            }
        });

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(textFieldBudgetTypName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(20, 20, 20)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(jLabel1)
                                .add(18, 18, 18)
                                .add(buttonSchliessen, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 104, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(buttonEdit)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(buttonLoeschen)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 64, Short.MAX_VALUE)
                                .add(buttonNeu))
                            .add(jScrollPane2, 0, 0, Short.MAX_VALUE)))
                    .add(buttonSpeichern, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 94, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel5)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(buttonSchliessen))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 115, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(buttonEdit)
                    .add(buttonLoeschen)
                    .add(buttonNeu))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jLabel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(6, 6, 6)
                .add(textFieldBudgetTypName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(9, 9, 9)
                .add(buttonSpeichern)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
        if (DshApp.getApplication().isTheTopWindow(this)) {
            if (tableExistingBudgetTypen.getSelectedRow()!=-1) {
                if (myBudgetTyp.getId()>0) myBudgetTyp.disposeMe();
                myBudgetTyp = new BudgetTyp (
                         ((java.lang.Integer) tableExistingBudgetTypen.getValueAt(
                                tableExistingBudgetTypen.getSelectedRow(),
                                colContainingID)
                         ).intValue()
                        );
            }
            loadBTintoEditor();            
        }
    }//GEN-LAST:event_buttonEditActionPerformed

    private void buttonSchliessenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSchliessenActionPerformed
        if (DshApp.getApplication().isTheTopWindow(this)) {
            if (myBudgetTyp.getId()>0) myBudgetTyp.disposeMe();
            DshApp.getApplication().endBudgetTypEditor();            
        }
    }//GEN-LAST:event_buttonSchliessenActionPerformed

    private void buttonLoeschenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoeschenActionPerformed
        if (DshApp.getApplication().isTheTopWindow(this) && DshApp.getApplication().userAccordOnDeleteWarning(this)) {
            if (tableExistingBudgetTypen.getSelectedRow()!=-1) {
                int selectedForDelete =((java.lang.Integer)
                        tableExistingBudgetTypen.getValueAt(
                            tableExistingBudgetTypen.getSelectedRow(),
                            colContainingID)
                        ).intValue();
                if (selectedForDelete==myBudgetTyp.getId()) {
                    // if to-be-deleted BT is the loaded one..
                    myBudgetTyp.deleteBT();
                    initBudgetTypEditor();
                } else {
                    BudgetTyp.deleteBT(selectedForDelete);
                    refreshBTtable ();
                }

            }            
        }
    }//GEN-LAST:event_buttonLoeschenActionPerformed

    private void buttonNeuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNeuActionPerformed
        if (DshApp.getApplication().isTheTopWindow(this)) {
            if (myBudgetTyp.getId()>0) myBudgetTyp.disposeMe();
            myBudgetTyp = new BudgetTyp ();
            loadBTintoEditor ();            
        }        
    }//GEN-LAST:event_buttonNeuActionPerformed

    private void buttonSpeichernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSpeichernActionPerformed
        if (DshApp.getApplication().isTheTopWindow(this)) {
            if (!succesfullySavedDataToDB()) JOptionPane.showMessageDialog(this, "Ausgabe-Typ konnte NICHT gespeichert werden!");
            refreshBTtable ();            
        }
    }//GEN-LAST:event_buttonSpeichernActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BudgetTypEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BudgetTypEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BudgetTypEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BudgetTypEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new BudgetTypEditor().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonLoeschen;
    private javax.swing.JButton buttonNeu;
    private javax.swing.JButton buttonSchliessen;
    private javax.swing.JButton buttonSpeichern;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableExistingBudgetTypen;
    private javax.swing.JTextField textFieldBudgetTypName;
    // End of variables declaration//GEN-END:variables
}

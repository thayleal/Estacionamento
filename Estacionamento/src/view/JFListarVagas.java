/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;


import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.dao.VagaDAO;
import model.bean.Vaga;
/**
 *
 * @author Thyane
 */
public class JFListarVagas extends javax.swing.JFrame {

    private void JBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {
        if(jTVaga.getSelectedRow() != -1){
            int vagaSelecionada = (int)jTVaga.getValueAt(jTVaga.getSelectedRow(), 0);
            JFatualizarVaga av = new JFatualizarVaga(vagaSelecionada);
            av.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Selecionar uma vaga!", "Erro",JOptionPane.ERROR_MESSAGE);
        }
        readJTable();
    }
    /**
     * Creates new form JFListarVagas
     */
    public JFListarVagas() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTVaga = new javax.swing.JTable();
        JBtnCadastrar = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Microsoft Tai Le", 3, 24)); // NOI18N
        jLabel1.setText("Listar Vagas");

        jTVaga.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID da Vaga", "Número", "Rua", "Oblíqua"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTVaga);

        JBtnCadastrar.setText("Cadastrar Vaga");

        jBtnAlterar.setText("Editar Vaga");

        jBtnExcluir.setText("Excluir Vaga");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JBtnCadastrar)
                                .addGap(95, 95, 95)
                                .addComponent(jBtnAlterar)
                                .addGap(46, 46, 46)
                                .addComponent(jBtnExcluir)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBtnCadastrar)
                    .addComponent(jBtnAlterar)
                    .addComponent(jBtnExcluir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        // TODO add your handling code here:
         if(jTVaga.getSelectedRow() != -1){
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja Excluir a vaga selecionada?", "Exclusão", JOptionPane.YES_NO_OPTION);
            if(opcao == 0){
                VagaDAO dao = new VagaDAO();
                Vaga v = new Vaga();
                
                v.setIdVaga((int)jTVaga.getValueAt(jTVaga.getSelectedRow(), 0));
                dao.delete(v);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma vaga!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        readJTable();
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        readJTable();// TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened
    
    
    private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt){
        
    }
    
    public void readJTable(){
        DefaultTableModel modelo = (DefaultTableModel) jTVaga.getModel();
        modelo.setNumRows(0);
        VagaDAO dao = new VagaDAO();
        for(Vaga v: dao.read()){
            modelo.addRow(new Object[]{
            v.getIdVaga(),
            v.getNumero(),
            v.getRua(),
            v.isObliqua()
        });
        }
     
    }
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
            java.util.logging.Logger.getLogger(JFListarVagas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFListarVagas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFListarVagas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFListarVagas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFListarVagas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBtnCadastrar;
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTVaga;
    // End of variables declaration//GEN-END:variables
}

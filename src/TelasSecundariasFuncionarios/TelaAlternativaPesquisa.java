/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelasSecundariasFuncionarios;

import TelasSecundariasJogos.TelaTabelaJogo;
import codigo.Funcionario;
import codigo.Jogo;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rafaela
 */
public class TelaAlternativaPesquisa extends javax.swing.JFrame {

    /**
     * Creates new form TelaAlternativaPesquisa
     */
    public TelaAlternativaPesquisa() {
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

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        btipoPesquisa = new javax.swing.JComboBox<>();
        jtextoPesquisa = new java.awt.TextField();
        bCancelar = new javax.swing.JButton();
        bPesquisa1 = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisa por Nome ou CPF", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        btipoPesquisa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btipoPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Nome", "CPF" }));
        btipoPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btipoPesquisaActionPerformed(evt);
            }
        });

        jtextoPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtextoPesquisaActionPerformed(evt);
            }
        });

        bCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        bPesquisa1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bPesquisa1.setText("Pesquisar");
        bPesquisa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPesquisa1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jtextoPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(bPesquisa1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtextoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bPesquisa1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtextoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtextoPesquisaActionPerformed

        jtextoPesquisa.setText("");

        // TODO add your handling code here:
    }//GEN-LAST:event_jtextoPesquisaActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed

        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bPesquisa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPesquisa1ActionPerformed

        String tipo = btipoPesquisa.getSelectedItem().toString();
        String chave = jtextoPesquisa.getText();
        
        System.out.println(tipo);
        System.out.println(chave);
        
        ArrayList <Funcionario> arrayFunc = new ArrayList <> ();
        
        int aux = 0;

        String nome = "";
        String CPF = "";
        String sexo = "";
        String dataNasc = "";
        String email = "";
        String celular = "";
        String complemento = "";
        String dataAdm = "";
        String cartTrabalho = "";

        String cidade = "";
        String bairro = "";
        String rua = "";
        String numero = "";
        String estado = "";

        String username = "";
        String senha = "*****";
        
        ArrayList <Funcionario> vetFunc = new ArrayList <> ();

        switch (tipo) {
            
            case "Nome" :
                
                 try {
                    FileInputStream fileinput = new FileInputStream("dadosFuncionario.txt");
                    ObjectInputStream input = new ObjectInputStream(fileinput);
                    
                    vetFunc = (ArrayList<Funcionario>) input.readObject();
                    
                    TabelaExibirFuncionarios tabela = new TabelaExibirFuncionarios();
                    DefaultTableModel envia = (DefaultTableModel) tabela.getTabelaFunc().getModel();
                    
                    for (Funcionario f : vetFunc) {
                       if (f.getNome().equals(chave)) {
                           arrayFunc.add(f);
                       }
                       
                    }
                       for (int i = 0 ; i<arrayFunc.size(); i++) {
                           Object[] fun = {
                               arrayFunc.get(i).getNome(),
                               arrayFunc.get(i).getCPF(), 
                               arrayFunc.get(i).getSexo(),
                               arrayFunc.get(i).getCartTrabalho(),
                               arrayFunc.get(i).getEmail(),
                               arrayFunc.get(i).getCelular()};
   
                                envia.addRow(fun);

                             
                           }
                       
                    tabela.setVisible(true);
                    input.close();
                    
                        } catch (IOException ex) {
            Logger.getLogger(TelaAlternativaPesquisa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaAlternativaPesquisa.class.getName()).log(Level.SEVERE, null, ex);
        }
                 
                       break;
                       
            case  "CPF" :
                    
            
            try {
                    FileInputStream fileinput = new FileInputStream("dadosFuncionario.txt");
              
                    ObjectInputStream input = new ObjectInputStream(fileinput);
                    
                    vetFunc = (ArrayList<Funcionario>) input.readObject();
                    
                    for (Funcionario f : vetFunc) {
                       if (f.getCPF().equals(chave)) {
                           TelaProcurarAtualizarFuncionario pesquisa = new TelaProcurarAtualizarFuncionario(chave);
                           pesquisa.pesquisa(chave);
                           pesquisa.setVisible(true);
                       }
                       
                    }
                
                    
                    /**
                    TabelaExibirFuncionarios tabela = new TabelaExibirFuncionarios();
                    DefaultTableModel envia = (DefaultTableModel) tabela.getTabelaFunc().getModel();
                    
                       for (int i = 0 ; i<arrayFunc.size(); i++) {
                           Object[] fun = {
                            
                               arrayFunc.get(i).getNome(),
                               arrayFunc.get(i).getCPF(), 
                               arrayFunc.get(i).getSexo(),
                               arrayFunc.get(i).getCartTrabalho(),
                               arrayFunc.get(i).getEmail(),
                               arrayFunc.get(i).getCelular()};
   
                                envia.addRow(fun);

                             
                           }
                     
                   
                    tabela.setVisible(true);
                    */
                    input.close();
                    
                    break;
                    
             } catch (IOException ex) {
            Logger.getLogger(TelaAlternativaPesquisa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaAlternativaPesquisa.class.getName()).log(Level.SEVERE, null, ex);
        }
                           
                        
              
            default :
                break;
                   
             
        }
            
        // TODO add your handling code here:
    }//GEN-LAST:event_bPesquisa1ActionPerformed

    private void btipoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btipoPesquisaActionPerformed



// TODO add your handling code here:
    }//GEN-LAST:event_btipoPesquisaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaAlternativaPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAlternativaPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAlternativaPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAlternativaPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAlternativaPesquisa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bPesquisa1;
    private javax.swing.JComboBox<String> btipoPesquisa;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JPanel jPanel1;
    private java.awt.TextField jtextoPesquisa;
    // End of variables declaration//GEN-END:variables
}

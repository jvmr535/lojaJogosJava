package TelasSecundariasJogos;

import codigo.Jogo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author joaov
 */
public class TelaAtualizaJogo extends javax.swing.JFrame {

    ArrayList<Jogo> vetJogos = new ArrayList<>();
    File arq = new File("dadosJogo.txt");
    //String procura;
    
    public TelaAtualizaJogo() {
        initComponents();
    }
    
    public void excluiAtualiza(){
        int aux = 0;
        
        String nomeJ = nomeJogo.getText();
        int posicao =0;
        
        try {
            if (!arq.exists()) {
                if (arq.createNewFile()) {
                    //System.out.println("O arquivo foi criado");
                } 
                else {
                    //System.out.println("O arquivo não foi criado");
                }
            } 
        }
        catch (IOException ex) {
            Logger.getLogger(TelaAtualizaJogo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            FileInputStream file = new FileInputStream(arq);
            ObjectInputStream input = new ObjectInputStream(file);
            
            ArrayList<Jogo> procuraJogo = new ArrayList<>();
            procuraJogo = (ArrayList) input.readObject();
            
            for (Jogo j : procuraJogo) {
                if (j.getNome().equals(nomeJ)) {
                    posicao = procuraJogo.indexOf(j);
                    
                    aux = 1;
                }
            }
            input.close();
            if (aux == 1) { 
                procuraJogo.remove(posicao);
                
                FileOutputStream stream = new FileOutputStream("dadosJogo.txt");
                ObjectOutputStream output = new ObjectOutputStream(stream);
                output.writeObject(procuraJogo);
                output.flush();
                output.close();
                                
                    TelaAtualizaJogo2 telaAtualizaJogo2 = new TelaAtualizaJogo2();
                    telaAtualizaJogo2.setVisible(true);
                
            }
            else{
                JOptionPane.showMessageDialog(null, "O jogo procurado não existe!");
            }
            
        } 
        catch (FileNotFoundException e1) {
            Logger.getLogger(TelaAtualizaJogo.class.getName()).log(Level.SEVERE, null, e1);
        }
        catch(IOException e2){
        }
        catch(ClassNotFoundException e3){
        }
    }
    
    public void atualiza(){
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        nomeJogo = new javax.swing.JTextField();
        procuraJogo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atualizar Jogo");
        setResizable(false);

        jLabel7.setText("Nome do Jogo:");

        nomeJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeJogoActionPerformed(evt);
            }
        });

        procuraJogo.setText("Procurar");
        procuraJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procuraJogoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(procuraJogo)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeJogo, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(procuraJogo))
                .addGap(22, 22, 22))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nomeJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeJogoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeJogoActionPerformed

    private void procuraJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procuraJogoActionPerformed
        excluiAtualiza();
        this.dispose();
    }//GEN-LAST:event_procuraJogoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaAtualizaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAtualizaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAtualizaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAtualizaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAtualizaJogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField nomeJogo;
    private javax.swing.JButton procuraJogo;
    // End of variables declaration//GEN-END:variables
}

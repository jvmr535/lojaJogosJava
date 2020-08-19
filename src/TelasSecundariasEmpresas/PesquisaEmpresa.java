/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelasSecundariasEmpresas;

import codigo.Empresa;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Thiago Vital
 */
public class PesquisaEmpresa extends javax.swing.JFrame {

    /**
     * Creates new form PesquisaEmpresa
     */
    public PesquisaEmpresa() {
        initComponents();
    }

    /**
     *
     * @param tipo rebcebe com base em qual categoria será feita a pesquisa
     * @param info recebe a String que o usuário digitou
     */
    public void pesquisaEmpresa(String tipo, String info) {

        int aux = 0;

        String nome = "";
        String email = "";
        String cnpj = "";
        String razaoSocial = "";
        String rua = "";
        String numero = "";
        String bairro = "";
        String cidade = "";
        String estado = "";
        String pais = "";
        String descricao = "";
        String data = "";
        String site = "";

        String categoria = tipo;
        String compara = info;

        ArrayList<Empresa> vetEmpresa = new ArrayList<>();
        ArrayList<Empresa> empresaEncontrada = new ArrayList<>();

        try {
            FileInputStream fips = new FileInputStream("dadosEmpresa.txt");
            ObjectInputStream obj = new ObjectInputStream(fips);
            vetEmpresa = (ArrayList<Empresa>) obj.readObject();
            if (categoria.equals("NOME")) {//se a categoria escolhida foi nome
                for (Empresa a : vetEmpresa) {
                    if (a.getNome().equals(compara)) {//se procura pelo nome
                        nome = a.getNome();
                        email = a.getEmail();
                        cnpj = a.getCnpj();
                        razaoSocial = a.getRazaoSocial();
                        rua = a.getRua();
                        numero = a.getNumero();
                        bairro = a.getBairro();
                        cidade = a.getCidade();
                        estado = a.getEstado();
                        pais = a.getPais();
                        descricao = a.getDescricao();
                        data = a.getData();
                        site = a.getSite();
                        //aux=1, houve sucesso na busca
                        aux = 1;
                        break;
                    }

                }
            }
            if (categoria.equals("RAZÃO SOCIAL")) {//se a categoria escolhida foi razão social
                for (Empresa a : vetEmpresa) {
                    if (a.getRazaoSocial().equals(compara)) {//se procura pela razão social
                        nome = a.getNome();
                        email = a.getEmail();
                        cnpj = a.getCnpj();
                        razaoSocial = a.getRazaoSocial();
                        rua = a.getRua();
                        numero = a.getNumero();
                        bairro = a.getBairro();
                        cidade = a.getCidade();
                        estado = a.getEstado();
                        pais = a.getPais();
                        descricao = a.getDescricao();
                        data = a.getData();
                        site = a.getSite();
                        //aux=1, houve sucesso na busca
                        aux = 1;
                        break;
                    }

                }
            }
            //IMPLEMENTAR BUSCA PARA CNPJ
            //IMPLEMENTAR BUSCA PARA CNPJ
            //IMPLEMENTAR BUSCA PARA CNPJ
            //IMPLEMENTAR BUSCA PARA CNPJ
            //IMPLEMENTAR BUSCA PARA CNPJ
            //IMPLEMENTAR BUSCA PARA CNPJ
            if(categoria.equals("CNPJ"))
                for (Empresa a : vetEmpresa) {
                    if (a.getCnpj().equals(compara)) {//se procura pela razão social
                        nome = a.getNome();
                        email = a.getEmail();
                        cnpj = a.getCnpj();
                        razaoSocial = a.getRazaoSocial();
                        rua = a.getRua();
                        numero = a.getNumero();
                        bairro = a.getBairro();
                        cidade = a.getCidade();
                        estado = a.getEstado();
                        pais = a.getPais();
                        descricao = a.getDescricao();
                        data = a.getData();
                        site = a.getSite();
                        //aux=1, houve sucesso na busca
                        aux = 1;
                        break;
                    }

                }
            if (aux == 1) {
                this.setVisible(true);
                nomedaEmpresa.setEnabled(false);
                emailEmpresa.setEnabled(false);
                cnpjEmpresa.setEnabled(false);
                razaoSocialEmpresa.setEnabled(false);
                ruaEmpresa.setEnabled(false);
                numeroEmpresa.setEnabled(false);
                bairroEmpresa.setEnabled(false);
                cidadeEmpresa.setEnabled(false);
                estadoEmpresa.setEnabled(false);
                paisEmpresa.setEnabled(false);
                descricaoEmpresa.setEnabled(false);
                dataEmpresa.setEnabled(false);
                siteEmpresa.setEnabled(false);

                nomedaEmpresa.setText(nome);
                emailEmpresa.setText(email);
                cnpjEmpresa.setText(cnpj);
                razaoSocialEmpresa.setText(razaoSocial);
                ruaEmpresa.setText(rua);
                numeroEmpresa.setText(numero);
                bairroEmpresa.setText(bairro);
                cidadeEmpresa.setText(cidade);
                estadoEmpresa.setText(estado);
                paisEmpresa.setText(pais);
                descricaoEmpresa.setText(descricao);
                dataEmpresa.setText(data);
                siteEmpresa.setText(site);

            } else {
                JOptionPane.showMessageDialog(null, "A empresa não foi encontrada!");
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a manipulação do arquivo de dados");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a manipulação do arquivo de dados");
        } catch (ClassNotFoundException ex) {
        }
    }

    /**
     * This method is called from within the constructor to initializ e the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        cidadeEmpresa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        razaoSocialEmpresa = new javax.swing.JTextField();
        nomedaEmpresa = new javax.swing.JTextField();
        emailEmpresa = new javax.swing.JTextField();
        ruaEmpresa = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        numeroEmpresa = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        bairroEmpresa = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        estadoEmpresa = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        paisEmpresa = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        descricaoEmpresa = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        dataEmpresa = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        siteEmpresa = new javax.swing.JTextField();
        cnpjEmpresa = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel5.setText("Razão Social:");

        cidadeEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cidadeEmpresaActionPerformed(evt);
            }
        });

        jLabel6.setText("Rua");

        emailEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailEmpresaActionPerformed(evt);
            }
        });

        jLabel7.setText("Cidade:");

        numeroEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeroEmpresaActionPerformed(evt);
            }
        });

        jLabel8.setText("Número:");

        jLabel2.setText("Nome:");

        jLabel3.setText("E-Mail:");

        jLabel4.setText("CNPJ:");

        jLabel9.setText("Bairro:");

        bairroEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bairroEmpresaActionPerformed(evt);
            }
        });

        jLabel10.setText("Estado:");

        estadoEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadoEmpresaActionPerformed(evt);
            }
        });

        jLabel11.setText("País:");

        jLabel12.setText("Descrição:");

        jLabel13.setText("Data:");

        dataEmpresa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("##/##/####"))));
        dataEmpresa.setText("  /  /    ");
        dataEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataEmpresaActionPerformed(evt);
            }
        });

        jLabel14.setText("Site:");

        try {
            cnpjEmpresa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cnpjEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnpjEmpresaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(razaoSocialEmpresa)
                    .addComponent(nomedaEmpresa)
                    .addComponent(emailEmpresa)
                    .addComponent(ruaEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(numeroEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9))
                            .addComponent(cidadeEmpresa))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bairroEmpresa)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(estadoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(paisEmpresa)
                    .addComponent(descricaoEmpresa)
                    .addComponent(siteEmpresa)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cnpjEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dataEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nomedaEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(emailEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cnpjEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(razaoSocialEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ruaEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(bairroEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(cidadeEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(estadoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(paisEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(descricaoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(dataEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(siteEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cidadeEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cidadeEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cidadeEmpresaActionPerformed

    private void emailEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailEmpresaActionPerformed

    private void numeroEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeroEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numeroEmpresaActionPerformed

    private void bairroEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bairroEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bairroEmpresaActionPerformed

    private void estadoEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estadoEmpresaActionPerformed

    private void dataEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dataEmpresaActionPerformed

    private void cnpjEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnpjEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cnpjEmpresaActionPerformed

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
            java.util.logging.Logger.getLogger(PesquisaEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisaEmpresa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bairroEmpresa;
    private javax.swing.JTextField cidadeEmpresa;
    private javax.swing.JFormattedTextField cnpjEmpresa;
    private javax.swing.JFormattedTextField dataEmpresa;
    private javax.swing.JTextField descricaoEmpresa;
    private javax.swing.JTextField emailEmpresa;
    private javax.swing.JTextField estadoEmpresa;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField nomedaEmpresa;
    private javax.swing.JTextField numeroEmpresa;
    private javax.swing.JTextField paisEmpresa;
    private javax.swing.JTextField razaoSocialEmpresa;
    private javax.swing.JTextField ruaEmpresa;
    private javax.swing.JTextField siteEmpresa;
    // End of variables declaration//GEN-END:variables
}

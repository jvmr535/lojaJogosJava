/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelasSecundariasJogos;

import TelasSecundariasFuncionarios.TelaCadastroFuncionario;
import codigo.Cliente;
import codigo.Empresa;
import codigo.Jogo;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author joaov
 */
public class TelaCadastroJogo extends javax.swing.JFrame {

    ArrayList<Jogo> vetJogo = new ArrayList<>();
    // File arq = new File ("dadosJogo.txt");

    public TelaCadastroJogo() {
        initComponents();

    }

    public void cadastrarJogo() {
        if (jComboBoxEmpresa.getSelectedItem().toString().equals("SELECIONE")) {

            TelaRedirecionarCadastroEmpresa tela = new TelaRedirecionarCadastroEmpresa();
            tela.setVisible(true);

        } else {
            ArrayList<Jogo> vetJogos = new ArrayList<>();
            File arq = new File("dadosJogo.txt");
            String nome = cadastroNome.getText();
            String censura = (String) cadastroCensura.getSelectedItem();
            String categoria = (String) cadastroCategoria.getSelectedItem();
            String desenvolvedora = jComboBoxEmpresa.getSelectedItem().toString();
            String descricao = cadastroBDescricao.getText();
            String quantidade = cadastroQuantidade.getText();
            String preco = cadastroPreco.getText();
            String estoque = cadastroQuantidade.getText();
            String tipo = (String) cadastroTipo.getSelectedItem();

            try {

                if (!arq.exists()) {

                    if (arq.createNewFile()) {
                        System.out.println("O arquivo foi criado");
                    } else {
                        System.out.println("O arquivo não foi criado");
                    }

                }
                try {
                    FileInputStream fileinput = new FileInputStream(arq);
                    ObjectInputStream input = new ObjectInputStream(fileinput);
                    //SALVO NO ARRAY O ARQUIVO ORIGINAL
                    vetJogos = (ArrayList<Jogo>) input.readObject();
                    input.close();
                } catch (EOFException e) {

                }
                int verificador = 0;
                for (int i = 0; i < vetJogos.size(); i++) {
                    if (vetJogos.get(i).getNome().equals(nome)) {
                        verificador = 1;
                    }
                }
                if (verificador == 1) {
                    JOptionPane.showMessageDialog(null, "O jogo já está cadastrado no sistema!");
                } else {
                    vetJogos.add(new Jogo(nome, censura, categoria, desenvolvedora, descricao, quantidade, preco, estoque, tipo));
                    JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
                }

                FileOutputStream fo = new FileOutputStream(arq);
                ObjectOutputStream escreve;
                escreve = new ObjectOutputStream(fo);
                escreve.writeObject(vetJogos);
                escreve.flush();
                escreve.close();
                System.out.println("**CADASTRADO COM SUCESSO!**");

                System.out.println(vetJogos.toString());

            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                System.err.println("CLASSE NÃO ENCONTRADA");
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cadastroNome = new javax.swing.JTextField();
        cadastroBDescricao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cadastroQuantidade = new javax.swing.JTextField();
        cadastroPreco = new javax.swing.JTextField();
        cadastroCategoria = new javax.swing.JComboBox<>();
        cadastroCensura = new javax.swing.JComboBox<>();
        jComboBoxEmpresa = new javax.swing.JComboBox<>();
        botaoCadastro = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cadastroTipo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Jogos");
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setText("Dados do Jogo");

        jLabel2.setText("Nome:");

        jLabel3.setText("Faixa Etária:");

        jLabel4.setText("Categoria:");

        jLabel5.setText("Empresa Desenvolvedora:");

        jLabel6.setText("Breve Descrição:");

        cadastroNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroNomeActionPerformed(evt);
            }
        });

        jLabel7.setText("Quantidade:");

        jLabel8.setText("Preço:");

        cadastroQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroQuantidadeActionPerformed(evt);
            }
        });

        cadastroPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroPrecoActionPerformed(evt);
            }
        });

        cadastroCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ação", "Aventura", "Corrida", "Esporte", "Estratégia", "Plataforma", "RPG", " ", " " }));

        cadastroCensura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Livre", "10+", "12+", "14+", "16+", "18+" }));
        cadastroCensura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroCensuraActionPerformed(evt);
            }
        });

        jComboBoxEmpresa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cadastroQuantidade)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cadastroPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(145, 145, 145))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cadastroNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                            .addComponent(cadastroBDescricao))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cadastroCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cadastroCensura, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastroNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(cadastroCensura, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastroCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(cadastroBDescricao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cadastroQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastroPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        botaoCadastro.setText("Cadastrar");
        botaoCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastroActionPerformed(evt);
            }
        });

        jLabel9.setText("Nome:");

        jLabel10.setText("Tipo de Cadastro:");

        cadastroTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jogo", "DLC" }));
        cadastroTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroTipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoCadastro)
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65)
                .addComponent(cadastroTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(267, 267, 267)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(267, 267, 267)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(cadastroTipo, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoCadastro)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(147, 147, 147)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(146, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastroActionPerformed
        cadastrarJogo();
        this.dispose();
    }//GEN-LAST:event_botaoCadastroActionPerformed

    private void cadastroNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cadastroNomeActionPerformed

    private void cadastroQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cadastroQuantidadeActionPerformed

    private void cadastroCensuraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroCensuraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cadastroCensuraActionPerformed

    private void cadastroPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cadastroPrecoActionPerformed

    private void cadastroTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cadastroTipoActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        //Exibir empresas desenvolvedoras disponíveis
        FileInputStream fr;
        ObjectInputStream br;
        int i = 0;
        ArrayList<Empresa> array = new ArrayList<>();
        try {
            fr = new FileInputStream("dadosEmpresa.txt");
            br = new ObjectInputStream(fr);
            array = (ArrayList<Empresa>) br.readObject();
            for (Empresa e : array) {
                jComboBoxEmpresa.insertItemAt(e.getNome(), i);
                i++;
            }

        } catch (FileNotFoundException ex) {
            System.err.println(ex.getLocalizedMessage());
            // Logger.getLogger(TelaCadastroJogo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex.getLocalizedMessage());
            //Logger.getLogger(TelaCadastroJogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formComponentShown

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
            java.util.logging.Logger.getLogger(TelaCadastroJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroJogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCadastro;
    private javax.swing.JTextField cadastroBDescricao;
    private javax.swing.JComboBox<String> cadastroCategoria;
    private javax.swing.JComboBox<String> cadastroCensura;
    private javax.swing.JTextField cadastroNome;
    private javax.swing.JTextField cadastroPreco;
    private javax.swing.JTextField cadastroQuantidade;
    private javax.swing.JComboBox<String> cadastroTipo;
    private javax.swing.JComboBox<String> jComboBoxEmpresa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

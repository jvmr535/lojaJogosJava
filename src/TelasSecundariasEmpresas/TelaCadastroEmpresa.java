/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelasSecundariasEmpresas;

import codigo.Empresa;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Thiago Vital
 */
public final class TelaCadastroEmpresa extends javax.swing.JFrame {

    //ArrayList <Empresa> vetEmpresa = new ArrayList<>();
    //File arq = new File ("dadosEmpresa.txt");
    public TelaCadastroEmpresa() {
        initComponents();
    }

    public void cadastroEmpresa() {
        ArrayList<Empresa> vetEmpresa = new ArrayList<>();
        File arq = new File("dadosEmpresa.txt");

        String nome = CaixaNomeFantasia.getText();
        String email = CaixaEmail.getText();
        String cnpj = CaixaCNPJ.getText();
        String razaoSocial = CaixaRazaoSocial.getText();
        String rua = CaixaRua.getText();
        String numero = CaixaNumero.getText();
        String bairro = CaixaBairro.getText();
        String cidade = CaixaCidade.getText();
        String estado = CaixaEstado.getText();
        String pais = CaixaPais.getText();
        String descricao = CaixaDescricao.getText();
        String data = FormatoData.getText();
        String site = CaixaSite.getText();

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
                //SALVO NO ARRAY O ARQUIVO ORIGINAL
                try (ObjectInputStream input = new ObjectInputStream(fileinput)) {
                    //SALVO NO ARRAY O ARQUIVO ORIGINAL
                    vetEmpresa = (ArrayList<Empresa>) input.readObject();
                }
            } catch (EOFException e) {

            }
        } catch (IOException | ClassNotFoundException e1) {
        }

        int veri = 0;
        if (!nome.equals("") && !email.equals("") && !razaoSocial.equals("")
                && !rua.equals("") && !numero.equals("") && !bairro.equals("") && !cidade.equals("")
                && !estado.equals("") && !pais.equals("")
                && !descricao.equals("") && !data.equals("  /  /    ")
                && !site.equals("")) {  // não deixa entrar sem dados

            //verificar se já não existe o CNPJ cadastrado 
            
            if(!cnpj.equals("  .   .   /    -  ")){
            for (Empresa empresa : vetEmpresa) {

                if (cnpj.equals(empresa.getCnpj())) {
                    JOptionPane.showMessageDialog(null, "CNPJ já existente, não pode ser cadastrado!");
                    System.out.println("CNPJ já existe");
                    CaixaNomeFantasia.setText("");
                    CaixaEmail.setText("");
                    CaixaCNPJ.setText("");
                    CaixaRazaoSocial.setText("");
                    CaixaRua.setText("");
                    CaixaNumero.setText("");
                    CaixaBairro.setText("");
                    CaixaCidade.setText("");
                    CaixaEstado.setText("");
                    CaixaPais.setText("");
                    CaixaDescricao.setText("");
                    FormatoData.setText("");
                    CaixaSite.setText("");
                    veri = 1;
                    break;
                }

            }
            }
            if (veri == 0) {
                vetEmpresa.add(new Empresa(nome, email, cnpj, razaoSocial, rua, numero, bairro, cidade,
                        estado, pais, descricao, data, site));
                JOptionPane.showMessageDialog(null, "Empresa cadastrada com sucesso!");
                try {
                    FileOutputStream fo = new FileOutputStream(arq);
                    ObjectOutputStream escreve;
                    escreve = new ObjectOutputStream(fo);
                    escreve.writeObject(vetEmpresa);
                    escreve.flush();
                    escreve.close();
                } catch (IOException ex) {
                    System.err.println("ERRO AO MANIPULAR ARQUIVO");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Empresa não cadastrada!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não é possivel cadastrar desenvolvedora sem dados.");
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        cadastroEmpresas = new javax.swing.JPanel();
        CadastrarEmpresas = new javax.swing.JLabel();
        NomeFantasia = new javax.swing.JLabel();
        Descricao = new javax.swing.JLabel();
        CaixaDescricao = new javax.swing.JTextField();
        DataCadastro = new javax.swing.JLabel();
        Email = new javax.swing.JLabel();
        CNPJ = new javax.swing.JLabel();
        RazaoSocial = new javax.swing.JLabel();
        EnderecoMatriz = new javax.swing.JLabel();
        Site = new javax.swing.JLabel();
        CaixaEmail = new javax.swing.JTextField();
        CaixaRazaoSocial = new javax.swing.JTextField();
        CaixaSite = new javax.swing.JTextField();
        Cancelar = new javax.swing.JButton();
        Salvar = new javax.swing.JButton();
        CaixaNomeFantasia = new javax.swing.JTextField();
        FormatoData = new javax.swing.JFormattedTextField();
        Rua = new javax.swing.JLabel();
        Bairro = new javax.swing.JLabel();
        Cidade = new javax.swing.JLabel();
        Estado = new javax.swing.JLabel();
        Pais = new javax.swing.JLabel();
        CaixaRua = new javax.swing.JTextField();
        CaixaBairro = new javax.swing.JTextField();
        CaixaCidade = new javax.swing.JTextField();
        CaixaEstado = new javax.swing.JTextField();
        CaixaPais = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        CaixaNumero = new javax.swing.JTextField();
        CaixaCNPJ = new javax.swing.JFormattedTextField();

        jTextField1.setText("jTextField1");

        jTextField3.setText("jTextField3");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        cadastroEmpresas.setPreferredSize(new java.awt.Dimension(500, 602));

        CadastrarEmpresas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CadastrarEmpresas.setText("Cadastrar empresas");

        NomeFantasia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NomeFantasia.setText("Nome Fantasia");

        Descricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Descricao.setText("Descrição");

        CaixaDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaixaDescricaoActionPerformed(evt);
            }
        });

        DataCadastro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DataCadastro.setText("Data de Cadastro");

        Email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Email.setText("E-mail");

        CNPJ.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CNPJ.setText("CNPJ");

        RazaoSocial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RazaoSocial.setText("Razão Social");

        EnderecoMatriz.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        EnderecoMatriz.setText("Endereço da Matriz");

        Site.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Site.setText("Site ");

        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        Salvar.setText("Salvar");
        Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarActionPerformed(evt);
            }
        });

        try {
            FormatoData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        Rua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Rua.setText("Rua");

        Bairro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Bairro.setText("Bairro");

        Cidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Cidade.setText("Cidade");

        Estado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Estado.setText("Estado");

        Pais.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Pais.setText("País");

        CaixaRua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaixaRuaActionPerformed(evt);
            }
        });

        CaixaCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaixaCidadeActionPerformed(evt);
            }
        });

        CaixaPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaixaPaisActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Número");

        try {
            CaixaCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout cadastroEmpresasLayout = new javax.swing.GroupLayout(cadastroEmpresas);
        cadastroEmpresas.setLayout(cadastroEmpresasLayout);
        cadastroEmpresasLayout.setHorizontalGroup(
            cadastroEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastroEmpresasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cadastroEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadastroEmpresasLayout.createSequentialGroup()
                        .addGroup(cadastroEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Email)
                            .addComponent(RazaoSocial)
                            .addComponent(CadastrarEmpresas)
                            .addComponent(EnderecoMatriz)
                            .addGroup(cadastroEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(cadastroEmpresasLayout.createSequentialGroup()
                                    .addGroup(cadastroEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Rua, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                    .addGap(76, 76, 76)
                                    .addGroup(cadastroEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(CaixaNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CaixaRua, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(119, 119, 119))
                                .addGroup(cadastroEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(CaixaDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cadastroEmpresasLayout.createSequentialGroup()
                                        .addGroup(cadastroEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(DataCadastro)
                                            .addComponent(CNPJ)
                                            .addComponent(Site))
                                        .addGap(18, 18, 18)
                                        .addGroup(cadastroEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(CaixaRazaoSocial, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                            .addComponent(CaixaSite)
                                            .addComponent(CaixaPais, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CaixaEmail)
                                            .addComponent(FormatoData, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CaixaCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(cadastroEmpresasLayout.createSequentialGroup()
                                    .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(209, 209, 209)
                                    .addComponent(Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(cadastroEmpresasLayout.createSequentialGroup()
                        .addGroup(cadastroEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cadastroEmpresasLayout.createSequentialGroup()
                                .addGroup(cadastroEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Cidade)
                                    .addComponent(Bairro)
                                    .addComponent(Estado))
                                .addGap(83, 83, 83)
                                .addGroup(cadastroEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CaixaCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CaixaBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CaixaEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(cadastroEmpresasLayout.createSequentialGroup()
                                .addComponent(NomeFantasia)
                                .addGap(36, 36, 36)
                                .addComponent(CaixaNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Descricao))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(cadastroEmpresasLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(Pais, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        cadastroEmpresasLayout.setVerticalGroup(
            cadastroEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastroEmpresasLayout.createSequentialGroup()
                .addComponent(CadastrarEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(cadastroEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NomeFantasia)
                    .addComponent(CaixaNomeFantasia))
                .addGap(18, 18, 18)
                .addGroup(cadastroEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Descricao)
                    .addComponent(CaixaDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(cadastroEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FormatoData, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(cadastroEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Email)
                    .addComponent(CaixaEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(cadastroEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CNPJ)
                    .addComponent(CaixaCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(cadastroEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RazaoSocial)
                    .addComponent(CaixaRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(cadastroEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Site)
                    .addComponent(CaixaSite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(EnderecoMatriz)
                .addGap(18, 18, 18)
                .addGroup(cadastroEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CaixaPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Pais))
                .addGap(18, 18, 18)
                .addGroup(cadastroEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CaixaEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(cadastroEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cidade)
                    .addComponent(CaixaCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(cadastroEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Bairro)
                    .addComponent(CaixaBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(cadastroEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CaixaRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Rua))
                .addGap(18, 18, 18)
                .addGroup(cadastroEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CaixaNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(cadastroEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Salvar)
                    .addComponent(Cancelar))
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cadastroEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cadastroEmpresas, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void CaixaDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaixaDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CaixaDescricaoActionPerformed

    private void CaixaRuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaixaRuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CaixaRuaActionPerformed

    private void CaixaCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaixaCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CaixaCidadeActionPerformed

    private void CaixaPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaixaPaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CaixaPaisActionPerformed

    private void SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarActionPerformed
        cadastroEmpresa();
    }//GEN-LAST:event_SalvarActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroEmpresa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bairro;
    private javax.swing.JLabel CNPJ;
    private javax.swing.JLabel CadastrarEmpresas;
    private javax.swing.JTextField CaixaBairro;
    private javax.swing.JFormattedTextField CaixaCNPJ;
    private javax.swing.JTextField CaixaCidade;
    private javax.swing.JTextField CaixaDescricao;
    private javax.swing.JTextField CaixaEmail;
    private javax.swing.JTextField CaixaEstado;
    private javax.swing.JTextField CaixaNomeFantasia;
    private javax.swing.JTextField CaixaNumero;
    private javax.swing.JTextField CaixaPais;
    private javax.swing.JTextField CaixaRazaoSocial;
    private javax.swing.JTextField CaixaRua;
    private javax.swing.JTextField CaixaSite;
    private javax.swing.JButton Cancelar;
    private javax.swing.JLabel Cidade;
    private javax.swing.JLabel DataCadastro;
    private javax.swing.JLabel Descricao;
    private javax.swing.JLabel Email;
    private javax.swing.JLabel EnderecoMatriz;
    private javax.swing.JLabel Estado;
    private javax.swing.JFormattedTextField FormatoData;
    private javax.swing.JLabel NomeFantasia;
    private javax.swing.JLabel Pais;
    private javax.swing.JLabel RazaoSocial;
    private javax.swing.JLabel Rua;
    private javax.swing.JButton Salvar;
    private javax.swing.JLabel Site;
    private javax.swing.JPanel cadastroEmpresas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}

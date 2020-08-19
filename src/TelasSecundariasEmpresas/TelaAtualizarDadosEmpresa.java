/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelasSecundariasEmpresas;

import codigo.Empresa;
import java.awt.event.ActionEvent;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class TelaAtualizarDadosEmpresa extends javax.swing.JFrame {

    /**
     * Creates new form Empresa
     */
    public TelaAtualizarDadosEmpresa() {
        initComponents();
    }

    public void atualizaDados(String tipo, String info) {

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
            
            if(categoria.equals("CNPJ")){
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
            }
            //IMPLEMENTAR BUSCA PARA CNPJ
            //IMPLEMENTAR BUSCA PARA CNPJ
            //IMPLEMENTAR BUSCA PARA CNPJ
            //IMPLEMENTAR BUSCA PARA CNPJ
            //IMPLEMENTAR BUSCA PARA CNPJ
            //IMPLEMENTAR BUSCA PARA CNPJ
            
            if (aux == 1) {
                this.setVisible(true);
                nomedaEmpresa.setEnabled(true);
                emailEmpresa.setEnabled(true);
                cnpjEmpresa.setEnabled(true);
                razaoSocialEmpresa.setEnabled(true);
                ruaEmpresa.setEnabled(true);
                numeroEmpresa.setEnabled(true);
                bairroEmpresa.setEnabled(true);
                cidadeEmpresa.setEnabled(true);
                estadoEmpresa.setEnabled(true);
                paisEmpresa.setEnabled(true);
                descricaoEmpresa.setEnabled(true);
                dataEmpresa.setEnabled(true);
                siteEmpresa.setEnabled(true);

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
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
        jButtonCancelar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jTextFieldInformação = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButtonPesquisar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

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

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(siteEmpresa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                                .addComponent(razaoSocialEmpresa, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(emailEmpresa, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nomedaEmpresa, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(cnpjEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(numeroEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dataEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(ruaEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                                    .addComponent(cidadeEmpresa)
                                    .addComponent(paisEmpresa)
                                    .addComponent(descricaoEmpresa)
                                    .addComponent(estadoEmpresa)
                                    .addComponent(bairroEmpresa))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nomedaEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(emailEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cnpjEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(razaoSocialEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(siteEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descricaoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(paisEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(estadoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cidadeEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(bairroEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ruaEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(numeroEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(dataEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTextFieldInformação.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldInformaçãoActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("DIGITE:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("CATEGORIA");

        jButtonPesquisar.setText("Atualizar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE", "NOME", "RAZÃO SOCIAL", "CNPJ" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel15))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jTextFieldInformação, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldInformação, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKActionPerformed

    }//GEN-LAST:event_OKActionPerformed

    private void ColecaoEstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColecaoEstadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ColecaoEstadosActionPerformed

    private void SelecioneempresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelecioneempresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SelecioneempresaActionPerformed

    private void CaixaFantasiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaixaFantasiaActionPerformed

    }//GEN-LAST:event_CaixaFantasiaActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        // TODO add your handling code here:
        String tipo = jComboBox1.getSelectedItem().toString();
        String info = jTextFieldInformação.getText();
        if (tipo.equals("SELECIONE")) {
            JOptionPane.showMessageDialog(null, "INFORME UMA CATEGORIA VÁLIDA");
        } else {
            //chama a função para atualizar
            atualizaDados(tipo, info);
        }
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jTextFieldInformaçãoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldInformaçãoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldInformaçãoActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:
        ArrayList<Empresa> vetEmpresa = new ArrayList<>();
        File arq = new File("dadosEmpresa.txt");
      
        
    
                
        String nome = nomedaEmpresa.getText();
        String email = emailEmpresa.getText();
        String cnpj = cnpjEmpresa.getText();
        String razaoSocial = razaoSocialEmpresa.getText();
        String rua = ruaEmpresa.getText();
        String numero = numeroEmpresa.getText();
        String bairro =  bairroEmpresa.getText();
        String cidade =cidadeEmpresa.getText();
        String estado = estadoEmpresa.getText();
        String pais = paisEmpresa.getText();
        String descricao = descricaoEmpresa.getText();
        String data =  dataEmpresa.getText();
        String site = siteEmpresa.getText();
        
        try{
            
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
            }
            catch (EOFException e) {
            }
            
            vetEmpresa.add(new Empresa(nome, email, cnpj, razaoSocial, rua, numero, bairro, cidade,
                               estado, pais, descricao, data, site));
            
            FileOutputStream fo = new FileOutputStream(arq);
            ObjectOutputStream escreve;
            escreve = new ObjectOutputStream(fo);
            escreve.writeObject(vetEmpresa);
            escreve.flush();
            escreve.close();
            
         JOptionPane.showMessageDialog(null, "Empresa Atualizada com sucesso!");
        this.dispose();
        }
        catch(IOException | ClassNotFoundException e1){
        }
    
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(Empresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Empresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Empresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Empresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAtualizarDadosEmpresa().setVisible(true);
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
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldInformação;
    private javax.swing.JTextField nomedaEmpresa;
    private javax.swing.JTextField numeroEmpresa;
    private javax.swing.JTextField paisEmpresa;
    private javax.swing.JTextField razaoSocialEmpresa;
    private javax.swing.JTextField ruaEmpresa;
    private javax.swing.JTextField siteEmpresa;
    // End of variables declaration//GEN-END:variables
}

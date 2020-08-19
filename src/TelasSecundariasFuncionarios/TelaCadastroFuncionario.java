/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelasSecundariasFuncionarios;


import TelasSecundariasClientes.TelaCadastroCliente;
import codigo.Administrador;

import codigo.Cliente;
import codigo.Funcionario;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 *
 * @author Rafaela
 */
public class TelaCadastroFuncionario extends javax.swing.JFrame {

    private int posicao = 0;
    //private Object bConfirmarDados;
    ArrayList<Funcionario> Funcionario = new ArrayList<>();
    File arq = new File("dadosFuncionario.txt");
    String usuario;

    /**
     * Creates new form TelaCadastroFuncionario
     */
    public TelaCadastroFuncionario() {
        initComponents();

        jbCancelar.setEnabled(true);
        jbConfirmaDados.setEnabled(false);

        //os campos so estarão livres para edição após clicar em novo
        jBairroFunc.setEnabled(false);
        jCPFFunc.setEnabled(false);
        jCartTrabFunc.setEnabled(false);
        jCelularFunc.setEnabled(false);
        jCidadeFunc.setEnabled(false);
        jComplFunc.setEnabled(false);
        jConfirmarSenhaFunc.setEnabled(false);
        jDataAdmissaoFunc1.setEnabled(false);
        jDataNascFunc.setEnabled(false);
        jEstadoFunc.setEnabled(false);
        jNomeFunc.setEnabled(false);
        jNumCasaFunc.setEnabled(false);
        jRuaFunc.setEnabled(false);
        jSenhaFunc.setEnabled(false);
        jSexoFunc.setEnabled(false);
        jUsernameFunc.setEnabled(false);
        jEmailFuncionario.setEnabled(false);
        jSexoFunc.setEnabled(false);
    }

    public void removerFuncionario(String cpf) {

        try {
            FileInputStream fo = new FileInputStream("dadosFuncionario.txt");
            ObjectInputStream le = new ObjectInputStream(fo);

            for (Funcionario f : Funcionario) {

                if (f.getCPF().equals(cpf)) {

                    posicao = Funcionario.indexOf(f);
                    Funcionario.remove(posicao);
                }
            }

            le.close();

            FileOutputStream fi = new FileOutputStream("dadosFuncionario.txt");
            ObjectOutputStream escreve = new ObjectOutputStream(fi);
            escreve.writeObject(Funcionario);
            escreve.flush();
            escreve.close();

        } catch (IOException e) {

        }

        JOptionPane.showMessageDialog(null, "Dados Excluídos!");

    }

    public void cadastrarFuncionario() {

        String nome = jNomeFunc.getText();
        String cpf = jCPFFunc.getText();
        String sexo = jSexoFunc.getSelectedItem().toString();
        String dataNasc = jDataNascFunc.getText();
        String dataAdm = jDataAdmissaoFunc1.getText();
        String email = jEmailFuncionario.getText();
        String cartTrabalho = jCartTrabFunc.getText();
        String celular = jCelularFunc.getText();

        String cidade = jCidadeFunc.getText();
        String bairro = jBairroFunc.getText();
        String rua = jRuaFunc.getText();
        String numero = jNumCasaFunc.getText();
        String complemento = jComplFunc.getText();
        String estado = jEstadoFunc.getSelectedItem().toString();

        String username = jUsernameFunc.getText();
        String senha = jSenhaFunc.getText();

        try {
            FileInputStream fileinput = new FileInputStream(arq);
            //SALVO NO ARRAY O ARQUIVO ORIGINAL
            try (ObjectInputStream input = new ObjectInputStream(fileinput)) {
                //SALVO NO ARRAY O ARQUIVO ORIGINAL
                Funcionario = (ArrayList<Funcionario>) input.readObject();
            }
        } catch (EOFException e) {

        } catch (IOException | ClassNotFoundException e1) {
        }

        int veri = 0;
        if (!(jNomeFunc.getText().equals(""))
                && !(jCPFFunc.getText().equals(""))
                && !(jCelularFunc.getText().equals("(  )      -    "))
                && !(jDataNascFunc.getText().equals("  /  /    "))
                && !(jDataAdmissaoFunc1.getText().equals("  /  /    "))
                && !(jSexoFunc.getSelectedItem().toString().equals("Selecione"))
                && !(jEmailFuncionario.getText().equals(""))
                && !(jUsernameFunc.getText().equals(""))
                && !(jSenhaFunc.getText().equals(""))
                && !(jConfirmarSenhaFunc.getText().equals(""))
                && !(jCidadeFunc.getText().equals(""))
                && !(jBairroFunc.getText().equals(""))
                && !(jRuaFunc.getText().equals(""))
                && !(jComplFunc.getText().equals(""))
                && !(jNumCasaFunc.getText().equals(""))
                && !(jEstadoFunc.getSelectedItem().toString().equals("Selecione"))) {  // não deixa entrar sem dados

            String procura = jCPFFunc.getText();

            for (Funcionario f : Funcionario) {
                if (f.getCPF().equals(procura)) {

                    JOptionPane.showMessageDialog(null, "CPF já existente, o funcionário não pôde ser cadastrado!");

                    System.out.println("CPF já existe");
                    jNomeFunc.setText(nome);
                    jCPFFunc.setText("");
                    jSexoFunc.setSelectedItem(sexo);
                    jDataNascFunc.setText(dataNasc);
                    jEmailFuncionario.setText(email);
                    jCelularFunc.setText(celular);
                    jCidadeFunc.setText(cidade);
                    jBairroFunc.setText(bairro);
                    jRuaFunc.setText(rua);
                    jNumCasaFunc.setText(numero);
                    jEstadoFunc.setSelectedItem(estado);
                    jUsernameFunc.setText(username);
                    jSenhaFunc.setText(senha);
                    jConfirmarSenhaFunc.setText(senha);
                    jComplFunc.setText(complemento);
                    jCartTrabFunc.setText(cartTrabalho);
                    jDataAdmissaoFunc1.setText(dataAdm);
                    veri = 1;
                    break;
                }
                if (f.getUser().equals(jUsernameFunc.getText())) {
                    JOptionPane.showMessageDialog(null, "Username já existente, o funcionário não pôde ser cadastrado!");

                    System.out.println("Username já existe");
                    jNomeFunc.setText(nome);
                    jCPFFunc.setText(cpf);
                    jSexoFunc.setSelectedItem(sexo);
                    jDataNascFunc.setText(dataNasc);
                    jEmailFuncionario.setText(email);
                    jCelularFunc.setText(celular);
                    jCidadeFunc.setText(cidade);
                    jBairroFunc.setText(bairro);
                    jRuaFunc.setText(rua);
                    jNumCasaFunc.setText(numero);
                    jEstadoFunc.setSelectedItem(estado);
                    jUsernameFunc.setText("");
                    jSenhaFunc.setText(senha);
                    jConfirmarSenhaFunc.setText(senha);
                    jComplFunc.setText(complemento);
                    jCartTrabFunc.setText(cartTrabalho);
                    jDataAdmissaoFunc1.setText(dataAdm);
                    veri = 1;
                    break;

                }
                if (!(jSenhaFunc.getText().equals(jConfirmarSenhaFunc.getText()))) {
                    JOptionPane.showMessageDialog(null, "As senhas informadas não conferem!");

                    System.out.println("Senhas diferentes!");
                    jNomeFunc.setText(nome);
                    jCPFFunc.setText(cpf);
                    jSexoFunc.setSelectedItem(sexo);
                    jDataNascFunc.setText(dataNasc);
                    jEmailFuncionario.setText(email);
                    jCelularFunc.setText(celular);
                    jCidadeFunc.setText(cidade);
                    jBairroFunc.setText(bairro);
                    jRuaFunc.setText(rua);
                    jNumCasaFunc.setText(numero);
                    jEstadoFunc.setSelectedItem(estado);
                    jUsernameFunc.setText(username);
                    jSenhaFunc.setText("");
                    jConfirmarSenhaFunc.setText("");
                    jComplFunc.setText(complemento);
                    jCartTrabFunc.setText(cartTrabalho);
                    jDataAdmissaoFunc1.setText(dataAdm);
                    veri = 1;
                    break;
                }

            }

            if (veri == 0) {

                Funcionario.add(new Funcionario(nome, cpf, dataNasc, sexo, celular, email, dataAdm, cartTrabalho, username, cidade, bairro, rua, numero, complemento, estado, senha));
                JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");

                try {
                    FileOutputStream fo = new FileOutputStream(arq);
                    ObjectOutputStream escreve;
                    escreve = new ObjectOutputStream(fo);
                    escreve.writeObject(Funcionario);
                    escreve.flush();
                    escreve.close();
                } catch (IOException ex) {
                    System.err.println("ERRO AO MANIPULAR ARQUIVO");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Funcionário não cadastrado!");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Não é possivel cadastrar funcionário sem todos os dados");
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

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSexoFunc = new javax.swing.JComboBox<>();
        jCPFFunc = new javax.swing.JFormattedTextField();
        jEmailFuncionario = new java.awt.TextField();
        jCelularFunc = new javax.swing.JFormattedTextField();
        jCartTrabFunc = new javax.swing.JFormattedTextField();
        jDataNascFunc = new javax.swing.JFormattedTextField();
        jLabel18 = new javax.swing.JLabel();
        jDataAdmissaoFunc1 = new javax.swing.JFormattedTextField();
        jNomeFunc = new java.awt.TextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jCidadeFunc = new java.awt.TextField();
        jBairroFunc = new java.awt.TextField();
        jRuaFunc = new java.awt.TextField();
        jNumCasaFunc = new java.awt.TextField();
        jComplFunc = new java.awt.TextField();
        jLabel17 = new javax.swing.JLabel();
        jEstadoFunc = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jUsernameFunc = new java.awt.TextField();
        jSenhaFunc = new javax.swing.JPasswordField();
        jConfirmarSenhaFunc = new javax.swing.JPasswordField();
        jbNovo = new java.awt.Button();
        jbCancelar = new java.awt.Button();
        jbConfirmaDados = new java.awt.Button();
        bSair = new java.awt.Button();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Funcionários");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DADOS PESSOAIS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nome");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("CPF");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Sexo");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("E-mail");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Celular");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Carteira de Trabalho");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Data de Admissão");

        jSexoFunc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Feminino", "Masculino" }));

        try {
            jCPFFunc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jCPFFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCPFFuncActionPerformed(evt);
            }
        });

        jEmailFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEmailFuncionarioActionPerformed(evt);
            }
        });

        try {
            jCelularFunc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jCartTrabFunc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.#####.##-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jDataNascFunc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Data de Nascimento");

        try {
            jDataAdmissaoFunc1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jNomeFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNomeFuncActionPerformed(evt);
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
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(jDataNascFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(31, 31, 31)
                                .addComponent(jDataAdmissaoFunc1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCartTrabFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(106, 106, 106)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jCPFFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(27, 27, 27)
                                .addComponent(jSexoFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jNomeFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCelularFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jEmailFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 8, Short.MAX_VALUE)))
                        .addContainerGap(18, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jNomeFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSexoFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCPFFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jEmailFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCelularFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jDataNascFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jDataAdmissaoFunc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jCartTrabFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ENDEREÇO", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Rua");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Cidade");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Bairro");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Número");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Complemento");

        jCidadeFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCidadeFuncActionPerformed(evt);
            }
        });

        jBairroFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBairroFuncActionPerformed(evt);
            }
        });

        jNumCasaFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNumCasaFuncActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Estado");

        jEstadoFunc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jEstadoFunc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Estado", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RO", "RR", "RN", "RS", "SC", "SE", "SP", "TO" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)))
                .addGap(48, 48, 48)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jCidadeFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(45, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComplFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRuaFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBairroFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jNumCasaFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(113, 113, 113)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jEstadoFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jCidadeFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jBairroFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRuaFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jComplFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jNumCasaFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jEstadoFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CADASTRO LOGIN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Username");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Senha");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Confirmar Senha");

        jUsernameFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUsernameFuncActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jUsernameFunc, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(jSenhaFunc)
                    .addComponent(jConfirmarSenhaFunc))
                .addContainerGap(253, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(jUsernameFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jSenhaFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jConfirmarSenhaFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jbNovo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jbNovo.setLabel("NOVO");
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });

        jbCancelar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jbCancelar.setLabel("CANCELAR");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbConfirmaDados.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jbConfirmaDados.setLabel("CONFIRMAR DADOS");
        jbConfirmaDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfirmaDadosActionPerformed(evt);
            }
        });

        bSair.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bSair.setLabel("SAIR");
        bSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbConfirmaDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bSair, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(35, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bSair, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbConfirmaDados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jEmailFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEmailFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jEmailFuncionarioActionPerformed

    private void jCPFFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCPFFuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCPFFuncActionPerformed

    private void jNomeFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNomeFuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNomeFuncActionPerformed

    private void jBairroFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBairroFuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBairroFuncActionPerformed

    private void jCidadeFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCidadeFuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCidadeFuncActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed

        this.dispose();

// TODO add your handling code here:
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jNumCasaFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNumCasaFuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNumCasaFuncActionPerformed

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed

        jBairroFunc.setEnabled(true);
        jCPFFunc.setEnabled(true);
        jCartTrabFunc.setEnabled(true);
        jCelularFunc.setEnabled(true);
        jCidadeFunc.setEnabled(true);
        jComplFunc.setEnabled(true);
        jConfirmarSenhaFunc.setEnabled(true);
        jDataAdmissaoFunc1.setEnabled(true);
        jDataNascFunc.setEnabled(true);
        jEstadoFunc.setEnabled(true);
        jNomeFunc.setEnabled(true);
        jNumCasaFunc.setEnabled(true);
        jRuaFunc.setEnabled(true);
        jSenhaFunc.setEnabled(true);
        jSexoFunc.setEnabled(true);
        jUsernameFunc.setEnabled(true);
        jEmailFuncionario.setEnabled(true);

        jbCancelar.setEnabled(true);
        jbConfirmaDados.setEnabled(true);

        jNomeFunc.setText("");
        jCPFFunc.setText("");
        jDataNascFunc.setText("");
        jDataAdmissaoFunc1.setText("");
        jEmailFuncionario.setText("");
        jCartTrabFunc.setText("");
        jCelularFunc.setText("");
        jSexoFunc.setSelectedIndex(0);

        jCidadeFunc.setText("");
        jBairroFunc.setText("");
        jRuaFunc.setText("");
        jNumCasaFunc.setText("");
        jComplFunc.setText("");
        jEstadoFunc.setSelectedIndex(0);
        jConfirmarSenhaFunc.setText("");

        jUsernameFunc.setText("");
        jSenhaFunc.setText("");

        // TODO add your handling code here:
    }//GEN-LAST:event_jbNovoActionPerformed

    private void jbConfirmaDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfirmaDadosActionPerformed
        this.usuario = jUsernameFunc.getText();
        boolean aux  = true;
        
        ArrayList<Cliente> procuraCliente = new ArrayList();
        ArrayList<Funcionario> procuraFuncionario = new ArrayList();
        ArrayList<Administrador> procuraAdmin = new ArrayList();

        try {
            FileInputStream fileinput = new FileInputStream("dadosClientes.txt");
            ObjectInputStream input = new ObjectInputStream(fileinput);

            procuraCliente = (ArrayList<Cliente>) input.readObject();

            //funcionario
            try {
                fileinput = new FileInputStream("dadosFuncionario.txt");
                input = new ObjectInputStream(fileinput);

                procuraFuncionario = (ArrayList) input.readObject();

            } catch (IOException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
            }

            //ADMINISTRADOR
            try {
                fileinput = new FileInputStream("dadosAdministrador.txt");
                input = new ObjectInputStream(fileinput);

                procuraAdmin = (ArrayList) input.readObject();

            } catch (IOException ex) {
                System.err.println("ERRO AO MANIPULAR ARQUIVO");
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
            }

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());

        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }

        
         for (Administrador a : procuraAdmin) {
            if (a.getUser().equals(this.usuario)) {
                JOptionPane.showMessageDialog(null, "Este nome de usuário já esta cadastrado!");
                aux = false;
            }
        }
        for (Cliente c : procuraCliente) {
            if (c.getUsername().equals(this.usuario)) {
                JOptionPane.showMessageDialog(null, "Este nome de usuário já esta cadastrado!");
                aux = false;
            }
        }
        for (Funcionario f : procuraFuncionario) {
            if (f.getUser().equals(this.usuario)) {
                JOptionPane.showMessageDialog(null, "Este nome de usuário já esta cadastrado!");
                aux = false;
            }
        }
        
        if(aux){
        cadastrarFuncionario();
        }
        else{
            
        }
        // TODO add your handling code here:

    }//GEN-LAST:event_jbConfirmaDadosActionPerformed

    private void bSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSairActionPerformed

        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_bSairActionPerformed

    private void jUsernameFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUsernameFuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jUsernameFuncActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroCliente().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button bSair;
    private java.awt.TextField jBairroFunc;
    private javax.swing.JFormattedTextField jCPFFunc;
    private javax.swing.JFormattedTextField jCartTrabFunc;
    private javax.swing.JFormattedTextField jCelularFunc;
    private java.awt.TextField jCidadeFunc;
    private java.awt.TextField jComplFunc;
    private javax.swing.JPasswordField jConfirmarSenhaFunc;
    private javax.swing.JFormattedTextField jDataAdmissaoFunc1;
    private javax.swing.JFormattedTextField jDataNascFunc;
    private java.awt.TextField jEmailFuncionario;
    private javax.swing.JComboBox<String> jEstadoFunc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private java.awt.TextField jNomeFunc;
    private java.awt.TextField jNumCasaFunc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private java.awt.TextField jRuaFunc;
    private javax.swing.JPasswordField jSenhaFunc;
    private javax.swing.JComboBox<String> jSexoFunc;
    private java.awt.TextField jUsernameFunc;
    private java.awt.Button jbCancelar;
    private java.awt.Button jbConfirmaDados;
    private java.awt.Button jbNovo;
    // End of variables declaration//GEN-END:variables

}

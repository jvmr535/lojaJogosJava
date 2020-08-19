/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelasSecundariasFuncionarios;

import codigo.Funcionario;
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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Rafaela
 */
public class TelaProcurarAtualizarFuncionario extends javax.swing.JFrame {

    /**
     * Creates new form TelaAtualizacaoFuncionario
     */
    public TelaProcurarAtualizarFuncionario(String cpf) {
        this.procura = cpf;
        initComponents();
    }

    ArrayList<Funcionario> Funcionario = new ArrayList<>();
    File arq = new File("dadosFuncionario.txt");
    String procura;

    public void pesquisa(String cpf) {
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
        String senha = "";

        try {
            FileInputStream fileinput = new FileInputStream(arq);
            ObjectInputStream input = new ObjectInputStream(fileinput);
            //SALVO NO ARRAY O ARQUIVO ORIGINAL
            ArrayList<Funcionario> procuraFuncionario = new ArrayList();
            procuraFuncionario = (ArrayList) input.readObject();

            for (Funcionario f : procuraFuncionario) {
                if (this.procura.equals(f.getCPF()) && this.procura != null) {
                    nome = f.getNome();
                    CPF = f.getCPF();
                    sexo = f.getSexo();
                    dataNasc = f.getDataNasc();
                    email = f.getEmail();
                    celular = f.getCelular();
                    dataAdm = f.getDataAdm();
                    cartTrabalho = f.getCartTrabalho();

                    cidade = f.getCidade();
                    bairro = f.getBairro();
                    rua = f.getRua();
                    numero = f.getNumero();
                    estado = f.getEstado();
                    complemento = f.getComplemento();
                    username = f.getUser();
                    senha = f.getSenha();
                    aux = 1;
                }

            }

            if (aux == 1) { //Foi encontrado administrador com sucesso
                this.setVisible(true);
                jNomeFunc.setEnabled(false);
                jCPFFunc.setEnabled(false);
                jSexoFunc.setEnabled(false);
                jDataNascFunc.setEnabled(false);
                jEmailFuncionario.setEnabled(false);
                jCelularFunc.setEnabled(false);
                jCidadeFunc.setEnabled(false);
                jBairroFunc.setEnabled(false);
                jRuaFunc.setEnabled(false);
                jNumCasaFunc.setEnabled(false);
                jEstadoFunc.setEnabled(false);
                jUsernameFunc1.setEnabled(false);
                jSenhaFunc1.setEnabled(false);
                jConfirmarSenhaFunc1.setEnabled(false);
                jComplFunc.setEnabled(false);
                jDataAdmissaoFunc1.setEnabled(false);
                jCartTrabFunc.setEnabled(false);

                jNomeFunc.setText(nome);
                jCPFFunc.setText(CPF);
                jSexoFunc.setSelectedItem(sexo);
                jDataNascFunc.setText(dataNasc);
                jEmailFuncionario.setText(email);
                jCelularFunc.setText(celular);
                jCidadeFunc.setText(cidade);
                jBairroFunc.setText(bairro);
                jRuaFunc.setText(rua);
                jNumCasaFunc.setText(numero);
                jEstadoFunc.setSelectedItem(estado);
                jUsernameFunc1.setText(username);
                jSenhaFunc1.setText(senha);
                jConfirmarSenhaFunc1.setText(senha);
                jComplFunc.setText(complemento);
                jCartTrabFunc.setText(cartTrabalho);
                jDataAdmissaoFunc1.setText(dataAdm);

            } else if (aux == 0) {
                JOptionPane.showMessageDialog(null, "Não existe cadastro para o Funcionário procurado!");
                MaskFormatter formato = null;
                try {
                    formato = new MaskFormatter("###.###.###-##");
                } catch (ParseException ex) {
                }
                JLabel label = new JLabel("Informe o CPF que deseja procurar: ");
                JFormattedTextField texto = new JFormattedTextField(formato);
                //UIManager.put("OptionPane.okButtonText", "Pesquisar");
                JOptionPane.showMessageDialog(null, new Object[]{label, texto});

                String procura = texto.getText();

                //TelaProcurarAtualizarAdm tela = new TelaProcurarAtualizarAdm();
                if (!"   .   .   -  ".equals(procura)) {
                    pesquisa(procura);
                } else {
                    System.out.println("Sair");
                }
            }

            input.close();

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "OCorreu um erro durante a manipulação do arquivo de dados");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "OCorreu um erro durante a manipulação do arquivo de dados");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "OCorreu um erro durante a manipulação do arquivo de dados");
        }

    }

    public void atualizar() {
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
        String senha = "";

        try {
            FileInputStream fileinput = new FileInputStream(arq);
            //SALVO NO ARRAY O ARQUIVO ORIGINAL
            try (ObjectInputStream input = new ObjectInputStream(fileinput)) {
                //SALVO NO ARRAY O ARQUIVO ORIGINAL
                ArrayList<Funcionario> procuraFuncionario = new ArrayList();
                procuraFuncionario = (ArrayList) input.readObject();

                for (Funcionario f : procuraFuncionario) {
                    if (this.procura.equals(f.getCPF())) {
                        nome = f.getNome();
                        CPF = f.getCPF();
                        sexo = f.getSexo();
                        dataNasc = f.getDataNasc();
                        email = f.getEmail();
                        celular = f.getCelular();
                        cartTrabalho = f.getCartTrabalho();
                        dataAdm = f.getDataAdm();

                        cidade = f.getCidade();
                        bairro = f.getBairro();
                        rua = f.getRua();
                        numero = f.getNumero();
                        estado = f.getEstado();
                        complemento = f.getComplemento();
                        username = f.getUser();
                        senha = f.getSenha();
                        aux = 1;
                    }
                    input.close();
                }
                if (aux == 1) { //Foi encontrado administrador com sucesso
                    this.setVisible(true);
                    jNomeFunc.setEnabled(false);
                    jCPFFunc.setEnabled(false);
                    jSexoFunc.setEnabled(false);
                    jDataNascFunc.setEnabled(false);
                    jEmailFuncionario.setEnabled(false);
                    jCelularFunc.setEnabled(false);
                    jCidadeFunc.setEnabled(false);
                    jBairroFunc.setEnabled(false);
                    jRuaFunc.setEnabled(false);
                    jNumCasaFunc.setEnabled(false);
                    jEstadoFunc.setEnabled(false);
                    jUsernameFunc1.setEnabled(false);
                    jSenhaFunc1.setEnabled(false);
                    jConfirmarSenhaFunc1.setEnabled(false);
                    jComplFunc.setEnabled(false);
                    jDataAdmissaoFunc1.setEnabled(false);
                    jCartTrabFunc.setEnabled(false);

                    jNomeFunc.setText(nome);
                    jCPFFunc.setText(CPF);
                    jSexoFunc.setSelectedItem(sexo);
                    jDataNascFunc.setText(dataNasc);
                    jEmailFuncionario.setText(email);
                    jCelularFunc.setText(celular);
                    jCidadeFunc.setText(cidade);
                    jBairroFunc.setText(bairro);
                    jRuaFunc.setText(rua);
                    jNumCasaFunc.setText(numero);
                    jEstadoFunc.setSelectedItem(estado);
                    jUsernameFunc1.setText(username);
                    jSenhaFunc1.setText(senha);
                    jConfirmarSenhaFunc1.setText(senha);
                    jComplFunc.setText(complemento);
                    jDataAdmissaoFunc1.setText(dataAdm);
                    jCartTrabFunc.setText(cartTrabalho);
                } else if (aux == 0) {
                    JOptionPane.showMessageDialog(null, "Não existe cadastro para o Funcionário procurado!");
                    MaskFormatter formato = null;
                    try {
                        formato = new MaskFormatter("###.###.###-##");
                    } catch (ParseException ex) {
                    }
                    JLabel label = new JLabel("Informe o CPF que deseja procurar: ");
                    JFormattedTextField texto = new JFormattedTextField(formato);
                    //UIManager.put("OptionPane.okButtonText", "Pesquisar");
                    JOptionPane.showMessageDialog(null, new Object[]{label, texto});

                    String procurar = texto.getText();

                    //TelaProcurarAtualizarAdm tela = new TelaProcurarAtualizarAdm();
                    if (!"   .   .   -  ".equals(procurar)) {
                        pesquisa(procurar);
                    } else {
                        System.out.println("Sair");
                    }
                }
            }

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "OCorreu um erro durante a manipulação do arquivo de dados");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "OCorreu um erro durante a manipulação do arquivo de dados");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "OCorreu um erro durante a manipulação do arquivo de dados");
        }

        jNomeFunc.setEnabled(true);
        jCPFFunc.setEnabled(true);
        jSexoFunc.setSelectedItem(sexo);
        jSexoFunc.setEnabled(true);
        jDataNascFunc.setEnabled(true);
        jEmailFuncionario.setEnabled(true);
        jCelularFunc.setEnabled(true);
        jCidadeFunc.setEnabled(true);
        jBairroFunc.setEnabled(true);
        jRuaFunc.setEnabled(true);
        jNumCasaFunc.setEnabled(true);
        jEstadoFunc.setSelectedItem(estado);
        jEstadoFunc.setEnabled(true);
        jUsernameFunc1.setEnabled(true);
        jSenhaFunc1.setEnabled(true);
        jConfirmarSenhaFunc1.setEnabled(true);
        jComplFunc.setEnabled(true);
        jDataAdmissaoFunc1.setEnabled(true);
        jCartTrabFunc.setEnabled(true);

    }

    public void removerParaAtualizar() {
        int remover = 0;
        try {
            FileInputStream file = new FileInputStream(arq);
            try (ObjectInputStream input = new ObjectInputStream(file)) {
                ArrayList<Funcionario> atualizarArray = new ArrayList<>();

                atualizarArray = (ArrayList<Funcionario>) input.readObject();

                System.out.println("ANTES: " + Arrays.toString(atualizarArray.toArray()));

                for (Funcionario f : atualizarArray) {
                    if (f.getCPF().equals(this.procura)) {
                        remover = atualizarArray.indexOf(f);
                    }
                }

                atualizarArray.remove(remover);
                input.close();
                System.out.println("DEPOIS: " + Arrays.toString(atualizarArray.toArray()));

                FileOutputStream stream = new FileOutputStream(arq);
                try (ObjectOutputStream output = new ObjectOutputStream(stream)) {
                    output.writeObject(atualizarArray);
                    output.flush();
                    output.close();
                }
            }
            atualizarDados();

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "OCorreu um erro durante a manipulação do arquivo de dados");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "OCorreu um erro durante a manipulação do arquivo de dados");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "OCorreu um erro durante a manipulação do arquivo de dados");
        }

    }

    public void atualizarDados() {

        String nome = jNomeFunc.getText();
        String cpf = jCPFFunc.getText();
        String sexo = jSexoFunc.getSelectedItem().toString();
        String dataNasc = jDataNascFunc.getText();
        String email = jEmailFuncionario.getText();
        String celular = jCelularFunc.getText();
        String dataAdm = jDataAdmissaoFunc1.getText();
        String cartTrabalho = jCartTrabFunc.getText();

        String cidade = jCidadeFunc.getText();
        String bairro = jBairroFunc.getText();
        String complemento = jComplFunc.getText();
        String rua = jRuaFunc.getText();
        String numero = jNumCasaFunc.getText();
        String estado = jEstadoFunc.getSelectedItem().toString();

        String username = jUsernameFunc1.getText();
        String senha = jSenhaFunc1.getText();

        
       try {
                FileInputStream fileinput = new FileInputStream(arq);
                //SALVO NO ARRAY O ARQUIVO ORIGINAL
                try (ObjectInputStream input = new ObjectInputStream(fileinput)) {
                    //SALVO NO ARRAY O ARQUIVO ORIGINAL
                    Funcionario = (ArrayList<Funcionario>) input.readObject();
                }
            } catch (EOFException e) {

            }
        catch (IOException | ClassNotFoundException e1) {
        }

        
        int veri = 0;
        if (!(jNomeFunc.getText().equals("")) 
                && !(jCPFFunc.getText().equals(""))
                && !(jCelularFunc.getText().equals("(  )      -    ")) 
                && !(jDataNascFunc.getText().equals("  /  /    "))
                && !(jDataAdmissaoFunc1.getText().equals("  /  /    "))
                && !(jSexoFunc.getSelectedItem().toString().equals("Selecione")) 
                && !(jEmailFuncionario.getText().equals(""))
                && !(jUsernameFunc1.getText().equals("")) 
                && !(jSenhaFunc1.getText().equals(""))
                && !(jConfirmarSenhaFunc1.getText().equals(""))
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
                jUsernameFunc1.setText(username);
                jSenhaFunc1.setText(senha);
                jConfirmarSenhaFunc1.setText(senha);
                jComplFunc.setText(complemento);
                jCartTrabFunc.setText(cartTrabalho);
                jDataAdmissaoFunc1.setText(dataAdm);
                    veri = 1;
                    break;
                }
                    if (f.getUser().equals(jUsernameFunc1.getText())) {
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
                jUsernameFunc1.setText("");
                jSenhaFunc1.setText(senha);
                jConfirmarSenhaFunc1.setText(senha);
                jComplFunc.setText(complemento);
                jCartTrabFunc.setText(cartTrabalho);
                jDataAdmissaoFunc1.setText(dataAdm);
                    veri = 1;
                    break;
                        
                }
                    if (!(jSenhaFunc1.getText().equals(jConfirmarSenhaFunc1.getText()))) {
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
                jUsernameFunc1.setText(username);
                jSenhaFunc1.setText("");
                jConfirmarSenhaFunc1.setText("");
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
            
            }else {
            JOptionPane.showMessageDialog(null, "Não é possivel cadastrar funcionário sem todos os dados");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jUsernameFunc1 = new java.awt.TextField();
        jSenhaFunc1 = new javax.swing.JPasswordField();
        jConfirmarSenhaFunc1 = new javax.swing.JPasswordField();
        jbAtualizar = new java.awt.Button();
        jRemover = new java.awt.Button();
        bSair = new java.awt.Button();
        bSalvar = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
                                .addGap(0, 6, Short.MAX_VALUE)))
                        .addContainerGap(16, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
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
                    .addComponent(jCartTrabFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addComponent(jNumCasaFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jEstadoFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCidadeFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComplFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRuaFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBairroFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(33, 33, 33))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jNumCasaFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jEstadoFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CADASTRO LOGIN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Username");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Senha");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Confirmar Senha");

        jConfirmarSenhaFunc1.setText("jPasswordField1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jUsernameFunc1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSenhaFunc1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(jConfirmarSenhaFunc1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19)
                    .addComponent(jUsernameFunc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jSenhaFunc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jConfirmarSenhaFunc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jbAtualizar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jbAtualizar.setLabel("ATUALIZAR");
        jbAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtualizarActionPerformed(evt);
            }
        });

        jRemover.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jRemover.setLabel("REMOVER");
        jRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRemoverActionPerformed(evt);
            }
        });

        bSair.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bSair.setLabel("SAIR");
        bSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSairActionPerformed(evt);
            }
        });

        bSalvar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bSalvar.setLabel("SALVAR");
        bSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bSair, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(108, 108, 108)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                            .addComponent(bSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jRemover, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                            .addComponent(bSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jCPFFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCPFFuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCPFFuncActionPerformed

    private void jEmailFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEmailFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jEmailFuncionarioActionPerformed

    private void jNomeFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNomeFuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNomeFuncActionPerformed

    private void jCidadeFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCidadeFuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCidadeFuncActionPerformed

    private void jBairroFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBairroFuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBairroFuncActionPerformed

    private void jNumCasaFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNumCasaFuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNumCasaFuncActionPerformed

    private void jbAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtualizarActionPerformed

        String estado = (String) jEstadoFunc.getSelectedItem();
        String sexo = (String) jSexoFunc.getSelectedItem();

        jNomeFunc.setEnabled(true);
        jCPFFunc.setEnabled(true);
        jSexoFunc.setSelectedItem(sexo);
        jSexoFunc.setEnabled(true);
        jDataNascFunc.setEnabled(true);
        jEmailFuncionario.setEnabled(true);
        jCelularFunc.setEnabled(true);
        jCidadeFunc.setEnabled(true);
        jBairroFunc.setEnabled(true);
        jRuaFunc.setEnabled(true);
        jNumCasaFunc.setEnabled(true);
        jEstadoFunc.setSelectedItem(estado);
        jEstadoFunc.setEnabled(true);
        jUsernameFunc1.setEnabled(true);
        jSenhaFunc1.setEnabled(true);
        jConfirmarSenhaFunc1.setEnabled(true);
        jComplFunc.setEnabled(true);
        jDataAdmissaoFunc1.setEnabled (true);
        jCartTrabFunc.setEnabled (true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jbAtualizarActionPerformed

    private void jRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRemoverActionPerformed

        int remover = 0;
        try {
            FileInputStream file = new FileInputStream(arq);
            try (ObjectInputStream input = new ObjectInputStream(file)) {
                ArrayList<Funcionario> atualizarArray = new ArrayList<>();
                atualizarArray = (ArrayList<Funcionario>) input.readObject();
                System.out.println("ANTES: " + Arrays.toString(atualizarArray.toArray()));
                for (Funcionario f : atualizarArray) {
                    if (f.getCPF().equals(this.procura)) {
                        remover = atualizarArray.indexOf(f);
                    }
                }

                atualizarArray.remove(remover);

                System.out.println("DEPOIS: " + Arrays.toString(atualizarArray.toArray()));
                FileOutputStream stream = new FileOutputStream(arq);
                try (ObjectOutputStream output = new ObjectOutputStream(stream)) {
                    output.writeObject(atualizarArray);
                    output.flush();
                    output.close();
                }
            }
            this.dispose();
            JOptionPane.showMessageDialog(null, "Cadastro Excluído com sucesso!");

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "OCorreu um erro durante a manipulação do arquivo de dados");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "OCorreu um erro durante a manipulação do arquivo de dados");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "OCorreu um erro durante a manipulação do arquivo de dados");
        }


    }//GEN-LAST:event_jRemoverActionPerformed

    private void bSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalvarActionPerformed

        removerParaAtualizar();

        // TODO add your handling code here:
    }//GEN-LAST:event_bSalvarActionPerformed

    private void bSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSairActionPerformed

        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_bSairActionPerformed

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
            java.util.logging.Logger.getLogger(TelaProcurarAtualizarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaProcurarAtualizarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaProcurarAtualizarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaProcurarAtualizarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaProcurarAtualizarFuncionario("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button bSair;
    private java.awt.Button bSalvar;
    private java.awt.TextField jBairroFunc;
    private javax.swing.JFormattedTextField jCPFFunc;
    private javax.swing.JFormattedTextField jCartTrabFunc;
    private javax.swing.JFormattedTextField jCelularFunc;
    private java.awt.TextField jCidadeFunc;
    private java.awt.TextField jComplFunc;
    private javax.swing.JPasswordField jConfirmarSenhaFunc1;
    private javax.swing.JFormattedTextField jDataAdmissaoFunc1;
    private javax.swing.JFormattedTextField jDataNascFunc;
    private java.awt.TextField jEmailFuncionario;
    private javax.swing.JComboBox<String> jEstadoFunc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private java.awt.TextField jNomeFunc;
    private java.awt.TextField jNumCasaFunc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private java.awt.Button jRemover;
    private java.awt.TextField jRuaFunc;
    private javax.swing.JPasswordField jSenhaFunc1;
    private javax.swing.JComboBox<String> jSexoFunc;
    private java.awt.TextField jUsernameFunc1;
    private java.awt.Button jbAtualizar;
    // End of variables declaration//GEN-END:variables

}

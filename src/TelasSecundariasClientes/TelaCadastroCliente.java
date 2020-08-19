/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelasSecundariasClientes;

import codigo.Administrador;
import codigo.Cliente;
import codigo.Funcionario;
import codigo.SendMail;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class TelaCadastroCliente extends javax.swing.JFrame {
    
    String usuario;

    /**
     * Creates new form TelaCadstroCliente
     */
    public TelaCadastroCliente() {
        initComponents();
        bConfirmarCliente.setEnabled(false);
        bCancelarCliente.setEnabled(true);

        //só conseguirá editar os campos após clicar em NOVO
        tFNomeCliente.setEditable(false);
        jFCPFCliente.setEditable(false);
        jFCelularCliente.setEditable(false);
        jFDataNascCliente.setEditable(false);
        jCBSexoCliente.setEditable(false);
        tFEmailCliente.setEditable(false);
        tFUserNameCliente.setEditable(false);
        tFUserNameCliente.setEditable(false);
        jPFSenha.setEditable(false);
        jPFConfirmarSenhaCliente.setEditable(false);

    }

    /**
     * Método retorna um numero aleatório entre 100 e 999.
     *
     * @return codigoCliente
     */
    public int gerarCodigoConfirmacao() {
        int codigoCliente;
        Random randow = new Random();
        codigoCliente = randow.nextInt(900) + 100;
        System.out.println("codigo gerado " + codigoCliente);
        return codigoCliente;
    }

    /**
     * Método envia email com código de confirmação.
     *
     * @param email
     * @return codigoCliente
     */
    public int enviarEmailConfirmacao(String email) {
        int codigoCliente;
        SendMail sm = new SendMail();
        codigoCliente = gerarCodigoConfirmacao();
        String codigo2 = String.valueOf("Seu codigo para novo usuario na loja: " + codigoCliente);
        sm.sendMail("lojadejogos2018@gmail.com", email, "Código de Confirmação", codigo2);
        return codigoCliente;
    }

    /**
     * O método adiciona os dados em forma de ArrayList no arquivo
     * dadosClientes.txt
     */
    public void cadastrarCliente() {
        //Escrita no arquivo de dados
        ArrayList<Cliente> cliente = new ArrayList<>();
        File arq = new File("dadosClientes.txt");
        String nome = tFNomeCliente.getText();
        String CPF = jFCPFCliente.getText();
        String celular = jFCelularCliente.getText();
        String dataNasc = jFDataNascCliente.getText();
        String sexo = jCBSexoCliente.getSelectedItem().toString();
        String email = tFEmailCliente.getText();
        String username = tFUserNameCliente.getText();
        String senha = jPFSenha.getText();
        System.out.println("Entrou aqui 1");
        try {

            if (!arq.exists()) {

                if (arq.createNewFile()) {
                    System.out.println("O arquivo foi criado");
                } else {
                    System.out.println("O arquivo não foi criado");
                }

            }
            try {
                 System.out.println("Entrou aqui 2");
                FileInputStream fileinput = new FileInputStream(arq);
                ObjectInputStream input = new ObjectInputStream(fileinput);
                //SALVO NO ARRAY O ARQUIVO ORIGINAL
                cliente = (ArrayList<Cliente>) input.readObject();
                input.close();
            } catch (EOFException e) {
                 System.out.println("Entrou aqui 3");

            }

            cliente.add(new Cliente(nome, CPF,dataNasc, sexo, celular, email, username,senha));
             System.out.println("Entrou aqui 4");
            FileOutputStream fo = new FileOutputStream(arq);
            ObjectOutputStream escreve;
            escreve = new ObjectOutputStream(fo);
            escreve.writeObject(cliente);
            escreve.flush();
            escreve.close();
            System.out.println("UserName"+username);
             System.out.println("Senha "+senha);
            System.out.println("**CADASTRADO COM SUCESSO!**");
            
            

        } catch (IOException ex) {
             System.out.println("Entrou aqui 6");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.err.println("CLASSE NÃO ENCONTRADA");
        }

      /*  //escrita no arquivo de senhas
        try (FileWriter fw = new FileWriter("senhasClientes.txt", true); PrintWriter out = new PrintWriter(fw)) {

            out.println(username);
            out.println(senha);
            out.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException e) {
            System.out.println("Erro ao manipular arquivo!");
        }*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tFEmailCliente = new java.awt.TextField();
        jFCPFCliente = new javax.swing.JFormattedTextField();
        jCBSexoCliente = new javax.swing.JComboBox<>();
        jFCelularCliente = new javax.swing.JFormattedTextField();
        tFNomeCliente = new java.awt.TextField();
        jFDataNascCliente = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tFUserNameCliente = new java.awt.TextField();
        jPFSenha = new javax.swing.JPasswordField();
        jPFConfirmarSenhaCliente = new javax.swing.JPasswordField();
        bNovoCliente = new java.awt.Button();
        bCancelarCliente = new java.awt.Button();
        bConfirmarCliente = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Clientes");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DADOS PESSOAIS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nome");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("CPF");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Data de Nascimento");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Sexo");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("e-mail");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Celular");

        tFEmailCliente.setMinimumSize(new java.awt.Dimension(60, 22));
        tFEmailCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tFEmailClienteActionPerformed(evt);
            }
        });

        try {
            jFCPFCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jCBSexoCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Feminino", "Masculino" }));

        try {
            jFCelularCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jFDataNascCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(99, 99, 99)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jFDataNascCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4))
                                    .addComponent(jFCPFCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jCBSexoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tFNomeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tFEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFCelularCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(tFNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jFCPFCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jCBSexoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFDataNascCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(tFEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jFCelularCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CADASTRO LOGIN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Username");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Senha");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Confirmar Senha");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tFUserNameCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(jPFSenha)
                    .addComponent(jPFConfirmarSenhaCliente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(tFUserNameCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jPFSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jPFConfirmarSenhaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        bNovoCliente.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bNovoCliente.setLabel("NOVO");
        bNovoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNovoClienteActionPerformed(evt);
            }
        });

        bCancelarCliente.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bCancelarCliente.setLabel("CANCELAR");
        bCancelarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarClienteActionPerformed(evt);
            }
        });

        bConfirmarCliente.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bConfirmarCliente.setLabel("CONFIRMAR DADOS");
        bConfirmarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConfirmarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(bNovoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(bCancelarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bConfirmarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bCancelarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(bNovoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(bConfirmarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bNovoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNovoClienteActionPerformed
        bConfirmarCliente.setEnabled(true);
        bCancelarCliente.setEnabled(true);
        tFNomeCliente.setEditable(true);
        jFCPFCliente.setEditable(true);
        jFCelularCliente.setEditable(true);
        jFDataNascCliente.setEditable(true);
        jCBSexoCliente.setEditable(true);
        tFEmailCliente.setEditable(true);
        tFUserNameCliente.setEditable(true);
        tFUserNameCliente.setEditable(true);
        jPFSenha.setEditable(true);
        jPFConfirmarSenhaCliente.setEditable(true);

        tFNomeCliente.setText(" ");
        tFNomeCliente.setText("");
        jFCPFCliente.setText("");
        jFCelularCliente.setText("");
        jFDataNascCliente.setText("");
        jCBSexoCliente.setSelectedIndex(0);
        tFEmailCliente.setText(" ");
        tFEmailCliente.setText("");
        tFUserNameCliente.setText(" ");
        tFUserNameCliente.setText("");
        jPFSenha.setText("");
        jPFConfirmarSenhaCliente.setText("");
        bConfirmarCliente.setEnabled(true);
        bCancelarCliente.setEnabled(true);
    }//GEN-LAST:event_bNovoClienteActionPerformed

    private void bCancelarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarClienteActionPerformed
        //se cancelar sai da tela
        this.dispose();
    }//GEN-LAST:event_bCancelarClienteActionPerformed

    private void bConfirmarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConfirmarClienteActionPerformed
        
        this.usuario = tFNomeCliente.getText();
        boolean auxB  = true;
        
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
                
                auxB = false;
            }
        }
        for (Cliente c : procuraCliente) {
            if (c.getUsername().equals(this.usuario)) {
                auxB = false;
            }
        }
        for (Funcionario f : procuraFuncionario) {
            if (f.getUser().equals(this.usuario)) {
                auxB = false;
            }
        }
        
        if(!auxB){
            JOptionPane.showMessageDialog(null, "Este nome de usuário já esta cadastrado!");
        }
        else{
            
            
            int aux = 0;
        //verificar se usuário não já foi cadastrado
        if (!jFCPFCliente.getText().equals("   .   .   -  ")) {
            String procura;
            procura = jFCPFCliente.getText();
            ArrayList<Cliente> cliente = new ArrayList<>();
            try {
                FileInputStream fileinput = new FileInputStream("dadosClientes.txt");
                ObjectInputStream input = new ObjectInputStream(fileinput);
                //guarda o que foi lido no arrayList
                cliente = (ArrayList<Cliente>) input.readObject();

                for (Cliente c : cliente) {
                    if (c.getCPF().equals(procura)) {
                        JOptionPane.showMessageDialog(null, "Usuário já cadastrado!");
                        tFNomeCliente.setText(" ");
                        tFNomeCliente.setText("");
                        jFCPFCliente.setText("");
                        jFCelularCliente.setText("");
                        jFDataNascCliente.setText("");
                        jCBSexoCliente.setSelectedIndex(0);
                        tFEmailCliente.setText(" ");
                        tFEmailCliente.setText("");
                        tFUserNameCliente.setText(" ");
                        tFUserNameCliente.setText("");
                        jPFSenha.setText("");
                        jPFConfirmarSenhaCliente.setText("");
                        aux = 1;
                        break;
                    }
                    //verificar se userName é único
                    if(c.getUsername().equals(tFUserNameCliente.getText())){
                         JOptionPane.showMessageDialog(null, "Nome de usuário já existe. Por favor, insira outro Username!");
                        tFUserNameCliente.setText("");
                        jPFSenha.setText("");
                        jPFConfirmarSenhaCliente.setText("");
                        System.out.println("Verificou user");
                        aux=2;
                        break;
                    }

                }
                if (aux !=1) {
                    System.out.println("usuário não encontrado no arquivo de dados");
                }
            } catch (IOException ex) {
                System.err.println("ERRO AO MANIPULAR ARQUIVO");

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TelaCadastroCliente.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        String email = tFEmailCliente.getText();

        //Verificar código e cadastrar se o código informado estiver correto
        if ((aux == 0) && !(tFNomeCliente.getText().equals("")) && !(jFCPFCliente.getText().equals(""))
                && !(jFCelularCliente.getText().equals("(  )      -    ")) && !(jFDataNascCliente.getText().equals("  /  /    "))
                && !(jCBSexoCliente.getSelectedItem().toString().equals("Selecione")) && !(tFEmailCliente.getText().equals(""))
                && !(tFUserNameCliente.getText().equals("")) && !(jPFSenha.getText().equals("")) && !(jPFConfirmarSenhaCliente.getText().equals(""))) {

            // String email = tFEmailCliente.getText();
            if (jPFSenha.getText().equals(jPFConfirmarSenhaCliente.getText())) {

                Cliente novoCliente = new Cliente();
                novoCliente.setNome(tFNomeCliente.getText());
                novoCliente.setCPF(jFCPFCliente.getText());
                novoCliente.setCelular(jFCelularCliente.getText());
                novoCliente.setDataNasc(jFDataNascCliente.getText());
                novoCliente.setSexo((String) jCBSexoCliente.getSelectedItem());
                novoCliente.setEmail(email);
                novoCliente.setUsername(tFUserNameCliente.getText());
                novoCliente.setSenha(jPFSenha.getText());
                int cod = enviarEmailConfirmacao(email);
                String codigoGerado = String.valueOf(cod);
                System.out.println("codigo: " + codigoGerado);
                String codigoInformadoCliente = JOptionPane.showInputDialog("Por Favor, insira o código de confirmação enviado para o email informado:");
                if (codigoInformadoCliente == null) {
                    JOptionPane.showMessageDialog(null, "Cliente não cadastrado!");
                }
                if (codigoInformadoCliente != null && (codigoInformadoCliente.equals("") || !((codigoInformadoCliente).equals(codigoGerado)))) {
                    try {
                        while (codigoInformadoCliente.equals("") || ((codigoInformadoCliente != null && !(codigoGerado.equals(codigoInformadoCliente))))) {
                            try {
                                codigoInformadoCliente = JOptionPane.showInputDialog("Valor Inválido. Por favor, insira o código de confirmação novamente ou cancele a operação para corrigir o e-mail!");
                                if (codigoGerado.equals(codigoInformadoCliente)) {
                                    break;
                                }
                            } catch (NullPointerException e) {
                                JOptionPane.showMessageDialog(null, "Cliente não cadastrado!");
                                break;
                            }

                        }
                    } catch (NullPointerException e) {
                        JOptionPane.showMessageDialog(null, "Cliente não cadastrado!");
                    }

                }
                if (codigoGerado.equals(codigoInformadoCliente)) {
                    cadastrarCliente();
                    JOptionPane.showMessageDialog(null, "Usuario Cadastrado com sucesso!");
                    this.dispose();

                }

            } else {
                JOptionPane.showMessageDialog(null, "Senha não confere. Insira novamente!");
                jPFSenha.setText("");
                jPFConfirmarSenhaCliente.setText("");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Ainda há dados para serem inseridos");
        }

            
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_bConfirmarClienteActionPerformed

    private void tFEmailClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tFEmailClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tFEmailClienteActionPerformed

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
    private java.awt.Button bCancelarCliente;
    private java.awt.Button bConfirmarCliente;
    private java.awt.Button bNovoCliente;
    private javax.swing.JComboBox<String> jCBSexoCliente;
    private javax.swing.JFormattedTextField jFCPFCliente;
    private javax.swing.JFormattedTextField jFCelularCliente;
    private javax.swing.JFormattedTextField jFDataNascCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPFConfirmarSenhaCliente;
    private javax.swing.JPasswordField jPFSenha;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private java.awt.TextField tFEmailCliente;
    private java.awt.TextField tFNomeCliente;
    private java.awt.TextField tFUserNameCliente;
    // End of variables declaration//GEN-END:variables

}

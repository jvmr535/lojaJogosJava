/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelasSecundariasFuncionarios;

import codigo.Autenticar;
import codigo.Venda;
import codigo.ImprimirArquivo;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class TelaConfirmarCompra extends javax.swing.JFrame {

    private static boolean tabelaComPendencias = false;//atributo para indicar se a tabela jTableConfirmarCompra tem compras para serem confirmadas

    String comprasAindaPendentes = "";

    /**
     * Creates new form TelaConfirmarCompra
     */
    public TelaConfirmarCompra() {
        initComponents();
        comprasAindaPendentes = preencherTabela();
    }

    public boolean gerarComprovantePagamento(String compraConfirmada) {

        String dadosCompra[] = compraConfirmada.split("#");
        //gravar em arquivo os dados do clente e da compra
        try (FileWriter fw = new FileWriter("comprovantePagamento.txt"); BufferedWriter out = new BufferedWriter(fw)) {
            out.write("*************************Loja de Jogos************************");
            out.newLine();
            out.newLine();
            out.write("******************Comprovante de Pagamento********************");
            out.newLine();
            out.newLine();
            out.write("Cliente: " + dadosCompra[0]);//tirar o [
            out.newLine();
            out.write("CPF: " + dadosCompra[1]);
            out.newLine();
            out.write("Jogo adquirido: " + dadosCompra[2] + ": " + dadosCompra[3] + " unidades.");
            out.newLine();
            out.write("Forma de aquisição: " + dadosCompra[4]);
            out.newLine();
            out.write("Valor unitário: " + dadosCompra[5]);
            out.newLine();
            out.write("Valor total: " + dadosCompra[6]);
            out.newLine();
            out.write("Forma de pagamento: " + dadosCompra[7]);
            out.newLine();
            out.write("Data da compra: " + dadosCompra[8]);
            out.newLine();
            out.write("Funcionário Responsável: " + Autenticar.getUser());
            out.newLine();
            out.newLine();
            out.write("**************Obrigado pela compra. Volte Sempre*************");
            out.newLine();
            out.flush();
            out.close();
            return true;

        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException e) {
            System.out.println("Erro ao manipular arquivo!");
        }

        return false;
    }

    /**
     * Método mostra as compras que precisam ser confirmadas
     *
     * @return
     */
    public String preencherTabela() {
        //ler arquivo com compras pendentes

        File arq = new File("dadosComprasPendentes.txt");
        //gravar dados do arquivo em um ArrayList

        System.out.println("Entrou aqui 1");
        String comprasPendentes = "";

        try {
            System.out.println("Entrou aqui 3");
            String linha = "";
            FileReader reader = new FileReader(arq);
            BufferedReader leitorArquivo = new BufferedReader(reader);
            try {
                linha = leitorArquivo.readLine();

                System.out.println("linha= " + linha);
                while (linha != null) {

                    comprasPendentes = comprasPendentes + linha + "\r\n";
                    linha = leitorArquivo.readLine();
                }
            } catch (IOException ex) {
                Logger.getLogger(TelaConfirmarCompra.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(TelaConfirmarCompra.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TelaConfirmarCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("comprasPendentes: " + comprasPendentes);
        //inserir dados na tabela
        DefaultTableModel dtmConfirmaCompra = (DefaultTableModel) jTableConfirmarCompra.getModel();
        dtmConfirmaCompra.setNumRows(0);//limpar a tabela antes de encher de novo
        String nomeCliente = null, nomeUser, jogo = null, qtde = null, dataCompra = null, precoUnitario, valorPago = null, valorRestante = null, formaPgtoPago = null, precoTotal, midia = null, status = null, cpf = null, formaPgtoRestante = null;
        if (!comprasPendentes.isEmpty()) {
            String compras[] = comprasPendentes.split("\r\n");

            for (int i = 0; i < compras.length; i++) {

                if (!compras[i].isEmpty()) {
                    String dadosCompra[] = compras[i].split("#");
                    for (int j = 0; j < dadosCompra.length; j++) {
                        nomeCliente = dadosCompra[0];
                        nomeUser = dadosCompra[1];
                        jogo = dadosCompra[2];
                        qtde = dadosCompra[3];
                        dataCompra = dadosCompra[4];
                        precoUnitario = dadosCompra[5];
                        valorPago = dadosCompra[6];
                        valorRestante = dadosCompra[7];
                        formaPgtoPago = dadosCompra[8];
                        precoTotal = dadosCompra[9];
                        midia = dadosCompra[10];
                        status = dadosCompra[11];
                        cpf = dadosCompra[12];
                        if (dadosCompra[13] != null) {
                            formaPgtoRestante = dadosCompra[13];
                        }
                    }

                }
                Object[] dados = {cpf, nomeCliente, jogo, qtde,
                    dataCompra, valorPago, formaPgtoPago, valorRestante, formaPgtoRestante, midia, status};
                dtmConfirmaCompra.addRow(dados);
            }

        }
        System.out.println("Entrou aqui 10");
        if (jTableConfirmarCompra.getRowCount() > 0) {
            setTabelaComPendencias(true);
        }
        System.out.println("Entrou aqui 11");
        return comprasPendentes;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableConfirmarCompra = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jBConfirmar = new javax.swing.JButton();
        jTFNomeCliente = new javax.swing.JTextField();
        jTJogo = new javax.swing.JTextField();
        jFTDataConfirmacao = new javax.swing.JFormattedTextField();
        jBSair = new javax.swing.JButton();
        jTValorTotalPago = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Confirmar Compra dos Clientes");

        jTableConfirmarCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CPF", "Cliente", "Jogo", "Qtde", "Data Compra", "Valor Pago", "Forma pgto do valor pago", "Valor a Pagar", "Forma Pagamento", "Mídia", "Status Compra"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableConfirmarCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableConfirmarCompraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableConfirmarCompra);
        if (jTableConfirmarCompra.getColumnModel().getColumnCount() > 0) {
            jTableConfirmarCompra.getColumnModel().getColumn(0).setMinWidth(50);
            jTableConfirmarCompra.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableConfirmarCompra.getColumnModel().getColumn(1).setMinWidth(300);
            jTableConfirmarCompra.getColumnModel().getColumn(1).setPreferredWidth(300);
            jTableConfirmarCompra.getColumnModel().getColumn(2).setMinWidth(200);
            jTableConfirmarCompra.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTableConfirmarCompra.getColumnModel().getColumn(3).setMinWidth(50);
            jTableConfirmarCompra.getColumnModel().getColumn(3).setPreferredWidth(50);
            jTableConfirmarCompra.getColumnModel().getColumn(4).setMinWidth(100);
            jTableConfirmarCompra.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTableConfirmarCompra.getColumnModel().getColumn(5).setMinWidth(100);
            jTableConfirmarCompra.getColumnModel().getColumn(5).setPreferredWidth(100);
            jTableConfirmarCompra.getColumnModel().getColumn(6).setMinWidth(100);
            jTableConfirmarCompra.getColumnModel().getColumn(6).setPreferredWidth(100);
            jTableConfirmarCompra.getColumnModel().getColumn(7).setMinWidth(100);
            jTableConfirmarCompra.getColumnModel().getColumn(7).setPreferredWidth(100);
            jTableConfirmarCompra.getColumnModel().getColumn(8).setMinWidth(100);
            jTableConfirmarCompra.getColumnModel().getColumn(8).setPreferredWidth(100);
            jTableConfirmarCompra.getColumnModel().getColumn(9).setMinWidth(50);
            jTableConfirmarCompra.getColumnModel().getColumn(9).setPreferredWidth(50);
            jTableConfirmarCompra.getColumnModel().getColumn(10).setMinWidth(100);
            jTableConfirmarCompra.getColumnModel().getColumn(10).setPreferredWidth(100);
        }

        jLabel2.setText("Cliente:");

        jLabel3.setText("Jogo:");

        jLabel4.setText("Data:");

        jLabel5.setText("Valor Total Pago:");

        jBConfirmar.setText("CONFIRMAR");
        jBConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConfirmarActionPerformed(evt);
            }
        });

        jTFNomeCliente.setEditable(false);
        jTFNomeCliente.setBackground(new java.awt.Color(255, 255, 255));
        jTFNomeCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTJogo.setEditable(false);
        jTJogo.setBackground(new java.awt.Color(255, 255, 255));
        jTJogo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTJogoActionPerformed(evt);
            }
        });

        jFTDataConfirmacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        jFTDataConfirmacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jBSair.setText("SAIR");
        jBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSairActionPerformed(evt);
            }
        });

        jTValorTotalPago.setEditable(false);
        jTValorTotalPago.setBackground(new java.awt.Color(255, 255, 255));
        jTValorTotalPago.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTValorTotalPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTValorTotalPagoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTDataConfirmacao, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTValorTotalPago, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(jBConfirmar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jBConfirmar)
                    .addComponent(jTFNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTJogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTDataConfirmacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTValorTotalPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jBSair)
                .addGap(22, 22, 22))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSairActionPerformed
        dispose();
    }//GEN-LAST:event_jBSairActionPerformed

    private void jBConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConfirmarActionPerformed
        DefaultTableModel dtmConfirmaCompra = (DefaultTableModel) jTableConfirmarCompra.getModel();
        String comprasFinalizadas = "";
        int aux = 0;
        //coloca na coluna status compra efetuada com sucesso
        if (jTableConfirmarCompra.getSelectedRow() != -1) {
            int linha = jTableConfirmarCompra.getSelectedRow();
            dtmConfirmaCompra.setValueAt("Compra efetuada com sucesso", jTableConfirmarCompra.getSelectedRow(), 10);
        }
        //escreve em um arquivo com compras bem sucedidas

        File arq = new File("dadosComprasBemSucedidas.txt");
        //verifica se o arquivo existe
        if (!arq.exists()) {

            try {
                if (arq.createNewFile()) {
                    System.out.println("O arquivo foi criado");
                } else {
                    System.out.println("O arquivo não foi criado");
                }
            } catch (IOException ex) {
                Logger.getLogger(TelaConfirmarCompra.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        //buscar compra confirmada em compras Pendentes
        String comprasOK = "", comprasPaga = "";
        String nomeCliente = null, nomeUser = null, jogo = null, qtde = null, dataCompra = null, precoUnitario = null, valorPago = null, valorRestante = null, formaPgtoPago = null, precoTotal = null, midia = null, status = null, cpf = null, formaPgtoRestante = null;
        if (!comprasAindaPendentes.isEmpty()) {
            String compras[] = comprasAindaPendentes.split("\r\n");
            for (int i = 0; i < compras.length; i++) {

                if (!compras[i].isEmpty()) {
                    String dadosCompra[] = compras[i].split("#");
                    for (int j = 0; j < dadosCompra.length; j++) {
                        nomeCliente = dadosCompra[0];
                        nomeUser = dadosCompra[1];
                        jogo = dadosCompra[2];
                        qtde = dadosCompra[3];
                        dataCompra = dadosCompra[4];
                        precoUnitario = dadosCompra[5];
                        valorPago = dadosCompra[6];
                        valorRestante = dadosCompra[7];
                        formaPgtoPago = dadosCompra[8];
                        precoTotal = dadosCompra[9];
                        midia = dadosCompra[10];
                        status = dadosCompra[11];
                        cpf = dadosCompra[12];
                        if (dadosCompra[13] != null) {
                            formaPgtoRestante = dadosCompra[13];
                        }
                    }
                }
                if (jTableConfirmarCompra.getValueAt(jTableConfirmarCompra.getSelectedRow(), 0).equals(cpf)) {
                    String formaPgto = "-";
                    if (Double.parseDouble(valorRestante) > 0) {
                        formaPgto = "R$ " + valorPago + ": " + formaPgtoPago + "e R$ "
                                + valorRestante + ": " + jTableConfirmarCompra.getValueAt(jTableConfirmarCompra.getSelectedRow(), 8);
                    } else {
                        formaPgto = formaPgtoPago;
                    }
                    //dados para arquivo de compras bem sucedidas
                    comprasOK = nomeUser + "#" + jogo + "#" + precoUnitario + "#" + qtde + "#" + precoTotal + "#" + jFTDataConfirmacao.getText() + "#" + formaPgto + "#" + String.valueOf(jTableConfirmarCompra.getValueAt(jTableConfirmarCompra.getSelectedRow(), 9)) + "#"
                            + "Compra efetuada com sucesso";
                    //dados para comprovante de pagamento
                    comprasPaga = nomeCliente + "#" + cpf + "#" + jogo + "#" + qtde + "#" + midia + "#" + precoUnitario + "#" + precoTotal + "#" + formaPgto + "#" + jFTDataConfirmacao.getText() + "#";
                    break;
                }

            }
        }

        //salvar dados no arquivo
        try (FileWriter fw = new FileWriter("dadosComprasBemSucedidas.txt", true); BufferedWriter bufOut = new BufferedWriter(fw)) {
            bufOut.write(comprasOK);
            bufOut.newLine();
            bufOut.flush();
            bufOut.close();
            aux = 1;
        } catch (IOException ex) {
            Logger.getLogger(TelaConfirmarCompra.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (aux == 1) {
            gerarComprovantePagamento(comprasPaga);

            //imprimir comprovante de pagamento
            ImprimirArquivo imprimir = new ImprimirArquivo();
            imprimir.imprimeArquivo("comprovantePagamento.txt");
            aux = 2;
        }

        if (aux == 2) {
            //apagar compra confirmada do arquivo compras pendentes
            //ler arquivo com compras pendentes

            arq = new File("dadosComprasPendentes.txt");

            if (!arq.exists()) {

                try {
                    if (arq.createNewFile()) {
                        System.out.println("O arquivo foi criado");
                    } else {
                        System.out.println("O arquivo não foi criado");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(TelaConfirmarCompra.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            //ler arquivo de compras pendentes
            try {

            
                String comprasPendentes = "";
                String linhaArquivo = "";
                File arqComprasPendentes = new File("dadosComprasPendentes.txt");
                FileReader reader = new FileReader(arqComprasPendentes);
                BufferedReader leitorArquivo = new BufferedReader(reader);
                try {
                    linhaArquivo = leitorArquivo.readLine();

                    while (linhaArquivo != null) {
                        comprasPendentes = comprasPendentes + linhaArquivo + "\r\n"; //cada linha uma compra pendente
                        linhaArquivo = leitorArquivo.readLine();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(TelaConfirmarCompra.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        reader.close();
                    } catch (IOException ex) {
                        Logger.getLogger(TelaConfirmarCompra.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

               int p=0;
              //buscar na tabela linha de compra já confirmada
                for(int i=0;i<jTableConfirmarCompra.getRowCount();i++){
                    String linha=(String) jTableConfirmarCompra.getValueAt(i, 10);
                    System.out.println("valores linhas= "+jTableConfirmarCompra.getValueAt(i, 10));
                    if(linha.equals("Compra efetuada com sucesso")){
                        p=i;
                    }
                }
                
                //excluir linha já confirmada
                comprasAindaPendentes = "";
               String compras1[]=comprasPendentes.split("\r\n");
                for (int i = 0; i < compras1.length; i++) {
                    if(i!=p){
                        comprasAindaPendentes = comprasAindaPendentes +compras1[i]+ "\r\n";
                    }
                }
                System.out.println("compras ainda pendentes: "+comprasAindaPendentes);
                //escrever no arquivo compras ainda não confirmadas
                
                try (FileWriter fwr = new FileWriter("dadosComprasPendentes.txt"); BufferedWriter outW = new BufferedWriter(fwr)) {
                outW.write(comprasAindaPendentes);
               

            } catch (FileNotFoundException ex) {
                Logger.getLogger(TelaConfirmarCompra.class.getName()).log(Level.SEVERE, null, ex);
            }   catch (IOException ex) {
                    Logger.getLogger(TelaConfirmarCompra.class.getName()).log(Level.SEVERE, null, ex);
                }
            }catch(Exception ex){
                Logger.getLogger(TelaConfirmarCompra.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro. Compra não confirmada! Tente novamente.");
        }

        jTFNomeCliente.setText("");
        jTJogo.setText("");
        jFTDataConfirmacao.setText("");
        jTValorTotalPago.setText("");

    }//GEN-LAST:event_jBConfirmarActionPerformed

    private void jTableConfirmarCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableConfirmarCompraMouseClicked
        // ao clicar na linha os dados aparecerão nos campos

        //jTConsumoDiario.getSelectedRow() == -1 significa que nenhuma linha foi selecionada
        if (jTableConfirmarCompra.getSelectedRow() != -1) {
            int linha = jTableConfirmarCompra.getSelectedRow();
            double valorTotal = Double.parseDouble((String) jTableConfirmarCompra.getValueAt(linha, 5)) + Double.parseDouble((String) jTableConfirmarCompra.getValueAt(linha, 7));

            jTFNomeCliente.setText((String) jTableConfirmarCompra.getValueAt(linha, 1));
            jTJogo.setText((String) jTableConfirmarCompra.getValueAt(linha, 2));
            jFTDataConfirmacao.setText((String) jTableConfirmarCompra.getValueAt(linha, 4));
            jTValorTotalPago.setText(valorTotal + "");

        } else {
            jTFNomeCliente.setText("");
            jTJogo.setText("");
            jFTDataConfirmacao.setText("");
            jTValorTotalPago.setText("");
        }
    }//GEN-LAST:event_jTableConfirmarCompraMouseClicked

    private void jTJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTJogoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTJogoActionPerformed

    private void jTValorTotalPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTValorTotalPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTValorTotalPagoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //a cada 1 minuto a tabela confirma compra será atualizada
        Timer timer = new Timer(60000, new atualizaTabela());
        timer.start();
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(TelaConfirmarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaConfirmarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaConfirmarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConfirmarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaConfirmarCompra().setVisible(true);
            }
        });
    }

    class atualizaTabela implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            comprasAindaPendentes = "";

            comprasAindaPendentes = preencherTabela();

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBConfirmar;
    private javax.swing.JButton jBSair;
    private javax.swing.JFormattedTextField jFTDataConfirmacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFNomeCliente;
    private javax.swing.JTextField jTJogo;
    private javax.swing.JTextField jTValorTotalPago;
    private javax.swing.JTable jTableConfirmarCompra;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the tabelaComPendencias
     */
    public static boolean isTabelaComPendencias() {
        return tabelaComPendencias;
    }

    /**
     * @param aTabelaComPendencias the tabelaComPendencias to set
     */
    public static void setTabelaComPendencias(boolean aTabelaComPendencias) {
        tabelaComPendencias = aTabelaComPendencias;
    }
}

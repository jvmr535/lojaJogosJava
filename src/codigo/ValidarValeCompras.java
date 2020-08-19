/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import TelasSecundariasFuncionarios.TelaCadastroValeCompras;
import codigo.ValeCompras;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class ValidarValeCompras {

    String id = "";
    double valor = 0;
    String dataVigor = "";
    String dataValidade = "";

    /**
     * Método para validar vale-compras
     *
     * @param identificacao
     * @return retorna true caso ok
     */
    public boolean validaValeCompras(String identificacao) {
        //ler arquivo de vales-compras
        File arq = new File("dadosValeCompras.txt");
        FileInputStream file;
        try {
            file = new FileInputStream(arq);
            ObjectInputStream input = new ObjectInputStream(file);

            ArrayList<ValeCompras> valeArray = new ArrayList<>();
            valeArray = (ArrayList) input.readObject();

            for (int i = 0; i < valeArray.size(); i++) {
                if (identificacao.equals(valeArray.get(i).getIdentificacao())) {
                    id = identificacao;
                    System.out.println("identificação: "+id);
                    valor = Double.parseDouble(valeArray.get(i).getValor());
                    System.out.println("valor: "+valor);
                    dataVigor = valeArray.get(i).getDataVigor();
                    System.out.println("data vigor: "+dataVigor);
                    dataValidade = valeArray.get(i).getDataValidade();
                    System.out.println("data validade: "+dataValidade);
                    return true;
                } else {
                    return false;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ValidarValeCompras.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ValidarValeCompras.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ValidarValeCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Método retorna valor restante para completar a compra
     *
     * @param precoJogo
     * @return valor que falta para chegar ao preco do jogo
     */
    public double verificaValor(double precoJogo) {

        if (precoJogo <= valor) {
            System.out.println("Vale-Compras quita preco!");
            return 0;
        } else {
            System.out.println("Vale-Compras com valor inferior ao preco!");
            return precoJogo - valor;
        }
    }

    /**
     * Método verifica se o vale não perdeu a validade
     *
     * @param dataCompra
     * @return true caso validade ok
     */
    public boolean verificaValidade(String dataCompra) {

        Date dataVal = null;
        Date dataComp = null;
        String formato = "dd/MM/yyyy";
        SimpleDateFormat formatter = new SimpleDateFormat(formato);
        //transformar String em date
        try {
            dataComp = (Date) formatter.parse(dataCompra);
            dataVal = (Date) formatter.parse(dataValidade);
        } catch (ParseException ex) {
            Logger.getLogger(ValidarValeCompras.class.getName()).log(Level.SEVERE, null, ex);
        }

        Calendar dataValid = Calendar.getInstance();
        dataValid.setTime(dataVal);
        Calendar dataCompr = Calendar.getInstance();
        dataCompr.setTime(dataComp);

        //se data da compra for inferior a data de validade
        if (dataValid.after(dataCompr)) {
            System.out.println("Vale-Compras dentro da validade!");
            return true;
        }
        System.out.println("Vale-Compras já venceu!");
        return false;
    }

    /**
     * Método exclui vale compra específico
     *
     * @param identificacao
     * @return
     */
    public boolean removerValeCompras(String identificacao) {
        ArrayList<ValeCompras> procuraArray = new ArrayList<>();
        File arq = new File("dadosValeCompras.txt");
        int posicao = 0;
        int aux = 0;

        try {
            //lendo arquivo com dados dos administradores
            FileInputStream file = new FileInputStream(arq);
            ObjectInputStream input = new ObjectInputStream(file);

            procuraArray = (ArrayList) input.readObject();

            for (ValeCompras v : procuraArray) {
                if (v.getIdentificacao().equals(identificacao)) {
                    posicao = procuraArray.indexOf(v);
                    aux = 1;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ValidarValeCompras.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ValidarValeCompras.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ValidarValeCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
        procuraArray.remove(posicao);
        FileOutputStream stream;
        try {
            stream = new FileOutputStream(arq);
            ObjectOutputStream output = new ObjectOutputStream(stream);
            output.writeObject(procuraArray);
            output.flush();
            output.close();
            System.out.println("Vale compras removido com sucesso!");
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ValidarValeCompras.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ValidarValeCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
}

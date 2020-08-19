/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Desktop;
import javax.print.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author USUARIO
 */

public class ImprimirArquivo {

    /**
     *Método imprime arquivo com impressora padrão
     */
    public void imprimeArquivo(String nomeArquivo){
        File f=new File(nomeArquivo);
        try {
            Desktop.getDesktop().print(f);
        } catch (IOException ex) {
            Logger.getLogger(ImprimirArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args){
        ImprimirArquivo imprime=new ImprimirArquivo();
        imprime.imprimeArquivo("dadosClientes.txt");
    }
}



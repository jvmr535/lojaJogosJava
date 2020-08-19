/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yasmi_78vs0ei
 */
public final class Autenticar {

    private static String user, nome, cpf;
    private String type, password;

    public Autenticar(String u, String p) {

        this.user = u;
        this.password = p;

    }

    public Autenticar() {
    }

    
    public String defineTipo() {

        String tipodeLogin = validar();

        return tipodeLogin;
    }
    
    
    
    public String validar() {

        //cliente
        ArrayList<Cliente> procuraCliente = new ArrayList();
        try {
            FileInputStream fileinput = new FileInputStream("dadosClientes.txt");
            ObjectInputStream input = new ObjectInputStream(fileinput);

            procuraCliente = (ArrayList<Cliente>) input.readObject();
            input.close();
            System.out.println("Entrou aqui 1");

        } catch (IOException ex) {
            System.out.println("Entrou aqui 5");
            System.err.println("ERRO AO MANIPULAR ARQUIVO");
        } catch (ClassNotFoundException ex) {
            System.out.println("Entrou aqui 6");
            Logger.getLogger(Autenticar.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Cliente c : procuraCliente) {
            System.out.println(c.getUser());
            System.out.println(c.getSenha());
            System.out.println("Entrou aqui 2");
            if (user.equals(c.getUsername()) && this.getPassword().equals(c.getSenha())) {
                System.out.println("Entrou aqui 3");
                nome = c.getNome();
                setCpf(c.getCPF());
                System.out.println("USUÁRIO ENCONTRADO, ACESSO LIBERADO");
                System.out.println("Entrou aqui 4");
                return "CLIENTE";

            }
        }

        //funcionario
        try {
            FileInputStream fileinput = new FileInputStream("dadosFuncionario.txt");
            ObjectInputStream input = new ObjectInputStream(fileinput);

            ArrayList<Funcionario> procuraFuncionario = new ArrayList();
            procuraFuncionario = (ArrayList) input.readObject();

            for (Funcionario f : procuraFuncionario) {
                if (this.getUser().equals(f.getUser()) && this.getPassword().equals(f.getSenha())) {

                    System.out.println("USUÁRIO ENCONTRADO, ACESSO LIBERADO");
                    return "FUNCIONARIO";

                }
            }
        } catch (IOException ex) {
            System.err.println("ERRO AO MANIPULAR ARQUIVO");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Autenticar.class.getName()).log(Level.SEVERE, null, ex);
        }

        //ADMINISTRADOR
        try {
            FileInputStream fileinput = new FileInputStream("dadosAdministrador.txt");
            ObjectInputStream input = new ObjectInputStream(fileinput);

            ArrayList<Administrador> procuraAdmin = new ArrayList();
            procuraAdmin = (ArrayList) input.readObject();

            for (Administrador admin : procuraAdmin) {
                if (this.getUser().equals(admin.getUser()) && this.getPassword().equals(admin.getSenha())) {

                    System.out.println("USUÁRIO ENCONTRADO, ACESSO LIBERADO");
                    return "ADMINISTRADOR";

                }
            }
        } catch (IOException ex) {
            System.err.println("ERRO AO MANIPULAR ARQUIVO");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Autenticar.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "ERRO";

    }

    

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the user
     */
    public static String getUser() {
        return user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the nome
     */
    public static String getNome() {
        return nome;
    }

    /**
     * @return the cpf
     */
    public static String getCpf() {
        return cpf;
    }

    /**
     * @param aCpf the cpf to set
     */
    public static void setCpf(String aCpf) {
        cpf = aCpf;
    }
}

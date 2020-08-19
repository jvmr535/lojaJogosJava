/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.TextField;
import java.io.Serializable;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

/**
 *
 * @author Rafaela
 */
public class Funcionario extends Pessoa implements Serializable{
    
    private String username;
    private String senha;
    private String DataAdm;
    private String CartTrabalho;

    public Funcionario() {
        super.setNome("");
        super.setCPF("");
        super.setDataNasc("");
        super.setSexo("");
        super.setCelular("");
        super.setEmail("");
        super.setRua ("");
        super.setBairro("");
        super.setComplemento("");
        super.setCidade("");
        super.setEstado("");
        super.setNumero("");
        this.senha = "";
        this.senha = "";
        this.DataAdm = "";
        this.CartTrabalho = "";
    }

    public Funcionario(String nome, String cpf, String dataNasc, String sexo, String celular, String email,
            String DataAdm, String CartTrabalho, String username, String cidade, String bairro, String rua, String numero, 
            String complemento, String estado, String senha) {
        
        super.setNome(nome);
        super.setCPF(cpf);
        super.setDataNasc(dataNasc);
        super.setSexo(sexo);
        super.setCelular(celular);
        super.setEmail(email);
        super.setUser(username);
        this.CartTrabalho = CartTrabalho;
        this.DataAdm = DataAdm;
        super.setRua (rua);
        super.setBairro(bairro);
        super.setComplemento(complemento);
        super.setCidade(cidade);
        super.setEstado(estado);
        super.setNumero(numero);
        this.senha=senha;
    }


    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setDataAdm(String DataAdm) {
        this.DataAdm = DataAdm;
    }

    public void setCartTrabalho(String CartTrabalho) {
        this.CartTrabalho = CartTrabalho;
    }

    public String getUsername() {
        return username;
    }

    public String getSenha() {
        return senha;
    }

    public String getDataAdm() {
        return DataAdm;
    }

    public String getCartTrabalho() {
        return CartTrabalho;
    }

    
    
}

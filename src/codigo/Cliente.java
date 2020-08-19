/**
 * Classe responsável pelos atributos dos clientes.
 */
package codigo;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente extends Pessoa implements Serializable {

   
    private String username;
    private String senha;
    private ArrayList<String>jogoComprado;
    
    public Cliente() {
        super.setNome("");
        super.setCPF("");
        super.setDataNasc("");
        super.setSexo("");
        super.setCelular("");
        super.setEmail("");
        this.username = "";
        this.senha = "";
    }

    public Cliente(String nome, String cpf, String dataNasc, String sexo, String celular, String email, String username,String senha) {
        
        super.setNome(nome);
        super.setCPF(cpf);
        super.setDataNasc(dataNasc);
        super.setSexo(sexo);
        super.setCelular(celular);
        super.setEmail(email);
        this.username = username;
        this.senha = senha;
    }

    public Cliente(String jogoComprado,String cpf) {
        this.jogoComprado.add(jogoComprado);
        super.setCPF(cpf);
    }

    /**
     * 
     * @return the nome
     */
    @Override
    public String getNome() {
        return super.getNome();
    }


    /**
     * @return the cpf
     */
    @Override
    public String getCPF() {
        return super.getCPF();
    }

    /**
     * @return the dataNasc
     */
    @Override
    public String getDataNasc() {
        return super.getDataNasc();
    }

    /**
     * @return the sexo
     */
    @Override
    public String getSexo() {
        return super.getSexo();
    }

    /**
     * @return the celular
     */
    @Override
    public String getCelular() {
        return super.getCelular();
    }


    /**
     * @return the email
     */
    @Override
    public String getEmail() {
        return super.getEmail();
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

}

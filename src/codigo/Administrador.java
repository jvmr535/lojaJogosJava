/**
 * Classe responsável pelos atributos dos clientes.
 */
package codigo;

import java.io.Serializable;


public class Administrador extends Pessoa implements Serializable {

    private String senha, username;

    public Administrador(String user,String nome, String CPF,String dataNasc, String sexo, String rua, String numero, String bairro, String CEP,String cidade, String estado,String celular, String email, String senha) {
        
        super.setUser(user);
        super.setNome(nome);
        super.setCPF(CPF);
        super.setDataNasc(dataNasc);
        super.setSexo(sexo);
        
        super.setRua(rua);
        super.setNumero(numero);
        super.setBairro(bairro);
        super.setCEP(CEP);
        super.setCidade(cidade);
        super.setEstado(estado);
        
        super.setCelular(celular);
        super.setEmail(email);
        this.senha=senha;
   
    }
     /**
     * 
     * @return the email
     */
    
    
    @Override
    public String getEmail(){
        return super.getEmail();
    }
     /**
     * 
     * @return the celular
     */
    @Override
    public String getCelular(){
        return super.getCelular();
    }
     /**
     * 
     * @return the cidade
     */
    @Override
    public String getCidade(){
        return super.getCidade();
    }
     /**
     * 
     * @return the numero
     */
    @Override
    public String getNumero(){
        return super.getNumero();
    }
     /**
     * 
     * @return the rua
     */
    @Override
    public String getRua(){
        return super.getRua();
    }
     /**
     * 
     * @return the sexo
     */
    @Override
    public String getSexo(){
        return super.getSexo();
    }
    /**
     * 
     * @return nome
     */
    @Override
    public String getNome(){
        return super.getNome();
    }
    /**
     * @return CPF
     */
    @Override
    public String getCPF() {
        return super.getCPF();
    }

    /**
     * @return Bairro
     */
    @Override
    public String getBairro() {
        return super.getBairro();
    }

    /**
     * @return the dataNasc
     */
    @Override
    public String getDataNasc() {
        return super.getDataNasc();
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

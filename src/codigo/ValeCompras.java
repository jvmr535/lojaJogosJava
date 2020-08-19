/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.Serializable;

/**
 *
 * @author USUARIO
 */
public class ValeCompras implements Serializable{

    /**
     * @return the identifiacao
     */
    public String getIdentificacao() {
        return identifiacao;
    }

    /**
     * @param identifiacao the identifiacao to set
     */
    public void setIdentifiacao(String identifiacao) {
        this.identifiacao = identifiacao;
    }

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * @return the dataVigor
     */
    public String getDataVigor() {
        return dataVigor;
    }

    /**
     * @param dataVigor the dataVigor to set
     */
    public void setDataVigor(String dataVigor) {
        this.dataVigor = dataVigor;
    }

    /**
     * @return the dataValidade
     */
    public String getDataValidade() {
        return dataValidade;
    }

    /**
     * @param dataValidade the dataValidade to set
     */
    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }
    private String identifiacao;
    private String valor;
    private String dataVigor;
    private String dataValidade;
    
    public ValeCompras(String identificacao,String valor,String dataVigor, String dataValidade){
        this.identifiacao=identificacao;
        this.valor=valor;
        this.dataVigor=dataVigor;
        this.dataValidade=dataValidade;
    }
    
    
}

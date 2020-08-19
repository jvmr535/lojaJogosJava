/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.Serializable;

/**
 *
 * @author Cida Siqueira
 */
public class Relatorio implements Serializable{
    
    private String nomeJogo;
    private String quantidade;//quantidade atual do estoque
    private String estoque;//quantidade inicial do estoque
    private String totalVen;
    private String valorTotal;
    private String valTotalDoJogo;

    public Relatorio(String nomeJogo, String quantidade, String estoque, String totalVen, String valorTotal, String valTotalDoJogo) {
        this.nomeJogo = nomeJogo;
        this.quantidade = quantidade;
        this.estoque = estoque;
        this.totalVen = totalVen;
        this.valorTotal = valorTotal;
        this.valTotalDoJogo = valTotalDoJogo;
    }

    public String getNomeJogo() {
        return nomeJogo;
    }

    public void setNomeJogo(String nomeJogo) {
        this.nomeJogo = nomeJogo;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getEstoque() {
        return estoque;
    }

    public void setEstoque(String estoque) {
        this.estoque = estoque;
    }

    public String getTotalVen() {
        return totalVen;
    }

    public void setTotalVen(String totalVen) {
        this.totalVen = totalVen;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getValTotalDoJogo() {
        return valTotalDoJogo;
    }

    public void setValTotalDoJogo(String valTotalDoJogo) {
        this.valTotalDoJogo = valTotalDoJogo;
    }
    
    
}

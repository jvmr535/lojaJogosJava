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
public class CompraPendente implements Serializable{

    

     
    private String nomeCliente;
    private String nomeUser;
    private String jogo;
    private String quantidade;
    private String dataCompra;
    private String precoUnitario;
    private String valorPago;
    private String valorRestante;
    private String formaPgtoPago;
    private String precoTotal;
    private String midia;
    private String status;
    private String cpf;
    private String formaPagtoRestante;

    public CompraPendente(String nomeCliente, String nomeUser,String jogo, String qtde, String dataCompra,String precoUnitario, String valorPago, String valorRestante, String formaPgtoPago, String precoTotal,
            String midia, String status,String cpf, String formaPgtoRestante) {
        this.nomeCliente = nomeCliente;
        this.nomeUser=nomeUser;
        this.jogo = jogo;
        this.quantidade = qtde;
        this.dataCompra = dataCompra;
        this.precoUnitario=precoUnitario;
        this.valorPago = valorPago;
        this.valorRestante = valorRestante;
        this.formaPgtoPago = formaPgtoPago;
        this.precoTotal = precoTotal;
        this.midia = midia;
        this.status = status;
        this.cpf = cpf;
        this.formaPagtoRestante = formaPgtoRestante;
    }  
    
    /**
     * @return the precoUnitario
     */
    public String getPrecoUnitario() {
        return precoUnitario;
    }

    /**
     * @param precoUnitario the precoUnitario to set
     */
    public void setPrecoUnitario(String precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
    
        /**
     * @return the nomeCliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * @param nomeCliente the nomeCliente to set
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    
    /**
     * @return the nomeUser
     */
    public String getNomeUser() {
        return nomeUser;
    }

    /**
     * @param nomeUser the nomeUser to set
     */
    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
    }
    
    /**
     * @return the jogo
     */
    public String getJogo() {
        return jogo;
    }

    /**
     * @param jogo the jogo to set
     */
    public void setJogo(String jogo) {
        this.jogo = jogo;
    }

    /**
     * @return the quantidade
     */
    public String getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the dataCompra
     */
    public String getDataCompra() {
        return dataCompra;
    }

    /**
     * @param dataCompra the dataCompra to set
     */
    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    /**
     * @return the valorPago
     */
    public String getValorPago() {
        return valorPago;
    }

    /**
     * @param valorPago the valorPago to set
     */
    public void setValorPago(String valorPago) {
        this.valorPago = valorPago;
    }

    /**
     * @return the valorRestante
     */
    public String getValorRestante() {
        return valorRestante;
    }

    /**
     * @param valorRestante the valorRestante to set
     */
    public void setValorRestante(String valorRestante) {
        this.valorRestante = valorRestante;
    }

    /**
     * @return the formaPgtoPago
     */
    public String getFormaPgtoPago() {
        return formaPgtoPago;
    }

    /**
     * @param formaPgtoPago the formaPgtoPago to set
     */
    public void setFormaPgtoPago(String formaPgtoPago) {
        this.formaPgtoPago = formaPgtoPago;
    }

   

    /**
     * @return the midia
     */
    public String getMidia() {
        return midia;
    }

    /**
     * @param midia the midia to set
     */
    public void setMidia(String midia) {
        this.midia = midia;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the formaPagtoRestante
     */
    public String getFormaPagtoRestante() {
        return formaPagtoRestante;
    }

    /**
     * @param formaPagtoRestante the formaPagtoRestante to set
     */
    public void setFormaPagtoRestante(String formaPagtoRestante) {
        this.formaPagtoRestante = formaPagtoRestante;
    }

    /**
     * @return the precoTotal
     */
    public String getPrecoTotal() {
        return precoTotal;
    }

    /**
     * @param precoTotal the precoTotal to set
     */
    public void setPrecoTotal(String precoTotal) {
        this.precoTotal = precoTotal;
    }

}

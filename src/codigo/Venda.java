package codigo;
    
import java.io.Serializable;

public class Venda implements Serializable{
    private String nomeJogo;
    private String preco;
    private String midia;
    private String formaPgto;
    private String dataCompra;
    private String user;
    private String quantidade;
    private String precoUnitario;
    private String precoTotal;
    private String status;

    public Venda(String nome, String preco, String midia, String formaPgto) {
        this.nomeJogo = nome;
        this.preco = preco;
        this.midia = midia;
        this.formaPgto = formaPgto;
    }
    
    public Venda(String user,String jogo,String precoUnitario, String qtde,String precoTotal, String dataCompra, String formaPgto,String midia,String status) {
        this.user=user;
        this.nomeJogo = jogo;
        this.precoUnitario = precoUnitario;
        this.quantidade=qtde;
        this.precoTotal=precoTotal;
        this.dataCompra=dataCompra;
        this.midia = midia;
        this.formaPgto = formaPgto;
        this.status=status;
        
    }
    
    public String getNome() {
        return nomeJogo;
    }

    public void setNome(String nome) {
        this.nomeJogo = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getMidia() {
        return midia;
    }

    public void setMidia(String midia) {
        this.midia = midia;
    }

    public String getFormaPgto() {
        return formaPgto;
    }

    public void setFormaPgto(String formaPgto) {
        this.formaPgto = formaPgto;
    }
    
    public String getDataCompra(){
        return dataCompra;
    }
    
    public void setDataCompra(String dataCompra){
        this.dataCompra=dataCompra;
    }
}
package codigo;

import java.io.Serializable;

/**
 *
 * @author joaov
 */
public class Jogo implements Serializable{
    
    private String nome;
    private String censura;
    private String categoria;
    private String desenvolvedora;
    private String descricao;
    private String quantidade;// quantidade disponivel no estoque
    private String preco;
    private String estoque;// estoque inicial
    private String tipo; // Se é um jogo nativo ou DLC
   
    

    public Jogo(String nome, String censura, String categoria, String desenvolvedora, String descricao,
            String quantidade, String preco, String estoque, String tipo) {
        this.nome = nome;
        this.censura = censura;
        this.categoria = categoria;
        this.desenvolvedora = desenvolvedora;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
        this.estoque = estoque;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getEstoque() {
        return estoque;
    }

    public void setEstoque(String estoque) {
        this.estoque = estoque;
    }
    
    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nomeOficial) {
        this.nome = nome;
    }

    public String getCensura() {
        return censura;
    }

    public void setCensura(String censura) {
        this.censura = censura;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDesenvolvedora() {
        return desenvolvedora;
    }

    public void setDesenvolvedora(String desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}


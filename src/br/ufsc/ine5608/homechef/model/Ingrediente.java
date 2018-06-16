package br.ufsc.ine5608.homechef.model;

import br.ufsc.ine5608.homechef.dto.DadosIngrediente;
import java.io.Serializable;

public class Ingrediente implements Serializable {
    
    private static final long serialVersionUID = 1L;

    protected int id;
    protected String nome;
    protected double preco;
    protected Unidade unidade;
    protected Unidade unidadePreco;
    protected int quantidadePreco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public Unidade getUnidadePreco() {
        return unidadePreco;
    }

    public void setUnidadePreco(Unidade unidadePreco) {
        this.unidadePreco = unidadePreco;
    }

    public int getQuantidadePreco() {
        return quantidadePreco;
    }

    public void setQuantidadePreco(int quantidadePreco) {
        this.quantidadePreco = quantidadePreco;
    }
    
    public DadosIngrediente getDTO() {
        return new DadosIngrediente(id, nome, preco, unidade.getId(), unidadePreco.getId(), quantidadePreco);
    }
    
}

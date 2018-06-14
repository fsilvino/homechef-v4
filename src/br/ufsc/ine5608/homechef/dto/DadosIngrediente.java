package br.ufsc.ine5608.homechef.dto;

import br.ufsc.ine5608.homechef.model.Unidade;

/**
 * Classe que encapsula os dados a serem enviados pela tela ao controlador
 * (Data Transfer Object)
 * @author Flávio
 */
public class DadosIngrediente {

    public Integer idIngrediente;
    public String nome;
    public Double preco;
    public Unidade unidade;
    public Unidade unidadePreco;
    public Integer quantidadePreco;
    
    public DadosIngrediente() {

    }

    public DadosIngrediente(Integer idIngrediente, String nome, Double preco, Unidade unidade, Unidade unidadePreco, Integer quantidadePreco) {
        this.idIngrediente = idIngrediente;
        this.nome = nome;
        this.preco = preco;
        this.unidade = unidade;
        this.unidadePreco = unidadePreco;
        this.quantidadePreco = quantidadePreco;
    }
    
}

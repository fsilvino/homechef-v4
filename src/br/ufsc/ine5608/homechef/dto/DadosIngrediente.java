package br.ufsc.ine5608.homechef.dto;

import br.ufsc.ine5608.homechef.model.Unidade;

/**
 * Classe que encapsula os dados a serem enviados pela tela ao controlador
 * (Data Transfer Object)
 * @author Flávio
 */
public class DadosIngrediente {

    public int id;
    public String nome;
    public double preco;
    public int idUnidade;
    public int idUnidadePreco;
    public int quantidadePreco;
    
    public DadosIngrediente() {

    }

    public DadosIngrediente(int id, String nome, double preco, int idUnidade, int idUnidadePreco, int quantidadePreco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.idUnidade = idUnidade;
        this.idUnidadePreco = idUnidadePreco;
        this.quantidadePreco = quantidadePreco;
    }
    
}

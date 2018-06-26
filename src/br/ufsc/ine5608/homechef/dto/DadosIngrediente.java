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
    public Unidade unidade;
    public Unidade unidadePreco;
    public int quantidadePreco;
    
    public DadosIngrediente() {

    }

    public DadosIngrediente(int id, String nome, double preco, Unidade unidade, Unidade unidadePreco, int quantidadePreco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.unidade = unidade;
        this.unidadePreco = unidadePreco;
        this.quantidadePreco = quantidadePreco;
    }
    
    public double getPrecoParaUnidade(Unidade unidade) throws Exception {
        int qtd = 1;
        if (unidade.getId() != this.unidadePreco.getId()) {
            qtd = this.unidadePreco.getQuantidadeEquivalente(unidade);
        }
        return preco / quantidadePreco * qtd;
    }
    
}

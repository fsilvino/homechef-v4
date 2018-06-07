package br.ufsc.ine5608.homechef.model;

public class Ingrediente {

    protected Integer idIngrediente;
    protected String nome;
    protected Double preco;
    protected Unidade unidade;
    protected Unidade unidadePreco;
    protected Integer quantidadePreco;

    public Integer getIdIngrediente() {
        return idIngrediente;
    }

    public Ingrediente setIdIngrediente(Integer idIngrediente) {
        this.idIngrediente = idIngrediente;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Ingrediente setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Double getPreco() {
        return preco;
    }

    public Ingrediente setPreco(Double preco) {
        this.preco = preco;
        return this;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public Ingrediente setUnidade(Unidade unidade) {
        this.unidade = unidade;
        return this;
    }

    public Unidade getUnidadePreco() {
        return unidadePreco;
    }

    public Ingrediente setUnidadePreco(Unidade unidadePreco) {
        this.unidadePreco = unidadePreco;
        return this;
    }

    public Integer getQuantidadePreco() {
        return quantidadePreco;
    }

    public Ingrediente setQuantidadePreco(Integer quantidadePreco) {
        this.quantidadePreco = quantidadePreco;
        return this;
    }

    @Override
    public String toString() {
        return "Ingrediente{" +
                "idIngrediente=" + idIngrediente +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", unidade=" + unidade +
                ", unidadePreco=" + unidadePreco +
                ", quantidadePreco=" + quantidadePreco +
                '}';
    }
}

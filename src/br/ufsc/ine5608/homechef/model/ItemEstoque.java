package br.ufsc.ine5608.homechef.model;

import java.time.LocalDate;

public class ItemEstoque {

    protected Integer idItemEstoque;
    protected Unidade unidade;
    protected Ingrediente ingrediente;
    protected LocalDate validade;
    protected Integer quantidade;

    public Integer getIdItemEstoque() {
        return idItemEstoque;
    }

    public ItemEstoque setIdItemEstoque(Integer idItemEstoque) {
        this.idItemEstoque = idItemEstoque;
        return this;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public ItemEstoque setUnidade(Unidade unidade) {
        this.unidade = unidade;
        return this;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public ItemEstoque setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
        return this;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public ItemEstoque setValidade(LocalDate validade) {
        this.validade = validade;
        return this;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public ItemEstoque setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }
}

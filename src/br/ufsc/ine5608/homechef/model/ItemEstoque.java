package br.ufsc.ine5608.homechef.model;

import br.ufsc.ine5608.homechef.controller.ControladorUnidade;
import br.ufsc.ine5608.homechef.dto.DadosItemEstoque;

import java.io.Serializable;
import java.time.LocalDate;

public class ItemEstoque implements Serializable {
    
    private static final long serialVersionUID = 2L;

    protected int id;
    protected Unidade unidade;
    protected Ingrediente ingrediente;
    protected LocalDate validade;
    protected int quantidade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public DadosItemEstoque getDTO() {
        int quantidadeEquivalente = 1;
        try {
            quantidadeEquivalente = unidade.getQuantidadeEquivalente(ControladorUnidade.getInstance().getUnidadeBase(unidade));
        } catch (Exception e) {
        }
        float quantidade = (float) this.quantidade / quantidadeEquivalente;
        float decimal = quantidade - (int) quantidade;
        if (decimal > 0) {
            return new DadosItemEstoque(id, ControladorUnidade.getInstance().getUnidadeBase(unidade), ingrediente, validade, this.quantidade);
        }
        return new DadosItemEstoque(id, unidade, ingrediente, validade, (int) quantidade);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5608.homechef.model;

import br.ufsc.ine5608.homechef.dto.DadosIngredienteReceita;

/**
 *
 * @author Flávio
 */
public class IngredienteReceita {
    
    private int id;
    private float quantidade;
    private Unidade unidade;
    private Ingrediente ingrediente;

    public IngredienteReceita() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
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
    
    public DadosIngredienteReceita getDTO() {
        return new DadosIngredienteReceita(id, quantidade, unidade, ingrediente.getDTO());
    }
    
}

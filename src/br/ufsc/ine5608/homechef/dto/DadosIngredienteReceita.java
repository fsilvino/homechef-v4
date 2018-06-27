/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5608.homechef.dto;

import br.ufsc.ine5608.homechef.model.Unidade;

/**
 *
 * @author Flávio
 */
public class DadosIngredienteReceita {
    
    public int id;
    public float quantidade;
    public Unidade unidade;
    public DadosIngrediente ingrediente;

    public DadosIngredienteReceita() {
        id = 0;
    }

    public DadosIngredienteReceita(int id, float quantidade, Unidade unidade, DadosIngrediente ingrediente) {
        this.id = id;
        this.quantidade = quantidade;
        this.unidade = unidade;
        this.ingrediente = ingrediente;
    }
    
    public double getCustoEstimado() throws Exception {
        double custo = 0.0d;
        if (unidade != null && ingrediente != null) {
            custo = ingrediente.getPrecoParaUnidade(unidade) * quantidade;
        }
        return custo;
    } 
    
}
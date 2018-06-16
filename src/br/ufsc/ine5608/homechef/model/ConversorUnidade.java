/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5608.homechef.model;

import java.io.Serializable;

/**
 *
 * @author Flávio
 */
public class ConversorUnidade implements Serializable {
    
    protected Unidade subunidade;
    protected int quantidadeEquivalente;
    
    public ConversorUnidade() {
        
    }

    public ConversorUnidade(Unidade subunidade, int quantidadeEquivalente) {
        this.subunidade = subunidade;
        this.quantidadeEquivalente = quantidadeEquivalente;
    }

    public Unidade getSubunidade() {
        return subunidade;
    }

    public void setSubunidade(Unidade subunidade) {
        this.subunidade = subunidade;
    }

    public int getQuantidadeEquivalente() {
        return quantidadeEquivalente;
    }

    public void setQuantidadeEquivalente(int quantidadeEquivalente) {
        this.quantidadeEquivalente = quantidadeEquivalente;
    }
    
}

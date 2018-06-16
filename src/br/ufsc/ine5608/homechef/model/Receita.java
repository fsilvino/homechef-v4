package br.ufsc.ine5608.homechef.model;

import java.io.Serializable;
import java.util.Collection;

public class Receita implements Serializable {
    
    private static final long serialVersionUID = 1L;

    protected int id;
    protected Dificuldade dificuldade;
    protected String modoPreparo;
    protected String nome;
    protected int tempo;
    protected Collection<Ingrediente> ingredientes;

    public int getId() {
        return id;
    }

    public void setIdReceita(int id) {
        this.id = id;
    }

    public Dificuldade getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(Dificuldade dificuldade) {
        this.dificuldade = dificuldade;
    }

    public String getModoPreparo() {
        return modoPreparo;
    }

    public void setModoPreparo(String modoPreparo) {
        this.modoPreparo = modoPreparo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public Collection<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Collection<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
    
}
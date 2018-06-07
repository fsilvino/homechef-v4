package br.ufsc.ine5608.homechef.model;

import java.util.Collection;

public class Receita {

    protected Integer idReceita;
    protected Dificuldade dificuldade;
    protected String modoPreparo;
    protected String nome;
    protected Integer tempo;
    protected Collection<Ingrediente> ingredientes;

    public Integer getIdReceita() {
        return idReceita;
    }

    public Receita setIdReceita(Integer idReceita) {
        this.idReceita = idReceita;
        return this;
    }

    public Dificuldade getDificuldade() {
        return dificuldade;
    }

    public Receita setDificuldade(Dificuldade dificuldade) {
        this.dificuldade = dificuldade;
        return this;
    }

    public String getModoPreparo() {
        return modoPreparo;
    }

    public Receita setModoPreparo(String modoPreparo) {
        this.modoPreparo = modoPreparo;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Receita setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Integer getTempo() {
        return tempo;
    }

    public Receita setTempo(Integer tempo) {
        this.tempo = tempo;
        return this;
    }

    public Collection<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public Receita setIngredientes(Collection<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
        return this;
    }

    @Override
    public String toString() {
        return "Receita{" +
                "idReceita=" + idReceita +
                ", dificuldade=" + dificuldade +
                ", modoPreparo='" + modoPreparo + '\'' +
                ", nome='" + nome + '\'' +
                ", tempo=" + tempo +
                '}';
    }
}

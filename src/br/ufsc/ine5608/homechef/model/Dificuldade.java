package br.ufsc.ine5608.homechef.model;

import java.io.Serializable;

public class Dificuldade implements Serializable {
    
    private static final long serialVersionUID = 2L;

    protected int id;
    protected String nome;

    public Dificuldade() {
    }

    public Dificuldade(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
    
}

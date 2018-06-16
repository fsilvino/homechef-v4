package br.ufsc.ine5608.homechef.model;

import java.io.Serializable;

public class Dificuldade implements Serializable {
    
    private static final long serialVersionUID = 1L;

    protected int id;
    protected String nome;

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
}

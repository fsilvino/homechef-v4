package br.ufsc.ine5608.homechef.model;

public class Dificuldade {

    protected Integer idDificuldade;
    protected String nome;

    public Integer getIdDificuldade() {
        return idDificuldade;
    }

    public Dificuldade setIdDificuldade(Integer idDificuldade) {
        this.idDificuldade = idDificuldade;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Dificuldade setNome(String nome) {
        this.nome = nome;
        return this;
    }
}

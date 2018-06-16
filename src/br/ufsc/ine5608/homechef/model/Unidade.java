package br.ufsc.ine5608.homechef.model;

public class Unidade {

    protected int id;
    protected String nomePlural;
    protected String nomeSingular;
    protected String unidade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomePlural() {
        return nomePlural;
    }

    public void setNomePlural(String nomePlural) {
        this.nomePlural = nomePlural;
    }

    public String getNomeSingular() {
        return nomeSingular;
    }

    public void setNomeSingular(String nomeSingular) {
        this.nomeSingular = nomeSingular;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
    
}

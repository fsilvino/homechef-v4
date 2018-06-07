package br.ufsc.ine5608.homechef.model;

public class Unidade {

    protected Integer idUnidade;
    protected String nomePlural;
    protected String nomeSingular;
    protected String unidade;

    public Integer getIdUnidade() {
        return idUnidade;
    }

    public Unidade setIdUnidade(Integer idUnidade) {
        this.idUnidade = idUnidade;
        return this;
    }

    public String getNomePlural() {
        return nomePlural;
    }

    public Unidade setNomePlural(String nomePlural) {
        this.nomePlural = nomePlural;
        return this;
    }

    public String getNomeSingular() {
        return nomeSingular;
    }

    public Unidade setNomeSingular(String nomeSingular) {
        this.nomeSingular = nomeSingular;
        return this;
    }

    public String getUnidade() {
        return unidade;
    }

    public Unidade setUnidade(String unidade) {
        this.unidade = unidade;
        return this;
    }

    @Override
    public String toString() {
        return "Unidade{" +
                "idUnidade=" + idUnidade +
                ", nomePlural='" + nomePlural + '\'' +
                ", nomeSingular='" + nomeSingular + '\'' +
                ", unidade='" + unidade + '\'' +
                '}';
    }
}

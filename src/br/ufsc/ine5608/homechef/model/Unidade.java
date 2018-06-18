package br.ufsc.ine5608.homechef.model;

import java.io.Serializable;
import java.util.HashMap;

public class Unidade implements Serializable {
    
    private static final long serialVersionUID = 1L;

    protected int id;
    protected String nomePlural;
    protected String nomeSingular;
    protected String unidade;
    protected HashMap<Integer, ConversorUnidade> conversores;
    
    public Unidade() {
        conversores = new HashMap<>();
    }
    
    public Unidade(int id, String nomeSingular, String nomePlural, String unidade) {
        this();
        this.id = id;
        this.nomeSingular = nomeSingular;
        this.nomePlural = nomePlural;
        this.unidade = unidade;
    }

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
    
    public void addSubunidade(Unidade subunidade, int quantidadeEquivalente) {
        if (!this.conversores.containsKey(subunidade.getId())) {
            this.conversores.put(subunidade.getId(), new ConversorUnidade(subunidade, quantidadeEquivalente));
        } else {
            ConversorUnidade conversor = this.conversores.get(subunidade.getId());
            conversor.setQuantidadeEquivalente(quantidadeEquivalente);
        }
    }
    
    public void removeSubunidade(Unidade subunidade) {
        this.conversores.remove(subunidade.getId());
    }
    
    public HashMap<Integer, ConversorUnidade> getConversores() {
        return this.conversores;
    }

    @Override
    public String toString() {
        return nomeSingular + " (" + unidade + ")";
    }
    
    
    
}

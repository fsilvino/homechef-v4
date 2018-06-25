package br.ufsc.ine5608.homechef.dto;

import br.ufsc.ine5608.homechef.model.Dificuldade;
import java.util.Collection;

/**
 * Classe que encapsula os dados a serem enviados pela tela ao controlador
 * (Data Transfer Object)
 * @author Flávio
 */
public class DadosReceita {

    public Integer idReceita;
    public Dificuldade dificuldade;
    public String modoPreparo;
    public String nome;
    public Integer tempo;
    public Collection<DadosIngrediente> ingredientes;
    
    public DadosReceita() {
        
    }

    public DadosReceita(Integer idReceita, Dificuldade dificuldade, String modoPreparo, String nome, Integer tempo, Collection<DadosIngrediente> ingredientes) {
        this.idReceita = idReceita;
        this.dificuldade = dificuldade;
        this.modoPreparo = modoPreparo;
        this.nome = nome;
        this.tempo = tempo;
        this.ingredientes = ingredientes;
    }
    
}

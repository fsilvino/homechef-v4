package br.ufsc.ine5608.homechef.dto;

import br.ufsc.ine5608.homechef.model.Dificuldade;
import br.ufsc.ine5608.homechef.model.Ingrediente;
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
    public Collection<Ingrediente> ingredientes;
    
    public DadosReceita() {

    }
    
}

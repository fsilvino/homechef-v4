package br.ufsc.ine5608.homechef.dto;

import br.ufsc.ine5608.homechef.model.Ingrediente;
import br.ufsc.ine5608.homechef.model.Unidade;

import java.time.LocalDate;

/**
 * Classe que encapsula os dados a serem enviados pela tela ao controlador
 * (Data Transfer Object)
 * @author Flávio
 */
public class DadosItemEstoque {

    public int id;
    public Unidade unidade;
    public Ingrediente ingrediente;
    public LocalDate validade;
    public int quantidade;

    public DadosItemEstoque() {
    }

    public DadosItemEstoque(int id, Unidade unidade, Ingrediente ingrediente, LocalDate validade, int quantidade) {
        this.id = id;
        this.unidade = unidade;
        this.ingrediente = ingrediente;
        this.validade = validade;
        this.quantidade = quantidade;
    }
}

package br.ufsc.ine5608.homechef.controller;

import br.ufsc.ine5608.homechef.dto.DadosItemEstoque;
import br.ufsc.ine5608.homechef.dto.DadosReceita;
import br.ufsc.ine5608.homechef.model.Dificuldade;
import br.ufsc.ine5608.homechef.view.MainForm;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author diogo
 */
public class ControladorPrincipal {
    
    
    private static ControladorPrincipal instance;
    private MainForm telaPrincipal;
    private ArrayList<Dificuldade> dificuldades;

    private ControladorPrincipal() {
        dificuldades = ControladorDificuldade.getInstance().getAll();
        dificuldades.add(0, new Dificuldade(0, "Todas"));
    }

    public static ControladorPrincipal getInstance() {
        if (instance == null) {
            instance = new ControladorPrincipal();
        }
        return instance;
    }
    
    public void inicia() {
        telaPrincipal = new MainForm();
        telaPrincipal.setVisible(true);
        atualizaTelaPrincipal();
    }
    
    public void atualizaTelaPrincipal() {
        setDadosTelaPrincipal();
    }
    
    
    private void setDadosTelaPrincipal () {
        atualizaItensEstoque();
        atualizaReceitas();
    }
    
    public void atualizaItensEstoque() {
        List<DadosItemEstoque> estoque = ControladorItemEstoque.getInstance().getListaDTO();
        telaPrincipal.setItensEstoque(estoque);
    }
    
    public void atualizaReceitas() {
        ArrayList<DadosReceita> resultado = new ArrayList<>();
        List<DadosReceita> receitas = ControladorReceita.getInstance().getListaDTO();
        Dificuldade dificuldade = this.dificuldades.get(telaPrincipal.getIndexDificuldade());
        for (DadosReceita receita : receitas) {
            if ((dificuldade.getId() == 0 || receita.dificuldade.getId() == dificuldade.getId())) {
                resultado.add(receita);
            }
        }
        telaPrincipal.setReceitas(resultado);
    }
    
}

package br.ufsc.ine5608.homechef.controller;

import br.ufsc.ine5608.homechef.dto.DadosItemEstoque;
import br.ufsc.ine5608.homechef.dto.DadosReceita;
import br.ufsc.ine5608.homechef.view.MainForm;
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

    private ControladorPrincipal() {
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
        List<DadosReceita> receitas = ControladorReceita.getInstance().getListaDTO();
        List<DadosItemEstoque> estoque = ControladorItemEstoque.getInstance().getListaDTO();
        this.telaPrincipal.setDados(receitas, estoque);
    }
    
}

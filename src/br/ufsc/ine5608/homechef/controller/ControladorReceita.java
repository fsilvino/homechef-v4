/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5608.homechef.controller;

import br.ufsc.ine5608.homechef.dto.DadosReceita;
import br.ufsc.ine5608.homechef.model.Receita;
import br.ufsc.ine5608.homechef.persistencia.ReceitaDAO;
import br.ufsc.ine5608.homechef.view.FmListarReceitas;
import br.ufsc.ine5608.homechef.view.FmCadastrarReceita;
import java.util.List;

/**
 *
 * @author Flávio
 */
public class ControladorReceita extends ControladorCadastro<FmListarReceitas, FmCadastrarReceita, ReceitaDAO, Receita, DadosReceita> {

    @Override
    protected FmListarReceitas instanciaTelaTable() {
        return new FmListarReceitas();
    }

    @Override
    protected FmCadastrarReceita instanciaTelaCadastro() {
        return new FmCadastrarReceita();
    }

    @Override
    protected boolean valida(DadosReceita item) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void salvaInclusao(DadosReceita item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void salvaAlteracao(DadosReceita item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void executaExclusao(DadosReceita item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<DadosReceita> getListaDTO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected ReceitaDAO getDao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}

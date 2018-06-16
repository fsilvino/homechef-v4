/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5608.homechef.persistencia;

import br.ufsc.ine5608.homechef.model.Receita;

/**
 *
 * @author Flávio
 */
public class ReceitaDAO extends BaseDAO<Receita> {

    private static ReceitaDAO instance;
    
    public static ReceitaDAO getInstance() {
        if (instance == null) {
            instance = new ReceitaDAO();
        }
        return instance;
    }

    private ReceitaDAO() {
        super();
    }
    
    @Override
    protected String getFileName() {
        return "receita.hc";
    }

    @Override
    protected void initializeData() {
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5608.homechef.controller;

import br.ufsc.ine5608.homechef.model.Unidade;
import br.ufsc.ine5608.homechef.persistencia.UnidadeDAO;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Flávio
 */
public class ControladorUnidade {

    private static ControladorUnidade instance;
    
    private ControladorUnidade() {
        
    }
    
    public static ControladorUnidade getInstance() {
        if (instance == null) {
            instance = new ControladorUnidade();
        }
        return instance;
    }
    
    public Unidade get(int id) {
        return UnidadeDAO.getInstance().get(id);
    }
    
    public Collection<Unidade> getList() {
        return UnidadeDAO.getInstance().getList();
    }
    
    public Collection<Unidade> getUnidadesRelacionadas(int idUnidade) {
        Collection<Unidade> relacionadas = new ArrayList<>();
        
        for (Unidade unidade : getList()) {
            if (unidade.getConversores().containsKey(idUnidade)) {
                relacionadas.add(unidade);
            }
        }
        
        return relacionadas;
    }
    
}

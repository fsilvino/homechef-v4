/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5608.homechef.controller;

import br.ufsc.ine5608.homechef.model.Dificuldade;
import br.ufsc.ine5608.homechef.persistencia.DificuldadeDAO;
import java.util.ArrayList;

/**
 *
 * @author Flávio
 */
public class ControladorDificuldade {
    
    private static ControladorDificuldade instance;
    
    private ControladorDificuldade() {
        
    }
    
    public static ControladorDificuldade getInstance() {
        if (instance == null) {
            instance = new ControladorDificuldade();
        }
        return instance;
    }
    
    public ArrayList<Dificuldade> getAll() {
        return new ArrayList<>(DificuldadeDAO.getInstance().getList());
    }
    
}

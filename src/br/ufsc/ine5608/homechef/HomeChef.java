/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5608.homechef;

import br.ufsc.ine5608.homechef.controller.ControladorIngrediente;
import br.ufsc.ine5608.homechef.controller.ControladorItemEstoque;
import br.ufsc.ine5608.homechef.controller.ControladorReceita;

/**
 *
 * @author Flávio
 */
public class HomeChef {
    
    public static void main(String[] args) {
//        ControladorItemEstoque.getInstance().inicia();
//        ControladorIngrediente.getInstance().inicia();
        ControladorReceita.getInstance().inicia();
    }
    
}

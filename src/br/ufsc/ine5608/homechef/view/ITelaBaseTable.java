/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5608.homechef.view;

import java.util.Observable;

/**
 *
 * @author Flávio
 */
public interface ITelaBaseTable {
    
    void addObserver(ITelaBaseTableObserver observer);
    void removeObserver(ITelaBaseTableObserver observer);
    
    
}

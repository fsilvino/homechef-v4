package br.ufsc.ine5608.homechef.view;

import br.ufsc.ine5608.homechef.model.Unidade;

/**
 *
 * @author Flávio
 */
public interface ITelaItemEstoqueObserver {
    
    public void salvaCadastro();
    public void salvaSaida(int quantidade, Unidade unidade);
}

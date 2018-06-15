package br.ufsc.ine5608.homechef.view;

/**
 * 
 * @author Flávio
 * @param <E>
 */
public interface ITelaBaseTableObserver<E> {
    
    public void inclui();
    public void altera(E item);
    public void exclui(E item);
    
}

package br.ufsc.ine5608.homechef.controller;

import br.ufsc.ine5608.homechef.persistencia.BaseDAO;
import br.ufsc.ine5608.homechef.view.AcoesCadastro;
import br.ufsc.ine5608.homechef.view.FmBaseCadastro;
import br.ufsc.ine5608.homechef.view.FmBaseTable;
import br.ufsc.ine5608.homechef.view.ITelaBaseCadastroObserver;
import br.ufsc.ine5608.homechef.view.ITelaBaseTableObserver;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Flávio
 * @param <TTb> 
 * @param <TCad>
 * @param <E>
 * @param <DTO>
 */
public abstract class ControladorCadastro<TTb extends FmBaseTable<DTO>, TCad extends FmBaseCadastro<DTO>, DAO extends BaseDAO<E>, E, DTO> 
            implements ITelaBaseTableObserver<DTO>, ITelaBaseCadastroObserver {
    
    protected TTb telaTb;
    protected TCad telaCad;

    public ControladorCadastro() {
        this.telaTb = this.instanciaTelaTable();
        this.telaTb.setObserver(this);
        this.telaCad = this.instanciaTelaCadastro();
        this.telaCad.setObserver(this);
    }
    
    protected abstract TTb instanciaTelaTable();
    protected abstract TCad instanciaTelaCadastro();
    protected abstract boolean valida(DTO item) throws Exception;
    protected abstract void salvaInclusao(DTO item);
    protected abstract void salvaAlteracao(DTO item);
    protected abstract void executaExclusao(DTO item);
    protected abstract List<DTO> getListaDTO();
    protected abstract DAO getDao();
    
    public void inicia() {
        this.telaTb.setVisible(true);
        this.atualizaListaTela();
    }

    @Override
    public void inclui() {
        this.telaCad.abreInclusao();
    }

    @Override
    public void altera(DTO item) {
        this.telaCad.abreAlteracao(item);
    }
    
    protected String getMensagemConfirmacaoExclusao(DTO item) {
        return "Deseja realmente excluir?";
    }

    @Override
    public void exclui(DTO item) {
        if (JOptionPane.showConfirmDialog(null, this.getMensagemConfirmacaoExclusao(item), "Confirmação", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            executaExclusao(item);
            this.atualizaListaTela();
        }
    }

    @Override
    public void salvaCadastro(String acao) {
        try {
            DTO item = this.telaCad.getDados();
            if (this.valida(item)) {
                if (AcoesCadastro.ACAO_INCLUI.equals(acao)) {
                    this.salvaInclusao(item);
                } else if (AcoesCadastro.ACAO_ALTERA.equals(acao)) {
                    this.salvaAlteracao(item);
                }
                this.atualizaListaTela();
            }    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    protected void atualizaListaTela() {
        this.telaTb.setLista(this.getListaDTO());
    }
    
}

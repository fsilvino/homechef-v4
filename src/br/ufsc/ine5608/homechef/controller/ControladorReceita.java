/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5608.homechef.controller;

import br.ufsc.ine5608.homechef.dto.DadosIngredienteReceita;
import br.ufsc.ine5608.homechef.dto.DadosReceita;
import br.ufsc.ine5608.homechef.model.IngredienteReceita;
import br.ufsc.ine5608.homechef.model.Receita;
import br.ufsc.ine5608.homechef.persistencia.IngredienteDAO;
import br.ufsc.ine5608.homechef.persistencia.ReceitaDAO;
import br.ufsc.ine5608.homechef.view.FmListarReceitas;
import br.ufsc.ine5608.homechef.view.FmCadastrarReceita;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Flávio
 */
public class ControladorReceita extends ControladorCadastro<FmListarReceitas, FmCadastrarReceita, ReceitaDAO, Receita, DadosReceita> {

    private static ControladorReceita instance;
    
    private ControladorReceita() {
        super();
    }
    
    public static ControladorReceita getInstance() {
        if (instance == null) {
            instance = new ControladorReceita();
        }
        return instance;
    }
    
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
        if (item == null) {
            throw new Exception("Dados da receita não fornecidos!");
        }
        
        if (item.nome == null || item.nome.trim().isEmpty()) {
            throw new Exception("Informe o nome da receita.");
        }
        
        if (item.dificuldade == null) {
            throw new Exception("Informe a dificuldade da receita!");
        }
        
        if (item.ingredientes.isEmpty()) {
            throw new Exception("A receite precisa ter ao menos um ingrediente!");
        }
        
        if (item.modoPreparo == null || item.modoPreparo.trim().isEmpty()) {
            throw new Exception("Informe o modo de preparo da receita!");
        }
        
        return true;
    }

    @Override
    protected void salvaInclusao(DadosReceita item) {
        try {
            Receita receita = new Receita();
            copiaDadosParaReceita(item, receita);
            receita.setIdReceita(getDao().getNextId());
            getDao().put(receita.getId(), receita);
            telaCad.fechaTela();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(telaCad, e.getMessage());
        }
    }

    @Override
    protected void salvaAlteracao(DadosReceita item) {
        try {
            Receita receita = ReceitaDAO.getInstance().get(item.idReceita);
            if (receita != null) {
                copiaDadosParaReceita(item, receita); 
                getDao().put(receita.getId(), receita);
                telaCad.fechaTela();
            } else {
                throw new Exception("Receita não cadastrada!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(telaCad, e.getMessage());
        }
    }
    
    private void copiaDadosParaReceita(DadosReceita dadosReceita, Receita receita) {
        receita.setIdReceita(dadosReceita.idReceita);
        receita.setDificuldade(dadosReceita.dificuldade);
        receita.setModoPreparo(dadosReceita.modoPreparo);
        receita.setNome(dadosReceita.nome);
        receita.setTempo(dadosReceita.tempo);
        ArrayList<IngredienteReceita> listaIngredienteReceita = new ArrayList<>();
        for (DadosIngredienteReceita dadosIngredienteReceita : dadosReceita.ingredientes) {
            IngredienteReceita ir = new IngredienteReceita();
            ir.setId(dadosIngredienteReceita.id);
            ir.setIngrediente(IngredienteDAO.getInstance().get(dadosIngredienteReceita.ingrediente.id));
            ir.setQuantidade(dadosIngredienteReceita.quantidade);
            ir.setUnidade(dadosIngredienteReceita.unidade);
            listaIngredienteReceita.add(ir);
        }
        receita.setIngredientes(listaIngredienteReceita);
    }

    @Override
    protected String getMensagemConfirmacaoExclusao(DadosReceita dadosReceita) {
        return super.getMensagemConfirmacaoExclusao(dadosReceita) +
               "\nNome: " + dadosReceita.nome;
    }
    
    @Override
    protected void executaExclusao(DadosReceita item) {
        try {
            if (item.idReceita == 0) {
                throw new InvalidParameterException("Falha ao excluir a receita! ID não informado.");
            }

            Receita receita = ReceitaDAO.getInstance().get(item.idReceita);
            if (receita == null) {
                throw new Exception("Receita não encontrada pelo id informado!");
            }

            getDao().remove(receita.getId());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(telaTb, e.getMessage());
        }
    }

    @Override
    public List<DadosReceita> getListaDTO() {
        ArrayList<DadosReceita> lista = new ArrayList<>();
        for (Receita receita : getDao().getList()) {
            lista.add(receita.getDTO());
        }
        return lista;
    }

    @Override
    protected ReceitaDAO getDao() {
        return ReceitaDAO.getInstance();
    }
    
    public boolean existeReceitaComIngrediente(int idIngrediente) {
        for (Receita receita : ReceitaDAO.getInstance().getList()) {
            for (IngredienteReceita ingrediente : receita.getIngredientes()) {
                if (ingrediente.getId() == idIngrediente) {
                    return true;
                }
            }
        }
        return false;
    }
    
}

package br.ufsc.ine5608.homechef.controller;

import br.ufsc.ine5608.homechef.dto.DadosIngrediente;
import br.ufsc.ine5608.homechef.model.Ingrediente;
import br.ufsc.ine5608.homechef.persistencia.IngredienteDAO;
import br.ufsc.ine5608.homechef.view.FmCadastrarIngrediente;
import br.ufsc.ine5608.homechef.view.FmListarIngredientes;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Responsável pelo controle de cadastro dos ingredientes
 * @author Flávio
 */
public class ControladorIngrediente extends ControladorCadastro<FmListarIngredientes, FmCadastrarIngrediente, IngredienteDAO, Integer, Ingrediente, DadosIngrediente> {

    private static ControladorIngrediente instance;

    private ControladorIngrediente() {
        super();
    }

    public static ControladorIngrediente getInstance() {
        if (instance == null) {
            instance = new ControladorIngrediente();
        }
        return instance;
    }

    @Override
    protected FmListarIngredientes instanciaTelaTable() {
        return new FmListarIngredientes();
    }

    @Override
    protected FmCadastrarIngrediente instanciaTelaCadastro() {
        return new FmCadastrarIngrediente();
    }

    @Override
    protected boolean valida(DadosIngrediente dadosIngrediente) throws Exception {
        if (dadosIngrediente == null) {
            throw new InvalidParameterException("Dados invalidos! Parametro nulo.");
        }
        
        if (dadosIngrediente.nome == null || dadosIngrediente.nome.trim().isEmpty()) {
            throw new Exception("Informe o nome do ingrediente!");
        }
        
        Ingrediente ingrediente = findIngredientePeloNome(dadosIngrediente.nome);
        if (ingrediente != null && !ingrediente.getIdIngrediente().equals(dadosIngrediente.idIngrediente)) {
            throw new Exception("Já existe um ingrediente cadastrado com este nome!");
        }
        
        if (dadosIngrediente.unidade == null) {
            throw new Exception("Informe a unidade!");
        }
        
        return true;
    }

    @Override
    protected void salvaInclusao(DadosIngrediente dadosIngrediente) {
        try {
            if (valida(dadosIngrediente)) {
                Ingrediente ingrediente = new Ingrediente();
                copiaDadosParaIngrediente(dadosIngrediente, ingrediente);
                ingrediente.setIdIngrediente(getDao().getNextId());
                getDao().put(ingrediente.getIdIngrediente(), ingrediente);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(telaCad, e.getMessage());
        }
    }

    @Override
    protected void salvaAlteracao(DadosIngrediente dadosIngrediente) {
        try {
            Ingrediente ingrediente = findIngrediente(dadosIngrediente.idIngrediente);
            if (ingrediente != null) {
                if (valida(dadosIngrediente)) {
                    copiaDadosParaIngrediente(dadosIngrediente, ingrediente); 
                    getDao().put(ingrediente.getIdIngrediente(), ingrediente);
                }
            } else {
                throw new Exception("Ingrediente não cadastrado!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(telaCad, e.getMessage());
        }
    }

    @Override
    protected String getMensagemConfirmacaoExclusao(DadosIngrediente dadosIngrediente) {
        return super.getMensagemConfirmacaoExclusao(dadosIngrediente) +
               "\nNome: " + dadosIngrediente.nome;
    }

    
    
    @Override
    protected void executaExclusao(DadosIngrediente dadosIngrediente) {
        try {
            if (dadosIngrediente.idIngrediente == null || dadosIngrediente.idIngrediente == 0) {
                throw new InvalidParameterException("Falha ao excluir o ingrediente! ID não informado.");
            }

            Ingrediente ingrediente = findIngrediente(dadosIngrediente.idIngrediente);
            if (ingrediente == null) {
                throw new Exception("Ingrediente não encontrado pelo id informado!");
            }

            /*if (!ControladorReceita.getInstance().existeReceitaComIngrediente(ingrediente.getIdIngrediente())) {
                throw new Exception("Ingrediente está sendo utilizado em uma ou mais receitas!");
            }*/

            getDao().remove(ingrediente.getIdIngrediente());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(telaTb, e.getMessage());
        }
    }

    @Override
    protected List<DadosIngrediente> getListaDTO() {
        ArrayList<DadosIngrediente> lista = new ArrayList<>();
        for (Ingrediente ingrediente : getDao().getList()) {
            lista.add(ingrediente.getDTO());
        }
        return lista;
    }

    @Override
    protected IngredienteDAO getDao() {
        return IngredienteDAO.getInstance();
    }

    private Ingrediente findIngrediente(int id) {
        return getDao().get(id);
    }
    
    /**
     * Pesquisa o ingrediente pelo nome
     * @param nome Nome a ser pesquisado
     * @return Ingrediente encontrado pelo nome ou nulo se nao encontrar
     */
    private Ingrediente findIngredientePeloNome(String nome) {
        return getDao().getByNome(nome);
    }
    
    /**
     * Copia os dados da tela para uma instancia de ingrediente
     * @param dadosIngrediente Dados passados pela tela
     * @param ingrediente Objeto veiculo que ira receber os dados
     */
    private void copiaDadosParaIngrediente(DadosIngrediente dadosIngrediente, Ingrediente ingrediente) {
        ingrediente.setIdIngrediente(dadosIngrediente.idIngrediente);
        ingrediente.setNome(dadosIngrediente.nome);
        ingrediente.setPreco(dadosIngrediente.preco);
        ingrediente.setQuantidadePreco(dadosIngrediente.quantidadePreco);
        ingrediente.setUnidade(dadosIngrediente.unidade);
        ingrediente.setUnidadePreco(dadosIngrediente.unidadePreco);
    }
    
}
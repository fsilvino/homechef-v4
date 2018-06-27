package br.ufsc.ine5608.homechef.controller;

import br.ufsc.ine5608.homechef.dto.DadosItemEstoque;
import br.ufsc.ine5608.homechef.model.ItemEstoque;
import br.ufsc.ine5608.homechef.model.Unidade;
import br.ufsc.ine5608.homechef.persistencia.ItemEstoqueDAO;
import br.ufsc.ine5608.homechef.view.FmRegistrarEntradaEstoque;
import br.ufsc.ine5608.homechef.view.ITelaItemEstoqueObserver;
import br.ufsc.ine5608.homechef.view.SaidaEstoqueIngrediente;

import javax.swing.*;
import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Responsável pelo controle de item de estoque
 *
 * @author Gabriel
 */
public class ControladorItemEstoque implements ITelaItemEstoqueObserver {

    private static ControladorItemEstoque instance;
    private final FmRegistrarEntradaEstoque telaEntradaEstoque;
    private final SaidaEstoqueIngrediente telaSaidaEstoque;

    private ControladorItemEstoque() {
        telaEntradaEstoque = instanciaTelaEntradaEstoque();
        telaEntradaEstoque.setObserver(this);
        telaSaidaEstoque = instanciaTelaSaidaEstoque();
        telaSaidaEstoque.setObserver(this);
    }

    public static ControladorItemEstoque getInstance() {
        if (instance == null) {
            instance = new ControladorItemEstoque();
        }
        return instance;
    }

    public void inicia() {
//        this.telaEntradaEstoque.setVisible(true);
//        this.telaEntradaEstoque.setListaIngrediente();
        this.telaSaidaEstoque.setVisible(true);
        this.telaSaidaEstoque.setListaItemEstoque(getListaDTO());
    }

    @Override
    public void salvaCadastro() {
        try {
            DadosItemEstoque item = this.telaEntradaEstoque.getDados();
            if (this.valida(item)) {
                this.salvaInclusao(item);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void salvaInclusao(DadosItemEstoque dadosItemEstoque) {
        try {
            ItemEstoque itemEstoque = new ItemEstoque();
            copiaDadosParaItemEstoque(dadosItemEstoque, itemEstoque);
            itemEstoque.setId(getDao().getNextId());
            getDao().put(itemEstoque.getId(), itemEstoque);
            telaEntradaEstoque.fechaTela();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(telaEntradaEstoque, e.getMessage());
        }
    }

    @Override
    public void salvaSaida(int quantidade, Unidade unidade) {
        try {
            DadosItemEstoque item = this.telaSaidaEstoque.getDados();
            if (this.valida(item)) {
                ItemEstoque itemEstoque = findItemEstoque(item.id);
                if (validaQuantidadeSaida(itemEstoque, quantidade, unidade)) {
                    int quantidadeDecrementa = ControladorUnidade.getInstance().getQuantidadeEquivalenteBase(unidade, quantidade);
                    decrementaItemEstoque(itemEstoque, quantidadeDecrementa);
                    atualizaListaTela();
                } else {
                    JOptionPane.showMessageDialog(telaSaidaEstoque, "Quantidade informada é superior à existente no estoque!");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void atualizaListaTela() {
        telaSaidaEstoque.setListaItemEstoque(getListaDTO());
    }

    private void decrementaItemEstoque(ItemEstoque item, int quantidade) {
        item.setQuantidade(item.getQuantidade() - quantidade);
        getDao().put(item.getId(), item);
    }

    private FmRegistrarEntradaEstoque instanciaTelaEntradaEstoque() {
        return new FmRegistrarEntradaEstoque();
    }

    private SaidaEstoqueIngrediente instanciaTelaSaidaEstoque() {
        return new SaidaEstoqueIngrediente();
    }

    public boolean valida(DadosItemEstoque dadosItemEstoque) throws Exception {
        if (dadosItemEstoque == null) {
            throw new InvalidParameterException("Dados invalidos! Parametro nulo.");
        }

        if (dadosItemEstoque.id == 0) {
            if (dadosItemEstoque.ingrediente == null) {
                throw new Exception("Informe o ingrediente!");
            }

            if (dadosItemEstoque.unidade == null) {
                throw new Exception("Informe a unidade!");
            }

            if (dadosItemEstoque.quantidade <= 0) {
                throw new Exception("A quantidade informada deve ser maior que zero!");
            }

            if (dadosItemEstoque.validade != null && dadosItemEstoque.validade.isBefore(LocalDate.now())) {
                throw new Exception("A validade deve ser posterior à data atual!");
            }
        } else {
            if (findItemEstoque(dadosItemEstoque.id) == null) {
                throw new Exception("Ingrediente não encontrado");
            }
        }

        return true;
    }

    public boolean validaQuantidadeSaida(ItemEstoque itemEstoque, int quantidade, Unidade unidade) throws Exception {
        if (quantidade <= 0) {
            throw new Exception("Quantidade deve ser superior à zero!");
        }
        try {
            int quantidadeEstoque = ControladorUnidade.getInstance().getQuantidadeEquivalenteBase(itemEstoque.getUnidade(), itemEstoque.getQuantidade());
            quantidade = ControladorUnidade.getInstance().getQuantidadeEquivalenteBase(unidade, quantidade);
            return quantidadeEstoque >= quantidade;
        } catch (Exception e) {
            return false;
        }
    }

    private List<DadosItemEstoque> getListaDTO() {
        ArrayList<DadosItemEstoque> lista = new ArrayList<>();
        for (ItemEstoque itemEstoque : getDao().getList()) {
            lista.add(itemEstoque.getDTO());
        }
        return lista;
    }

    private ItemEstoqueDAO getDao() {
        return ItemEstoqueDAO.getInstance();
    }

    private ItemEstoque findItemEstoque(int id) {
        return getDao().get(id);
    }

    /**
     * Pesquisa o ingrediente pelo nome
     *
     * @param nome Nome a ser pesquisado
     * @return Ingrediente encontrado pelo nome ou nulo se nao encontrar
     */
    private ItemEstoque findItemEstoqueByNome(String nome) {
        return getDao().getByNome(nome);
    }

    /**
     * Copia os dados da tela para uma instancia de ingrediente
     *
     * @param dadosItemEstoque Dados passados pela tela
     * @param itemEstoque      Objeto veiculo que ira receber os dados
     */
    private void copiaDadosParaItemEstoque(DadosItemEstoque dadosItemEstoque, ItemEstoque itemEstoque) {
        itemEstoque.setId(dadosItemEstoque.id);
        itemEstoque.setUnidade(dadosItemEstoque.unidade);
        itemEstoque.setIngrediente(dadosItemEstoque.ingrediente);
        itemEstoque.setValidade(dadosItemEstoque.validade);
        itemEstoque.setQuantidade(dadosItemEstoque.quantidade);
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5608.homechef.controller;

import br.ufsc.ine5608.homechef.view.FmCadastrarIngrediente;
import br.ufsc.ine5608.homechef.view.FmListarIngredientes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author Gabriel
 */
public class ControladorIngrediente {

    private static ControladorIngrediente mInstance;
    private final IngredienteService ingredienteService;
    private final FmListarIngredientes listarIngredientes;
    private final FmCadastrarIngrediente cadastrarIngrediente;
    private final UnidadeService unidadeService;

    private ControladorIngrediente() {
        unidadeService = new UnidadeServiceImpl();
        ingredienteService = new IngredienteServiceImpl();
        listarIngredientes = new FmListarIngredientes();
        cadastrarIngrediente = new FmCadastrarIngrediente();
    }

    public static ControladorIngrediente getInstance() {
        if (mInstance == null) {
            mInstance = new ControladorIngrediente();
        }
        return mInstance;
    }

    public void abreInclusao() {
        cadastrarIngrediente.abreInclusao();
    }

    public void abreAlteracao(IngredienteDTO ingredienteDTO) {
        cadastrarIngrediente.abreAlteracao(ingredienteDTO);
    }

    public void abreListaIngredientes() {
        listarIngredientes.setaIntegredientesTable(listIngredientes());
        listarIngredientes.setVisible(true);
    }

    public void salva(IngredienteDTO ingredienteDTO) throws Exception {
        valida(ingredienteDTO);
        Ingrediente ingrediente = montaIngrediente(ingredienteDTO);
        if (ingrediente.getIdIngrediente() == null) {
            ingredienteService.insert(ingrediente);
        } else {
            ingredienteService.update(ingrediente);
        }
        listarIngredientes.setaIntegredientesTable(listIngredientes());
    }

    public void exclui(IngredienteDTO ingrediente) {
        ingredienteService.delete(Integer.parseInt(ingrediente.getIdIngrediente()));
        listarIngredientes.setaIntegredientesTable(listIngredientes());
    }

    public Collection<IngredienteDTO> listIngredientes() {
        return ingredienteService.list().stream().map(this::montaIngredienteDTO).collect(Collectors.toList());
    }

    private Ingrediente montaIngrediente(IngredienteDTO ingredienteDTO) {
        return new Ingrediente()
                .setIdIngrediente(ingredienteDTO.getIdIngrediente().equals("") ? null : Integer.parseInt(ingredienteDTO.getIdIngrediente()))
                .setNome(ingredienteDTO.getNome())
                .setPreco(ingredienteDTO.getPreco().equals("") ? 0 : Double.parseDouble(ingredienteDTO.getPreco()))
                .setQuantidadePreco(ingredienteDTO.getQuantidadePreco().equals("") ? 0 : Integer.parseInt(ingredienteDTO.getQuantidadePreco()))
                .setUnidade(getUnidadeSelecionada(ingredienteDTO.getUnidade()))
                .setUnidadePreco(getUnidadeSelecionada(ingredienteDTO.getUnidade()));
    }

    private IngredienteDTO montaIngredienteDTO(Ingrediente ingrediente) {
        return new IngredienteDTO()
                .setIdIngrediente(ingrediente.getIdIngrediente().toString())
                .setNome(ingrediente.getNome())
                .setPreco(ingrediente.getPreco().toString())
                .setQuantidadePreco(ingrediente.getQuantidadePreco().toString())
                .setUnidade(ingrediente.getUnidade().getNomeSingular())
                .setUnidadePreco(ingrediente.getUnidadePreco().getNomeSingular());
    }

    private Unidade getUnidadeSelecionada(String nomeUnidade) {
        return unidadeService.findByName(nomeUnidade);
    }

    private void valida(IngredienteDTO ingredienteDTO) throws Exception {
        ArrayList<String> errors = new ArrayList<>();
        if (ingredienteDTO.getNome().isEmpty()) {
            errors.add("Nome do ingrediente não pode estar vazio.");
        }
        if (ingredienteService.list().stream().anyMatch((i) -> { return !i.getIdIngrediente().toString().equals(ingredienteDTO.getIdIngrediente()) && i.getNome().equals(ingredienteDTO.getNome()); } )) {
            errors.add("Ingrediente já cadastrado com esse nome.");
        }
        if (ingredienteDTO.getUnidade() == null) {
            errors.add("Você deve especificar uma unidade.");
        }
        if (!ingredienteDTO.getPreco().isEmpty() && Double.parseDouble(ingredienteDTO.getPreco()) != 0) {
            if (Double.parseDouble(ingredienteDTO.getPreco()) < 0) {
                errors.add("O preço deve ser um número positivo.");
            }
            if (ingredienteDTO.getQuantidadePreco().equals("") || Integer.parseInt(ingredienteDTO.getQuantidadePreco()) <= 0) {
                errors.add("A quantidade deve ser um número positivo maior que zero.");
            }
        }
        if (!errors.isEmpty()) {
            throw new BusinessException(errors);
        }
    }
}

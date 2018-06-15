/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5608.homechef.controller;

/*
import br.ufsc.ine5608.homechef.model.Ingrediente;
import br.ufsc.ine5608.homechef.model.Unidade;
import br.ufsc.ine5608.homechef.view.FmCadastrarIngrediente;
import br.ufsc.ine5608.homechef.view.FmListarIngredientes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;*/

/**
 * @author Gabriel
 */
public class ControladorIngredienteBkp {

   /* private static ControladorIngredienteBkp mInstance;
    private final FmListarIngredientes listarIngredientes;
    private final FmCadastrarIngrediente cadastrarIngrediente;
    
    private ControladorIngredienteBkp() {
        listarIngredientes = new FmListarIngredientes();
        cadastrarIngrediente = new FmCadastrarIngrediente();
    }

    public static ControladorIngredienteBkp getInstance() {
        if (mInstance == null) {
            mInstance = new ControladorIngredienteBkp();
        }
        return mInstance;
    }

    public void abreInclusao() {
        cadastrarIngrediente.abreInclusao();
    }

    public void abreAlteracao(Ingrediente ingrediente) {
        cadastrarIngrediente.abreAlteracao(ingrediente);
    }

    public void abreListaIngredientes() {
        listarIngredientes.setaIntegredientesTable(listIngredientes());
        listarIngredientes.setVisible(true);
    }

    public void salva(Ingrediente ingrediente) throws Exception {
        valida(ingrediente);
//        if (ingrediente.getIdIngrediente() == null) {
//            ingredienteService.insert(ingrediente);
//        } else {
//            ingredienteService.update(ingrediente);
//        }
        listarIngredientes.setaIntegredientesTable(listIngredientes());
    }

    public void exclui(Ingrediente ingrediente) {
//        ingredienteService.delete(Integer.parseInt(ingrediente.getIdIngrediente()));;
        listarIngredientes.setaIntegredientesTable(listIngredientes());
    }

    public Collection<Ingrediente> listIngredientes() {
//        return ingredienteService.list().stream().map(this::montaIngredienteDTO).collect(Collectors.toList());
        return null;
    }

    private Unidade getUnidadeSelecionada(String nomeUnidade) {
//        return unidadeService.findByName(nomeUnidade);
        return null;
    }

    private void valida(Ingrediente ingrediente) throws Exception {
        ArrayList<String> errors = new ArrayList<>();
        if (ingrediente.getNome().isEmpty()) {
            errors.add("Nome do ingrediente não pode estar vazio.");
        }
//        if (ingredienteService.list().stream().anyMatch((i) -> { return !i.getIdIngrediente().toString().equals(ingredienteDTO.getIdIngrediente()) && i.getNome().equals(ingredienteDTO.getNome()); } )) {
//            errors.add("Ingrediente já cadastrado com esse nome.");
//        }
        if (ingrediente.getUnidade() == null) {
            errors.add("Você deve especificar uma unidade.");
        }
        if (!errors.isEmpty()) {
//            throw new BusinessException(errors);
        }
    }*/
}

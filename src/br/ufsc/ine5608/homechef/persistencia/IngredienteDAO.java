package br.ufsc.ine5608.homechef.persistencia;

import br.ufsc.ine5608.homechef.model.Ingrediente;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Flávio
 */
public class IngredienteDAO extends BaseDAO<Ingrediente> {

    private static IngredienteDAO instance;

    public static IngredienteDAO getInstance() {
        if (instance == null) {
            instance = new IngredienteDAO();
        }
        return instance;
    }

    private IngredienteDAO() {
        super();
    }

    @Override
    protected String getFileName() {
        return "ingrediente.hc";
    }

    public Ingrediente getByNome(String nome) {
        for (Ingrediente ingrediente : cache.values()) {
            if (ingrediente.getNome().equals(nome)) {
                return ingrediente;
            }
        }
        return null;
    }

    public List<Ingrediente> pesquisa(String nome) {
        List<Ingrediente> resultado = new ArrayList<>();
        if (nome == null || nome.isEmpty()) {
            resultado.addAll(cache.values());
        } else {
            for (Ingrediente ingrediente : cache.values()) {
                if (ingrediente.getNome().contains(nome)) {
                    resultado.add(ingrediente);
                }
            }
        }
        resultado.sort((i1, i2) -> i1.getNome().compareTo(i2.getNome()));
        return resultado;
    }

    @Override
    protected void initializeData() {

    }

}

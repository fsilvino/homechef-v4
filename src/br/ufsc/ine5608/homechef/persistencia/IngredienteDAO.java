package br.ufsc.ine5608.homechef.persistencia;

import br.ufsc.ine5608.homechef.model.Ingrediente;

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

    @Override
    protected void initializeData() {
        
    }
    
}

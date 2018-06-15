package br.ufsc.ine5608.homechef.persistencia;

import br.ufsc.ine5608.homechef.model.Ingrediente;

/**
 *
 * @author Flávio
 */
public class IngredienteDAO extends BaseDAO<Integer, Ingrediente> {
    
    private static IngredienteDAO instance;
    private int nextId;
    
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

    @Override
    public void load() {
        super.load();
        Integer[] keys = this.cache.keySet().toArray(new Integer[0]);
        this.nextId = 1;
        if (keys.length > 0)
            this.nextId = keys[keys.length - 1] + 1;
    }
    
    public int getNextId() {
        return this.nextId++;
    }
    
    public Ingrediente getByNome(String nome) {
        for (Ingrediente ingrediente : cache.values()) {
            if (ingrediente.getNome().equals(nome)) {
                return ingrediente;
            }
        }
        return null;
    }
    
}

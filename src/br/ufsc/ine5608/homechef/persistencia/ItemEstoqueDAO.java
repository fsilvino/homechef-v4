package br.ufsc.ine5608.homechef.persistencia;

import br.ufsc.ine5608.homechef.model.ItemEstoque;

/**
 *
 * @author Gabriel
 */
public class ItemEstoqueDAO extends BaseDAO<ItemEstoque> {

    private static ItemEstoqueDAO instance;

    public static ItemEstoqueDAO getInstance() {
        if (instance == null) {
            instance = new ItemEstoqueDAO();
        }
        return instance;
    }

    private ItemEstoqueDAO() {
        super();
    }

    @Override
    protected String getFileName() {
        return "item-estoque.hc";
    }
    
    public ItemEstoque getByNome(String nome) {
        for (ItemEstoque itemEstoque : cache.values()) {
            if (itemEstoque.getIngrediente().getNome().equals(nome)) {
                return itemEstoque;
            }
        }
        return null;
    }

    @Override
    protected void initializeData() {
        
    }
}

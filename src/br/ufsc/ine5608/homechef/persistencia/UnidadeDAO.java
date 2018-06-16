package br.ufsc.ine5608.homechef.persistencia;

import br.ufsc.ine5608.homechef.model.Unidade;

/**
 *
 * @author Flávio
 */
public class UnidadeDAO extends BaseDAO<Unidade> {
    
    private static UnidadeDAO instance;
    
    public static UnidadeDAO getInstance() {
        if (instance == null) {
            instance = new UnidadeDAO();
        }
        return instance;
    }

    private UnidadeDAO() {
        super();
    }

    @Override
    protected String getFileName() {
        return "unidade.hc";
    }
    
    public Unidade getByNomeSingular(String nomeSingular) {
        for (Unidade unidade : cache.values()) {
            if (unidade.getNomeSingular().equals(nomeSingular)) {
                return unidade;
            }
        }
        return null;
    }

    @Override
    protected void initializeData() {
        if (this.cache.isEmpty()) {
            Unidade und = new Unidade(getNextId(), "Grama", "Gramas", "g");
            put(und.getId(), und);

            und = new Unidade(getNextId(), "Quilograma", "Quilogramas", "kg");
            put(und.getId(), und);

            und = new Unidade(getNextId(), "Litro", "Litros", "l");
            put(und.getId(), und);

            und = new Unidade(getNextId(), "Mililitro", "Mililitros", "ml");
            put(und.getId(), und);

            und = new Unidade(getNextId(), "Unidade", "Unidades", "un");
            put(und.getId(), und);
        }
    }
    
}

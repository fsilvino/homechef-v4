package br.ufsc.ine5608.homechef.persistencia;

import br.ufsc.ine5608.homechef.model.Dificuldade;

/**
 *
 * @author Flávio
 */
public class DificuldadeDAO extends BaseDAO<Dificuldade> {
    
    private static DificuldadeDAO instance;
    
    public static DificuldadeDAO getInstance() {
        if (instance == null) {
            instance = new DificuldadeDAO();
        }
        return instance;
    }

    private DificuldadeDAO() {
        super();
    }

    @Override
    protected String getFileName() {
        return "dificuldade.hc";
    }
    
    @Override
    protected void initializeData() {
        if (this.cache.isEmpty()) {
            Dificuldade facil = new Dificuldade(getNextId(), "Fácil");
            put(facil.getId(), facil);
            
            Dificuldade media = new Dificuldade(getNextId(), "Média");
            put(media.getId(), media);
            
            Dificuldade dificil = new Dificuldade(getNextId(), "Difícil");
            put(dificil.getId(), dificil);
        }
    }
    
}

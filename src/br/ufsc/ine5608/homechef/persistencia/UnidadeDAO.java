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
            Unidade grama = new Unidade(getNextId(), "Grama", "Gramas", "g");
            put(grama.getId(), grama);

            Unidade quilograma = new Unidade(getNextId(), "Quilograma", "Quilogramas", "kg");
            quilograma.addSubunidade(grama, 1000);
            put(quilograma.getId(), quilograma);

            Unidade mililitro = new Unidade(getNextId(), "Mililitro", "Mililitros", "ml");
            put(mililitro.getId(), mililitro);
            
            Unidade litro = new Unidade(getNextId(), "Litro", "Litros", "l");
            litro.addSubunidade(mililitro, 1000);
            put(litro.getId(), litro);

            Unidade unidade = new Unidade(getNextId(), "Unidade", "Unidades", "un");
            put(unidade.getId(), unidade);
            
            Unidade lata = new Unidade(getNextId(), "Lata", "Latas", "lt");
            lata.addSubunidade(grama, 250);
            put(lata.getId(), lata);
            
            Unidade copo = new Unidade(getNextId(), "Copo", "Copos", "cp");
            copo.addSubunidade(mililitro, 250);
            put(copo.getId(), copo);
            
            Unidade colher = new Unidade(getNextId(), "Colher", "Colheres", "colher");
            colher.addSubunidade(grama, 40);
            put(colher.getId(), colher);
            
        }
    }
    
}

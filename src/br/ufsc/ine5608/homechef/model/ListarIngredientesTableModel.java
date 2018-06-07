package br.ufsc.ine5608.homechef.model;

import javax.swing.table.DefaultTableModel;
import java.util.Collection;

public class ListarIngredientesTableModel extends DefaultTableModel {

    public ListarIngredientesTableModel(Collection<Ingrediente> ingredientes) {
        super(
                new Object[][]{
                        ingredientes.toArray()
                },
                new String[]{
                        "Nome", "Unidade", "Preço"
                });
    }
}

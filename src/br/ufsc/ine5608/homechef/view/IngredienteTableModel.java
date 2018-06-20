package br.ufsc.ine5608.homechef.view;

import br.ufsc.ine5608.homechef.dto.DadosIngrediente;
import br.ufsc.ine5608.homechef.model.Unidade;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class IngredienteTableModel extends AbstractTableModel {
    private List<DadosIngrediente> ingredientes;
    
    private String[] colunas = new String[] {
            "Nome", "Unidade", "Preço"
    };

    public IngredienteTableModel() {
        this.ingredientes = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return ingredientes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex){
        return colunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }


    public void setValueAt(DadosIngrediente aValue, int rowIndex) {
        ingredientes.add(aValue);
        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        DadosIngrediente ingrediente = ingredientes.get(rowIndex);

        switch (columnIndex) {
            case 0:
                ingrediente.nome = aValue.toString();
            case 1:
                ingrediente.unidade = (Unidade)aValue;
            case 2:
                ingrediente.preco = (Double)aValue;

            default:
                System.err.println("Índice da coluna inválido");
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DadosIngrediente ingredienteSelecionado = ingredientes.get(rowIndex);
        String valueObject = null;
        switch(columnIndex){
            case 0: valueObject = ingredienteSelecionado.nome; break;
            case 1: valueObject = ingredienteSelecionado.unidade.toString(); break;
            case 2 : valueObject = ingredienteSelecionado.preco + ""; break;
            default: System.err.println("Índice inválido para propriedade do bean IngredienteDTO.class");
        }

        return valueObject;
    }

    public DadosIngrediente getValueAt(int rowIndex) {
        return ingredientes.get(rowIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }


    public DadosIngrediente getIngredienteDTO(int indiceLinha) {
        return ingredientes.get(indiceLinha);
    }

    public void addIngredienteDTO(DadosIngrediente u) {
        ingredientes.add(u);
        
        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }


    public void removeIngredienteDTO(int indiceLinha) {
        ingredientes.remove(indiceLinha);

        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }


    public void addListaDeIngredienteDTOs(List<DadosIngrediente> novosIngredienteDTOs) {

        int tamanhoAntigo = getRowCount();
        ingredientes.addAll(novosIngredienteDTOs);
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }

    public void limpar() {
        ingredientes.clear();
        fireTableDataChanged();
    }

    public boolean isEmpty() {
        return ingredientes.isEmpty();
    }
}

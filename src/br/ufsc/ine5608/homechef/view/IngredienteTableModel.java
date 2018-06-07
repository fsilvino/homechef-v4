package src.main.java.br.ufsc.INE5608.homechef.view;

import src.main.java.br.ufsc.INE5608.homechef.dto.IngredienteDTO;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class IngredienteTableModel extends AbstractTableModel {
    private List<IngredienteDTO> ingredientes;
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


    public void setValueAt(IngredienteDTO aValue, int rowIndex) {
        ingredientes.add(aValue);
        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        IngredienteDTO ingrediente = ingredientes.get(rowIndex);

        switch (columnIndex) {
            case 0:
                ingrediente.setNome(aValue.toString());
            case 1:
                ingrediente.setUnidade(aValue.toString());
            case 2:
                ingrediente.setPreco(aValue.toString());

            default:
                System.err.println("Índice da coluna inválido");
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }


    public Object getValueAt(int rowIndex, int columnIndex) {
        IngredienteDTO ingredienteSelecionado = ingredientes.get(rowIndex);
        String valueObject = null;
        switch(columnIndex){
            case 0: valueObject = ingredienteSelecionado.getNome(); break;
            case 1: valueObject = ingredienteSelecionado.getUnidade(); break;
            case 2 : valueObject = ingredienteSelecionado.getQuantidadePreco(); break;
            default: System.err.println("Índice inválido para propriedade do bean IngredienteDTO.class");
        }

        return valueObject;
    }

    public IngredienteDTO getValueAt(int rowIndex) {
        return ingredientes.get(rowIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }


    public IngredienteDTO getIngredienteDTO(int indiceLinha) {
        return ingredientes.get(indiceLinha);
    }

    public void addIngredienteDTO(IngredienteDTO u) {
        ingredientes.add(u);


        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }


    public void removeIngredienteDTO(int indiceLinha) {
        ingredientes.remove(indiceLinha);

        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }


    public void addListaDeIngredienteDTOs(List<IngredienteDTO> novosIngredienteDTOs) {

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

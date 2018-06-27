/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5608.homechef.view;

import br.ufsc.ine5608.homechef.controller.ControladorIngrediente;
import br.ufsc.ine5608.homechef.controller.ControladorUnidade;
import br.ufsc.ine5608.homechef.dto.DadosIngrediente;
import br.ufsc.ine5608.homechef.dto.DadosIngredienteReceita;
import br.ufsc.ine5608.homechef.model.Unidade;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Flávio
 */
public class FmCadastroIngredienteReceita extends javax.swing.JFrame {

    private List<DadosIngrediente> ingredientes;
    private ArrayList<Unidade> unidadesRelacionadas;
    private FmCadastrarReceita fmCadastrarReceita;
    private DadosIngredienteReceita ingredienteReceita;

    /**
     * Creates new form IncluiIngredienteReceita
     * @param fmCadastrarReceita
     */
    public FmCadastroIngredienteReceita(FmCadastrarReceita fmCadastrarReceita) {
        initComponents();
        this.fmCadastrarReceita = fmCadastrarReceita;
        setListeners();
        pesquisa();
        verificaIngredienteSelecionado();
        setLocationRelativeTo(null);
    }
    
    private void setListeners() {
        txtNomeIngrediente.getDocument().addDocumentListener(new DocumentListener() {
            
            @Override
            public void insertUpdate(DocumentEvent e) {
                pesquisa();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                pesquisa();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                pesquisa();
            }
            
        });
        tableIngredientes.getSelectionModel().addListSelectionListener((e) -> {
            verificaIngredienteSelecionado();
        });
    }

    public void setDados(DadosIngredienteReceita ingredienteReceita) {
        this.ingredienteReceita = ingredienteReceita;
        setDados();
    }
    
    private void setDados() {
        txtNomeIngrediente.setText("");
        spnQtd.setValue(ingredienteReceita.quantidade);
        pesquisa();
        if (ingredienteReceita.ingrediente != null) {
            for (int i = 0; i < ingredientes.size(); i++) {
                if (ingredientes.get(i).id == ingredienteReceita.ingrediente.id) {
                    tableIngredientes.getSelectionModel().setSelectionInterval(i, i);
                    break;
                }
            }
            cbUnidade.setSelectedItem(ingredienteReceita.unidade);
        }
    }

    private void pesquisa() {
        String nome = txtNomeIngrediente.getText().trim();
        ingredientes = ControladorIngrediente.getInstance().pesquisa(nome);
        IngredientesTableModel model = new IngredientesTableModel();
        model.addListaDeIngredientes(ingredientes);
        tableIngredientes.setModel(model);
    }
    
    private DadosIngrediente getIngredienteSelecionado() {
        int idx = tableIngredientes.getSelectedRow();
        if (idx > -1 && ingredientes != null) {
            return ingredientes.get(idx);
        }
        return null;
    }

    private void verificaIngredienteSelecionado() {
        DadosIngrediente ingrediente = getIngredienteSelecionado();
        if (ingrediente != null) {
            unidadesRelacionadas = ControladorUnidade.getInstance().getUnidadesRelacionadas(ingrediente.unidade.getId());
        } else {
            unidadesRelacionadas = new ArrayList<>();
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel(unidadesRelacionadas.toArray(new Unidade[0]));
        cbUnidade.setModel(model);
    }
    
    private void getDados() {
        ingredienteReceita.ingrediente = getIngredienteSelecionado();
        ingredienteReceita.quantidade = Float.parseFloat(spnQtd.getValue().toString());
        ingredienteReceita.unidade = unidadesRelacionadas.get(cbUnidade.getSelectedIndex());
    }
    
    private boolean valida() {
        if (getIngredienteSelecionado() == null) {
            JOptionPane.showMessageDialog(null, "Selecione um ingrediente!");
            return false;
        }
        
        try {
            float qtd = Float.parseFloat(spnQtd.getValue().toString());
            if (qtd <= 0) {
                JOptionPane.showMessageDialog(null, "A quantidade deve ser maior do que zero!");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Quantidade inválida!");
            return false;
        }
        
        if (cbUnidade.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(null, "Selecione uma unidade!");
            return false;
        }
        
        return true;
    }

    private void salva() {
        if (valida()) {
            getDados();
            if (ingredienteReceita.id != 0) {
                fmCadastrarReceita.alterarIngrediente(ingredienteReceita);
            } else {
                if (ingredienteReceita.id == 0) {
                    ingredienteReceita.id = -1;
                }
                fmCadastrarReceita.incluirIngrediente(ingredienteReceita);
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIngrediente = new javax.swing.JLabel();
        btCancela = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableIngredientes = new javax.swing.JTable();
        btSalva = new javax.swing.JButton();
        txtNomeIngrediente = new javax.swing.JTextField();
        lbQtd = new javax.swing.JLabel();
        spnQtd = new javax.swing.JSpinner();
        cbUnidade = new javax.swing.JComboBox<>();

        setTitle("Cadastro Ingrediente na Receita");

        lbIngrediente.setText("Ingrediente:");

        btCancela.setText("Cancela");
        btCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelaActionPerformed(evt);
            }
        });

        tableIngredientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Leite", "L"},
                {"Farinha de Trigo", "kg"},
                {"Macarrão Instantâneo", "und"}
            },
            new String [] {
                "Nome", "Unidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableIngredientes);
        if (tableIngredientes.getColumnModel().getColumnCount() > 0) {
            tableIngredientes.getColumnModel().getColumn(0).setPreferredWidth(400);
            tableIngredientes.getColumnModel().getColumn(1).setPreferredWidth(50);
        }

        btSalva.setText("Salva");
        btSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvaActionPerformed(evt);
            }
        });

        lbQtd.setText("Quantidade:");

        cbUnidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ML", "L", "G", "KG", "XÍCARA (240ml)", "XÍCARA (165g)", "COPO (250ml)", "COPO (212g)" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbIngrediente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeIngrediente))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btSalva)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancela))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbQtd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbIngrediente)
                    .addComponent(txtNomeIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbQtd)
                    .addComponent(spnQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancela)
                    .addComponent(btSalva))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelaActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btCancelaActionPerformed

    private void btSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvaActionPerformed
        salva();
    }//GEN-LAST:event_btSalvaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancela;
    private javax.swing.JButton btSalva;
    private javax.swing.JComboBox<String> cbUnidade;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbIngrediente;
    private javax.swing.JLabel lbQtd;
    private javax.swing.JSpinner spnQtd;
    private javax.swing.JTable tableIngredientes;
    private javax.swing.JTextField txtNomeIngrediente;
    // End of variables declaration//GEN-END:variables

    private class IngredientesTableModel extends AbstractTableModel {

        private List<DadosIngrediente> ingredientes;

        private String[] colunas = new String[]{
            "Nome", "Unidade"
        };

        public IngredientesTableModel() {
            this.ingredientes = new ArrayList<>();
        }

        public IngredientesTableModel(List<DadosIngrediente> ingredientes) {
            this.ingredientes = ingredientes;
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
        public String getColumnName(int columnIndex) {
            return colunas[columnIndex];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return String.class;
        }

        public void addIngrediente(DadosIngrediente dadosIngredienteReceita) {
            ingredientes.add(dadosIngredienteReceita);
            int ultimoIndice = getRowCount() - 1;
            fireTableRowsInserted(ultimoIndice, ultimoIndice);
        }

        public void removeIngrediente(int indiceLinha) {
            ingredientes.remove(indiceLinha);
            fireTableRowsDeleted(indiceLinha, indiceLinha);
        }

        public void limpar() {
            ingredientes.clear();
            fireTableDataChanged();
        }

        public void addListaDeIngredientes(List<DadosIngrediente> novosIngrediente) {
            int tamanhoAntigo = getRowCount();
            ingredientes.addAll(novosIngrediente);
            fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            DadosIngrediente ingrediente = ingredientes.get(rowIndex);
            String valueObject = null;
            switch (columnIndex) {
                case 0:
                    valueObject = ingrediente.nome;
                    break;
                case 1:
                    valueObject = ingrediente.unidade.getUnidade();
                    break;
                default:
                    System.err.println("Índice inválido para propriedade do bean IngredienteDTO.class");
            }
            return valueObject;
        }
    }

}

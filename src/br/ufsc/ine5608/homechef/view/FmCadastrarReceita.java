package br.ufsc.ine5608.homechef.view;

import br.ufsc.ine5608.homechef.dto.DadosIngredienteReceita;
import br.ufsc.ine5608.homechef.dto.DadosReceita;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Flávio
 */
public class FmCadastrarReceita extends FmBaseCadastro<DadosReceita> {
    
    private FmCadastroIngredienteReceita fmIngredienteReceita;
    private List<DadosIngredienteReceita> ingredientesReceita;

    /**
     * Creates new form Receita
     */
    public FmCadastrarReceita() {
        ingredientesReceita = new ArrayList<>();
        
        fmIngredienteReceita = new FmCadastroIngredienteReceita(this);
        fmIngredienteReceita.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lbTexto = new javax.swing.JLabel();
        lbDificuldade = new javax.swing.JLabel();
        cbDificuldade = new javax.swing.JComboBox<>();
        lbModoPreparo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtModoPreparo = new javax.swing.JTextArea();
        txtTempo = new javax.swing.JTextField();
        lbMin = new javax.swing.JLabel();
        lbIngredientes = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableIngredientes = new javax.swing.JTable();
        btCancela = new javax.swing.JButton();
        btSalva = new javax.swing.JButton();
        btExcluirIngrediente = new javax.swing.JButton();
        btIncluirIngrediente = new javax.swing.JButton();
        btAlterarIngrediente = new javax.swing.JButton();
        lbCustoEstimado = new javax.swing.JLabel();
        lbId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();

        setTitle("Cadastro Receita");

        lbNome.setText("Nome:");

        lbTexto.setText("Tempo:");

        lbDificuldade.setText("Dificuldade:");

        cbDificuldade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fácil", "Média", "Difícil" }));

        lbModoPreparo.setText("Modo de Preparo:");

        txtModoPreparo.setColumns(20);
        txtModoPreparo.setRows(5);
        jScrollPane1.setViewportView(txtModoPreparo);

        lbMin.setText("min");

        lbIngredientes.setText("Ingredientes:");

        tableIngredientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1 colher", "Azeite", "R$ 0,20"},
                {"1 und", "Macarrão Instantâneo", "R$ 2,00"},
                {"1 lata", "Extrato de Tomate", "R$ 3,50"}
            },
            new String [] {
                "Quantidade", "Ingrediente", "Custo Estimado"
            }
        ));
        jScrollPane2.setViewportView(tableIngredientes);
        if (tableIngredientes.getColumnModel().getColumnCount() > 0) {
            tableIngredientes.getColumnModel().getColumn(0).setPreferredWidth(80);
            tableIngredientes.getColumnModel().getColumn(1).setPreferredWidth(500);
            tableIngredientes.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        btCancela.setText("Cancela");

        btSalva.setText("Salva");

        btExcluirIngrediente.setText("Exclui");
        btExcluirIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirIngredienteActionPerformed(evt);
            }
        });

        btIncluirIngrediente.setText("Inclui");
        btIncluirIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIncluirIngredienteActionPerformed(evt);
            }
        });

        btAlterarIngrediente.setText("Altera");
        btAlterarIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarIngredienteActionPerformed(evt);
            }
        });

        lbCustoEstimado.setText("Custo Estimado Receita: R$ 5,70");

        lbId.setText("ID:");

        txtId.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNome)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 31, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTexto)
                            .addComponent(txtTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(lbMin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbDificuldade)
                                .addGap(29, 29, 29)
                                .addComponent(lbId)
                                .addGap(30, 30, 30))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbDificuldade, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbModoPreparo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbIngredientes)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbCustoEstimado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btIncluirIngrediente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAlterarIngrediente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btExcluirIngrediente)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btSalva)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancela)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTexto)
                            .addComponent(lbDificuldade)
                            .addComponent(lbId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbDificuldade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMin)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbIngredientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExcluirIngrediente)
                    .addComponent(btIncluirIngrediente)
                    .addComponent(btAlterarIngrediente)
                    .addComponent(lbCustoEstimado))
                .addGap(9, 9, 9)
                .addComponent(lbModoPreparo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancela)
                    .addComponent(btSalva))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btIncluirIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIncluirIngredienteActionPerformed
        abreInclusaoIngredienteReceita();
    }//GEN-LAST:event_btIncluirIngredienteActionPerformed

    private void btAlterarIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarIngredienteActionPerformed
        abreAlteracaoIngredienteReceita();
    }//GEN-LAST:event_btAlterarIngredienteActionPerformed

    private void btExcluirIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirIngredienteActionPerformed
        excluiIngredienteReceita();
    }//GEN-LAST:event_btExcluirIngredienteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterarIngrediente;
    private javax.swing.JButton btCancela;
    private javax.swing.JButton btExcluirIngrediente;
    private javax.swing.JButton btIncluirIngrediente;
    private javax.swing.JButton btSalva;
    private javax.swing.JComboBox<String> cbDificuldade;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbCustoEstimado;
    private javax.swing.JLabel lbDificuldade;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbIngredientes;
    private javax.swing.JLabel lbMin;
    private javax.swing.JLabel lbModoPreparo;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbTexto;
    private javax.swing.JTable tableIngredientes;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextArea txtModoPreparo;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTempo;
    // End of variables declaration//GEN-END:variables

    @Override
    protected void reset() {
        txtNome.setText("");
        txtTempo.setText("");
        cbDificuldade.setSelectedIndex(-1);
        lbCustoEstimado.setText("Custo Estimado Receita: (não calculado)");
        tableIngredientes.setModel(new IngredientesReceitaTableModel());
        txtModoPreparo.setText("");
    }

    @Override
    protected void setDados(DadosReceita item) {
        txtNome.setText(item.nome);
        txtTempo.setText("" + item.tempo);
        cbDificuldade.setSelectedItem(item.dificuldade);
        if (AcoesCadastro.ACAO_ALTERA.equals(this.acao)) {
            txtId.setText("" + item.idReceita);
            lbId.setVisible(true);
            txtId.setVisible(true);
        } else {
            txtId.setText("");
            lbId.setVisible(false);
            txtId.setVisible(false);
        }
        this.ingredientesReceita = new ArrayList<>(item.ingredientes);
        tableIngredientes.setModel(new IngredientesReceitaTableModel(this.ingredientesReceita));
    }

    @Override
    public DadosReceita getDados() {
        DadosReceita dadosReceita = new DadosReceita();
        dadosReceita.idReceita = 0;
        if (AcoesCadastro.ACAO_ALTERA.equals(this.acao)) {
            dadosReceita.idReceita = Integer.parseInt(txtId.getText());
        }
        dadosReceita.nome = txtNome.getText();
        try {
            dadosReceita.tempo = Integer.parseInt(txtTempo.getText());
        } catch (NumberFormatException e) {
            dadosReceita.tempo = 0;
        }
        dadosReceita.modoPreparo = txtModoPreparo.getText();
        dadosReceita.ingredientes = ingredientesReceita;
        return dadosReceita;
    }

    @Override
    protected void initFmComponents() {
        initComponents();
    }

    @Override
    protected JButton getBtOk() {
        return btSalva;
    }

    @Override
    protected JButton getBtCancela() {
        return btCancela;
    }

    private DadosIngredienteReceita getIngredienteReceitaSelecionado() {
        int row = tableIngredientes.getSelectedRow();
        if (row > -1) {
            return this.ingredientesReceita.get(row);
        }
        return null;
    }
    
    private void abreInclusaoIngredienteReceita() {
        fmIngredienteReceita.setDados(new DadosIngredienteReceita());
        fmIngredienteReceita.setVisible(true);
    }
    
    private boolean validaIngredienteDuplicado(DadosIngredienteReceita ingredienteReceita) {
        for (DadosIngredienteReceita dadosIngredienteReceita : ingredientesReceita) {
            if (dadosIngredienteReceita != ingredienteReceita && dadosIngredienteReceita.ingrediente.id == ingredienteReceita.ingrediente.id) {
                JOptionPane.showMessageDialog(null, "Este ingrediente já foi incluído na receita! Altere a quantidade.");
                return false;
            }
        }
        return true;
    }
    
    public void incluirIngrediente(DadosIngredienteReceita ingredienteReceita) {
        if (validaIngredienteDuplicado(ingredienteReceita)) {
            this.ingredientesReceita.add(ingredienteReceita);
            ((IngredientesReceitaTableModel)tableIngredientes.getModel()).addIngredienteReceita(ingredienteReceita);
            fmIngredienteReceita.setVisible(false);
        }
    }

    private void abreAlteracaoIngredienteReceita() {
        DadosIngredienteReceita ingredienteReceita = getIngredienteReceitaSelecionado();
        if (ingredienteReceita != null) {
            fmIngredienteReceita.setDados(ingredienteReceita);
            fmIngredienteReceita.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum ingrediente selecionado!");
        }
    }
    
    public void alterarIngrediente(DadosIngredienteReceita ingredienteReceita) {
        if (validaIngredienteDuplicado(ingredienteReceita)) {
            ((IngredientesReceitaTableModel)tableIngredientes.getModel()).fireTableDataChanged();
            fmIngredienteReceita.setVisible(false);
        }
    }

    private void excluiIngredienteReceita() {
        DadosIngredienteReceita ingredienteReceita = getIngredienteReceitaSelecionado();
        if (ingredienteReceita != null) {
            if (JOptionPane.showConfirmDialog(null, "Deseja realmente remover o ingrediente selecionado?", "Confirmação", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                int idx = this.ingredientesReceita.indexOf(ingredienteReceita);
                this.ingredientesReceita.remove(idx);
                IngredientesReceitaTableModel model = (IngredientesReceitaTableModel)this.tableIngredientes.getModel();
                model.removeIngredienteReceita(idx);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum ingrediente selecionado!");
        }
    }

    private class IngredientesReceitaTableModel extends AbstractTableModel {

        private List<DadosIngredienteReceita> ingredientesReceita;

        private String[] colunas = new String[]{
            "Quantidade", "Ingrediente", "Custo Estimado"
        };

        public IngredientesReceitaTableModel() {
            this.ingredientesReceita = new ArrayList<>();
        }
        
        public IngredientesReceitaTableModel(List<DadosIngredienteReceita> ingredientesReceita) {
            this.ingredientesReceita = ingredientesReceita;
        }

        @Override
        public int getRowCount() {
            return ingredientesReceita.size();
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

        public void addIngredienteReceita(DadosIngredienteReceita dadosIngredienteReceita) {
            ingredientesReceita.add(dadosIngredienteReceita);
            int ultimoIndice = getRowCount() - 1;
            fireTableRowsInserted(ultimoIndice, ultimoIndice);
        }

        public void removeIngredienteReceita(int indiceLinha) {
            ingredientesReceita.remove(indiceLinha);
            fireTableRowsDeleted(indiceLinha, indiceLinha);
        }

        public void limpar() {
            ingredientesReceita.clear();
            fireTableDataChanged();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            DadosIngredienteReceita ingredienteReceita = ingredientesReceita.get(rowIndex);
            String valueObject = null;
            switch (columnIndex) {
                case 0:
                    valueObject = ingredienteReceita.quantidade + " " + (ingredienteReceita.quantidade > 1 ? ingredienteReceita.unidade.getNomePlural() : ingredienteReceita.unidade.getNomeSingular());
                    break;
                case 1:
                    valueObject = ingredienteReceita.ingrediente.nome;
                    break;
                case 2:
                    try {
                        valueObject = "" + ingredienteReceita.getCustoEstimado();
                    } catch (Exception e) {
                        valueObject = e.getMessage();
                    }
                    break;
                default:
                    System.err.println("Índice inválido para propriedade do bean IngredienteDTO.class");
            }
            return valueObject;
        }
    }
}

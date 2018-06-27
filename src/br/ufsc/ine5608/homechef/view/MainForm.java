/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5608.homechef.view;

import br.ufsc.ine5608.homechef.controller.ControladorIngrediente;
import br.ufsc.ine5608.homechef.controller.ControladorReceita;
import br.ufsc.ine5608.homechef.dto.DadosReceita;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Flávio
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form Teste
     */
    public MainForm() {
        initComponents();
        tableReceitas.setModel(new FmListarReceitas().getTable().getModel());
        //tableItemEstoque.setModel(new FmListarIngredientes().getTable().getModel());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableItemEstoque = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableReceitas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbDificuldadeReceita = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbTempoReceita = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfNomeReceita = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfNomeItemEstoque = new javax.swing.JTextField();
        ckbFiltraReceitasPorIngredienteSelecionado = new javax.swing.JCheckBox();
        ckbFiltraItensVencendoEm10Dias = new javax.swing.JCheckBox();
        btPrepararReceitaSelecionada = new javax.swing.JButton();
        btGerarListaCompras = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuEstoque = new javax.swing.JMenu();
        smenuEstoqueEntrada = new javax.swing.JMenuItem();
        smenuEstoqueSaida = new javax.swing.JMenuItem();
        menuCadastro = new javax.swing.JMenu();
        smenuCadastroIngrediente = new javax.swing.JMenuItem();
        smenuCadastroReceita = new javax.swing.JMenuItem();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HomeChef");

        tableItemEstoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Leite", "1 Litro", "10/05/2018"},
                {"Farinha de Trigo", "1 Kg", "01/01/2019"},
                {"Macarrão Instantâneo", "2 und", "05/03/2022"}
            },
            new String [] {
                "Nome", "Qtd", "Validade"
            }
        ));
        jScrollPane2.setViewportView(tableItemEstoque);
        if (tableItemEstoque.getColumnModel().getColumnCount() > 0) {
            tableItemEstoque.getColumnModel().getColumn(0).setPreferredWidth(200);
            tableItemEstoque.getColumnModel().getColumn(1).setPreferredWidth(50);
        }

        tableReceitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Pudim de Leite", "40 min", "Média", "Não", "R$ 10,00"},
                {"Feijoada", "1h30min", "Fácil", "Sim", "R$ 15,00"},
                {"Miojo", "5min", "Fácil", "Sim", "R$ 4,00"}
            },
            new String [] {
                "Nome", "Tempo", "Dificuldade", "Possível", "Custo Estimado"
            }
        ));
        jScrollPane3.setViewportView(tableReceitas);
        if (tableReceitas.getColumnModel().getColumnCount() > 0) {
            tableReceitas.getColumnModel().getColumn(0).setPreferredWidth(200);
            tableReceitas.getColumnModel().getColumn(1).setPreferredWidth(60);
            tableReceitas.getColumnModel().getColumn(2).setPreferredWidth(60);
            tableReceitas.getColumnModel().getColumn(3).setPreferredWidth(60);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Ingredientes disponíveis:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Receitas:");

        cbDificuldadeReceita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas", "Fácil", "Média", "Difícil" }));

        jLabel3.setText("Dificuldade:");

        cbTempoReceita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas", "Até 15min", "De 16min até 30min", "Acima de 30min" }));

        jLabel4.setText("Tempo:");

        jLabel5.setText("Nome:");

        jLabel6.setText("Nome:");

        ckbFiltraReceitasPorIngredienteSelecionado.setText("Listar somente receitas que usam o ingrediente selecionado");

        ckbFiltraItensVencendoEm10Dias.setText("Listar ingredientes que vencerão em 10 dias");

        btPrepararReceitaSelecionada.setText("Preparar Receita Selecionada");

        btGerarListaCompras.setText("Gerar Lista de Compras");

        jMenuBar1.setToolTipText("");

        menuEstoque.setText("Estoque");

        smenuEstoqueEntrada.setText("Entrada de Estoque");
        smenuEstoqueEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smenuEstoqueEntradaActionPerformed(evt);
            }
        });
        menuEstoque.add(smenuEstoqueEntrada);

        smenuEstoqueSaida.setText("Saída de Estoque");
        menuEstoque.add(smenuEstoqueSaida);

        jMenuBar1.add(menuEstoque);

        menuCadastro.setText("Cadastro");

        smenuCadastroIngrediente.setText("Ingredientes");
        smenuCadastroIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smenuCadastroIngredienteActionPerformed(evt);
            }
        });
        menuCadastro.add(smenuCadastroIngrediente);

        smenuCadastroReceita.setText("Receitas");
        smenuCadastroReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smenuCadastroReceitaActionPerformed(evt);
            }
        });
        menuCadastro.add(smenuCadastroReceita);

        jMenuBar1.add(menuCadastro);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(tfNomeReceita, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTempoReceita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(cbDificuldadeReceita, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(ckbFiltraReceitasPorIngredienteSelecionado))
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(tfNomeItemEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ckbFiltraItensVencendoEm10Dias)))
                                .addGap(0, 74, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btGerarListaCompras)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btPrepararReceitaSelecionada)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNomeItemEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ckbFiltraItensVencendoEm10Dias))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ckbFiltraReceitasPorIngredienteSelecionado)
                .addGap(6, 6, 6)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTempoReceita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDificuldadeReceita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNomeReceita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPrepararReceitaSelecionada)
                    .addComponent(btGerarListaCompras))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void smenuCadastroIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smenuCadastroIngredienteActionPerformed
        ControladorIngrediente.getInstance().inicia();
    }//GEN-LAST:event_smenuCadastroIngredienteActionPerformed

    private void smenuCadastroReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smenuCadastroReceitaActionPerformed
        ControladorReceita.getInstance().inicia();
    }//GEN-LAST:event_smenuCadastroReceitaActionPerformed

    private void smenuEstoqueEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smenuEstoqueEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_smenuEstoqueEntradaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btGerarListaCompras;
    private javax.swing.JButton btPrepararReceitaSelecionada;
    private javax.swing.JComboBox<String> cbDificuldadeReceita;
    private javax.swing.JComboBox<String> cbTempoReceita;
    private javax.swing.JCheckBox ckbFiltraItensVencendoEm10Dias;
    private javax.swing.JCheckBox ckbFiltraReceitasPorIngredienteSelecionado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenu menuEstoque;
    private javax.swing.JMenuItem smenuCadastroIngrediente;
    private javax.swing.JMenuItem smenuCadastroReceita;
    private javax.swing.JMenuItem smenuEstoqueEntrada;
    private javax.swing.JMenuItem smenuEstoqueSaida;
    private javax.swing.JTable tableItemEstoque;
    private javax.swing.JTable tableReceitas;
    private javax.swing.JTextField tfNomeItemEstoque;
    private javax.swing.JTextField tfNomeReceita;
    // End of variables declaration//GEN-END:variables

    private class FmListarReceitas extends FmBaseTable<DadosReceita> {

    /**
     * Creates new form FmListarReceitas
     */
        public FmListarReceitas() {
            super();
        }
        
        @Override
    protected JTable getTable() {
        return tableReceitas;
    }

    @Override
    protected TableModel getTableModel() {
        ReceitasTableModel model = new ReceitasTableModel();
        model.addListaReceitas(this.list);
        return model;
    }

    @Override
    protected void initFmComponents() {
        initComponents();
    }

        @Override
        protected void defineCommands() {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

    private class ReceitasTableModel extends AbstractTableModel {

        private List<DadosReceita> receitas;

        private String[] colunas = new String[]{
            "Nome", "Tempo", "Dificuldade", "Possível", "Custo estimado"
        };

        public ReceitasTableModel() {
            this.receitas = new ArrayList<>();
        }

        @Override
        public int getRowCount() {
            return receitas.size();
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

        public void addReceita(DadosReceita dadosReceita) {
            receitas.add(dadosReceita);
            int ultimoIndice = getRowCount() - 1;
            fireTableRowsInserted(ultimoIndice, ultimoIndice);
        }

        public void addListaReceitas(List<DadosReceita> novasReceitas) {
            int tamanhoAntigo = getRowCount();
            receitas.addAll(novasReceitas);
            fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
        }

        public void removeReceita(int indiceLinha) {
            receitas.remove(indiceLinha);
            fireTableRowsDeleted(indiceLinha, indiceLinha);
        }

        public void limpar() {
            receitas.clear();
            fireTableDataChanged();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            DadosReceita receita = receitas.get(rowIndex);
            String valueObject = null;
            switch (columnIndex) {
                case 0:
                    valueObject = receita.nome;
                    break;
                case 1:
                    valueObject = "" + receita.tempo;
                    break;
                case 2:
                    valueObject = receita.dificuldade.getNome();
                    break;
                case 3:
                    //valueObject = possivel ou não;
                case 4: 
                    //custo estimado
                default:
                    System.err.println("Índice inválido para propriedade de DadosReceita.class");
            }
            return valueObject;
        }
    }
    }
}

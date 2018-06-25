/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5608.homechef.view;

import br.ufsc.ine5608.homechef.dto.DadosIngrediente;

import javax.swing.*;
import javax.swing.table.TableModel;

/**
 *
 * @author Gabriel
 */
public class FmListarIngredientes extends FmBaseTable<DadosIngrediente> {

    /**
     * Creates new form NewJFrame
     */
    public FmListarIngredientes() {
    }

    @Override
    protected void initFmComponents() {
        initComponents();
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
        ingredienteTable = new javax.swing.JTable();
        ingredienteLabel = new javax.swing.JLabel();
        incluiBtn = new javax.swing.JButton();
        alteraBtn = new javax.swing.JButton();
        excluiBtn = new javax.swing.JButton();
        fecharBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ingredienteTable.setModel(new IngredienteTableModel());
        jScrollPane1.setViewportView(ingredienteTable);
        if (ingredienteTable.getColumnModel().getColumnCount() > 0) {
            ingredienteTable.getColumnModel().getColumn(2).setResizable(false);
        }

        ingredienteLabel.setText("Ingredientes:");

        incluiBtn.setText("Inclui");

        alteraBtn.setText("Altera");

        excluiBtn.setText("Exclui");

        fecharBtn.setText("Fechar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(fecharBtn)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ingredienteLabel)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(excluiBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(alteraBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(incluiBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(41, 41, 41))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ingredienteLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(incluiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(alteraBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(excluiBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(fecharBtn)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
  
    @Override
    protected JTable getTable() {
        return ingredienteTable;
    }

    @Override
    protected TableModel getTableModel() {
        IngredienteTableModel tbModel = new IngredienteTableModel();
        
        tbModel.addListaDeIngredienteDTOs(this.list);
        
        return tbModel;
    }

    @Override
    protected void defineCommands() {
        this.incluiBtn.setActionCommand(AcoesCadastro.ACAO_INCLUI);
        this.incluiBtn.addActionListener(actManager);
        
        this.alteraBtn.setActionCommand(AcoesCadastro.ACAO_ALTERA);
        this.alteraBtn.addActionListener(actManager);
        
        this.excluiBtn.setActionCommand(AcoesCadastro.ACAO_EXCLUI);
        this.excluiBtn.addActionListener(actManager);
        
        this.fecharBtn.setActionCommand(AcoesCadastro.ACAO_CANCELA);
        this.fecharBtn.addActionListener(actManager);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alteraBtn;
    private javax.swing.JButton excluiBtn;
    private javax.swing.JButton fecharBtn;
    private javax.swing.JButton incluiBtn;
    private javax.swing.JLabel ingredienteLabel;
    private javax.swing.JTable ingredienteTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5608.homechef.view;

import br.ufsc.ine5608.homechef.controller.ControladorIngrediente;
import br.ufsc.ine5608.homechef.controller.ControladorUnidade;
import br.ufsc.ine5608.homechef.dto.DadosItemEstoque;
import br.ufsc.ine5608.homechef.model.Ingrediente;
import br.ufsc.ine5608.homechef.model.Unidade;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Gabriel
 */
public class FmRegistrarEntradaEstoque extends javax.swing.JFrame {

    private ITelaItemEstoqueObserver observer;
    private Collection<Ingrediente> ingredientes;

    /**
     * Creates new form RegistrarEntradaEstoque
     */
    public FmRegistrarEntradaEstoque() {
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

        lbIngrediente = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listIngrediente = new javax.swing.JList<>();
        btCancela = new javax.swing.JButton();
        btSalva = new javax.swing.JButton();
        lbUnidade = new javax.swing.JLabel();
        cbUnidade = new javax.swing.JComboBox<>();
        lbQuantidade = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        lbValidade = new javax.swing.JLabel();
        txtValidade = new javax.swing.JFormattedTextField();
        txtIngrediente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbIngrediente.setText("Ingrediente:");

        listIngrediente.setModel(new IngredienteListModel());
        listIngrediente.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listIngredienteValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listIngrediente);

        btCancela.setText("Cancela");
        btCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelaActionPerformed(evt);
            }
        });

        btSalva.setText("Salva");
        btSalva.setMaximumSize(new java.awt.Dimension(71, 23));
        btSalva.setMinimumSize(new java.awt.Dimension(71, 23));
        btSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvaActionPerformed(evt);
            }
        });

        lbUnidade.setText("Unidade:");

        cbUnidade.setModel(new UnidadeComboModel());

        lbQuantidade.setText("Quantidade:");

        lbValidade.setText("Validade:");

        try {
            new MaskFormatter("##/##/####").install(txtValidade);
        } catch (ParseException e) {
        }
        txtValidade.setToolTipText("");

        txtIngrediente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIngredienteKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btSalva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lbIngrediente)
                                                        .addComponent(lbUnidade)
                                                        .addComponent(lbQuantidade)
                                                        .addComponent(lbValidade))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtValidade, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jScrollPane1)
                                                                .addComponent(cbUnidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtIngrediente))
                                                .addGap(0, 116, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btCancela)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbIngrediente)
                                        .addComponent(txtIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(cbUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lbUnidade))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lbQuantidade)
                                                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(lbValidade))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(70, 70, 70)
                                                .addComponent(txtValidade, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btCancela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btSalva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtIngredienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIngredienteKeyReleased
        List<Ingrediente> ingredientes = filtraIngrediente();
        getListIngredienteModel().setLista(ingredientes);
    }//GEN-LAST:event_txtIngredienteKeyReleased

    private void listIngredienteValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listIngredienteValueChanged
        Ingrediente ingredienteSelecionado = getIngredienteSelecionado();
        if (ingredienteSelecionado != null) {
            ArrayList<Unidade> unidadesRelacionadas = ControladorUnidade.getInstance().getUnidadesRelacionadas(ControladorUnidade.getInstance().getUnidadeBase(ingredienteSelecionado.getUnidade()).getId());
            getComboUnidadeModel().setLista(unidadesRelacionadas);
            getComboUnidade().setSelectedIndex(-1);
        }
    }//GEN-LAST:event_listIngredienteValueChanged

    private void btSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvaActionPerformed
        salvar();
    }//GEN-LAST:event_btSalvaActionPerformed

    private void btCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelaActionPerformed
        fechaTela();
    }//GEN-LAST:event_btCancelaActionPerformed

    public void setObserver(ITelaItemEstoqueObserver observer) {
        this.observer = observer;
    }

    public DadosItemEstoque getDados() throws Exception {
        Unidade unidade = getUnidadeSelecionada();
        Ingrediente ingrediente = getIngredienteSelecionado();
        LocalDate validade = null;
        if (!txtValidade.getText().isEmpty()) {
            try {
                validade = LocalDate.parse(txtValidade.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (Exception e) {
                throw new Exception("Data incorreta!");
            }
        }
        int quantidade = 0;
        if (!txtQuantidade.getText().isEmpty()) {
            try {
                quantidade = Integer.parseInt(txtQuantidade.getText());
            } catch (NumberFormatException e) {
            }
        }
        return new DadosItemEstoque(0,
                unidade,
                ingrediente,
                validade,
                quantidade);
    }

    public void setListaIngrediente() {
        ingredientes = ControladorIngrediente.getInstance().getIngredientes();
        getListIngredienteModel().addIngredientes(ingredientes);
    }

    private void salvar() {
        if (observer != null) {
            observer.salvaCadastro();
        }
    }

    private List<Ingrediente> filtraIngrediente() {
        return ingredientes.stream()
                .filter(ingrediente -> ingrediente.getNome().contains(txtIngrediente.getText().toLowerCase()))
                .collect(Collectors.toList());
    }

    private Ingrediente getIngredienteSelecionado() {
        int selectedIndex = getListIngrediente().getSelectedIndex();
        if (selectedIndex > -1) {
            return getListIngredienteModel().getElementAt(selectedIndex);
        }
        return null;
    }

    private JList getListIngrediente() {
        return listIngrediente;
    }

    private IngredienteListModel getListIngredienteModel() {
        return (IngredienteListModel) getListIngrediente().getModel();
    }

    private Unidade getUnidadeSelecionada() {
        int selectedIndex = getComboUnidade().getSelectedIndex();
        if (selectedIndex > -1) {
            return getComboUnidadeModel().getElementAt(selectedIndex);
        }
        return null;
    }

    private JComboBox<String> getComboUnidade() {
        return cbUnidade;
    }

    private UnidadeComboModel getComboUnidadeModel() {
        return (UnidadeComboModel) getComboUnidade().getModel();
    }

    public void fechaTela() {
        setVisible(false);
        limpaDados();
    }

    private void limpaDados() {
        listIngrediente.setModel(new IngredienteListModel());
        cbUnidade.setModel(new UnidadeComboModel());
        txtIngrediente.setText("");
        txtQuantidade.setText("");
        txtValidade.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancela;
    private javax.swing.JButton btSalva;
    private javax.swing.JComboBox<String> cbUnidade;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbIngrediente;
    private javax.swing.JLabel lbQuantidade;
    private javax.swing.JLabel lbUnidade;
    private javax.swing.JLabel lbValidade;
    private javax.swing.JList<String> listIngrediente;
    private javax.swing.JTextField txtIngrediente;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JFormattedTextField txtValidade;
    // End of variables declaration//GEN-END:variables

    private class IngredienteListModel extends AbstractListModel {

        private List<Ingrediente> ingredientes;

        public IngredienteListModel() {
            this.ingredientes = new ArrayList<>();
        }

        @Override
        public int getSize() {
            return ingredientes.size();
        }

        @Override
        public Ingrediente getElementAt(int index) {
            return ingredientes.get(index);
        }

        private void addIngredientes(Collection<Ingrediente> ingredientes) {
            int tamanhoAntigo = getSize();
            this.ingredientes.addAll(ingredientes);
            fireContentsChanged(ingredientes, tamanhoAntigo, getSize() - 1);
        }

        private void setLista(List<Ingrediente> ingredientes) {
            int tamanhoAntigo = getSize();
            this.ingredientes = ingredientes;
            fireContentsChanged(ingredientes, tamanhoAntigo, getSize() - 1);
        }
    }

    private class UnidadeComboModel extends DefaultComboBoxModel {

        private List<Unidade> unidades;

        public UnidadeComboModel() {
            this.unidades = new ArrayList<>();
        }

        @Override
        public int getSize() {
            return unidades.size();
        }

        @Override
        public Unidade getElementAt(int index) {
            return unidades.get(index);
        }

        public void setLista(ArrayList<Unidade> unidades) {
            int tamanhoAntigo = getSize();
            this.unidades = unidades;
            fireContentsChanged(unidades, tamanhoAntigo, getSize() - 1);
        }
    }

}

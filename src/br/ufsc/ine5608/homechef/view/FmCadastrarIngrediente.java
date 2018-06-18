/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5608.homechef.view;

import br.ufsc.ine5608.homechef.controller.ControladorUnidade;
import br.ufsc.ine5608.homechef.dto.DadosIngrediente;
import br.ufsc.ine5608.homechef.model.Unidade;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

/**
 *
 * @author Flávio
 */
public class FmCadastrarIngrediente extends FmBaseCadastro<DadosIngrediente> {
    
    private ArrayList<Unidade> unidades;
    private ArrayList<Unidade> unidadesRelacionadas;

    /**
     * Creates new form FmIngredienteTable
     */
    public FmCadastrarIngrediente() {
        super();
    }
    
    @Override
    protected void initFmComponents() {
        initComponents();
        setListaUnidades();
    }
    
    private Unidade getUnidadeSelecionada() {
        Unidade unidade = null;
        if (cbUnd.getSelectedIndex() > -1) {
            unidade = unidades.get(cbUnd.getSelectedIndex());
        }
        return unidade;
    }
    
    private Unidade getUnidadePrecoSelecionada() {
        Unidade unidade = null;
        if (cbUndPreco.getSelectedIndex() > -1) {
            unidade = unidadesRelacionadas.get(cbUndPreco.getSelectedIndex());
        }
        return unidade;
    }
    
    public void setListaUnidades() {
        this.unidades = new ArrayList<>(ControladorUnidade.getInstance().getUnidadesBase());
        carregaCbUnidade();
        carregaCbUnidadePreco(this.unidades.get(0));
    }
    
    private void carregaCbUnidade() {
        DefaultComboBoxModel model = new DefaultComboBoxModel(unidades.toArray(new Unidade[0]));
        cbUnd.setModel(model);
    }
    
    private void carregaCbUnidadePreco(Unidade unidadeBase) {
        if (unidadeBase != null) {
            unidadesRelacionadas = ControladorUnidade.getInstance().getUnidadesRelacionadas(unidadeBase.getId());
        } else {
            unidadesRelacionadas = new ArrayList<>();
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel(unidadesRelacionadas.toArray(new Unidade[0]));
        cbUndPreco.setModel(model);
    }

    @Override
    protected void reset() {
        lbId.setText("");
        txtQtdPreco.setText("");
        txtNome.setText("");
        txtPreco.setText("");
        cbUnd.setSelectedIndex(-1);
        cbUndPreco.setSelectedIndex(-1);
    }

    @Override
    protected void setDados(DadosIngrediente ingrediente) {
        lbId.setVisible(ingrediente.id > 0);
        lbId.setText("ID: " + ingrediente.id);
        txtNome.setText(ingrediente.nome);
        setUnidade(ingrediente.unidade);
        setUnidadePreco(ingrediente.unidadePreco);
        txtPreco.setText("" + ingrediente.preco);
        txtQtdPreco.setText("" + ingrediente.quantidadePreco);
    }
    
    private void setUnidade(Unidade unidade) {
        int idx = -1;
        if (unidade != null) {
            for (int i = 0; i < unidades.size(); i++) {
                if (unidades.get(i).getId() == unidade.getId()) {
                    idx = i;
                    break;
                }
            }
        }
        cbUnd.setSelectedIndex(idx);
    }
    
    private void setUnidadePreco(Unidade unidadePreco) {
        int idx = -1;
        if (unidadePreco != null) {
            for (int i = 0; i < unidadesRelacionadas.size(); i++) {
                if (unidadesRelacionadas.get(i).getId() == unidadePreco.getId()) {
                    idx = i;
                    break;
                }
            }
        }
        cbUndPreco.setSelectedIndex(idx);
    }

    @Override
    public DadosIngrediente getDados() {
        int id = 0;
        if (this.acao.equals(AcoesCadastro.ACAO_ALTERA)) {
            id = Integer.parseInt(lbId.getText().replaceAll("[^0-9]", ""));
        }
        double preco = 0;
        if (!txtPreco.getText().isEmpty()) {
            try {
                preco = Double.parseDouble(txtPreco.getText());
            } catch (Exception e) {
            }
        }
        int qtdPreco = 0;
        if (!txtQtdPreco.getText().isEmpty()) {
            try {
                qtdPreco = Integer.parseInt(txtQtdPreco.getText());
            } catch (Exception e) {
            }
        }
        return new DadosIngrediente(id,
                                    txtNome.getText(),
                                    preco,
                                    getUnidadeSelecionada(),
                                    getUnidadePrecoSelecionada(),
                                    qtdPreco);
    }
    
    @Override
    protected JButton getBtOk() {
        return this.btSalva;
    }

    @Override
    protected JButton getBtCancela() {
        return this.btCancela;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbId = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbUnd = new javax.swing.JComboBox<>();
        txtPreco = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtQtdPreco = new javax.swing.JTextField();
        cbUndPreco = new javax.swing.JComboBox<>();
        btCancela = new javax.swing.JButton();
        btSalva = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();

        lbId.setText("ID:");

        jLabel1.setText("Nome:");

        jLabel2.setText("Unidade base:");

        jLabel3.setText("Preço:");

        cbUnd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbUnd.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbUndItemStateChanged(evt);
            }
        });

        jLabel4.setText("por");

        cbUndPreco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btCancela.setText("Cancela");

        btSalva.setText("Salva");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btSalva)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancela))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(lbId)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQtdPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbUndPreco, 0, 195, Short.MAX_VALUE))
                            .addComponent(txtNome)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbUnd, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbUnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtQtdPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbUndPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancela)
                    .addComponent(btSalva))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbUndItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbUndItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            carregaCbUnidadePreco((Unidade)evt.getItem());
        }
    }//GEN-LAST:event_cbUndItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancela;
    private javax.swing.JButton btSalva;
    private javax.swing.JComboBox<String> cbUnd;
    private javax.swing.JComboBox<String> cbUndPreco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQtdPreco;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5608.homechef.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

/**
 *
 * @author Flávio
 * @param <DTO>
 */
public abstract class FmBaseCadastro<DTO> extends javax.swing.JFrame {

    protected List<ITelaBaseCadastroObserver> observers;
    protected String acao;
    protected BaseCadastroActionManager actManager;
    
    /**
     * Creates new form FmBaseCadastro
     */
    public FmBaseCadastro() {
        initComponents();
        this.observers = new ArrayList<>();
        this.actManager = new BaseCadastroActionManager();
        
        initFmComponents();
        
        getBtOk().setActionCommand(AcoesCadastro.ACAO_OK);
        getBtOk().addActionListener(actManager);
        
        getBtCancela().setActionCommand(AcoesCadastro.ACAO_CANCELA);
        getBtCancela().addActionListener(actManager);
        
        setLocationRelativeTo(null);
    }
    
    protected abstract void reset();
    protected abstract void setDados(DTO item);
    public abstract DTO getDados();
    protected abstract void initFmComponents();
    protected abstract JButton getBtOk();
    protected abstract JButton getBtCancela();

    public void addObserver(ITelaBaseCadastroObserver observer) {
        if (!this.observers.contains(observer)) {
            this.observers.add(observer);
        }
    }
    
    public void removeObserver(ITelaBaseCadastroObserver observer) {
        this.observers.remove(observer);
    }
    
    private void notificaSalvar() {
        for (ITelaBaseCadastroObserver observer : this.observers) {
            observer.salvaCadastro(this.acao);
        }
    }
    
    public void abreInclusao() {
        this.acao = AcoesCadastro.ACAO_INCLUI;
        this.reset();
        setVisible(true);
    }
    
    public void abreAlteracao(DTO item) {
        this.acao = AcoesCadastro.ACAO_ALTERA;
        setDados(item);
        setVisible(true);
    }
    
    public void fechaTela() {
        setVisible(false);
    }
    
    
    
    private class BaseCadastroActionManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if (AcoesCadastro.ACAO_OK.equals(e.getActionCommand())) {
                notificaSalvar();
                fechaTela();
            } else if (AcoesCadastro.ACAO_CANCELA.equals(e.getActionCommand())) {
                fechaTela();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
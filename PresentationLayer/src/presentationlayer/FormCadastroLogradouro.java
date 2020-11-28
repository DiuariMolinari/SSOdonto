/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationlayer;

import businessLogicalLayer.BairroBLL;
import businessLogicalLayer.CidadeBLL;
import businessLogicalLayer.EstadoBLL;
import businessLogicalLayer.LogradouroBLL;
import businessLogicalLayer.PaisBLL;
import domain.Bairro;
import domain.Cidade;
import domain.Estado;
import domain.Logradouro;
import domain.Pais;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author sabri
 */
public class FormCadastroLogradouro extends javax.swing.JFrame {

    PaisBLL srvPais = new PaisBLL();
    EstadoBLL srvEstado = new EstadoBLL();
    CidadeBLL srvCidade =  new CidadeBLL();
    BairroBLL srvBairro = new BairroBLL();
    LogradouroBLL srvLogradouro = new LogradouroBLL();
    
    private Bairro lastBairro;
    private Logradouro lastLogradouro;
    private String lastNome;
    
    private DefaultTableModel model;
    
    /**
     * Creates new form FormCadastroLogradouro
     */
    public FormCadastroLogradouro() {
        initComponents();
        model = new DefaultTableModel();
        grdLogradouro.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbBairro = new javax.swing.JComboBox<>();
        btnSalvar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cmbPais = new javax.swing.JComboBox<>();
        cmbEstado = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cmbCidade = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        grdLogradouro = new javax.swing.JTable();
        btnAtualizar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        lblMensagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Logradouro");

        jLabel2.setText("Nome da Rua");

        jLabel3.setText("Bairro");

        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jLabel4.setText("País");

        jLabel5.setText("Estado");

        jLabel6.setText("Cidade");

        grdLogradouro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Bairro", "Cidade", "Estado", "País"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        grdLogradouro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grdLogradouroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(grdLogradouro);

        btnAtualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnDeletar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(cmbPais, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(cmbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(cmbBairro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(txtRua)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(btnAtualizar)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeletar))
                    .addComponent(lblMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            addListenerPais();
            
            preencheGrid();
            preencheCombo();
        } catch (SQLException ex) {
            Logger.getLogger(FormCadastroLogradouro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            if (cmbBairro.getSelectedItem() == null || txtRua.getText().trim().length() == 0) {
                return;
            }
            lblMensagem.setText(srvLogradouro.insert(new Logradouro(0, txtRua.getText(),(Bairro)cmbBairro.getSelectedItem())));
            lblMensagem.setForeground(new Color(0, 102, 0));
            preencheGrid();
            deselecionaCombo(); 
            limpaCampos();
            
        } catch (SQLException ex) {
            Logger.getLogger(FormCadastroAtendimento.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        try {
            if (cmbBairro.getSelectedItem() != null 
                    && !"".equals(txtRua.getText()) 
                    && (lastBairro != cmbBairro.getSelectedItem() 
                    || !lastNome.equals(txtRua.getText())) 
                    && lastLogradouro != null){
                lblMensagem.setText(srvLogradouro.update(new Logradouro(lastLogradouro.getId(), txtRua.getText(), (Bairro)cmbBairro.getSelectedItem())));
                lblMensagem.setForeground(Color.blue);
                preencheGrid();
                deselecionaCombo();
                limpaCampos();
                preenchePais();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormCadastroAtendimento.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void grdLogradouroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grdLogradouroMouseClicked
        try {
            int row = grdLogradouro.getSelectedRow();
            TableModel model = grdLogradouro.getModel();

            int id = (int)model.getValueAt(row, 0);

            String nome = (String)model.getValueAt(row, 1);
            txtRua.setText(nome);

            Pais pais = (Pais)model.getValueAt(row, 5);
            cmbPais.getModel().setSelectedItem(pais);
            preencheEstado();

            Estado estado = (Estado)model.getValueAt(row, 4);
            cmbEstado.getModel().setSelectedItem(estado);
            preencheCidade();

            Cidade cidade = (Cidade)model.getValueAt(row, 3);
            cmbCidade.getModel().setSelectedItem(cidade);
            preencheBairro();

            Bairro bairro = (Bairro)model.getValueAt(row, 2);
            cmbBairro.getModel().setSelectedItem(bairro);

            lastBairro = bairro;
            lastNome = nome;
            lastLogradouro = new Logradouro(id, nome, bairro);
        } catch (SQLException ex) {
            Logger.getLogger(FormCadastroLogradouro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_grdLogradouroMouseClicked

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        try {
            if (lastLogradouro != null){
                lblMensagem.setText(srvLogradouro.delete(lastLogradouro));
                lblMensagem.setForeground(Color.red);
                preencheGrid();
                deselecionaCombo(); 
                limpaCampos();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormCadastroAtendimento.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void preencheGrid() throws SQLException{
        ArrayList<Logradouro> logradouros = srvLogradouro.getAll();
         
        Object colunas[] = {"Id", "Nome", "Bairro", "Cidade", "Estado", "Pais"};
            model = new DefaultTableModel(colunas, 0);
            for (Logradouro logradouro : logradouros) {
                model.addRow( new Object[]{
                    logradouro.getId(),
                    logradouro.getNome(),
                    logradouro.getBairro(),
                    logradouro.getBairro().getCidade(),
                    logradouro.getBairro().getCidade().getEstado(),
                    logradouro.getBairro().getCidade().getEstado().getPais()
                });           
            }  
            grdLogradouro.setModel(model);
    }
    
    private void preencheCombo() throws SQLException{
        limpaCampos();

        preenchePais();
        deselecionaCombo();
    }
        
    private void deselecionaCombo(){
        cmbPais.setSelectedItem(null);
        cmbEstado.setSelectedItem(null);
        cmbCidade.setSelectedItem(null);
        cmbBairro.setSelectedItem(null);
    }
    
    private void limpaCampos(){
        cmbEstado.removeAllItems();  
        cmbCidade.removeAllItems();
        cmbBairro.removeAllItems();   
        txtRua.setText("");
    }
    
    private void preenchePais()throws SQLException{
        cmbPais.removeAllItems();
        ArrayList<Pais> paises = srvPais.getAll();
        for (Pais pais : paises) {
            cmbPais.addItem(pais);
        }
    }
    
    private void preencheEstado() throws SQLException{
        cmbEstado.removeAllItems();
        ArrayList<Estado> estados = srvEstado.getByPais((Pais)cmbPais.getSelectedItem());
        for (Estado estado : estados) {
            cmbEstado.addItem(estado);
        }
    }
    
    private void addListenerPais(){
        cmbPais.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent eventoItem){
                if (eventoItem.getStateChange() == ItemEvent.SELECTED) {
                    try {
                        preencheEstado();
                        cmbEstado.setSelectedItem(null);
                        addListenerEstado();
                    } catch (SQLException ex) {
                        Logger.getLogger(FormCadastroLogradouro.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }
    
    private void preencheCidade() throws SQLException{
        cmbCidade.removeAllItems();
        ArrayList<Cidade> cidades = srvCidade.getByEstado((Estado)cmbEstado.getSelectedItem());
        for (Cidade cidade : cidades) {
            cmbCidade.addItem(cidade);
        }
    }
    
    private void addListenerEstado(){
        cmbEstado.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent eventoItem){
                if (eventoItem.getStateChange() == ItemEvent.SELECTED) {
                    try {
                        preencheCidade();
                        cmbCidade.setSelectedItem(null);
                        addListenerCidade();
                    } catch (SQLException ex) {
                        Logger.getLogger(FormCadastroLogradouro.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }
    
    private void preencheBairro() throws SQLException{
        cmbBairro.removeAllItems();
        ArrayList<Bairro> bairros = srvBairro.getByCidade((Cidade)cmbCidade.getSelectedItem());
        for (Bairro bairro : bairros) {
            cmbBairro.addItem(bairro);
        }
    }
    
    private void addListenerCidade(){
        cmbCidade.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent eventoItem){
                if (eventoItem.getStateChange() == ItemEvent.SELECTED) {
                    try {
                        preencheBairro();
                        cmbBairro.setSelectedItem(null);
                    } catch (SQLException ex) {
                        Logger.getLogger(FormCadastroLogradouro.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormCadastroLogradouro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCadastroLogradouro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCadastroLogradouro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCadastroLogradouro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormCadastroLogradouro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<Bairro> cmbBairro;
    private javax.swing.JComboBox<Cidade> cmbCidade;
    private javax.swing.JComboBox<Estado> cmbEstado;
    private javax.swing.JComboBox<Pais> cmbPais;
    private javax.swing.JTable grdLogradouro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JTextField txtRua;
    // End of variables declaration//GEN-END:variables
}

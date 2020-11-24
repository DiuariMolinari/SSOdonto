/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationlayer;

/**
 *
 * @author sabri
 */
public class FormMenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FormMenuPrincipal
     */
    public FormMenuPrincipal() {
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

        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuServico = new javax.swing.JMenu();
        itemAtendimento = new javax.swing.JMenuItem();
        itemProcedimento = new javax.swing.JMenuItem();
        itemTipoProcedimento = new javax.swing.JMenuItem();
        menuFinanceiro = new javax.swing.JMenu();
        itemPagamento = new javax.swing.JMenuItem();
        itemTipoPagamento = new javax.swing.JMenuItem();
        menuGestao = new javax.swing.JMenu();
        itemClinica = new javax.swing.JMenuItem();
        itemFuncao = new javax.swing.JMenuItem();
        menuLocais = new javax.swing.JMenu();
        itemEndereco = new javax.swing.JMenuItem();
        itemLogradouro = new javax.swing.JMenuItem();
        itemBairro = new javax.swing.JMenuItem();
        itemCidade = new javax.swing.JMenuItem();
        itemEstado = new javax.swing.JMenuItem();
        itemPais = new javax.swing.JMenuItem();
        menuMaterias = new javax.swing.JMenu();
        itemEstoque = new javax.swing.JMenuItem();
        itemProduto = new javax.swing.JMenuItem();
        itemTipoEmbalagem = new javax.swing.JMenuItem();
        menuPessoas = new javax.swing.JMenu();
        itemColaborador = new javax.swing.JMenuItem();
        itemPaciente = new javax.swing.JMenuItem();
        itemUsuario = new javax.swing.JMenuItem();

        jMenuItem11.setText("jMenuItem11");

        jMenuItem25.setText("jMenuItem25");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Menu Principal");

        menuServico.setText("Serviços");

        itemAtendimento.setText("Atendimentos");
        itemAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAtendimentoActionPerformed(evt);
            }
        });
        menuServico.add(itemAtendimento);

        itemProcedimento.setText("Procedimentos");
        itemProcedimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemProcedimentoActionPerformed(evt);
            }
        });
        menuServico.add(itemProcedimento);

        itemTipoProcedimento.setText("Tipo de Procedimento");
        itemTipoProcedimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemTipoProcedimentoActionPerformed(evt);
            }
        });
        menuServico.add(itemTipoProcedimento);

        jMenuBar1.add(menuServico);

        menuFinanceiro.setText("Financeiro");

        itemPagamento.setText("Pagamentos");
        itemPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPagamentoActionPerformed(evt);
            }
        });
        menuFinanceiro.add(itemPagamento);

        itemTipoPagamento.setText("Tipo de Pagamento");
        itemTipoPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemTipoPagamentoActionPerformed(evt);
            }
        });
        menuFinanceiro.add(itemTipoPagamento);

        jMenuBar1.add(menuFinanceiro);

        menuGestao.setText("Gestão");

        itemClinica.setText("Clínicas");
        itemClinica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemClinicaActionPerformed(evt);
            }
        });
        menuGestao.add(itemClinica);

        itemFuncao.setText("Funções");
        itemFuncao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFuncaoActionPerformed(evt);
            }
        });
        menuGestao.add(itemFuncao);

        jMenuBar1.add(menuGestao);

        menuLocais.setText("Locais");

        itemEndereco.setText("Endereços");
        itemEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEnderecoActionPerformed(evt);
            }
        });
        menuLocais.add(itemEndereco);

        itemLogradouro.setText("Logradouros");
        itemLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemLogradouroActionPerformed(evt);
            }
        });
        menuLocais.add(itemLogradouro);

        itemBairro.setText("Bairros");
        itemBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBairroActionPerformed(evt);
            }
        });
        menuLocais.add(itemBairro);

        itemCidade.setText("Cidades");
        itemCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCidadeActionPerformed(evt);
            }
        });
        menuLocais.add(itemCidade);

        itemEstado.setText("Estados");
        itemEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEstadoActionPerformed(evt);
            }
        });
        menuLocais.add(itemEstado);

        itemPais.setText("Países");
        itemPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPaisActionPerformed(evt);
            }
        });
        menuLocais.add(itemPais);

        jMenuBar1.add(menuLocais);

        menuMaterias.setText("Materias");

        itemEstoque.setText("Estoques");
        itemEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEstoqueActionPerformed(evt);
            }
        });
        menuMaterias.add(itemEstoque);

        itemProduto.setText("Produtos");
        itemProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemProdutoActionPerformed(evt);
            }
        });
        menuMaterias.add(itemProduto);

        itemTipoEmbalagem.setText("Tipo de Embalagem");
        itemTipoEmbalagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemTipoEmbalagemActionPerformed(evt);
            }
        });
        menuMaterias.add(itemTipoEmbalagem);

        jMenuBar1.add(menuMaterias);

        menuPessoas.setText("Pessoas");

        itemColaborador.setText("Colaboradores");
        itemColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemColaboradorActionPerformed(evt);
            }
        });
        menuPessoas.add(itemColaborador);

        itemPaciente.setText("Pacientes");
        itemPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPacienteActionPerformed(evt);
            }
        });
        menuPessoas.add(itemPaciente);

        itemUsuario.setText("Usuários");
        itemUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemUsuarioActionPerformed(evt);
            }
        });
        menuPessoas.add(itemUsuario);

        jMenuBar1.add(menuPessoas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(408, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(294, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAtendimentoActionPerformed
       new FormCadastroAtendimento().setVisible(true);
    }//GEN-LAST:event_itemAtendimentoActionPerformed

    private void itemProcedimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemProcedimentoActionPerformed
        new FormCadastroProcedimento().setVisible(true);
    }//GEN-LAST:event_itemProcedimentoActionPerformed

    private void itemTipoProcedimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemTipoProcedimentoActionPerformed
        new FormCadastroTipoProcedimento().setVisible(true);
    }//GEN-LAST:event_itemTipoProcedimentoActionPerformed

    private void itemPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPagamentoActionPerformed
        new FormCadastroPagamento().setVisible(true);
    }//GEN-LAST:event_itemPagamentoActionPerformed

    private void itemTipoPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemTipoPagamentoActionPerformed
        new FormCadastroTipoPagamento().setVisible(true);
    }//GEN-LAST:event_itemTipoPagamentoActionPerformed

    private void itemClinicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemClinicaActionPerformed
        new FormCadastroClinica().setVisible(true);
    }//GEN-LAST:event_itemClinicaActionPerformed

    private void itemFuncaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemFuncaoActionPerformed
        new FormCadastroFuncao().setVisible(true);
    }//GEN-LAST:event_itemFuncaoActionPerformed

    private void itemEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEnderecoActionPerformed
        new FormCadastroEndereco().setVisible(true);
    }//GEN-LAST:event_itemEnderecoActionPerformed

    private void itemLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLogradouroActionPerformed
        new FormCadastroLogradouro().setVisible(true);
    }//GEN-LAST:event_itemLogradouroActionPerformed

    private void itemBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBairroActionPerformed
        new FormCadastroBairro().setVisible(true);
    }//GEN-LAST:event_itemBairroActionPerformed

    private void itemCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCidadeActionPerformed
        new FormCadastroCidade().setVisible(true);
    }//GEN-LAST:event_itemCidadeActionPerformed

    private void itemEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEstadoActionPerformed
        new FormCadastroEstado().setVisible(true);
    }//GEN-LAST:event_itemEstadoActionPerformed

    private void itemPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPaisActionPerformed
        new FormCadastroPais().setVisible(true);
    }//GEN-LAST:event_itemPaisActionPerformed

    private void itemEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEstoqueActionPerformed
        new FormCadastroEstoque().setVisible(true);
    }//GEN-LAST:event_itemEstoqueActionPerformed

    private void itemProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemProdutoActionPerformed
        new FormCadastroProduto().setVisible(true);
    }//GEN-LAST:event_itemProdutoActionPerformed

    private void itemTipoEmbalagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemTipoEmbalagemActionPerformed
        new FormCadastroTipoEmbalagem().setVisible(true);
    }//GEN-LAST:event_itemTipoEmbalagemActionPerformed

    private void itemColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemColaboradorActionPerformed
        new FormCadastroColaborador().setVisible(true);
    }//GEN-LAST:event_itemColaboradorActionPerformed

    private void itemPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPacienteActionPerformed
        new FormCadastroPaciente().setVisible(true);
    }//GEN-LAST:event_itemPacienteActionPerformed

    private void itemUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemUsuarioActionPerformed
        new FormCadastroUsuario().setVisible(true);
    }//GEN-LAST:event_itemUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(FormMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemAtendimento;
    private javax.swing.JMenuItem itemBairro;
    private javax.swing.JMenuItem itemCidade;
    private javax.swing.JMenuItem itemClinica;
    private javax.swing.JMenuItem itemColaborador;
    private javax.swing.JMenuItem itemEndereco;
    private javax.swing.JMenuItem itemEstado;
    private javax.swing.JMenuItem itemEstoque;
    private javax.swing.JMenuItem itemFuncao;
    private javax.swing.JMenuItem itemLogradouro;
    private javax.swing.JMenuItem itemPaciente;
    private javax.swing.JMenuItem itemPagamento;
    private javax.swing.JMenuItem itemPais;
    private javax.swing.JMenuItem itemProcedimento;
    private javax.swing.JMenuItem itemProduto;
    private javax.swing.JMenuItem itemTipoEmbalagem;
    private javax.swing.JMenuItem itemTipoPagamento;
    private javax.swing.JMenuItem itemTipoProcedimento;
    private javax.swing.JMenuItem itemUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenu menuFinanceiro;
    private javax.swing.JMenu menuGestao;
    private javax.swing.JMenu menuLocais;
    private javax.swing.JMenu menuMaterias;
    private javax.swing.JMenu menuPessoas;
    private javax.swing.JMenu menuServico;
    // End of variables declaration//GEN-END:variables
}

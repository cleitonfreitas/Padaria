package visao;

import controle.ProdutoController;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Categoria;
import modelo.Fornecedor;
import modelo.Produto;

public class FrmProduto extends javax.swing.JDialog {

    Categoria c = new Categoria();
    Produto p = new Produto();
    ProdutoController dao = new ProdutoController();
    List<Produto> produtosList = new ArrayList();
    List<Categoria>categoriaList = new ArrayList();

    public FrmProduto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        statusComponentes(false);
        produtosList = dao.localizar();
        preencherTabela();
        carregarComboFornecedor();
    }

    /**
     * MÉTODO HABILITA E DESABILITA COMPONENTES DA TELA. TRUE:HABILITA
     * FALSE:DESABILITA
     *
     * @param status
     */
    
    public void carregarComboFornecedor(){
        for(Categoria c : categoriaList){
            cbCategoria.addItem(c.getNome());
        }
    }
    public void statusComponentes(boolean status) {
        btNovo.setEnabled(!status);
        btAlterar.setEnabled(!status);
        btExcluir.setEnabled(!status);
        btSalvar.setEnabled(status);
        btCancelar.setEnabled(status);
        lbCodigoBarras.setEnabled(status);
        tfCodigoBarras.setEnabled(status);
        lbNome.setEnabled(status);
        tfNome.setEnabled(status);
        lbCategoria.setEnabled(status);
        cbCategoria.setEnabled(status);
        lbUnidadeMedida.setEnabled(status);
        cbUnidadeMedida.setEnabled(status);
        lbPesquisar.setEnabled(status);
        cbPesquisar.setEnabled(status);
        tfPesquisar.setEnabled(status);
        lbValor.setEnabled(status);
        tfValor.setEnabled(status);
    }

    /**
     * ´MÉTODO REALIZA A LIMPEZA DOS CAMPOS PARA NOVA UTILIZAÇÃO.
     */
    public void limparCampos() {
        tfCodigoBarras.setText("");
        tfNome.setText("");
        tfPesquisar.setText("");
        tfValor.setText("");
    }

    public void salvar() throws Exception {
        p.setNome(tfNome.getText());
        p.setCategoria((String) cbCategoria.getSelectedItem());
        p.setUnidadeMedida((String) cbUnidadeMedida.getSelectedItem());
        p.setCodigoBarras(tfCodigoBarras.getText());
        p.setValor(Double.parseDouble(tfValor.getText()));
                
        dao.salvar(p);
        atualizarTabela();
        JOptionPane.showMessageDialog(this, "Produto Cadatrado");
        atualizarTabela();
        statusComponentes(false);
        limparCampos();
        p = new Produto();  // limpando a variavel global
    }

    public void vincularCampos() {
        Produto produto = produtosList.get(tblProdutos.getSelectedRow());

        tfNome.setText(produto.getNome());
        tfCodigoBarras.setText(produto.getCodigoBarras());
        tfValor.setText(String.valueOf(produto.getValor()));
        
    }

    public void excluir() {
        if (tblProdutos.getSelectedRow() > -1) {
            int linhaClicada = tblProdutos.getSelectedRow();
            Produto prod = produtosList.get(linhaClicada);
            ((DefaultTableModel) tblProdutos.getModel()).removeRow(tblProdutos.getSelectedRow());
            dao.remover(Produto.class, prod.getId());
            atualizarTabela();
            JOptionPane.showMessageDialog(this, "Produto Excluido");
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um Produto");
        }
    }

    public void preencherTabela() {
        DefaultTableModel dtm = (DefaultTableModel) tblProdutos.getModel();
        for (Produto produto : produtosList) {
            dtm.addRow(new Object[]{produto.getId(), produto.getNome(), produto.getCategoria(), produto.getUnidadeMedida(), produto.getValor()});
        }
    }

    public void alterar() {
        if (tblProdutos.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selecione uma linha!!!");
        } else {
            statusComponentes(true);
            int linha = tblProdutos.getSelectedRow();
            p = produtosList.get(linha);           
            p = dao.consultarPorId(Produto.class,p.getId());
        }
    }

    public void atualizarTabela() {
        DefaultTableModel dtm = (DefaultTableModel) tblProdutos.getModel();
        dtm.setNumRows(0);  // limpa os dados da tabela
        produtosList = dao.localizar();
        preencherTabela();
    }

    public void pesquisar() {
        String str = "from Produto p ";
        String atributo = "";
        if (cbPesquisar.getSelectedItem().toString().equals("Nome")) {
            atributo = "p.nome";
        }
        if (cbPesquisar.getSelectedItem().toString().equals("CodigoBarras")) {
            atributo = "p.barras";
        }

        String filtro = tfPesquisar.getText();
        if (filtro.length() > 0 && filtro != null) {
            str += "where upper(" + atributo + ") like '" + filtro.toUpperCase() + "%' ";
        }

        str += "order by " + atributo;
        produtosList = dao.pesquisarRelease(str);//ATUALIZA A LISTA COM OS DADOS DESTA PESQUISA RELEASE
        DefaultTableModel dtm = (DefaultTableModel) tblProdutos.getModel();
        dtm.setNumRows(0);
        preencherTabela();
    }
    

    public void novoCadastro() {
        statusComponentes(true);
        tfCodigoBarras.requestFocus();//direcionando o ponteiro do mouse para este componente
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        buttonGroupTipo = new javax.swing.ButtonGroup();
        buttonGroupSexo = new javax.swing.ButtonGroup();
        pnBotoes = new javax.swing.JPanel();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        pnDados = new javax.swing.JPanel();
        lbCodigoBarras = new javax.swing.JLabel();
        tfCodigoBarras = new javax.swing.JTextField();
        lbNome = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        lbCategoria = new javax.swing.JLabel();
        lbUnidadeMedida = new javax.swing.JLabel();
        pnTabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        lbPesquisar = new javax.swing.JLabel();
        tfPesquisar = new javax.swing.JTextField();
        cbPesquisar = new javax.swing.JComboBox();
        btLocalizar = new javax.swing.JButton();
        cbCategoria = new javax.swing.JComboBox();
        cbUnidadeMedida = new javax.swing.JComboBox();
        lbValor = new javax.swing.JLabel();
        tfValor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SoftPaes - Cadastro de Produtos");

        pnBotoes.setBackground(new java.awt.Color(102, 102, 255));
        pnBotoes.setLayout(new java.awt.GridLayout(1, 0));

        btNovo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONES/User-icon2 (Custom).png"))); // NOI18N
        btNovo.setText("Novo");
        btNovo.setToolTipText("cadastrar novo cliente");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        pnBotoes.add(btNovo);

        btSalvar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONES/save01_48.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.setToolTipText("salvar novo cadastro de cliente");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        pnBotoes.add(btSalvar);

        btExcluir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONES/Delete_01_48.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setToolTipText("exclui um cadastro");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        pnBotoes.add(btExcluir);

        btAlterar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONES/Editar01_48.png"))); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.setToolTipText("alterar cadastro de cliente");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });
        pnBotoes.add(btAlterar);

        btCancelar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONES/cancel-icon (Custom).png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.setToolTipText("cancelar a operação");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        pnBotoes.add(btCancelar);

        getContentPane().add(pnBotoes, java.awt.BorderLayout.PAGE_START);

        lbCodigoBarras.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lbCodigoBarras.setText("Cód.Barras:");

        tfCodigoBarras.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblProdutos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nome}"), tfCodigoBarras, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lbNome.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lbNome.setText("Nome:");

        tfNome.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblProdutos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.bairro}"), tfNome, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lbCategoria.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lbCategoria.setText("Categoria:");

        lbUnidadeMedida.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lbUnidadeMedida.setText("Und.Medida:");

        pnTabela.setBackground(new java.awt.Color(204, 204, 204));
        pnTabela.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "  Informações dos Produtos Cadastrados :  ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans", 1, 16), new java.awt.Color(0, 0, 204))); // NOI18N

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód.Produto", "Descrição", "Categoria", "Und.Medida", "Valor R$"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProdutos);

        lbPesquisar.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lbPesquisar.setForeground(new java.awt.Color(0, 51, 204));
        lbPesquisar.setText("Pesquisar:");
        lbPesquisar.setToolTipText("defina o tipo de pesquisa ex: por nome,cpf.");

        tfPesquisar.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        tfPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPesquisarKeyReleased(evt);
            }
        });

        cbPesquisar.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        cbPesquisar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nome", "CodigoBarras" }));

        btLocalizar.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btLocalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Search-icon (Custom).png"))); // NOI18N
        btLocalizar.setText("Localizar");
        btLocalizar.setToolTipText("clique para habilitar o campo de pesquisa");
        btLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLocalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnTabelaLayout = new javax.swing.GroupLayout(pnTabela);
        pnTabela.setLayout(pnTabelaLayout);
        pnTabelaLayout.setHorizontalGroup(
            pnTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTabelaLayout.createSequentialGroup()
                .addComponent(lbPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btLocalizar))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnTabelaLayout.setVerticalGroup(
            pnTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPesquisar)
                    .addComponent(tfPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLocalizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cbCategoria.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alimentos", "Bebidas" }));

        cbUnidadeMedida.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        cbUnidadeMedida.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "UND - Unidade", "KG - Quilograma" }));

        lbValor.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lbValor.setText("Valor em R$:");

        tfValor.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N

        javax.swing.GroupLayout pnDadosLayout = new javax.swing.GroupLayout(pnDados);
        pnDados.setLayout(pnDadosLayout);
        pnDadosLayout.setHorizontalGroup(
            pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pnDadosLayout.createSequentialGroup()
                            .addGap(281, 281, 281)
                            .addComponent(lbUnidadeMedida)
                            .addGap(155, 155, 155)
                            .addComponent(lbValor))
                        .addGroup(pnDadosLayout.createSequentialGroup()
                            .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tfCodigoBarras)
                                .addComponent(lbCategoria, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbCategoria, 0, 263, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addComponent(cbUnidadeMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(tfValor))
                        .addGroup(pnDadosLayout.createSequentialGroup()
                            .addComponent(lbCodigoBarras)
                            .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnDadosLayout.createSequentialGroup()
                                    .addGap(205, 205, 205)
                                    .addComponent(lbNome))
                                .addGroup(pnDadosLayout.createSequentialGroup()
                                    .addGap(202, 202, 202)
                                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(pnTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        pnDadosLayout.setVerticalGroup(
            pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnDadosLayout.createSequentialGroup()
                        .addComponent(lbCodigoBarras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnDadosLayout.createSequentialGroup()
                        .addComponent(lbNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCategoria)
                    .addComponent(lbUnidadeMedida)
                    .addComponent(lbValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbUnidadeMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        getContentPane().add(pnDados, java.awt.BorderLayout.CENTER);

        bindingGroup.bind();

        setSize(new java.awt.Dimension(722, 496));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        try {
            salvar();
        } catch (Exception ex) {
            Logger.getLogger(FrmProduto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btSalvarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        
        excluir();
        atualizarTabela();
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        statusComponentes(false);
        alterar();
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed

        limparCampos();
        novoCadastro();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed

        statusComponentes(false);
        atualizarTabela();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLocalizarActionPerformed

        cbPesquisar.setEnabled(true);
        tfPesquisar.setEnabled(true);
    }//GEN-LAST:event_btLocalizarActionPerformed

    private void tfPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisarKeyReleased

        pesquisar();
    }//GEN-LAST:event_tfPesquisarKeyReleased

    private void tblProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutosMouseClicked

        vincularCampos();
    }//GEN-LAST:event_tblProdutosMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btLocalizar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSalvar;
    private javax.swing.ButtonGroup buttonGroupSexo;
    private javax.swing.ButtonGroup buttonGroupTipo;
    private javax.swing.JComboBox cbCategoria;
    private javax.swing.JComboBox cbPesquisar;
    private javax.swing.JComboBox cbUnidadeMedida;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCategoria;
    private javax.swing.JLabel lbCodigoBarras;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbPesquisar;
    private javax.swing.JLabel lbUnidadeMedida;
    private javax.swing.JLabel lbValor;
    private javax.swing.JPanel pnBotoes;
    private javax.swing.JPanel pnDados;
    private javax.swing.JPanel pnTabela;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField tfCodigoBarras;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfPesquisar;
    private javax.swing.JTextField tfValor;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}

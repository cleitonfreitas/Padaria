/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

/**
 *
 * @author Cleiton
 */
public class FrmPedidoMesa extends javax.swing.JDialog {

    /**
     * Creates new form FrmPedido
     */
    public FrmPedidoMesa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        pnFundo = new java.awt.Panel();
        lbFichaMesa = new javax.swing.JLabel();
        tfNumFichaMesa = new javax.swing.JTextField();
        lbCodigoProduto = new javax.swing.JLabel();
        tfQuantidade = new javax.swing.JTextField();
        lbDescricao = new javax.swing.JLabel();
        tfDescricao = new javax.swing.JTextField();
        lbQuantidade = new javax.swing.JLabel();
        tfCodigoProduto1 = new javax.swing.JTextField();
        lbPreco = new javax.swing.JLabel();
        tfPreco = new javax.swing.JTextField();
        lbTotal = new javax.swing.JLabel();
        tfTotal = new javax.swing.JTextField();
        pnTabela = new java.awt.Panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        btRemoverItem = new javax.swing.JButton();
        btFinalizar = new javax.swing.JButton();
        lbTotalGeralPedido = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pedido de Mesa ou Ficha");
        setBackground(new java.awt.Color(83, 131, 181));

        pnFundo.setBackground(new java.awt.Color(83, 131, 181));

        lbFichaMesa.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbFichaMesa.setText("Mesa/Ficha N.:");

        tfNumFichaMesa.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        lbCodigoProduto.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbCodigoProduto.setText("Cód. Produto:");

        tfQuantidade.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lbDescricao.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbDescricao.setText("Descrição do Produto: ");

        tfDescricao.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lbQuantidade.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbQuantidade.setText("Quantidade:");

        tfCodigoProduto1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lbPreco.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbPreco.setText("Preço:");

        tfPreco.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lbTotal.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbTotal.setText("Total:");

        tfTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Qtde", "Descrição", "Preço", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProdutos);
        if (tblProdutos.getColumnModel().getColumnCount() > 0) {
            tblProdutos.getColumnModel().getColumn(0).setMinWidth(100);
            tblProdutos.getColumnModel().getColumn(0).setMaxWidth(100);
            tblProdutos.getColumnModel().getColumn(1).setMinWidth(450);
            tblProdutos.getColumnModel().getColumn(1).setMaxWidth(450);
        }

        javax.swing.GroupLayout pnTabelaLayout = new javax.swing.GroupLayout(pnTabela);
        pnTabela.setLayout(pnTabelaLayout);
        pnTabelaLayout.setHorizontalGroup(
            pnTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTabelaLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 943, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnTabelaLayout.setVerticalGroup(
            pnTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btRemoverItem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btRemoverItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/bin-empty-icon (Custom).png"))); // NOI18N
        btRemoverItem.setText("Remover");

        btFinalizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/produto_05.png"))); // NOI18N
        btFinalizar.setText("Fechar Pedido");

        lbTotalGeralPedido.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbTotalGeralPedido.setText("Total da Mesa");

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N

        javax.swing.GroupLayout pnFundoLayout = new javax.swing.GroupLayout(pnFundo);
        pnFundo.setLayout(pnFundoLayout);
        pnFundoLayout.setHorizontalGroup(
            pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFundoLayout.createSequentialGroup()
                .addGroup(pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnFundoLayout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(lbFichaMesa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfNumFichaMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnFundoLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnFundoLayout.createSequentialGroup()
                                .addComponent(lbTotalGeralPedido)
                                .addGap(37, 37, 37)
                                .addGroup(pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnFundoLayout.createSequentialGroup()
                                        .addComponent(btFinalizar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btRemoverItem))
                                    .addComponent(jTextField1))
                                .addGap(16, 16, 16))))
                    .addGroup(pnFundoLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnFundoLayout.createSequentialGroup()
                                .addGroup(pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbCodigoProduto)
                                    .addComponent(tfCodigoProduto1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbDescricao)
                                    .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnFundoLayout.createSequentialGroup()
                                .addGroup(pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbQuantidade)
                                    .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbPreco)
                                    .addComponent(tfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTotal)
                                    .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        pnFundoLayout.setVerticalGroup(
            pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFundoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFichaMesa)
                    .addComponent(tfNumFichaMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCodigoProduto)
                    .addComponent(lbDescricao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCodigoProduto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnFundoLayout.createSequentialGroup()
                        .addGroup(pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbQuantidade)
                            .addComponent(lbPreco))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnFundoLayout.createSequentialGroup()
                        .addComponent(lbTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addComponent(pnTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btFinalizar)
                    .addComponent(btRemoverItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTotalGeralPedido)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFinalizar;
    private javax.swing.JButton btRemoverItem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbCodigoProduto;
    private javax.swing.JLabel lbDescricao;
    private javax.swing.JLabel lbFichaMesa;
    private javax.swing.JLabel lbPreco;
    private javax.swing.JLabel lbQuantidade;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JLabel lbTotalGeralPedido;
    private java.awt.Panel pnFundo;
    private java.awt.Panel pnTabela;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField tfCodigoProduto1;
    private javax.swing.JTextField tfDescricao;
    private javax.swing.JTextField tfNumFichaMesa;
    private javax.swing.JTextField tfPreco;
    private javax.swing.JTextField tfQuantidade;
    private javax.swing.JTextField tfTotal;
    // End of variables declaration//GEN-END:variables
}
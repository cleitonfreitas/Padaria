package visao;

import controle.FornecedorController;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Fornecedor;

public class FrmFornecedor extends javax.swing.JDialog {

    Fornecedor f = new Fornecedor();
    FornecedorController dao = new FornecedorController();
    List<Fornecedor> fornecedoresList = new ArrayList();

    public FrmFornecedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        statusComponentes(false);
        fornecedoresList = dao.localizar();
        preencherTabela();
    }

    /**
     * MÉTODO HABILITA E DESABILITA COMPONENTES DA TELA. TRUE:HABILITA
     * FALSE:DESABILITA
     *
     * @param status
     */
    public void statusComponentes(boolean status) {
        btNovo.setEnabled(!status);
        btAlterar.setEnabled(!status);
        btExcluir.setEnabled(!status);
        btSalvar.setEnabled(status);
        btCancelar.setEnabled(status);
        lbNome.setEnabled(status);
        tfNome.setEnabled(status);
        lbEndereco.setEnabled(status);
        tfEndereco.setEnabled(status);
        lbBairro.setEnabled(status);
        tfBairro.setEnabled(status);
        lbCidade.setEnabled(status);
        tfCidade.setEnabled(status);
        lbCep.setEnabled(status);
        ftfCep.setEnabled(status);
        lbEstado.setEnabled(status);
        tfEstado.setEnabled(status);
        lbNumero.setEnabled(status);
        tfNumero.setEnabled(status);    
        lbTelFixo.setEnabled(status);
        ftfTelFixo.setEnabled(status);
        lbCelular.setEnabled(status);
        ftfCelular.setEnabled(status);
        lbEmail.setEnabled(status);
        tfEmail.setEnabled(status);
        lbIe.setEnabled(status);
        ftfIe.setEnabled(status);
        lbCnpj.setEnabled(status);
        ftfCnpj.setEnabled(status);
        lbPesquisar.setEnabled(status);
        cbPesquisar.setEnabled(status);
        tfPesquisar.setEnabled(status);
    }

    /**
     * ´MÉTODO REALIZA A LIMPEZA DOS CAMPOS PARA NOVA UTILIZAÇÃO.
     */
    public void limparCampos() {
        tfNome.setText("");
        tfCidade.setText("");
        tfEndereco.setText("");
        tfBairro.setText("");
        ftfCep.setText("");
        tfNumero.setText("");
        tfEstado.setText("");
        ftfTelFixo.setText("");
        ftfCelular.setText("");
        tfEmail.setText("");      
        ftfIe.setText("");
        ftfCnpj.setText("");
    }

    public void salvar() throws Exception {
        f.setBairro(tfBairro.getText());
        f.setCelular(ftfCelular.getText());
        f.setCep(ftfCep.getText());
        f.setCidade(tfCidade.getText());
        f.setCnpj(ftfCnpj.getText());
        f.setEmail(tfEmail.getText());
        f.setEndereco(tfEndereco.getText());
        f.setEstado(tfEstado.getText());
        f.setNome(tfNome.getText());
        f.setNumero(tfNumero.getText());
        f.setCnpj(ftfCnpj.getText());
        f.setInscricaoEstadual(ftfIe.getText());        
        f.setTelefone(ftfTelFixo.getText());
        
        dao.salvar(f);
        atualizarTabela();
        JOptionPane.showMessageDialog(this, "Fornecedor Cadatrado");
        atualizarTabela();
        statusComponentes(false);
        limparCampos();
        f = new Fornecedor();  // limpando a variavel global
    }

    public void vincularCampos() {
        Fornecedor fornecedor = fornecedoresList.get(tblFornecedores.getSelectedRow());

        tfBairro.setText(fornecedor.getBairro());
        tfCidade.setText(fornecedor.getCidade());
        tfEmail.setText(fornecedor.getEmail());
        tfEndereco.setText(fornecedor.getEndereco());
        tfEstado.setText(fornecedor.getEstado());
        tfNome.setText(fornecedor.getNome());
        tfNumero.setText(fornecedor.getNumero());
        ftfCelular.setText(fornecedor.getCelular());
        ftfCep.setText(fornecedor.getCep());
        ftfTelFixo.setText(fornecedor.getTelefone());
        ftfIe.setText(fornecedor.getInscricaoEstadual());
        ftfCnpj.setText(fornecedor.getCnpj());
    }

    public void excluir() {
        if (tblFornecedores.getSelectedRow() > -1) {
            int linhaClicada = tblFornecedores.getSelectedRow();
            Fornecedor forn = fornecedoresList.get(linhaClicada);
            ((DefaultTableModel) tblFornecedores.getModel()).removeRow(tblFornecedores.getSelectedRow());
            dao.remover(Fornecedor.class, forn.getId());
            atualizarTabela();
            JOptionPane.showMessageDialog(this, "Fornecedor Excluido");
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um Fornecedor");
        }
    }

    public void preencherTabela() {
        DefaultTableModel dtm = (DefaultTableModel) tblFornecedores.getModel();
        for (Fornecedor fornecedor : fornecedoresList) {
            dtm.addRow(new Object[]{fornecedor.getNome(), fornecedor.getCnpj(), fornecedor.getInscricaoEstadual(), fornecedor.getTelefone(), fornecedor.getCelular()});
        }
    }

    public void alterar() {
        if (tblFornecedores.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selecione uma linha!!!");
        } else {
            statusComponentes(true);
            int linha = tblFornecedores.getSelectedRow();
            f = fornecedoresList.get(linha);           
            f = dao.consultarPorId(Fornecedor.class,f.getId());
        }
    }

    public void atualizarTabela() {
        DefaultTableModel dtm = (DefaultTableModel) tblFornecedores.getModel();
        dtm.setNumRows(0);  // limpa os dados da tabela
        fornecedoresList = dao.localizar();
        preencherTabela();
    }

    public void pesquisar() {
        String str = "from Fornecedor f ";
        String atributo = "";
        if (cbPesquisar.getSelectedItem().toString().equals("Nome")) {
            atributo = "f.nome";
        }
        if (cbPesquisar.getSelectedItem().toString().equals("Cnpj")) {
            atributo = "f.cnpj";
        }

        String filtro = tfPesquisar.getText();
        if (filtro.length() > 0 && filtro != null) {
            str += "where upper(" + atributo + ") like '" + filtro.toUpperCase() + "%' ";
        }

        str += "order by " + atributo;
        fornecedoresList = dao.pesquisarRelease(str);//ATUALIZA A LISTA COM OS DADOS DESTA PESQUISA RELEASE
        DefaultTableModel dtm = (DefaultTableModel) tblFornecedores.getModel();
        dtm.setNumRows(0);
        preencherTabela();
    }
    

    public void novoCadastro() {
        statusComponentes(true);
        tfNome.requestFocus();//direcionando o ponteiro do mouse para este componente
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
        lbNome = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        lbEndereco = new javax.swing.JLabel();
        tfEndereco = new javax.swing.JTextField();
        lbNumero = new javax.swing.JLabel();
        tfNumero = new javax.swing.JTextField();
        lbBairro = new javax.swing.JLabel();
        tfBairro = new javax.swing.JTextField();
        lbCidade = new javax.swing.JLabel();
        tfCidade = new javax.swing.JTextField();
        lbEstado = new javax.swing.JLabel();
        tfEstado = new javax.swing.JTextField();
        lbEmail = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        lbTelFixo = new javax.swing.JLabel();
        ftfTelFixo = new javax.swing.JFormattedTextField();
        lbCelular = new javax.swing.JLabel();
        ftfCelular = new javax.swing.JFormattedTextField();
        lbIe = new javax.swing.JLabel();
        ftfIe = new javax.swing.JFormattedTextField();
        lbCnpj = new javax.swing.JLabel();
        ftfCnpj = new javax.swing.JFormattedTextField();
        lbCep = new javax.swing.JLabel();
        ftfCep = new javax.swing.JFormattedTextField();
        pnTabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFornecedores = new javax.swing.JTable();
        lbPesquisar = new javax.swing.JLabel();
        tfPesquisar = new javax.swing.JTextField();
        cbPesquisar = new javax.swing.JComboBox();
        btLocalizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SoftPaes - Cadastro de Fornecedores");

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

        lbNome.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lbNome.setText("Nome:");

        tfNome.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblFornecedores, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nome}"), tfNome, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lbEndereco.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lbEndereco.setText("Endereço:");

        tfEndereco.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblFornecedores, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.endereco}"), tfEndereco, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lbNumero.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lbNumero.setText("Número:");

        tfNumero.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblFornecedores, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.numero}"), tfNumero, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lbBairro.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lbBairro.setText("Bairro:");

        tfBairro.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblFornecedores, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.bairro}"), tfBairro, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lbCidade.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lbCidade.setText("Cidade:");

        tfCidade.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblFornecedores, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.cidade}"), tfCidade, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lbEstado.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lbEstado.setText("Estado:");

        tfEstado.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblFornecedores, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.estado}"), tfEstado, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lbEmail.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lbEmail.setText("E-mail:");

        tfEmail.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblFornecedores, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.email}"), tfEmail, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lbTelFixo.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lbTelFixo.setText("Tel. Fixo:");

        try {
            ftfTelFixo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfTelFixo.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblFornecedores, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.telefoneFixo}"), ftfTelFixo, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        lbCelular.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lbCelular.setText("Celular:");

        try {
            ftfCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfCelular.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblFornecedores, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.celular}"), ftfCelular, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        lbIe.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lbIe.setText("Ie :");

        try {
            ftfIe.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfIe.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblFornecedores, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.rg}"), ftfIe, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        lbCnpj.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lbCnpj.setText("Cnpj :");

        try {
            ftfCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfCnpj.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblFornecedores, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.cpf}"), ftfCnpj, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        ftfCnpj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ftfCnpjKeyTyped(evt);
            }
        });

        lbCep.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lbCep.setText("Cep:");

        try {
            ftfCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfCep.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblFornecedores, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.cep}"), ftfCep, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        pnTabela.setBackground(new java.awt.Color(204, 204, 204));
        pnTabela.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "  Informações dos Fornecedores: ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans", 1, 16), new java.awt.Color(0, 0, 204))); // NOI18N

        tblFornecedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Cnpj", "ie", "Telefone Fixo", "Celular"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFornecedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFornecedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFornecedores);

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
        cbPesquisar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nome", "Cnpj" }));

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
            .addGroup(pnTabelaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btLocalizar)
                .addGap(182, 182, 182))
            .addComponent(jScrollPane1)
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

        javax.swing.GroupLayout pnDadosLayout = new javax.swing.GroupLayout(pnDados);
        pnDados.setLayout(pnDadosLayout);
        pnDadosLayout.setHorizontalGroup(
            pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnDadosLayout.createSequentialGroup()
                        .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDadosLayout.createSequentialGroup()
                                .addComponent(lbNome)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tfNome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbEndereco)
                            .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNumero)))
                    .addGroup(pnDadosLayout.createSequentialGroup()
                        .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbBairro)
                            .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCidade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDadosLayout.createSequentialGroup()
                                .addComponent(lbCep)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(ftfCep, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEstado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ftfTelFixo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTelFixo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCelular)
                            .addComponent(ftfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnDadosLayout.createSequentialGroup()
                        .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEmail))
                        .addGap(18, 18, 18)
                        .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbIe)
                            .addComponent(ftfIe, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCnpj)
                            .addComponent(ftfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnDadosLayout.setVerticalGroup(
            pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome)
                    .addComponent(lbEndereco)
                    .addComponent(lbNumero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnDadosLayout.createSequentialGroup()
                        .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbBairro)
                            .addComponent(lbCidade)
                            .addComponent(lbEstado)
                            .addComponent(lbTelFixo)
                            .addComponent(lbCelular)
                            .addComponent(lbCep))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ftfTelFixo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ftfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ftfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnDadosLayout.createSequentialGroup()
                        .addComponent(lbIe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftfIe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnDadosLayout.createSequentialGroup()
                        .addComponent(lbCnpj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(pnTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        getContentPane().add(pnDados, java.awt.BorderLayout.CENTER);

        bindingGroup.bind();

        setSize(new java.awt.Dimension(1115, 639));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        try {
            salvar();
        } catch (Exception ex) {
            Logger.getLogger(FrmFornecedor.class.getName()).log(Level.SEVERE, null, ex);
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

    private void tfPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisarKeyReleased

        pesquisar();
    }//GEN-LAST:event_tfPesquisarKeyReleased

    private void btLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLocalizarActionPerformed

        cbPesquisar.setEnabled(true);
        tfPesquisar.setEnabled(true);
    }//GEN-LAST:event_btLocalizarActionPerformed

    private void tblFornecedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFornecedoresMouseClicked

        vincularCampos();
    }//GEN-LAST:event_tblFornecedoresMouseClicked

    private void ftfCnpjKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftfCnpjKeyTyped
       String texto = "0123456789";
        if (!texto.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_ftfCnpjKeyTyped

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
    private javax.swing.JComboBox cbPesquisar;
    private javax.swing.JFormattedTextField ftfCelular;
    private javax.swing.JFormattedTextField ftfCep;
    private javax.swing.JFormattedTextField ftfCnpj;
    private javax.swing.JFormattedTextField ftfIe;
    private javax.swing.JFormattedTextField ftfTelFixo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbBairro;
    private javax.swing.JLabel lbCelular;
    private javax.swing.JLabel lbCep;
    private javax.swing.JLabel lbCidade;
    private javax.swing.JLabel lbCnpj;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbEndereco;
    private javax.swing.JLabel lbEstado;
    private javax.swing.JLabel lbIe;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbNumero;
    private javax.swing.JLabel lbPesquisar;
    private javax.swing.JLabel lbTelFixo;
    private javax.swing.JPanel pnBotoes;
    private javax.swing.JPanel pnDados;
    private javax.swing.JPanel pnTabela;
    private javax.swing.JTable tblFornecedores;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfEstado;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfPesquisar;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}

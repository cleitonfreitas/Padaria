package visao;

import controle.ClienteController;
import dao.JpaUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;

public class FrmCliente extends javax.swing.JDialog {

    Cliente c = new Cliente();
    ClienteController dao = new ClienteController();
    List<Cliente> clientesList = new ArrayList();
    EntityManager manager = JpaUtil.getEm();
    

    public FrmCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        statusComponentes(false);
        clientesList = dao.localizar();
        preencherTabela();
        
    }

    /**
     * MÉTODO HABILITA E DESABILITA COMPONENTES DA TELA. TRUE:HABILITA
     * FALSE:DESABILITA
     *
     * @param status
     */
    
    public void listarClientes(){
        Query query = manager.createQuery("Cliente c from Cliente c");
        List<Cliente> cliList = query.getResultList();
        for (Cliente cliente : cliList){
            
        }
    }
    
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
//        tfEstado.setEnabled(status);
        cbEstado.setEnabled(status);
        lbNumero.setEnabled(status);
        tfNumero.setEnabled(status);
        lbTelFixo.setEnabled(status);
        ftfTelFixo.setEnabled(status);
        lbCelular.setEnabled(status);
        ftfCelular.setEnabled(status);
        lbEmail.setEnabled(status);
        tfEmail.setEnabled(status);
        lbRg.setEnabled(status);
        ftfRg.setEnabled(status);
        lbCpf.setEnabled(status);
        ftfCpf.setEnabled(status);
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
   //     tfEstado.setText("");
        
        ftfTelFixo.setText("");
        ftfCelular.setText("");
        tfEmail.setText("");
        ftfRg.setText("");
        ftfCpf.setText("");
    }

    public void salvar() throws Exception {
        c.setBairro(tfBairro.getText());
        c.setCelular(ftfCelular.getText());
        c.setCep(ftfCep.getText());
        c.setCidade(tfCidade.getText());
        c.setCpf(ftfCpf.getText());
        c.setEmail(tfEmail.getText());
        c.setEndereco(tfEndereco.getText());
        c.setEstado((String) cbEstado.getSelectedItem());
        c.setNome(tfNome.getText());
        c.setNumero(tfNumero.getText());
        c.setRg(ftfRg.getText());
//        if (rbFisica.isSelected()) {
//            c.setTipo(rbFisica.getText());
//        } else {
//            c.setTipo(rbJuridica.getText());
//        }
//
//        if (rbMasculino.isSelected()) {
//            c.setSexo(rbMasculino.getText());
//        } else {
//            c.setSexo(rbFeminino.getText());
//        }
        
        c.setTelefone(ftfTelFixo.getText());
        

        dao.salvar(c);
        atualizarTabela();
        JOptionPane.showMessageDialog(this, "Cliente Cadatrado");
        atualizarTabela();
        statusComponentes(false);
        limparCampos();
        c = new Cliente();  // limpando a variavel global
    }

    public void vincularCampos() {
        Cliente cliente = clientesList.get(tblCliente.getSelectedRow());

        tfBairro.setText(cliente.getBairro());
        tfCidade.setText(cliente.getCidade());
        tfEmail.setText(cliente.getEmail());
        tfEndereco.setText(cliente.getEndereco());
 //       tfEstado.setText(cliente.getEstado());
        tfNome.setText(cliente.getNome());
        tfNumero.setText(cliente.getNumero());
  //      tfSkype.setText(cliente.getSkype());
 //       tfWhatsApp.setText(cliente.getWhatsApp());
        ftfCelular.setText(cliente.getCelular());
        ftfCep.setText(cliente.getCep());
        ftfCpf.setText(cliente.getCpf());
        ftfRg.setText(cliente.getRg());
        ftfTelFixo.setText(cliente.getTelefone());
    }

    public void excluir() {
        if (tblCliente.getSelectedRow() > -1) {
            int linhaClicada = tblCliente.getSelectedRow();
            Cliente cli = clientesList.get(linhaClicada);
            ((DefaultTableModel) tblCliente.getModel()).removeRow(tblCliente.getSelectedRow());
            dao.remover(Cliente.class, cli.getId());
            atualizarTabela();
            JOptionPane.showMessageDialog(this, "Cliente Excluido");
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um Cliente");
        }
    }

    public void preencherTabela() {
        DefaultTableModel dtm = (DefaultTableModel) tblCliente.getModel();
        for (Cliente cliente : clientesList) {
            dtm.addRow(new Object[]{cliente.getNome(), cliente.getCpf(), cliente.getRg(), cliente.getTelefone(), cliente.getCelular()});
        }
    }

    public void alterar() {
        if (tblCliente.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selecione uma linha!!!");
        } else {
            statusComponentes(true);
            int linha = tblCliente.getSelectedRow();
            c = clientesList.get(linha);           
            c = dao.consultarPorId(Cliente.class,c.getId());
          
    //        System.out.println(c.getId());
    //        System.out.println("Numero do id do cliente para titulo de informação: " + c.getId());//so para testar se o id estava correto
        }
    }

    public void atualizarTabela() {
        DefaultTableModel dtm = (DefaultTableModel) tblCliente.getModel();
        dtm.setNumRows(0);  // limpa os dados da tabela
        clientesList = dao.localizar();
        preencherTabela();
    }

    public void pesquisar() {
        String str = "from Cliente c ";
        String atributo = "";
        if (cbPesquisar.getSelectedItem().toString().equals("Nome")) {
            atributo = "c.nome";
        }
        if (cbPesquisar.getSelectedItem().toString().equals("Cpf")) {
            atributo = "c.cpf";
        }

        String filtro = tfPesquisar.getText();
        if (filtro.length() > 0 && filtro != null) {
            str += "where upper(" + atributo + ") like '" + filtro.toUpperCase() + "%' ";
        }

        str += "order by " + atributo;
        clientesList = dao.pesquisarRelease(str);//ATUALIZA A LISTA COM OS DADOS DESTA PESQUISA RELEASE
        DefaultTableModel dtm = (DefaultTableModel) tblCliente.getModel();
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
        lbEmail = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        lbTelFixo = new javax.swing.JLabel();
        ftfTelFixo = new javax.swing.JFormattedTextField();
        lbCelular = new javax.swing.JLabel();
        ftfCelular = new javax.swing.JFormattedTextField();
        lbRg = new javax.swing.JLabel();
        ftfRg = new javax.swing.JFormattedTextField();
        lbCpf = new javax.swing.JLabel();
        ftfCpf = new javax.swing.JFormattedTextField();
        lbCep = new javax.swing.JLabel();
        ftfCep = new javax.swing.JFormattedTextField();
        pnTabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        lbPesquisar = new javax.swing.JLabel();
        tfPesquisar = new javax.swing.JTextField();
        cbPesquisar = new javax.swing.JComboBox();
        btLocalizar = new javax.swing.JButton();
        cbEstado = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SoftPaes - Cadastro de Clientes");

        pnBotoes.setBackground(new java.awt.Color(102, 102, 255));
        pnBotoes.setLayout(new java.awt.GridLayout(1, 0));

        btNovo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/user-icon (Custom).png"))); // NOI18N
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

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblCliente, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nome}"), tfNome, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lbEndereco.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lbEndereco.setText("Endereço:");

        tfEndereco.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblCliente, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.endereco}"), tfEndereco, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lbNumero.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lbNumero.setText("Número:");

        tfNumero.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblCliente, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.numero}"), tfNumero, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lbBairro.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lbBairro.setText("Bairro:");

        tfBairro.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblCliente, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.bairro}"), tfBairro, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lbCidade.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lbCidade.setText("Cidade:");

        tfCidade.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblCliente, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.cidade}"), tfCidade, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lbEstado.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lbEstado.setText("Estado:");

        lbEmail.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lbEmail.setText("E-mail:");

        tfEmail.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblCliente, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.email}"), tfEmail, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lbTelFixo.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lbTelFixo.setText("Tel. Fixo:");

        try {
            ftfTelFixo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfTelFixo.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblCliente, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.telefoneFixo}"), ftfTelFixo, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        lbCelular.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lbCelular.setText("Celular:");

        try {
            ftfCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfCelular.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblCliente, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.celular}"), ftfCelular, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        lbRg.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lbRg.setText("RG:");

        try {
            ftfRg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfRg.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblCliente, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.rg}"), ftfRg, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        lbCpf.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lbCpf.setText("CPF:");

        try {
            ftfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfCpf.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblCliente, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.cpf}"), ftfCpf, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        ftfCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ftfCpfKeyTyped(evt);
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

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblCliente, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.cep}"), ftfCep, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        pnTabela.setBackground(new java.awt.Color(204, 204, 204));
        pnTabela.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "  Informações Cliente: ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans", 1, 16), new java.awt.Color(0, 0, 204))); // NOI18N

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Cpf", "Rg", "Telefone Fixo", "Celular"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCliente);

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
        cbPesquisar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nome", "Cpf" }));

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
            .addGroup(pnTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        cbEstado.setFont(new java.awt.Font("Lucida Sans", 0, 13)); // NOI18N
        cbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "São Paulo - SP ", "Alagoas - AL ", "Acre - AC ", "Amapá - AP", "Amazonas - AM ", "Bahia - BA ", "Ceará - CE ", "Distrito Federal - DF ", "Espirito Santo - ES ", "Goiás - GO Maranhão - MA", "Mato Grosso - MT ", "Mato Grosso do Sul - MS ", "Minas Gerais - MG ", "Pará - PA ", "Paraíba - PB ", "Paraná - PR ", "Pernambuco - PE ", "Piauí - PI ", "Rio de Janeiro - RJ ", "Rio Grande do Norte - RN ", "Rio Grande do Sul - RS ", "Rôndonia - RO ", "Roraima - RR ", "Santa Catarina - SC ", "Seripe - SE ", "Tocantins - TO" }));
        cbEstado.setToolTipText("");

        javax.swing.GroupLayout pnDadosLayout = new javax.swing.GroupLayout(pnDados);
        pnDados.setLayout(pnDadosLayout);
        pnDadosLayout.setHorizontalGroup(
            pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnDadosLayout.createSequentialGroup()
                        .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNome)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDadosLayout.createSequentialGroup()
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
                                    .addComponent(ftfCep)))
                            .addGroup(pnDadosLayout.createSequentialGroup()
                                .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbNome)
                                    .addGroup(pnDadosLayout.createSequentialGroup()
                                        .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbEmail))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbRg)
                                            .addComponent(ftfRg, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbCpf)
                                            .addComponent(ftfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDadosLayout.createSequentialGroup()
                                .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbEstado)
                                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ftfTelFixo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbTelFixo)))
                            .addComponent(lbEndereco)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDadosLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ftfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCelular)
                            .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNumero))))
                .addGap(49, 49, 49))
        );
        pnDadosLayout.setVerticalGroup(
            pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNome)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbNumero)
                        .addComponent(lbEndereco)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnDadosLayout.createSequentialGroup()
                        .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfEndereco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                            .addComponent(ftfTelFixo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ftfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ftfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnDadosLayout.createSequentialGroup()
                                .addComponent(lbEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnDadosLayout.createSequentialGroup()
                                .addComponent(lbRg)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ftfRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnDadosLayout.createSequentialGroup()
                        .addComponent(lbCpf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnDados, java.awt.BorderLayout.CENTER);

        bindingGroup.bind();

        setSize(new java.awt.Dimension(1141, 605));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        try {
            salvar();
        } catch (Exception ex) {
            Logger.getLogger(FrmCliente.class.getName()).log(Level.SEVERE, null, ex);
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

    private void tblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMouseClicked

        vincularCampos();
    }//GEN-LAST:event_tblClienteMouseClicked

    private void ftfCpfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftfCpfKeyTyped
        String texto = "0123456789";
        if (!texto.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_ftfCpfKeyTyped

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
    private javax.swing.JComboBox cbEstado;
    private javax.swing.JComboBox cbPesquisar;
    private javax.swing.JFormattedTextField ftfCelular;
    private javax.swing.JFormattedTextField ftfCep;
    private javax.swing.JFormattedTextField ftfCpf;
    private javax.swing.JFormattedTextField ftfRg;
    private javax.swing.JFormattedTextField ftfTelFixo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbBairro;
    private javax.swing.JLabel lbCelular;
    private javax.swing.JLabel lbCep;
    private javax.swing.JLabel lbCidade;
    private javax.swing.JLabel lbCpf;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbEndereco;
    private javax.swing.JLabel lbEstado;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbNumero;
    private javax.swing.JLabel lbPesquisar;
    private javax.swing.JLabel lbRg;
    private javax.swing.JLabel lbTelFixo;
    private javax.swing.JPanel pnBotoes;
    private javax.swing.JPanel pnDados;
    private javax.swing.JPanel pnTabela;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfPesquisar;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}

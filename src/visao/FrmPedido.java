/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.Color;

/**
 *
 * @author Cleiton
 */
public class FrmPedido extends javax.swing.JDialog {

    /**
     * Creates new form FrmPedido
     */
    public FrmPedido(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        inicializarPedido();
    }

   public void inicializarPedido(){
       bt01.setBackground(Color.GREEN);
       bt02.setBackground(Color.GREEN);
       bt03.setBackground(Color.GREEN);
       bt04.setBackground(Color.GREEN);
       bt5.setBackground(Color.GREEN);
       bt6.setBackground(Color.GREEN);
       bt7.setBackground(Color.GREEN);
       bt8.setBackground(Color.GREEN);
       bt9.setBackground(Color.GREEN);
       bt10.setBackground(Color.GREEN);
       bt11.setBackground(Color.GREEN);
       bt12.setBackground(Color.GREEN);
       bt13.setBackground(Color.GREEN);
       bt14.setBackground(Color.GREEN);
       bt15.setBackground(Color.GREEN);
       bt16.setBackground(Color.GREEN);
       bt17.setBackground(Color.GREEN);
       bt18.setBackground(Color.GREEN);
       bt19.setBackground(Color.GREEN);
       bt20.setBackground(Color.GREEN);
       bt21.setBackground(Color.GREEN);
       bt22.setBackground(Color.GREEN);
       bt23.setBackground(Color.RED);
       bt24.setBackground(Color.GREEN);
       bt25.setBackground(Color.GREEN);
       bt26.setBackground(Color.GREEN);
       bt27.setBackground(Color.GREEN);
       bt28.setBackground(Color.GREEN);
       bt29.setBackground(Color.GREEN);
       bt30.setBackground(Color.GREEN);
       bt31.setBackground(Color.GREEN);
       bt32.setBackground(Color.GREEN);
       bt33.setBackground(Color.GREEN);
       bt34.setBackground(Color.GREEN);
       bt35.setBackground(Color.RED);
       bt36.setBackground(Color.GREEN);
       bt37.setBackground(Color.GREEN);
       bt38.setBackground(Color.GREEN);
       bt39.setBackground(Color.GREEN);
       bt40.setBackground(Color.GREEN);
       bt41.setBackground(Color.GREEN);
       bt42.setBackground(Color.GREEN);
       bt43.setBackground(Color.GREEN);
       bt44.setBackground(Color.GREEN);
       bt45.setBackground(Color.RED);
       bt46.setBackground(Color.GREEN);
       bt47.setBackground(Color.GREEN);
       bt48.setBackground(Color.GREEN);
       bt49.setBackground(Color.GREEN);
       bt50.setBackground(Color.GREEN);
       bt51.setBackground(Color.GREEN);
       bt52.setBackground(Color.GREEN);
       bt53.setBackground(Color.GREEN);
       bt54.setBackground(Color.GREEN);
       bt55.setBackground(Color.GREEN);
       bt56.setBackground(Color.GREEN);
       bt57.setBackground(Color.GREEN);
       bt58.setBackground(Color.GREEN);
       bt59.setBackground(Color.GREEN);
       bt60.setBackground(Color.GREEN);
       btLivre.setBackground(Color.GREEN);
       btEmAberto.setBackground(Color.red);
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnFundo = new java.awt.Panel();
        pnMesas = new java.awt.Panel();
        bt01 = new javax.swing.JButton();
        bt02 = new javax.swing.JButton();
        bt03 = new javax.swing.JButton();
        bt04 = new javax.swing.JButton();
        bt5 = new javax.swing.JButton();
        bt6 = new javax.swing.JButton();
        bt7 = new javax.swing.JButton();
        bt8 = new javax.swing.JButton();
        bt9 = new javax.swing.JButton();
        bt10 = new javax.swing.JButton();
        bt11 = new javax.swing.JButton();
        bt12 = new javax.swing.JButton();
        bt13 = new javax.swing.JButton();
        bt14 = new javax.swing.JButton();
        bt15 = new javax.swing.JButton();
        bt16 = new javax.swing.JButton();
        bt17 = new javax.swing.JButton();
        bt18 = new javax.swing.JButton();
        bt19 = new javax.swing.JButton();
        bt20 = new javax.swing.JButton();
        bt21 = new javax.swing.JButton();
        bt22 = new javax.swing.JButton();
        bt23 = new javax.swing.JButton();
        bt24 = new javax.swing.JButton();
        bt25 = new javax.swing.JButton();
        bt26 = new javax.swing.JButton();
        bt27 = new javax.swing.JButton();
        bt28 = new javax.swing.JButton();
        bt29 = new javax.swing.JButton();
        bt30 = new javax.swing.JButton();
        bt31 = new javax.swing.JButton();
        bt32 = new javax.swing.JButton();
        bt33 = new javax.swing.JButton();
        bt34 = new javax.swing.JButton();
        bt35 = new javax.swing.JButton();
        bt36 = new javax.swing.JButton();
        bt37 = new javax.swing.JButton();
        bt38 = new javax.swing.JButton();
        bt39 = new javax.swing.JButton();
        bt40 = new javax.swing.JButton();
        bt41 = new javax.swing.JButton();
        bt42 = new javax.swing.JButton();
        bt43 = new javax.swing.JButton();
        bt44 = new javax.swing.JButton();
        bt45 = new javax.swing.JButton();
        bt46 = new javax.swing.JButton();
        bt47 = new javax.swing.JButton();
        bt48 = new javax.swing.JButton();
        bt49 = new javax.swing.JButton();
        bt50 = new javax.swing.JButton();
        bt51 = new javax.swing.JButton();
        bt52 = new javax.swing.JButton();
        bt53 = new javax.swing.JButton();
        bt54 = new javax.swing.JButton();
        bt55 = new javax.swing.JButton();
        bt56 = new javax.swing.JButton();
        bt57 = new javax.swing.JButton();
        bt58 = new javax.swing.JButton();
        bt59 = new javax.swing.JButton();
        bt60 = new javax.swing.JButton();
        btLivre = new javax.swing.JButton();
        lbLivre = new javax.swing.JLabel();
        btEmAberto = new javax.swing.JButton();
        lbFichaMesa = new javax.swing.JLabel();
        lbEmAberto1 = new javax.swing.JLabel();
        tfNumFichaMesa = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pedido de Mesa ou Ficha");
        setBackground(new java.awt.Color(83, 131, 181));

        pnFundo.setBackground(new java.awt.Color(83, 131, 181));

        pnMesas.setBackground(java.awt.Color.lightGray);

        bt01.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt01.setText("01");

        bt02.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt02.setText("02");

        bt03.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt03.setText("03");

        bt04.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt04.setText("04");

        bt5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt5.setText("05");

        bt6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt6.setText("06");

        bt7.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt7.setText("07");

        bt8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt8.setText("08");

        bt9.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt9.setText("09");

        bt10.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt10.setText("10");

        bt11.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt11.setText("11");

        bt12.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt12.setText("12");

        bt13.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt13.setText("13");

        bt14.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt14.setText("14");

        bt15.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt15.setText("15");

        bt16.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt16.setText("16");

        bt17.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt17.setText("17");

        bt18.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt18.setText("18");

        bt19.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt19.setText("19");

        bt20.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt20.setText("20");

        bt21.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt21.setText("21");

        bt22.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt22.setText("22");

        bt23.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt23.setText("23");

        bt24.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt24.setText("24");

        bt25.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt25.setText("25");

        bt26.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt26.setText("26");

        bt27.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt27.setText("27");

        bt28.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt28.setText("28");

        bt29.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt29.setText("29");

        bt30.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt30.setText("30");

        bt31.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt31.setText("31");

        bt32.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt32.setText("32");

        bt33.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt33.setText("33");

        bt34.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt34.setText("34");

        bt35.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt35.setText("35");

        bt36.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt36.setText("36");

        bt37.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt37.setText("37");

        bt38.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt38.setText("38");

        bt39.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt39.setText("39");

        bt40.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt40.setText("40");

        bt41.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt41.setText("41");

        bt42.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt42.setText("42");

        bt43.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt43.setText("43");

        bt44.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt44.setText("51");

        bt45.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt45.setText("52");

        bt46.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt46.setText("53");

        bt47.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt47.setText("44");

        bt48.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt48.setText("54");

        bt49.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt49.setText("55");

        bt50.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt50.setText("45");

        bt51.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt51.setText("46");

        bt52.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt52.setText("56");

        bt53.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt53.setText("47");

        bt54.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt54.setText("48");

        bt55.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt55.setText("57");

        bt56.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt56.setText("58");

        bt57.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt57.setText("49");

        bt58.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt58.setText("50");

        bt59.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt59.setText("59");

        bt60.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bt60.setText("60");

        javax.swing.GroupLayout pnMesasLayout = new javax.swing.GroupLayout(pnMesas);
        pnMesas.setLayout(pnMesasLayout);
        pnMesasLayout.setHorizontalGroup(
            pnMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMesasLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnMesasLayout.createSequentialGroup()
                        .addComponent(bt44)
                        .addGap(18, 18, 18)
                        .addComponent(bt45)
                        .addGap(18, 18, 18)
                        .addComponent(bt46)
                        .addGap(18, 18, 18)
                        .addComponent(bt48)
                        .addGap(18, 18, 18)
                        .addComponent(bt49)
                        .addGap(18, 18, 18)
                        .addComponent(bt52)
                        .addGap(18, 18, 18)
                        .addComponent(bt55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMesasLayout.createSequentialGroup()
                        .addComponent(bt41)
                        .addGap(18, 18, 18)
                        .addComponent(bt42)
                        .addGap(18, 18, 18)
                        .addComponent(bt43)
                        .addGap(18, 18, 18)
                        .addComponent(bt47)
                        .addGap(18, 18, 18)
                        .addComponent(bt50)
                        .addGap(18, 18, 18)
                        .addComponent(bt51)
                        .addGap(18, 18, 18)
                        .addComponent(bt53)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt54))
                    .addGroup(pnMesasLayout.createSequentialGroup()
                        .addComponent(bt01)
                        .addGap(18, 18, 18)
                        .addComponent(bt02)
                        .addGap(18, 18, 18)
                        .addComponent(bt03)
                        .addGap(18, 18, 18)
                        .addComponent(bt04)
                        .addGap(18, 18, 18)
                        .addComponent(bt5)
                        .addGap(18, 18, 18)
                        .addComponent(bt6)
                        .addGap(18, 18, 18)
                        .addComponent(bt7)
                        .addGap(27, 27, 27)
                        .addComponent(bt8))
                    .addGroup(pnMesasLayout.createSequentialGroup()
                        .addGroup(pnMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnMesasLayout.createSequentialGroup()
                                .addComponent(bt11)
                                .addGap(18, 18, 18)
                                .addComponent(bt12))
                            .addGroup(pnMesasLayout.createSequentialGroup()
                                .addComponent(bt21)
                                .addGap(18, 18, 18)
                                .addComponent(bt22)))
                        .addGap(18, 18, 18)
                        .addGroup(pnMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnMesasLayout.createSequentialGroup()
                                .addComponent(bt13)
                                .addGap(18, 18, 18)
                                .addComponent(bt14)
                                .addGap(18, 18, 18)
                                .addComponent(bt15)
                                .addGap(18, 18, 18)
                                .addComponent(bt16)
                                .addGap(18, 18, 18)
                                .addComponent(bt17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bt18))
                            .addGroup(pnMesasLayout.createSequentialGroup()
                                .addComponent(bt23)
                                .addGap(18, 18, 18)
                                .addComponent(bt24)
                                .addGap(18, 18, 18)
                                .addComponent(bt25)
                                .addGap(18, 18, 18)
                                .addComponent(bt26)
                                .addGap(18, 18, 18)
                                .addComponent(bt27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bt28))))
                    .addGroup(pnMesasLayout.createSequentialGroup()
                        .addComponent(bt31)
                        .addGap(18, 18, 18)
                        .addComponent(bt32)
                        .addGap(18, 18, 18)
                        .addComponent(bt33)
                        .addGap(18, 18, 18)
                        .addComponent(bt34)
                        .addGap(18, 18, 18)
                        .addComponent(bt35)
                        .addGap(18, 18, 18)
                        .addComponent(bt36)
                        .addGap(18, 18, 18)
                        .addComponent(bt37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt38)))
                .addGap(28, 28, 28)
                .addGroup(pnMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnMesasLayout.createSequentialGroup()
                        .addComponent(bt9)
                        .addGap(18, 18, 18)
                        .addComponent(bt10))
                    .addGroup(pnMesasLayout.createSequentialGroup()
                        .addComponent(bt19)
                        .addGap(18, 18, 18)
                        .addComponent(bt20))
                    .addGroup(pnMesasLayout.createSequentialGroup()
                        .addComponent(bt29)
                        .addGap(18, 18, 18)
                        .addComponent(bt30))
                    .addGroup(pnMesasLayout.createSequentialGroup()
                        .addComponent(bt39)
                        .addGap(18, 18, 18)
                        .addComponent(bt40))
                    .addGroup(pnMesasLayout.createSequentialGroup()
                        .addComponent(bt57)
                        .addGap(18, 18, 18)
                        .addComponent(bt58))
                    .addGroup(pnMesasLayout.createSequentialGroup()
                        .addComponent(bt59)
                        .addGap(18, 18, 18)
                        .addComponent(bt60)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        pnMesasLayout.setVerticalGroup(
            pnMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMesasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt01)
                    .addComponent(bt02)
                    .addComponent(bt03)
                    .addComponent(bt04)
                    .addComponent(bt5)
                    .addComponent(bt6)
                    .addComponent(bt7)
                    .addComponent(bt8)
                    .addComponent(bt9)
                    .addComponent(bt10))
                .addGap(18, 18, 18)
                .addGroup(pnMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt11)
                    .addComponent(bt12)
                    .addComponent(bt13)
                    .addComponent(bt14)
                    .addComponent(bt15)
                    .addComponent(bt16)
                    .addComponent(bt17)
                    .addComponent(bt18)
                    .addComponent(bt19)
                    .addComponent(bt20))
                .addGap(18, 18, 18)
                .addGroup(pnMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt21)
                    .addComponent(bt22)
                    .addComponent(bt23)
                    .addComponent(bt24)
                    .addComponent(bt25)
                    .addComponent(bt26)
                    .addComponent(bt27)
                    .addComponent(bt28)
                    .addComponent(bt29)
                    .addComponent(bt30))
                .addGap(18, 18, 18)
                .addGroup(pnMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt31)
                    .addComponent(bt32)
                    .addComponent(bt33)
                    .addComponent(bt34)
                    .addComponent(bt35)
                    .addComponent(bt36)
                    .addComponent(bt37)
                    .addComponent(bt38)
                    .addComponent(bt39)
                    .addComponent(bt40))
                .addGap(18, 18, 18)
                .addGroup(pnMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt41)
                    .addComponent(bt42)
                    .addComponent(bt43)
                    .addComponent(bt47)
                    .addComponent(bt50)
                    .addComponent(bt51)
                    .addComponent(bt53)
                    .addComponent(bt54)
                    .addComponent(bt57)
                    .addComponent(bt58))
                .addGap(18, 18, 18)
                .addGroup(pnMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt44)
                    .addComponent(bt45)
                    .addComponent(bt46)
                    .addComponent(bt48)
                    .addComponent(bt49)
                    .addComponent(bt52)
                    .addComponent(bt55)
                    .addComponent(bt56)
                    .addComponent(bt59)
                    .addComponent(bt60))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        btLivre.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N

        lbLivre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbLivre.setText("Livre");

        btEmAberto.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N

        lbFichaMesa.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbFichaMesa.setText("Mesa/Ficha N.:");

        lbEmAberto1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbEmAberto1.setText("Em Aberto");

        tfNumFichaMesa.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        javax.swing.GroupLayout pnFundoLayout = new javax.swing.GroupLayout(pnFundo);
        pnFundo.setLayout(pnFundoLayout);
        pnFundoLayout.setHorizontalGroup(
            pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnFundoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btLivre, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbLivre)
                .addGap(50, 50, 50)
                .addComponent(btEmAberto, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbEmAberto1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnFundoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbFichaMesa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfNumFichaMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(208, 208, 208))
        );
        pnFundoLayout.setVerticalGroup(
            pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFundoLayout.createSequentialGroup()
                .addGroup(pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btEmAberto, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnFundoLayout.createSequentialGroup()
                        .addComponent(pnMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnFundoLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(btLivre, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnFundoLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(lbLivre))
                            .addGroup(pnFundoLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(lbEmAberto1)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFichaMesa)
                    .addComponent(tfNumFichaMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
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
    private javax.swing.JButton bt01;
    private javax.swing.JButton bt02;
    private javax.swing.JButton bt03;
    private javax.swing.JButton bt04;
    private javax.swing.JButton bt10;
    private javax.swing.JButton bt11;
    private javax.swing.JButton bt12;
    private javax.swing.JButton bt13;
    private javax.swing.JButton bt14;
    private javax.swing.JButton bt15;
    private javax.swing.JButton bt16;
    private javax.swing.JButton bt17;
    private javax.swing.JButton bt18;
    private javax.swing.JButton bt19;
    private javax.swing.JButton bt20;
    private javax.swing.JButton bt21;
    private javax.swing.JButton bt22;
    private javax.swing.JButton bt23;
    private javax.swing.JButton bt24;
    private javax.swing.JButton bt25;
    private javax.swing.JButton bt26;
    private javax.swing.JButton bt27;
    private javax.swing.JButton bt28;
    private javax.swing.JButton bt29;
    private javax.swing.JButton bt30;
    private javax.swing.JButton bt31;
    private javax.swing.JButton bt32;
    private javax.swing.JButton bt33;
    private javax.swing.JButton bt34;
    private javax.swing.JButton bt35;
    private javax.swing.JButton bt36;
    private javax.swing.JButton bt37;
    private javax.swing.JButton bt38;
    private javax.swing.JButton bt39;
    private javax.swing.JButton bt40;
    private javax.swing.JButton bt41;
    private javax.swing.JButton bt42;
    private javax.swing.JButton bt43;
    private javax.swing.JButton bt44;
    private javax.swing.JButton bt45;
    private javax.swing.JButton bt46;
    private javax.swing.JButton bt47;
    private javax.swing.JButton bt48;
    private javax.swing.JButton bt49;
    private javax.swing.JButton bt5;
    private javax.swing.JButton bt50;
    private javax.swing.JButton bt51;
    private javax.swing.JButton bt52;
    private javax.swing.JButton bt53;
    private javax.swing.JButton bt54;
    private javax.swing.JButton bt55;
    private javax.swing.JButton bt56;
    private javax.swing.JButton bt57;
    private javax.swing.JButton bt58;
    private javax.swing.JButton bt59;
    private javax.swing.JButton bt6;
    private javax.swing.JButton bt60;
    private javax.swing.JButton bt7;
    private javax.swing.JButton bt8;
    private javax.swing.JButton bt9;
    private javax.swing.JButton btEmAberto;
    private javax.swing.JButton btLivre;
    private javax.swing.JLabel lbEmAberto1;
    private javax.swing.JLabel lbFichaMesa;
    private javax.swing.JLabel lbLivre;
    private java.awt.Panel pnFundo;
    private java.awt.Panel pnMesas;
    private javax.swing.JTextField tfNumFichaMesa;
    // End of variables declaration//GEN-END:variables
}

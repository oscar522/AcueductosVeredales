/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import conexion.Index;
import conexion.Servicio_CDE;

/**
 *
 * @author OSCARPC
 */
public class Gui_CDE1 extends javax.swing.JInternalFrame {
       Servicio_CDE c = new Servicio_CDE();
    Object[][] datos;
    Object[][] valor_facturas;
    Object[][] valor_facturas_pagas;
    Object[][] valor_facturas_no_pagas;
    Object[][] facturas_pagas;
    Object[][] facturas_no_pagas;
    Object[][] valor_abonos;
    Object[][] valor_pagos_financiaciones;
    Object[][] facturas_anteriores;
    Object[][] valor_facturas_anteriores;
    Index in;
    /**
     * Creates new form Gui_CDE1
     */
    public Gui_CDE1() {
     initComponents();
     in = new Index();
     Index.Imagen imagen = in.new Imagen();
     jPanel1.add(imagen);
     jPanel1.repaint();
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
        jLabel17 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Fecha_inicial = new datechooser.beans.DateChooserCombo();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtValorTotalFacturas = new javax.swing.JTextField();
        txtValorTotalFacturasPagas = new javax.swing.JTextField();
        txtValorTotalFacturasNoPagas = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbAbonos = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbFinanciaciones = new javax.swing.JLabel();
        txtFacturasTotales = new javax.swing.JLabel();
        txtFacturasPagas = new javax.swing.JLabel();
        txtFacturasNoPagas = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtTotalAnterior = new javax.swing.JLabel();

        setClosable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));

        jLabel17.setFont(new java.awt.Font("Arial Narrow", 3, 21)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("DINERO ENTRANTE");

        jLabel2.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Elija la fecha del periodo inicial");

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Las facturas generadas fueron");

        jLabel5.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Las facturas pagas fueron");

        jLabel7.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("La facturas no canceladas fueron");

        jLabel4.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("El valor total es ");

        jLabel6.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("El valor total es  ");

        jLabel8.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("El valor de las facturas ");

        jLabel9.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("no canceladas es");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Consultar2.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial Narrow", 3, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Consultar");

        jLabel11.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Abonos realizados por fianciaciones");

        lbAbonos.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        lbAbonos.setForeground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Pagos realizados de financiaciones");

        lbFinanciaciones.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        lbFinanciaciones.setForeground(new java.awt.Color(255, 255, 255));

        txtFacturasTotales.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        txtFacturasTotales.setForeground(new java.awt.Color(255, 255, 255));

        txtFacturasPagas.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        txtFacturasPagas.setForeground(new java.awt.Color(255, 255, 255));

        txtFacturasNoPagas.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        txtFacturasNoPagas.setForeground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Facturas pagas mes anterior");

        jLabel15.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Total Facturas");

        txtTotalAnterior.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        txtTotalAnterior.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtFacturasPagas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtFacturasTotales, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(txtFacturasNoPagas, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel6)))
                                    .addComponent(txtTotalAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtValorTotalFacturasPagas, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                    .addComponent(txtValorTotalFacturasNoPagas)
                                    .addComponent(txtValorTotalFacturas, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtTotal)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton2)
                                            .addComponent(jLabel10)
                                            .addComponent(lbFinanciaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(lbAbonos, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(110, 110, 110)
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(Fecha_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(237, 237, 237))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel17)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(Fecha_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFacturasTotales, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(txtValorTotalFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(txtValorTotalFacturasPagas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(txtFacturasPagas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(txtValorTotalFacturasNoPagas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFacturasNoPagas, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbAbonos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbFinanciaciones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String [] fecha_inicial = Fecha_inicial.getText().split("/");
        String Dia1, Mes1, Ano1;
        Dia1="";
        Mes1="";
        Ano1="";
        Dia1=fecha_inicial[0] ;
        Mes1=fecha_inicial[1] ;
        Ano1=fecha_inicial[2] ;

        int mes2 =Integer.parseInt(Mes1)+1;
        int mes3 =Integer.parseInt(Mes1)-1;

        String Fechainicial= "20"+Ano1+"/" + Mes1 + "/"+ Dia1;
        String Fechainicial2="";
        String Fechainicial3="";
        String Fechainicial4="";

        if(mes3 == 1){

            Fechainicial4 ="20"+Ano1+"-0"+12+"-"+01;
        }
        Fechainicial4 ="20"+Ano1+"-0"+mes3+"-"+01;

        if(mes2 > 12){
            mes2 = 1;

        }
        Fechainicial2 ="20"+Ano1+"-0"+mes2+"-"+01;
        Fechainicial3 ="20"+Ano1+"-0"+mes2+"-"+30;
        String fecha1 ="20"+Ano1+"-0"+mes2+"-"+01;
        String fecha2 ="20"+Ano1+"-0"+mes2+"-"+30;

        System.out.print(Fechainicial2);
        System.out.print(Fechainicial4);
        System.out.print(Fechainicial3);

        String Fechafinal= "20"+Ano1+"/" + Mes1 + "/"+ Dia1;

        datos=c.consultarFacturasGeneradas(Fechainicial, Fechafinal);
        txtFacturasTotales.setText(String.valueOf(datos[0][0]));
        valor_facturas=c.consultarValorTotalFacturas(Fechainicial);
        txtValorTotalFacturas.setText(String.valueOf(valor_facturas[0][0]));
        facturas_pagas=c.consultarFacturasPagas(Fechainicial);
        txtFacturasPagas.setText(String.valueOf(facturas_pagas[0][0]));
        valor_facturas_pagas=c.consultarValorTotalFacturasPagas(Fechainicial);
        facturas_no_pagas=c.consultarFacturasNoPagas(Fechainicial);
        txtFacturasNoPagas.setText(String.valueOf(facturas_no_pagas[0][0]));
        valor_facturas_no_pagas=c.consultarValorTotalFacturasNoPagas(Fechainicial);
        txtValorTotalFacturasNoPagas.setText(String.valueOf(valor_facturas_no_pagas[0][0]));
        valor_abonos=c.consultarValorAbonos(Fechainicial2,Fechainicial3);
        lbAbonos.setText(String.valueOf(valor_abonos[0][0]));
        valor_pagos_financiaciones=c.consultarValorFinanciaciones(Fechainicial2, Fechainicial3);
        lbFinanciaciones.setText(String.valueOf(valor_pagos_financiaciones[0][0]));
        facturas_anteriores=c.consultarFacturasPagasMesAnterior(Fechainicial4, Fechainicial2, Fechainicial3);
        txtTotalAnterior.setText(String.valueOf(facturas_anteriores[0][0]));
        valor_facturas_anteriores=c.consultarValorTotalFacturasMesAnterior(Fechainicial4, Fechainicial2, Fechainicial3);
        txtTotal.setText(String.valueOf(valor_facturas_anteriores[0][0]));
        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo Fecha_inicial;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbAbonos;
    private javax.swing.JLabel lbFinanciaciones;
    private javax.swing.JLabel txtFacturasNoPagas;
    private javax.swing.JLabel txtFacturasPagas;
    private javax.swing.JLabel txtFacturasTotales;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JLabel txtTotalAnterior;
    private javax.swing.JTextField txtValorTotalFacturas;
    private javax.swing.JTextField txtValorTotalFacturasNoPagas;
    private javax.swing.JTextField txtValorTotalFacturasPagas;
    // End of variables declaration//GEN-END:variables
}

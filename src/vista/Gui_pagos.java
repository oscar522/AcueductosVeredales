/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import conexion.Index;
import conexion.Servicio_cierre;
import conexion.Servicio_pago;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author OSCARPC
 */
public class Gui_pagos extends javax.swing.JInternalFrame {
 Servicio_pago s = new Servicio_pago();
    Servicio_cierre C = new Servicio_cierre();
    Index i = new Index();
    Gui_index ii = new Gui_index();
    /**
     * Creates new form Gui_pagos1
     */
    public Gui_pagos() {
        initComponents();
        String CodigoFact = s.NumeroGestionFactura();
        lbCodigoFact.setText(CodigoFact);
        Index.Imagen imagen = i.new Imagen();
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
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbCodigoFact = new javax.swing.JLabel();
        txtCodigoFac = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        lbCodigoFin = new javax.swing.JLabel();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel7.setFont(new java.awt.Font("Arial Narrow", 3, 21)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("GESTION DE PAGOS");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/PagoFactura.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial Narrow", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Codigo de Pago");

        jLabel6.setFont(new java.awt.Font("Arial Narrow", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Codigo Factura");

        lbCodigoFact.setFont(new java.awt.Font("Arial Narrow", 3, 24)); // NOI18N
        lbCodigoFact.setForeground(new java.awt.Color(255, 255, 255));
        lbCodigoFact.setText("CODIGO");

        jLabel8.setFont(new java.awt.Font("Arial Narrow", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Reporte Reconexiones");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/CortesFac.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial Narrow", 3, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Pagar Factura");

        lbCodigoFin.setFont(new java.awt.Font("Arial Narrow", 3, 24)); // NOI18N
        lbCodigoFin.setForeground(new java.awt.Color(255, 255, 255));
        lbCodigoFin.setText("  ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(lbCodigoFin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbCodigoFact)
                                    .addComponent(txtCodigoFac, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(85, 85, 85)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(jLabel8))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel7)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(lbCodigoFin))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lbCodigoFact))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtCodigoFac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(txtCodigoFac.getText().equals("") ){
            JOptionPane.showMessageDialog(new JDialog(), "Inserte el CODIGO de barras");
        }else{
            
            String CodigoBarra =  txtCodigoFac.getText();
            
            
            String[] databar = CodigoBarra.split("'");
            
            String Codigofac = databar[0];
            String Codigofinan = databar[1];
            String Codigodeuda = databar[2];
                     
            String resultado=s.VerificarFacturaPaga(Codigofac);
            String resul_deuda=s.Factura_deuda(Codigofac);
            if (resultado.equals("1")){
                JOptionPane.showMessageDialog(new JDialog(), "La Factura Ya se Pago");
            }else if ( resul_deuda.equals("1") ){
                JOptionPane.showMessageDialog(new JDialog(), "La Factura NO corresponde al periodo actual ");
            } else {
                Object[][] datos = s.DatosFactura(Codigofac);
                String nl = System.getProperty("line.separator");

                String data_fac = 
                        "-- ¿  ESTA SEGURO QUE DESEA PAGAR ESTA FACTURA  ? -- "+
                        nl+
                        nl+
                        "Nombre Suscriptor : "+String.valueOf(datos[0][2])+
                        nl+
                        "Identificación : ("+String.valueOf(datos[0][1])+") "+String.valueOf(datos[0][0])+
                        nl+
                        nl+
                        "Codigo Inmueble : "+String.valueOf(datos[0][4])+
                        nl+
                        "Dirección : "+String.valueOf(datos[0][3])+
                        nl+
                        nl+
                        "Codigo de Factura : "+String.valueOf(datos[0][5])+
                        nl+
                        "Codigo de Reconexión  : "+String.valueOf(datos[0][6])+
                        nl+
                        "Codigo de Financiación Instalación  : "+String.valueOf(datos[0][7])+
                        nl+
                        "Codigo de Financiación Deuda  : "+String.valueOf(datos[0][8])+
                        nl+
                        nl+
                        "Valor Total Factura  : "+String.valueOf(datos[0][9])+
                        nl+
                        nl;
                
                int resp = JOptionPane.showConfirmDialog(null, data_fac, "Alerta!", JOptionPane.YES_NO_OPTION);
                
                        if(resp == 0){
                        s.insertarPagoFactura(Codigofac,Codigofinan,Codigodeuda);
                        String Codfac = s.NumeroGestionFactura();
                        lbCodigoFact.setText(Codfac);
                        String Codfin=s.NumeroGestionFinanciaciones();
                        lbCodigoFin.setText(Codfin);
                        txtCodigoFac.setText("");
                       
                        }
            }

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String nombre ="ReporteCierreReconAcueducto";
        String Fecha_corte1 ="2014/06/06";
        // TODO add your handling code here:

        C.GenerarReporte(nombre,Fecha_corte1);           // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbCodigoFact;
    private javax.swing.JLabel lbCodigoFin;
    private javax.swing.JTextField txtCodigoFac;
    // End of variables declaration//GEN-END:variables
}

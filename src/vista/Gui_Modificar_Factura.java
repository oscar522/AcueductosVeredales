/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import conexion.Index;
import conexion.Servicio_factura;
import java.awt.event.FocusEvent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author OSCARPC
 */
public class Gui_Modificar_Factura extends javax.swing.JInternalFrame {
    Object[][] datos;
     Servicio_factura s;
     Index i;
    /**
     * Creates new form Gui_Modificar_Factura
     */
    public Gui_Modificar_Factura() {
        s = new Servicio_factura();
        i = new Index();
        Index.Imagen imagen = i.new Imagen();
        initComponents();
           jPanel3.add(imagen);
        jPanel3.repaint();
        
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        ValorAcue = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        LabelInicial = new javax.swing.JLabel();
        LabelFinall = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        LabelPago = new javax.swing.JLabel();
        LabelSuspencion = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        LabelTotalFactura = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        LabelCod_inmueble = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtCod_inmueble = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        LabelNombre = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        LabelInmueble = new javax.swing.JLabel();
        txtdeuda = new javax.swing.JTextField();

        setClosable(true);
        setResizable(true);

        jPanel3.setBackground(new java.awt.Color(51, 204, 255));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Consultar.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Actualizar.png"))); // NOI18N
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Limpiar.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Consultar");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Actualizar");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Limpiar");

        jLabel17.setFont(new java.awt.Font("Arial Narrow", 3, 21)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("MODIFICAR FACTURA");

        jLabel11.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Codigo de Factura :");

        ValorAcue.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ValorAcue.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ValorAcueFocusLost(evt);
            }
        });
        ValorAcue.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                ValorAcueInputMethodTextChanged(evt);
            }
        });
        ValorAcue.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                ValorAcuePropertyChange(evt);
            }
        });
        ValorAcue.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                ValorAcueVetoableChange(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Fecha Inicial Periodo Facturacion :");

        jLabel13.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Fecha Final Periodo Facturacion :");

        LabelInicial.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LabelInicial.setForeground(new java.awt.Color(255, 0, 51));
        LabelInicial.setText("-----------------------------");

        LabelFinall.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LabelFinall.setForeground(new java.awt.Color(255, 0, 51));
        LabelFinall.setText("-----------------------------");

        jLabel16.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Fecha de Pago :");

        jLabel18.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Fecha de Suspencion :");

        LabelPago.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LabelPago.setForeground(new java.awt.Color(255, 0, 51));
        LabelPago.setText("-----------------------------");

        LabelSuspencion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LabelSuspencion.setForeground(new java.awt.Color(255, 0, 51));
        LabelSuspencion.setText("-----------------------------");

        jLabel21.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Codigo Inmueble :");

        LabelTotalFactura.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LabelTotalFactura.setForeground(new java.awt.Color(255, 0, 51));
        LabelTotalFactura.setText("-----------------------------");

        jLabel23.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Valor Acueducto :");

        LabelCod_inmueble.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LabelCod_inmueble.setForeground(new java.awt.Color(255, 0, 51));
        LabelCod_inmueble.setText("-----------------------------");

        jLabel25.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Deuda Anterior :");

        txtCod_inmueble.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Valor a Pagar : ");

        jLabel28.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Nombre Suscriptor :");

        jLabel29.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Direccion Inmueble :");

        LabelNombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LabelNombre.setForeground(new java.awt.Color(255, 0, 51));
        LabelNombre.setText("-----------------------------");

        jLabel31.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 0, 51));
        jLabel31.setText("* Codigo de Consulta");

        LabelInmueble.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LabelInmueble.setForeground(new java.awt.Color(255, 0, 51));
        LabelInmueble.setText("-----------------------------");

        txtdeuda.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtdeuda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtdeudaFocusLost(evt);
            }
        });
        txtdeuda.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtdeudaInputMethodTextChanged(evt);
            }
        });
        txtdeuda.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtdeudaPropertyChange(evt);
            }
        });
        txtdeuda.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                txtdeudaVetoableChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LabelCod_inmueble, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LabelInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel21)
                            .addComponent(LabelPago, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtdeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel26)
                            .addComponent(jLabel18)
                            .addComponent(jLabel23)
                            .addComponent(LabelFinall, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(LabelSuspencion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                                .addComponent(LabelTotalFactura, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(ValorAcue, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jLabel29)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCod_inmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel10))
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel28))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LabelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LabelInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtCod_inmueble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelNombre)
                    .addComponent(LabelInmueble))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelFinall)
                    .addComponent(LabelInicial))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPago)
                    .addComponent(LabelSuspencion))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelCod_inmueble)
                    .addComponent(ValorAcue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(txtdeuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelTotalFactura)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
         
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (txtCod_inmueble.getText().equals("")){

            JOptionPane.showMessageDialog(new JDialog(), "Debe digitar el CODIGO de la FACTURA");
        }else{

            String codigo_fact = txtCod_inmueble.getText();
            datos=s.ConsultarFacturasModficar(codigo_fact);
             
              
            LabelNombre.setText(String.valueOf(datos[0][0]));
            LabelInmueble.setText(String.valueOf(datos[0][1]));
            LabelInicial.setText(String.valueOf(datos[0][2]));
            LabelFinall.setText(String.valueOf(datos[0][3]));
            LabelPago.setText(String.valueOf(datos[0][4]));
            LabelSuspencion.setText(String.valueOf(datos[0][5]));
            LabelCod_inmueble.setText(String.valueOf(datos[0][6]));
            txtdeuda.setText(String.valueOf(datos[0][7]));
            ValorAcue.setText(String.valueOf(datos[0][8]));
            LabelTotalFactura.setText(String.valueOf(datos[0][9]));
            
                        

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
            
        
            String codigo_fact = txtCod_inmueble.getText();
          
            int txtdeuda1 = Integer.parseInt(txtdeuda.getText().trim());
            int ValorAcue1 = Integer.parseInt(ValorAcue.getText().trim());
            
              int Valortotal = txtdeuda1+ValorAcue1;
         int respuesta =    JOptionPane.showConfirmDialog(null, "El Valor de Factura es : "+Valortotal+" ¿Está seguro?");
        
         if (respuesta == 0 ){
         
             s.ModificarFactura(codigo_fact, txtdeuda1, ValorAcue1, Valortotal);
                
             
                datos=s.ConsultarFacturasModficar(codigo_fact);
                LabelNombre.setText(String.valueOf(datos[0][0]));
                LabelInmueble.setText(String.valueOf(datos[0][1]));
                LabelInicial.setText(String.valueOf(datos[0][2]));
                LabelFinall.setText(String.valueOf(datos[0][3]));
                LabelPago.setText(String.valueOf(datos[0][4]));
                LabelSuspencion.setText(String.valueOf(datos[0][5]));
                LabelCod_inmueble.setText(String.valueOf(datos[0][6]));
                txtdeuda.setText(String.valueOf(datos[0][7]));
                ValorAcue.setText(String.valueOf(datos[0][8]));
                LabelTotalFactura.setText(String.valueOf(datos[0][9]));

                        

         
         }else{}
        // TODO add your handling code here:
    }//GEN-LAST:event_ActualizarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                  
            LabelNombre.setText("");
            LabelInmueble.setText("");
            LabelInicial.setText("");
            LabelFinall.setText("");
            LabelPago.setText("");
            LabelSuspencion.setText("");
            LabelCod_inmueble.setText("");
            txtdeuda.setText("");
            ValorAcue.setText("");
            LabelTotalFactura.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ValorAcueInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_ValorAcueInputMethodTextChanged

    }//GEN-LAST:event_ValorAcueInputMethodTextChanged

    private void ValorAcuePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_ValorAcuePropertyChange
     // TODO add your handling code here:
    }//GEN-LAST:event_ValorAcuePropertyChange

    private void ValorAcueVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_ValorAcueVetoableChange

    }//GEN-LAST:event_ValorAcueVetoableChange

    private void ValorAcueFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ValorAcueFocusLost

      
            
         // TODO add your handling code here:
    }//GEN-LAST:event_ValorAcueFocusLost

    private void txtdeudaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdeudaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdeudaFocusLost

    private void txtdeudaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtdeudaInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdeudaInputMethodTextChanged

    private void txtdeudaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtdeudaPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdeudaPropertyChange

    private void txtdeudaVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_txtdeudaVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdeudaVetoableChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JLabel LabelCod_inmueble;
    private javax.swing.JLabel LabelFinall;
    private javax.swing.JLabel LabelInicial;
    private javax.swing.JLabel LabelInmueble;
    private javax.swing.JLabel LabelNombre;
    private javax.swing.JLabel LabelPago;
    private javax.swing.JLabel LabelSuspencion;
    private javax.swing.JLabel LabelTotalFactura;
    private javax.swing.JTextField ValorAcue;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtCod_inmueble;
    private javax.swing.JTextField txtdeuda;
    // End of variables declaration//GEN-END:variables
}

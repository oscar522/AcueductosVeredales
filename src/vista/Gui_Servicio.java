/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import conexion.Index;
import conexion.Servicio_servicio;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.Servicio;

/**
 *
 * @author OSCARPC
 */
public class Gui_Servicio extends javax.swing.JInternalFrame {
     Servicio_servicio s;
     Index i;
     Object[][] datos;
     String valor ="";
    /**
     * Creates new form Gui_Servicio1
     */
    public Gui_Servicio() {
         initComponents();
        s = new Servicio_servicio();
        i = new Index();
        Index.Imagen imagen = i.new Imagen();
        jPanel1.add(imagen);
        jPanel1.repaint();
    }
public Servicio armeservicio() {

            valor =  txtValor.getText().trim();
            String nombre = cboNombre.getSelectedItem().toString();
            Servicio servicio = new Servicio(valor, nombre);
            
        return servicio;
    }
    private void ComboAlcantarillado(String Categoria) {
        
        int i = 0;
        int j = 0;
        datos=s.cboIva(Categoria);
        for (i=1 ; i <= datos.length ;i=i+1){
        cboNombre.addItem(datos[j][1]);
        j++;
        }
         
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboCategoria = new javax.swing.JComboBox();
        txtValor = new javax.swing.JTextField();
        cboNombre = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Aqui modificamos el valor que se aplica a cada Usuario segun el Concepto de Cobro en la Factura fijos.");

        jLabel5.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Seleccione el Tipo :");

        jLabel2.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Elija el nombre :");

        jLabel3.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Indique el valor :");

        cboCategoria.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        cboCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Alcantarillado", "Acueducto", "Iva", "Reconexion" }));
        cboCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboCategoriaItemStateChanged(evt);
            }
        });
        cboCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboCategoriaMouseClicked(evt);
            }
        });
        cboCategoria.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cboCategoriaPropertyChange(evt);
            }
        });

        txtValor.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N

        cboNombre.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        cboNombre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione" }));
        cboNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboNombreMouseClicked(evt);
            }
        });
        cboNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNombreActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/consultar1.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar1.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(25, 25, 25)
                                    .addComponent(cboNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(91, 91, 91)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cboNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)))
                .addContainerGap(167, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboCategoriaItemStateChanged
        String Categoria = cboCategoria.getSelectedItem().toString();
        cboNombre.removeAllItems();
        ComboAlcantarillado(Categoria);        // TODO add your handling code here:
    }//GEN-LAST:event_cboCategoriaItemStateChanged

    private void cboCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboCategoriaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCategoriaMouseClicked

    private void cboCategoriaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cboCategoriaPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCategoriaPropertyChange

    private void cboNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboNombreMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cboNombreMouseClicked

    private void cboNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboNombreActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        String nombre = cboNombre.getSelectedItem().toString();

        if(nombre.equals("Seleccione")){

            JOptionPane.showMessageDialog(new JDialog(), "Seleccione un servicio");
        }else {

            datos=s.ConsultarServicio(nombre);

            //txtGenero.getSelectedItem().equals(datos[0][3]);
            txtValor.setText(String.valueOf(datos[0][0]));
        }
        
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        Servicio servicio = null;
        servicio = armeservicio();
        s.ModificarServicio(servicio);

        String id = String.valueOf(datos[0][1]);
        s.insertarbackup(valor, id);
        
    }//GEN-LAST:event_jLabel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboCategoria;
    private javax.swing.JComboBox cboNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}

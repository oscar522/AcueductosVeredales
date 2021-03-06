/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Gui_consultar_inmuable.java
 *
 * Created on 17/07/2013, 03:41:16 PM
 */
package vista;

import conexion.Index;
import conexion.Servicio_inmueble;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Paolita
 */
public class Gui_Consultar_Inmuable extends javax.swing.JInternalFrame {

    
    Servicio_inmueble s = new Servicio_inmueble();
     Object[][] datos1;
     Index i = new Index();
     Index j = new Index();
     int fila = -1;
    /** Creates new form Gui_consultar_inmuable */
    public Gui_Consultar_Inmuable() {
        initComponents();
        //centrarVentana();
        i = new Index();
        Index.Imagen imagen = i.new Imagen();
        j = new Index();
        Index.Imagen imagenn = j.new Imagen();
        
        jPanel1.add(imagen);
        radios.add(imagenn);
        jPanel1.repaint();
        radios.repaint();
        s = new Servicio_inmueble();
    }
     public void centrarVentana() {
                // Se obtienen las dimensiones en pixels de la pantalla.
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                // Se obtienen las dimensiones en pixels de la ventana.
                Dimension ventana = getSize();
                // Una cuenta para situar la ventana en el centro de la pantalla.

                setLocation((pantalla.width - ventana.width) / 2 ,0);
 }
private void updateTabla(){
      
       String valor =txtDocumento.getText().trim();
       
        if(valor.equals("")){
        JOptionPane.showMessageDialog(new JDialog(), "No se permite el campo en blanco, verifique el documensto nuevamente");
                                                     
        }
   
       String[] columNames = {"CODIGO","DIRECCION","TELEFONO" ,"NOMBRE", };
        // se utiliza la funcion
       datos1= s.ConsultarInmuebleCodigo(valor);
        // se colocan los datos en la tabla
       DefaultTableModel datos = new DefaultTableModel(datos1,columNames);
       tabla.setModel(datos);
       
          }

private void updateTabla2(){
      
       String valor =txtDocumento.getText().trim();
    
       
    if(valor.equals("")){
    JOptionPane.showMessageDialog(new JDialog(), "No se permite el campo en blanco, verifique el nombre nuevamente");
               
    }else{
   
       String[] columNames = {"CODIGO","DIRECCION","TELEFONO" ,"NOMBRE", };
        // se utiliza la funcion
       datos1= s.ConsultarInmuebleNombre(valor);
        // se colocan los datos en la tabla
       DefaultTableModel datos = new DefaultTableModel(datos1,columNames);
       tabla.setModel(datos);
     }
}
           
     /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gui_index_carte1 = new vista.Gui_index_carte();
        grupobusqueda = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        txtDocumento = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        radios = new javax.swing.JPanel();
        optDocumento = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        optNombre = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();

        gui_index_carte1.setVisible(true);

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Consultar");

        setClosable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(-13382401,true));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Consultar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtDocumento.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Arial Narrow", 3, 21)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("CONSULTAS DE INMUEBLES");

        tabla.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CODIGO", "DIRECCION", "TELEFONO", "TITULAR"
            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabla);

        grupobusqueda.add(optDocumento);
        optDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optDocumentoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Documento");

        grupobusqueda.add(optNombre);
        optNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optNombreActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre");

        javax.swing.GroupLayout radiosLayout = new javax.swing.GroupLayout(radios);
        radios.setLayout(radiosLayout);
        radiosLayout.setHorizontalGroup(
            radiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(radiosLayout.createSequentialGroup()
                .addComponent(optDocumento)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(optNombre)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        radiosLayout.setVerticalGroup(
            radiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(radiosLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(radiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(optNombre)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(optDocumento))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(jLabel17))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
  fila = tabla.rowAtPoint(evt.getPoint());
         int columna = tabla.columnAtPoint(evt.getPoint());        // TODO add your handling code here:
}//GEN-LAST:event_tablaMouseClicked

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    if(optNombre.isSelected()){
       updateTabla2(); 
    }else if(optDocumento.isSelected()){
        updateTabla();
    }else{
        JOptionPane.showMessageDialog(new JDialog(), "Debe elegir una opción de busqueda");
    }
     
     
    // TODO add your handling code here:
}//GEN-LAST:event_jButton1ActionPerformed

    private void optDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_optDocumentoActionPerformed

    private void optNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_optNombreActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup grupobusqueda;
    private vista.Gui_index_carte gui_index_carte1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton optDocumento;
    private javax.swing.JRadioButton optNombre;
    private javax.swing.JPanel radios;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtDocumento;
    // End of variables declaration//GEN-END:variables
}

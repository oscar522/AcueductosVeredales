/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Gui_inmueble.java
 *
 * Created on 18/06/2013, 11:46:33 AM
 */
package vista;

import conexion.ConexionMysql;
import conexion.Index;
import conexion.Servicio_cliente;
import conexion.Servicio_inmueble;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.Inmueble;

/**
 *
 * @author Paolita
 */
public class Gui_inmueble extends javax.swing.JInternalFrame {
    private final javax.swing.DefaultComboBoxModel modelocbAlcantarillado;
    private final javax.swing.DefaultComboBoxModel modelocbAcueducto;
    Servicio_inmueble s = new Servicio_inmueble();
    Servicio_cliente c = new Servicio_cliente();
    ConexionMysql conm = new ConexionMysql();
    Index i = new Index();
    Object[][] datos;
    Object[][] datos1;
    Object[][] datos2;

    String cantidad = "";
    String CodInmu2 = "";

      
    /** Creates new form Gui_inmueble */
    public Gui_inmueble() {
          modelocbAlcantarillado = new javax.swing.DefaultComboBoxModel(new String[] {});
          modelocbAcueducto = new javax.swing.DefaultComboBoxModel(new String[] {});
        initComponents();
        s = new Servicio_inmueble();
       // centrarVentana();
        int numero=0;
        datos1=s.NumeroGestion(numero);
         String num=(String.valueOf(datos1[0][0]));
        if (num.equals("null")){
        labelCodigo.setText("1");
        }else {
        labelCodigo.setText(String.valueOf(datos1[0][0]));
        }
        //Fondo panel
        i = new Index();
        Index.Imagen imagen = i.new Imagen();
        jPanel1.add(imagen);
        jPanel1.repaint();
        ComboAlcantarillado();
        ComboAcueducto();
      
       
       
        
    }
     public void centrarVentana() {
                // Se obtienen las dimensiones en pixels de la pantalla.
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                // Se obtienen las dimensiones en pixels de la ventana.
                Dimension ventana = getSize();
                // Una cuenta para situar la ventana en el centro de la pantalla.

                setLocation((pantalla.width - ventana.width) / 2 ,0);
 }
    private void ComboAlcantarillado() {
         int i = 0;
        int j = 0;
        modelocbAlcantarillado.addElement("Elije un Servicio");
        datos=s.ComboAlcantarillado();
        for (i=1 ; i <= datos.length ;i=i+1){
        
        modelocbAlcantarillado.addElement(datos[j][1]);    
        
        j++;
        }
              
    }
    
    private void ComboAcueducto() {
        int i = 0;
        int j = 0;
        modelocbAcueducto.addElement("Elije un Servicio");
        datos=s.ComboAcueducto();
        for (i=1 ; i <= datos.length ;i=i+1){
        
        modelocbAcueducto.addElement(datos[j][1]);    
        
        j++;
        }
           
    }
    
    public Inmueble armainmueble(){
          Inmueble inmueble = null;
          String documento = txtDocumento.getText().trim();
          String codigo =labelCodigo.getText().trim();
          String direccion = txtDireccion.getText().trim();
          String telefono = txtTelefono.getText().trim();          
          String NomAlcantarillado= cbAlcantarillado.getSelectedItem().toString();
          String NomAcueducto= cbAcueducto.getSelectedItem().toString();
          
          if(direccion.equals("")){
               JOptionPane.showMessageDialog(new JDialog(), "La Direccion no puede ser vacia");
               }else if(telefono.matches("[a-z]*")){
                   JOptionPane.showMessageDialog(new JDialog(), "El telefono debe ser numerico");
                 }else if(NomAlcantarillado.equals("Elije un Servicio")){
                      JOptionPane.showMessageDialog(new JDialog(), "Debe seleccionar el alcantarillado");
                     }else if(NomAcueducto.equals("Elije un Servicio")){
                          JOptionPane.showMessageDialog(new JDialog(), "Debe seleccionar el Acueducto");
                     } else if(documento.equals("")){
                          JOptionPane.showMessageDialog(new JDialog(), "Debe indicar el Documento del titular");
                     }else if(codigo.equals("")){
                          JOptionPane.showMessageDialog(new JDialog(), "Debe indicar el codigo del inmueble");
                     }else{
                     
                     
                     inmueble = new Inmueble(codigo, direccion,telefono, NomAlcantarillado, documento, NomAcueducto);
                     }
          return inmueble;
        
        
          
                     
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        labelCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cbAcueducto = new javax.swing.JComboBox();
        cbAlcantarillado = new javax.swing.JComboBox();

        setClosable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 3, 21)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("INMUEBLE");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Consultar3.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Codigo Inmueble");

        labelCodigo.setFont(new java.awt.Font("Arial Narrow", 0, 36)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre");

        txtNombre.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtNombre.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Documento del Titular ");

        txtDocumento.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocumentoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Direccion");

        txtDireccion.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Telefono");

        txtTelefono.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Alcantarillado");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Guardar.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Consultar.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Actualizar.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Eliminar.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Limpiar.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Consultar Cliente");

        jLabel9.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Limpiar");

        jLabel10.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Eliminar");

        jLabel11.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Actualizar");

        jLabel12.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Consultar");

        jLabel13.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Insertar");

        jLabel14.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Acueducto");

        cbAcueducto.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        cbAcueducto.setModel(modelocbAcueducto);

        cbAlcantarillado.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        cbAlcantarillado.setModel(modelocbAlcantarillado);
        cbAlcantarillado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAlcantarilladoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel13)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel9))
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1)
                                        .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cbAcueducto, javax.swing.GroupLayout.Alignment.LEADING, 0, 183, Short.MAX_VALUE)
                                            .addComponent(cbAlcantarillado, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtNombre)
                                            .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(53, 53, 53)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8))))))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(labelCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbAlcantarillado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cbAcueducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addContainerGap(28, Short.MAX_VALUE))
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
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void txtDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocumentoActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtDocumentoActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 String documento = txtDocumento.getText().trim();
 if(documento.equals("")){
      JOptionPane.showMessageDialog(new JDialog(), "Digite el numero del documento");
                                                     
 }else{
   datos= c.ConsultarCliente(documento);
   String nombre = "";
   nombre = String.valueOf(datos[0][3]);
   if (nombre.equals("null")){
   JOptionPane.showMessageDialog(new JDialog(), "No se encuentro la persona");
   } else {
   txtNombre.setText(String.valueOf(datos[0][3]));
   }
    
 }
    // TODO add your handling code here:
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        Inmueble inmueble = null;
        inmueble = armainmueble();
      if(inmueble == null){}else{
     s.insertar(inmueble);
        }
    
    
    // TODO add your handling code here:
}//GEN-LAST:event_jButton2ActionPerformed

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

   String documento = labelCodigo.getText();
    
    
    if (txtDireccion.getText().equals("") || txtTelefono.getText().equals("") ||
cbAlcantarillado.getSelectedItem().toString().equals("Elije un Servicio") ||
cbAcueducto.getSelectedItem().toString().equals("Elije un Servicio") || documento.equals("")){

    JOptionPane.showMessageDialog(new JDialog(), "TODOS LOS CAMPOS SON OBLIGATORIOS");

}else{
   Inmueble inmueble = null;
   inmueble = armainmueble();
   if(inmueble == null){}else{
      s.ModificarInmueble(inmueble);
       
       s.insertarcambiousuario(inmueble,CodInmu2 );
        }
    }

    
    // TODO add your handling code here:
}//GEN-LAST:event_jButton4ActionPerformed

private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
datos1 = s.ConsultarInmuebleFactura();   
int tamaño = datos1.length;
//JOptionPane.showMessageDialog(new JDialog(), "tamaño"+tamaño);
        int numero=0;
        datos1=s.NumeroGestion(numero);
          labelCodigo.setText(String.valueOf(datos1[0][0]));
    
        txtNombre.setText("");
        txtDireccion.setText("");
        txtDocumento.setText("");
        txtTelefono.setText("");
        cbAlcantarillado.setSelectedItem("Elije un Servicio");
        cbAcueducto.setSelectedItem("Elije un Servicio");
    
    // TODO add your handling code here:
}//GEN-LAST:event_jButton6ActionPerformed

private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

 String Codigo = labelCodigo.getText();
    s.BorrarInmueble(Codigo);    
    
    // TODO add your handling code here:
}//GEN-LAST:event_jButton5ActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

     if (labelCodigo.getText().equals("")){
    
       JOptionPane.showMessageDialog(new JDialog(), "Debe digitar el Codigo del Inmueble");
    }else{
    
String DOCUMENTO = labelCodigo.getText();

datos=s.ConsultarInmueble(DOCUMENTO);
CodInmu2 = String.valueOf(datos[0][3]);
txtDireccion.setText(String.valueOf(datos[0][1]));
txtDocumento.setText(String.valueOf(datos[0][3]));
String documento=String.valueOf(datos[0][3]);
 datos2= c.ConsultarCliente(documento);
   String nombre = "";
   nombre = String.valueOf(datos2[0][3]);
   if (nombre.equals("null")){
   JOptionPane.showMessageDialog(new JDialog(), "No se encuentro el inmueble");
   } else {
   txtNombre.setText(String.valueOf(datos2[0][3]));
   }
 //txtNombre.setText(String.valueOf(datos[0][1]));  
    txtTelefono.setText(String.valueOf(datos[0][2])); 
    String alcantarillado=(String.valueOf(datos[0][5]));
    String Acueducto=(String.valueOf(datos[0][8]));
    System.out.println(alcantarillado + "/////");
    System.out.println(Acueducto + "/////");
    cbAlcantarillado.setSelectedItem(alcantarillado);
    cbAcueducto.setSelectedItem(Acueducto);
     }    
  
    // TODO add your handling code here:
}//GEN-LAST:event_jButton3ActionPerformed

    private void cbAlcantarilladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlcantarilladoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAlcantarilladoActionPerformed

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbAcueducto;
    private javax.swing.JComboBox cbAlcantarillado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField labelCodigo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}

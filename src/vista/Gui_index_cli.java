/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import conexion.ConexionMysql;
import java.awt.Dimension;
import java.awt.Graphics;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author oscar
 */
public class Gui_index_cli extends javax.swing.JInternalFrame {
 ConexionMysql conm;
    /**
     * Creates new form Gui_prueba
     */
    public Gui_index_cli() {
        initComponents();
        //ocultarBarraTitulo();
        Imagen Imagen = new Imagen();
        jPanel2.add(Imagen);
        jPanel2.repaint();
        conm = new ConexionMysql();
        ocultarBarraTitulo();
    }
    
   
    
    //////////////////////// FONDO DE PANEL
    
    public class Imagen extends javax.swing.JPanel {
 
public Imagen() {
this.setSize(850, 350); //se selecciona el tamaño del panel
}
    public void paint(Graphics grafico) {
    
Dimension height = getSize();
 
//Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
 
ImageIcon Img = new ImageIcon(getClass().getResource("/imagenes/FondoMedio.png")); 
 
//se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
 
grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
 
setOpaque(false);
super.paintComponent(grafico);
}
    }
//////////////////////////////////////////////
    

    private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
    private Dimension dimBarra = null; 

    public void ocultarBarraTitulo()
    { 
    Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane(); 
    dimBarra = Barra.getPreferredSize(); 
    Barra.setSize(0,0); 
    Barra.setPreferredSize(new Dimension(0,0)); 
    repaint(); 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        texto4 = new javax.swing.JLabel();
        texto1 = new javax.swing.JLabel();
        texto2 = new javax.swing.JLabel();
        texto3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        texto5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        texto6 = new javax.swing.JLabel();
        texto7 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createCompoundBorder());
        setAlignmentX(0.0F);
        setAlignmentY(-0.2F);
        setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        texto4.setFont(new java.awt.Font("Arial Narrow", 2, 18)); // NOI18N
        texto4.setForeground(new java.awt.Color(255, 255, 255));
        texto4.setText("Usuarios");

        texto1.setFont(new java.awt.Font("Arial Narrow", 3, 18)); // NOI18N
        texto1.setForeground(new java.awt.Color(255, 255, 255));
        texto1.setText("Aqui se encuentra todo lo relacionado con nuestros clientes.");

        texto2.setFont(new java.awt.Font("Arial Narrow", 2, 18)); // NOI18N
        texto2.setForeground(new java.awt.Color(255, 255, 255));
        texto2.setText("- Crea, Modifica o Consulta  ");

        texto3.setFont(new java.awt.Font("Arial Narrow", 2, 18)); // NOI18N
        texto3.setForeground(new java.awt.Color(255, 255, 255));
        texto3.setText("Inmueble");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Inmueble.png"))); // NOI18N
        jButton1.setAlignmentY(1.5F);
        jButton1.setMargin(new java.awt.Insets(2, 0, 2, 14));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Cliente2.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ConsultaInmueble.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        texto5.setFont(new java.awt.Font("Arial Narrow", 2, 18)); // NOI18N
        texto5.setForeground(new java.awt.Color(255, 255, 255));
        texto5.setText("Consultar Inmueble");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Concep1.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        texto6.setFont(new java.awt.Font("Arial Narrow", 2, 18)); // NOI18N
        texto6.setForeground(new java.awt.Color(255, 255, 255));
        texto6.setText("Otros Conceptos");

        texto7.setFont(new java.awt.Font("Arial Narrow", 2, 18)); // NOI18N
        texto7.setForeground(new java.awt.Color(255, 255, 255));
        texto7.setText("Reporte de Usuario");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Consultar3.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(texto3)))
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(texto4)))
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(texto5))
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto6)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(texto7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto2)
                    .addComponent(texto1))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(texto7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(texto1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(texto2)
                        .addGap(58, 58, 58)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto3)
                            .addComponent(texto4)
                            .addComponent(texto5)
                            .addComponent(texto6))))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 Gui_cliente f4= new Gui_cliente();
        f4.setVisible(true);             // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   
        Gui_inmueble f4= new Gui_inmueble();
        f4.setVisible(true);              // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
Gui_Consultar_Inmuable f4= new Gui_Consultar_Inmuable();
        f4.setVisible(true);          // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
Gui_Conceptos f4= new Gui_Conceptos();
        f4.setVisible(true);                 // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

           Connection micone = conm.getConnection();
           
       try{
           String reporte = System.getProperty("user.dir")+"/src/ReportesFacturaCierre/ReporteCierreClientesActivos.jasper"; // direccion del reporte 
           
           JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reporte);
          
           
           
           JasperPrint  print = JasperFillManager.fillReport(jasperReport, null, micone);
           
           JasperViewer view = new JasperViewer (print,false);
           view.setVisible(true);
           
       } catch (Exception f){
       
       JOptionPane.showMessageDialog(new JDialog(), "ERROR al General informes "+f);
       
       }
           
           // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel texto1;
    private javax.swing.JLabel texto2;
    private javax.swing.JLabel texto3;
    private javax.swing.JLabel texto4;
    private javax.swing.JLabel texto5;
    private javax.swing.JLabel texto6;
    private javax.swing.JLabel texto7;
    // End of variables declaration//GEN-END:variables
}

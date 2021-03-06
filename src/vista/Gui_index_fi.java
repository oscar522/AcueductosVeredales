/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author oscar
 */
public class Gui_index_fi extends javax.swing.JInternalFrame {

    /**
     * Creates new form Gui_index_fi
     */
    public Gui_index_fi() {
        initComponents();
        ocultarBarraTitulo();
        Imagen Imagen = new Imagen();
        jPanel2.add(Imagen);
        jPanel2.repaint();
    }
    
    
    public class Imagen extends javax.swing.JPanel {
 
    public Imagen() {
    this.setSize(850, 350); //se selecciona el tamaño del panel
    }
    @Override
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        texto1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        texto6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        texto9 = new javax.swing.JLabel();
        texto11 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        texto7 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createCompoundBorder());
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setAlignmentY(-0.2F);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        texto1.setFont(new java.awt.Font("Arial Narrow", 3, 18)); // NOI18N
        texto1.setForeground(new java.awt.Color(255, 255, 255));
        texto1.setText("Aqui se encuentra todo lo relacionado con las nuevas instalaciones del servicio de Acueducto ");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Financiacion2.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ConsultaInmueble.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        texto6.setFont(new java.awt.Font("Arial Narrow", 2, 18)); // NOI18N
        texto6.setForeground(new java.awt.Color(255, 255, 255));
        texto6.setText("Financiación");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ConsultarDeudor.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        texto9.setFont(new java.awt.Font("Arial Narrow", 2, 18)); // NOI18N
        texto9.setForeground(new java.awt.Color(255, 255, 255));
        texto9.setText("Financiación Cliente");

        texto11.setFont(new java.awt.Font("Arial Narrow", 2, 18)); // NOI18N
        texto11.setForeground(new java.awt.Color(255, 255, 255));
        texto11.setText("Financiación General");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ConsultaInmueble.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        texto7.setFont(new java.awt.Font("Arial Narrow", 2, 18)); // NOI18N
        texto7.setForeground(new java.awt.Color(255, 255, 255));
        texto7.setText("Pago Cuotas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(texto6)
                        .addGap(114, 114, 114)
                        .addComponent(texto9)
                        .addGap(68, 68, 68)
                        .addComponent(texto11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(texto7)))
                .addGap(91, 91, 91))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(texto1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(texto1)
                .addGap(85, 85, 85)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto11)
                            .addComponent(texto9)
                            .addComponent(texto6)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(texto7)))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Gui_financiacion f4= new Gui_financiacion();
        f4.setVisible(true);              // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Gui_Consultar_Financiacion f4= new Gui_Consultar_Financiacion();
        f4.setVisible(true);          // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      Gui_Consulta_Financia_General f4= new Gui_Consulta_Financia_General();
        f4.setVisible(true);    // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    Gui_pago_financiacion  f4= new Gui_pago_financiacion();
    f4.setVisible(true);    // TODO add your handling code here:     
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel texto1;
    private javax.swing.JLabel texto11;
    private javax.swing.JLabel texto6;
    private javax.swing.JLabel texto7;
    private javax.swing.JLabel texto9;
    // End of variables declaration//GEN-END:variables
}

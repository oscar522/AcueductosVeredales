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

/**
 *
 * @author OSCARPC
 */
public class Gui_Delete_F extends javax.swing.JInternalFrame {
    Index i;
    Servicio_servicio s;

    /**
     * Creates new form Gui_Delete_F1
     */
    public Gui_Delete_F() {
        initComponents();
        this.setTitle("Eliminar Financiación");
        i = new Index();
        Index.Imagen imagen = i.new Imagen();
        s = new Servicio_servicio();
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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        Txt_fecha_pago = new datechooser.beans.DateChooserCombo();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setResizable(true);

        jLabel2.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Elija la fecha de pago del periodo que desea eliminar");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Evite realizar esta acción a menos que sea necesario.\nRecuerde que una vez ejecutado este procedimiento los\ndatos no podran recuperarse.\n\n\n\n");
        jScrollPane1.setViewportView(jTextArea1);

        Txt_fecha_pago.setCalendarBackground(new java.awt.Color(204, 204, 204));
        Txt_fecha_pago.setNavigateFont(new java.awt.Font("Arial Narrow", java.awt.Font.BOLD + java.awt.Font.ITALIC, 12));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar1.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(Txt_fecha_pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(Txt_fecha_pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        String [] ini = Txt_fecha_pago.getText().split("/");

        String Dia1, Mes1, Ano1;
        Dia1="";
        Mes1="";
        Ano1="";
        Dia1=ini[0] ;
        Mes1=ini[1] ;
        Ano1=ini[2] ;

        String Fecha_pago1= "20"+Ano1+"/" + Mes1 + "/"+ Dia1;
        String resultado = s.verificarperiodopago(Fecha_pago1);
        String resultado2 = s.verificarperiododeuda(Fecha_pago1);

        if(resultado.equals("0") && resultado2.equals("0") ){
            s.eliminarperiodofacturacion(Fecha_pago1);
        }else if((resultado != "0" && resultado2.equals("0")) || (resultado.equals("0") && resultado2 != "0") ||(resultado != "0" && resultado2 != "0") ){

            JOptionPane.showMessageDialog(new JDialog(), "EL PERIODO DE FACTURACION QUE DESEA ELIMINAR NO ES EL ACTUAL VERIFIQUE LA FECHA DE PAGO");
            JOptionPane.showMessageDialog(new JDialog(), "ERROR AL TRATAR DE ELIMINAR EL PERIODO DE FACTURACION");

        } 
        
    }//GEN-LAST:event_jLabel3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo Txt_fecha_pago;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}

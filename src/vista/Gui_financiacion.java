/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Gui_financiacion.java
 *
 * Created on 10/07/2013, 01:19:11 PM
 */
package vista;

import conexion.ConexionMysql;
import conexion.Index;
import conexion.Servicio_cliente;
import conexion.Servicio_financiacion;
import conexion.Servicio_inmueble;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.Financiacion;

/**
 *
 * @author Paolita
 */
public class Gui_financiacion extends javax.swing.JInternalFrame {
   
    Servicio_cliente c = new Servicio_cliente();
    Servicio_financiacion s = new Servicio_financiacion();
    Servicio_inmueble i = new Servicio_inmueble();
    Index f = new Index();
    private double cuota;
    ConexionMysql conm = new ConexionMysql();
    int cuotas_p=0;
    
     Object[][] datos;
     Object[][] datos1;
     Object[][] datos2;
     Object[][] datos3;
     Object[][] datos4;
    /** Creates new form Gui_financiacion */
    public Gui_financiacion() {
        
        initComponents();
        //centrarVentana();
        int numero=0;
        ComboAlcantarillado();
        datos1=s.NumeroGestion();
        String num=(String.valueOf(datos1[0][0]));
            if (num.equals("null")){
            txtCodigo.setText("1");
            }else {
            txtCodigo.setText(String.valueOf(datos1[0][0]));
            }
        f = new Index();
        Index.Imagen imagen = f.new Imagen();
        jPanel1.add(imagen);
        jPanel1.repaint();
        
      
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
        datos=s.cboIva();
        for (i=1 ; i <= datos.length ;i=i+1){
        ComboInteres.addItem(datos[j][1]);
        j++;
        }
         
    }
  

    public Financiacion armafinanciacion(){
        
          Financiacion financiacion = null;
          String documento = txtDocumento.getText().trim();
          String codigo_inmueble = txtInmueble.getText().trim();
          String codigo =txtCodigo.getText().trim();
          String valor = txtValor_financiacion.getText().trim();
          String abono = txtAbono.getText().trim();
          String numero_cuotas = txtNumero_cuotas.getText().trim();
          String cuotas_pagas = (String.valueOf(cuotas_p));
          String tipo = CBtipotipo.getSelectedItem().toString();
          
          String iva = ComboInteres.getSelectedItem().toString();
          
           datos= s.ConsultarTitular_inmueble(documento, codigo_inmueble);
           String doc_veri = "";
           doc_veri = String.valueOf(datos[0][0]);
  
            if ( doc_veri.equals("null")) 
            {JOptionPane.showMessageDialog(new JDialog(), "El documento y el codigo del inmueble no se relacionan");}
             else if(documento.matches("[a-z]*")){
               JOptionPane.showMessageDialog(new JDialog(), "El documento debe ser numerico");
               }else if(Integer.parseInt(valor) == 0){
                    JOptionPane.showMessageDialog(new JDialog(), "El valor a financiar no puede ser 0");
                      }
                    else if(valor.matches("[a-z]*")){
                    JOptionPane.showMessageDialog(new JDialog(), "El valor a financiar debe ser numerico");
                      }else if(numero_cuotas.matches("[a-z]*")){
                        JOptionPane.showMessageDialog(new JDialog(), "El numero de cuotas a financiar debe ser numerico");
                         }else if(numero_cuotas.equals("")){
                    JOptionPane.showMessageDialog(new JDialog(), "El numero de cuotas a diferir no puede estar vacio");
                      }
                      else if(numero_cuotas.equals("0")){
                    JOptionPane.showMessageDialog(new JDialog(), "El numero de cuotas a diferir no puede ser cero");
                      }else if(tipo.equals("Seleccione")){
                            JOptionPane.showMessageDialog(new JDialog(), "Debe seleccionar una opcion");
                            }else if(iva.equals("Seleccione")){
                            JOptionPane.showMessageDialog(new JDialog(), "Debe seleccionar una opcion");
                            }else {
                            String CodIva = s.CodigoIva(iva);
                            financiacion = new Financiacion(codigo, documento,codigo_inmueble,numero_cuotas, valor, cuotas_pagas,CodIva,tipo, abono);
                            }
          
         
         
        return financiacion;
    }

    
    /** This method is called from wi   thin the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtValor_financiacion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNumero_cuotas = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtInmueble = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        Limpiar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtCuotas_pagas = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        CBtipotipo = new javax.swing.JComboBox();
        txtNombre = new javax.swing.JLabel();
        ComboInteres = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtAbono = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtFactura = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtValor_pagar = new javax.swing.JLabel();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Codigo");

        jLabel2.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Documento");

        txtDocumento.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Consultar3.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Valor Financiación");

        txtValor_financiacion.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtValor_financiacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValor_financiacionActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Consultar Inmueble");

        txtNumero_cuotas.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Interes ");

        jLabel8.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Valor cuota");

        jLabel9.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Valor a  pagar");

        jLabel10.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Codigo Inmueble");

        txtInmueble.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtInmueble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInmuebleActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Dirección");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Consultar2.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Arial Narrow", 3, 21)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("FINANCIACIÓN");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Guardar.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Actualizar.png"))); // NOI18N
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Consultar.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Valor.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        Limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Limpiar.png"))); // NOI18N
        Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Numero de cuotas");

        jLabel14.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Consultar Titular");

        jLabel15.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Cuotas pagas");

        jLabel16.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Guardar");

        jLabel18.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Actualizar");

        jLabel19.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Consultar");

        jLabel20.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Limpiar");

        txtCuotas_pagas.setFont(new java.awt.Font("Arial Narrow", 3, 14)); // NOI18N
        txtCuotas_pagas.setForeground(new java.awt.Color(255, 255, 255));

        txtDireccion.setFont(new java.awt.Font("Arial Narrow", 3, 14)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Tipo Financiación");

        CBtipotipo.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        CBtipotipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Deuda", "Instalacion" }));
        CBtipotipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBtipotipoActionPerformed(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Arial Narrow", 3, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));

        ComboInteres.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        ComboInteres.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Iva Deudores", "Iva Financiacion" }));

        jLabel3.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Abono ");

        jLabel21.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Factura");

        txtFactura.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txtFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFacturaActionPerformed(evt);
            }
        });

        txtCodigo.setFont(new java.awt.Font("Arial Narrow", 2, 36)); // NOI18N
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 0, 0));
        jLabel22.setText("* Solo para Consultar");

        txtValor_pagar.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        txtValor_pagar.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addGap(14, 14, 14)
                        .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(txtInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(200, 200, 200)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel14)
                        .addGap(172, 172, 172)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(ComboInteres, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel12))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(txtValor_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel21))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addGap(27, 27, 27)
                                        .addComponent(Actualizar)
                                        .addGap(27, 27, 27)
                                        .addComponent(jButton3)
                                        .addGap(27, 27, 27)
                                        .addComponent(Limpiar))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel16)
                                        .addGap(69, 69, 69)
                                        .addComponent(jLabel18)
                                        .addGap(62, 62, 62)
                                        .addComponent(jLabel19)
                                        .addGap(64, 64, 64)
                                        .addComponent(jLabel20)))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel8))
                                    .addComponent(jButton5)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtValor_financiacion, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                                    .addComponent(txtAbono))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel13)
                                                    .addComponent(jLabel15))
                                                .addGap(22, 22, 22)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtCuotas_pagas, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(CBtipotipo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtNumero_cuotas, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(156, 156, 156)
                                        .addComponent(jLabel17))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, Short.MAX_VALUE)
                                        .addComponent(jLabel22)))))))
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel22)))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel6))
                        .addGap(23, 23, 23)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 19, Short.MAX_VALUE)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(jLabel11)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtValor_financiacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13))
                    .addComponent(jLabel5)
                    .addComponent(txtNumero_cuotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCuotas_pagas, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAbono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(ComboInteres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(CBtipotipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(txtFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtValor_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(Actualizar)
                    .addComponent(jButton3)
                    .addComponent(Limpiar)
                    .addComponent(jButton5))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(jLabel8)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void txtValor_financiacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValor_financiacionActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtValor_financiacionActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    String documento =txtDocumento.getText().trim();
 if(documento.equals("")){
    JOptionPane.showMessageDialog(new JDialog(), "Digite el numero del documento");
                                                     
 }else{
   datos= c.ConsultarCliente(documento);
    txtNombre.setText(String.valueOf(datos[0][3]));
 }
    
    // TODO add your handling code here:
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     Financiacion financiacion = null;
     financiacion = armafinanciacion();
    
    if (CBtipotipo.getSelectedItem().equals("Deuda")){
        
        String CodigoInm= txtInmueble.getText().trim();
        s.ConsultarDeuda(CodigoInm);
        String codigo = txtFactura.getText().trim();
             if(codigo.equals("")){
             JOptionPane.showMessageDialog(new JDialog(), "Digite el codigo de la factura que se va a financiar");
             }else{
             s.InserDeuda(codigo);
             if(financiacion == null){}else{s.insertar(financiacion); }
             }
    } else if (CBtipotipo.getSelectedItem().equals("Instalacion")){
         if(financiacion == null){}else{s.insertar(financiacion); }
    }   
        
    // TODO add your handling code here:
}//GEN-LAST:event_jButton2ActionPerformed

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        String codigo =txtInmueble.getText().trim();
 if(codigo.equals("")){
    JOptionPane.showMessageDialog(new JDialog(), "Digite el numero del inmueble");
                                                     
 }else{
   datos= i.ConsultarInmueble(codigo);
    txtDireccion.setText(String.valueOf(datos[0][1]));
 }
    
    // TODO add your handling code here:
}//GEN-LAST:event_jButton4ActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    String codigo1 =txtCodigo.getText().trim();
    datos2= s.ConsultarFinanciacion(codigo1);
if (datos2[0][0] == null){ 
    JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL CODIGO DE LA FINANCIACIÓN");
}else{
   
    
    txtCodigo.setText(String.valueOf(datos2[0][0]));
    txtCuotas_pagas.setText(String.valueOf(datos2[0][4]));
    txtDocumento.setText(String.valueOf(datos2[0][5]));
    txtValor_financiacion.setText(String.valueOf(datos2[0][3]));
    txtNumero_cuotas.setText(String.valueOf(datos2[0][1]));
    txtAbono.setText(String.valueOf(datos2[0][9]));
    txtInmueble.setText(String.valueOf(datos2[0][10]));
    String ivaset = String.valueOf(datos2[0][2]);
    String ivaenvia ="";
    ComboInteres.setSelectedItem(String.valueOf(datos2[0][2]));
    if(ivaset.equals("1")){
           ivaenvia  = "Iva Deudores";
           ComboInteres.setSelectedItem(ivaenvia);

          } else {
             ivaenvia  = "Iva Financiacion";
             ComboInteres.setSelectedItem(ivaenvia);
          
          }

    CBtipotipo.setSelectedItem(String.valueOf(datos2[0][8]));
    txtDireccion.setText(String.valueOf(datos2[0][6]));
    txtCuotas_pagas.setText(String.valueOf(datos2[0][7]));
    
    datos2 = s.CuotaFija(codigo1); 
    txtValor_pagar.setText(String.valueOf(datos2[0][7]));
}
    // TODO add your handling code here:
}//GEN-LAST:event_jButton3ActionPerformed

private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed

   if (txtValor_financiacion.getText().equals("") || txtNumero_cuotas.getText().equals("")){

    JOptionPane.showMessageDialog(new JDialog(), "TODOS LOS CAMPOS SON OBLIGATORIOS");

}else{
        
   Financiacion financiacion = null;
        financiacion = armafinanciacion();
        
         if(financiacion == null){}else{
      s.Modificarfinanciacion(financiacion);
        }
       
}
    
    // TODO add your handling code here:
}//GEN-LAST:event_ActualizarActionPerformed

private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarActionPerformed
datos1=s.NumeroGestion();
    txtCodigo.setText(String.valueOf(datos1[0][0]));
    txtCodigo.setText("");
    txtCuotas_pagas.setText("");
    txtDocumento.setText("");
    txtValor_financiacion.setText("");
    txtNumero_cuotas.setText("");
    ComboInteres.setSelectedItem("Elije un Servicio");
    txtDireccion.setText("");
    txtInmueble.setText("");
    txtValor_pagar.setText("");
    
    // TODO add your handling code here:
}//GEN-LAST:event_LimpiarActionPerformed

private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

    String codigo =txtCodigo.getText().trim();
    
   if (codigo.equals("") ){

       
    JOptionPane.showMessageDialog(new JDialog(), "DIGITE EL NUMERO DE LA FINANCIACON");

}else{
    datos2 = s.CuotaFija(codigo); 
    
            txtValor_pagar.setText(String.valueOf(datos2[0][7]));  
 
    
} 
    
    // TODO add your handling code here:
}//GEN-LAST:event_jButton5ActionPerformed

    private void CBtipotipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBtipotipoActionPerformed
      
        String codigo1=txtInmueble.getText().trim();
        String tipofi = CBtipotipo.getSelectedItem().toString();
        if (tipofi.equals("Deuda")){
            datos4 =s.ConsultarNumeroFactura(codigo1);
            txtFactura.setText(String.valueOf(datos4[0][0]));
        int k =JOptionPane.showConfirmDialog(this,"Desea verificar la Deuda del Usuario","Consulta",JOptionPane.YES_NO_OPTION);
        if(k==0){
            Gui_Consultar_Deudores_Inmuebles f2= new Gui_Consultar_Deudores_Inmuebles();
        f2.setVisible(true);
        }   
        
        
        
    }// TODO add your handling code here:
    }//GEN-LAST:event_CBtipotipoActionPerformed

    private void txtFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFacturaActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtInmuebleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInmuebleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInmuebleActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JComboBox CBtipotipo;
    private javax.swing.JComboBox ComboInteres;
    private javax.swing.JButton Limpiar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAbono;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JLabel txtCuotas_pagas;
    private javax.swing.JLabel txtDireccion;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtFactura;
    private javax.swing.JTextField txtInmueble;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JTextField txtNumero_cuotas;
    private javax.swing.JTextField txtValor_financiacion;
    private javax.swing.JLabel txtValor_pagar;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conexion;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import vista.Gui_Backup;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import vista.Gui_Factura;
import vista.Gui_cierre;

/**
 *
 * @author Paola Alfonso
 */
public class Index {

    ConexionMysql conm;
   
    public Index (){
        conm = new ConexionMysql();
}
    
    public class Imagen extends javax.swing.JPanel {
    
       public Imagen() {
           
       this.setSize(1000, 650); //se selecciona el tamaño del panel
        }
 
//Se crea un método cuyo parámetro debe ser un objeto Graphics
 
        public void paint(Graphics grafico) {
        Dimension height = getSize();
        //Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
        ImageIcon Img = new ImageIcon(getClass().getResource("/imagenes/FondoFormularios.png")); 
        //se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
        grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
        setOpaque(false);
        super.paintComponent(grafico);
        }
        
        
}
   

   
 public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Imagenes/logo133.png"));


        return retValue;
    }
 
 public void VerificarCiclos(){
  String registros = "";
  int inicio1 = 0;
  int fin1 = 0;
  int copia1 = 0;
  int factura1 = 0;
  int cierre1 = 0;
 
        //obtenemos la cantidad de registros existentes en la tabla
        try{

            ResultSet res = null;
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement( "SELECT inicio, fin, copia, factura, cierre as cierredb FROM fechas_facturacion");
           
            
            res = (ResultSet) pstm.executeQuery();
             while(res.next()){
            inicio1 = res.getInt("inicio");
            fin1 = res.getInt("fin");
            copia1 = res.getInt("copia");
            factura1 = res.getInt("factura");
            cierre1 = res.getInt("cierredb");
             
             }
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        System.out.println(registros);
    Date fechaActual = new Date();
    SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
    SimpleDateFormat formato1 = new SimpleDateFormat("dd / MMMM / yyyy");
    String cadenaFecha = formato.format(fechaActual);
    String cadenaFecha1= formato1.format(fechaActual);
    String []fecha = cadenaFecha.split("/");
    String Dia1="";
    Dia1=fecha[2] ;
    int DiaActual = Integer.parseInt(Dia1);
     
    if (DiaActual == copia1 ){
        int k =JOptionPane.showConfirmDialog(null,"Hoy es el dia "+cadenaFecha1+", Desea Realizar una Copia de Seguridad ?","Consulta",JOptionPane.YES_NO_OPTION);
        if(k==0){
        Gui_Backup f4= new Gui_Backup();
        f4.setVisible(true);       
    }
      
    }else if (DiaActual == inicio1 ){
    
    JOptionPane.showMessageDialog(new JDialog(), "Hoy es el dia "+cadenaFecha1+", El dia de Hoy da Inicio el periodo de facturacion");
    
    }else if (DiaActual == fin1 ){
    
    JOptionPane.showMessageDialog(new JDialog(), "Hoy es el dia "+cadenaFecha1+", El dia de Hoy se da Fin a el periodo de facturacion");
    
    }else if (DiaActual == factura1 ){
    
    int k =JOptionPane.showConfirmDialog(null,"Hoy es el dia "+cadenaFecha1+", Desea Generar las Facturas   ?","Consulta",JOptionPane.YES_NO_OPTION);
        if(k==0){
        Gui_Factura f4= new Gui_Factura();
        f4.setVisible(true); 
        }
    }else if (DiaActual == cierre1 ){
    
    int k =JOptionPane.showConfirmDialog(null,"Hoy es el dia "+cadenaFecha1+", Desea Cerrar el periodo de Facturación ?","Consulta",JOptionPane.YES_NO_OPTION);
        if(k==0){
        Gui_cierre f4= new Gui_cierre();
        f4.setVisible(true); 
        }
    }
 }
  
}

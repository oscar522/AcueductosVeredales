/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package conexion;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.Servicio;

/**
 *
 * @author PaolaAlfonso
 */
public class Servicio_servicio {

     ConexionMysql conm;


    public Servicio_servicio (){
        conm = new ConexionMysql();
}

    public Object [][] ConsultarServicio(String nombre){

        Object[][] datos = new String[1][2];
        try{
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("SELECT valor, idservicio FROM servicio  WHERE nombre = '"+nombre+"'");
             ResultSet res = null;
           res = (ResultSet) pstm.executeQuery();
             while(res.next()){

            String valor = res.getString("valor");
            String id = res.getString("idservicio");
           
                datos[0][0] = valor;
                datos[0][1] = id;
                           }

            res.close();
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL NOMBRE");
        }

         return datos;
    }

     public void ModificarServicio(Servicio a){
         try {
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("UPDATE servicio SET valor =  '" + a.getValor()+ "' " + "WHERE nombre  = '"+a.getNombre() + "' ");
              System.out.println(pstm);
              pstm.execute();
              pstm.close();
              JOptionPane.showMessageDialog(new JDialog(), "Valor actualizado correctamente");

        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA ACTUALIZACION");
        }

  }
     
     public void EliminarServicio(String nombre){
         try {
              PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("DELETE FROM servicio  WHERE nombre = 'Acueducto "+nombre+"'");
              System.out.println(pstm);
              pstm.execute();
              pstm.close();
             
              PreparedStatement pstm2 = (PreparedStatement) conm.getConnection().prepareStatement("DELETE FROM servicio WHERE nombre = 'Iva Acueducto " +nombre+"'");
              pstm2.execute();
              pstm2.close();
            
              PreparedStatement pstm3 = (PreparedStatement) conm.getConnection().prepareStatement("DELETE FROM  servicio WHERE nombre = 'Alcantarillado " +nombre+"'");
              pstm3.execute();
              pstm3.close();
              
              PreparedStatement pstm4 = (PreparedStatement) conm.getConnection().prepareStatement("DELETE FROM servicio WHERE nombre = 'Iva Alcantarillado " +nombre+"'");
              pstm4.execute();
              pstm4.close();
              
              PreparedStatement pstm5 = (PreparedStatement) conm.getConnection().prepareStatement("DELETE FROM servicio WHERE nombre = 'Reconexion Acueducto " +nombre+"'");
              pstm5.execute();
              pstm5.close();

              JOptionPane.showMessageDialog(new JDialog(), "Servicio eliminado correctamente"); 
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA ELIMINACION");
        }

  }

     public  void insertarbackup(String valor, String id){

         String q ="";
        try {
         q = "INSERT INTO backupservicios (valor, id_servicios) VALUES ('"+valor+"', '"+id+"')";

              PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(q);
              System.out.println(pstm);
              pstm.execute();
              pstm.close();
              
             } catch (SQLException e) {
                  System.out.println(e);
             
        }

    }
    
     public  void insertar(String nombre, String valoracued, String valorivaacueducto, String valoralcantarillado, String valorivaalcan, String valorreconc){
        
         String q ="";
         String q1 ="";
        try {
         q = "INSERT INTO servicio (CodServicio, nombre, valor) VALUES ('2',  'Acueducto "+nombre+"', '"+valoracued +"' )";
        
              PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(q);
              System.out.println(pstm);
              pstm.execute();
              pstm.close();
             
                        
              PreparedStatement pstm2 = (PreparedStatement) conm.getConnection().prepareStatement("INSERT INTO servicio (CodServicio, nombre, valor) VALUES ('3','Iva Acueducto " +nombre+"', '"+valorivaacueducto+"')");
              pstm2.execute();
              pstm2.close();
            
              PreparedStatement pstm3 = (PreparedStatement) conm.getConnection().prepareStatement("INSERT INTO servicio (CodServicio, nombre, valor) VALUES ('1','Alcantarillado " +nombre+"', '"+valoralcantarillado+"')");
              pstm3.execute();
              pstm3.close();
              
              PreparedStatement pstm4 = (PreparedStatement) conm.getConnection().prepareStatement("INSERT INTO servicio (CodServicio, nombre, valor) VALUES ('3','Iva Alcantarillado " +nombre+"', '"+valorivaalcan+"')");
              pstm4.execute();
              pstm4.close();
              
              PreparedStatement pstm5 = (PreparedStatement) conm.getConnection().prepareStatement("INSERT INTO servicio (CodServicio, nombre, valor) VALUES ('4','Reconexion Acueducto " +nombre+"', '"+valorreconc+"')");
              pstm5.execute();
              pstm5.close();
              
              JOptionPane.showMessageDialog(new JDialog(), "INGRESO DEL SERVICIO CORRECTO EN LA BASE DE DATOS");
             } catch (SQLException e) {
                  System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REGISTAR EL SERVICIO");
        }
        
    }
       public Object [][] cboIva(String Categoria){
         
        int registros = 0;
        //obtenemos la cantidad de registros existentes en la tabla
        try{

            ResultSet res = null;
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement( "SELECT count(*) as total  FROM `servicio` WHERE `nombre` LIKE '"+Categoria+"%'");
            
            res = (ResultSet) pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }
     
        
        Object[][] datos = new String[registros][5];
        try{
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("SELECT nombre, valor  FROM `servicio` WHERE `nombre` LIKE '"+Categoria+"%'");
            
             ResultSet res = null;
             res = (ResultSet) pstm.executeQuery();
             int i=0;
             while(res.next()){

            String idservicio = res.getString("nombre");
            String nombre = res.getString("nombre");
            String valor = res.getString("valor");
                datos[i][0] = idservicio;
                datos[i][1] = nombre;
                datos[i][2] = valor;
            i++;
            }

            res.close();
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL NUMERO DE DOCUMENTO");
        }

         return datos;
           } 
       
       public  void insertarFechas(String inicio, String fin, String cierre, String generacion, String copia, String reconexion){
        
         String q ="";
        
        try {
         q = "UPDATE fechas_facturacion SET cierre = '"+cierre+"', factura = '"+generacion +"', copia = '"+copia +"', inicio = '"+inicio+"', reconexion = '"+reconexion+"', fin = '"+fin+"'";
        
              PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(q);
              System.out.println(pstm);
              pstm.execute();
              pstm.close();
              JOptionPane.showMessageDialog(new JDialog(), "INGRESO DE LOS DIAS CORRECTOS");
             } catch (SQLException e) {
                  System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REGISTAR LOS DIAS");
        }
}
       
       public Object [][] ConsultarDias(){

        Object[][] datos = new String[1][6];
        try{
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("SELECT cierre, factura, copia, inicio, fin, reconexion FROM fechas_facturacion");
             ResultSet res = null;
           res = (ResultSet) pstm.executeQuery();
             while(res.next()){

            String cierre = res.getString("cierre");
            String factura = res.getString("factura");
            String copia = res.getString("copia");
            String inicio = res.getString("inicio");
            String fin = res.getString("fin");
            String rec = res.getString("reconexion");
           
                datos[0][0] = cierre;
                datos[0][1] = factura;
                datos[0][2] = copia;
                datos[0][3] = inicio;
                datos[0][4] = fin;
                datos[0][5] = rec;
                           }

            res.close();
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL NOMBRE");
        }

         return datos;
    }
       
              public String verificarperiodopago(String fecha){

        String codigo_factura1 = "0";
        try{
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("SELECT p.codigo_factura from pago_factura p, factura f where p.codigo_factura = f.codigo_factura and f.fecha_de_pago='"+fecha+"'");
             ResultSet res = null;
           res = (ResultSet) pstm.executeQuery();
             while(res.next()){

            codigo_factura1 = res.getString("codigo_factura");
            
           
                            
                           }

            res.close();
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR");
        }

         return codigo_factura1;
    }

 public String verificarperiododeuda(String fecha){

        String codigo ="0";
        try{
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("SELECT d.codigo_factura from factura f, deudor d where d.codigo_factura = f.codigo_factura and f.fecha_de_pago='"+fecha+"'");
             ResultSet res = null;
           res = (ResultSet) pstm.executeQuery();
             while(res.next()){

            codigo = res.getString("codigo_factura");
            
           
            }

            res.close();
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR");
        }

         return codigo;
    }
 public void eliminarperiodofacturacion(String fecha){
     
     try{
      PreparedStatement pstm5 = (PreparedStatement) conm.getConnection().prepareStatement("delete from factura where fecha_de_pago = '"+fecha+"'");
              pstm5.execute();
              pstm5.close();

              JOptionPane.showMessageDialog(new JDialog(), "Periodo de faturacion eliminado correctamente"); 
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA ELIMINACION");
        }
     
     try{
      PreparedStatement pstm5 = (PreparedStatement) conm.getConnection().prepareStatement("delete from periodos where fechaPago = '"+fecha+"'");
              pstm5.execute();
              pstm5.close();

              //JOptionPane.showMessageDialog(new JDialog(), "TABLA PERIODO ELIMINADA"); 
        }catch(SQLException e){
            System.out.println(e);
            // JOptionPane.showMessageDialog(new JDialog(), "ERROR ELIMINACION");
        }
     
 }

}

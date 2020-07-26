/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.Cliente;


/**
 *
 * @author Paolita
 */
public class Servicio_cliente {
    
    ConexionMysql conm;
 
    
    public Servicio_cliente (){
        conm = new ConexionMysql();
}

    public  void insertar(Cliente cliente){
        
         String q ="";
        try {
         q = "INSERT INTO cliente (documento, tipo_documento, genero, telefono, nombre) VALUES (" +cliente.getDocumento()+",'" +cliente.getTipo_documento()+"','" +cliente.getGenero()+"'," +cliente.getTelefono()+",'" +cliente.getNombre()+"')";
        
              PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(q);
              //System.out.println(pstm);
              pstm.execute();
              pstm.close();
              JOptionPane.showMessageDialog(new JDialog(), "INGRESO DE CLIENTE CORRECTO EN LA BASE DE DATOS");
            
             } catch (SQLException e) {
                  System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REGISTAR EL CLIENTE");
        }
        
    }
    
    

public Object [][] ConsultarCliente(String DOCUMENTO){

        Object[][] datos = new String[1][6];
        try{
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("SELECT " +
            " documento,tipo_documento,genero,telefono,Nombre" +
            " FROM cliente " +
            " WHERE documento = "+DOCUMENTO+ 
            " ORDER BY documento ");
            
             ResultSet res = null;
             res = (ResultSet) pstm.executeQuery();
             while(res.next()){

            //String documento = res.getString("documento");
            String tipo = res.getString("tipo_documento");
            String genero = res.getString("genero");
            String telefono_fij = res.getString("telefono");
            String nombre = res.getString("Nombre");
            

                datos[0][0] = tipo;
                datos[0][1] = genero;
                datos[0][2] = telefono_fij;
                datos[0][3] = nombre;
                

            }

            res.close();
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL NUMERO DE DOCUMENTO");
        }

         return datos;


    }

  public void ModificarCliente(Cliente cliente){
         try {
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("UPDATE cliente SET genero =  '" + cliente.getGenero()+
                    "', telefono = '" + cliente.getTelefono()+"' , Nombre = '" + cliente.getNombre() + "' " + "WHERE documento  ="  + cliente.getDocumento());
              //System.out.println(pstm);
              pstm.execute();
              pstm.close();
              
              JOptionPane.showMessageDialog(new JDialog(), "Actualizacion correcta");

        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA ACTUALIZACION");
        }

  }
             
        public void BorrarCliente(String documento)  {

        try {

           PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("delete from cliente  WHERE documento  ='" + documento + "'");
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(new JDialog(), "EL CLIENTE SE A ELIMINADO");
            
        } catch(SQLException e){
            System.out.println(e);

        }
     }


public String CodigoAcueducto(String iva) {
           
      String idservicio = "";
        try{
            com.mysql.jdbc.PreparedStatement pstm = (com.mysql.jdbc.PreparedStatement) conm.getConnection().prepareStatement("SELECT idservicio,nombre   FROM servicio WHERE nombre = '"+iva+"' AND CodServicio = 5");
            ResultSet res = null;
            res = (ResultSet) pstm.executeQuery();
            while(res.next()){
            idservicio = res.getString("idservicio");
            
             }

            res.close();
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL CODIGO DEL INMUEBLE");
        }

         return idservicio;   
        
        
    }
}
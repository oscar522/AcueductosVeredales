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
import modelo.Usuarios;


/**
 *
 * @author Paolita
 */
public class Servicios_usuarios {
    
    ConexionMysql conm;
 
    
    public Servicios_usuarios (){
        conm = new ConexionMysql();
}

    public  void insertar(Usuarios usuarios){
        //////////////////////// INSERTAR EN LA TABLA ////////////////7
         String q ="";
        try {
         q = "INSERT INTO usuarios (nombre, apellidos, usuario, contrasena, idetificacion) VALUES ('" +usuarios.getNombre()+"','" +usuarios.getApellidos()+"','" +usuarios.getUsuario()+"', MD5('" +usuarios.getContrasena()+"'),'"+usuarios.getIdentifica()+"' )";
        
              PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(q);
              System.out.println(q);
              pstm.execute();
              pstm.close();
              //////////////////////// INSERTAR EN LA DB ////////////////7  
                     String DB ="";
                     try {
                        DB = "CREATE USER '"+usuarios.getUsuario()+"'@'localhost' IDENTIFIED BY '"+usuarios.getContrasena()+"'";
        
                        PreparedStatement DB_TRANS = (PreparedStatement) conm.getConnection().prepareStatement(DB);
                        System.out.println(DB);
                        DB_TRANS.execute();
                        DB_TRANS.close();
                        JOptionPane.showMessageDialog(new JDialog(), "INGRESO USUARIO DB");
            
                        } catch (SQLException e) {
                        System.out.println(e);
                        JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REGISTAR EL INGRESO USUARIO DB");
                        }
            ////     
            JOptionPane.showMessageDialog(new JDialog(), "INGRESO DE CLIENTE CORRECTO EN LA BASE DE DATOS");

        } catch (SQLException e) {
        System.out.println(e);
        JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REGISTAR EL CLIENTE");
        }
        
    }
    
    

public Object [][] ConsultarUsuario(String DOCUMENTO){

        Object[][] datos = new String[1][6];
        try{
            String q = " SELECT " +
            "idusuario, nombre, apellidos, usuario, contrasena, idetificacion " +
            " FROM usuarios "+
            " WHERE estado = 'A' and idetificacion = "+DOCUMENTO;
            
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(q);
             System.out.println(q);
             ResultSet res = null;
             res = (ResultSet) pstm.executeQuery();
             while(res.next()){
            
            //String documento = res.getString("documento");
            String idetificacion = res.getString("idetificacion");
            String nombre = res.getString("nombre");
            String apellidos = res.getString("apellidos");
            String usuario = res.getString("usuario");
            String contrasena = res.getString("contrasena");
            

                datos[0][0] = idetificacion;
                datos[0][1] = nombre;
                datos[0][2] = apellidos;
                datos[0][3] = usuario;
                datos[0][4] = contrasena;
                

            }

            res.close();
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL NUMERO DE DOCUMENTO");
        }

         return datos;


    }

  public void ModificarCliente(Usuarios usuarios){
          //////////////////////// PERMISOS PARA USUARIOS EN DB ////////////////7  
                     try {
                        
                           //String  q = "INSERT INTO usuarios (nombre, apellidos, usuario, contrasena, idetificacion) VALUES ('" +usuarios.getNombre()+"','" +usuarios.getApellidos()+"','" +usuarios.getUsuario()+"', MD5('" +usuarios.getContrasena()+"'),'"+usuarios.getIdentifica()+"' )";
                              String q = "UPDATE usuarios SET contrasena =  MD5('" +usuarios.getContrasena()+"') WHERE idetificacion  ="   +usuarios.getIdentifica()+"";
                            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(q);
                            System.out.println(q);
                            pstm.execute();
                            pstm.close();
                            
                        } catch (SQLException e) {
                        System.out.println(e);
                        JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REGISTAR MODIFICAR");
                        }
                      /////////////////////////////////////////////////////////////////////////////////////
  }
             
        public void BorrarUsuario(Usuarios usuarios)  {

       //////////////////////// PERMISOS PARA USUARIOS EN DB ////////////////7  
                     try {
                           //String  q = "INSERT INTO usuarios (nombre, apellidos, usuario, contrasena, idetificacion) VALUES ('" +usuarios.getNombre()+"','" +usuarios.getApellidos()+"','" +usuarios.getUsuario()+"', MD5('" +usuarios.getContrasena()+"'),'"+usuarios.getIdentifica()+"' )";
                              String q = "UPDATE usuarios SET estado =  'I'  WHERE idetificacion  ="+usuarios.getIdentifica()+"";
                            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(q);
                            System.out.println(q);
                            pstm.execute();
                            pstm.close();
                        } catch (SQLException e) {
                        System.out.println(e);
                        JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REGISTAR PERMISOS PARA USUARIOS EN DB");
                        }
                      /////////////////////////////////////////////////////////////////////////////////////
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

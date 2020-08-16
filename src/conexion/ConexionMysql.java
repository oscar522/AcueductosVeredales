/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package conexion; 
import java.sql.*;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.Servicios_globales;
public class ConexionMysql {
    private static Connection conn = null;
    private static String Key = "AcuedutosComunitarios1.*";
    Servicios_globales glo = new Servicios_globales();
    
    public ConexionMysql() {
        
    }
    
    public Connection getConnection(){
        if (conn!=null){
            System.out.println("Ya Esta Conectado");
        } else {
            System.out.println("Se Creo una Conexion");
            conectar();
        }
        return conn;
    }
    public void desconectar(){
        conn = null;
    }
    
    public void conectar (){
        String usuario = glo.getUser();
        String contrasena = glo.getPass();
        try{
            if (usuario != "root")
            {
                usuario = "root";
                try {
                    java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
                    byte[] array = md.digest(Key.getBytes());
                    StringBuffer sb = new StringBuffer();
                    for (int i = 0; i < array.length; ++i) {
                      sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
                    }
                    contrasena = sb.toString();

                } catch (java.security.NoSuchAlgorithmException e) {
                }
            }
            Class.forName("com.mysql.jdbc.Driver"); // mod
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_acueductos", usuario , contrasena);
            if (conn!=null){
                System.out.println("Conexión a base de datos listo mysql");
            }           
        }catch(java.sql.SQLException e){
            if (e.toString().contains("Communications link failure")) {                         
                JOptionPane.showMessageDialog(new JDialog(), "Error de comunicacion con el servidor");
            }else if (e.toString().contains("Access denied for user")) {
                System.out.println(e);
                JOptionPane.showMessageDialog(new JDialog(), "VERIFIQUE USUARIO Y CONTRASEÑA");
            }
        }catch(ClassNotFoundException e){
            System.out.println("error no conecta mysql   "+e);
        }
    }
}
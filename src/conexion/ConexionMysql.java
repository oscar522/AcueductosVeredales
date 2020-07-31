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
    Connection conn = null;
     Servicios_globales glo = new Servicios_globales();
 
    public ConexionMysql() {
        String usuario = glo.getUser();
        String contrasena = glo.getPass();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agua_florida", "root" , "");
            if (conn!=null){
                System.out.println("Conexión a base de datos listo mysql");
            }            System.out.print(usuario + contrasena);

        }catch(java.sql.SQLException e){
            System.out.println(e);
              JOptionPane.showMessageDialog(new JDialog(), "VERIFIQUE USUARIO Y CONTRASEÑA");
        }catch(ClassNotFoundException e){
            System.out.println("error no conecta mysql   "+e);
        }
    }
    public Connection getConnection(){
        return conn;
    }
    public void desconectar(){
        conn = null;
    }
}
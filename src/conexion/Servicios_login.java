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
import vista.Gui_Factura;
import vista.Gui_cierre;
import vista.Gui_index;
import vista.Gui_usuarios;
import vista.Nuevo_index;

/**
 *
 * @author OSCARPC
 */
public class Servicios_login {
     
    public Servicios_login (){
        
    }
    public void accesso(String user, String pass){
    ConexionMysql conm = new ConexionMysql();
    String usuario = "";
    String contrasena = "";
    String nombre_usu = "";

        //obtenemos la cantidad de registros existentes en la tabla
    try{
        if (!user.equals("root")) {
            ResultSet res = null;
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement( 
                    "SELECT CONCAT(nombre, ' ', apellidos) As Nombre, usuario, contrasena FROM usuarios WHERE contrasena = MD5('"+pass+"') and usuario = '"+user+"'");
            System.out.println("SELECT CONCAT(nombre, ' ', apellidos) As Nombre, usuario, contrasena FROM usuarios WHERE contrasena = MD5('"+pass+"') and usuario = '"+user+"'");

            res = (ResultSet) pstm.executeQuery();
            while(res.next()){
                usuario = res.getString("usuario");
                contrasena = res.getString("contrasena");
                nombre_usu = res.getString("Nombre");
            }
            res.close();
            if ((usuario != "") && (contrasena != "")) {
                JOptionPane.showMessageDialog(null,"Bienvenido "+nombre_usu);
                Nuevo_index index = new Nuevo_index();
                index.show();
            } else {
                JOptionPane.showMessageDialog(null,"In - Correcto : Usuario o contraseña ");
            }
        }else {
            JOptionPane.showMessageDialog(null,"Bienvenido "+nombre_usu);
            Nuevo_index index = new Nuevo_index();
            index.show();
        }
    }catch(SQLException e){
        System.out.println(e);
    }


    
    
 }
        
        
}

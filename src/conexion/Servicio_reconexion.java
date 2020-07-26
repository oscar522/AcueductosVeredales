/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conexion;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author PaolaAlfonso
 */
public class Servicio_reconexion {
    
     ConexionMysql conm;
   
    public Servicio_reconexion() {
        // 
        conm = new ConexionMysql();
    }
    
    public void insertarcorte(String codigo){
       
        
        try {
            //PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("UPDATE reconexion SET Estado = 'AC', Estadoservis = 'COR'  WHERE codigo_reconeccion  ="+codigo);
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("UPDATE reconexion SET Estado = 'COR', Estadoservis = '1'  WHERE codigo_reconeccion  ="+codigo);
           
              pstm.execute();
              pstm.close();
               JOptionPane.showMessageDialog(new JDialog(), "RECONEXIÓN ACTUALIZADA");

        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA RECONEXIÓN");
        }
}
    
     public void insertarreconexion(String codigo){
       
        
        try {
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("UPDATE reconexion SET Estado = 'REC' WHERE codigo_reconeccion  ="+codigo);
           
              pstm.execute();
              pstm.close();
               JOptionPane.showMessageDialog(new JDialog(), "RECONEXIÓN ACTUALIZADA");

        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA RECONEXIÓN");
        }
}
    
    public Object [][] Consultar(String codigo){
        
        Object[][] datos = new String[1][4];
        
         try{
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("SELECT c.Nombre, c.documento, i.codigo_inmueble, i.Direccion "
                    + "FROM cliente c, inmueble i, factura f, reconexion r WHERE"
                    + "(r.codigo_factura = f.codigo_factura)"
                    + "AND (f.codigo_inmueble = i.codigo_inmueble)"
                    + "AND (i.documento = c.documento) "
                    + "AND r.codigo_reconeccion ="+codigo);
           
            
            ResultSet res = null;
            res = (ResultSet) pstm.executeQuery();
            while(res.next()){

            String nombre = res.getString("Nombre");
            String documento = res.getString("documento");
            String codigo_i = res.getString("codigo_inmueble");
            String direccion = res.getString("Direccion");
            
                datos[0][0] = nombre;
                datos[0][1] = documento;
                datos[0][2] = codigo_i;
                datos[0][3] = direccion;
            }

            res.close();
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL NUMERO DE RECONEXIÓN");
    }
          return datos;
}

}
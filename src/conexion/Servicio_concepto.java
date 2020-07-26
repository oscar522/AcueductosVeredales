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
import modelo.Otros_conceptos;

/**
 *
 * @author PaolaAlfonso
 */
public class Servicio_concepto {
    
  ConexionMysql conm;


    public Servicio_concepto (){
        conm = new ConexionMysql();
}

    public Object [][] NumeroGestion(){

        Object[][] datos = new String[1][1];
             try{
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(
            "SELECT max(id+1)as total FROM otrosconceptos");
            ResultSet res = (ResultSet) pstm.executeQuery();
             while(res.next()){
            String total = res.getString("total");
                datos[0][0] = total;
            }
            res.close();
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA");
        }
         return datos;
    }
        public  void insertar(Otros_conceptos concepto){

         String q ="";
        try {
         q = "INSERT INTO otrosconceptos (inmueble,cocepto,valor,estado) VALUES (" +concepto.getInmueble()+",'" +concepto.getConceptos()+"','" +concepto.getValor()+ "','AC')";

              PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(q);
              //System.out.println(pstm);
              pstm.execute();
              pstm.close();
              JOptionPane.showMessageDialog(new JDialog(), "CONCEPTO INGRESADO CORRECTAMENTE");

             } catch (SQLException e) {
                  System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REGISTAR INTENTELO NUEVAMENTE");
        }

    }

        public void ModificarConcepto(Otros_conceptos c){
         try {
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("UPDATE otrosconceptos SET inmueble =  '" + c.getInmueble()+ "' ,cocepto= '" + c.getConceptos() + "' , valor='" +  c.getValor()  + "' " + "WHERE id  = '"+c.getId() + "' ");
              //System.out.println(pstm);
              pstm.execute();
              pstm.close();

              JOptionPane.showMessageDialog(new JDialog(), "Concepto actualizado correctamente");

        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA ACTUALIZACION");
        }

  }
         public void EliminarConcepto(String codigo){
         try {
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("UPDATE otrosconceptos SET estado= 'IN' " + "WHERE id  = '"+codigo + "' ");
              //System.out.println(pstm);
              pstm.execute();
              pstm.close();

              JOptionPane.showMessageDialog(new JDialog(), "Concepto eliminado correctamente");

        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA ELIMINACION");
        }

  }
        
       public Object [][] ConsultarConceptos(String CODIGO){

        Object[][] datos = new String[1][6];
        try{
            String q = "SELECT " +
            " o.cocepto as concepto, o.valor as valor, o.fecha as fecha, o.inmueble as inmueble, i.Direccion as direccion, o.estado as estado " +
            " FROM  otrosconceptos o, inmueble i " +
            " WHERE o.inmueble= i.codigo_inmueble and i.codigo_inmueble= "+CODIGO+ " ";
             System.out.println(q);
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(q);
           
            ResultSet res = null;
            res = (ResultSet) pstm.executeQuery();
            while(res.next()){

            String concepto = res.getString("concepto");
            String valor = res.getString("valor");
            String fecha = res.getString("fecha");
            String inmueble = res.getString("inmueble");
            String direccion = res.getString("direccion");
            String estado = res.getString("estado");


                datos[0][0] = concepto;
                datos[0][1] = valor;
                datos[0][2] = fecha;
                datos[0][3] = inmueble;
                datos[0][4] = direccion;
                datos[0][5] = estado;


            }

            res.close();
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL CODIGO DEL CONCEPTO");
        }

         return datos;


    }
       
       public Object [][] ConsultarConcepto(String CODIGO){

        Object[][] datos = new String[1][6];
        try{
            String q = "SELECT " +
            " o.cocepto as concepto, o.valor as valor, o.fecha as fecha, o.inmueble as inmueble, i.Direccion as direccion, o.estado as estado " +
            " FROM  otrosconceptos o, inmueble i " +
            " WHERE o.estado ='AC' AND o.inmueble= i.codigo_inmueble and o.id= "+CODIGO+ " ";
           System.out.println(q);
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(q);
           System.out.println(pstm);
            ResultSet res = null;
            res = (ResultSet) pstm.executeQuery();
            while(res.next()){

            String concepto = res.getString("concepto");
            String valor = res.getString("valor");
            String fecha = res.getString("fecha");
            String inmueble = res.getString("inmueble");
            String direccion = res.getString("direccion");
            String estado = res.getString("estado");


                datos[0][0] = concepto;
                datos[0][1] = valor;
                datos[0][2] = fecha;
                datos[0][3] = inmueble;
                datos[0][4] = direccion;
                datos[0][5] = estado;


            }

            res.close();
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL CODIGO DEL CONCEPTO");
        }

         return datos;


    }
       

       public Object [][] ConsultarFinanciaciones(String codigo){

        int registros = 0;

        String sqlver = "SELECT  count(*) as total FROM cliente c, inmueble i,  otrosconceptos o where (o.inmueble = i.codigo_inmueble) and (i.documento = c.documento) AND o.inmueble='" +codigo+ "'";

        System.out.println(sqlver);//obtenemos la cantidad de registros existentes en la tabla

        Object[][] datos = new String[registros][5];
        try{
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("SELECT " +
            " c.Nombre, i.Direccion,o.fecha, o.cocepto, o.valor, o.estado " +
            " FROM cliente c, inmueble i,  otrosconceptos o " +
            " WHERE (o.inmueble = i.codigo_inmueble) and (i.documento = c.documento) AND o.inmueble='"+codigo+ "'");

             ResultSet res = null;
             res = (ResultSet) pstm.executeQuery();
             int i=0;
             while(res.next()){

            String nombre = res.getString("Nombre");
            String direccion = res.getString("Direccion");
            String fecha = res.getString("fecha");
            String concepto = res.getString("cocepto");
            String valor = res.getString("valor");
            String estado = res.getString("estado");


                datos[i][0] = nombre;
                datos[i][1] = direccion;
                datos[i][2] = fecha;
                datos[i][3] = concepto;
                datos[i][4] = valor;
                datos[i][5] = estado;

            i++;
            }

            res.close();
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL NUMERO DE DOCUMENTO");
        }

         return datos;


    }
}


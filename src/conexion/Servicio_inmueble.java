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
import modelo.Inmueble;

/**
 *
 * @author Paolita
 */
public class Servicio_inmueble {
    
    ConexionMysql conm;
 
     public Servicio_inmueble (){
        conm = new ConexionMysql();
}
    
       
     
   public Object [][] ComboAlcantarillado(){
         
        int registros = 0;
        //obtenemos la cantidad de registros existentes en la tabla
        try{

            ResultSet res = null;
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement( "SELECT Count(*) as total  FROM servicio WHERE CodServicio = 1");
            
            res = (ResultSet) pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }
     
        
        Object[][] datos = new String[registros][5];
        try{
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("SELECT idservicio, nombre   FROM servicio WHERE CodServicio = 1");
            
             ResultSet res = null;
             res = (ResultSet) pstm.executeQuery();
             int i=0;
             while(res.next()){

            String idservicio = res.getString("idservicio");
            String nombre = res.getString("nombre");
                datos[i][0] = idservicio;
                datos[i][1] = nombre;
            i++;
            }

            res.close();
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL NUMERO DE DOCUMENTO");
        }

         return datos;
    }  
public Object [][] ComboAcueducto(){
         
        int registros = 0;
        //obtenemos la cantidad de registros existentes en la tabla
        try{

            ResultSet res = null;
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement( "SELECT Count(*) as total  FROM servicio WHERE CodServicio = 2");
            
            res = (ResultSet) pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }
     
        
        Object[][] datos = new String[registros][5];
        try{
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("SELECT idservicio, nombre   FROM servicio WHERE CodServicio = 2");
            
             ResultSet res = null;
             res = (ResultSet) pstm.executeQuery();
             int i=0;
             while(res.next()){

            String idservicio = res.getString("idservicio");
            String nombre = res.getString("nombre");
                datos[i][0] = idservicio;
                datos[i][1] = nombre;
            i++;
            }

            res.close();
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL NUMERO DE DOCUMENTO");
        }

         return datos;
    }
     
     public Object [][] NumeroGestion(int numero){

        Object[][] datos = new String[1][1];
             try{
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(
            "SELECT max(codigo_inmueble+1)as total FROM inmueble");
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
    

     
     
     public  void insertar(Inmueble inmueble){
        String Acueducto = "";
        String Alcantarillado ="";
         try{
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(
            "SELECT idservicio as Acueducto, (SELECT idservicio FROM servicio WHERE nombre ='"+inmueble.getAlcantarillado()+"') as alcantarillado   FROM servicio WHERE nombre ='"+inmueble.getAcueducto()+"'");
            ResultSet res = (ResultSet) pstm.executeQuery();
             while(res.next()){
             Acueducto = res.getString("Acueducto");
             Alcantarillado = res.getString("alcantarillado");
                
            }
            res.close();
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA");
        }
        
         
         
         String q ="";
        try {
         q = "INSERT INTO inmueble (codigo_inmueble, direccion, telefono,alcantarillado, acueduto, documento) VALUES ("+inmueble.getCodigo()+",'"+inmueble.getDireccion()+"','"+inmueble.getTelefono()+"','"+Alcantarillado+"','"+Acueducto+"','"+inmueble.getDocumento()+"')";
        
      PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(q);
              System.out.println(pstm);
              pstm.execute();
              pstm.close();
              JOptionPane.showMessageDialog(new JDialog(), "Inmueble ingresado correctamente");
            
             } catch (SQLException e) {
                  System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "Error al ingresar el inmueble");
        }
        
}
     
   public Object [][] ConsultarInmueble(String CODIGO){

        Object[][] datos = new String[1][10];
        try{
            
             
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(
            "SELECT " +
            "i.direccion as Direccion, " +
            "i.telefono as Telefono, " +
            "i.documento as Documento, " +
            "s.Codservicio as CodAlcanta, " +
            "s.nombre as Alcantarrillado, " +
            "s.valor as ValorAlcanta, " +

            "(select s.Codservicio FROM  " +
            "inmueble i, " +
            "servicio s  " +
            "WHERE " +
            "s.idservicio = i.Acueduto " +
            "and i.codigo_inmueble="+CODIGO+ " ) as CodAcueducto, " +

            "(select s.nombre FROM  " +
            "inmueble i, " +
            "servicio s  " +
            "WHERE " +
            "s.idservicio = i.Acueduto " +
            "and i.codigo_inmueble="+CODIGO+ " ) as Acueducto, " +

            "(select s.valor FROM " +
            "inmueble i, " +
            "servicio s  " +
            "WHERE " +
            "s.idservicio = i.Acueduto " +
            "and i.codigo_inmueble="+CODIGO+ " ) as ValorAcueducto " +

            "FROM " +
            "inmueble i, " +
            "servicio s " +
            "WHERE " +
            "s.idservicio = i.alcantarillado and i.estado ='AC'" +
            "and i.codigo_inmueble="+CODIGO+ " ");
            
             ResultSet res = null;
                res = (ResultSet) pstm.executeQuery();
             while(res.next()){


             String Direccion = res.getString("Direccion");
             String Telefono = res.getString("Telefono");
             String Documento = res.getString("Documento");
             String CodAlcanta = res.getString("CodAlcanta"); 
             String Alcantarrillado = res.getString("Alcantarrillado"); 
             String ValorAlcanta = res.getString("ValorAlcanta"); 
             String CodAcueducto = res.getString("CodAcueducto"); 
             String Acueducto = res.getString("Acueducto"); 
             String ValorAcueducto = res.getString("ValorAcueducto"); 

             datos[0][1] = Direccion;
             datos[0][2] = Telefono;
             datos[0][3] = Documento; 
             datos[0][4] = CodAlcanta;
             datos[0][5] = Alcantarrillado;//
             datos[0][6] = ValorAlcanta;
             datos[0][7] = CodAcueducto;
             datos[0][8] = Acueducto;//
             datos[0][9] = ValorAcueducto;
                
                

            }

            res.close();
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL NUMERO DE DOCUMENTO");
           
        }

         return datos;


    }  
     
     public void ModificarInmueble(Inmueble inmueble){
         
         String Acueducto = "";
        String Alcantarillado ="";
         try{
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(
            "SELECT idservicio as Acueducto, (SELECT idservicio FROM servicio WHERE nombre ='"+inmueble.getAlcantarillado()+"') as alcantarillado   FROM servicio WHERE nombre ='"+inmueble.getAcueducto()+"'");
            ResultSet res = (ResultSet) pstm.executeQuery();
             while(res.next()){
             Acueducto = res.getString("Acueducto");
             Alcantarillado = res.getString("alcantarillado");
                
            }
            res.close();
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA");
        }
         
         try {
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("UPDATE inmueble SET direccion =  '" + inmueble.getDireccion()+
                    "', Telefono = '" + inmueble.getTelefono()+"' , alcantarillado ='"+Alcantarillado+"', acueduto = '"+Acueducto+"', documento =" + inmueble.getDocumento()+" WHERE codigo_inmueble  ="+inmueble.getCodigo());
           
              pstm.execute();
              pstm.close();
              JOptionPane.showMessageDialog(new JDialog(), "Actualizacion correcta");
              
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA ACTUALIZACION");
        }

  }
     
     
     public void insertarcambiousuario (Inmueble inmueble, String documento){
    String q="";
    try {
         q = "INSERT INTO cambiousuario (`id`, `documento`, `inmueble`, `fecha`) VALUES (NULL, '"+documento+"', '"+inmueble.getCodigo()+"', CURRENT_TIMESTAMP)";
        
      PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(q);
              System.out.println(pstm);
              pstm.execute();
              pstm.close();
              
            
             } catch (SQLException e) {
                  System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "Error guardar el usuario");
        }
     
     }
     public void BorrarInmueble(String Codigo)  {

        try {

           PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("UPDATE inmueble set estado ='IN' " + "WHERE codigo_inmueble  ='"+Codigo+"'");
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(new JDialog(), "EL INMUEBLE SE A ELIMINADO");
            
        } catch(SQLException e){
            System.out.println(e);

        }
     }

     
     public Object [][] ConsultarInmuebleCodigo(String documento){
         
        int registros = 0;
        //obtenemos la cantidad de registros existentes en la tabla
        try{

            ResultSet res = null;
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement( "SELECT  count(*) as total FROM inmueble i, cliente c WHERE i.documento = c.documento and i.estado='AC' and i.documento='" +documento+ "'");
            
            res = (ResultSet) pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }
     
        
        Object[][] datos = new String[registros][5];
        try{
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("SELECT " +
            " c.nombre, i.codigo_inmueble,i.direccion,i.telefono" +
            " FROM cliente c, inmueble i " +
            " WHERE i.documento = c.documento and i.estado='AC' and i.documento= '"+documento+ "'");
            
             ResultSet res = null;
             res = (ResultSet) pstm.executeQuery();
             int i=0;
             while(res.next()){

            String codigo = res.getString("codigo_inmueble");
            String direccion = res.getString("direccion");
            String telefono = res.getString("telefono");
            String nombre = res.getString("nombre");
                
                datos[i][0] = codigo;
                datos[i][1] = direccion;
                datos[i][2] = telefono;
                datos[i][3] = nombre;
               
            i++;
            }

            res.close();
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL NUMERO DE DOCUMENTO");
        }

         return datos;


    }
     
     public Object [][] ConsultarInmuebleNombre(String nombre2){
         
        int registros = 0;
        //obtenemos la cantidad de registros existentes en la tabla
        try{

            ResultSet res = null;
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement( "SELECT  count(*) as total FROM inmueble i, cliente c WHERE i.documento = c.documento and i.estado= 'AC' and c.nombre LIKE  '%"+nombre2+"%'");
            
            res = (ResultSet) pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }
     
        
        Object[][] datos = new String[registros][5];
        
        try{
            
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("select c.nombre, i.codigo_inmueble, i.direccion, i.telefono FROM cliente c, inmueble i WHERE i.documento = c.documento AND i.estado = 'AC' AND c.nombre LIKE  '%"+nombre2+"%'");
            
             ResultSet res = null;
             res = (ResultSet) pstm.executeQuery();
             int i=0;
             while(res.next()){

            String codigo = res.getString("codigo_inmueble");
            String direccion = res.getString("direccion");
            String telefono = res.getString("telefono");
            String nombre = res.getString("nombre");
            
            
                
                datos[i][0] = codigo;
                datos[i][1] = direccion;
                datos[i][2] = telefono;
                datos[i][3] = nombre;
               
                
            i++;
            }

            res.close();
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL NOMBRE");
        }

         return datos;


    }
   public String CodigoAcueducto(String Acueducto, String Alcantarillado) {
      String CodAcueducto="";
      String CodAlcantarillado="";
      String idservicio = "";
      
        try{
            com.mysql.jdbc.PreparedStatement pstm = (com.mysql.jdbc.PreparedStatement) conm.getConnection().prepareStatement("SELECT idservicio,nombre   FROM servicio WHERE nombre = '"+Acueducto+"' AND CodServicio = 2");
            ResultSet res = null;
            res = (ResultSet) pstm.executeQuery();
            while(res.next()){
            CodAcueducto = res.getString("idservicio");
           
             }

            res.close();
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL CODIGO DEL INMUEBLE");
        }
        
          try{
            com.mysql.jdbc.PreparedStatement pstm = (com.mysql.jdbc.PreparedStatement) conm.getConnection().prepareStatement("SELECT idservicio,nombre   FROM servicio WHERE nombre = '"+Alcantarillado+"' AND CodServicio = 1");
            ResultSet res = null;
            res = (ResultSet) pstm.executeQuery();
            while(res.next()){
            CodAlcantarillado = res.getString("idservicio");
            
             }

            res.close();
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL CODIGO DEL INMUEBLE");
        }
          idservicio = CodAcueducto+"/"+CodAlcantarillado;
         return idservicio;   
        
        
    }  
   
   
    public Object [][] ConsultarInmuebleFactura(){

        int registros = 0;
        //obtenemos la cantidad de registros existentes en la tabla
        try{

      ResultSet res = null;
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement( "SELECT  count(*) as total from inmueble where estado='AC'");

            res = (ResultSet) pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }

        Object[][] datos = new String[registros][9];
        try{
               PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("SELECT " +
        "codigo_inmueble as codinm, " +
        "acueduto  as codacueducto, " +
        "alcantarillado  as codalcantarillado, " +
        "documento as documento " +
        "FROM " +
        "inmueble WHERE estado = 'AC' ");

            ResultSet res = null;
            res = (ResultSet) pstm.executeQuery();
            int i=0;
            while(res.next()){


            String Codinmueble = res.getString("codinm"); // Codigo inmueble 
            String codacueducto = res.getString("codacueducto"); // codigo acueducto
            String codalcantarillado = res.getString("codalcantarillado"); // codigo alcantarillado
               
                datos[i][0] = Codinmueble;
                datos[i][1] = codacueducto;
                datos[i][2] = codalcantarillado;
             

           i ++;
           

            }
          
            res.close();
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA");
        }

         return datos;


    }
}
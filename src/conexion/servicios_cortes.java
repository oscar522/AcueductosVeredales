/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
/**
 *
 * @author OSCARPC
 */
public class servicios_cortes {
    ConexionMysql conm = new ConexionMysql();
    public servicios_cortes() {
    }
    
    
public int ConsulMeses() {  // consulta cantidad de meses
    
    int meces_corte =0;
   try{
      String sql="SELECT reconexion FROM  fechas_facturacion";
      
      ResultSet res = null;
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(sql);

            res = (ResultSet) pstm.executeQuery();
            res.next();
            meces_corte = res.getInt("reconexion");
            res.close();
   
   }catch(SQLException e){
            System.out.println(e);
        }
   
    
  return meces_corte;
 }


     public void ConsultarNuevaReconexcion(String fecha_pago){
         
         
         
        int i=0;   
    try{    // RECORRE LOS CLIENTES
        PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("SELECT " +
        "count(f.codigo_inmueble) as numfac, " +
        "max(f.codigo_factura) as codfactu, " +
        "s.nombre as acueduto, " +
        "f.codigo_inmueble as codigo_inmueble " +
        "FROM deudor d " +
        "inner join factura f on f.codigo_factura  = d.codigo_factura " +
        "inner join inmueble i on i.codigo_inmueble = f.codigo_inmueble " +
        "inner join servicio s on s.idservicio = i.Acueduto  where d.estado = 'AC' " +
        "group by f.codigo_inmueble ");

         ResultSet res = null;
         res = (ResultSet) pstm.executeQuery();
         
         while(res.next()){
         i++;
         int numfac = res.getInt("numfac");
         String Codigo = res.getString("codigo_inmueble");
         String nombreacu = res.getString("acueduto");
         String codfactu = res.getString("codfactu");
       
         int mesesreco = ConsulMeses();
         
           System.out.println("///////////////////////////////////////////");
         System.out.println(numfac );
         System.out.println(Codigo );
         System.out.println(nombreacu );
         System.out.println(codfactu );
         System.out.println(mesesreco );
         
         System.out.println("///////////////////////////////////////////");
         
         if (numfac >= mesesreco){
           
            String Resultado =  ConsulRecon(Codigo);
            if (Resultado.equals("0")){
            InsertReconec( codfactu, fecha_pago, nombreacu);
            }
             
        }
         
        } 
        res.close();
        }catch(SQLException eU){
        System.out.println(eU);
             //JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL NUMERO DE DOCUMENTO");
        }
          //JOptionPane.showMessageDialog(new JDialog(), "INSERTAMOS RECONEXION"+i );  
          System.out.println(i);
             } 

     
  public String ConsulRecon (String codigo ){
     
    String codigorex = "0";
   
    int cantidad = 0;
    String sql = "SELECT " +
        "r.codigo_reconeccion as codigorex, " +
        "r.codigo_factura as codigo_factura, " +
        "r.Estado as Estado, " +
        "r.EstadoPago as pago,"+
        "r.Estadoservis as Estadoservis, " +
        "s.valor as valor " +
        "FROM " +
        "reconexion r, " +
        "factura f, " +
        "servicio s " +
        "WHERE " +
        "r.codigo_factura = f.codigo_factura " +
        "and r.valor = s.idservicio " +
        "and r.Estado not like 'FIN' " +
        "and f.codigo_inmueble ="+codigo ;
        //System.out.println(sql);
        try{
        PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(sql);
        
        ResultSet res = null;
        res = (ResultSet) pstm.executeQuery();
        while(res.next()){
        
        codigorex = res.getString("codigorex");
        
        cantidad++;
        
        }

        res.close();
        }catch(SQLException e){
        System.out.println(e);
        JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL NUMERO DE DOCUMENTO");
        }
         
     return codigorex;
     }
public void InsertReconec( String codigo_factura, String fecha_pago, String nombreacu){
         String id ="";
         int numrecon = 0;
         int numeroinser = 0;
       try{ PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("SELECT nombre, idservicio FROM servicio  WHERE nombre LIKE '%"+nombreacu+"%' AND  CodServicio = 4");
            
            ResultSet res = null;
            res = (ResultSet) pstm.executeQuery();
            while(res.next()){
                
                numrecon++;
            id = res.getString("idservicio");
            System.out.println("idservicio"+id);
            //JOptionPane.showMessageDialog(new JDialog(), "Numero serv RECONEXION"+id );  
             }
            res.close();
            }catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL NUMERO DE DOCUMENTO");
            }
            //JOptionPane.showMessageDialog(new JDialog(), "Numero serv RECONEXION"+numrecon );  
            //System.out.println("Numero serv RECONEXION"+numrecon);
       
            
            try { String q ="";// INSERTAR LA RECONEXCION DEPENDIENDO EL CASO
            
             //JOptionPane.showMessageDialog(new JDialog(), "INSERTAMOS RECONEXION"+codigo_factura );
             q = "INSERT INTO reconexion (codigo_factura, fecha_reconeccion, Estado, EstadoPago, valor ) VALUES ('"+codigo_factura+"','"+fecha_pago+"','INI','NO','"+id+"')";
            numeroinser++;
        
            PreparedStatement pstm1 = (PreparedStatement) conm.getConnection().prepareStatement(q);
            
            pstm1.execute();
            pstm1.close();
        

            } catch (SQLException eX) {
             System.out.println(eX);
             JOptionPane.showMessageDialog(new JDialog(), "Error al ingresar la nuevaaaa financiacion");
             }
            //JOptionPane.showMessageDialog(new JDialog(), "Numero serv RECONEXION"+numeroinser );  
            //System.out.println("Numero serv RECONEXION"+numeroinser);

     }

    public String CrearCobro(String codigo){
        
    String valorrecon = "0";
    String estado = "0";
    String reconexion ="0";
    String codigorex = "0";
    int Estadoservis =0;
    String pago ="0";
    String TotalAcueducto = "si";
    String Esta_ac_in= "Activo";
    String codigo_inmueble = "";
    String codigo_factura = "";
    int cantidad = 0;
   String sql = "SELECT " +
        "r.codigo_reconeccion as codigorex, " +
        "r.codigo_factura as codigo_factura, " +
        "r.Estado as Estado, " +
        "r.EstadoPago as pago," +
        "r.Estadoservis as Estadoservis, " +
        "r.codigo_factura as codigo_factura, " +
        "s.valor as valor, " +
        "f.codigo_inmueble as codigo_inmueble " +
        "FROM " +
        "reconexion r, " +
        "factura f, " +
        "servicio s " +
        "WHERE " +
        "r.codigo_factura = f.codigo_factura " +
        "and r.valor = s.idservicio " +
        "and f.codigo_inmueble ="+codigo;
   System.out.println(sql);
        try{
        PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(sql);
        
        ResultSet res = null;
        res = (ResultSet) pstm.executeQuery();
        while(res.next()){
        valorrecon = res.getString("valor");
        estado = res.getString("Estado");
        pago = res.getString("pago");
        codigorex = res.getString("codigorex");
        Estadoservis = res.getInt("Estadoservis");
        codigo_inmueble = res.getString("codigo_inmueble");
        codigo_factura = res.getString("codigo_factura");
        cantidad++;
        
    
        }

        res.close();
        }catch(SQLException e){
        System.out.println(e);
        JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL NUMERO DE DOCUMENTO");
        }
        
        if(estado.equals("COR") && pago.equals("NO") && Estadoservis == 1 ) { 
                System.out.println("entra COR NO 1");  
                ActualizaEstadoser(codigorex,"2");
                valorrecon = "0";
                TotalAcueducto = "no"; 
                Esta_ac_in = "Suspendido";
        } 
        if(estado.equals("INI") && pago.equals("NO") && Estadoservis == 1 ){
                valorrecon = "0";
                System.out.println("entra INI NO 1");  
                Esta_ac_in = "Activo";
        }
        if(estado.equals("COR") && pago.equals("NO") && Estadoservis == 2 ){
                System.out.println("entra COR NO 2");  
                
                Esta_ac_in = "Suspendido";
                //aqui va
                int num = Verifica_factura(codigo_inmueble, codigo_factura ) ;
                 if(num > 1){
                     System.out.println("entra mayor a 1");  
                 valorrecon = "0"; 
                 TotalAcueducto = "no"; 
                 }else{
                     valorrecon = "0";
                 System.out.println("entra menor a 1");}
                
        }
        if(estado.equals("COR") && pago.equals("SI") && Estadoservis == 3 ){
                System.out.println("entra COR SI 3");  
                valorrecon = "0";
                Esta_ac_in = "Suspendido";
        }
        if(estado.equals("REC") && pago.equals("SI") && Estadoservis == 3 ){
                System.out.println("entra REC SI 3"); 
                ActualizaEstadoser(codigorex,"4");
                Esta_ac_in = "Activo";
        }
         if(estado.equals("REC") && pago.equals("SI") && Estadoservis == 4 ){
                System.out.println("entra REC SI 4"); 
                valorrecon = "0";
                Esta_ac_in = "Activo";
        }
        reconexion = valorrecon+"/"+estado+"/"+codigorex+"/"+Estadoservis+"/"+pago+"/"+TotalAcueducto+"/"+Esta_ac_in; 
        System.out.println(reconexion);
        //System.out.println("datos vec reconecxion jjjjjj"+reconexion);
        
    return  reconexion;         
} 

    public  void ActualizaEstadoser(String Codigocor, String valor){
    
     try {// SI YA ESTA PAGA ACTUALIZAMOS EL ESTADO DE LA MISMA

        java.sql.PreparedStatement pstm = (java.sql.PreparedStatement) conm.getConnection().prepareStatement("UPDATE reconexion SET Estadoservis ='"+valor+"' WHERE codigo_reconeccion  ="+Codigocor);
        pstm.execute();
        pstm.close();

        //JOptionPane.showMessageDialog(new JDialog(), "Actualizacion correcta Financiacion estado");

       }catch(SQLException e){
       System.out.println(e);
       JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA ACTUALIZACION");
       }
    
 
    }
public int Verifica_factura(String codigo, String factura) {  // consulta cantidad de meses
    
    int numero = 0;
   try{
      String sql="SELECT COUNT(codigo_factura) as numero FROM factura WHERE codigo_inmueble ="+codigo+" AND codigo_factura > "+factura;
      
      ResultSet res = null;
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(sql);

            res = (ResultSet) pstm.executeQuery();
            res.next();
            numero = res.getInt("numero");
            res.close();
   
   }catch(SQLException e){
            System.out.println(e);
        }
   
    
  return numero;
 }

}
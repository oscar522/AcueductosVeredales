/*
 * To change this template, choose Tools | Templates
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
import modelo.PagoFinanciacion;

/**
 *
 * @author Paolita
 */
public class Servicio_pago {
    
    ConexionMysql conm;
    
     int numero_cuotas = 0;
      int cuotas_pagas = 0;
      

    public Servicio_pago() {
    
  
    conm = new ConexionMysql();
    }
    
    
     public String NumeroGestionFinanci(int numero2){
            String total = null;
       
             try{
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(
            "SELECT max(codigo_pago_financiacion+1)as total FROM pago_financiacion");
            ResultSet res = (ResultSet) pstm.executeQuery();
             while(res.next()){
             total = res.getString("total");
            
                 
                
            }
            res.close();
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA");
        }
             return total;
    }
    
     public String NumeroGestionFactura(){
            String totall = "";
            
             try{
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(
            "SELECT max(codigo_pago_factura+1)as total FROM pago_factura");
            ResultSet res = (ResultSet) pstm.executeQuery();
             while(res.next()){
             totall = res.getString("total");
              }
            res.close();
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA");
        }
         return totall;
    }
  
     
        public String NumeroGestionFinanciaciones(){
            String total = "";
             String numero = "";
       
             try{
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(
            "SELECT max(codigo_pago_financiacion+1)as total FROM pago_financiacion");
            ResultSet res = (ResultSet) pstm.executeQuery();
             while(res.next()){
             numero = res.getString("total");
 //            JOptionPane.showMessageDialog(new JDialog(), "total"+numero);
             
//            if ( numero.equals("null")){
//            total="1";
//            }
//            else{
//            total=numero;
//            }     
//                
            }
            res.close();
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA");
        }
             return numero;
    }
  
     
   public void insertarPagoFactura(String Codigofac, String Codigofinan, String Codigodeuda){
        
       String Deuda = VerificarDeuda(Codigofac);
//           if (Deuda.equals("1")){
                String q ="";
                insertarPagoFinanciacion(Codigofinan); 
                insertarPagoFinanciacion(Codigodeuda); 
                String otros = ActualizarDeuda(Codigofac);
                OtrosConceptos(otros);
                CancelarReconeccion(Codigofac);
                try {
                q = "INSERT INTO pago_factura (codigo_factura,codigo_pago_factura) VALUES ('"+Codigofac+"',null)";
        
                PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(q);
                //System.out.println(pstm);
                pstm.execute();
                pstm.close();
                JOptionPane.showMessageDialog(new JDialog(), "Pago satisfactorio");
                
              
             
             } catch (SQLException e) {
                  System.out.println(e);
           //  JOptionPane.showMessageDialog(new JDialog(), "");
             }
                
                try{
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(
            "SELECT `codigo_inmueble`  FROM `factura` WHERE `codigo_factura` = "+Codigofac);
            ResultSet res = (ResultSet) pstm.executeQuery();
            while(res.next()){
            String Inmu = res.getString("codigo_inmueble");
            //JOptionPane.showMessageDialog(new JDialog(), "Codigo Imueble"+Inmu);
             
                    try{
                    PreparedStatement pstma = (PreparedStatement) conm.getConnection().prepareStatement(
                    "SELECT r.codigo_reconeccion as codi FROM reconexion r , factura f WHERE r.codigo_factura = f.codigo_factura and r.Estado != 'REC' and f.codigo_inmueble ="+Inmu);
                    ResultSet resa = (ResultSet) pstma.executeQuery();
                    while(resa.next()){
                        
                    String codi = resa.getString("codi");
                   // JOptionPane.showMessageDialog(new JDialog(), "Codigo Reco"+codi);
                    
                    
                            try {
                            java.sql.PreparedStatement pstmb = (java.sql.PreparedStatement) conm.getConnection().prepareStatement("UPDATE reconexion SET EstadoPago = 'SI', Estadoservis = 3  WHERE  codigo_reconeccion="+codi );
                            pstmb.execute();
                            pstmb.close();
                            JOptionPane.showMessageDialog(new JDialog(), "RECONEXIÓN ACTUALIZADA");

                            }catch(SQLException e){
                            System.out.println(e);
                            JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA RECONEXIÓN");
                            }
                    
                    

                    }
                    resa.close();
                    }catch(SQLException e){
                    System.out.println(e);
                    JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA");
                    }
             
             
             
            }
            res.close();
            }catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA");
            }
//           }else{}
       
} 
   
   public  String VerificarDeuda(String Codigofac){
           String valor = "";
           String codigo_factura="";
           String fecha_pago = "";
           Date fechaActual = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
            String cadenaFecha = formato.format(fechaActual);
       
             try{
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(
            "SELECT iddeuda ,interes_mora, fecha_pago, estado, codigo_factura FROM deudor " +
            "WHERE estado = 'AC' and codigo_factura ="+Codigofac);
            ResultSet res = (ResultSet) pstm.executeQuery();
             while(res.next()){
             
             
             fecha_pago = res.getString("fecha_pago");
             
             codigo_factura = res.getString("codigo_factura");
                   
            }
            res.close();
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA");
        }
           if (codigo_factura.equals(Codigofac)){
            
            // JOptionPane.showMessageDialog(new JDialog(), "No es posible el pago Fecha pago: "+fecha_pago+" Fecha actual: "+cadenaFecha);
            valor="2";
            }else {
            valor="1";
           
           }
           
              return valor;
                
} 
   
    public  void insertarPagoFinanciacion(String Codigofinan){
            String estadofi ="no";
            String numero_cuota ="1";
            String cuotas_paga ="B";
            String valorcuotadeuda ="";
            String ivadeuda ="";
            String codigofide ="";
            int nuevacuotapaga = 0;
            
            double TotaDeuda = 0;  
             try{ // VERIFICAMOS EL VALOR DE LA CUOTA
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(
            "SELECT f.estado as estado, (f.valor_total / f.numero_cuotas) as valorcuota , f.numero_cuotas as numero_cuotas, f.cuotas_pagas as cuotas_pagas, s.valor as iva, f.codigo_financiacion as codigofi FROM inmueble i, financiacion f, servicio s WHERE f.inmueble = i.codigo_inmueble and s.idservicio = f.iva and  f.estado = 'AC' and f.codigo_financiacion ="+Codigofinan);
            
            ResultSet res = (ResultSet) pstm.executeQuery();
             while(res.next()){
                   
             valorcuotadeuda = res.getString("valorcuota");
             ivadeuda = res.getString("iva");
             codigofide = res.getString("codigofi");
             TotaDeuda = (Double.parseDouble(valorcuotadeuda) * (Double.parseDouble(ivadeuda)/100)) + Double.parseDouble(valorcuotadeuda);    
             estadofi = res.getString("estado");
             
             numero_cuota = res.getString("numero_cuotas");
             cuotas_paga = res.getString("cuotas_pagas");
                   
            }
            res.close();
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA");
        }
           
             if (estadofi.equals("no")){ // VERIFICAMOS SI HAY FINANCIACION
             // NO HAY FINANCIACION
             
             } else if (numero_cuota.equals(cuotas_paga)){ // VERIFICAMOS QUE LA FINANCIACION NO ESTE PAGA 
             JOptionPane.showMessageDialog(new JDialog(), "La financiacion YA se cancelo en su totalidad estado"+estadofi);
              try {// SI YA ESTA PAGA ACTUALIZAMOS EL ESTADO DE LA MISMA
             
              java.sql.PreparedStatement pstm = (java.sql.PreparedStatement) conm.getConnection().prepareStatement("UPDATE financiacion SET estado ='IN' WHERE codigo_financiacion  ="+Codigofinan);
              //System.out.println(pstm);
              pstm.execute();
              pstm.close();
              
              JOptionPane.showMessageDialog(new JDialog(), "Actualizacion correcta Financiacion ");

             }catch(SQLException e){
             System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA ACTUALIZACION");
             }
              
             } else { // SE INSERTA EN PAGO FINANCIACION LA NUEVA CUOTA
             
           try {
              String q = "INSERT INTO pago_financiacion (codigo_financiacion,valor, tipopago) VALUES ('"+Codigofinan+"',"+TotaDeuda+",'Factura')";
              PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(q);
              //System.out.println(pstm);
              pstm.execute();
              pstm.close();
              JOptionPane.showMessageDialog(new JDialog(), "Pago satisfactorio Financiacion");
              } catch (SQLException e) {
                  System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "Error al registrar el pago Financiacion");
              }
           
          try {// SE ACTUALIZA LA NUEVA CUOTA PAGA ES CUOTASPAGAS
              nuevacuotapaga = Integer.parseInt(cuotas_paga) + 1; 
              java.sql.PreparedStatement pstm = (java.sql.PreparedStatement) conm.getConnection().prepareStatement("UPDATE financiacion SET cuotas_pagas ="+nuevacuotapaga+ " WHERE codigo_financiacion  ="+Codigofinan);
              //System.out.println(pstm);
              pstm.execute();
              pstm.close();
              
              JOptionPane.showMessageDialog(new JDialog(), "Actualizacion correcta Financiacion cuota neuva");

             }catch(SQLException e){
             System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA ACTUALIZACION");
             }
                 
        }    
             int cuotapaga = Integer.parseInt(numero_cuota); //SE VERIFICA SI YA TERMINO LA FINANCIACION Y SE ACTUALIZA EL ESTADO
             if (numero_cuota.equals("A")){
             // NO HAY FINANCIACION           
             }else if (cuotapaga == nuevacuotapaga){
             JOptionPane.showMessageDialog(new JDialog(), "La financiacion  se cancelo en su totalidad estado"+estadofi);
              try {
             
              java.sql.PreparedStatement pstm = (java.sql.PreparedStatement) conm.getConnection().prepareStatement("UPDATE financiacion SET estado ='IN' WHERE codigo_financiacion  ="+Codigofinan);
             // System.out.println(pstm);
              pstm.execute();
              pstm.close();
              
              JOptionPane.showMessageDialog(new JDialog(), "Actualizacion correcta Financiacion estado");

             }catch(SQLException e){
             System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA ACTUALIZACION");
             }
              
             }
}  
   
   public  void CancelarReconeccion(String CodigoFact){
        
         String q ="SELECT codigo_recone FROM `factura` WHERE `codigo_factura` ="+CodigoFact;
       // System.out.print("Consulta Reconeccion Pago Factura"+q);
       try{
            PreparedStatement pstmcan = (PreparedStatement) conm.getConnection().prepareStatement(q);
            
            ResultSet res1 = (ResultSet) pstmcan.executeQuery();
             while(res1.next()){
                   
             String codigo_recone = res1.getString("codigo_recone");
             System.out.println("Codigo Reconexion:"+codigo_recone);
             try { // ACTUALIZAMOS DEUDA SI HAY
              
              java.sql.PreparedStatement pstm2 = (java.sql.PreparedStatement) conm.getConnection().prepareStatement("UPDATE reconexion SET EstadoPago = 'SI' WHERE  codigo_reconeccion ="+codigo_recone);
              System.out.println(pstm2);
              pstm2.execute();
              pstm2.close();
              
              //JOptionPane.showMessageDialog(new JDialog(), "Actualizacion correcta RECONEXION");

             }catch(SQLException eY){
             System.out.println(eY);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA ACTU RECONEXION");
             }
             
                   
            }
            res1.close();
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA");
        }
        
} 
   public  String ActualizarDeuda(String Codfactura){
        String codigo_inmueble ="";
        String otros_conceptos = "";
        try{ // CONSULTAMOS EL CODIGO INMUEBLE
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(
            "SELECT codigo_inmueble, otros_conceptos FROM `factura` WHERE `codigo_factura` ="+Codfactura);
            ResultSet res = (ResultSet) pstm.executeQuery();
             while(res.next()){
             
             codigo_inmueble = res.getString("codigo_inmueble");
             otros_conceptos = res.getString("otros_conceptos");
             
             try{ // CONSULTAMOS CODIGO FACTURA DEUDA
            PreparedStatement pstm1 = (PreparedStatement) conm.getConnection().prepareStatement(
            "SELECT F.codigo_factura AS codigo_factura , D.codigo_factura AS codigo_factura FROM factura F , deudor D WHERE D.estado = 'AC' AND D.codigo_factura = F.codigo_factura  AND F.codigo_inmueble ="+codigo_inmueble);
            ResultSet res1 = (ResultSet) pstm1.executeQuery();
             while(res1.next()){
             
             String codigo_factura = res1.getString("codigo_factura");
             
             
             try { // ACTUALIZAMOS DEUDA SI HAY
              
              java.sql.PreparedStatement pstm2 = (java.sql.PreparedStatement) conm.getConnection().prepareStatement("UPDATE deudor SET estado = 'IN' WHERE codigo_factura ="+codigo_factura);
              //System.out.println(pstm2);
              pstm2.execute();
              pstm2.close();
              
              //JOptionPane.showMessageDialog(new JDialog(), "Actualizacion correcta DEUDA");

             }catch(SQLException eY){
             System.out.println(eY);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA ACTUALIZACION DEUDA");
             }
             
                   
            }
            res1.close();
        }catch(SQLException ex){
            System.out.println(ex);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA DEUDA");
        }
             
            }
            res.close();
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA CODIGO INMUEBLE");
        }
       
    return otros_conceptos;
   }
 public  void OtrosConceptos(String otros_conceptos){
        
        
        try { // ACTUALIZAMOS DEUDA SI HAY
              
              java.sql.PreparedStatement pstm2 = (java.sql.PreparedStatement) conm.getConnection().prepareStatement("UPDATE otrosconceptos SET estado = 'IN' WHERE estado = 'AC' and id="+otros_conceptos);
             // System.out.println(pstm2);
              pstm2.execute();
              pstm2.close();
              
              //JOptionPane.showMessageDialog(new JDialog(), "Actualizacion correcta otros_conceptos");

             }catch(SQLException eY){
             System.out.println(eY);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA ACTUALIZACION DE OTROS CONCEPTOS");
             }
 }
 
 public  Object [][] Cuotapagafinanciacion(String CodigoFinan){
       
        
        Object[][] datos = new String[1][2];
                 
        try{
           String q = "select numero_cuotas, cuotas_pagas from financiacion where codigo_financiacion="+CodigoFinan;
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("select numero_cuotas, cuotas_pagas from financiacion where codigo_financiacion="+CodigoFinan);
          
             
           ResultSet res = null;
           res = (ResultSet) pstm.executeQuery();
             while(res.next()){
            
             String numero_cuota = res.getString("numero_cuotas");
             String cuotas_paga = res.getString("cuotas_pagas");
            
              numero_cuotas = Integer.parseInt(numero_cuota);
              cuotas_pagas = Integer.parseInt(cuotas_paga);
            
                datos[0][0] = numero_cuota;
                datos[0][1] = cuotas_paga; 
                
                                 
                if(Integer.parseInt(cuotas_paga) == Integer.parseInt(numero_cuota)){
                     
                       try {
                       PreparedStatement pstm2 = (PreparedStatement) conm.getConnection().prepareStatement("UPDATE financiacion SET estado = 'IN' WHERE  codigo_financiacion=" +CodigoFinan);
           
                       pstm2.execute();
                       pstm2.close();
                    //   JOptionPane.showMessageDialog(new JDialog(), "Pago satisfactorio de cuota");
                     }catch(SQLException e){
                        System.out.println(e);
                                             } 
                   // JOptionPane.showMessageDialog(new JDialog(), "La financiacion ya ha sido cancelada en su totalidad");
                }else{
                    
                    int nc=cuotas_pagas +1;
                   
                     try {
                       PreparedStatement pstm1 = (PreparedStatement) conm.getConnection().prepareStatement("UPDATE financiacion SET cuotas_pagas =  " + nc + " WHERE  codigo_financiacion=" +CodigoFinan);
           
                       pstm1.execute();
                       pstm1.close();
                       
                  //     JOptionPane.showMessageDialog(new JDialog(), "Pago satisfactorio de cuota");
                        
                      }catch(SQLException e){
                        System.out.println(e);
                        JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR EL PAGO");
                      }
                }
             }
             
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA");
        }
             
             
       
 
   return datos;
        
     }
 
   public  void insertarPagoFinanciacionGui(PagoFinanciacion pagofinanciacion){
        
         String q ="";
           
        if (cuotas_pagas < numero_cuotas  ){
            System.out.print("siiii" +numero_cuotas);
            
        try {
         q = "INSERT INTO pago_financiacion (codigo_financiacion, tipopago, valor) VALUES ('"+pagofinanciacion.getCodigo_financiacion()+"', 'Financiacion', "+pagofinanciacion.getValor()+")";
        System.out.println(q);
      PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(q);
              //System.out.println(pstm);
              pstm.execute();
              pstm.close();
              JOptionPane.showMessageDialog(new JDialog(), "Pago satisfactorio");
            
             } catch (SQLException e) {
                  System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "Error al registrar el pago");
        }
        }else{
         JOptionPane.showMessageDialog(new JDialog(), "La financiacion ya ha sido cancelada en su totalidad");
            
        }
}
   
   public String VerificarFacturaPaga(String Codigo) {  
    String resultado ="";
    String codigopago = "";
   try{
      String sql="SELECT codigo_factura as codigopago from pago_factura where codigo_factura ="+Codigo;
      //System.out.println(sql);
      ResultSet res = null;
       
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(sql);

            res = (ResultSet) pstm.executeQuery();
            res.next();
             codigopago = res.getString("codigopago");
       
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        
    if (codigopago.equals(Codigo) ){
    resultado = "1";
    }else {resultado = "2";}
  return resultado;
 }
 public String Factura_deuda(String Codigo) {  
    String resultado ="";
    String codigopago = "";
   try{
      String sql="SELECT f.codigo_factura as codigopago from factura f inner join deudor d on (f.codigo_factura = d.codigo_factura) where f.codigo_factura ="+Codigo;
      //System.out.println(sql);
      ResultSet res = null;
       
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(sql);

            res = (ResultSet) pstm.executeQuery();
            res.next();
             codigopago = res.getString("codigopago");
       
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        
    if (codigopago.equals(Codigo) ){
    resultado = "1";
    }else {resultado = "2";}
  return resultado;
 }
 
  public Object [][] DatosFactura( String Codigo){
            
        Object [][] datos = new String[1][10];
                
      
            
             try{
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(
            "SELECT " +
            "c.documento, " +
            "c.tipo_documento, " +
            "c.Nombre, " +

            "i.Direccion, " +
            "i.codigo_inmueble, " +

            "f.codigo_factura, " +
            "f.codigo_recone, " +
            "f.codigo_financiacion, " +
            "f.codigo_financiacion_deuda, " +
            "f.total_a_pagar " +

            "FROM cliente c " +
            "inner join inmueble i on (c.documento = i.documento) " +
            "inner join factura f on (i.codigo_inmueble = f.codigo_inmueble) " +

            "WHERE f.codigo_factura ="+Codigo);
            
            ResultSet res = (ResultSet) pstm.executeQuery();
            while(res.next()){
                 
            String documento = res.getString("documento");
            String tipo_documento = res.getString("tipo_documento");
            String Nombre = res.getString("Nombre");
                        
            String Direccion = res.getString("Direccion");
            String codigo_inmueble = res.getString("codigo_inmueble");
            
            String codigo_factura = res.getString("codigo_factura");
            String codigo_recone = res.getString("codigo_recone");
            String codigo_financiacion = res.getString("codigo_financiacion");
            String codigo_financiacion_deuda = res.getString("codigo_financiacion_deuda");
            String total_a_pagar = res.getString("total_a_pagar");
                 
                datos[0][0] = documento;
                datos[0][1] = tipo_documento;
                datos[0][2] = Nombre;
                datos[0][3] = Direccion;
                datos[0][4] = codigo_inmueble;
                datos[0][5] = codigo_factura;
                datos[0][6] = codigo_recone;
                datos[0][7] = codigo_financiacion;
                datos[0][8] = codigo_financiacion_deuda;
                datos[0][9] = total_a_pagar;
              }
            res.close();
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA");
        }
         return datos;
    }
}
   
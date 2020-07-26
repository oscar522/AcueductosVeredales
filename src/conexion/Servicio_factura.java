/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.Cliente;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Paolita
 */
public class Servicio_factura {
    
    ConexionMysql  conm = new ConexionMysql();
    Servicio_inmueble s = new Servicio_inmueble();
     Servicio_cierre ss = new Servicio_cierre();
     servicios_cortes cor = new servicios_cortes();
    public Servicio_factura() {
        // 
       
    }

    
    public String ConsultarDeuda(String codigo){
    String cadenatotal = "";
    String sql = "SELECT f.codigo_factura as codigo_factura, f.total_a_pagar as totalfa, s.valor as valoriva FROM  factura f, deudor de, servicio s  WHERE de.estado = 'AC' and f.codigo_factura=de.codigo_factura and s.idservicio = 5 and f.codigo_inmueble="+codigo+" ORDER BY f.codigo_factura desc limit 1";
    //System.out.println(sql);
            try{
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(sql);

            ResultSet res = null;
            res = (ResultSet) pstm.executeQuery();
            while(res.next()){

            int deuda = res.getInt("totalfa");
            double ivatotal = Double.parseDouble(res.getString("valoriva")) / 100 ;
            double total = (deuda * ivatotal) + deuda ;
            cadenatotal = String.valueOf(total); 
            //JOptionPane.showMessageDialog(new JDialog(), "Valor deuda" +cadenatotal);
            }
            res.close();
            }catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL NUMERO DE DOCUMENTO");
            }

    return cadenatotal;        
    }
     
  
 
    public String ConsultarFinanciacion(String codigo){
    double CadenaTota =0;
    String CadenaTotaFinanciacion ="0";
    double TotaFinanciacion = 0;
    double TotaDeuda = 0;
    String codigofi="0";
    String codigofide="0";
      
        try{
        PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("SELECT (f.valor_total / f.numero_cuotas) as valorcuota , f.numero_cuotas as numero_cuotas, f.cuotas_pagas as cuotas_pagas, s.valor as iva, f.codigo_financiacion as codigofi  FROM inmueble i, financiacion f, servicio s WHERE f.inmueble = i.codigo_inmueble and s.idservicio = f.iva and f.tipo = 'Instalacion' and  f.estado = 'AC' and f.inmueble ="+codigo);

        ResultSet res = null;
        res = (ResultSet) pstm.executeQuery();
        while(res.next()){ 
       
        String valorcuota = res.getString("valorcuota");
        String iva = res.getString("iva");
        codigofi = res.getString("codigofi");

        TotaFinanciacion = (Double.parseDouble(valorcuota) * (Double.parseDouble(iva)/100)) + Double.parseDouble(valorcuota);

        }
            res.close();
        }catch(SQLException e){
        System.out.println(e);
        JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL NUMERO DE DOCUMENTO");
        }
        
        
        String valorcuotadeuda = "";
        String ivadeuda = "";
      
          //deuda   
        
        
        try{
        PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("SELECT (f.valor_total / f.numero_cuotas) as valorcuota , f.numero_cuotas as numero_cuotas, f.cuotas_pagas as cuotas_pagas, s.valor as iva, f.codigo_financiacion as codigofi FROM inmueble i, financiacion f, servicio s WHERE f.inmueble = i.codigo_inmueble and s.idservicio = f.iva and f.tipo = 'Deuda' and  f.estado = 'AC' and f.inmueble ="+codigo);

        ResultSet res = null;
        res = (ResultSet) pstm.executeQuery();
        while(res.next()){ 
        
        valorcuotadeuda = res.getString("valorcuota");
        ivadeuda = res.getString("iva");
        codigofide = res.getString("codigofi");
        TotaDeuda = (Double.parseDouble(valorcuotadeuda) * (Double.parseDouble(ivadeuda)/100)) + Double.parseDouble(valorcuotadeuda);
        
                      
        }
        res.close();
        }catch(SQLException e){
        System.out.println(e);
        JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL NUMERO DE DOCUMENTO");
        }        
                CadenaTota = TotaFinanciacion + TotaDeuda;  
                CadenaTotaFinanciacion = String.valueOf(CadenaTota);
                if (codigofi.equals("")){
                codigofi="0";
                }else if (codigofide.equals("")){
                codigofide="0";
                 }
                
                String Total = CadenaTotaFinanciacion+"/"+codigofi+"/"+codigofide;
        return Total;   
        }
        
          /////////// metodo Consulta el valor del alcantarillado con el acueducto y el iva que corresponde a C/U
    private String  ValoarAcueducto(String codacueducto, String codalcantarillado, String Codinmueble) {
        int i = 0;
        String sql ="";
        
        
        String nombreacue ="";
        String valoracue ="";
        String nombrealcan ="";
        String valoralcan="";
        
        String nombreacueiva ="";
        String valoracueiva ="";
        String nombrealcaniva ="";
        String valoralcaniva ="";

        
        //// consulta los nombres de los servicios
        try{
        sql ="SELECT s.nombre as nombreacue,"
           + " s.valor as valoracue, "
           + "(SELECT s.nombre FROM servicio s,  inmueble i WHERE i.alcantarillado ="+codalcantarillado+"  and s.idservicio ="+codalcantarillado+" and i.codigo_inmueble ="+Codinmueble+") as nombrealcan,"
           + "(SELECT s.valor FROM servicio s,  inmueble i WHERE i.alcantarillado ="+codalcantarillado+"  and s.idservicio ="+codalcantarillado+" and i.codigo_inmueble ="+Codinmueble+")  as valoralcan"
           + " FROM servicio s, inmueble i WHERE s.idservicio ="+codacueducto+" and i.Acueduto = "+codacueducto+ " and i.codigo_inmueble ="+Codinmueble;

           
        PreparedStatement pstm1 = (PreparedStatement) conm.getConnection().prepareStatement(sql);
        ResultSet res1 = null;
         res1 = (ResultSet) pstm1.executeQuery();
         while(res1.next()){
         
         nombreacue = res1.getString("nombreacue");
         valoracue = res1.getString("valoracue"); 
         nombrealcan = res1.getString("nombrealcan");
         valoralcan = res1.getString("valoralcan");
        }

        res1.close();
        }catch(SQLException e1){
        System.out.println(e1);
        JOptionPane.showMessageDialog(new JDialog(), "ERROR acueducto y alcantarillado nombres");
        }
        // consulta el iva de los servcicios 
        try{
        sql ="SELECT " +
        "nombre as nombreacueiva, " +
        " valor as valoracueiva, " +
        "(SELECT nombre FROM servicio  WHERE nombre LIKE '%"+nombrealcan+"%' AND  CodServicio = 3) as nombrealcaniva, " +
        "(SELECT valor FROM servicio WHERE nombre LIKE '%"+nombrealcan+"%' AND  CodServicio = 3) as valoralcaniva " +
        "FROM " +
        "servicio " +
        "WHERE " +
        "nombre LIKE '%"+nombrealcan+"%' AND  CodServicio = 3";

         //  System.out.println(sql);
        PreparedStatement pstm1 = (PreparedStatement) conm.getConnection().prepareStatement(sql);
        ResultSet res1 = null;
        res1 = (ResultSet) pstm1.executeQuery();
        while(res1.next()){
        i++;
        nombreacueiva = res1.getString("nombreacueiva");
        valoracueiva = res1.getString("valoracueiva"); 
        nombrealcaniva = res1.getString("nombrealcaniva");
        valoralcaniva = res1.getString("valoralcaniva");
        //JOptionPane.showMessageDialog(new JDialog(), "datos "+nombreacueiva);
        
        
        
        }

        res1.close();
        }catch(SQLException e1){
        System.out.println(e1);
        JOptionPane.showMessageDialog(new JDialog(), "ERROR acueducto y alcantarillado  iva  ");
        } 
        if(i == 0){
        valoracueiva = "0";
        valoralcaniva="0";
        }
        double ivarealacue = 0.0;
        double ivarealaalca = 0.0;
        double TotalAcueducto = 0.0;
        double TotalAlcatarillado = 0.0;
        
         ivarealacue = (Double.parseDouble(valoracueiva)/100); 
       
         TotalAcueducto = Double.parseDouble(valoracue);
         TotalAlcatarillado = Double.parseDouble(valoralcan);
        
         Double suma_alca_acue = (Double.parseDouble(valoracue) + Double.parseDouble(valoralcan));
         Double Total_suma_alca_acue = (suma_alca_acue * ivarealacue ) + suma_alca_acue;
        
       
    
       String valores = +TotalAlcatarillado+"/"+TotalAcueducto+"/"+valoracueiva+"/"+valoralcaniva+"/"+Total_suma_alca_acue;
       return valores;
            
    }
       
    
    public String ConsultarOtrosConceptos(String codigo){
    String cadenatotal = "";
    String id = "";
    String valor = "";
    String estado ="";
    
            try{
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("SELECT "
            + "valor, estado, id "
            + "FROM  otrosconceptos where inmueble="+codigo);

            ResultSet res = null;
            res = (ResultSet) pstm.executeQuery();
            while(res.next()){

            valor = res.getString("valor");
            estado = res.getString("estado");
            id = res.getString("id");
            
            
            }
            res.close();
            }catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL NUMERO DE DOCUMENTO");
            }
            
            if (estado.equals("AC")){
            cadenatotal = valor+"/"+id;
            }
            else {
            valor =  "0";
            id = "0";
            cadenatotal = valor+"/"+id;
            }
            
            
    return cadenatotal;        
    }
    
    
    
    public void GenerarFacturacion(String perioIni, String periodoFin, String fePago, String Fesus, String nota){
      // consultamos el total de los inmuebles y los codigos de acueducto y alcantarillado
        int t=0;
        Object[][] datos;
        datos = s.ConsultarInmuebleFactura();
        int tamaño = datos.length-1;
        
        String totalAcueducto="";
        String ValorDeuda="";
        String TotalAlcantarillado = "";
        String TotalAcueducto = ""; 
        String TotalFinanciacion="";
        String ValorRecon = "";
        String ivaAcueducto = "";
        String ivaAlcantar = "";
        String Total_suma_alca_acue = "";
        int x =0;
        for (x=0;x<=tamaño;x=x+1){
           t++;
            String Codinmueble = (String.valueOf(datos[x][0])); // Codigo inmueble 
            String codacueducto = (String.valueOf(datos[x][1])); // codigo acueducto
            String codalcantarillado = (String.valueOf(datos[x][2])); // codigo alcantarillado
   
        totalAcueducto = ValoarAcueducto(codacueducto,codalcantarillado,Codinmueble);  
        String [] acuedutovalor = totalAcueducto.split("/");
        TotalAlcantarillado = acuedutovalor[0]; // valor del alcantarillado sin iva 
        TotalAcueducto = acuedutovalor[1]; // valor del acueducto sin iva 
        ivaAcueducto = acuedutovalor[2]; //iva del acueducto
        ivaAlcantar = acuedutovalor[3]; // iva alcantarillado
        Total_suma_alca_acue = acuedutovalor[4]; // total de la suma de los dos con el iva del acueducto
        
        if (ivaAlcantar.equals("null")){ivaAlcantar = "0";}
        

        
        //se consulta el valor de la deuda 
        ValorDeuda = ConsultarDeuda(Codinmueble); // total valor de la deuda mas iva 
        if (ValorDeuda.equals("")){
        
        ValorDeuda = "0";
        }


        TotalFinanciacion = ConsultarFinanciacion(Codinmueble);
        String [] Financiacion = TotalFinanciacion.split("/");
        String valorFinanciacion = Financiacion[0];
        String codigoFinanciacion = Financiacion[1];
        String codigoFinandeuda = Financiacion[2];

        ValorRecon = cor.CrearCobro(Codinmueble);
        String [] reconexion = ValorRecon.split("/");
        String valor = reconexion[0];
        
        String estado = reconexion[1];
        String codigorex = reconexion[2];
        String Estadoservis = reconexion[3];
        String pago = reconexion[4];
        
        String valor_acue_rec = reconexion[5];
        String Estado = reconexion[6];
        
        if(valor_acue_rec.equals("no")){
        TotalAcueducto = "0"; 
        Total_suma_alca_acue = "0";
        }
      
        
      
        String OtrosConceptos = ConsultarOtrosConceptos(Codinmueble);
        String [] Conceptos =  OtrosConceptos.split("/");
        String Conceptovalor = Conceptos[0];
        String Conceptoid = Conceptos[1];

        float total = Float.parseFloat(Total_suma_alca_acue) + Float.parseFloat(valor)+
                      Float.parseFloat(ValorDeuda)+ Float.parseFloat(valorFinanciacion)+Float.parseFloat(Conceptovalor);
        

        InsertarFactura(perioIni, periodoFin, fePago, Fesus, Codinmueble, TotalAcueducto, TotalAlcantarillado, valor, ivaAcueducto , ivaAlcantar, ValorDeuda, codigoFinanciacion, codigoFinandeuda, total, Conceptoid , nota, codigorex, Estado);


        
        
       
}
    generarreporte(fePago,t);
    }
    public void generarreporte(String fePago, int t ){
     //GENERAR REPORTE
            
        Connection micone = conm.getConnection();
       try{
           String reporte = System.getProperty("user.dir")+"/src/Reportes/report2pru.jasper"; // direccion del reporte 
           
           JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reporte);
          
           Map parametro = new HashMap();
           parametro.put("inicial", fePago);
           
           JasperPrint  print = JasperFillManager.fillReport(jasperReport, parametro, micone);
           
           JasperViewer view = new JasperViewer (print,false);
           view.setVisible(true);
           
       } catch (Exception f){
       
       JOptionPane.showMessageDialog(new JDialog(), "ERROR al General informes "+f);
       
       }
       JOptionPane.showMessageDialog(new JDialog(), "SE GENERO LA FACTURA DE FORMA CORRECTA, N° DE FACTURAS "+t); 
    
    
    }

    private void InsertarFactura(String perioIni, String periodoFin, String fePago, String Fesus, String Codinmueble, String TotalAcueducto, String TotalAlcantarillado, String ValorRecon, String ivaAcueducto , String ivaAlcantar, String ValorDeuda, String codigoFinanciacion, String codigoFinandeuda, Float total, String otros_conceptos, String nota, String codigo_recone, String Estado) {
       
        String q ="";
        
        try {
        q = "INSERT INTO  factura (`periodo_facturacion_inicial`, `periodo_facturacion_final`, `fecha_de_pago`, `fecha_suspencion`, `codigo_inmueble`, `acueducto`, `alcantarillado`, `reconexion`, `iva_acueducto`, `Iva_alcantarillado`, `deuda_factura`, `total_a_pagar`, `codigo_financiacion`, `codigo_financiacion_deuda`, otros_conceptos, nota, codigo_recone,estado) VALUES   (  '"+perioIni+"',  '"+periodoFin+"',  '"+fePago+"',  '"+Fesus+"',  '"+Codinmueble+"',  '"+TotalAcueducto+"', '"+TotalAlcantarillado+"' , '"+ValorRecon+"' , '"+ivaAcueducto+"' , '"+ivaAlcantar+"' , '"+ValorDeuda+"' , '"+total+"' , '"+codigoFinanciacion+"' , '"+codigoFinandeuda+"',"+otros_conceptos+", '"+nota+"',"+codigo_recone+",'"+Estado+"')";                                
       // System.out.println(q);         
        PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(q);
       // System.out.println(pstm);
        pstm.execute();
        pstm.close();
              //JOptionPane.showMessageDialog(new JDialog(), "INGRESO DE CLIENTE CORRECTO EN LA BASE DE DATOS");
        }catch(SQLException e){
        System.out.println(e);
        JOptionPane.showMessageDialog(new JDialog(), "ERROR acueducto y alcantarillado  iva  ");
        } 
        
    }
    
    
    public String compararFechasConDate(String inicio, String fin, String corte, String pago) {  
//  System.out.println("Parametro String Fecha 1 = "+fecha1+"\n" +
//    "Parametro String fechaActual = "+fechaActual+"\n");  
   String resultado="";
   try {
   /**Obtenemos las fechas enviadas en el formato a comparar*/
   SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy"); 
   Date inicio1 = formateador.parse(inicio);
   Date fin1 = formateador.parse(fin);
   Date corte1 = formateador.parse(corte);
   Date pago1 = formateador.parse(pago);

    if (inicio.equals(fin)){
    resultado= "La fecha de INICIO no puede ser igual a la fecha de FIN ";
     JOptionPane.showMessageDialog(new JDialog(), resultado);
    }else if (fin1.before(inicio1)  ){
    resultado= "La Fecha FIN del periodo facturado no puede ser menor a la Fecha de INICIO ";
     JOptionPane.showMessageDialog(new JDialog(), resultado);
    }else if (pago1.before(inicio1)){
    resultado= "Las Fecha de PAGO no puede ser anterior a la Fecha de INICIO";
    JOptionPane.showMessageDialog(new JDialog(), resultado);
   }
 //    else if (pago1.before(fin1)){
//    resultado= "Las Fecha de PAGO no puede ser anterior a la Fecha Final del periodo";
//    JOptionPane.showMessageDialog(new JDialog(), resultado);
//    }
    else if (corte1.before(inicio1)){
    resultado= "Las Fecha de SUSPENCIÓN no puede ser anterior a la Fecha de INICIO";
     JOptionPane.showMessageDialog(new JDialog(), resultado);
    //}else if(fin1.before(corte1)){//////
    //resultado= "Las Fecha de SUSPENCIÓN no puede ser anterior a la Fecha de FIN";
     //JOptionPane.showMessageDialog(new JDialog(), resultado);
    }else if(corte1.before(pago1)){
    resultado= "Las Fecha de SUSPENCIÓN no puede ser anterior a la Fecha de PAGO";
     JOptionPane.showMessageDialog(new JDialog(), resultado);
    }else if(pago.equals(corte)){
    resultado= "Las Fecha de PAGO no puede ser igual a la Fecha de SUSPENCIÓN";
     JOptionPane.showMessageDialog(new JDialog(), resultado);
    }else if(pago.equals(fin)){
    resultado= "Las Fecha de PAGO no puede ser igual a la Fecha de FIN";
     JOptionPane.showMessageDialog(new JDialog(), resultado);
    }else if(pago.equals(inicio)){
    resultado= "Las Fecha de PAGO no puede ser igual a la Fecha de INICIO";
     JOptionPane.showMessageDialog(new JDialog(), resultado);
    }else if(inicio.equals(corte)){
    resultado= "Las Fecha de INICIO no puede ser igual a la fecha de SUSPENCIÓN";
     JOptionPane.showMessageDialog(new JDialog(), resultado);
    }else if(fin.equals(corte)){
    resultado= "Las Fecha de FIN no puede ser igual a la Fecha de SUSPENCIÓN";
     JOptionPane.showMessageDialog(new JDialog(), resultado);
    }else {  resultado= "";
    }
  } catch (Exception e) {
   System.out.println("Se Produjo un Error!!!  "+e.getMessage());
  }  
  return resultado;
 }
          public String VerificarPeriodo(String inicio, String fin, String corte, String pago) {  
    String resultado ="";
   try{
      String sql="SELECT periodo_facturacion_inicial as inicial, periodo_facturacion_final as final, fecha_de_pago as pago, fecha_suspencion as corte  from factura where periodo_facturacion_inicial='"+inicio+"' and periodo_facturacion_final='"+fin+"' and fecha_de_pago='"+pago+"' and fecha_suspencion='"+corte+"'";
      
      ResultSet res1 = null;
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(sql);

            res1 = (ResultSet) pstm.executeQuery();
            res1.next();
            String inicial = res1.getString("inicial");
            String final1 = res1.getString("final");
            String pago1 = res1.getString("pago");
            String corte1 = res1.getString("corte");
            if (inicial.equals(inicio) || final1.equals(fin) || pago1.equals(pago) || corte1.equals(corte) ){
                resultado = "1";
            }else {resultado = "2";}
            res1.close();
        }catch(SQLException e){
            System.out.println(e);
        }
  return resultado;
 }
 public Object [][] ConsultarFinanciacionesGenerales(){

        int registros = 0;
        //obtenemos la cantidad de registros existentes en la tabla
        try{

      ResultSet res = null;
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement( "SELECT  count(*) as total from cliente c, inmueble i, financiacion f where (c.documento = i.documento) and (i.codigo_inmueble = f.inmueble) and (estado='ac')");

            res = (ResultSet) pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }

        Object[][] datos = new String[registros][8];
        try{
               PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("select c.Nombre, c.documento, i.codigo_inmueble, i.direccion, "
                       + "f.codigo_financiacion, f.valor_total, f.numero_cuotas, f.cuotas_pagas from cliente c, inmueble i, financiacion f where (c.documento = i.documento)"
                       + " and (i.codigo_inmueble = f.inmueble) and (estado='ac')");

             ResultSet res = null;
           res = (ResultSet) pstm.executeQuery();
           int i=0;
           while(res.next()){


            String nombre = res.getString("Nombre");
            String documento = res.getString("documento");
            String inmueble = res.getString("codigo_inmueble");
            String direccion = res.getString("direccion");
            String financiacion = res.getString("codigo_financiacion");
            String total = res.getString("valor_total");
            String cuotas = res.getString("numero_cuotas");
            String pagas = res.getString("cuotas_pagas");

                datos[i][0] = nombre;
                datos[i][1] = documento;
                datos[i][2] = inmueble;
                datos[i][3] = direccion;
                datos[i][4] = financiacion;
                datos[i][5] = total;
                datos[i][6] = cuotas;
                datos[i][7] = pagas;


           i ++;

            }

            res.close();
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA");
        }

         return datos;


    }
 
 
 public Object [][] ConsultarFacturas(String Codigo){

        int registros = 0;
        //obtenemos la cantidad de registros existentes en la tabla
        try{

      ResultSet res = null;
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement( "SELECT  count(*) as total from factura where codigo_inmueble="+Codigo);

            res = (ResultSet) pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }

        Object[][] datos = new String[registros][8];
        try{
               PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("SELECT  codigo_factura, periodo_facturacion_inicial, periodo_facturacion_final, fecha_de_pago, fecha_suspencion, total_a_pagar from factura where codigo_inmueble="+Codigo);

             ResultSet res = null;
           res = (ResultSet) pstm.executeQuery();
           int i=0;
           while(res.next()){


            String codigo_factura = res.getString("codigo_factura");
            String inicial = res.getString("periodo_facturacion_inicial");
            String pefinal = res.getString("periodo_facturacion_final");
            String pago = res.getString("fecha_de_pago");
            String suspencion = res.getString("fecha_suspencion");
            String total = res.getString("total_a_pagar");
           

                datos[i][0] = codigo_factura;
                datos[i][1] = inicial;
                datos[i][2] = pefinal;
                datos[i][3] = pago;
                datos[i][4] = suspencion;
                datos[i][5] = total;
                i ++;

            }

            res.close();
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA");
        }

         return datos;


    }
 
 public void DuplicadoFac(String CodFact)
 {
 Connection micone = conm.getConnection();
       try{
           String reporte = System.getProperty("user.dir")+"/src/Reportes/DuplicadoFactura.jasper"; // direccion del reporte 
           
           JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reporte);
          
           Map parametro = new HashMap();
           parametro.put("inicial", CodFact);
           
           JasperPrint  print = JasperFillManager.fillReport(jasperReport, parametro, micone);
           
           JasperViewer view = new JasperViewer (print,false);
           view.setVisible(true);
           
       } catch (Exception f){
       
       JOptionPane.showMessageDialog(new JDialog(), "ERROR al General informes "+f);
       
       }
  }

  public Object [][] ConsultarFacturasModficar(String Codigo){

         Object[][] datos = new String[1][10];
        try{
            String q = "SELECT " +
        " C.Nombre AS Nombre , " +
        " I.Direccion AS Direccion, " +
        " F.periodo_facturacion_inicial AS periodo_facturacion_inicial, " +
        " F.periodo_facturacion_final AS periodo_facturacion_final, " +
        " F.fecha_de_pago AS fecha_de_pago, " +
        " F.fecha_suspencion AS fecha_suspencion, " +
        " F.codigo_inmueble AS codigo_inmueble1, " +
        " F.deuda_factura AS deuda_factura, " +
        " F.acueducto AS acueducto, " +
        " F.total_a_pagar AS total_a_pagar " +
        " FROM cliente C INNER JOIN  inmueble I ON (C.documento = I.documento) " +
        " INNER JOIN factura F ON (F.codigo_inmueble = I.codigo_inmueble) WHERE F.codigo_factura = "+Codigo+""; 
            
            java.sql.PreparedStatement pstm = (java.sql.PreparedStatement) conm.getConnection().prepareStatement(q);
            System.out.println(q);
             ResultSet res = null;
             res = (ResultSet) pstm.executeQuery();
             while(res.next()){

            //String documento = res.getString("documento");
            String Nombre                       = res.getString("Nombre");
            String Direccion                    = res.getString("Direccion");
            String periodo_facturacion_inicial  = res.getString("periodo_facturacion_inicial");
            String periodo_facturacion_final    = res.getString("periodo_facturacion_final");
            String fecha_de_pago                = res.getString("fecha_de_pago");
            String fecha_suspencion             = res.getString("fecha_suspencion");
            String codigo_inmueble              = res.getString("codigo_inmueble1");
            String deuda_factura                = res.getString("deuda_factura");
            String acueducto                    = res.getString("acueducto");
            String total_a_pagar                = res.getString("total_a_pagar");
            
            

                datos[0][0] = Nombre;
                datos[0][1] = Direccion;
                datos[0][2] = periodo_facturacion_inicial;
                datos[0][3] = periodo_facturacion_final;
                datos[0][4] = fecha_de_pago;
                datos[0][5] = fecha_suspencion;
                datos[0][6] = codigo_inmueble;
                datos[0][7] = deuda_factura;
                datos[0][8] = acueducto;
                datos[0][9] = total_a_pagar;
            
                

            }

            res.close();
        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL NUMERO DE DOCUMENTO");
        }

         return datos;


    }
 
   public void ModificarFactura(String Cod_factu, int valordeuda, int Valoracued, int valorTotal){
         try {
            java.sql.PreparedStatement pstm = (java.sql.PreparedStatement) conm.getConnection().prepareStatement("UPDATE factura SET "
                    + "acueducto =  '" + Valoracued+
                    "', deuda_factura = '" + valordeuda+"' , total_a_pagar = '" + valorTotal + "' WHERE codigo_factura  ="  + Cod_factu);
              //System.out.println(pstm);
              pstm.execute();
              pstm.close();
              
              JOptionPane.showMessageDialog(new JDialog(), "Actualizacion correcta");

        }catch(SQLException e){
            System.out.println(e);
             JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA ACTUALIZACION");
        }

  }
             
  
}                    
  
       

    
          




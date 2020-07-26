/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conexion;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PaolaAlfonso
 */
public class Servicio_CDE {
    ConexionMysql conm;
 
   public Servicio_CDE (){
        conm = new ConexionMysql();
}
       public Object [][] consultarFacturasGeneradas(String fecha_inicial, String fecha_final){
            
            Object [][] datos = new String[1][1];

            try{
            ResultSet res = null;
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement( "select count(f.codigo_factura)as numero_facturas from factura f where f.periodo_facturacion_inicial = '" +fecha_inicial+"'");

            res = (ResultSet) pstm.executeQuery();
       
             while(res.next()){
               String facturas=res.getString("numero_facturas");
              
               datos[0][0]=facturas;
                             
           }
             res.close();
            
            } catch (SQLException e) {
                
               }
               return datos;
        }
         
        public Object [][] consultarValorTotalFacturas(String fecha_inicial){
            
            Object [][] valor_facturas = new String[1][1];
            try{
            ResultSet res = null;
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement( "select sum(f.total_a_pagar)as valor from factura f where f.periodo_facturacion_inicial = '" +fecha_inicial+"'");
            res = (ResultSet) pstm.executeQuery();
       
            while(res.next()){ 
               String valor=res.getString("valor");
              
               valor_facturas[0][0]=valor;
                             
           }
            res.close();
            
            } catch (SQLException e) {
                
               }
               return valor_facturas;
        }
        
        public Object [][] consultarFacturasPagas(String fecha_inicial){

            Object [][] facturas_pagas = new String[1][1];

            try{
            ResultSet res = null;
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement( "SELECT COUNT( codigo_pago_factura ) AS pagas\n" +
            "FROM factura f, pago_factura p\n" +
            "WHERE (\n" +
            "p.codigo_factura = f.codigo_factura\n" +
            ")\n" +
            "AND f.periodo_facturacion_inicial = '" +fecha_inicial+"'");

            res = (ResultSet) pstm.executeQuery();

             while(res.next()){
               String facturas=res.getString("pagas");

               facturas_pagas[0][0]=facturas;

           }
             res.close();

            } catch (SQLException e) {

               }
               return facturas_pagas;
        }

        public Object [][] consultarFacturasPagasMesAnterior(String fecha_inicial,String fecha_2, String fecha_3){

            Object [][] facturas_pagas = new String[1][1];

            try{
            ResultSet res = null;
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement( "SELECT COUNT( codigo_pago_factura ) AS pagas\n" +
            "FROM factura f, pago_factura p\n" +
            "WHERE (\n" +
            "p.codigo_factura = f.codigo_factura\n" +
            ")\n" +
            "AND f.periodo_facturacion_inicial = '" +fecha_inicial+"' and DATE(p.fecha_pago_pago) BETWEEN '"+fecha_2+"' AND '"+fecha_3+"'");

            res = (ResultSet) pstm.executeQuery();

             while(res.next()){
               String facturas=res.getString("pagas");

               facturas_pagas[0][0]=facturas;

           }
             res.close();

            } catch (SQLException e) {

               }
               return facturas_pagas;
        }

  public Object [][] consultarValorTotalFacturasMesAnterior(String fecha_inicial, String fecha_2, String fecha_3){
            
            Object [][] valor_facturas = new String[1][1];
            try{
            ResultSet res = null;
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement( "select sum(f.total_a_pagar)as valor FROM factura f, pago_factura p WHERE (p.codigo_factura = f.codigo_factura) AND f.periodo_facturacion_inicial = '" +fecha_inicial+"' and DATE(p.fecha_pago_pago) BETWEEN '"+fecha_2+"' AND '"+fecha_3+"'");


            res = (ResultSet) pstm.executeQuery();
       
            while(res.next()){ 
               String valor=res.getString("valor");
              
               valor_facturas[0][0]=valor;
                             
           }
            res.close();
            
            } catch (SQLException e) {
                
               }
               return valor_facturas;
        }
        
        public Object [][] consultarValorTotalFacturasPagas(String fecha_inicial){

            Object [][] valor_pagas = new String[1][1];
            try{
            ResultSet res = null;
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement( "select sum(f.total_a_pagar) as valor from factura f, pago_factura p where (p.codigo_factura = f.codigo_factura) and f.periodo_facturacion_inicial = '" +fecha_inicial+"'");
            res = (ResultSet) pstm.executeQuery();

            while(res.next()){
               String valor=res.getString("valor");

               valor_pagas[0][0]=valor;

           }
            res.close();

            } catch (SQLException e) {

               }
               return valor_pagas;
        }

        public Object [][] consultarFacturasNoPagas(String fecha_inicial){

            Object [][] facturas_no_pagas = new String[1][1];

            try{
            ResultSet res = null;
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement( "SELECT COUNT( d.iddeuda ) AS deuda\n" +
            "FROM deudor d, factura f\n" +
            "WHERE (\n" +
            "d.codigo_factura = f.codigo_factura\n" +
            ")\n" +
            "AND f.periodo_facturacion_inicial = '" + fecha_inicial+"'");

            res = (ResultSet) pstm.executeQuery();

             while(res.next()){
               String facturas=res.getString("deuda");

               facturas_no_pagas[0][0]=facturas;

           }
             res.close();

            } catch (SQLException e) {

               }
               return facturas_no_pagas;
        }

                 
            
 public Object [][] consultarValorTotalFacturasNoPagas(String fecha_final){

            Object [][] valor_no_pagas = new String[1][1];
            try{
            ResultSet res = null;
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement( "SELECT SUM( f.total_a_pagar ) AS valor\n" +
            "FROM factura f, deudor d\n" +
            "WHERE (\n" +
            "d.codigo_factura = f.codigo_factura\n" +
            ")\n" +
            "AND f.periodo_facturacion_inicial = '"+fecha_final+"'");
            res = (ResultSet) pstm.executeQuery();

            while(res.next()){
               String valor=res.getString("valor");

               valor_no_pagas[0][0]=valor;

           }
            res.close();

            } catch (SQLException e) {

               }
               return valor_no_pagas;
        }    

 public Object [][] consultarValorAbonos(String fecha_inicial, String fecha_final){

            Object [][] valor_abonos = new String[1][1];
            try{
            ResultSet res = null;
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement( "SELECT SUM( f.abono ) AS valor  "
                    + "FROM financiacion f "
                    + "WHERE  DATE(f.fecha) BETWEEN '"+fecha_inicial+"' AND '"+fecha_final+"'");
            System.out.print(pstm);
            res = (ResultSet) pstm.executeQuery();

            while(res.next()){
               String valor=res.getString("valor");

               valor_abonos[0][0]=valor;

           }
            res.close();

            } catch (SQLException e) {

               }
               return valor_abonos;
        }
 
 public Object [][] consultarValorFinanciaciones(String fecha_inicial, String fecha_final){

     System.out.print(fecha_inicial);
            Object [][] valor_pagos_financiacion = new String[1][1];
            try{
            ResultSet res = null;
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement( "SELECT "
           + "SUM( p.valor ) AS valor " +
            "FROM pago_financiacion p " +
            "WHERE (p.tipopago =  'Financiacion') and " +
            "DATE(p.fecha_pago) BETWEEN '"+fecha_inicial+"' AND '"+fecha_final+"'");
            
            res = (ResultSet) pstm.executeQuery();

            while(res.next()){
               String valor=res.getString("valor");

              valor_pagos_financiacion[0][0]=valor;

           }
            res.close();

            } catch (SQLException e) {

               }
               return valor_pagos_financiacion;
        }
 
 
}

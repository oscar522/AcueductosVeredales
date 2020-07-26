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
public class Servicio_dinero_diario {
    ConexionMysql conm;
    
    public Servicio_dinero_diario (){
        conm = new ConexionMysql();
}
    
    public Object [][] consultarFacturasPagasDiarias(String fecha_diaria){

            Object [][] facturas_pagas = new String[1][1];

            try{
            ResultSet res = null;
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement( "SELECT COUNT( p.codigo_pago_factura ) AS pagas\n" +
            "FROM pago_factura p\n" +
            "WHERE DATE( p.fecha_pago_pago ) = ('"+fecha_diaria+"')");

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
    
    public Object [][] consultarValorTotalFacturasPagasdiaria(String fecha_diaria){

            Object [][] valor_pagas = new String[1][1];
            try{
            ResultSet res = null;
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement( "SELECT SUM( f.total_a_pagar ) AS valor\n" +
            "FROM factura f, pago_factura p\n" +
            "WHERE (\n" +
            "p.codigo_factura = f.codigo_factura\n" +
            ")\n" +
            "AND DATE( p.fecha_pago_pago ) = ('"+fecha_diaria+"')");
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

    public Object [][] consultarValorFinanciaciones(String fecha_diaria){

            Object [][] valor_pagos_financiacion = new String[1][1];
            try{
            ResultSet res = null;
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement( "SELECT SUM( p.valor ) AS valor\n" +
            "FROM pago_financiacion p\n" +
            "WHERE (\n" +
            "p.tipopago =  'financiacion'\n" +
            ")\n" +
            "AND UNIX_TIMESTAMP( p.fecha_pago ) > UNIX_TIMESTAMP('"+fecha_diaria+"')");
            
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

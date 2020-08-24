/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Paolita
 */
public class Servicio_cierre {
    ConexionMysql conm = new ConexionMysql();
    servicios_cortes cor = new servicios_cortes(); 
    
    public Servicio_cierre (){
    }
   
    public void ConsultarNuevosDeudores(String fecha_de_corte){
        try{
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(
                    "SELECT "
                            + "f.otros_conceptos as otros_conceptos, "
                            + "f.codigo_financiacion_deuda as codigo_financiacion_deuda, "
                            + "f.codigo_financiacion as codigo_financiacion, "
                            + "f.codigo_factura as codigo_factura, "
                            + "f.fecha_de_pago as fecha_de_pago  "
                    + "FROM factura f  "
                    + "WHERE f.codigo_factura NOT IN(SELECT p.codigo_factura FROM pago_factura p) "
                    + "and f.codigo_factura NOT IN(SELECT p.codigo_factura FROM deudor p Where  p.tipo = 'financia')  "
                    + "and f.fecha_suspencion='"+fecha_de_corte+"'");
                
            ResultSet res = null;
            res = (ResultSet) pstm.executeQuery();
            int i=0;
            while(res.next()){
                i++;
                String codigo = res.getString("codigo_factura");
                String fecha = res.getString("fecha_de_pago");
                String codigo_financiacion = res.getString("codigo_financiacion");
                String codigo_financiacion_deuda = res.getString("codigo_financiacion_deuda");
                String otros_conceptos = res.getString("otros_conceptos");

                String q ="";
                if (codigo_financiacion.equals("") || codigo_financiacion_deuda.equals("") ){}else{
                  insertarPagoFinanciacion(codigo_financiacion);
                  insertarPagoFinanciacion(codigo_financiacion_deuda);
                }
                try {
                    q = "INSERT INTO deudor (interes_mora, codigo_factura,fecha_pago, estado, tipo) VALUES ('1','"+codigo+"','"+fecha+"','AC', 'cierre')";
                    PreparedStatement pstm1 = (PreparedStatement) conm.getConnection().prepareStatement(q);
                    pstm1.execute();
                    pstm1.close();
                } catch (SQLException e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(new JDialog(), "Error al insertar deuda");
                }
              
                OtrosConceptos(otros_conceptos); 
            }
            res.close();
        }catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL NUMERO DE DOCUMENTO");
        }
        JOptionPane.showMessageDialog(new JDialog(), "SE A REALIZADO EN CIERRE, LAS FACTURAS NO PAGAS AHORA ESTAN EN DEUDA");
        cor.ConsultarNuevaReconexcion(fecha_de_corte);
    } 

    public String ConsultarFactura(String fecha_suspencion){
        int i=0;
        String valor = "";
        try{
            PreparedStatement pstm = (PreparedStatement) 
                    conm.getConnection()
                    .prepareStatement("SELECT  "
                            + "f.codigo_factura as codigo_factura, "
                            + "f.fecha_de_pago as fecha_de_pago  "
                            + "FROM factura f  "
                            + "WHERE f.fecha_suspencion='"+fecha_suspencion+"'");
            ResultSet res = null;
            res = (ResultSet) pstm.executeQuery();
            i=0;
            while(res.next()){
                i++;
                String codigo = res.getString("codigo_factura");
                String fecha = res.getString("fecha_de_pago");
            }
            res.close();
        }catch(SQLException eY){
            System.out.println(eY);
            JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL NUMERO DE DOCUMENTO");
        }
        if(i == 0){valor = "1";}else{valor = "0";}
        return valor;
    }
    
    public void GenerarReporte(String nombre, String parametros) {
        Connection micone = conm.getConnection();
        String[] ini = parametros.split("/");
        String Dia1, Mes1, Ano1;
        Dia1 = "";
        Mes1 = "";
        Ano1 = "";
        Dia1 = ini[0];
        Mes1 = ini[1];
        Ano1 = ini[2];

        String Fecha_corte1 = "20" + Ano1 + "/" + Mes1 + "/" + Dia1;

        try {
            String reporte = System.getProperty("user.dir") + "/src/ReportesFacturaCierre/" + nombre + ".jasper"; // direccion del reporte 

            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reporte);

            Map parametro = new HashMap();

            parametro.put("fechaSuspen", Fecha_corte1);
            //parametro.put("fechaSuspen", Fecha_corte1);

            JasperPrint print = JasperFillManager.fillReport(jasperReport, parametro, micone);

            JasperViewer view = new JasperViewer(print, false);
            view.setVisible(true);

        } catch (Exception f) {

            JOptionPane.showMessageDialog(new JDialog(), "ERROR al General informes " + f);

        }

    }

    public void GenerarReporteEspecial(String nombre, String parametros) {
        Connection micone = conm.getConnection();
        String[] ini = parametros.split("/");
        String Dia1, Mes1, Ano1;
        Dia1 = "";
        Mes1 = "";
        Ano1 = "";
        Dia1 = ini[0];
        Mes1 = ini[1];
        Ano1 = ini[2];

        String Fecha_corte1 = "20" + Ano1 + "/" + Mes1 + "/" + 1;
        String Fecha_corte2 = "20" + Ano1 + "/" + Mes1 + "/" + 30;

        try {
            String reporte = System.getProperty("user.dir") + "/src/ReportesFacturaCierre/" + nombre + ".jasper"; // direccion del reporte 

            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reporte);

            Map parametro = new HashMap();

            parametro.put("fechaSuspen1", Fecha_corte1);
            parametro.put("fechaSuspen2", Fecha_corte2);
            //parametro.put("fechaSuspen", Fecha_corte1);

            JasperPrint print = JasperFillManager.fillReport(jasperReport, parametro, micone);

            JasperViewer view = new JasperViewer(print, false);
            view.setVisible(true);

        } catch (Exception f) {

            JOptionPane.showMessageDialog(new JDialog(), "ERROR al General informes " + f);

        }

    }

    public void GenerarReporteHistorial(String nombre, String parametros) {
        Connection micone = conm.getConnection();

        try {
            String reporte = System.getProperty("user.dir") + "/src/ReportesUsuario/" + nombre + ".jasper"; // direccion del reporte 

            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reporte);

            Map parametro = new HashMap();

            parametro.put("codigo", parametros);

            JasperPrint print = JasperFillManager.fillReport(jasperReport, parametro, micone);

            JasperViewer view = new JasperViewer(print, false);
            view.setVisible(true);

        } catch (Exception f) {

            JOptionPane.showMessageDialog(new JDialog(), "ERROR al General informes " + f);

        }

    }

    public void insertarPagoFinanciacion(String Codigofinan) {
        String estadofi = "no";
        String numero_cuota = "1";
        String cuotas_paga = "B";
        String valorcuotadeuda = "";
        String ivadeuda = "";
        String codigofide = "";
        int nuevacuotapaga = 0;

        double TotaDeuda = 0;
        try { // VERIFICAMOS EL VALOR DE LA CUOTA
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(
                    "SELECT f.estado as estado, (f.valor_total / f.numero_cuotas) as valorcuota , f.numero_cuotas as numero_cuotas, f.cuotas_pagas as cuotas_pagas, s.valor as iva, f.codigo_financiacion as codigofi FROM inmueble i, financiacion f, servicio s WHERE f.inmueble = i.codigo_inmueble and s.idservicio = f.iva and  f.estado = 'AC' and f.codigo_financiacion =" + Codigofinan);

            ResultSet res = (ResultSet) pstm.executeQuery();
            while (res.next()) {

                valorcuotadeuda = res.getString("valorcuota");
                ivadeuda = res.getString("iva");
                codigofide = res.getString("codigofi");
                TotaDeuda = (Double.parseDouble(valorcuotadeuda) * (Double.parseDouble(ivadeuda) / 100)) + Double.parseDouble(valorcuotadeuda);
                estadofi = res.getString("estado");

                numero_cuota = res.getString("numero_cuotas");
                cuotas_paga = res.getString("cuotas_pagas");

            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA");
        }

        if (estadofi.equals("no")) { // VERIFICAMOS SI HAY FINANCIACION
            // NO HAY FINANCIACION

        } else if (numero_cuota.equals(cuotas_paga)) { // VERIFICAMOS QUE LA FINANCIACION NO ESTE PAGA 
            JOptionPane.showMessageDialog(new JDialog(), "La financiacion YA se cancelo en su totalidad estado" + estadofi);
            try {// SI YA ESTA PAGA ACTUALIZAMOS EL ESTADO DE LA MISMA

                java.sql.PreparedStatement pstm = (java.sql.PreparedStatement) conm.getConnection().prepareStatement("UPDATE financiacion SET estado ='IN' WHERE codigo_financiacion  =" + Codigofinan);
                pstm.execute();
                pstm.close();

                //JOptionPane.showMessageDialog(new JDialog(), "Actualizacion correcta Financiacion estado");
            } catch (SQLException e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA ACTUALIZACION");
            }

        } else { // SE INSERTA EN PAGO FINANCIACION LA NUEVA CUOTA

            try {
                String q = "INSERT INTO pago_financiacion (codigo_financiacion,valor, tipopago) VALUES ('" + Codigofinan + "'," + TotaDeuda + ",'Factura')";
                PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(q);
                pstm.execute();
                pstm.close();
                //JOptionPane.showMessageDialog(new JDialog(), "Pago satisfactorio Financiacion");
            } catch (SQLException e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(new JDialog(), "Error al registrar el pago Financiacion");
            }

            try {// SE ACTUALIZA LA NUEVA CUOTA PAGA ES CUOTASPAGAS
                nuevacuotapaga = Integer.parseInt(cuotas_paga) + 1;
                java.sql.PreparedStatement pstm = (java.sql.PreparedStatement) conm.getConnection().prepareStatement("UPDATE financiacion SET cuotas_pagas =" + nuevacuotapaga + " WHERE codigo_financiacion  =" + Codigofinan);
                //System.out.println(pstm);
                pstm.execute();
                pstm.close();

                //JOptionPane.showMessageDialog(new JDialog(), "Actualizacion correcta Financiacion cuota neuva");
            } catch (SQLException e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA ACTUALIZACION");
            }

        }
        int cuotapaga = Integer.parseInt(numero_cuota); //SE VERIFICA SI YA TERMINO LA FINANCIACION Y SE ACTUALIZA EL ESTADO
        if (numero_cuota.equals("A")) {
            // NO HAY FINANCIACION           
        } else if (cuotapaga == nuevacuotapaga) {
            //JOptionPane.showMessageDialog(new JDialog(), "La financiacion  se cancelo en su totalidad estado"+estadofi);
            try {

                java.sql.PreparedStatement pstm = (java.sql.PreparedStatement) conm.getConnection().prepareStatement("UPDATE financiacion SET estado ='IN' WHERE codigo_financiacion  =" + Codigofinan);
                //System.out.println(pstm);
                pstm.execute();
                pstm.close();

                //JOptionPane.showMessageDialog(new JDialog(), "Actualizacion correcta Financiacion estado");
            } catch (SQLException e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA ACTUALIZACION");
            }

        }
    }

    public String VerificarCierre(String Fechacorte) {
        String resultado = "";
        String fechade = "";
        try {
            String sql = "SELECT f.fecha_suspencion as fecha "
                    + "FROM factura f, deudor d "
                    + "WHERE f.codigo_factura = d.codigo_factura "
                    + "AND f.fecha_suspencion='" + Fechacorte + "' "
                    + "AND d.tipo = 'cierre'";
            //System.out.println(sql);
            ResultSet res = null;
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(sql);
            res = (ResultSet) pstm.executeQuery();
            res.next();
            fechade = res.getString("fecha");
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        if (fechade.equals(Fechacorte)) {

            resultado = "1";

        } else {
            resultado = "2";
        }
        return resultado;
    }

    public void OtrosConceptos(String otros_conceptos) {

        try { // ACTUALIZAMOS DEUDA SI HAY

            java.sql.PreparedStatement pstm2 = (java.sql.PreparedStatement) conm.getConnection().prepareStatement("UPDATE otrosconceptos SET estado = 'IN' WHERE estado = 'AC' and id=" + otros_conceptos);
            //System.out.println(pstm2);
            pstm2.execute();
            pstm2.close();

            //JOptionPane.showMessageDialog(new JDialog(), "Actualizacion correcta otros_conceptos");
        } catch (SQLException eY) {
            System.out.println(eY);
            JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA ACTU otros_conceptos");
        }
    }

   

}

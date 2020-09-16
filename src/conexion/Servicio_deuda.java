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

/**
 *
 * @author Paolita
 */
public class Servicio_deuda {

    ConexionMysql conm;

    public Servicio_deuda() {

        conm = new ConexionMysql();
    }

    public Object[][] ConsultarDeuda(String CODIGO) {

        int registros = 0;
        //obtenemos la cantidad de registros existentes en la tabla
        try {

            ResultSet res = null;
            String Sql = "SELECT " +
                "count(*) as total " +
                "From " +
                "inmueble i " +
                "Inner join cliente c on c.documento = i.documento  " +
                "Inner join factura f on i.codigo_inmueble = f.codigo_inmueble " +
                "Where " +
                " i.codigo_inmueble ='" +CODIGO+ "'";

            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(Sql);

            res = (ResultSet) pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        Object[][] datos = new String[registros][6];
        try {
            String sql = "Select " +
                    "c.documento, c.nombre, i.direccion, f.codigo_factura , f.total_a_pagar, f.codigo_factura " +
                    "From "+
                    "inmueble i " +
                    "Inner join cliente c on c.documento = i.documento  " +
                    "Inner join factura f on i.codigo_inmueble = f.codigo_inmueble " +
                    "Where " +
                    " i.codigo_inmueble ='" +CODIGO+ "'";

            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(sql);
            ResultSet res = null;
            res = (ResultSet) pstm.executeQuery();
            int i = 0;
            while (res.next()) {

                String documento = res.getString("documento");
                String nombre = res.getString("nombre");
                String direccion = res.getString("direccion");
                String deuda = res.getString("codigo_factura");
                String total = res.getString("total_a_pagar");
                String factura = res.getString("codigo_factura");

                datos[i][0] = documento;
                datos[i][1] = nombre;
                datos[i][2] = direccion;
                datos[i][3] = deuda;
                datos[i][4] = total;
                datos[i][5] = factura;

                i++;
//System.out.println(i);
//System.out.println(documento);
            }

            res.close();
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL NUMERO DE DOCUMENTO");
        }

        return datos;

    }
    
   

    public void CancelarDeuda(String codigo) {
        try {
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("UPDATE deudor SET estado ='IN' "
                    + "WHERE codigo_factura  =" + codigo);

            pstm.execute();
            pstm.close();
            // JOptionPane.showMessageDialog(new JDialog(), "Actualizacion correcta");

        } catch (SQLException e) {
            System.out.println(e);
            // JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA ACTUALIZACION");
        }

    }

    public Object[][] ConsultarDeudaCedula(String CEDULA) {

        int registros = 0;
        //obtenemos la cantidad de registros existentes en la tabla
        try {

            ResultSet res = null;
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("SELECT  count(*) as total from inmueble i, cliente c, factura f, deudor d where d.codigo_factura = f.codigo_factura and i.codigo_inmueble = f.codigo_inmueble and c.documento = i.documento and d.estado = 'AC' and c.documento = " + CEDULA + " ");

            res = (ResultSet) pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        Object[][] datos = new String[registros][7];
        try {
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("select "
                    + "c.documento, c.nombre, i.codigo_inmueble, i.direccion, f.codigo_factura, f.total_a_pagar, f.fecha_de_pago "
                    + "from inmueble i, cliente c, factura f, deudor d "
                    + "where d.codigo_factura = f.codigo_factura and i.codigo_inmueble = f.codigo_inmueble and c.documento = i.documento and d.estado = 'AC' and c.documento = " + CEDULA + " ");

            ResultSet res = null;
            res = (ResultSet) pstm.executeQuery();
            int i = 0;
            while (res.next()) {

                String documento = res.getString("documento");
                String nombre = res.getString("nombre");
                String inmueble = res.getString("codigo_inmueble");
                String direccion = res.getString("direccion");
                String factura = res.getString("codigo_factura");
                String total = res.getString("total_a_pagar");
                String fecha = res.getString("fecha_de_pago");

                datos[i][0] = documento;
                datos[i][1] = nombre;
                datos[i][2] = inmueble;
                datos[i][3] = direccion;
                datos[i][4] = factura;
                datos[i][5] = total;
                datos[i][6] = fecha;

                i++;
//System.out.println(i);
//System.out.println(documento);
            }

            res.close();
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL NUMERO DE DOCUMENTO");
        }

        return datos;

    }

    public Object[][] ConsultarDeudores() {

        int registros = 0;
        //obtenemos la cantidad de registros existentes en la tabla
        try {

            ResultSet res = null;
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("SELECT  count(*) as total from cliente c, inmueble i, deudor d, factura f "
                    + " where (c.documento = i.documento) and (i.codigo_inmueble = f.codigo_inmueble) and (d.codigo_factura = f.codigo_factura) and (d.estado ='ac')");

            res = (ResultSet) pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        Object[][] datos = new String[registros][6];
        try {
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("select c.Nombre, c.documento, i.direccion, d.codigo_factura, f.total_a_pagar, f.fecha_de_pago from cliente c, inmueble i, deudor d, factura f "
                    + " where (c.documento = i.documento) and (i.codigo_inmueble = f.codigo_inmueble) and (d.codigo_factura = f.codigo_factura) and (d.estado ='ac')");

            ResultSet res = null;
            res = (ResultSet) pstm.executeQuery();
            int i = 0;
            while (res.next()) {

                String documento = res.getString("documento");
                String nombre = res.getString("Nombre");
                String direccion = res.getString("direccion");
                String factura = res.getString("codigo_factura");
                String total = res.getString("total_a_pagar");
                String fecha = res.getString("fecha_de_pago");

                datos[i][0] = documento;
                datos[i][1] = nombre;
                datos[i][2] = direccion;
                datos[i][3] = factura;
                datos[i][4] = total;
                datos[i][5] = fecha;

                i++;
//System.out.println(i);
//System.out.println(documento);
            }

            res.close();
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL NUMERO DE DOCUMENTO");
        }

        return datos;

    }

    public Object[][] consultarValorTotaldeudas() {

        Object[][] valor_deuda = new String[1][1];
        try {
            ResultSet res = null;
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("select sum(f.total_a_pagar) as valor from cliente c, inmueble i, deudor d, factura f where (c.documento = i.documento) and (i.codigo_inmueble = f.codigo_inmueble) and (d.codigo_factura = f.codigo_factura) and (d.estado ='ac')");
            res = (ResultSet) pstm.executeQuery();

            while (res.next()) {
                String valor = res.getString("valor");

                valor_deuda[0][0] = valor;

            }
            res.close();

        } catch (SQLException e) {

        }
        return valor_deuda;
    }
}

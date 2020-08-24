/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.Financiacion;

/**
 *
 * @author Paolita
 */
public class Servicio_financiacion {

    ConexionMysql conm;

    public Servicio_financiacion() {
        conm = new ConexionMysql();
    }

    public Object[][] cboIva() {

        int registros = 0;
        //obtenemos la cantidad de registros existentes en la tabla
        try {

            ResultSet res = null;
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("SELECT Count(*) as total  FROM servicio WHERE CodServicio = 5");

            res = (ResultSet) pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        Object[][] datos = new String[registros][5];
        try {
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("SELECT idservicio, nombre   FROM servicio WHERE CodServicio = 5");

            ResultSet res = null;
            res = (ResultSet) pstm.executeQuery();
            int i = 0;
            while (res.next()) {

                String idservicio = res.getString("idservicio");
                String nombre = res.getString("nombre");
                datos[i][0] = idservicio;
                datos[i][1] = nombre;
                i++;
            }

            res.close();
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL NUMERO DE DOCUMENTO");
        }

        return datos;
    }

    public Object[][] NumeroGestion() {

        Object[][] datos = new String[1][1];
        try {
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(
                    "SELECT max(codigo_financiacion+1)as total FROM financiacion");
            ResultSet res = (ResultSet) pstm.executeQuery();
            while (res.next()) {
                String total = res.getString("total");
                datos[0][0] = total;
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA");
        }
        return datos;
    }

    public void ConsultarDeuda(String codigo_inmueble) {

        try {
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("select "
                    + "c.documento, c.nombre, i.direccion, d.iddeuda, f.total_a_pagar, f.codigo_factura "
                    + "from inmueble i, cliente c, deudor d, factura f "
                    + "where d.codigo_factura = f.codigo_factura and i.codigo_inmueble = f.codigo_inmueble and c.documento = i.documento and d.estado = 'AC' and i.codigo_inmueble = " + codigo_inmueble + " ");

            ResultSet res = null;
            res = (ResultSet) pstm.executeQuery();

            while (res.next()) {

                String factura = res.getString("codigo_factura");

                try {
                    PreparedStatement pstm1 = (PreparedStatement) conm.getConnection().prepareStatement("UPDATE deudor SET estado ='IN' "
                            + "WHERE codigo_factura  =" + factura);

                    pstm1.execute();
                    pstm1.close();
                    // JOptionPane.showMessageDialog(new JDialog(), "Actualizacion correcta");

                } catch (SQLException e1) {
                    System.out.println(e1);
                    // JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA ACTUALIZACION");
                }

            }

            res.close();
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL NUMERO DE DOCUMENTO");
        }

    }

    public void insertar(Financiacion financiacion) {

        String q = "";

        try {
            q = "INSERT INTO financiacion (codigo_financiacion, documento, inmueble, numero_cuotas, cuotas_pagas,iva,valor_total, tipo, abono, estado) VALUES (" + financiacion.getCodigo_financiacion() + ",'" + financiacion.getDocumento() + "','" + financiacion.getInmueble() + "','" + financiacion.getNumero_cuotas() + "','0','" + financiacion.getIva_financiacion() + "','" + financiacion.getValor_total() + "','" + financiacion.getTipo() + "','" + financiacion.getAbono() + "','AC')";

            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement(q);
            System.out.println(pstm);
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(new JDialog(), "Financiación Ingresada Correctamente");

        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(new JDialog(), "Error al ingresar la nueva financiacion");
        }
    }

    public Object[][] ConsultarFinanciacion(String CODIGO) {

        Object[][] datos = new String[1][11];
        try {
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("SELECT "
                    + " f.inmueble as inmueble, f.codigo_financiacion as codigo, f.numero_cuotas as cuotas, f.iva as iva, f.tipo as tipo,c.nombre as nombre, c.documento as documento, i.direccion as dir, f.valor_total as valor, f.cuotas_pagas, f.abono as abono"
                    + " FROM  financiacion f, cliente c, inmueble i "
                    + " WHERE f.inmueble= i.codigo_inmueble and c.documento = i.documento and f.codigo_financiacion= " + CODIGO);

            ResultSet res = null;
            res = (ResultSet) pstm.executeQuery();
            while (res.next()) {

                String codigo = res.getString("codigo");
                String numero = res.getString("cuotas");
                String iva = res.getString("iva");
                String valor = res.getString("valor");
                String nombre = res.getString("nombre");
                String documento = res.getString("documento");
                String direccion = res.getString("dir");
                String cuota = res.getString("cuotas_pagas");
                String tipo = res.getString("tipo");
                String abono = res.getString("abono");
                String inmueble = res.getString("inmueble");
                datos[0][0] = codigo;
                datos[0][1] = numero;
                datos[0][2] = iva;
                datos[0][3] = valor;
                datos[0][4] = nombre;
                datos[0][5] = documento;
                datos[0][6] = direccion;
                datos[0][7] = cuota;
                datos[0][8] = tipo;
                datos[0][9] = abono;
                datos[0][10] = inmueble;

            }

            res.close();
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL CODIGO DE LA FINANCIACIÓN");
        }

        return datos;

    }

    public void Modificarfinanciacion(Financiacion financiacion) {
        try {
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("UPDATE financiacion SET inmueble =  '" + financiacion.getInmueble()
                    + "', valor_total = '" + financiacion.getValor_total() + "' , numero_cuotas = '" + financiacion.getNumero_cuotas() + "' " + " WHERE codigo_financiacion=" + financiacion.getCodigo_financiacion());

            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(new JDialog(), "Actualizacion correcta");

        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA ACTUALIZACION");
        }

    }

    public Object[][] CuotaFija(String codigo_financiacion) {

        Object[][] datos = new String[1][9];
        double cuota = 0.0;
        String cuota_1 = "";

        try {

            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("SELECT "
                    + "c.nombre as nombre, "
                    + "c.documento as documento, "
                    + "i.Direccion as direccion,  "
                    + "f.numero_cuotas as numero_cuotas, "
                    + "f.cuotas_pagas as cuotas_pagas, "
                    + "f.iva as iva, "
                    + "f.valor_total as valor_total,"
                    + "s.valor as valoriva, "
                    + "f.codigo_financiacion as financiacion, "
                    + "f.inmueble as inmueble "
                    + "FROM "
                    + "financiacion f, "
                    + "inmueble i,  "
                    + "cliente c, "
                    + "servicio s "
                    + "WHERE "
                    + "i.documento = c.documento and "
                    + "f.iva = s.idservicio and "
                    + "i.codigo_inmueble = f.inmueble and "
                    + "f.codigo_financiacion=" + codigo_financiacion + " "
                    + "group by  i.codigo_inmueble");

            ResultSet res = null;
            res = (ResultSet) pstm.executeQuery();
            while (res.next()) {

                String numero_cuotas = res.getString("numero_cuotas");
                String cuotas_pagas = res.getString("cuotas_pagas");
                String iva = res.getString("valoriva");
                double ivareal = Double.parseDouble(iva) / 100;
                String valor_total = res.getString("valor_total");

                String nombre = res.getString("nombre");
                String direccion = res.getString("direccion");
                String documento = res.getString("documento");
                String inmueble = res.getString("inmueble");
                cuota = ((Double.parseDouble(valor_total) * ivareal) + (Double.parseDouble(valor_total))) / Double.parseDouble(numero_cuotas);
                //System.out.println(cuota);           
                DecimalFormat df = new DecimalFormat("000");
                cuota_1 = df.format(cuota);
                //System.out.println(df.format(cuota)); 

                datos[0][0] = numero_cuotas;
                datos[0][1] = cuotas_pagas;
                datos[0][2] = iva;
                datos[0][3] = valor_total;
                datos[0][4] = nombre;
                datos[0][5] = direccion;
                datos[0][6] = documento;
                datos[0][7] = cuota_1;
                datos[0][8] = inmueble;

            }

        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA");
        }

        return datos;

    }
//

    public Object[][] Cuotapagafinanciacionfactura(String factura) {

        Object[][] datos = new String[1][2];

        try {

            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("select numero_cuotas, cuotas_pagas from financiacion where codigo_financiacion=" + factura);

            ResultSet res = null;
            res = (ResultSet) pstm.executeQuery();
            while (res.next()) {

                String numero_cuotas = res.getString("numero_cuotas");
                String cuotas_pagas = res.getString("cuotas_pagas");

                datos[0][0] = numero_cuotas;
                datos[0][1] = cuotas_pagas;

                if (Integer.parseInt(cuotas_pagas) == Integer.parseInt(numero_cuotas)) {

                    try {
                        PreparedStatement pstm2 = (PreparedStatement) conm.getConnection().prepareStatement("UPDATE financiacion SET estado = 'IN' WHERE  codigo_financiacion=" + factura);

                        pstm2.execute();
                        pstm2.close();
                        JOptionPane.showMessageDialog(new JDialog(), "Pago satisfactorio de cuota");
                    } catch (SQLException e) {
                        System.out.println(e);
                    }

                    JOptionPane.showMessageDialog(new JDialog(), "La financiacion ya ha sido cancelada en su totalidad");
                } else {

                    int nc = Integer.parseInt(cuotas_pagas) + 1;

                    try {
                        PreparedStatement pstm1 = (PreparedStatement) conm.getConnection().prepareStatement("UPDATE financiacion SET cuotas_pagas =  " + nc + " WHERE  codigo_financiacion=" + factura);

                        pstm1.execute();
                        pstm1.close();
                        JOptionPane.showMessageDialog(new JDialog(), "Pago satisfactorio de cuota");

                    } catch (SQLException e) {
                        System.out.println(e);
                        JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR EL PAGO");
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA");
        }

        return datos;

    }

    public String ConsultarFactura(String CODIGO) {

        String Codigofinan = "";
        try {
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("SELECT "
                    + " f.codigo_financiacion as codigo"
                    + " FROM financiacion f, factura fa, inmueble i "
                    + " WHERE fa.codigo_inmueble=i.codigo_inmueble and i.codigo_inmueble=f.inmueble and  fa.codigo_factura= " + CODIGO + " ");

            ResultSet res = null;
            res = (ResultSet) pstm.executeQuery();
            while (res.next()) {

                String codigo = res.getString("codigo");

                Codigofinan = codigo;
            }

            res.close();
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL CODIGO DEL INMUEBLE");
        }

        return Codigofinan;

    }

    public Object[][] ConsultarFinanciaciones(String documento) {

        int registros = 0;

        try {

            ResultSet res = null;
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("SELECT  count(*) as total FROM cliente c, inmueble i, financiacion f where f.documento = c.documento and f.inmueble = i.codigo_inmueble and f.estado='AC' and f.documento='" + documento + "'");

            res = (ResultSet) pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        Object[][] datos = new String[registros][9];
        try {
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("SELECT "
                    + " c.documento, c.nombre, i.codigo_inmueble, i.direccion, f.codigo_financiacion, f.numero_cuotas, f.cuotas_pagas, f.abono as abono, valor_total as valor_total "
                    + " FROM cliente c, inmueble i, financiacion f "
                    + " WHERE f.documento = c.documento and f.inmueble = i.codigo_inmueble and f.estado='AC' and f.documento='" + documento + "'");

            ResultSet res = null;
            res = (ResultSet) pstm.executeQuery();
            int i = 0;
            while (res.next()) {

                String documento1 = res.getString("documento");
                String nombre = res.getString("nombre");
                String inmueble = res.getString("codigo_inmueble");
                String direccion = res.getString("direccion");
                String financiacion = res.getString("codigo_financiacion");
                String cuotas = res.getString("numero_cuotas");
                String pagas = res.getString("cuotas_pagas");
                String abono = res.getString("abono");
                String valor = res.getString("valor_total");

                datos[i][0] = documento1;
                datos[i][1] = nombre;
                datos[i][2] = inmueble;
                datos[i][3] = direccion;
                datos[i][4] = financiacion;
                datos[i][5] = cuotas;
                datos[i][6] = pagas;
                datos[i][7] = abono;
                datos[i][8] = valor;
                i++;
            }

            res.close();
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL NUMERO DE DOCUMENTO");
        }

        return datos;

    }

    public Object[][] ConsultarFinanciacionesGenerales() {

        int registros = 0;
        //obtenemos la cantidad de registros existentes en la tabla
        try {

            ResultSet res = null;
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("SELECT  count(*) as total from cliente c, inmueble i, financiacion f where (c.documento = i.documento) and (i.codigo_inmueble = f.inmueble) and (f.estado='AC')");

            res = (ResultSet) pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        Object[][] datos = new String[registros][9];
        try {
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("select c.Nombre, c.documento, i.codigo_inmueble, i.direccion, "
                    + "f.codigo_financiacion, f.valor_total, f.numero_cuotas, f.cuotas_pagas, f.abono from cliente c, inmueble i, financiacion f where (c.documento = i.documento)"
                    + " and (i.codigo_inmueble = f.inmueble) and (f.estado='AC')");

            ResultSet res = null;
            res = (ResultSet) pstm.executeQuery();
            int i = 0;
            while (res.next()) {

                String nombre = res.getString("Nombre");
                String documento = res.getString("documento");
                String inmueble = res.getString("codigo_inmueble");
                String direccion = res.getString("direccion");
                String financiacion = res.getString("codigo_financiacion");
                String total = res.getString("valor_total");
                String cuotas = res.getString("numero_cuotas");
                String pagas = res.getString("cuotas_pagas");
                String abono = res.getString("abono");

                datos[i][0] = nombre;
                datos[i][1] = documento;
                datos[i][2] = inmueble;
                datos[i][3] = direccion;
                datos[i][4] = financiacion;
                datos[i][5] = total;
                datos[i][6] = cuotas;
                datos[i][7] = pagas;
                datos[i][8] = abono;

                i++;

            }

            res.close();
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA");
        }

        return datos;

    }

    public Object[][] ConsultarNumeroFactura(String codigo_inmueble) {

        Object[][] datos = new String[1][1];
        try {
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("select max(d.codigo_factura) as factura "
                    + " FROM  factura f, deudor d, inmueble i, cliente c  "
                    + " WHERE  f.codigo_inmueble = i.codigo_inmueble and c.documento= i.documento \n"
                    + "and f.codigo_factura = d.codigo_factura and f.codigo_inmueble =  " + codigo_inmueble);

            ResultSet res = null;
            res = (ResultSet) pstm.executeQuery();
            while (res.next()) {

                String codigo_factura = res.getString("factura");

                datos[0][0] = codigo_factura;

            }

            res.close();
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL CODIGO DEL INMUEBLE");
        }

        return datos;

    }

    public String CodigoIva(String iva) {

        String idservicio = "";
        try {
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("SELECT idservicio,nombre   FROM servicio WHERE nombre = '" + iva + "' AND CodServicio = 5");
            ResultSet res = null;
            res = (ResultSet) pstm.executeQuery();
            while (res.next()) {
                idservicio = res.getString("idservicio");

            }

            res.close();
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL CODIGO DEL INMUEBLE");
        }

        return idservicio;

    }

    public void InserDeuda(String codigo) {
        String q = "";
        String fecha = "";
        try {
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("select fecha_de_pago from factura where codigo_factura =" + codigo);
            ResultSet res = null;
            res = (ResultSet) pstm.executeQuery();
            int i = 0;
                if (res !=null) {
                    while (res.next()) {

                        fecha = res.getString("fecha_de_pago");

                        q = "select * from deudor where tipo = 'financia' and codigo_factura =" + codigo;
                        pstm = (PreparedStatement) conm.getConnection().prepareStatement(q);
                        System.out.println(pstm);
                        res = null;
                        res = (ResultSet) pstm.executeQuery();
                        if (!res.next()) {   
                            q = "INSERT INTO deudor (interes_mora, codigo_factura,fecha_pago, estado, tipo) VALUES ('1','" + codigo + "','" + fecha + "','IN','financia')";
                            pstm = (PreparedStatement) conm.getConnection().prepareStatement(q);
                            System.out.println(pstm);
                        }else {
                            JOptionPane.showMessageDialog(new JDialog(), "ERROR LA DEUDA YA EXISTE PARA ESA FACTURA");
                        }   
                
                    pstm.execute();
                    pstm.close();
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA");
        }
        
        

    }

    public Object[][] ConsultarTitular_inmueble(String documento, String codigo_inmueble) {

        Object[][] datos = new String[1][11];
        try {
            PreparedStatement pstm = (PreparedStatement) conm.getConnection().prepareStatement("SELECT codigo_inmueble, documento "
                    + " FROM  inmueble "
                    + " WHERE documento = " + documento + " AND codigo_inmueble = " + codigo_inmueble);

            ResultSet res = null;
            res = (ResultSet) pstm.executeQuery();
            while (res.next()) {

                String codigo_inmueble1 = res.getString("codigo_inmueble");
                String documento1 = res.getString("documento");

                datos[0][0] = codigo_inmueble1;
                datos[0][1] = documento1;

            }

            res.close();
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(new JDialog(), "ERROR AL REALIZAR LA CONSULTA VERIFIQUE EL CODIGO DEL INMUEBLE");
        }

        return datos;

    }

}

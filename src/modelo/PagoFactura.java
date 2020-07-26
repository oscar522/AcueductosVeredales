/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Paolita
 */
public class PagoFactura {
    
    private String codigo_factura;
    private String codigo_pago_factura;
    private String fecha_pago;

    public PagoFactura(String codigo_factura, String codigo_pago_factura, String fecha_pago) {
        this.codigo_factura = codigo_factura;
        this.codigo_pago_factura = codigo_pago_factura;
        this.fecha_pago = fecha_pago;
    }

    public PagoFactura(String codigo_factura, String codigo_pago_factura) {
        this.codigo_factura = codigo_factura;
        this.codigo_pago_factura = codigo_pago_factura;
    }
    
    

    public String getCodigo_factura() {
        return codigo_factura;
    }

    public void setCodigo_factura(String codigo_factura) {
        this.codigo_factura = codigo_factura;
    }

    public String getCodigo_pago_factura() {
        return codigo_pago_factura;
    }

    public void setCodigo_pago_factura(String codigo_pago_factura) {
        this.codigo_pago_factura = codigo_pago_factura;
    }

    public String getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(String fecha_pago) {
        this.fecha_pago = fecha_pago;
    }
    
    
    
}

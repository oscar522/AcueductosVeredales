/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Paolita
 */
public class PagoFinanciacion {
    
    
    private String codigo_pago_financiacion;
    private String codigo_financiacion;
    private String fecha_pago;
    private String valor;

    public PagoFinanciacion(String codigo_pago_financiacion, String codigo_financiacion, String fecha_pago, String valor) {
        this.codigo_pago_financiacion = codigo_pago_financiacion;
        this.codigo_financiacion = codigo_financiacion;
        this.fecha_pago = fecha_pago;
        this.valor = valor;
    }

    public PagoFinanciacion( String codigo_financiacion, String valor) {
      
        this.codigo_financiacion = codigo_financiacion;
        this.valor = valor;
    }

    
    
    public String getCodigo_financiacion() {
        return codigo_financiacion;
    }

    public void setCodigo_financiacion(String codigo_financiacion) {
        this.codigo_financiacion = codigo_financiacion;
    }

    public String getCodigo_pago_financiacion() {
        return codigo_pago_financiacion;
    }

    public void setCodigo_pago_financiacion(String codigo_pago_financiacion) {
        this.codigo_pago_financiacion = codigo_pago_financiacion;
    }

    public String getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(String fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Paolita
 */
public class Factura {
    
    private String codigo_factura;
    private String periodeo_facturacion_inicial;
    private String periodo_facturacion_final;
    private String fecha_de_pago;
    private String fecha_suspencion;
    private String codigo_inmueble;
    private String acueducto;
    private String reconeccion;
    private String iva_acueducto;
    private String total_a_pagar;
    private String codigo_financiacion;

    public Factura(String codigo_factura, String periodeo_facturacion_inicial, String periodo_facturacion_final, String fecha_de_pago, String fecha_suspencion, String codigo_inmueble, String acueducto, String reconeccion, String iva_acueducto, String total_a_pagar, String codigo_financiacion) {
        this.codigo_factura = codigo_factura;
        this.periodeo_facturacion_inicial = periodeo_facturacion_inicial;
        this.periodo_facturacion_final = periodo_facturacion_final;
        this.fecha_de_pago = fecha_de_pago;
        this.fecha_suspencion = fecha_suspencion;
        this.codigo_inmueble = codigo_inmueble;
        this.acueducto = acueducto;
        this.reconeccion = reconeccion;
        this.iva_acueducto = iva_acueducto;
        this.total_a_pagar = total_a_pagar;
        this.codigo_financiacion = codigo_financiacion;
    }

    public String getAcueducto() {
        return acueducto;
    }

    public void setAcueducto(String acueducto) {
        this.acueducto = acueducto;
    }

    public String getCodigo_factura() {
        return codigo_factura;
    }

    public void setCodigo_factura(String codigo_factura) {
        this.codigo_factura = codigo_factura;
    }

    public String getCodigo_financiacion() {
        return codigo_financiacion;
    }

    public void setCodigo_financiacion(String codigo_financiacion) {
        this.codigo_financiacion = codigo_financiacion;
    }

    public String getCodigo_inmueble() {
        return codigo_inmueble;
    }

    public void setCodigo_inmueble(String codigo_inmueble) {
        this.codigo_inmueble = codigo_inmueble;
    }

    public String getFecha_de_pago() {
        return fecha_de_pago;
    }

    public void setFecha_de_pago(String fecha_de_pago) {
        this.fecha_de_pago = fecha_de_pago;
    }

    public String getFecha_suspencion() {
        return fecha_suspencion;
    }

    public void setFecha_suspencion(String fecha_suspencion) {
        this.fecha_suspencion = fecha_suspencion;
    }

    public String getIva_acueducto() {
        return iva_acueducto;
    }

    public void setIva_acueducto(String iva_acueducto) {
        this.iva_acueducto = iva_acueducto;
    }

    public String getPeriodeo_facturacion_inicial() {
        return periodeo_facturacion_inicial;
    }

    public void setPeriodeo_facturacion_inicial(String periodeo_facturacion_inicial) {
        this.periodeo_facturacion_inicial = periodeo_facturacion_inicial;
    }

    public String getPeriodo_facturacion_final() {
        return periodo_facturacion_final;
    }

    public void setPeriodo_facturacion_final(String periodo_facturacion_final) {
        this.periodo_facturacion_final = periodo_facturacion_final;
    }

    public String getReconeccion() {
        return reconeccion;
    }

    public void setReconeccion(String reconeccion) {
        this.reconeccion = reconeccion;
    }

    public String getTotal_a_pagar() {
        return total_a_pagar;
    }

    public void setTotal_a_pagar(String total_a_pagar) {
        this.total_a_pagar = total_a_pagar;
    }
    
    
    
}

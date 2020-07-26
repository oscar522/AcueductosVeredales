/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Paolita
 */
public class Financiacion {
   
    
    
    private String codigo_financiacion;
    private String documento;
    private String inmueble;
    private String numero_cuotas;
    private String valor_total;
    private String cuotas_pagas;
    private String iva_financiacion;
    private String tipo;
    private String abono;
    private String estado;
    
    

    public Financiacion(String codigo_financiacion,String documento,String inmueble, String numero_cuotas, String valor_total, String cuotas_pagas, String iva_financiacion, String tipo, String abono) {
        this.codigo_financiacion = codigo_financiacion;
        this.documento = documento;
        this.inmueble = inmueble;
        this.numero_cuotas = numero_cuotas;
        this.valor_total = valor_total;
        this.cuotas_pagas = cuotas_pagas;
        this.iva_financiacion = iva_financiacion;
        this.tipo = tipo;
        this.abono = abono;
    }  

    public String getAbono() {
        return abono;
    }

    public void setAbono(String abono) {
        this.abono = abono;
    }

    
    public String getInmueble() {
        return inmueble;
    }

    public void setInmueble(String inmueble) {
        this.inmueble = inmueble;
    }

    public Financiacion(String codigo_financiacion, String documento, String inmueble, String numero_cuotas, String valor_total, String cuotas_pagas, String iva_financiacion,String tipo, String abono,  String estado) {
        this.codigo_financiacion = codigo_financiacion;
        this.documento = documento;
        this.inmueble = inmueble;
        this.numero_cuotas = numero_cuotas;
        this.valor_total = valor_total;
        this.cuotas_pagas = cuotas_pagas;
        this.iva_financiacion = iva_financiacion;
        this.tipo = tipo;
        this.estado = estado;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCodigo_financiacion() {
        return codigo_financiacion;
    }

    public void setCodigo_financiacion(String codigo_financiacion) {
        this.codigo_financiacion = codigo_financiacion;
    }

    public String getCuotas_pagas() {
        return cuotas_pagas;
    }

    public void setCuotas_pagas(String cuotas_pagas) {
        this.cuotas_pagas = cuotas_pagas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getIva_financiacion() {
        return iva_financiacion;
    }

    public void setIva_financiacion(String iva_financiacion) {
        this.iva_financiacion = iva_financiacion;
    }

    public String getNumero_cuotas() {
        return numero_cuotas;
    }

    public void setNumero_cuotas(String numero_cuotas) {
        this.numero_cuotas = numero_cuotas;
    }

    public String getValor_total() {
        return valor_total;
    }

    public void setValor_total(String valor_total) {
        this.valor_total = valor_total;
    }
    
    
    
    
    
    
}

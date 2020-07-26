/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Paolita
 */
public class Reconeccion {
    
    String codigo_factura;
    String fecha_reconeccion;
    String valor;
    String estado;

    public Reconeccion(String codigo_factura, String fecha_reconeccion) {
        this.codigo_factura = codigo_factura;
        this.fecha_reconeccion = fecha_reconeccion;
    }

    public String getFecha_reconeccion() {
        return fecha_reconeccion;
    }

    public void setFecha_reconeccion(String fecha_reconeccion) {
        this.fecha_reconeccion = fecha_reconeccion;
    }

    public String getCodigo_factura() {
        return codigo_factura;
    }

    public void setCodigo_factura(String codigo_factura) {
        this.codigo_factura = codigo_factura;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author PaolaAlfonso
 */
public class Otros_conceptos {

    private String id ="";
    private String inmueble =" ";
    private String conceptos =" ";
    private String valor =" ";
    private String estado =" ";

    public Otros_conceptos(String id,String inmueble, String concepto, String valor) {
        this.id = id;
        this.inmueble = inmueble;
        this.conceptos = concepto;
        this.valor = valor;
        

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getConceptos() {
        return conceptos;
    }

    public void setConceptos(String conceptos) {
        this.conceptos = conceptos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getInmueble() {
        return inmueble;
    }

    public void setInmueble(String inmueble) {
        this.inmueble = inmueble;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

}

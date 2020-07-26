/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author PaolaAlfonso
 */
public class Servicio {

    private String valor = "";
    private String nombre = "";
    private String idservicio = "";

    public Servicio(String valor, String nombre ) {

       
        this.valor = valor;
        this.nombre = nombre;


    }

    public String getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(String idservicio) {
        this.idservicio = idservicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }





}

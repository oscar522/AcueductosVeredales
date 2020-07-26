/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Paolita
 */
public class Cliente {
    
    
   private String nombre;
   private String documento;
   private String tipo_documento;
   private String genero;
   private String telefono;
  
    public Cliente(String nombre, String documento, String tipo_documento, String genero, String telefono) {
        this.nombre = nombre;
        this.documento = documento;
        this.tipo_documento = tipo_documento;
        this.genero = genero;
        this.telefono = telefono;
    }

  
    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

  
    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

  
   
}

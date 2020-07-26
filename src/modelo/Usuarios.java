/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Paolita
 */
public class Usuarios {
    
    
   private String nombre;
   private String apellidos;
   private String usuario;
   private String contrasena;
   private String identifica;

    public Usuarios(String nombre, String apellidos, String usuario, String contrasena, String identifica) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.identifica = identifica;
    }

    public String getIdentifica() {
        return identifica;
    }

    public void setIdentifica(String identifica) {
        this.identifica = identifica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

   
  
   
}

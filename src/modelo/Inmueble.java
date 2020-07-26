/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Paolita
 */
public class Inmueble {
    
    private String codigo;
    private String direccion;
    private String telefono;
    private String alcantarillado;
    private String acueducto;
    private String documento;


   

    public Inmueble(String codigo, String direccion, String telefono, String alcantarillado, String documento, String acueducto) {
        
        this.codigo = codigo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.documento = documento;
        this.alcantarillado = alcantarillado;
        this.acueducto = acueducto;
        
    }

 
    

   

    
    public String getAlcantarillado() {
        return alcantarillado;
    }

    public void setAlcantarillado(String alcantarillado) {
        this.acueducto = alcantarillado;
    }
    
    public String getAcueducto() {
        return acueducto;
    }

    public void setAcueducto(String alcantarillado) {
        this.alcantarillado = alcantarillado;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
  
    
    
}

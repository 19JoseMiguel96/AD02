/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appgestiontiendas;

/**
 *
 * @author Jose Miguel
 */
public class Clientes {
    private final String nombre;
    private final String apellidos;
    private String email;
    
    public Clientes(String nombre,String apellidos,String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}

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
public class Empleados {
    private final String nombre;
    private final String apellidos;
    
    public Empleados(String nome, String apelidos) {
        this.nombre = nome;
        this.apellidos = apelidos;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getApellidos() {
        return apellidos;
    }
    
}

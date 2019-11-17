/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appgestiontiendas;

import java.util.ArrayList;

/**
 *
 * @author Jose Miguel
 */
public class Tiendas {
    private final String nombre;
    private final String ciudad;
    private ArrayList<Empleados> empleados;
    private ArrayList<Productos> productos;
  
    public Tiendas(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;     
        this.empleados = new ArrayList();
        this.productos = new ArrayList();        
    } 

    public ArrayList<Empleados> getEmpleados() {
        return empleados;
    }

    public ArrayList<Productos> getProductos() {
        return productos;
    }    
            
    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    } 
       
    
}

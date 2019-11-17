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
public class Productos {
    private final String codigoId;
    private final String descripcion;
    private double precio;
    private int cantidad;
            
    public Productos(String id,String descripcion,double prezo,int cantidade) {
        this.codigoId = id;
        this.descripcion = descripcion;
        this.precio = prezo;
        this.cantidad = cantidade;
    }

    public String getCodigoId() {
        return codigoId;
    }   

    public String getDescripcion() {
        return descripcion;
    }
    
    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    
    
}

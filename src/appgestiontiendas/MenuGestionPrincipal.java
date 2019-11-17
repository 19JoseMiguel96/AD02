/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appgestiontiendas;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;


/**
 *
 * @author Jose Miguel
 */
public class MenuGestionPrincipal {
    static Empresa empresa = new Empresa();
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */    
    public static void main(String[] args) throws IOException {
        leerJson();
        System.out.println("|---------------------------|");
        System.out.println("|App de gestión [Franquicia]|");
        System.out.println("|---------------------------|");
                 
        String nombre,ciudad,codigoId,descripcion,apellidos,email;
        Double precio;
        int cantidad,i,c;
        boolean cierre = false;        
        while(cierre==false){      
            Scanner teclado = new Scanner(System.in);
            System.out.println("\n<-----------------MENÚ----------------->");
            System.out.println("[1] Añadir una tienda.");
            System.out.println("[2] Eliminar una tienda.");
            System.out.println("[3] Añadir un producto a la tienda.");
            System.out.println("[4] Eliminar un producto de la tienda.");
            System.out.println("[5] Añadir un empleado a la tienda.");
            System.out.println("[6] Eliminar un empleado de la tienda.");
            System.out.println("[7] Añadir un cliente.");
            System.out.println("[8] Eliminar un cliente.");
            System.out.println("[9] Crear una copia de seguridad.");
            System.out.println("[10] Leer los titulares del periódico El País.");
            System.out.print("[0] Salir del programa.");
            System.out.println("\n<-------------------------------------->\n");
            
            System.out.println("Introduce el número de la opción del menú:");
            
            boolean control = false;
            boolean control2 = false;
            boolean control3 = true;
            String opcion = teclado.nextLine();
            switch(opcion){                        
                case "1":
                    System.out.println("Introduce el nombre de la nueva tienda:");

                    nombre = teclado.nextLine();
                        if(!empresa.getTiendas().isEmpty()){
                            for(i=0;i<empresa.getTiendas().size();i++){
                                if(empresa.getTiendas().get(i).getNombre().equalsIgnoreCase(nombre)){
                                    System.out.println("¡Esa tienda ya existe!");
                                    System.out.println("Redirigiendo al menú...");
                                    control=true;
                                }                            
                            }
                            if(control==false){
                                System.out.println("Introduce la ciudad en la que se encuentra la tienda:");
                                ciudad = teclado.nextLine();
                                empresa.getTiendas().add(new Tiendas(nombre,ciudad));
                                System.out.println("¡Tienda añadida correctamente!");
                                System.out.println("Redirigiendo al menú...");
                            }
                        }                
                        else{
                            System.out.println("Introduce la ciudad en la que se encuentra la tienda:");
                            ciudad = teclado.nextLine();
                            empresa.getTiendas().add(new Tiendas(nombre,ciudad));
                            System.out.println("¡Tienda añadida correctamente!");
                            System.out.println("Redirigiendo al menú...");
                        }                    
                    break;

                case "2":
                    if(empresa.getTiendas().isEmpty()){
                        System.out.println("No hay tiendas para eliminar. Serás redirigido al menú.\n");
                        break;
                    }
                    System.out.println("Introduce el nombre de la tienda a eliminar:");
                    nombre = teclado.nextLine();

                    for(i=0;i<empresa.getTiendas().size();i++){
                        if(empresa.getTiendas().get(i).getNombre().equalsIgnoreCase(nombre)){
                            empresa.getTiendas().remove(i);                            
                            control = true;
                        }
                    } 
                    if(control==true){
                        System.out.println("!Tienda eliminada correctamente¡");
                        System.out.println("Redirigiendo al menú...");
                        break;
                    }
                    else{
                        System.out.println("La tienda introducida no existe.");
                        System.out.println("Redirigiendo al menú...");
                    }
                    break;

                case "3":
                    if(empresa.getTiendas().isEmpty()){
                        System.out.println("No existe ninguna tienda para añadir productos.");
                        System.out.println("Redirigiendo al menú...");
                        break;
                    }
                    System.out.println("Introduce el nombre de la tienda a la que añadirás el producto:");
                    nombre = teclado.nextLine();
                    for(i=0;i<empresa.getTiendas().size();i++){
                        if(empresa.getTiendas().get(i).getNombre().equalsIgnoreCase(nombre)){  
                            System.out.println("Introduce el código identificador del nuevo producto:");
                            codigoId = teclado.nextLine();
                            control2=true;
                            if(!empresa.getTiendas().get(i).getProductos().isEmpty()){
                                for(c=0;c<empresa.getTiendas().get(i).getProductos().size();c++){
                                    if(empresa.getTiendas().get(i).getProductos().get(c).getCodigoId().equalsIgnoreCase(codigoId)){
                                        System.out.println("El producto que desea añadir ya existe.");
                                        control = true;
                                    }
                                }                                   
                            }                                                                                   
                            if (control==false){
                                System.out.println("Introduce una descripción para el producto:");
                                descripcion = teclado.nextLine();
                                System.out.println("Introduce el precio del producto:");
                                precio = teclado.nextDouble();
                                System.out.println("Introduce la cantidad del producto:");
                                cantidad = teclado.nextInt();
                                System.out.println("Se va a añadir el producto a la tienda: -"+empresa.getTiendas().get(i).getNombre()+"-");
                                empresa.getTiendas().get(i).getProductos().add(new Productos(codigoId,descripcion,precio,cantidad));
                            }
                        }                        
                    }
                    if (control2==false){
                        System.out.println("La tienda introducida no existe.");
                        System.out.println("Redirigiendo al menú...");
                        control=true;
                        } 
                    if(control==false){
                        System.out.println("¡Producto añadido correctamente!");
                        System.out.println("Redirigiendo al menú...");
                        break;
                    }
                    else if(control==true){
                        System.out.println("Redirigiendo al menú...");
                        break;
                    }                                  
                    

                case "4":
                    if(empresa.getTiendas().isEmpty()){
                        System.out.println("No hay tiendas para eliminar productos.");
                        System.out.println("Redirigiendo al menú...");
                        break;
                    }
                    System.out.println("Introduce la tienda de la que quiera eliminar el producto:");
                    nombre = teclado.nextLine();
                       
                    for(i=0;i<empresa.getTiendas().size();i++){
                        if(empresa.getTiendas().get(i).getNombre().equalsIgnoreCase(nombre) && !empresa.getTiendas().get(i).getProductos().isEmpty()){
                            System.out.println("Introduce el identificador del producto que desea eliminar:");
                            codigoId = teclado.nextLine();
                            control2=true;
                            c = i;
                            for(i = 0;i<empresa.getTiendas().get(c).getProductos().size();i++){
                                if(empresa.getTiendas().get(c).getProductos().get(i).getCodigoId().equalsIgnoreCase(codigoId)){
                                    empresa.getTiendas().get(c).getProductos().remove(i);
                                    System.out.println("¡Producto eliminado correctamente!");
                                    control = true;
                                }
                            }           
                        }                        
                    }
                    if(control2==false){
                            System.out.println("La tienda introducida no existe o no tiene productos.");
                            control=true;
                    }                    
                    if(control==true){
                        System.out.println("Redirigiendo al menú...");
                        break;
                    }
                    else{
                        System.out.println("No se encuentra el producto en la tienda.");
                        System.out.println("Redirigiendo al menú...");
                        break;
                    }

                case "5":
                    if(empresa.getTiendas().isEmpty()){
                        System.out.println("No hay tiendas para añadir empleados.");
                        System.out.println("Redirigiendo al menú...");
                        break;
                    }
                    System.out.println("Introduce el nombre de la tienda a la que se añadirá el empleado:");
                    nombre = teclado.nextLine();                                                            
                    for(i=0;i<empresa.getTiendas().size();i++){
                        if(empresa.getTiendas().get(i).getNombre().equalsIgnoreCase(nombre)){
                            System.out.println("Introduce el nombre del empleado:");
                            nombre = teclado.nextLine();
                            System.out.println("Introduce los apellidos del empleado:");
                            apellidos = teclado.nextLine();
                            c = i;
                            if(!empresa.getTiendas().get(c).getEmpleados().isEmpty()){
                                for(i = 0;i<empresa.getTiendas().get(c).getEmpleados().size();i++){
                                    if(empresa.getTiendas().get(c).getEmpleados().get(i).getNombre().equalsIgnoreCase(nombre) 
                                    && empresa.getTiendas().get(c).getEmpleados().get(i).getApellidos().equalsIgnoreCase(apellidos)){
                                    control3=false;
                                    break;    
                                    }
                                    else{
                                        control3=true;
                                    }
                                }
                                if(control3==true){
                                        empresa.getTiendas().get(c).getEmpleados().add(new Empleados(nombre,apellidos));
                                        System.out.println("¡Empleado añadido correctamente!");
                                        control = true;
                                        control2=true;
                                        break;
                                    }
                                else{
                                        System.out.println("El empleado ya está en la tienda.");
                                        control = true;
                                        control2=true;
                                        break;  
                                }
                            }
                            else{
                                empresa.getTiendas().get(c).getEmpleados().add(new Empleados(nombre,apellidos));
                                System.out.println("¡Empleado añadido correctamente!");
                                control = true;
                                control2=true;
                                break;
                            }
                            
                        }
                    }
                    if (control2==false){
                        System.out.println("La tienda introducida no existe.");
                        System.out.println("Redirigiendo al menú...");                      
                        break;
                    }
                    if(control==true){
                        System.out.println("Redirigiendo al menú...");
                        break;
                    }

                case "6":
                    if(empresa.getTiendas().isEmpty()){
                        System.out.println("No hay tiendas para eliminar empleados.");
                        System.out.println("Redirigiendo al menú...");
                        break;
                    }
                    System.out.println("Introduce la tienda de la que quiera dar de baja el empleado:");
                    nombre = teclado.nextLine();
                       
                    for(i=0;i<empresa.getTiendas().size();i++){
                        if(empresa.getTiendas().get(i).getNombre().equalsIgnoreCase(nombre) && !empresa.getTiendas().get(i).getEmpleados().isEmpty()){
                            System.out.println("Introduce el nombre del empleado:");
                            nombre = teclado.nextLine();
                            System.out.println("Introduce los apellidos del empleado:");
                            apellidos = teclado.nextLine();
                            control2=true;
                            c = i;
                                for(i = 0;i<empresa.getTiendas().get(c).getEmpleados().size();i++){
                                if(empresa.getTiendas().get(c).getEmpleados().get(i).getNombre().equalsIgnoreCase(nombre) && empresa.getTiendas().get(c).getEmpleados().get(i).getApellidos().equalsIgnoreCase(apellidos)){
                                    empresa.getTiendas().get(c).getEmpleados().remove(i);
                                    System.out.println("¡Se ha dado de baja al empleado correctamente!");
                                    control = true;
                                    break;
                                }
                            }           
                        }                        
                    }
                    if(control2==false){
                            System.out.println("La tienda introducida no existe o no tiene empleados.");
                            control=true;
                    }                    
                    if(control==true){
                        System.out.println("Redirigiendo al menú...");
                        break;
                    }
                    else{
                        System.out.println("No se encuentra el empleado en la tienda.");
                        System.out.println("Redirigiendo al menú...");
                        break;
                    }

                case "7":                  
                    System.out.println("Introduce el nombre del nuevo cliente:");
                    nombre = teclado.nextLine();
                    System.out.println("Introduce los apellidos del cliente:");
                    apellidos = teclado.nextLine();
                    System.out.println("Introduce el correo electrónico del cliente:");
                    email = teclado.nextLine();
                    for(i = 0;i<empresa.getClientes().size();i++){
                        if(empresa.getClientes().get(i).getEmail().equalsIgnoreCase(email)){
                            System.out.println("El cliente ya existe.");
                            control = true;
                        }
                    }
                    if(control==true){
                        System.out.println("Redirigiendo al menú...");
                    }
                    else{
                        empresa.getClientes().add(new Clientes(nombre,apellidos,email));
                        System.out.println("¡Cliente creado correctamente!");
                        System.out.println("Redirigiendo al menú...");
                    }
                    break;

                case "8":
                    if(empresa.getClientes().isEmpty()){
                        System.out.println("No hay cliente para eliminar.");
                        break;
                    }
                    System.out.println("Introduce el email del cliente a eliminar:");
                    email = teclado.nextLine();

                    for(i = 0;i<empresa.getClientes().size();i++){
                        if(empresa.getClientes().get(i).getEmail().equalsIgnoreCase(email)){
                            empresa.getClientes().remove(i);                                                        
                            System.out.println("¡Cliente eliminado correctamente!");
                            System.out.println("Redirigiendo al menú...");
                            control = true;
                            break;
                        }

                    } 
                    if(control==true){
                        break;
                    }
                    else{
                        System.out.println("El cliente introducido no existe.");
                        System.out.println("Redirigiendo al menú...");
                        break;
                    }

                case "9":
                    File ficheroOrigen = new File("data.json");
                    File ficheroDestino = new File("data.backup");
                    if (ficheroOrigen.exists()) {                       
                            FileReader flr = new FileReader(ficheroOrigen);

                            BufferedReader br = new BufferedReader(flr);
                           
                            String linea;
                                                        
                            FileWriter flw = new FileWriter(ficheroDestino);
                            BufferedWriter bw = new BufferedWriter(flw);
                            
                            while ((linea=br.readLine()) != null) {
                                bw.append(linea);
                            }
                            
                            br.close();                                                                                    
                            bw.close();
                            System.out.println("¡Copia de seguridad creada correctamente!");
                            System.out.println("Serás redirigido al menú...");
                           
                    }
                    else{
                        System.out.println("No existe ningún fichero del que realizar la copia de seguridad.");
                        System.out.println("Serás redirigido al menú...");
                    }
                    break;
                    
                case "10":
                    XMLReader procesadorXML = null;
                    try {
                        System.out.println("\n");
                        /*Creamos un parseador de texto nuestra clase que se va a encargar
                        de parsear el texto.*/
                        procesadorXML = XMLReaderFactory.createXMLReader();
                        TitularesXML titularesXML = new TitularesXML();
                        procesadorXML.setContentHandler(titularesXML);

                        //Indicamos donde están guardados los titulares.
                        InputSource archivo = new InputSource("http://ep00.epimg.net/rss/elpais/portada.xml");
                        procesadorXML.parse(archivo);

                        //Imprimimos los datos que se han leido del XML.
                        ArrayList<Titular> titulares = titularesXML.getTitulares();
                        for(i=0;i<titulares.size();i++){
                            Titular tituloAux = titulares.get(i);
                            int n=i+1;
                            System.out.println("Titular "+n+": "+ tituloAux.getTitular());
                        }

                    } 
                    catch (SAXException e) {
                        System.out.println("No existe el fichero para realizar la copia de seguridad.");
                    } 
                    catch (IOException e) {
                        System.out.println("Ha ocurrido un error al leer el archivo XML.");
                    }
                    System.out.println("\nPulsa intro para salir de esta sección.");
                    teclado.nextLine();
                    break;
                    
                case "0":
                    System.out.println("El programa será cerrado... ¡Vuelve pronto!");
                    cierre=true;
                    break;
                default:
                    System.out.println("\n¡Error! El valor introducido debe estar entre el 0 y el 10.\n");
                                        
            }   
            
        }    
    }
    //Método encargado de leer el fichero Json.
    public static void leerJson(){
        //Comenzamos declarando el fichero.
        File fichero = new File("data.json");
        if(fichero.exists()){
            try {
                //Creamos el flujo de lectura del fichero.
                FileReader flr = new FileReader(fichero);

                //Creamos el buffer de lectura.
                BufferedReader br = new BufferedReader(flr);

                
                StringBuilder jsonBuilder = new StringBuilder();
                String linea;
                //Se lee línea a línea el fichero json.
                while ((linea=br.readLine()) != null) {
                    System.out.println(linea);
                    jsonBuilder.append(linea).append("\n");
                }

                //Se cierra el archivo.
                br.close();

                //Creamos una variable de tipo String para almacenar todas las líneas leídas.
                String json = jsonBuilder.toString();

                //Pasamos el json a la clase con la cual se corresponde.
                Gson gson = new Gson();
                empresa = gson.fromJson(json, Empresa.class);
                
                
            } 
            catch (FileNotFoundException e) {
                System.out.println("No se encuentra el archivo.");
            } 
            catch (IOException e) {
                System.out.println("Error de tipo E/S");
            }
        }    
        
    }
    
    public static void escribirJson(){
        //Pasamos nuestra clase a JSON utilizando la libreria GSON.
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(empresa);
                
        //Comenzamos declarando el fichero json.
        File fichero = new File("data.json");

        try {
            //Creamos el flujo de escritura del fichero.
            FileWriter flw = new FileWriter(fichero);
            //Creamos el buffer de escritura.
            BufferedWriter bw = new BufferedWriter(flw);
            //Escribimos el fichero json.
            bw.write(json);
            //Cerramos el fichero.
            bw.close();
        }
        catch (IOException e) {
            System.out.println("Error de tipo E/S");
        }                        
    }
}

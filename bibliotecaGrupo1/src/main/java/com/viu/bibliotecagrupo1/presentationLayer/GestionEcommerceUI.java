package com.viu.bibliotecagrupo1.presentationLayer;
import com.viu.bibliotecagrupo1.businessLayer.gestionEcommerce;
import com.viu.bibliotecagrupo1.entitiyLayer.Venta;
import java.util.List;

import java.util.Scanner;

/**
 *
 * @author kmccallum <Kathleen_McCallum VIU>
 */
public class GestionEcommerceUI {
        private final Scanner scanner;

    public GestionEcommerceUI() {
        this.scanner = new Scanner(System.in);
    }
    
    public void mostrarMenu() {
        while (true) {
            System.out.println("\n=== E-commerce, para comprar y vender libros ===");
            System.out.println("0. Listar Ventas");
            System.out.println("1. Consultar Venta");
            System.out.println("2. Nueva Venta");
            System.out.println("5. Volver al menú principal");
            System.out.print("\nSeleccione una opción: ");

            String opcion = scanner.nextLine();
            switch (opcion) {
                case "0":
                    listarVentas();
                    break;
                case "1":
                    consultarVenta();
                    break;
                case "2":
                    //();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
    
     private void listarVentas() {
        gestionEcommerce gestVen = new gestionEcommerce();
        List<Venta> listaVen = gestVen.ListarVentas();
        
        for(Venta ven : listaVen ){
            System.out.println(ven.toString());
        }
        
    }
    
     private void consultarVenta() {
        System.out.println("\n=== Consulta de ventas realizadas ===");
        
        System.out.print("Introducir numero de venta: ");
        String numventa = scanner.nextLine();
        
        try{
            gestionEcommerce gestVen = new gestionEcommerce();
            List<Venta> ventaLib = gestVen.consultaVenta( Integer.parseInt(numventa));
            int firstOnly = 0;
            for(Venta ven : ventaLib ){
                if (firstOnly ==0){
                    System.out.print("\nVenta id: "+ ven.getVentaid());
                    System.out.print(", Fecha Venta: "+ ven.getFechaVenta().toString());
                    System.out.print(", Usuario id: "+ ven.getUsuarioid());
                    System.out.println(", Monto Factura: "+ ven.getValorTotal());
                }
                firstOnly=1;
                System.out.print("Item id: "+ ven.getItemid());
                System.out.print(", Libro id: "+ ven.getLibroid());
                System.out.println(", Valor Libro: "+ ven.getPrecioVentaLibroitem() );
            }
         }catch (NumberFormatException e) {
            System.out.println("Error en id de venta : " + e.getMessage());
        }catch (Exception e) {
            System.out.println("Error al buscar venta: " + e.getMessage());
       
        
    }
        
   // private void venderLibro() {
     //   gestionEcommerce gestVen = new gestionEcommerce();
        /*
        System.out.println("\n=== Venta de libros de la Biblioteca ===");
        
        System.out.print("Buscar libro que no este en pretamo: ");
        String venta = scanner.nextLine();
        
        try {
            List<Venta> listaVen = gestVen.nuevaVenta();
            gestionLibros gestLib = new gestionLibros(titulo, isbn, genero, nombreAutor, apellidosAutor);
            Libro libNuevo;
            
            if (gestLib.validaLibro()){
                libNuevo = gestLib.InsertarLibro();  
                if (libNuevo != null)
                    System.out.println("Libro agregado con éxito.");
                else
                    System.out.println("No se guardo el libro, fallo al guardar");
            }
            else{
                System.out.println("Validacion con errores, porfavor verifique");
            }
                
            //System.out.println("Libro agregado con éxito.");
        } catch (Exception e) {
            System.out.println("Error al agregar el libro: " + e.getMessage());
        }
        */
        
    } 
        
}

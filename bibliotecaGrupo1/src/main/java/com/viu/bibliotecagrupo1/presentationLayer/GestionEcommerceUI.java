package com.viu.bibliotecagrupo1.presentationLayer;
import com.viu.bibliotecagrupo1.businessLayer.gestionEcommerce;
import com.viu.bibliotecagrupo1.businessLayer.gestionLibros;
import com.viu.bibliotecagrupo1.entitiyLayer.Libro;
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
                    venderLibro();
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
     }
        
    private void venderLibro() {
        System.out.println("\n=== Venta de libros de la Biblioteca ===");
        // la idea es buscar el libro e ir añadiendo al pedido
       // System.out.print("Buscar libro que no este en pretamo: ");
        try {
            System.out.print("Usuario Id: ");
            String usuarioId = scanner.nextLine();
            
            int librosid[] = new int[5];
            float precioVenta[] = new float[5];
            int contadorLibros = 0;
            String opcion = "s";
            boolean pregunto = true;
            while (pregunto ) {
                System.out.print("Añadir Libro? (maximo 5)");
                System.out.println("S (si) / N (no)" );
                opcion = scanner.nextLine();
                
                // aqui falta validar que el libro no este en alquiler
                switch (opcion.toLowerCase()) {
                    case "s" -> {
                        if (contadorLibros==5){
                            pregunto=false;
                            break;
                        }else{
                            System.out.print("Introdusca el ISBN del libro: ");
                            String libroid = scanner.nextLine();
                            gestionLibros gestLib = new gestionLibros();
                            System.out.println("Realizando búsqueda...");
                            Libro libroFound = gestLib.BuscarLibro("3", libroid); // buscar por ISBN opcion 3
                            if (libroFound!=null){
                                System.out.print("Precio venta libro: ");
                                float precioVentaind = scanner.nextFloat();

                                librosid[contadorLibros] = libroFound.getLibroId();
                                precioVenta[contadorLibros] = precioVentaind;
                                System.out.println("libro encontrado ");
                                contadorLibros ++;  

                            }else
                               System.out.println("Libro no encotrado"); 
                            break;
                        }
                    }
                    case "n" -> {
                        pregunto=false;
                        System.out.println("Listo, venta en marcha"); 
                        break;
                    }
                    //default -> System.out.println("Opción no válida");
                }
            }
            System.out.println("contador libros: " + contadorLibros); 
            // solo hago venta si hay algun libro :)
            if (contadorLibros >0){
                gestionEcommerce gestVen = new gestionEcommerce();

                // calculo monto total, inserto venta, y luego inserto libros
                if (gestVen.validaVenta(contadorLibros, librosid, precioVenta)){
                    Venta laventa = gestVen.creaVenta(contadorLibros, librosid, precioVenta);
                    if (laventa!= null)
                        System.out.println("Venta con id " +laventa.getVentaid() + " realizada con éxito." );
                    else
                        System.out.println("No se guardo la venta, fallo al guardar");
                }
            }
            else
               System.out.println("Venta no realizada."); 
        } catch (Exception e) {
            System.out.println("Error al crear la venta: " + e.getMessage());
        }       
    } 
        
}

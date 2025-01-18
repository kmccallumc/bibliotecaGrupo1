// GestionLibrosUI.java
package com.viu.bibliotecagrupo1.presentationLayer;


import com.viu.bibliotecagrupo1.businessLayer.gestionLibros;
import com.viu.bibliotecagrupo1.entitiyLayer.Libro;

import java.util.Scanner;

public class GestionLibrosUI {
    private final Scanner scanner;

    public GestionLibrosUI() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        while (true) {
            System.out.println("\n=== Gestión de Libros ===");
            System.out.println("1. Agregar libro");
            System.out.println("2. Buscar libro");
            System.out.println("3. Actualizar libro");
            System.out.println("4. Eliminar libro");
            System.out.println("5. Volver al menú principal");
            System.out.print("\nSeleccione una opción: ");

            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    agregarLibro();
                    break;
                case "2":
                    buscarLibro();
                    break;
                case "3":
                    actualizarLibro();
                    break;
                case "4":
                    eliminarLibro();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private void agregarLibro() {
        System.out.println("\n=== Agregar Nuevo Libro ===");
        
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        
        System.out.print("Género: ");
        String genero = scanner.nextLine();
        
        System.out.println("\nDatos del autor:");
        System.out.print("Nombre: ");
        String nombreAutor = scanner.nextLine();
        System.out.print("Apellidos: ");
        String apellidosAutor = scanner.nextLine();
        
        try {
            gestionLibros gestLib = new gestionLibros(titulo, isbn, genero, nombreAutor, apellidosAutor);
            Libro libNuevo;
            
            if (gestLib.validaLibro()){
                libNuevo = gestLib.GuardaLibro();  
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
    }

    private void buscarLibro() {
        System.out.println("\n=== Buscar Libro ===");
        System.out.println("1. Buscar por título");
        System.out.println("2. Buscar por autor");
        System.out.println("3. Buscar por ISBN");
        System.out.print("Seleccione criterio de búsqueda: ");
        
        String opcion = scanner.nextLine();
        System.out.print("Introduzca el término de búsqueda: ");
        String termino = scanner.nextLine();
        
        // Llamada al servicio de la capa de negocio
        gestionLibros gestLib = new gestionLibros();
        System.out.println("Realizando búsqueda...");
        Libro libroFound = gestLib.BuscarLibro(opcion, termino);
        // FALTA IMPRIMIR
        System.out.println(libroFound.toString());
        
    }

    private void actualizarLibro() {
        System.out.println("\n=== Actualizar Libro ===");
        System.out.print("Introduzca el ISBN del libro a actualizar: ");
        String isbn = scanner.nextLine();
        
        // Se buscaría el libro y luego se permitiría su actualización
        System.out.println("Introduzca los nuevos datos (deje en blanco para mantener el valor actual):");
        
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        
        System.out.print("Género: ");
        String genero = scanner.nextLine();
        
        // Llamada al servicio de la capa de negocio
        System.out.println("Libro actualizado con éxito.");
    }

    private void eliminarLibro() {
        System.out.println("\n=== Eliminar Libro ===");
        System.out.print("Introduzca el ISBN del libro a eliminar: ");
        String isbn = scanner.nextLine();
        
        System.out.print("¿Está seguro? (S/N): ");
        if (scanner.nextLine().equalsIgnoreCase("S")) {
            // Llamada al servicio de la capa de negocio
            System.out.println("Libro eliminado con éxito.");
        } else {
            System.out.println("Operación cancelada.");
        }
    }
}

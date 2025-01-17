// MenuPrincipal.java
package com.viu.bibliotecagrupo1.presentationLayer;

import java.util.Scanner;

/**
 * Clase que representa a un autor de libros en el sistema de biblioteca
 * @author kmccallum <Kathleen_McCallum VIU>
 */

public class MenuPrincipal {
    private final GestionLibrosUI gestionLibrosUI;
    private final GestionUsuariosUI gestionUsuariosUI;
    private final Scanner scanner;

    public MenuPrincipal() {
        this.gestionLibrosUI = new GestionLibrosUI();
        this.gestionUsuariosUI = new GestionUsuariosUI();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        while (true) {
            System.out.println("\n=== Sistema de Gestión de Biblioteca ===");
            System.out.println("1. Gestión de Libros");
            System.out.println("2. Gestión de Usuarios");
            System.out.println("3. Salir");
            System.out.print("\nSeleccione una opción: ");

            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    gestionLibrosUI.mostrarMenu();
                    break;
                case "2":
                    gestionUsuariosUI.mostrarMenu();
                    break;
                case "3":
                    System.out.println("¡Hasta pronto!");
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}

// GestionLibrosUI.java
package com.viu.bibliotecagrupo1.presentationLayer;

import com.viu.bibliotecagrupo1.entitiyLayer.Libro;
import com.viu.bibliotecagrupo1.entitiyLayer.Autor;
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
            Autor autor = new Autor(nombreAutor, apellidosAutor);
            Libro libro = new Libro(titulo, autor, isbn, genero);
            System.out.println("Libro agregado con éxito.");
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
        System.out.println("Realizando búsqueda...");
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

// GestionUsuariosUI.java
package com.viu.bibliotecagrupo1.presentationLayer;

import java.util.Scanner;

public class GestionUsuariosUI {
    private final Scanner scanner;

    public GestionUsuariosUI() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        while (true) {
            System.out.println("\n=== Gestión de Usuarios ===");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Buscar usuario");
            System.out.println("3. Actualizar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("5. Volver al menú principal");
            System.out.print("\nSeleccione una opción: ");

            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    registrarUsuario();
                    break;
                case "2":
                    buscarUsuario();
                    break;
                case "3":
                    actualizarUsuario();
                    break;
                case "4":
                    eliminarUsuario();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private void registrarUsuario() {
        System.out.println("\n=== Registrar Nuevo Usuario ===");
        try {
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            
            System.out.print("Apellidos: ");
            String apellidos = scanner.nextLine();
            
            System.out.print("DNI: ");
            String dni = scanner.nextLine();
            
            System.out.print("Email: ");
            String email = scanner.nextLine();
            
            // Llamada al servicio de la capa de negocio
            System.out.println("Usuario registrado con éxito.");
        } catch (Exception e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
        }
    }

    private void buscarUsuario() {
        System.out.println("\n=== Buscar Usuario ===");
        System.out.print("Introduzca el DNI del usuario: ");
        String dni = scanner.nextLine();
        
        // Llamada al servicio de la capa de negocio
        System.out.println("Realizando búsqueda...");
    }

    private void actualizarUsuario() {
        System.out.println("\n=== Actualizar Usuario ===");
        System.out.print("Introduzca el DNI del usuario a actualizar: ");
        String dni = scanner.nextLine();
        
        System.out.println("Introduzca los nuevos datos (deje en blanco para mantener el valor actual):");
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        // Llamada al servicio de la capa de negocio
        System.out.println("Usuario actualizado con éxito.");
    }

    private void eliminarUsuario() {
        System.out.println("\n=== Eliminar Usuario ===");
        System.out.print("Introduzca el DNI del usuario a eliminar: ");
        String dni = scanner.nextLine();
        
        System.out.print("¿Está seguro? (S/N): ");
        if (scanner.nextLine().equalsIgnoreCase("S")) {
            // Llamada al servicio de la capa de negocio
            System.out.println("Usuario eliminado con éxito.");
        } else {
            System.out.println("Operación cancelada.");
        }
    }
}

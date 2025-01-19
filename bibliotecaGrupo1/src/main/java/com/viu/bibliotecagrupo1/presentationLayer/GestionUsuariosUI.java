package com.viu.bibliotecagrupo1.presentationLayer;

import com.viu.bibliotecagrupo1.businessLayer.gestionUsuario;
import com.viu.bibliotecagrupo1.entitiyLayer.Usuario;
import java.util.List;

import java.util.Scanner;

public class GestionUsuariosUI {
    private final Scanner scanner;

    public GestionUsuariosUI() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        while (true) {
            System.out.println("\n=== Gestión de Usuarios ===");
            System.out.println("0. Listar usuarios");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Buscar usuario");
            System.out.println("3. Actualizar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("5. Volver al menú principal");
            System.out.print("\nSeleccione una opción: ");

            String opcion = scanner.nextLine();
            switch (opcion) {
                case "0":
                    listarUsuarios();
                    break;
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

        private void listarUsuarios() {
        gestionUsuario gestUsu = new gestionUsuario();
        List<Usuario> listaUsu = gestUsu.ListarUsuarios();
        
        for(Usuario usu : listaUsu ){
            System.out.println(usu.toString());
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

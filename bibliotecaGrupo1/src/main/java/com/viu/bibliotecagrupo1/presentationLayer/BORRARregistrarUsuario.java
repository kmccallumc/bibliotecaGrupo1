package com.viu.bibliotecagrupo1.presentationLayer;

import com.viu.bibliotecagrupo1.entitiyLayer.Usuario;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Date;

/**
 * Clase que representa a un autor de libros en el sistema de biblioteca
 * @author kmccallum <Kathleen_McCallum VIU>
 */

public class BORRARregistrarUsuario {
    private final Scanner scanner;
    private static int ultimoId = 0;
    
    public BORRARregistrarUsuario() {
        this.scanner = new Scanner(System.in);
    }
    
    public void iniciarRegistro() {
        System.out.println("\n=== Registro de Nuevo Usuario ===");
        
        try {
            // Recoger datos obligatorios
            String nombre = solicitarDato("Nombre");
            String apellidos = solicitarDato("Apellidos");
            String dni = solicitarDNI();
            String email = solicitarEmail();
            
            System.out.println("\nDatos opcionales (presione Enter para omitir):");
            String telefono = solicitarDatoOpcional("Teléfono");
            String direccion = solicitarDatoOpcional("Dirección");
            
            // Crear el usuario
            Usuario nuevoUsuario = new Usuario(0,nombre,apellidos,dni,email,telefono,direccion, new Date(), 1,0);
            
            // Mostrar resumen del registro
            mostrarResumenRegistro(nuevoUsuario);
            
            if (confirmarRegistro()) {
                // Aquí iría la lógica para guardar el usuario
                System.out.println("Usuario registrado con éxito.");
            } else {
                System.out.println("Registro cancelado.");
            }
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error en el registro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
    
    private String solicitarDato(String nombreDato) {
        String dato;
        do {
            System.out.print(nombreDato + ": ");
            dato = scanner.nextLine().trim();
            if (dato.isEmpty()) {
                System.out.println("El " + nombreDato + " es obligatorio. Por favor, inténtelo de nuevo.");
            }
        } while (dato.isEmpty());
        return dato;
    }
    
    private String solicitarDatoOpcional(String nombreDato) {
        System.out.print(nombreDato + " (opcional): ");
        return scanner.nextLine().trim();
    }
    
    private String solicitarDNI() {
        String dni;
        Pattern dniPattern = Pattern.compile("^[0-9]{8}[A-Z]$");
        
        do {
            System.out.print("DNI (formato: 12345678A): ");
            dni = scanner.nextLine().trim().toUpperCase();
            
            if (!dniPattern.matcher(dni).matches()) {
                System.out.println("DNI no válido. Debe tener 8 números seguidos de una letra mayúscula.");
            }
        } while (!dniPattern.matcher(dni).matches());
        
        return dni;
    }
    
    private String solicitarEmail() {
        String email;
        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
        
        do {
            System.out.print("Email: ");
            email = scanner.nextLine().trim();
            
            if (!emailPattern.matcher(email).matches()) {
                System.out.println("Email no válido. Por favor, introduzca un email válido.");
            }
        } while (!emailPattern.matcher(email).matches());
        
        return email;
    }
    
    private void mostrarResumenRegistro(Usuario usuario) {
        System.out.println("\n=== Resumen del Registro ===");
        System.out.println("ID: " + usuario.getId());
        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("Apellidos: " + usuario.getApellidos());
        System.out.println("DNI: " + usuario.getDNI());
        System.out.println("Email: " + usuario.getEmail());
        System.out.println("Teléfono: " + (usuario.getTelefono().isEmpty() ? "No especificado" : usuario.getTelefono()));
        System.out.println("Dirección: " + (usuario.getDireccion().isEmpty() ? "No especificada" : usuario.getDireccion()));
    }
    
    private boolean confirmarRegistro() {
        System.out.print("\n¿Confirmar registro? (S/N): ");
        String respuesta = scanner.nextLine().trim().toUpperCase();
        return respuesta.equals("S");
    }
}

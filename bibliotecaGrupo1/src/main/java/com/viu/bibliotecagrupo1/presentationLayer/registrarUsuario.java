/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viu.bibliotecagrupo1.presentationLayer;

import com.viu.bibliotecagrupo1.entitiyLayer.Usuario;
//import com.viu.bibliotecagrupo1.businessLayer.GestionUsuarios;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Clase que maneja la interfaz de registro de usuarios
 * @author kmccallum <Kathleen_McCallum VIU>
 */
public class registrarUsuario {
    //private final GestionUsuarios gestionUsuarios;
    private final Scanner scanner;
    
    /**
     * Constructor de la clase
     */
    public registrarUsuario() {
        //this.gestionUsuarios = new GestionUsuarios();
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * Inicia el proceso de registro de un nuievo usuario
     */
    public void iniciarRegistro() {
        System.out.println("\n=== Registro de Nuevo Usuario ===");
      
        // KMC : he comentado el codigo para poder compilar
    /*    try {
            // Recoger datos obligatorios
            String nombre = solicitarDato("Nombre");
            String apellidos = solicitarDato("Apellidos");
            String dni = solicitarDNI();
            String email = solicitarEmail();
            
            System.out.println("\nDatos opcionales (presione Enter para omitir):");
            String telefono = solicitarDatoOpcional("Teléfono");
            String direccion = solicitarDatoOpcional("Dirección");
            
            // Crear el usuariuio
            Usuario nuevoUsuario = new Usuario(
                generarNuevoId(),
                nombre,
                apellidos,
                dni,
                email,
                telefono,
                direccion
            )catch
                    
      */
    }
}

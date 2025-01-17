
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

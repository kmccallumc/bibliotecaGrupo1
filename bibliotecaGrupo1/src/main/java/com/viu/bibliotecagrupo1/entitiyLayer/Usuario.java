/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viu.bibliotecagrupo1.entitiyLayer;

import java.util.Date;
import java.util.Objects;

/**
 * Clase que representa a un usuario del sistema de biblioteca
 * @author kmccallum <Kathleen_McCallum VIU>
 */
public class Usuario {
    private int id;
    private String nombre;
    private String apellidos;
    private String dni;
    private String email;
    private String telefono;
    private String direccion;
    private Date fechaAlta;
    private boolean activo;
    private int numeroPrestamosPendientes;
    private static final int MAX_PRESTAMOS = 3;

    /* no se cuanto poner de max de prestamo?? 3? 4?     */
    public Usuario(int id, String nombre, String apellidos, String dni, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.email = email;
        this.fechaAlta = new Date();
        this.activo = true;
        this.numeroPrestamosPendientes = 0;
    }

 // Getters y Setters
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

   public String getDNI() {
        return this.dni;
    }
    
    public void setDNI(String dni) {
        this.dni = dni;
    }   
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }   
    
    public Date getFechanAlta() {
        return this.fechaAlta;
    }
    
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }   
    
    public boolean getActivo() {
        return this.activo;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public int getNumeroPrestamosPendientes() {
        return this.numeroPrestamosPendientes;
    }
    
    public void setNumeroPrestamosPendientes(int numeroPrestamosPendientes) {
        this.numeroPrestamosPendientes = numeroPrestamosPendientes;
    }

}

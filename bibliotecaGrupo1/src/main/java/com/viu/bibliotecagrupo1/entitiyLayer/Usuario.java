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
    private int activo;
    private int numeroPrestamos;
    private static final int MAX_PRESTAMOS = 3;

    /* no se cuanto poner de max de prestamo?? 3? 4?     */
    public Usuario(int id, String nombre, String apellidos, String dni, String email, String telefono, String direccion, Date fechaAlta, int activo, int numeroPrestamos) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.email = email;
        this.fechaAlta = new Date();
        this.activo = 1; //1:True, 0:False
        this.numeroPrestamos = 0;
    }

 // Getters y Setters
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
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
    
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }   
    
     public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }      
    public Date getFechaAlta() {
        return this.fechaAlta;
    }
    
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }   
    
    public int getActivo() {
        return this.activo;
    }
    
    public void setActivo(int activo) {
        this.activo = activo;
    }
    
    public int getNumeroPrestamos() {
        return this.numeroPrestamos;
    }
    
    public void setNumeroPrestamos(int numeroPrestamos) {
        this.numeroPrestamos = numeroPrestamos;
    }

}

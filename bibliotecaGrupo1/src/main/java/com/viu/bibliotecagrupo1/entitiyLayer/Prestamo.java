/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viu.bibliotecagrupo1.entitiyLayer;

import java.util.Date;
/**
 *
 * @author kmccallum <Kathleen_McCallum VIU>
 */
public class Prestamo {
    private int prestamoid;
    private int autorid; 
    private int libroid;
    private Date fechaPrestamo;
    private Date fechaRetorno;
    
    public Prestamo(int prestamoid, int autorid, int libroid, Date fechaPrestamo, Date fechaRetorno) {
        this.prestamoid = prestamoid;
        this.autorid = autorid;
        this.libroid = libroid;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaRetorno = fechaRetorno;
    }
    
    // constructor sin prestamoID cuando se esta creando
    public Prestamo(int autorid, int libroid, Date fechaPrestamo, Date fechaRetorno) {
        this.autorid = autorid;
        this.libroid = libroid;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaRetorno = fechaRetorno;
    }
       
    // Getters y Setters
    public int getPrestamoId() {
        return this.prestamoid;
    }
    
    public void setPrestamoId(int prestamoid) {
        this.prestamoid = prestamoid;
    }
    
    public int getLibroId() {
        return this.libroid;
    }
    
    public void setLibroId(int libroid) {
        this.libroid = libroid;
    }
    
    public int getAutorid() {
        return this.autorid;
    }
    
    public void setAutorid(int autorid) {
        this.autorid = autorid;
    }
    
    public Date getFechaPrestamo() {
        return this.fechaPrestamo;
    }
    
    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
    
    public Date getFechaRetorno() {
        return this.fechaRetorno;
    }
    
    public void setFechaRetorno(Date fechaRetorno) {
        this.fechaRetorno = fechaRetorno;
    }
}

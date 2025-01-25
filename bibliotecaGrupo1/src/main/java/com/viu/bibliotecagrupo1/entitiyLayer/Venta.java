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
public class Venta {   
    private int ventaid;
    private Date fechaVenta;
    private Libro libros[];
    private int librosid[];
    private int libroid;
    private int itemid;
    private float precioVentaLibro[];
    private float precioVentaLibroitem;
    private Usuario usuario;
    private int usuarioid;   
    private float valorTotal;
    
 
    public Venta(){
    }
    
    // solo clase venta asociado con tabla venta
     public Venta(int ventaid, Date fechaVenta, int usuarioid, float valorTotal){
        this.ventaid = ventaid;
        this.fechaVenta=fechaVenta;
        this.usuarioid = usuarioid;
        this.valorTotal = valorTotal;
    }
     
    public Venta(int ventaid, Date fechaVenta, int usuarioid, float valorTotal, int itemid, int libroid, float precioVentaLibro){
        this.ventaid = ventaid;
        this.fechaVenta=fechaVenta;
        this.usuarioid = usuarioid;
        this.valorTotal = valorTotal;
        this.itemid = itemid;
        this.libroid = libroid;
        this.precioVentaLibroitem = precioVentaLibro;
        
    }
    
     // venta con detalle de libros
    public Venta(int ventaid, Date fechaVenta, int librosid[], float precioVentaLibro[], int usuarioid, float valorTotal){
        this.ventaid = ventaid;
        this.fechaVenta=fechaVenta;
        this.librosid = librosid;
        this.precioVentaLibro = precioVentaLibro;
        this.usuarioid = usuarioid;
        this.valorTotal = valorTotal;
    }
    
    // Getter and Setter for ventaid
    public int getVentaid() {
        return ventaid;
    }

    public void setVentaid(int ventaid) {
        this.ventaid = ventaid;
    }

    // Getter and Setter for fechaVenta
    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    // Getter and Setter for libros
    public Libro[] getLibros() {
        return libros;
    }

    public void setLibros(Libro[] libros) {
        this.libros = libros;
    }

    // Getter and Setter for librosid
    public int[] getLibrosid() {
        return librosid;
    }

    public void setLibrosid(int[] librosid) {
        this.librosid = librosid;
    }

    public int getLibroid() {
        return libroid;
    }

    public void setLibroid(int libroid) {
        this.libroid = libroid;
    }
    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    } 
    
    public float getPrecioVentaLibroitem() {
        return this.precioVentaLibroitem;
    }

    public void setPrecioVentaLibroitem(float precioVentaLibroitem) {
        this.precioVentaLibroitem = precioVentaLibroitem;
    }    

    // Getter and Setter for precioVentaLibro
    public float[] getPrecioVentaLibro() {
        return precioVentaLibro;
    }

    public void setPrecioVentaLibro(float[] precioVentaLibro) {
        this.precioVentaLibro = precioVentaLibro;
    }

    // Getter and Setter for usuario
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // Getter and Setter for usuarioid
    public int getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(int usuarioid) {
        this.usuarioid = usuarioid;
    }

    // Getter and Setter for valorTotal
    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    @Override
    public String toString() {
        return "Venta{" +
                "Venta ID='" + ventaid + '\'' +
                ",Fecha venta=" + fechaVenta.toString() +
                ", usuarioid='" + usuarioid + '\'' +
                ", valorTotal=" + valorTotal +
                '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Venta ven = (Venta) obj;
        return (ventaid==ven.ventaid);
    }
}

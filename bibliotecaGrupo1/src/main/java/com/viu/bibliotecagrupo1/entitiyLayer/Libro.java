/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viu.bibliotecagrupo1.entitiyLayer;

/**
 * @author kmccallum <Kathleen_McCallum VIU>
 */
public class Libro {
    private String titulo;
    private Autor elautor;
    private String isbn;
    private boolean disponible;
    private String genero;
    // asumimos que por ahora el libro solo tiene un autor
    
     public Libro(String titulo, Autor elautor, String isbn, String genero) {
        this.titulo = titulo;
        this.elautor = elautor;
        this.isbn = isbn;
        this.disponible = true; // los libros por defecto estan disponibles
        this.genero = genero;
    }

     public Libro(String titulo, int elautor, String isbn, boolean disponible, String genero) {
        this.titulo = titulo;
        
        this.isbn = isbn;
        this.disponible = disponible; // los libros por defecto estan disponibles
        this.genero = genero;
    }
     
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public Autor getAutor() {
        return this.elautor;
    }
    public void setAutor(Autor elautor){
        this.elautor = elautor;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn){
        this.isbn = isbn;
    }
    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
     public String getGenero() {
        return this.genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
}

package com.viu.bibliotecagrupo1.entitiyLayer;

/**
 * Clase que representa un libro en el sistema de biblioteca.
 * @author kmccallum <Kathleen_McCallum VIU>
 */
public class Libro {
    private String titulo;
    private Autor autor;
    private String isbn;
    private boolean disponible;
    private String genero;
    private int autorid; // cuando recupero de BD solo tengo el id del autor, no el objeto
    private int libroid;
    
    public Libro(String titulo, Autor autor, String isbn, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponible = true; // Los libros por defecto están disponibles
        this.genero = genero;
    }
    
    // cuando traigo la informacion de bd, no tengo el objeto autor, lo cargo aqui
    public Libro(int libroid, String titulo, String isbn, String genero, boolean disponible, int autorid) {
        this.libroid = libroid;
        this.titulo = titulo;
        //this.autor = autor;  -- autor lo completo con el set
        this.isbn = isbn;
        this.disponible = disponible;
        this.genero = genero;
        this.autorid = autorid;
    }

    public int getLibroId() {
        return this.libroid;
    }
    
    public void setLibroId(int libroid) {
        this.libroid = libroid;
    }
    
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public Autor getAutor() {
        return this.autor;
    }
    
    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
    public String getIsbn() {
        return this.isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public boolean isDisponible() {
        return this.disponible;
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
    
    public int getAutorId() {
        return this.autorid;
    }
    
    public void setAutorId(int autorid) {
        this.autorid = autorid;
    }
    
    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor=" + autor +
                ", isbn='" + isbn + '\'' +
                ", disponible=" + disponible +
                ", genero='" + genero + '\'' +
                '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Libro libro = (Libro) obj;
        return isbn.equals(libro.isbn);
    }
    
    @Override
    public int hashCode() {
        return isbn.hashCode();
    }
}

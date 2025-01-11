package com.viu.bibliotecagrupo1.entitiyLayer;

import java.util.Date;
import java.util.Objects;

/**
 * Clase que representa a un autor de libros en el sistema de biblioteca
 * @author kmccallum <Kathleen_McCallum VIU>
 */
public class Autor {
    private String nombreAutor;
    private String apellidoAutor;
    private Date fechaNacimiento;
    private String sexo;
    private String nacionalidad;
    private String biografia;
    
    /**
     * Constructor principal de la clase Autor
     * nombreAutor Nombre del autor
     * apellidoAutor Apellido del autor
     * fechaNacimiento Fecha de nacimiento del autor
     * sexo Sexo del autor (M: masculino, F: femenino, etc)
     */
    public Autor(String nombreAutor, String apellidoAutor, Date fechaNacimiento, String sexo) {
        this.nombreAutor = nombreAutor;
        this.apellidoAutor = apellidoAutor;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }
    
    /**
     * Constructor completo de la clase Autor
     * nombreAutor Nombre del autor
     * apellidoAutor Apellido del autor
     * fechaNacimiento Fecha de nacimiento del autor
     * sexo Sexo del autor
     * nacionalidad Nacionalidad del autor
     * biografia Breve biografía del autor
     */
    public Autor(String nombreAutor, String apellidoAutor, Date fechaNacimiento, 
                String sexo, String nacionalidad, String biografia) {
        this(nombreAutor, apellidoAutor, fechaNacimiento, sexo);
        this.nacionalidad = nacionalidad;
        this.biografia = biografia;
    }

    // Getters y Setters
    public String getNombreAutor() {
        return this.nombreAutor;
    }
    
    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }
    
    public String getApellidoAutor() {
        return this.apellidoAutor;
    }
    
    public void setApellidoAutor(String apellidoAutor) {
        this.apellidoAutor = apellidoAutor;
    }
    
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public String getSexo() {
        return this.sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
    
    /**
     * Obtiene el nombre completo del autor
     * return String con el nombre y apellido del autor
     */
    public String getNombreCompleto() {
        return this.nombreAutor + " " + this.apellidoAutor;
    }
    
    /**
     * Verifica si los datos básicos del autor están completos
     * return true si todos los campos básicos están completos, false en caso contrario
     */
    public boolean datosCompletos() {
        return nombreAutor != null && !nombreAutor.trim().isEmpty() &&
               apellidoAutor != null && !apellidoAutor.trim().isEmpty() &&
               fechaNacimiento != null &&
               sexo != null && !sexo.trim().isEmpty();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Autor other = (Autor) obj;
        return Objects.equals(nombreAutor, other.nombreAutor) &&
               Objects.equals(apellidoAutor, other.apellidoAutor) &&
               Objects.equals(fechaNacimiento, other.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreAutor, apellidoAutor, fechaNacimiento);
    }

    @Override
    public String toString() {
        return "Autor{" +
               "nombreAutor='" + nombreAutor + '\'' +
               ", apellidoAutor='" + apellidoAutor + '\'' +
               ", fechaNacimiento=" + fechaNacimiento +
               ", sexo='" + sexo + '\'' +
               (nacionalidad != null ? ", nacionalidad='" + nacionalidad + '\'' : "") +
               '}';
    }
}

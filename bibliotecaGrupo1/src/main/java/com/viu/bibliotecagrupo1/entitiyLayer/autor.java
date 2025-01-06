package com.viu.bibliotecagrupo1.entitiyLayer;

import java.util.Date;

/**
 *
 * @author kmccallum <Kathleen_McCallum VIU>
 */
public class autor {
    private String nombreAutor;
    private String apellidoAutor;
    private Date fechaNacimiento;
    private String sexo;
    // 
    
     public autor(String nombreAutor, String apellidoAutor, Date fechaNacimiento, String sexo) {
        this.nombreAutor = nombreAutor;
        this.apellidoAutor = apellidoAutor;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo; // M : masculino, F: Femenino, etc
    }

    public String getNombreAutor() {
        return this.nombreAutor;
    }
    
    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }
    
     public String getApelludoAutor() {
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
}
s

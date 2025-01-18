package com.viu.bibliotecagrupo1.businessLayer;
/**
 *
 * @author kmccallum <Kathleen_McCallum VIU>
 */

import com.viu.bibliotecagrupo1.entitiyLayer.Autor;
import com.viu.bibliotecagrupo1.entitiyLayer.Libro;
import com.viu.bibliotecagrupo1.resources.DBClient;
import java.util.List;

public class gestionLibros {
    
  
    private Autor autor;
    private Libro libro;
    private String nombreAutor;
    private String apellidoAutor;
   
    private int autorid; // cuando recupero de BD solo tengo el id del autor, no el objeto
    private int libroid;
    
    public gestionLibros(){
    }
    
    public gestionLibros(String titulo, String isbn, String genero, String nombreAutor, String apellidoAutor) {
         
         libro = new Libro();
         libro.setTitulo(titulo);
         libro.setIsbn(isbn);
         libro.setGenero(genero);
     
         // no creo "aun" el objeto AUtor...
         this.nombreAutor = nombreAutor;
         this.apellidoAutor = apellidoAutor;
        
    }
 
     public boolean validaLibro(){
         boolean validacion = false;
         int numValidaciones = 0;
         DBClient dbLib = new DBClient();
         
         // 1. Valido ISBN
         //Libro otroLib = (Libro)(dbLib.selectLibroISBN(libro.getIsbn())).getFirst();
         if(dbLib.selectLibroISBN(libro.getIsbn()).isEmpty()){
             numValidaciones ++;
             System.out.println("ISBN correcto, no existe");
         }
             
         // 2. Valido autor
         List aut = dbLib.selectAutorByNombre(nombreAutor);
                    // por ahora recojo el primero de la lista, 
         Autor autor = (Autor)(aut.getFirst());
         if (autor!= null){
             // si lo encuentro, guardo en this.autor
             this.autorid = autor.getAutorid();
             System.out.println("Autor correcto: "+ this.autorid);
             // añado el id del autor al objeto libro
             libro.setAutorId(this.autorid);
             numValidaciones ++;
         }
         if (numValidaciones ==2){
             validacion = true;
             System.out.println("Valiciones correctas, por autor y por isbn");
         }
         return validacion;
     }
     
     public Libro GuardaLibro(){
         
         DBClient dbLib = new DBClient();
         if (dbLib.insertLibro(libro))
             return libro;
         else
             return null;
     }
     
     public Libro BuscarLibro(String opcion, String termino){
         DBClient dbLib = new DBClient();
         Libro elLibro;
         
         switch (opcion) {
                case "1" -> // Por titulo
                    elLibro = (Libro)(dbLib.selectLibroTitulo(termino).getFirst());
                case "2" -> {
                    // por autor
                    List aut = dbLib.selectAutorByNombre(termino);
                    // por ahora recojo el primero de la lista
                    Autor autor = (Autor)(aut.getFirst());
                    elLibro = (Libro)(dbLib.selectLibroAutor(autor.getAutorid()).getFirst());
                    }
                case "3" -> // por ISBN
                    elLibro = (Libro)(dbLib.selectLibroISBN(termino).getFirst());
                default -> elLibro = null;
         }
         
         return elLibro;
     }
}

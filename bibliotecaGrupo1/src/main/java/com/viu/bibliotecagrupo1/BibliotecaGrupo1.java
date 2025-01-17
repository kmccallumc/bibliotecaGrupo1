package com.viu.bibliotecagrupo1;
/**
 *
 * @author Kathleen Mc Callum
 * @author Oscar Guardia 
 */

import com.viu.bibliotecagrupo1.presentationLayer.MenuPrincipal;
/*import com.viu.bibliotecagrupo1.resources.DBClient;
import java.util.List;
import java.util.Arrays;
*/


public class BibliotecaGrupo1 {

    public static void main(String[] args) {
        System.out.println("***** Bienvenidos a la Biblioteca del Grupo1 *****");
        try{
            
            MenuPrincipal iniciaMenu  = new MenuPrincipal();
            iniciaMenu.mostrarMenu();
            // esto era para probar la conecion
            /*DBClient conec = new DBClient();
            List listalibros, listaAutores;
            
            listaAutores = conec.selectAllAutores();
            listaAutores.forEach(System.out::println);
            
            listalibros = conec.selectAllLibros();
            listalibros.forEach(System.out::println);
            */
         System.out.println("*************** Hasta luego ***************");   
        }catch(Exception e){
            e.printStackTrace();
        }
          
    }
}

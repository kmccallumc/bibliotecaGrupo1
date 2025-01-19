/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viu.bibliotecagrupo1.businessLayer;

import com.viu.bibliotecagrupo1.entitiyLayer.Usuario;
import com.viu.bibliotecagrupo1.resources.DBClient;
import java.util.Date;
import java.util.List;

/**
 *
 * @author kmccallum <Kathleen_McCallum VIU>
 */
public class gestionUsuario {
    Usuario usu;
    
     public gestionUsuario(){
    }
    
    public gestionUsuario(String nombre, String apellidos, String dni, String email, String telefono, String direccion) {
        
        usu = new Usuario();
        usu.setNombre(nombre);
        usu.setApellidos(apellidos);
        usu.setDNI(dni);
        usu.setEmail(email);
        usu.setTelefono(telefono);
        usu.setDireccion(direccion);
        usu.setFechaAlta(new Date()); // por ahora no da tiempo a validar fechas... todos son recien nacidos :)
        usu.setActivo(1);
        usu.setNumeroPrestamos(0);
    }
     public List ListarUsuarios(){
         
         DBClient dbLib = new DBClient();
         return dbLib.selectAllUsuarios();
     }
     
     public boolean validaUsuario(){
         boolean validacion = false;
         int numValidaciones = 0;
         DBClient dbLib = new DBClient();
         
         // 1. Valido DNI
         System.out.println("valido dni.");
         if( dbLib.selectUsuarioDNI(usu.getDNI())==null) {
             numValidaciones ++;
             System.out.println("DNI correcto, no existe");
         }else
             System.out.println("DNI incorrecto, ya existe, verifique");
             
         // 2. Valido email
         System.out.println("valido email.");
         if(dbLib.selectUsuarioEmail(usu.getEmail())== null ) {
             numValidaciones ++;
             System.out.println("email correcto, no existe");
         }else
             System.out.println("email incorrecto, ya existe, pòr favor verifique");
         
         if (numValidaciones ==2){
             validacion = true;
             System.out.println("Valiciones correctas, por DNI e email");
         }
         return validacion;
     }
     
          public Usuario InsertarUsuario(){
         //libro = lib;
         DBClient dbLib = new DBClient();
         if (dbLib.InsertUsuario(this.usu))
             return usu;
         else
             return null;
     }
          
    public Usuario BuscarUsuario(String opcion, String termino){
         DBClient dbLib = new DBClient();
         Usuario elUsu;
         
         switch (opcion) {
                case "1" -> {// Por dni
                    elUsu = dbLib.selectUsuarioDNI(termino);                   
                }
                case "2" -> {// por email - no implementado
                    elUsu = dbLib.selectUsuarioEmail(termino); 
                }
                default -> elUsu = null;
         }
         
         return elUsu;
     }
}

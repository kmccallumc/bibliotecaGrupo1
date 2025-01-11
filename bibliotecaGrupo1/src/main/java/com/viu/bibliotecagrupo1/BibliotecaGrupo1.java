/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.viu.bibliotecagrupo1;

import com.viu.bibliotecagrupo1.resources.DBClient;
import java.util.List;
import java.util.Arrays;

/**
 *
 * @author kmccallum <Kathleen_McCallum VIU>
 */
public class BibliotecaGrupo1 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        List listalibros;
        
        try{
            DBClient conec = new DBClient();
            
            listalibros = conec.selectLibros("select * from libro");
            listalibros.forEach(System.out::println);
            
        }catch(Exception e){
            e.printStackTrace();
        }
          
    }
}

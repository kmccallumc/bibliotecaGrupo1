/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viu.bibliotecagrupo1.businessLayer;

import com.viu.bibliotecagrupo1.resources.DBClient;
import java.util.List;

/**
 *
 * @author kmccallum <Kathleen_McCallum VIU>
 */
public class gestionEcommerce {
    
       public gestionEcommerce(){
    }
    
       public List ListarVentas(){
         
         DBClient dbLib = new DBClient();
         return dbLib.selectAllVentas();

     }
       
       public List consultaVenta(int numVenta){
           
            DBClient dbLib = new DBClient();
            return dbLib.selectVenta(numVenta);
       }
     
}

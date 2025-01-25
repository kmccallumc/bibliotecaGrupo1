/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viu.bibliotecagrupo1.businessLayer;

import com.viu.bibliotecagrupo1.resources.DBClient;
import com.viu.bibliotecagrupo1.entitiyLayer.Venta;
import java.util.List;
import java.util.Date;

/**
 *
 * @author kmccallum <Kathleen_McCallum VIU>
 */
public class gestionEcommerce {
    
    public gestionEcommerce(){
    }
    public boolean validaVenta(int usuarioId, int libros[], float precios[]){
        // validar usuario, validar libro y validar precios
        return true;
    }
    
    public Venta creaVenta(int usuarioId, int libros[], float precios[]){
        int contadorLibros = libros.length;
        
        Venta venta = new Venta();
        float total = 0;
        for (int i=0;i<contadorLibros;i++){
            total += precios[i];
        }
        try{
            venta.setUsuarioid(usuarioId);
            venta.setValorTotal(total);
        
            venta = this.insertaVenta(venta, libros, precios);

            
        }catch(Exception e) {
            System.out.println("Error al crear la venta: " + e.getMessage());
        }
        return venta;
    }
    
       public List ListarVentas(){
         
         DBClient dbLib = new DBClient();
         return dbLib.selectAllVentas();

     }
       
       public List consultaVenta(int numVenta){
           
            DBClient dbLib = new DBClient();
            return dbLib.selectVenta(numVenta);
       }
       
       public Venta insertaVenta(Venta venta, int libros[], float precios[]){
           DBClient dbLib = new DBClient();
           Date fecha = new Date(System.currentTimeMillis());
           venta.setFechaVenta(fecha);
           // inserto venta
           int ventaKey = dbLib.InsertVenta(venta);
           if(ventaKey>0){
               venta.setVentaid(ventaKey);
               dbLib.InsertDetalleVenta(venta,libros, precios );
           }
         return venta;      
         // luego hay que reducir el stock de libros
       }
       
         
     
}

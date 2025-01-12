
package com.viu.bibliotecagrupo1.resources;

/**
 *
 * @author kmccallum <Kathleen_McCallum VIU>
 */

import java.sql.*;
import com.viu.bibliotecagrupo1.entitiyLayer.Libro;
import com.viu.bibliotecagrupo1.entitiyLayer.Autor;
import java.util.List;
import java.util.ArrayList;

public class DBClient {
    // JDBC driver mariadb para usar el AuroraMysql de AWS
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";

    // credenciales sin enmascarar ... ups
    
    static String USERDB = "admin";
    static String PASSDB = "21giinbiblioteca";
    static String DB_URL = "jdbc:mysql://grupo1biblioteca.c3ocykg6ykg2.us-east-1.rds.amazonaws.com:3306/grupo1biblioteca";
    
    Connection connBiblio;
    
    // constructor
    public void DBClient(){
        // al construir el DBClient genero la conection
        try {
            connBiblio = DriverManager.getConnection(DB_URL, USERDB, PASSDB);
            
        }catch (SQLException  e) {
                e.printStackTrace();
        }
    }
    
    // KMC : he creado 3 queries genericas
    // PENDIENTE: HAY QUE CREAR
     public List selectLibros(String querySelect){
         List listalibros = new ArrayList();
         
        try {connBiblio = DriverManager.getConnection(DB_URL, USERDB, PASSDB);
            Statement insertaQ = connBiblio.createStatement();
            ResultSet rs = insertaQ.executeQuery(querySelect);
            
            
           while (rs.next()) {
                // Retrieve by column name 
                String titulo = rs.getString("titulo");
                int elautor = rs.getInt("autor_id");
                String  isbn = rs.getString("titulo");
                boolean disponible = rs.getBoolean("autor_id"); // los libros por defecto estan disponibles
                String genero = rs.getString("genero");
                
                // aqui falta hacer un get del autor, y rellenar el objeto
                Autor aut;
                        
                Libro lib = new Libro(titulo, aut, isbn, genero, disponible);
                listalibros.add(lib);
            }
            
         }catch (SQLException  e) {
             System.out.println(e.getErrorCode());
             System.out.println(e.getLocalizedMessage() );
                e.printStackTrace();
         }
        
        return listalibros;
    }
     
    public String insertStatement(String queryInsert){
        try {
            Statement insertaQ = connBiblio.createStatement();
            ResultSet rs = insertaQ.executeQuery(queryInsert);
            
         }catch (SQLException  e) {
                e.printStackTrace();
        }
        return "algo";
    }
    
    public String UpdateStatement(String queryUpdate){
        try {
            Statement insertaQ = connBiblio.createStatement();
            ResultSet rs = insertaQ.executeQuery(queryUpdate);
            
         }catch (SQLException  e) {
                e.printStackTrace();
        }
        return "algo";
    }

}

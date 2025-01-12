
package com.viu.bibliotecagrupo1.resources;

/**
 *
 * @author kmccallum <Kathleen_McCallum VIU>
 */

//import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.viu.bibliotecagrupo1.entitiyLayer.Libro;
import com.viu.bibliotecagrupo1.entitiyLayer.Autor;
import java.util.List;
import java.util.ArrayList;
import software.amazon.jdbc.ds.AwsWrapperDataSource;

public class DBClient {
    // credenciales sin enmascarar ... ups   
    private static final String USERDB = "admin";
    private static final String PASSDB = "21giinbiblioteca";
    private static final String SERVERA = "grupo1biblioteca.c3ocykg6ykg2.us-east-1.rds.amazonaws.com";
    private static final String DBAW = "g1lib";
    private static final String PORTAW = "3306";
    //private static final String DB_URL = "jdbc:aws-wrapper:mysql://grupo1biblioteca.c3ocykg6ykg2.us-east-1.rds.amazonaws.com:3306/grupo1biblioteca";
     
    Connection connBiblio;
    AwsWrapperDataSource ds;
      
    // constructor
    public void DBClient(){
        // al construir el DBClient genero la conection
        
        inicializaDS();    
        try {
            connBiblio = ds.getConnection(USERDB, PASSDB);
            
        }catch (SQLException  e) {
                e.printStackTrace();
        }
    }
    
    private void inicializaDS (){
        ds = new AwsWrapperDataSource();
        ds.setJdbcProtocol("jdbc:mysql:");
        // Specify the driver-specific data source:
        //ds.setTargetDataSourceClassName("org.mysql.ds.PGSimpleDataSource");

        // Configure basic data source information:
        ds.setServerName(SERVERA);
        ds.setDatabase(DBAW);
        ds.setServerPort(PORTAW);
    }
    
    
    // KMC : he creado 3 queries genericas
    // PENDIENTE: HAY QUE CREAR
     public List selectLibros(String querySelect){
        List listalibros = new ArrayList();
        inicializaDS();
        try {connBiblio = ds.getConnection(USERDB, PASSDB);
            Statement insertaQ = connBiblio.createStatement();
            ResultSet rs = insertaQ.executeQuery(querySelect);
            
            
           while (rs.next()) {
                // Retrieve by column name 
                String titulo = rs.getString("titulo");
                int elautor = rs.getInt("autor_id");
                String  isbn = rs.getString("titulo");
                boolean disponible = rs.getBoolean("autor_id"); // los libros por defecto estan disponibles
                String genero = rs.getString("genero");
                
                // Traigo el autor, que solo tengo su id
                String queryAutor = "select * from autor where autor_id = " + elautor;
                Autor aut = this.selectAutor(queryAutor);
                        
                //Libro lib = new Libro(titulo, aut, isbn, genero, disponible);
                //listalibros.add(lib);
            }
            
         }catch (SQLException  e) {
             System.out.println(e.getErrorCode());
             System.out.println(e.getLocalizedMessage() );
                e.printStackTrace();
         }
        
        return listalibros;
    }
   
    public Autor selectAutor(String querySelect){
         //List elautor = new ArrayList();
        Autor aut=null; 
        inicializaDS();
        try {connBiblio = ds.getConnection(USERDB, PASSDB);
            Statement selecta = connBiblio.createStatement();
            ResultSet rs = selecta.executeQuery(querySelect);
            
           while (rs.next()) {
                // Retrieve by column name 
                int autorid = rs.getInt("autor_id");
                String nombreautor = rs.getString("nombreAutor");
                String apellidoautor = rs.getString("apellidoAutor");
                String  sexo = rs.getString("sexo");
                Date fechanacimiento = rs.getDate("fechaNacimiento");
                String nacionalidad = rs.getString("nacionalidad");
                String biografia = rs.getString("biografia");
                
                // aqui falta hacer un get del autor, y rellenar el objeto
                //aut = new Autor (nombreautor,apellidoautor,fechanacimiento,sexo,nacionalidad,biografia, autorid);
            }
            
         }catch (SQLException  e) {
             System.out.println(e.getErrorCode());
             System.out.println(e.getLocalizedMessage() );
                e.printStackTrace();
         }
        
        return aut;
    }
    
    public String insertStatement(String queryInsert){
        inicializaDS();
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

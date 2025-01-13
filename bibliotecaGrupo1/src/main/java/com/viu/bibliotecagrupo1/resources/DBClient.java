
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
import java.sql.PreparedStatement;
import java.sql.Date;
//import java.util.Date;

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
        // solo hago una conexion de prueba, esto es muy ineficiente
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
    
    // generic statement : Insert, Update, Delete statement - no hace falta recoger los datos, solo el resultado
     public boolean InsUpdDelStatement(String queryIns){
        //inicializaDS();
        boolean isOK = false;
        try {
            connBiblio = ds.getConnection(USERDB, PASSDB);
            Statement insertUpdateDelete = connBiblio.createStatement();
            ResultSet rs = insertUpdateDelete.executeQuery(queryIns);
            isOK = true;
            
         }catch (SQLException  e) {
                e.printStackTrace();
        }
        return isOK;
    }
    
    /* ******************************************************
     * Libro
     * ****************************************************** */
    public boolean insertLibro(Libro lib){
        inicializaDS();
        boolean isOK = false;
        try {
            connBiblio = ds.getConnection(USERDB, PASSDB);
            String sql = "INSERT INTO libro(titulo, autor_id, isbn, disponible, genero) VALUES ( ?, ?, ?, ?, ?)";
    
            PreparedStatement preparedStmt = connBiblio.prepareStatement(sql);
            preparedStmt.setString (1, lib.getTitulo());
            preparedStmt.setInt (2, lib.getAutor().getAutorid());
            preparedStmt.setString (3, lib.getIsbn());
            preparedStmt.setBoolean(4, lib.isDisponible());
            preparedStmt.setString(5, lib.getGenero());
            
            preparedStmt.execute();
            isOK = true;
            
         }catch (SQLException  e) {
                e.printStackTrace();
        }
        return isOK;
    }

        public boolean updateLibro(Libro lib){
        inicializaDS();
        boolean isOK = false;
        try {
            connBiblio = ds.getConnection(USERDB, PASSDB);
            String sql = "UPDATE libro set titulo = ?, autor_id = ?, isbn = ?, disponible = ?, genero= ? where libro_id = ?";
    
            PreparedStatement preparedStmt = connBiblio.prepareStatement(sql);
            preparedStmt.setString (1, lib.getTitulo());
            preparedStmt.setInt (2, lib.getAutor().getAutorid());
            preparedStmt.setString (3, lib.getIsbn());
            preparedStmt.setBoolean(4, lib.isDisponible());
            preparedStmt.setString(5, lib.getGenero());
            preparedStmt.setInt(6, lib.getLibroId());
            preparedStmt.execute();
            isOK = true;
            
         }catch (SQLException  e) {
                e.printStackTrace();
        }
        return isOK;
    }
     
    public boolean deleteLibro(int libroid){
        inicializaDS();
        boolean isOK = false;
        try {
            connBiblio = ds.getConnection(USERDB, PASSDB);
            String sql = "DELETE from libro where libro_id = ?";
            
            PreparedStatement preparedStmt = connBiblio.prepareStatement(sql);
            preparedStmt.setInt(1, libroid);
            preparedStmt.execute();
            isOK = true;
            
         }catch (SQLException  e) {
                e.printStackTrace();
        }
        return isOK;
    }
        
    public List selectLibroTitulo(String Titulo){
        // el titulo puede devolver valios libros               
        String sql = "select * from libro where titulo = '" + Titulo + "'";
        return selectGenericoLibro(sql);
    }      

    public List selectLibroAutor(int Autorid){
        // el autor puede devolver valios libros
        String sql = "select * from libro where autor_id = " + Autorid;
        return selectGenericoLibro(sql);
    }      

    public List selectLibroISBN(String ISBN){
        // el ISBN puede devolver valios libros ???? o solo 1        
        String sql = "select * from libro where titulo = '" + ISBN + "'";
        return selectGenericoLibro(sql);
    }      
    
     public List selectAllLibros(){
        // devuelve todos los libros
        String querySelect = "select * from libro";
        return selectGenericoLibro(querySelect);
    }
    
      private List selectGenericoLibro(String sql){
        Libro lib=null; 
        List listalibros = new ArrayList(); 
        String titulo, isbn, genero;
        int elautor, libroid;
        boolean disponible;
        
        inicializaDS();
        try {
            connBiblio = ds.getConnection(USERDB, PASSDB);
            Statement selecta = connBiblio.createStatement();           
            ResultSet rs = selecta.executeQuery(sql);  
            
           while (rs.next()) {
                // Retrieve by column name 
                libroid = rs.getInt("libro_id");
                titulo = rs.getString("titulo");
                elautor = rs.getInt("autor_id");
                isbn = rs.getString("titulo");
                disponible = rs.getBoolean("autor_id"); // los libros por defecto estan disponibles
                genero = rs.getString("genero");
                
                // KMC : no se si esta bien ponerlo aqui... el objeto... pero bueno, solo por ahora
                //Autor aut = this.selectAutorById(elautor);                       
                lib = new Libro(libroid, titulo, isbn, genero, disponible, elautor);
                listalibros.add(lib);               
            }
            
         }catch (SQLException  e) {
             System.out.println(e.getErrorCode());
             System.out.println(e.getLocalizedMessage() );
                e.printStackTrace();
         }        
        return listalibros;
    }
    
     /* ******************************************************
      * Autor
      * ****************************************************** */
    public boolean InsertAutor(Autor aut){
        inicializaDS();
        boolean isOK = false;
        try {
            connBiblio = ds.getConnection(USERDB, PASSDB);
            String sql = "INSERT INTO Autor (nombreAutor, apellidoAutor, sexo, fechaNacimiento, nationality, biografia) VALUES (?, ?, ?, ?, ?, ?)";
    
            PreparedStatement preparedStmt = connBiblio.prepareStatement(sql);
            preparedStmt.setString (1, aut.getNombreAutor());
            preparedStmt.setString (2, aut.getApellidoAutor());
            preparedStmt.setString (3, aut.getSexo());
            preparedStmt.setDate (4, new java.sql.Date(aut.getFechaNacimiento().getTime()));
            preparedStmt.setString (5, aut.getNacionalidad());
            preparedStmt.setString(6, aut.getBiografia());
            
            preparedStmt.execute();
            isOK = true;
            
         }catch (SQLException  e) {
                e.printStackTrace();
        }
        return isOK;
    }
    
    public Autor selectAutorById(int elautorid){
        Autor aut=null; 
        inicializaDS();
        try {
            connBiblio = ds.getConnection(USERDB, PASSDB);
            Statement selecta = connBiblio.createStatement();
            // Traigo el autor, que solo tengo su id
            String sql = "select * from Autor where autor_id = " + elautorid;
            ResultSet rs = selecta.executeQuery(sql);
            
           while (rs.next()) {
                // Retrieve by column name 
                int autorid = rs.getInt("autor_id");
                String nombreautor = rs.getString("nombreAutor");
                String apellidoautor = rs.getString("apellidoAutor");
                String  sexo = rs.getString("sexo");
                Date fechanacimiento = rs.getDate("fechaNacimiento");
                String nacionalidad = rs.getString("nationality");
                String biografia = rs.getString("biografia");
                
                aut = new Autor (nombreautor,apellidoautor,fechanacimiento,sexo,nacionalidad,biografia, autorid);
            }
            
         }catch (SQLException  e) {
             System.out.println(e.getErrorCode());
             System.out.println(e.getLocalizedMessage() );
                e.printStackTrace();
         }
        
        return aut;
    }
   
     public List selectAllAutores(){
        List listaAutores = new ArrayList();
        String querySelect = "select * from Autor";
        String nombreautor, apellidoautor, sexo, nacionalidad,biografia ;
        int elautor;
        Date fechanacimiento;
        
        inicializaDS();
        try {
            connBiblio = ds.getConnection(USERDB, PASSDB);
            Statement insertaQ = connBiblio.createStatement();
            ResultSet rs = insertaQ.executeQuery(querySelect);
            
           while (rs.next()) {
                // Retrieve by column name 
                nombreautor = rs.getString("nombreAutor");
                apellidoautor = rs.getString("apellidoAutor");
                 sexo = rs.getString("sexo");
                fechanacimiento = rs.getDate("fechaNacimiento");
                nacionalidad = rs.getString("nationality");
                biografia = rs.getString("biografia");
                elautor = rs.getInt("autor_id");

                Autor aut = new Autor(nombreautor, apellidoautor, new java.util.Date(fechanacimiento.getTime()), sexo, nacionalidad, biografia, elautor);
                listaAutores.add(aut);
            }
            
         }catch (SQLException  e) {
             System.out.println(e.getErrorCode());
             System.out.println(e.getLocalizedMessage() );
                e.printStackTrace();
         }
        return listaAutores;
    }
 
    
}


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
import com.viu.bibliotecagrupo1.entitiyLayer.Usuario;
import com.viu.bibliotecagrupo1.entitiyLayer.Venta;
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
            preparedStmt.setInt (2, lib.getAutorId());
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
            preparedStmt.setInt (2, lib.getAutorId());
            preparedStmt.setString (3, lib.getIsbn());
            preparedStmt.setBoolean(4, lib.isDisponible());
            preparedStmt.setString(5, lib.getGenero());
            preparedStmt.setInt(6, lib.getLibroId()); // el argumento
            preparedStmt.execute();
            isOK = true;
            
         }catch (SQLException  e) {
                e.printStackTrace();
                isOK = false;
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
        String sql = "select * from libro where isbn = '" + ISBN + "'";
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
            System.out.println("The query: " + sql);
            connBiblio = ds.getConnection(USERDB, PASSDB);
            Statement selecta = connBiblio.createStatement();           
            ResultSet rs = selecta.executeQuery(sql);  
            
           while (rs.next()) {
                // Retrieve by column name 
                libroid = rs.getInt("libro_id");
                titulo = rs.getString("titulo");
                elautor = rs.getInt("autor_id");
                isbn = rs.getString("isbn");
                disponible = rs.getBoolean("autor_id"); // los libros por defecto estan disponibles
                genero = rs.getString("genero");
                                 
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
      * Usuario
      * ****************************************************** */
    public boolean InsertUsuario(Usuario usu){
        inicializaDS();
        boolean isOK = false;
        try {
            connBiblio = ds.getConnection(USERDB, PASSDB);
            String sql = "INSERT INTO usuario (nombre, apellidos, dni, email, telefono, direccion, fechaAlta, activo, numeroPrestamos) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
            PreparedStatement preparedStmt = connBiblio.prepareStatement(sql);
            preparedStmt.setString (1, usu.getNombre());
            preparedStmt.setString (2, usu.getApellidos());
            preparedStmt.setString (3, usu.getDNI());
            preparedStmt.setString (4, usu.getEmail());
            preparedStmt.setString (5, usu.getTelefono());
            preparedStmt.setString (6, usu.getDireccion());
            preparedStmt.setDate (7, new java.sql.Date(usu.getFechaAlta().getTime()));
            preparedStmt.setInt(8, usu.getActivo());
            preparedStmt.setInt(9, usu.getNumeroPrestamos());
            
            preparedStmt.execute();
            isOK = true;
            
         }catch (SQLException  e) {
                e.printStackTrace();
        }
        return isOK;
    }
    
        public boolean updateUsuario(Usuario usu){
        inicializaDS();
        boolean isOK = false;
        try {
            connBiblio = ds.getConnection(USERDB, PASSDB);
            String sql = "UPDATE usuario set nombre = ?, apellidos= ?, dni= ?, email= ?, telefono=?, direccion = ?, fechaAlta = ? , activo= ?, numeroPrestamos=? where usuario_id = ?";
    
            PreparedStatement preparedStmt = connBiblio.prepareStatement(sql);
            preparedStmt.setString (1, usu.getNombre());
            preparedStmt.setString (2, usu.getApellidos());
            preparedStmt.setString (3, usu.getDNI());
            preparedStmt.setString (4, usu.getEmail());
            preparedStmt.setString (5, usu.getTelefono());
            preparedStmt.setString (6, usu.getDireccion());
            preparedStmt.setDate (7, new java.sql.Date(usu.getFechaAlta().getTime()));
            preparedStmt.setInt(8, usu.getActivo());
            preparedStmt.setInt(9, usu.getNumeroPrestamos());
            preparedStmt.setInt(10, usu.getId());
            
            preparedStmt.execute();
            isOK = true;
            
         }catch (SQLException  e) {
                e.printStackTrace();
        }
        return isOK;
    }
     
    public boolean deleteUsuario(int usuarioid){
        inicializaDS();
        boolean isOK = false;
        try {
            connBiblio = ds.getConnection(USERDB, PASSDB);
            String sql = "DELETE from usuario where usuario_id = ?";
            
            PreparedStatement preparedStmt = connBiblio.prepareStatement(sql);
            preparedStmt.setInt(1, usuarioid);
            preparedStmt.execute();
            isOK = true;
            
         }catch (SQLException  e) {
                e.printStackTrace();
        }
        return isOK;
    }
    
    public Usuario selectUsuarioDNI(String dni){
        // el dni es unico
        Usuario usu = null;
        String sql = "select * from usuario where dni = '" + dni + "'";
        List listaUsuarios = selectGenericoUsuario(sql);
        if ( !listaUsuarios.isEmpty())
            usu  = (Usuario)listaUsuarios.getFirst();
        return usu;
    }      

    public Usuario selectUsuarioEmail(String email){
        // el email deberia ser unico, asi que traigo el primero
        Usuario usu = null;
        String sql = "select * from usuario where email = '" + email + "'";
        List listaUsuarios = selectGenericoUsuario(sql);
        if ( !listaUsuarios.isEmpty())
            usu = (Usuario)listaUsuarios.getFirst();       
        return usu;
    }      
    
        public List selectAllUsuarios(){
        // devuelve todos los libros
        String querySelect = "select * from usuario";
        return selectGenericoUsuario(querySelect);
    }
        
    private List selectGenericoUsuario(String sql){
        Usuario usu=null; 
        List listaUsuarios = new ArrayList(); 
        String nombre, apellidos, dni, email, telefono, direccion;
        Date fechaAlta;
        int usuarioid, activo, numeroPrestamos;
        
        inicializaDS();
        try {
            connBiblio = ds.getConnection(USERDB, PASSDB);
            Statement selecta = connBiblio.createStatement();           
            ResultSet rs = selecta.executeQuery(sql);  
            
           while (rs.next()) {
                // Retrieve by column name 
                usuarioid = rs.getInt("usuario_id");
                nombre = rs.getString("nombre");
                apellidos = rs.getString("apellidos");
                dni = rs.getString("dni");
                email = rs.getString("email");
                telefono = rs.getString("telefono");
                direccion = rs.getString("direccion");
                fechaAlta = rs.getDate("fechaAlta");
                activo = rs.getInt("activo");
                numeroPrestamos = rs.getInt("numeroPrestamos"); // los libros por defecto estan disponibles
                
                // KMC : no se si esta bien ponerlo aqui... el objeto... pero bueno, solo por ahora
                //Autor aut = this.selectAutorById(elautor);                       
                usu = new Usuario(usuarioid, nombre, apellidos, dni, email, telefono, direccion, fechaAlta, activo, numeroPrestamos);
                listaUsuarios.add(usu);               
            }
            
         }catch (SQLException  e) {
             System.out.println(e.getErrorCode());
             System.out.println(e.getLocalizedMessage() );
                e.printStackTrace();
         }        
        return listaUsuarios;
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
                
                aut = new Autor (nombreautor,apellidoautor,new java.util.Date(fechanacimiento.getTime()),sexo,nacionalidad,biografia, autorid);
            }
            
         }catch (SQLException  e) {
             System.out.println(e.getErrorCode());
             System.out.println(e.getLocalizedMessage() );
                e.printStackTrace();
         }
        
        return aut;
    }
    
       public List selectAutorByNombre(String nombreAutor){
        Autor aut=null; 
        List listaAutores = new ArrayList();
        inicializaDS();
        
        
        try {
            connBiblio = ds.getConnection(USERDB, PASSDB);
            Statement selecta = connBiblio.createStatement();
            // Traigo el autor, que solo tengo su id
            String sql = "select * from Autor where upper(nombreAutor) = '" + nombreAutor.toUpperCase() + "'";
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
                
                aut = new Autor (nombreautor,apellidoautor,new java.util.Date(fechanacimiento.getTime()),sexo,nacionalidad,biografia, autorid);
                listaAutores.add(aut);
            }
            
         }catch (SQLException  e) {
             System.out.println(e.getErrorCode());
             System.out.println(e.getLocalizedMessage() );
                e.printStackTrace();
         }
        
        return listaAutores;
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
 
     /* ******************************************************
      * Ventas
      * ****************************************************** */
    public List selectAllVentas(){
        List listaVentas = new ArrayList();
        String querySelect = "select * from ventas";
        
        int ventaid, usuarioid;
        float valorTotal;
        Date fechaventa;
        
        inicializaDS();
        try {
            connBiblio = ds.getConnection(USERDB, PASSDB);
            Statement insertaQ = connBiblio.createStatement();
            ResultSet rs = insertaQ.executeQuery(querySelect);
            
           while (rs.next()) {
                // Retrieve by column name 
                ventaid = rs.getInt("venta_id");
                fechaventa = rs.getDate("fechaVenta");
                valorTotal = rs.getFloat("valorTotal");
                usuarioid = rs.getInt("usuario_id");

                Venta ven = new Venta(ventaid, new java.util.Date(fechaventa.getTime()), usuarioid, valorTotal);
                listaVentas.add(ven);
            }
            
         }catch (SQLException  e) {
             System.out.println(e.getErrorCode());
             System.out.println(e.getLocalizedMessage() );
                e.printStackTrace();
         }
        return listaVentas;
    }
    
       public List selectVenta(int numVenta){
        List listaVentas = new ArrayList();
        int ventaid, usuarioid, ventaitem, libroid;
        float valorTotal,precioVentaLibro;
        Date fechaventa;
        String querySelect = "select v.venta_id, v.fechaVenta, v.usuario_id, v.valorTotal, venta_item, libro_id, precioVentaLibro\n" +
                             "from ventas v\n" +
                             "join ventas_detalle vd on v.venta_id = vd.venta_id\n" +
                             "where v.venta_id = " +numVenta +";";
       
        inicializaDS();
        try {
            connBiblio = ds.getConnection(USERDB, PASSDB);
            Statement insertaQ = connBiblio.createStatement();
            ResultSet rs = insertaQ.executeQuery(querySelect);
            
           while (rs.next()) {
                // Retrieve by column name 
                ventaid = rs.getInt("venta_id");
                fechaventa = rs.getDate("fechaVenta");
                valorTotal = rs.getFloat("valorTotal");
                usuarioid = rs.getInt("usuario_id");
                ventaitem = rs.getInt("venta_item");
                libroid = rs.getInt("libro_id");
                precioVentaLibro = rs.getFloat("precioVentaLibro");
                Venta ven = new Venta(ventaid, new java.util.Date(fechaventa.getTime()), usuarioid, valorTotal, ventaitem, libroid, precioVentaLibro);
                listaVentas.add(ven);
            }
            
         }catch (SQLException  e) {
             System.out.println(e.getErrorCode());
             System.out.println(e.getLocalizedMessage() );
                e.printStackTrace();
         }
        return listaVentas;
    }
       
    public int InsertVenta(Venta ven){
        inicializaDS();
        boolean isOK = false;
        int ventaKey=0;
        ResultSet rs;
        try {
            connBiblio = ds.getConnection(USERDB, PASSDB);
            String sql = "INSERT INTO ventas (fechaVenta, usuario_id, valorTotal) VALUES (?, ?, ?)";
    
            PreparedStatement preparedStmt = connBiblio.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            preparedStmt.setDate (1, new java.sql.Date(System.currentTimeMillis()));
            preparedStmt.setInt (2, ven.getUsuarioid());
            preparedStmt.setFloat(3, ven.getValorTotal());
            preparedStmt.execute();
            
            rs= preparedStmt.getGeneratedKeys();
            while (rs.next())
                ventaKey = rs.getInt(1);
            isOK = true;
            
         }catch (SQLException  e) {
                e.printStackTrace();
        }
        return ventaKey;
    }
    
       public boolean InsertDetalleVenta(Venta ven, int libros[], float precios[]){
        inicializaDS();
        boolean isOK = false;
        
        try {
            connBiblio = ds.getConnection(USERDB, PASSDB);
            int contador = libros.length;
            for(int i=0; i<contador; i++){
                String sql = "INSERT INTO ventas_detalle (venta_id, venta_item, libro_id, precioVentaLibro) VALUES(?,?,?,?)";
                PreparedStatement preparedStmt = connBiblio.prepareStatement(sql);
                preparedStmt.setInt (1, ven.getVentaid());
                preparedStmt.setInt (2, i);
                preparedStmt.setInt (3, libros[i]);
                preparedStmt.setFloat(4, precios[i]);

                preparedStmt.execute();
            }
            isOK = true;
            
         }catch (SQLException  e) {
                e.printStackTrace();
        }
        return isOK;
    }
}

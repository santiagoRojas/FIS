/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author estudiantes
 */
    public class Conexion {
        static Connection conn;
        public static Connection getConexion() throws ClassNotFoundException {

            String driver = "org.postgresql.Driver"; 
            String connectString = "jdbc:postgresql://localhost:5432/Cajero"; 
            String user = "postgres";
            String password = "1030jorge670566"; 

            try {
                    Class.forName(driver);
                    conn = DriverManager.getConnection(connectString, user, password);
                    //Si la conexion fue realizada con exito, muestra el sgte mensaje.
              
                    return conn;
                    }
                    //Si se produce una Excepcion y no nos podemos conectar, muestra el sgte. mensaje.
            catch(SQLException e) {
                    System.out.println("Se ha producido un error en la conexion a la base de datos Ejemplo! ");
                    return null;
                }

    /*private static Connection cn = null;
    private static String URLBD = "jdbc:postgresql://localhost:5432/postgres/";
    private static String usuario = "postgres";
    private static String contrasena = "santiago";

    public static Connection getConexion() throws SQLException {
        
        try {
            Class.forName("org.postgresql.Driver");
            cn = DriverManager.getConnection(URLBD, usuario, contrasena);
            Statement sta;
            sta = cn.createStatement();
            
            String query = "SELECT * FROM estudiante";
            ResultSet rs = sta.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getInt("idEstudiante"));
                System.out.println(rs.getString("nombre"));               
             }
             System.out.println("Conexión exitosa");
            return cn;
            
        } catch (Exception e) {
            System.out.println("Error ."+e);
            return null;
        }
    }*/
            }
    public static void cerrarConexion() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("No se pudo cerrar la conexion");
        }
    }}
    
            
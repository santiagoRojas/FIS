    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DAO;

import Controlador.Conexion.Conexion;
import Mundo.Administrador;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author TOSHIBA
 */
public class AdministradorDAO {
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public AdministradorDAO() {
        con = null;
        st = null;
        rs=null;
    }
    
    public Administrador consultarAdministrador (String correo, String contraseña){
        
        Administrador administrador = null;
        String script = "SELECT * FROM public.\"Administrador\" \n" +
"WHERE \"correo\" = '"+correo+"' and \"contrasena\" = '"+contraseña+"'";
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(script);
            if(rs.next()){
                administrador = new Administrador();
                administrador.setNombre(rs.getString("nombre"));
                administrador.setApellido(rs.getString("apellido"));
                administrador.setContrasena(rs.getString("contrasena"));
                administrador.setCorreo(rs.getString("correo"));
                administrador.setIdAdministrador(rs.getInt("idadministrador"));
            }
            st.close();
            Conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("No se pudo realizar la consulta");
            return null;
        }
        return administrador;
    }
}

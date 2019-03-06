/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DAO;
import Controlador.Conexion.Conexion;
import Mundo.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author TOSHIBA
 */
public class UsuarioDAO {
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public UsuarioDAO() {
        con = null;
        st = null;
        rs=null;
    }
    
    public boolean agregarUsuario(Usuario usuario) throws ClassNotFoundException{
        String script = "INSERT INTO public.\"Usuario\"(\n" +
"	 correo, contrasena, nombre, apellido, telefono, \"estadoUsuario\")\n" +
"	VALUES ('"+usuario.getCorreo()+"', '"+usuario.getContrasena()+"','"+usuario.getNombre()+"' , '"+usuario.getApellido()+"',"+usuario.getTelefono()+", "+usuario.isEstadoUsuario()+")";
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
             st.executeUpdate(script);
            st.close();
            Conexion.cerrarConexion();
            return true;
        } catch (SQLException e) {
            System.out.println("no se pudo realizar el agregado");
        }
        return false;
    }
    public boolean BloquearUsuario(String correo) throws ClassNotFoundException{
        String script = "update \"Usuario\" set \"estadoUsuario\" = false \n" +
"where \"correo\" = '"+correo+"'";
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            st.executeUpdate(script);
            st.close();
            Conexion.cerrarConexion();
            return true;
        } catch (SQLException e) {
            System.out.println("No se puedo realizar la modificacion");
        }
        return false;
    }
    public Usuario consultarUsuario(String correo, String contraseña){
        Usuario usuario = null;
        String script = "SELECT * FROM public.\"Usuario\" \n" +
"WHERE \"correo\" = '"+correo+"' and \"contrasena\" = '"+contraseña+"'";
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(script);
            if(rs.next()){
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setTelefono(rs.getInt("telefono"));
                usuario.setNombre(rs.getString("nombreUsuario"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setEstadoUsuario(rs.getBoolean("estadoUsuario"));
            }
            st.close();
            Conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("No se pudo realizar la consulta");
            return null;
        }
        return usuario;
    }
    public boolean desbloquearUSuario(String correo) throws ClassNotFoundException{
        String script = "update \"Usuario\" set \"estadoUsuario\" = true \n" +
"where \"correo\" ='"+correo+"'";
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            st.executeUpdate(script);
            st.close();
            Conexion.cerrarConexion();
            return true;
        } catch (SQLException e) {
            System.out.println("No se puedo realizar la modificacion");
        }
        return false;
    }
    public boolean eliminarUsuario(String correo) throws ClassNotFoundException{
        String eliminar = "DELETE FROM public.\"Usuario\"\n" +
"	WHERE \"correo\" ='"+correo+"'";
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            st.executeUpdate(eliminar);
            st.close();
            Conexion.cerrarConexion();
            return true;
        } catch (SQLException e) {
            System.out.println("no se pudo realizar la eliminacion");
        }
        return false;
    }
}

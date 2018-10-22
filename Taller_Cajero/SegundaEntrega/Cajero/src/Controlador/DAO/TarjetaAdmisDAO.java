/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DAO;

import Modelo.Administrador;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author TOSHIBA
 */
public class TarjetaAdmisDAO {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private Administrador admin;

    public TarjetaAdmisDAO() {
        con = null;
        st = null;
        rs=null;
    }
    public boolean bloquearTarjeta(int nit) throws ClassNotFoundException{
        String consulta = "UPDATE public.\"TarjetaAdministrador\"\n" +
"	SET  \"estadoTarjeta\"=false\n" +
"	WHERE \"idTarjetaAdministrador\"="+nit;
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            st.executeUpdate(consulta);
            st.close();
            Conexion.cerrarConexion();
            return true;
        } catch (SQLException e) {
            System.out.println("No se puedo realizar la modificacion");
        }
        return false;
    }
    public Administrador consultar(int nit){
        admin = null;
        String consulta = "SELECT *\n" +
"	FROM public.\"TarjetaAdministrador\", public.\"Administrador\"\n" +
"	WHERE public.\"Administrador\".\"idAdministrador\" = public.\"TarjetaAdministrador\".\"idAdministrador\" \n" +
"	and  \"idTarjetaAdministrador\" = "+nit;
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            if(rs.next()){
                admin = new Administrador();
                admin.setId(rs.getInt("idAdministrador"));
                admin.setNombre(rs.getString("nombre"));
                admin.setApellido(rs.getString("apellido"));
                admin.setNit(rs.getInt("idTarjetaAdministrador"));
                admin.setEstadoTarjeta(rs.getBoolean("estadoTarjeta"));
            }
            st.close();
            Conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("No se pudo realizar la consulta");
            return null;
        }
        return admin;
    }
    public boolean consultarContra(int contra, int nit){
        String consulta = "SELECT \"contraseña\" FROM public.\"TarjetaAdministrador\" \n" +
"WHERE \"idTarjetaAdministrador\" = "+nit+" \n" +
"and \"contraseña\" ="+contra;
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            if(rs.next()){
                st.close();
                Conexion.cerrarConexion();
                return true;
            }
        } catch (Exception e) {
            System.err.println("contraseña invalida");
        }
        return false;
    }
}
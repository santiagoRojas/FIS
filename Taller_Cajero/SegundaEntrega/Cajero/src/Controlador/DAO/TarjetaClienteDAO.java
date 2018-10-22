/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DAO;

import Modelo.Cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author TOSHIBA
 */
public class TarjetaClienteDAO {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private Cliente cliente;

    public TarjetaClienteDAO() {
        con = null;
        st = null;
        rs=null;
    }
    public boolean bloquearTarjeta(int nit) throws ClassNotFoundException{
        String consulta = "update \"TarjetaCliente\" set \"estadoTarjeta\" = false \n" +
"where \"nitTarjetaCliente\" ="+nit;
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
    public Cliente consultar(int nit){
        cliente = null;
        String consulta = "SELECT * FROM public.\"TarjetaCliente\", public.\"Cliente\"   \n" +
"WHERE public.\"Cliente\".\"idCliente\" = public.\"TarjetaCliente\".\"idCliente\" \n" +
"and  \"nitTarjetaCliente\" = "+nit;
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            if(rs.next()){
                cliente = new Cliente();
                cliente.setId(rs.getInt("idCliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setNit(rs.getInt("nitTarjetaCliente"));
                cliente.setDinero(rs.getInt("dinero"));
                cliente.setEstadoTarjeta(rs.getBoolean("estadoTarjeta"));
            }
            st.close();
            Conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("No se pudo realizar la consulta");
            return null;
        }
        return cliente;
    }
    public boolean consultarContra(int contra, int nit){
        String consulta = "SELECT \"contraseña\" FROM \"TarjetaCliente\" \n" +
"WHERE \"nitTarjetaCliente\" = "+nit+" and \"contraseña\" ="+contra;
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
            System.err.println("No se pudo realizar la consulta");
        }
        return false;
    }
    public boolean reactivar(int nit) throws ClassNotFoundException{
        String consulta = "update \"TarjetaCliente\" set \"estadoTarjeta\" = true \n" +
"where \"nitTarjetaCliente\" ="+nit;
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            st.executeUpdate(consulta);
            st.close();
            Conexion.cerrarConexion();
            return true;
        } catch (SQLException e) {
            System.out.println("contraseña invalida");
        }
        return false;
    }
    // hay que restarle al retirar falta
    public boolean retirar(int nit, int monto) throws ClassNotFoundException{
        Cliente user = consultar(nit);
        if((user.getDinero()-monto)<0){
            return false;
        }
        String consulta = "update \"TarjetaCliente\" set \"dinero\" = "+(user.getDinero()-monto)+" \n" +
"where \"nitTarjetaCliente\" ="+nit;
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            st.executeUpdate(consulta);
            st.close();
            Conexion.cerrarConexion();
            return true;
        } catch (SQLException e) {
            System.out.println("no se pudo realizar el retiro");
        }
        return false;
    }
}
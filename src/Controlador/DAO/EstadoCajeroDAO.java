/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author TOSHIBA
 */
public class EstadoCajeroDAO {
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public EstadoCajeroDAO() {
        con = null;
        st = null;
        rs=null;
    }
    public boolean retirar(int dinero) throws ClassNotFoundException {
        int dineroActual ;
        dineroActual = consultarDinero();
        String consulta = "update \"Cajero\" set \"deposito\"= "+(dineroActual-dinero)+"  \n" +
"WHERE \"idCajero\"=1";
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
    public int consultarDinero(){
        int dinero = 0;
        String consulta = "SELECT \"deposito\" FROM \"Cajero\" WHERE \"idCajero\" = 1";
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            if(rs.next()){
                dinero = rs.getInt("deposito");
            }
            st.close();
            Conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("No se pudo realizar la consulta");
            return 0;
        }
        return dinero;
    }
    public int consultarTopeHoy(){
        int tope = 0;
        String consulta = "SELECT \"maxRetiroDia\" FROM \"Cajero\" WHERE \"idCajero\" = 1";
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            if(rs.next()){
                tope = rs.getInt("maxRetiroDia");
            }
            st.close();
            Conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("No se pudo realizar la consulta");
            return 0;
        }
        return tope;
    }
    public boolean modificarDinero(int dinero) throws ClassNotFoundException {
        int dineroActual ;
        dineroActual = consultarDinero();
        String consulta = "update \"Cajero\" set \"deposito\"= "+(dineroActual+dinero)+"  \n" +
"WHERE \"idCajero\"=1";
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
    public boolean modificarTopeHoy(int dinero) throws ClassNotFoundException {
        String consulta = "update \"Cajero\" set \"maxRetiroDia\"= "+dinero+"  \n" +
"WHERE \"idCajero\"=1";
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

}

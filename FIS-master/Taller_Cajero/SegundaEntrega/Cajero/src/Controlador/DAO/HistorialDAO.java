/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DAO;

import Modelo.Registro;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author TOSHIBA
 */
public class HistorialDAO {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Registro> registros;

    public HistorialDAO() {
        con = null;
        st = null;
        rs=null;
    }
    public ArrayList<Registro> consultaDiario(){
        registros = null;
        String consulta = "SELECT * FROM HistorialRegistro, TarjetaCliente, Cliente WHERE where fecha >= dateadd([day], datediff([day], '19000101', getdate()), '19000101') and fecha < dateadd([day], datediff([day], '19000101', getdate()) + 1, '19000101')"
                + "and HistorialRegistro.nitTarjetaCliente = TarjetaCliente.nitTarjetaCliente"
                + "and TarjetaCliente.idCliente = Cliente.idCliente";
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            registros = new ArrayList<>();
            while(rs.next()){
                Registro registro = new Registro();
                registro.setId(rs.getInt("idHistorialRegistro"));
                registro.setFecha(rs.getDate("fechha"));
                registro.setMontoRetirado(rs.getInt("monto"));
                registro.setNitTarjetaUsuario(rs.getInt("nitTarjetaCliente"));
                registro.setNombreUsuario(rs.getString("nombre"));
                registro.setIdCajero(rs.getInt("idCajero"));
                registros.add(registro);
            }
            st.close();
            Conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("No se pudo realizar la consulta");
            return null;
        }
            return registros;
    }
    public ArrayList<Registro> consultaAño(){
        registros = null;
        String consulta = "SELECT * FROM HistorialRegistro, TarjetaCliente, Cliente WHERE where fecha >= dateadd([year], datediff([year], '19000101', getdate()), '19000101') and fecha < dateadd([year], datediff([year], '19000101', getdate()) + 1, '19000101')"
                + "and HistorialRegistro.nitTarjetaCliente = TarjetaCliente.nitTarjetaCliente"
                + "and TarjetaCliente.idCliente = Cliente.idCliente";
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            registros = new ArrayList<>();
            while(rs.next()){
                Registro registro = new Registro();
                registro.setId(rs.getInt("idHistorialRegistro"));
                registro.setFecha(rs.getDate("fechha"));
                registro.setMontoRetirado(rs.getInt("monto"));
                registro.setNitTarjetaUsuario(rs.getInt("nitTarjetaCliente"));
                registro.setNombreUsuario(rs.getString("nombre"));
                registro.setIdCajero(rs.getInt("idCajero"));
                registros.add(registro);
            }
            st.close();
            Conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("No se pudo realizar la consulta");
            return null;
        }
            return registros;
    }
    public boolean insertarRegistro(int monto, int nit, int idCajero){
        java.util.Date fecha = new Date();
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            String inserccion = "INSERT INTO HistorialRegistro VALUES("+fecha+","+monto+","+nit+","+idCajero+")";
            st.executeUpdate(inserccion);
            st.close();
            Conexion.cerrarConexion();
        } catch (Exception e) {
            System.out.println("no s epudo realizar la insercion");
        }
        return false;
    }
}
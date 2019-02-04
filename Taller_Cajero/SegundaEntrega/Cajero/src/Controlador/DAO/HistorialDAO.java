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
    public ArrayList<Registro> consultaRegistros(String fechaInicio,String fechaFin){
        registros = null;
        String consulta = "SELECT \"idregistro\",\"fecha\",\"montoRetirado\",\"TarjetaCliente\".\"nitTarjetaCliente\",\"idCajero\",\"nombre\"\n" +
"FROM \"Registro\",\"TarjetaCliente\",\"Cliente\"\n" +
"WHERE \"fecha\" BETWEEN '"+fechaInicio+"' AND '"+fechaFin+"'\n" +
"and \"Registro\".\"nitTarjetaCliente\" = \"TarjetaCliente\".\"nitTarjetaCliente\"\n" +
"and \"TarjetaCliente\".\"idCliente\" = \"Cliente\".\"idCliente\"";
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            registros = new ArrayList<>();
            while(rs.next()){
                Registro registro = new Registro();
                registro.setId(rs.getInt("idregistro"));
                registro.setFecha(rs.getDate("fecha"));
                registro.setMontoRetirado(rs.getInt("montoRetirado"));
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
            String inserccion = "INSERT INTO public.\"Registro\"(\n" +
"	fecha, \"montoRetirado\", \"nitTarjetaCliente\", \"idCajero\")"
                    + "VALUES('"+fecha+"',"+monto+","+nit+","+idCajero+")";
            st.executeUpdate(inserccion);
            st.close();
            Conexion.cerrarConexion();
        } catch (Exception e) {
            System.out.println("no s epudo realizar la insercion");
        }
        return false;
    }
}
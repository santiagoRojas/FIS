/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DAO;

import Controlador.Conexion.Conexion;
import Mundo.Registropedidos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author TOSHIBA
 */
public class HistorialRegistro {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Registropedidos> registros;

    public HistorialRegistro() {
        con = null;
        st = null;
        rs=null;
    }
    public ArrayList<Registropedidos> consultaPedidos(){
        registros = null;
        String consulta = "SELECT \"idregistro\",\"fecha\",\"Usuario\".\"idusuario\",\"nitProducto\",\"Producto\".\"nombre\",\"Usuario\".\"nombreUsuario\",\"Producto\".\"valor\"\n" +
"FROM \"RegistroPedidos\",\"Usuario\",\"Producto\"\n" +
"WHERE \"RegistroPedidos\".\"idusuario\" = \"Usuario\".\"idusuario\"\n" +
"and \"RegistroPedidos\".\"idproducto\" = \"Producto\".\"idproducto\"";
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            registros = new ArrayList<>();
            while(rs.next()){
                Registropedidos registro = new Registropedidos();
                registro.setIdRegistro(rs.getInt("idregistro"));
                registro.setFecha(rs.getDate("fecha"));
                registro.setId_usuario(rs.getInt("idUsuario"));
                registro.setNit_producto(rs.getInt("nitProducto"));
                registro.setNombre_producto(rs.getString("nombre"));
                registro.setNombre_usuario(rs.getString("nombreUsuario"));
                registro.setValor(rs.getInt("valor"));
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
    
    public boolean eliminarPedido(int nit) throws ClassNotFoundException{
        String eliminar = "DELETE FROM public.\"RegistroPedidos\"\n" +
"	WHERE \"idRegistro\" ="+nit;
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
    
    public boolean generarPedido(int idProducto, int idUsuario){
        java.util.Date fecha = new Date();
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            String inserccion = "INSERT INTO public.\"RegistroPedidos\"(\n" +
"	idusuario, idproducto, fecha)\n" +
"	VALUES ("+idUsuario+","+idProducto+",'"+fecha+"')";
            st.executeUpdate(inserccion);
            st.close();
            Conexion.cerrarConexion();
            return true;
        } catch (Exception e) {
            System.out.println("no s epudo realizar la insercion");
        }
        return false;
    }
}

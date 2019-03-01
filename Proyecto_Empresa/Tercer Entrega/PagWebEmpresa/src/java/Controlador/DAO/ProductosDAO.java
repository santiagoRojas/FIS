/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DAO;

import Controlador.Conexion.Conexion;
import Mundo.Producto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author TOSHIBA
 */
public class ProductosDAO {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private Producto producto;
    public ProductosDAO() {
        con = null;
        st = null;
        rs=null;
    }
    
    public Producto consultarProducto(int nit){
        producto = null;
        String consulta = "SELECT * FROM public.\"TarjetaCliente\", public.\"Cliente\"   \n" +
"WHERE public.\"Cliente\".\"idCliente\" = public.\"TarjetaCliente\".\"idCliente\" \n" +
"and  \"nitTarjetaCliente\" = "+nit;
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            if(rs.next()){
                producto = new Producto();
                producto.setNit(rs.getInt("nitProducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setTipoo(rs.getString("tipo"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setValor(rs.getInt("valor"));
            }
            st.close();
            Conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("No se pudo realizar la consulta");
            return null;
        }
        return producto;
    }
    
    public void retirar(int nit, int monto) throws ClassNotFoundException{
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
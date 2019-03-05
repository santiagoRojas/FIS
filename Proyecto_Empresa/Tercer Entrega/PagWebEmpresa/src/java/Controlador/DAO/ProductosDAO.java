/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DAO;

import Controlador.Conexion.Conexion;
import Mundo.Producto;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author TOSHIBA
 */
public class ProductosDAO {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Producto> productos;
    public ProductosDAO() {
        con = null;
        st = null;
        rs=null;
    }
    
    public ArrayList<Producto> consultarProductos(){
        productos = null;
        String consulta = "SELECT * FROM public.\"Producto\" ";
        try {
            InputStream is;
            con = Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            productos = new ArrayList<>();
            while(rs.next()){
                Producto producto = new Producto();
                producto = new Producto();
                producto.setNit(rs.getInt("nitProducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setTipoo(rs.getString("tipo"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setValor(rs.getInt("valor"));
                is = rs.getBinaryStream("foto");
                BufferedImage bi = ImageIO.read(is);
                producto.setFoto(new ImageIcon(bi));
                productos.add(producto);
            }
            st.close();
            Conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("No se pudo realizar la consulta");
            return null;
        }
        return productos;
    }
    //falta insertar la foto correctamente
    public boolean agregarProducto(Producto producto) throws ClassNotFoundException{
        String insertar = "INSERT INTO public.\"Producto\"(\n" +
"	descripcion, nombre, tipo, valor, foto)\n" +
"	VALUES ('"+producto.getDescripcion()+"', '"+producto.getNombre()+"', '"+producto.getTipoo()+"', "+producto.getValor()+", "+producto.getFoto()+")   ";
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            st.executeUpdate(insertar);
            st.close();
            Conexion.cerrarConexion();
            return true;
        } catch (SQLException e) {
            System.out.println("no se pudo realizar el agregado");
        }
        return false;
    }
    public boolean eliminarProducto(int nit) throws ClassNotFoundException{
        
        String eliminar = "DELETE FROM public.\"Producto\"\n" +
"	WHERE \"nitProducto\" ="+nit;
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
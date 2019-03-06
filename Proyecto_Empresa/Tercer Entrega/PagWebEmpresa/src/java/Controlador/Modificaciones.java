package Controlador;

import Controlador.DAO.HistorialRegistro;
import Controlador.DAO.ProductosDAO;
import Controlador.DAO.UsuarioDAO;
import Mundo.Producto;
import javax.swing.ImageIcon;



/**
 * @author TOSHIBA
 * @version 1.0
 * @created 04-mar.-2019 6:29:14 p. m.
 */
public class Modificaciones {

        private ProductosDAO env1;
        private UsuarioDAO env2;
        private HistorialRegistro env3;
	public Modificaciones(){
            env1 = null;
            env2=null;
            env3 = null;
	}

	public boolean agregarProducto(String descripcion, String foto, int nit, String nombre, String tipo, int valor) throws ClassNotFoundException{
            Producto producto = new Producto();
            producto.setDescripcion(descripcion);
            producto.setFoto(foto);
            producto.setNit(nit);
            producto.setNombre(nombre);
            producto.setTipoo(tipo);
            producto.setValor(valor);
            env1 = new ProductosDAO();
            return env1.agregarProducto(producto);
	}

	public boolean bloquearUsuario(String correo) throws ClassNotFoundException{
            env2 = new UsuarioDAO();
		return env2.BloquearUsuario(correo);
	}

	public boolean desbloquearUSuario(String correo) throws ClassNotFoundException{
            env2 = new UsuarioDAO();
		return env2.desbloquearUSuario(correo);
	}

	public boolean eliminarPedidos(int idPedido) throws ClassNotFoundException{
            env3 = new HistorialRegistro();
		return env3.eliminarPedido(idPedido);
	}

	public boolean eliminarProducto(int nit) throws ClassNotFoundException{
            env1 = new ProductosDAO();
		return env1.eliminarProducto(nit);
	}

	public boolean eliminarUsuario(String correo) throws ClassNotFoundException{
            env2 = new UsuarioDAO();
		return env2.eliminarUsuario(correo);
	}

	public boolean generarPedido(int idProducto, int idUsuario){
            env3 = new HistorialRegistro();
		return env3.generarPedido(idProducto, idUsuario);
	}
}//end Modificaciones
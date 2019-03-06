package Controlador;


import Controlador.DAO.AdministradorDAO;
import Controlador.DAO.HistorialRegistro;
import Controlador.DAO.ProductosDAO;
import Controlador.DAO.UsuarioDAO;
import Mundo.Administrador;
import Mundo.Producto;
import Mundo.Registropedidos;
import Mundo.Usuario;
import java.util.ArrayList;


public class Consultar {

         private ProductosDAO env1;
        private UsuarioDAO env2;
        private HistorialRegistro env3;
        private AdministradorDAO env4;
	public Consultar(){
            env1 = null;
            env2=null;
            env3 = null;
            env4 = null;
	}
	public ArrayList<Producto> consultaCatalogo(){
            env1 = new ProductosDAO();
		return env1.consultarProductos();
	}


	public Administrador consultarAdministrador(String correo, String contrasena){
            
            env4 = new AdministradorDAO();
		return env4.consultarAdministrador(correo, contrasena);
	}


	public ArrayList<Registropedidos> consultarPedidos(){
            env3 = new HistorialRegistro();
		return env3.consultaPedidos();
	}


	public Usuario consultarUsuario(String correo, String contrasena){
            env2 = new UsuarioDAO();
		return env2.consultarUsuario(correo, contrasena);
	}
}//end Consultar
package Controlador;

import Controlador.DAO.UsuarioDAO;
import Mundo.Usuario;



public class Registrar {

	public boolean RegistrarUsuario(String apellido, String contrasena, String correo, boolean estado, String nombre,int telefono) throws ClassNotFoundException{
            UsuarioDAO env = new UsuarioDAO();
            Usuario usuario = new Usuario();
            usuario.setApellido(apellido);
            usuario.setContrasena(contrasena);
            usuario.setCorreo(correo);
            usuario.setEstadoUsuario(estado);
            usuario.setNombre(nombre);
            usuario.setTelefono(telefono);
		return env.agregarUsuario(usuario);
	}
}//end Registrar
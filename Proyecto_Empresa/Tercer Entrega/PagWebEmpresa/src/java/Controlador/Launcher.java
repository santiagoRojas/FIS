/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Mundo.Administrador;
import Mundo.Registropedidos;
import Mundo.Usuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author TOSHIBA
 */
public class Launcher {
    public static void main(String[] args) throws ClassNotFoundException {
         Registrar cons=new Registrar();
         cons.RegistrarUsuario("leon","1234", "leon@hotmail.com", true, "erogo", 1233);
            
    }
}

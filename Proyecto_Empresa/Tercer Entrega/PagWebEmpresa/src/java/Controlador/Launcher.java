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
    public static void main(String[] args) {
         Consultar cons=new Consultar();
            ArrayList<Registropedidos> admi =  null;
            String text;
            admi = cons.consultarPedidos();
            JOptionPane.showMessageDialog(null, admi.get(0).getNombre_producto());
    }
}

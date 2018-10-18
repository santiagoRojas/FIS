/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.DAO.TarjetaClienteDAO;
import Modelo.Cliente;

/**
 *
 * @author jorge diaz
 */
public class Retirar {
    
    public boolean RetirarFondos(int monto, int nit){
        TarjetaClienteDAO tarjeta = new TarjetaClienteDAO();
        return tarjeta.retirar(nit, monto);
    }
    
    public int verificarFondos(int monto , Cliente user){
        return 0;
    }
}

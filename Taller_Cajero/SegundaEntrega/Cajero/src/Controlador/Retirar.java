/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.DAO.EstadoCajeroDAO;
import Controlador.DAO.HistorialDAO;
import Controlador.DAO.TarjetaClienteDAO;

/**
 *
 * @author jorge diaz
 */
public class Retirar {
    
    public boolean RetirarFondos(int monto, int nit) throws ClassNotFoundException{
        TarjetaClienteDAO tarjeta = new TarjetaClienteDAO();
        EstadoCajeroDAO estado = new EstadoCajeroDAO();
        HistorialDAO retiro = new HistorialDAO();
        estado.retirar(monto);
        retiro.insertarRegistro(monto, nit, 1);
        return tarjeta.retirar(nit, monto);
    }

}

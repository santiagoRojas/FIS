/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.DAO.EstadoCajeroDAO;

/**
 *
 * @author jorge diaz
 */
public class FuncionesAdmi {
    public boolean ingresarDinero(int monto) throws ClassNotFoundException{
        EstadoCajeroDAO estado=new EstadoCajeroDAO();
        return estado.modificarDinero(monto);
    }
    public boolean modificarTopeHoy(int monto) throws ClassNotFoundException{
        EstadoCajeroDAO estado=new EstadoCajeroDAO();
        return estado.modificarTopeHoy(monto);
    }
    public int consultarDinero(){
        EstadoCajeroDAO estado=new EstadoCajeroDAO();
        return estado.consultarDinero();
    }
}

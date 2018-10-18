/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Controlador.DAO.TarjetaAdmisDAO;
import Controlador.DAO.TarjetaClienteDAO;
import Modelo.Administrador;
import Modelo.Cliente;

/**
 *
 * @author jorge diaz
 */
public class Consultas {
    
    public Administrador ValidarTarjetaAdmin(int nit){
        Administrador admin = null;
        TarjetaAdmisDAO consult = new TarjetaAdmisDAO();
        admin = consult.consultar(nit);
        return admin;
    }
    
    public Cliente ValidarTarjetaCliente(int nit){
        Cliente user = null;
        TarjetaClienteDAO consult = new TarjetaClienteDAO();
        user = consult.consultar(nit);
        return user;
    }
    
    
}

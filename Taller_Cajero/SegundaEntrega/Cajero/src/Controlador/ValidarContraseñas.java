/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.DAO.TarjetaAdmisDAO;
import Controlador.DAO.TarjetaClienteDAO;

/**
 *
 * @author jorge diaz
 */
public class ValidarContraseñas {
     public boolean ValidarCliente(int nit, int contra){
         TarjetaClienteDAO tarjeta = new TarjetaClienteDAO(); 
         return tarjeta.consultarContra(contra, nit);
     }
     
     public boolean BloquearTarjetaCliente(int nit) throws ClassNotFoundException{
         TarjetaClienteDAO tarjeta = new TarjetaClienteDAO();
        return tarjeta.bloquearTarjeta(nit);
    }
     
     public boolean ValidarAdministrador(int nit, int contra){
         TarjetaAdmisDAO tarjeta = new TarjetaAdmisDAO(); 
         return tarjeta.consultarContra(contra, nit);
     }
     
     public boolean BloquearTarjetaAdmin(int nit) throws ClassNotFoundException{
         TarjetaAdmisDAO tarjeta = new TarjetaAdmisDAO();
        return tarjeta.bloquearTarjeta(nit);
    }
}

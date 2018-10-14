/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Estudiantes
 */
public class Registro {
    private Date fecha;
    private int id;
    private int montoRetirado;
    private int nitTarjetaUsuario;
    private String nombreUsuario;
    private int idCajero;

    public int getIdCajero() {
        return idCajero;
    }

    public void setIdCajero(int idCajero) {
        this.idCajero = idCajero;
    }
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMontoRetirado() {
        return montoRetirado;
    }

    public void setMontoRetirado(int montoRetirado) {
        this.montoRetirado = montoRetirado;
    }

    public int getNitTarjetaUsuario() {
        return nitTarjetaUsuario;
    }

    public void setNitTarjetaUsuario(int nitTarjetaUsuario) {
        this.nitTarjetaUsuario = nitTarjetaUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    
    
}

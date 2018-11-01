/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Estudiantes
 */
public class Administrador {
    private String nombre;
    private String apellido;
    private boolean estadoTarjeta;
    private int id;
    private int nit;

    public boolean getEstadoTarjeta(){
        return estadoTarjeta;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public boolean isEstadoTarjeta() {
        return estadoTarjeta;
    }

    public void setEstadoTarjeta(boolean estadoTerjeta) {
        this.estadoTarjeta = estadoTerjeta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }
    
}

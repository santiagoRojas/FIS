
package Mundo;

import java.sql.Date;

public class Registropedidos {
       private Date fecha;
       private int id_usuario;
       private int idRegistro;
       private int nit_producto;
       private String nombre_producto;
       private String nombre_usuario;
       private int Valor;

    public int getValor() {
        return Valor;
    }

    public void setValor(int Valor) {
        this.Valor = Valor;
    }

    public Date getFecha(){
      return this.fecha;
    }
    public int getId_usuario(){
      return this.id_usuario;
    }
    public int getIdRegistro(){
      return this.idRegistro;
    }
    public int getNit_producto(){
      return this.nit_producto;
    }
    public String getNombre_producto(){
      return this.nombre_producto;
    }
    public String getNombre_usuario(){
      return this.nombre_usuario;
    }

      public void setFecha(Date value){
        this.fecha = value;
      }

      public void setId_usuario(int value){
        this.id_usuario = value;
      }

      public void setIdRegistro(int value){
        this.idRegistro = value;
      }

      public void setNit_producto(int value){
        this.nit_producto = value;
      }

      public void setNombre_producto(String value){
        this.nombre_producto = value;
      }

      public void setNombre_usuario(String value){
        this.nombre_usuario = value;
      }


  }


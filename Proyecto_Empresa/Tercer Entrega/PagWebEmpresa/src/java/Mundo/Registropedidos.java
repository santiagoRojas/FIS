
package Mundo;

public class Registropedidos {
       private int fecha;
       private int id_usuario;
       private int nit_registro;
       private int nit_producto;
       private String nombre_producto;
       private String nombre_usuario;

    public int getFecha(){
      return this.fecha;
    }
    public int getId_usuario(){
      return this.id_usuario;
    }
    public int getNit_registro(){
      return this.nit_registro;
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

      public void setFecha(int value){
        this.fecha = value;
      }

      public void setId_usuario(int value){
        this.id_usuario = value;
      }

      public void setNit_registro(int value){
        this.nit_registro = value;
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


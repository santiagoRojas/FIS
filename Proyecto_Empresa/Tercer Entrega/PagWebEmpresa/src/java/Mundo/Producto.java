
package Mundo;

public class Producto {
       private String descripcion;
       private int nit;
       private int valor;
       private String nombre;
       private String tipoo;

    public String getDescripcion(){
      return this.descripcion;
    }
    public int getNit(){
      return this.nit;
    }
    public int getValor(){
      return this.valor;
    }
    public String getNombre(){
      return this.nombre;
    }
    public String getTipoo(){
      return this.tipoo;
    }

      public void setDescripcion(String value){
        this.descripcion = value;
      }

      public void setNit(int value){
        this.nit = value;
      }

      public void setValor(int value){
        this.valor = value;
      }

      public void setNombre(String value){
        this.nombre = value;
      }

      public void setTipoo(String value){
        this.tipoo = value;
      }


  }


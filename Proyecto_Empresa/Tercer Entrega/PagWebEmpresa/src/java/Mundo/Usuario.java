
package Mundo;


public class Usuario {
       private String nombre;
       private String apellido;
       private String correo;
       private String contrasena;
       private boolean estadoUsuario;
       private int telefono;
       private int idUsuario;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
       
    

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
       
    

    public boolean isEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(boolean estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public String getNombre(){
      return this.nombre;
    }
    public String getApellido(){
      return this.apellido;
    }
    public String getCorreo(){
      return this.correo;
    }
    public String getContrasena(){
      return this.contrasena;
    }

      public void setNombre(String value){
        this.nombre = value;
      }

      public void setApellido(String value){
        this.apellido = value;
      }

      public void setCorreo(String value){
        this.correo = value;
      }

      public void setContrasena(String value){
        this.contrasena = value;
      }


  }


<%@page import="javafx.scene.control.Alert"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Controlador.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="moderador.js"></script>
<title> Didier´s Sports</title>
<meta charset="UTF-8">
<style type="text/css">
	#header{
	margin:auto;
	width:1000px;
	font-family:Arial, Helvetica, sans-serif;
	}

	ul,ol {
		list-style:none;
	}
	.nav li a{
		background-color:#000;
		color:#fff;
		text-decoration:none;
		padding:20px 25px;
		display:block;
	}

	.nav li a:hover{
		background-color:#434343;
	}
	.nav>li{
	float:left;
	}
	.nav li ul{
		display:none;
		position:absolute;
		
	}
	.nav li:hover > ul{
		display:block;
	}
</style> 
</head>
<%!
            String nombre= null;
            String apellido = null;
            String telefono = null;
            String contrasena = null;
            String correo = null;
            boolean retorno = false;
%>
<% 
    contrasena = request.getParameter("clave");
    correo = request.getParameter("correo");
    nombre = request.getParameter("nombre");
    telefono = request.getParameter("telefono");
    apellido = request.getParameter("apellido");
    if(nombre != null && apellido != null && contrasena != null && correo != null && telefono != null){
        Registrar reg = new Registrar();
         retorno= reg.RegistrarUsuario(apellido, contrasena, correo, true, nombre, Integer.parseInt(telefono) );
    }
    if(nombre != null && apellido != null && contrasena != null && correo != null && telefono != null && retorno == false){
%>
<script type="text/javascript">
alert("Estas Bloqueado Putoo!!");
</script>
<%}%>
<body style="background-color:beige;" id="cuerpo">

<center>

<font size='7'><font face="Comic Sans MS,Arial,Verdana">DIDIER'S SPORTS</font></font>
<br>

<img src="Imagenes/principal.JPG" style="width: 600px; height: 250px;">
</center>

<div id="header">
	<ul class="nav">
		<li><a  onclick="inicio()">Inicio</a></li>
		<li><a  onclick="quienesSomos()">Quienes Somos</a>
			<ul>
			<li><a  onclick="mision()">Mision</a></li>
			<li><a  onclick="vision()">Vision</a></li>
			</ul>
		</li>
		<li><a  onclick="contactenos()">Contactenos</a></li>
		
                <li><a href="Formulario.jsp" >Registrarse</a></li>
		<li><input type="checkbox" name="c1" onclick="showMe('div1', this)">Ya estoy registrado</li>
		
</div>


<br><br><br>
<div id="div1" style="display:none" align="right">
    <form method="post" action="Usuario.jsp">
           <input type="hidden" name="registroForm"/>
           <br>
          Correo electronico:<br>
          <input type="text" name="correo" value="">
          <br><br>
          Contraseña:<br>
          <input type="password" name="clave" value="">
          <br><br>
          <input type="submit" name="sub1" >
        </form>
</div>
<h1 id="titulo" >
Inicio

</h1>
<textarea id="textToEncode" style="width: 49%; height: 200px;" readonly>

</textarea>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<img src="Imagenes/secundaria.JPG" style="width: 200px; height: 150px;"align="rigth">


</html>

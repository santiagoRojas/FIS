<%-- 
    Document   : Catalogo
    Created on : 6/03/2019, 02:58:42 AM
    Author     : TOSHIBA
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Mundo.Registropedidos"%>
<%@page import="Controlador.Modificaciones"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Mundo.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Controlador.Consultar"%>
<%@page import="Mundo.Administrador"%>
<%@page import="Mundo.Usuario"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<%!
            String correo ="";
            String contrasena="";
            int idProducto = 0;
            int idUsuario = 0;
            String pedi = "";
%>
<% 
    pedi = request.getParameter("pedidos");
    contrasena = request.getParameter("clave");
    correo = request.getParameter("correo");
    idProducto = Integer.parseInt(request.getParameter("idProducto"));
    idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
    if(idProducto != 0 && idUsuario != 0){
        Modificaciones mod = new Modificaciones();
        mod.generarPedido(idProducto, idUsuario);
    }
%>
<%!
    String nombre="";
    String apellido="";
    Administrador admi =  null;
    Usuario user = null;
public void consultaAdministrador(){
    Consultar cons=new Consultar();
    admi = cons.consultarAdministrador(correo, contrasena);
if(admi != null){
    nombre  = admi.getNombre();
    apellido = admi.getApellido();
}
}
public void consultaUsuario(){
    Consultar cons=new Consultar();
    user = cons.consultarUsuario(correo, contrasena);
if(user != null){
    nombre  = user.getNombre();
    apellido = user.getApellido();
}
    
}
%>
<% 
                 consultaAdministrador();
                 consultaUsuario();
%>
<% if (user !=null && user.isEstadoUsuario() == true){ %> 
Usuario   <%= nombre %> <%= apellido %> <form method="post" action="index1.jsp"><input type="submit" name="sub1" value="cerrar sesion" "></form>
<% }else if (admi !=null){ %> 
Administrador   <%= nombre %> <%= apellido %> <form method="post" action="index1.jsp"><input type="submit" name="sub1" value="cerrar sesion" "></form>
<% } %>

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

<body style="background-color:beige;" id="cuerpo">

<center>

<font size='7'><font face="Comic Sans MS,Arial,Verdana">DIDIER'S SPORTS</font></font>
<br>

<img src="Imagenes/principal.JPG" style="width: 600px; height: 250px;">
</center>

<div id="header">
	<ul class="nav">
		<li><a  onclick="inicio()">Inicio</a></li>
                <li><a  onclick="catalogo()">Catalogo</a></li>
		<li><a  onclick="quienesSomos()">Quienes Somos</a>
			<ul>
			<li><a  onclick="mision()">Mision</a></li>
			<li><a  onclick="vision()">Vision</a></li>
			</ul>
		</li>
		<li><a  onclick="contactenos()">Contactenos</a></li>
		
		<li><a href="formulario.html" >Registrarse</a></li>
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
          <input type="submit" name="sub1">
        </form>
</div>
<h1 id="titulo" >
Catalogo

</h1>

<%!
            ArrayList<Producto> productos;
            Producto producto;
%>
<% 
    Consultar con = new Consultar();
    productos = con.consultaCatalogo();
    for(int i = 0;i < productos.size();i++){
        producto = productos.get(i);
%>
<img src="<%= producto.getFoto() %>">  <%= producto.getNombre()%> - <%= producto.getNit() %>  -  <%= producto.getTipoo()%>  -  <%= producto.getValor()%><br><br>
<%= producto.getDescripcion()%>
<% 
    if(user != null){
%>
<form method="post" action="Catalogo.jsp">
    <input type="hidden" name="correo" value="<%= correo %>">
    <input type="hidden" name="clave" value="<%= contrasena %>">
    <input type="hidden" name="idProducto" value="<%= producto.getIdProducto() %>">
    <input type="hidden" name="idUsuario" value="<%= user.getIdUsuario() %>">
    <input type="submit" value="Pedir">
</form>
<br><br>
<% 
    }
    }
ArrayList<Registropedidos> pedidos = null;
Registropedidos pedido = null;
if(pedi != "" && admi != null){
%>
<form method="post" action="Catalogo.jsp">
<input type="hidden" name="correo" value="<%= correo %>">
<input type="hidden" name="clave" value="<%= contrasena %>">
<input type="hidden" name="pedidos" value="yes">
<input type="submit" name="sub6" value="Consultar Pedidos">
</form>
<textarea id="textToEncode" style="width: 49%; height: 200px;" readonly>
<% 


    Consultar cons = new Consultar();
    pedidos = cons.consultarPedidos();
    
    for(int i = 0; i < pedidos.size();i++){
        pedido = pedidos.get(i);
        String pattern = "yyyy-MM-dd";
SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

String date = simpleDateFormat.format(pedido.getFecha());
%>
|PeidoNo:<%= pedido.getIdRegistro() %>|
|UsuarioNo:<%= pedido.getId_usuario()%>|
|Nombre Usuario:<%= pedido.getNombre_usuario()%>|
|ProductoNo:<%= pedido.getNit_producto()%>|
|Nombre Producto:<%= pedido.getNombre_producto()%>|
|Precio:<%= pedido.getValor()%>|
|Fecha de pedido:<%= date%>|
<%        
    }
}
%>
</textarea>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<img src="../src/java/Imagenes/secundaria.JPG" style="width: 200px; height: 150px;"align="rigth">

<% if (admi !=null){ %> 
<li><input type="checkbox" name="c1" onclick="showMe('div1', this)">   Bloquear Usuario</li>
		
</div>

<br><br><br>
<div id="div1" style="display:none" align="right">
    <form method="post" action="Catalogo.jsp">
        <input type="hidden" name="correo" value="<%= correo %>">
        <input type="hidden" name="clave" value="<%= contrasena %>">
           <input type="hidden" name="registroForm"/>
           <br>
          Correo electronico:<br>
          <input type="text" name="correoBloquear" value="">
          <br><br>
          <input type="submit" name="sub1">
        </form>
</div>
<li><input type="checkbox" name="c2" onclick="showMe('div2', this)">   Desbloquear Usuario</li>
		
</div>

<br><br><br>
<div id="div2" style="display:none" align="right">
    <form method="post" action="Catalogo.jsp">
        <input type="hidden" name="correo" value="<%= correo %>">
        <input type="hidden" name="clave" value="<%= contrasena %>">
           <input type="hidden" name="registroForm"/>
           <br>
          Correo electronico:<br>
          <input type="text" name="correoDesbloquear" value="">
          <br><br>
          <input type="submit" name="sub2">
        </form>
</div>
<% } %>
</html>



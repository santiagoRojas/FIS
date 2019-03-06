package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javafx.scene.control.Alert;
import Controlador.*;

public final class index1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


            String nombre= null;
            String apellido = null;
            String telefono = null;
            String contrasena = null;
            String correo = null;
            boolean retorno = false;

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <script src=\"moderador.js\"></script>\n");
      out.write("<title> Didier´s Sports</title>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<style type=\"text/css\">\n");
      out.write("\t#header{\n");
      out.write("\tmargin:auto;\n");
      out.write("\twidth:1000px;\n");
      out.write("\tfont-family:Arial, Helvetica, sans-serif;\n");
      out.write("\t}\n");
      out.write("\n");
      out.write("\tul,ol {\n");
      out.write("\t\tlist-style:none;\n");
      out.write("\t}\n");
      out.write("\t.nav li a{\n");
      out.write("\t\tbackground-color:#000;\n");
      out.write("\t\tcolor:#fff;\n");
      out.write("\t\ttext-decoration:none;\n");
      out.write("\t\tpadding:20px 25px;\n");
      out.write("\t\tdisplay:block;\n");
      out.write("\t}\n");
      out.write("\n");
      out.write("\t.nav li a:hover{\n");
      out.write("\t\tbackground-color:#434343;\n");
      out.write("\t}\n");
      out.write("\t.nav>li{\n");
      out.write("\tfloat:left;\n");
      out.write("\t}\n");
      out.write("\t.nav li ul{\n");
      out.write("\t\tdisplay:none;\n");
      out.write("\t\tposition:absolute;\n");
      out.write("\t\t\n");
      out.write("\t}\n");
      out.write("\t.nav li:hover > ul{\n");
      out.write("\t\tdisplay:block;\n");
      out.write("\t}\n");
      out.write("</style> \n");
      out.write("</head>\n");
      out.write('\n');
 
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

      out.write("\n");
      out.write("<div class=\"alert alert-success\">no se pudo registrar el usuario</div>\n");
}
      out.write("\n");
      out.write("<body style=\"background-color:beige;\" id=\"cuerpo\">\n");
      out.write("\n");
      out.write("<center>\n");
      out.write("\n");
      out.write("<font size='7'><font face=\"Comic Sans MS,Arial,Verdana\">DIDIER'S SPORTS</font></font>\n");
      out.write("<br>\n");
      out.write("\n");
      out.write("<img src=\"../src/java/Imagenes/principal.JPG\" style=\"width: 600px; height: 250px;\">\n");
      out.write("</center>\n");
      out.write("\n");
      out.write("<div id=\"header\">\n");
      out.write("\t<ul class=\"nav\">\n");
      out.write("\t\t<li><a  onclick=\"inicio()\">Inicio</a></li>\n");
      out.write("                <li><a  href=\"Catalogo.jsp\" >Catalogo</a></li>\n");
      out.write("\t\t<li><a  onclick=\"quienesSomos()\">Quienes Somos</a>\n");
      out.write("\t\t\t<ul>\n");
      out.write("\t\t\t<li><a  onclick=\"mision()\">Mision</a></li>\n");
      out.write("\t\t\t<li><a  onclick=\"vision()\">Vision</a></li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</li>\n");
      out.write("\t\t<li><a  onclick=\"contactenos()\">Contactenos</a></li>\n");
      out.write("\t\t\n");
      out.write("                <li><a href=\"Formulario.jsp\" >Registrarse</a></li>\n");
      out.write("\t\t<li><input type=\"checkbox\" name=\"c1\" onclick=\"showMe('div1', this)\">Ya estoy registrado</li>\n");
      out.write("\t\t\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("<br><br><br>\n");
      out.write("<div id=\"div1\" style=\"display:none\" align=\"right\">\n");
      out.write("    <form method=\"post\" action=\"Usuario.jsp\">\n");
      out.write("           <input type=\"hidden\" name=\"registroForm\"/>\n");
      out.write("           <br>\n");
      out.write("          Correo electronico:<br>\n");
      out.write("          <input type=\"text\" name=\"correo\" value=\"\">\n");
      out.write("          <br><br>\n");
      out.write("          Contraseña:<br>\n");
      out.write("          <input type=\"password\" name=\"clave\" value=\"\">\n");
      out.write("          <br><br>\n");
      out.write("          <input type=\"submit\" name=\"sub1\" >\n");
      out.write("        </form>\n");
      out.write("</div>\n");
      out.write("<h1 id=\"titulo\" >\n");
      out.write("Inicio\n");
      out.write("\n");
      out.write("</h1>\n");
      out.write("<textarea id=\"textToEncode\" style=\"width: 49%; height: 200px;\" readonly>\n");
      out.write("\n");
      out.write("</textarea>\n");
      out.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("<img src=\"../src/java/Imagenes/secundaria.jpg\" style=\"width: 200px; height: 150px;\"align=\"rigth\">\n");
      out.write("\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

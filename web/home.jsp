<%@page import="modelo.Usuario" %>
<%@page import="modelo.Usuario.Privilegio" %>
<% 
	Usuario usuario=null;
	if(session.getAttribute("usuario")!=null)
		usuario=(Usuario)session.getAttribute("usuario");
%>

<div id="centercontent">
<p><br></p>
<p><h1>Buscador de Subvenciones Si3_144</h1></p>
<p><br></p>
<p><br></p>
<p><br></p>
<% 
	if((usuario==null)||(usuario.getTipoUsuario()==Privilegio.visitante))
   {
%> 
	<h3> Bienvenido usuario, identif&iacute;quese o cr&eacute;ese una <a onclick="enlace('nuevoUsuario')" >cuenta nueva</a></h3>
<%
	} else {
%>
	<p> <h3 align="left"><% out.print("Bienvenido "+usuario.getNombre()); %></h3>
<%
	}
%>
<h3> Seleccione la acci&oacute;n a realizar en el men&uacute; de la izquierda o en las pesta&ntilde;as superiores.</h3>
<p><br></p>
<p><br></p>
<p><br></p>
<p><br></p>
<p><br></p>
<p><br></p>
<p><br></p>
<p><br></p>
<p><br></p>
<p><br></p>
</div>


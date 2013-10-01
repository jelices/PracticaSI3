<%@page import="modelo.Usuario" %>
<%@page import="modelo.Usuario.Privilegio" %>

<% 
	Usuario usuario=null;
	if(session.getAttribute("usuario")!=null)
		usuario=(Usuario)session.getAttribute("usuario");
%>

<script language="javascript">
	function enlace(pagina)
	{
		document.getElementById('pagina').value=pagina;
		document.forms[0].submit();
	}
	
</script>

<!-- start top menu and blog title-->

<div id="blogtitle">
</div>
		
		<div id="topmenu">
		<form  method="POST" action="actualizar.do">
			<input type="hidden" id="pagina" name="pagina"/>
		</form>
		
		<ul class="BLUE">

		<li><a onclick="enlace('home')" title="Links"><span>Inicio</span></a></li>
		<li><a onclick="enlace('buscar')" title="Links"><span>Buscador</span></a></li>
<% if((usuario==null)||(usuario.getTipoUsuario()==Privilegio.visitante))
{
%>
		<li><a onclick="enlace('nuevoUsuario')" title="Links"><span>Registrate</span></a></li>
<% 
	}
	else if((usuario.getTipoUsuario()==Privilegio.registrado))
   {
%>
		<li><a onclick="enlace('editarPerfil')" title="Links"><span>Modificar Perfil</span></a></li>
		<li><a onclick="enlace('cerrarSesion')" title="Links"><span>Cerrar Sesi&oacute;n</span></a></li>
<% } 
		else
   {
%>
		<li><a onclick="enlace('gestionUsuarios')" title="Links"><span>Gesti&oacute;n Usuarios</span></a></li>
		<li><a onclick="enlace('gestionSubvenciones')" title="Links"><span>Gesti&oacute;n Subvenciones</span></a></li>
		<li><a onclick="enlace('cerrarSesion')" title="Links"><span>Cerrar Sesi&oacute;n</span></a></li>
<% } %>
		</ul>
		
</div>

<!-- end top menu and blog title-->

<!-- start left box-->

<div id="leftcontent">
	<img style="margin-top:-9px; margin-left:-12px;" src="images/top2.jpg" alt="" />
<% 
	if((usuario==null)||(usuario.getTipoUsuario()==Privilegio.visitante))
   {
%> 
<form  method="POST" action="login.do" >
<table>
	<tr>
		<td align="right"> Usuario </td>
		<td> <input type="text" name="nombre" size="15"/> </td>
	</tr>
	<tr>
		<td align="right"> Password </td>
		<td> <input type="password" name="password" size="15"/> </td>
	</tr>
	<tr>
		<td></td>
		<td><input  type="submit" value="Enviar"/></td>
	</tr>
</table>
</form>
<%
	} else {
%>
	<p> <h3 align="left"><% out.print("Bienvenido "+usuario.getNombre()); %></h3>
	<%
	}
	%>
	<h3 align="left">Menu</h3>
	
	
<div align="left">
		<ul class="BLUE">
				<li><a onclick="enlace('home')" >Inicio</a></li>
				<li><a onclick="enlace('buscar')" >Buscador</a></li>
		
<% if((usuario==null)||(usuario.getTipoUsuario()==Privilegio.visitante))
{
%>
		<li><a onclick="enlace('nuevoUsuario')" >Registrate</a></li>
<% 
	}
	else if((usuario.getTipoUsuario()==Privilegio.registrado))
   {
%>
		<li><a onclick="enlace('editarPerfil')" >Modificar Perfil</a></li>
		<ul class="BLUE2">
			<li><a onclick="enlace('cambiarPassword')" >Cambiar contrase&ntilde;a</a></li>
			<li><a onclick="enlace('cambiarPerfil')" >Cambiar Datos Empresa</a></li>
			<li><a onclick="enlace('cambiarInformes')" >Cambiar Recepci&oacute;n de Informes</a></li>
		</ul>
		<li><a onclick="enlace('cerrarSesion')" >Cerrar Sesi&oacute;n</a></li>
<% } 
		else
   {
%>
		<li><a onclick="enlace('gestionUsuarios')" >Gesti&oacute;n Usuarios</a></li>
		<ul class="BLUE2">
			<li><a onclick="enlace('nuevoUsuario')" >Nuevo</a></li>
			<li><a href="editarUsuarios.do" >Modificar</a></li>
			<li><a href="eliminarUsuario.do">Eliminar</a></li>
		</ul>
		<li><a onclick="enlace('gestionSubvenciones')" >Gesti&oacute;n Subvenciones</a></li>
		<ul class="BLUE2">
			<li><a onclick="enlace('nuevaSubvencion')" >Nueva</a></li>
			<li><a href="editarSubvenciones.do" >Modificar</a></li>
			<li><a href="borrarSubvencion.do" >Eliminar</a></li>
		</ul>
		<li><a onclick="enlace('cerrarSesion')" >Cerrar Sesi&oacute;n</a></li>
<% } %>
	</ul>
	</div>
	
	<!-- You have to modify the "padding-top: when you change the content of this div to keep the footer image looking aligned -->
	
	<img style="padding-top:2px; margin-left:-12px; margin-bottom:-4px;" src="images/specs_bottom.jpg" alt="" />
	
	

</div>

<!-- end left box-->

<script language="javascript">

function copiar(pagina)
{
	campoIndice=document.getElementById('indice');
	lista=document.getElementById('usuariosS');
	campoIndice.value=lista.selectedIndex;
	document.getElementById('accion').value=pagina;
}

</script>

<%@page import="modelo.Usuario" %>
<%@page import="java.util.ArrayList" %>

<% 
	ArrayList<Usuario> usuarios=null;
	if(session.getAttribute("listaUsuarios")!=null)
	{
		usuarios=(ArrayList<Usuario>)session.getAttribute("listaUsuarios");
%> 



<div id="centercontent">
<p><br></p>
<p><br></p>
<p><br></p>
<p><br></p>
<p><br></p>
<p><br></p>
<form  method="POST" action="editarUsuario.do">
<table>
<tr>
<td> <b> Seleccione usuario </b></td>
</tr>
<tr>
<td>
<select name="usuariosS" id="usuariosS" size="<%= usuarios.size()%>" />
<%
	for(int i=0; i<usuarios.size(); i++)
		out.println("<OPTION value="+usuarios.get(i).getNombre()+">"+usuarios.get(i).getNombre()+"</OPTION>");
%>
</select>
</td></tr>
<tr><td><input type="hidden" name="indice" id="indice"/></td></tr>
<tr><td><input type="hidden" name="accion" id="accion"/></td></tr>
</table>
<table>
<tr>
<td> <input type="submit" value="Eliminar Usuario" onClick="copiar('borrar')" /> </td>
</tr>
</table>
</form>
<% }%>
<p><br></p>
<p><br></p>
<p><br></p>
<p><br></p>
<p><br></p>
<p><br></p>
<p><br></p>
</div>
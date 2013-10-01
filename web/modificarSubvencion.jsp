<script language="javascript">

function copiar(pagina)
{
	campoIndice=document.getElementById('indice');
	lista=document.getElementById('subvencionesS');
	campoIndice.value=lista.selectedIndex;
	document.getElementById('accion').value=pagina;
}

</script>

<%@page import="modelo.Subvencion" %>
<%@page import="java.util.ArrayList" %>

<% 
	ArrayList<Subvencion> subvenciones=null;
	if(session.getAttribute("listaSubvenciones")!=null)
	{
		subvenciones=(ArrayList<Subvencion>)session.getAttribute("listaSubvenciones");
%> 

<div id="centercontent">
<p><br></p>
<p><br></p>
<p><br></p>
<p><br></p>
<form  method="POST" action="editarSubvencion.do">
<table>
<tr>
<td> <b> Seleccione subvencion</b></td>
</tr>
<tr>
<td>
<select name="subvencionesS" id="subvencionesS" size="<%= subvenciones.size()%>" />
<%
	for(int i=0; i<subvenciones.size(); i++)
		out.println("<OPTION value="+subvenciones.get(i).getTitulo()+">"+subvenciones.get(i).getTitulo()+"</OPTION>");
%>
</select>
</td></tr>
<tr><td><input type="hidden" name="indice" id="indice"/></td></tr>
<tr><td><input type="hidden" name="accion" id="accion"/></td></tr>
</table>
<table>
<tr>
<td> <input type="submit" value="Modificar Subvencion" onClick="copiar('modificar')" /> </td>
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
<p><br></p>
</div>
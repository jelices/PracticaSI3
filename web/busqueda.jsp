<%@page import="modelo.Subvencion" %>
<%@page import="java.util.ArrayList" %>

<div id="centercontent">
<p><br></p>
<p><br></p>
<% 
	ArrayList<Subvencion> subvenciones=null;
	if(session.getAttribute("busqueda")!=null)
	{
		subvenciones=(ArrayList<Subvencion>)session.getAttribute("busqueda");
		if(subvenciones.size()==0)
		{
			out.println("<p> No se encontro ninguna subvencion<br>");
			out.println("<a onclick=\"enlace('buscar')\" title=\"Links\"> Volver a intentarlo </a></p>");
		}
		for(int i=0; i<subvenciones.size(); i++)
		{
			out.println("<p>" + subvenciones.get(i).getTitulo()+ "<br>");
			out.println("<a href=\""+"pages/InfSub"+subvenciones.get(i).getId()+".pdf\">Ver en pdf</a></p>");
		}
		for(int i=subvenciones.size(); i<10; i++)
		out.println("<p><br></p>");
	}
	else
	{
		out.println("<p> Error en la busqueda<br>");
		out.println("<a onclick=\"enlace('buscar')\" title=\"Links\"> Volver a intentarlo </a></p>");
		for(int i=1; i<=13; i++)
			out.println("<p><br></p>");
	}
	
%>
<p><br></p>
<p><br></p>
</div>
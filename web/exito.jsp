<% 
	String mensaje=null;
	if(session.getAttribute("mensaje")!=null)
		mensaje=(String)session.getAttribute("mensaje");
%>

<div id="centercontent">
<p><br></p>
<p><br></p>
<p><br></p>
<form>
<table align="center">
<tr>
<td><h3><% out.println(mensaje); %> </h3></td>
</tr>
<tr>
<td align="center"><input type="button" value="indice" onclick="enlace('home')" /></td>
</tr>
</table>
</form>
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
<p><br></p>
</div>
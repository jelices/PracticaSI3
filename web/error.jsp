<% 
	String error=null;
	if(session.getAttribute("error")!=null)
		error=(String)session.getAttribute("error");
	String atras=null;
	if(session.getAttribute("atras")!=null)
				atras="enlace(\'"+(String)session.getAttribute("atras")+"\')";
%>

<div id="centercontent">
<p><br></p>
<p><br></p>
<p><br></p>
<form>
<table align="center">
<tr>
<td><h3><% out.println(error); %> </h3></td>
</tr>
<tr>
<td align="center"><input type="button" value="atras" onclick="<%= atras %>" /></td>
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
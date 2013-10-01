<script language="javascript">

function habilitar()
{
	for(i=0;i<document.form.formatoR.length;i++) 
		document.form.formatoR[i].disabled=false;
	for(i=0;i<document.form.categorias.length;i++) 
		document.form.categorias[i].disabled=false;
	if((!document.form.formatoR[0].checked)&&(!document.form.formatoR[1].checked))
		document.form.formatoR[1].checked=true;
	copiar();
}

function deshabilitar()
{	
	for(i=0;i<document.form.formatoR.length;i++) 
	{
		document.form.formatoR[i].disabled=true;
		document.form.formatoR[i].checked=false;
	}
	for(i=0;i<document.form.categorias.length;i++) 
	{
		document.form.categorias[i].disabled=true;
		document.form.categorias[i].checked=false;
	}
	copiar();
}

function copiar()
{
	if(document.form.informeR[0].checked)
	{
		document.form.informe.value="si";
		if(document.form.formatoR[0].checked)
			document.form.formato.value="html";
		else
			document.form.formato.value="texto";
	}
	else
	{
		document.form.informe.value="no";
		document.form.formato.value="";
	}
	document.form.catSubvenciones.value="";
	for(i=0;i<document.form.categorias.length;i++) 
	{
		if(document.form.categorias[i].checked)
			document.form.catSubvenciones.value=document.form.catSubvenciones.value +" "+ document.form.categorias[i].value+",";
	}
}

function cargar()
{
	if(document.form.informe.value=="si")
	{
		document.form.informeR[0].checked=true;
		if(document.form.formato.value=="html")
		{
			document.form.formatoR[0].checked=true;
		}
		if(document.form.formato.value=="texto")
		{
			document.form.formatoR[1].checked=true;
		}
		var trozos=document.form.catSubvenciones.value.split(",");
		for(i=0;i<(trozos.length-1);i++)
		{
			document.form.categorias[eval(trozos[i]-1)].checked=true;
		} 
		habilitar();
	}

}
</script>

<%@page import="modelo.Usuario" %>
<%@page import="modelo.Usuario.Privilegio" %>

<% 
	Usuario usuario=null;
	if(session.getAttribute("usuario")!=null)
		usuario=(Usuario)session.getAttribute("usuario");
	if((usuario!=null)&&(usuario.getTipoUsuario()==Privilegio.administrador))
		usuario=(Usuario)session.getAttribute("usuarioAEditar");
   if((usuario!=null)&&(usuario.getTipoUsuario()==Privilegio.registrado))
   {
%> 

<div id="centercontent">
<p><br></p>
<p><br></p>
<form  method="POST" name="form" action="cambiarInformes.do">
<table>
	<tr>
		<td> Desea recibir un informe semanal<br> sobre las nuevas subvenciones</td>
		<td> <input type="radio" name="informeR" value="si" onclick="habilitar()"> si </input>
		<td> <input type="radio" name="informeR" value="no" onclick="deshabilitar()" checked> no </input>
	</tr>
	<tr>
		<td align="right"> Formato</td>
		<td> <input type="radio" name="formatoR" value="html" disabled="true" onclick="copiar()"> html </input>
		<td> <input type="radio" name="formatoR" value="texto" disabled="true" onclick="copiar()"> texto plano </input>
	</tr>
</table>
<p>Categoria de subvenciones:
<table>
	<tr>
		<td> <input type="checkbox" name="categorias" value="1" disabled="true" onclick="copiar()">Actividades culturales, ling&uuml;&iacute;sticas y de deporte</input> </td>
		<td> <input type="checkbox" name="categorias" value="2" disabled="true" onclick="copiar()">Agrigultura, ganader&iacute;a y pesca</input> </td>
		<td> <input type="checkbox" name="categorias" value="3" disabled="true" onclick="copiar()">Arqueolog&iacute;a y Miner&iacute;a</input> </td>
		<td> <input type="checkbox" name="categorias" value="4" disabled="true" onclick="copiar()">Artesan&iacute;a</input> </td>
	</tr>
	<tr>
		<td> <input type="checkbox" name="categorias" value="5" disabled="true" onclick="copiar()">Asesor&iacute;as, Auditor&iacute;as y Consultor&iacute;as Externas</input> </td>
		<td> <input type="checkbox" name="categorias" value="6" disabled="true" onclick="copiar()">Asistencia a Ferias, Congresos y Material Promocional</input> </td>
		<td> <input type="checkbox" name="categorias" value="7" disabled="true" onclick="copiar()">Asociacionismo y Voluntariado</input> </td>
		<td> <input type="checkbox" name="categorias" value="8" disabled="true" onclick="copiar()">Audiovisual, Prensa y Publicaciones</input> </td>
	</tr>
	<tr>
		<td> <input type="checkbox" name="categorias" value="9" disabled="true" onclick="copiar()">Calidad</input> </td>
		<td> <input type="checkbox" name="categorias" value="10" disabled="true" onclick="copiar()">Comercio</input> </td>
		<td> <input type="checkbox" name="categorias" value="11" disabled="true" onclick="copiar()">Consumo</input> </td>
		<td> <input type="checkbox" name="categorias" value="12" disabled="true" onclick="copiar()">Cooperacion al Desarrollo e Inmigraci&oacute;n / Emigraci&oacute;n</input> </td>
	</tr>
	<tr>
		<td> <input type="checkbox" name="categorias" value="13" disabled="true" onclick="copiar()">Cooperacion Empresarial</input> </td>
		<td> <input type="checkbox" name="categorias" value="14" disabled="true" onclick="copiar()">Corporaciones Locales</input> </td>
		<td> <input type="checkbox" name="categorias" value="15" disabled="true" onclick="copiar()">Creaccion Nuevas Empresas</input> </td>
		<td> <input type="checkbox" name="categorias" value="16" disabled="true" onclick="copiar()">Desarrollo Rural</input> </td>
	</tr>
	<tr>
		<td> <input type="checkbox" name="categorias" value="17" disabled="true" onclick="copiar()">Educacion y Ciencia</input> </td>
		<td> <input type="checkbox" name="categorias" value="18" disabled="true" onclick="copiar()">Empleo</input> </td>
		<td> <input type="checkbox" name="categorias" value="19" disabled="true" onclick="copiar()">Equipamientos informaticos y Tecnolog&iacute;a</input> </td>
		<td> <input type="checkbox" name="categorias" value="20" disabled="true" onclick="copiar()">Exportaci&oacute;n / Internacionalizaci&oacute;n </input> </td>
	</tr>
	<tr>
		<td> <input type="checkbox" name="categorias" value="21" disabled="true" onclick="copiar()">Financiaci&oacute;n Preferente / Pr&eacute;stamos</input> </td>
		<td> <input type="checkbox" name="categorias" value="22" disabled="true" onclick="copiar()">Formaci&oacute;n</input> </td>
		<td> <input type="checkbox" name="categorias" value="23" disabled="true" onclick="copiar()">I+D+i (Investigaci&oacute;n+Desarrollo+Innovaci&oacute;n)</input> </td>
		<td> <input type="checkbox" name="categorias" value="24" disabled="true" onclick="copiar()">Inversiones Materiales y Equipos </input> </td>
	</tr>
	<tr>
		<td> <input type="checkbox" name="categorias" value="25" disabled="true" onclick="copiar()">Juventud</input> </td>
		<td> <input type="checkbox" name="categorias" value="26" disabled="true" onclick="copiar()">Medio Ambiente y Energ&iacute;a</input> </td>
		<td> <input type="checkbox" name="categorias" value="27" disabled="true" onclick="copiar()">Minusv&aacute;lidos / Discapacitados</input> </td>
		<td> <input type="checkbox" name="categorias" value="28" disabled="true" onclick="copiar()">Mujeres, Infancia y Ayudas Familiares </input> </td>
	</tr>
	<tr>
		<td> <input type="checkbox" name="categorias" value="29" disabled="true" onclick="copiar()">Otras</input> </td>
		<td> <input type="checkbox" name="categorias" value="30" disabled="true" onclick="copiar()">Patrimonio Cultural y Arquitectura</input> </td>
		<td> <input type="checkbox" name="categorias" value="31" disabled="true" onclick="copiar()">Prevenci&oacute;n de Riesgos Laborales</input> </td>
		<td> <input type="checkbox" name="categorias" value="32" disabled="true" onclick="copiar()">Recursos Humanos</input> </td>
	</tr>
	<tr>
		<td> <input type="checkbox" name="categorias" value="33" disabled="true" onclick="copiar()">Sanidad, Servicios Sociales y Mayores</input> </td>
		<td> <input type="checkbox" name="categorias" value="34" disabled="true" onclick="copiar()">Textil - Confecci&oacute;n</input> </td>
		<td> <input type="checkbox" name="categorias" value="35" disabled="true" onclick="copiar()">Transporte</input> </td>
		<td> <input type="checkbox" name="categorias" value="36" disabled="true" onclick="copiar()">Turismo y Hosteler&iacute;a</input> </td>
	</tr>
	<tr>
		<td> <input type="checkbox" name="categorias" value="37" disabled="true" onclick="copiar()">Vivienda y Urbanismo</input> </td>
	</tr>
	<tr>
		<td> <input type="hidden" name="informe" id="informe" value="<%= usuario.getInforme()%>"></td>
		<td> <input type="hidden" name="formato" id="formato" value="<%= usuario.getFormato()%>"></td>
		<td> <input type="hidden" name="catSubvenciones" id="catSubvenciones" value="<%= usuario.getCatSubvenciones()%>"></td>
	</tr>
	<tr>
		<td></td>
	</tr>
	<tr>
		<td></td>
		<td></td>
		<td><input  type="submit" value="Modificar"/></td>
	</tr>
	</table>
</form>
<p><br></p>
<p><br></p>
</div>
<%  
	}
%>

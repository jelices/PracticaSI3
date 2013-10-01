<script language="javascript">

function cargar()
{
	modificar()
}

function modificar()
{
	lugarSP = document.getElementById("lugarSP");
	ambitoS = document.getElementById("ambitoS");
	opcion=document.getElementById('lugarS');
	if(ambitoS.selectedIndex==0)
	{
		lugarSP.innerHTML="Provincia donde se encuentra";
		opcion.disabled=false;
		provincias=['Alava', 'Albacete', 'Alicante', 'Almeria', 'Asturias', 'Avila', 'Badajoz', 'Baleares', 'Barcelona', 'Burgos', 'Caceres','Cadiz','Cantabria','Castellon','Ceuta','Ciudad Real','Cordoba','Cuenca','Gerona','Granada','Guadalajara','Guipuzcoa','Huelva', 'Huesca', 'Jaen','La Coruna','La Rioja', 'Las Palmas','Leon','Lerida', 'Lugo','Madrid','Malaga', 'Melilla','Murcia', 'Navarra','Orense','Palencia', 'Pontevedra', 'Salamanca','Segovia','Sevilla', 'Soria','Tarragona','Tenerife','Teruel','Toledo','Valencia','Valladolid','Vizcaya', 'Zamora','Zaragoza'];
		opcion.length=provincias.length;
		for(var i=0; i<provincias.length; i++)
		{
			opcion[i].text=provincias[i];
			opcion[i].value=i+1;
		}
	}
	if(ambitoS.selectedIndex==1)
	{
		lugarSP.innerHTML="";
		opcion.disabled=true;
		opcion.length=0;
	}
	if(ambitoS.selectedIndex==2)
	{
		lugarSP.innerHTML="";	
		opcion.disabled=true;
		opcion.length=0;
	}
	if(ambitoS.selectedIndex==3)
	{
		lugarSP.innerHTML="Comunidad Autonoma: ";
		opcion.disabled=false;
		comunidades=['Andalucia', 'Aragon', 'Canarias','Cantabria','Castilla y Leon','Castilla-La Mancha','Cataluna','Ceuta','Comunidad de Madrid','Comunidad Valenciana','Extremadura','Galicia','Islas Baleares', 'La Rioja', 'Melilla', 'Navarra', 'Pais Vasco', 'Principado de Asturias', 'Region de Murcia'];
		opcion.length=comunidades.length;
		for(var i=0; i<comunidades.length; i++)
		{
			opcion[i].text=comunidades[i];
			opcion[i].value=i+1;
		}
	}
	if(ambitoS.selectedIndex==4)
	{
		lugarSP.innerHTML="Provincia";
		opcion.disabled=false;
		provincias=['Alava', 'Albacete', 'Alicante', 'Almeria', 'Asturias', 'Avila', 'Badajoz', 'Baleares', 'Barcelona', 'Burgos', 'Caceres','Cadiz','Cantabria','Castellon','Ceuta','Ciudad Real','Cordoba','Cuenca','Gerona','Granada','Guadalajara','Guipuzcoa','Huelva', 'Huesca', 'Jaen','La Coruna','La Rioja', 'Las Palmas','Leon','Lerida', 'Lugo','Madrid','Malaga', 'Melilla','Murcia', 'Navarra','Orense','Palencia', 'Pontevedra', 'Salamanca','Segovia','Sevilla', 'Soria','Tarragona','Tenerife','Teruel','Toledo','Valencia','Valladolid','Vizcaya', 'Zamora','Zaragoza'];
		opcion.length=provincias.length;
		for(var i=0; i<provincias.length; i++)
		{
			opcion[i].text=provincias[i];
			opcion[i].value=i+1;
		}
	}
}
	
function copiar()
{
	ct=document.getElementById('categoria');
	ctS=document.getElementById('categoriaS');
	ct.value=ctS[ctS.selectedIndex].value;
	am=document.getElementById('ambito');
	amS=document.getElementById('ambitoS');
	am.value=amS[amS.selectedIndex].value;
	lg=document.getElementById('lugar');
	lgS=document.getElementById('lugarS');
	lg.value=lgS[lgS.selectedIndex].value;
}
</script>

<p><br></p>
<p><br></p>
<p><br></p>
<p><br></p>
<p><br></p>
<p><br></p>
<p><br></p>
<p><br></p>
<form  method="POST" action="buscar.do" >
<table align="center">
	<tr>
		<td align="right"> Palabras en titulo de subvencion: </td>
		<td> <input type="text" id="titulo" name="titulo" size="25"></td>
	</tr>
	<tr>
	<td align="right">Categoria: </td>
	<td>
	<select name="categoriaS" id="categoriaS">
		<option value="0" >Todas</option>
		<option value="1" >Actividades culturales, ling&uuml;&iacute;sticas y de deporte</option>
		<option value="2" >Agrigultura, ganader&iacute;a y pesca</option>
		<option value="3" >Arqueolog&iacute;a y Miner&iacute;a</option>
		<option value="4" >Artesan&iacute;a</option>
		<option value="5" >Asesor&iacute;as, Auditor&iacute;as y Consultor&iacute;as Externas</option>
		<option value="6" >Asistencia a Ferias, Congresos y Material Promocional</option>
		<option value="7" >Asociacionismo y Voluntariado</option>
		<option value="8" >Audiovisual, Prensa y Publicaciones</option>
		<option value="9" >Calidad</option>
		<option value="10" >Comercio</option>
		<option value="11" >Consumo</option>
		<option value="12" >Cooperacion al Desarrollo e Inmigraci&oacute;n / Emigraci&oacute;n</option>
		<option value="13" >Cooperacion Empresarial</option>
		<option value="14" >Corporaciones Locales</option>
		<option value="15" >Creaccion Nuevas Empresas</option>
		<option value="16" >Desarrollo Rural</option>
		<option value="17" >Educaci&oacute;n y Ciencia</option>
		<option value="18" >Empleo</option>
		<option value="19" >Equipamientos informaticos y Tecnolog&iacute;a</option>
		<option value="20" >Exportaci&oacute;n / Internacionalizaci&oacute;n </option>
		<option value="21" >Financiaci&oacute;n Preferente / Préstamos</option>
		<option value="22" >Formaci&oacute;n</option>
		<option value="23" >I+D+i (Investigaci&oacute;n+Desarrollo+Innovaci&oacute;n)</option>
		<option value="24" >Inversiones Materiales y Equipos </option>
		<option value="25" >Juventud</option>
		<option value="26" >Medio Ambiente y Energ&iacute;a</option>
		<option value="27" >Minusválidos / Discapacitados</option>
		<option value="28" >Mujeres, Infancia y Ayudas Familiares </option>
		<option value="29" >Otras</option>
		<option value="30" >Patrimonio Cultural y Arquitectura</option>
		<option value="31" >Prevenci&oacute;n de Riesgos Laborales</option>
		<option value="32" >Recursos Humanos</option>
		<option value="33" >Sanidad, Servicios Sociales y Mayores</option>
		<option value="34" >Textil - Confecci&oacute;n</option>
		<option value="35" >Transporte</option>
		<option value="36" >Turismo y Hosteler&iacute;a</option>
		<option value="37" >Vivienda y Urbanismo</option>
	</select>
	</td>
	</tr>
	<tr>
		<td align="right">Ambito geografico</td>
		<td><select id="ambitoS" name="ambitoS" onChange="modificar()">
			<option value="0">Todas</option>
			<option value="1">Uni&oacute;n Europea</option>
			<option value="2">Espa&ntilde;a</option>
			<option value="3">Comunidad Aut&oacute;noma</option>
			<option value="4">Provincia</option>
		</select>
		</td>
		
		<td><span id="lugarSP">Provincia:</span></td>
		<td>
			<select id="lugarS" name="lugarS">
			</select>
		</td>
	</tr>
	</table>
	</table>
		<input type="hidden" name="categoria" id="categoria"/>
		<input type="hidden" name="ambito" id="ambito" />
		<input type="hidden" name="lugar" id="lugar" />
	<center><input type="submit" value="buscar" onclick="copiar()"></center>
	</form>
	
<p><br></p>
<p><br></p>
<p><br></p>
<p><br></p>
<p><br></p>
<p><br></p>
<p><br></p>
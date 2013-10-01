<script language="javascript">

function combos(x)
{
	Combos(x);
	copiar();
}

function Combos(x) {
  ItDepend=document.getElementById('subcategoriaS');
  if(!ItDepend){return;}                 
  var subcategorias=new Array();
  var indices=new Array();
  subcategorias['A']=['01.- Agricultura, ganaderia, caza y servicios relacionados con las mismas', '02.- Silvicultura y explotacion forestal', '03.- Pesca y acuicultura'];
  indices['A']=['01','02','03'];
  subcategorias['B']=['05.- Extraccion de antracita, hulla y lignito', '06.- Extraccion de crudo de petroleo y gas natural', '07.- Extraccion de minerales metalicos', '08.- Otras industrias extractivas', '09.- Actividades de apoyo a las industrias extractivas'];
  indices['B']=['05','06','07','08','09']; 
  subcategorias['C']=['10.- Industria de la alimentacion','11.- Fabricacion de bebidas','12.- Industria del tabaco','13.- Industria textil','14.- Confeccion de prendas de vestir','15.- Industria del cuero y del calzado','16.- Industria de la madera y del corcho, excepto muebles; cesteria y esparteria','17.- Industria del papel','18.- Artes graficas y reproduccion de soportes grabados','19.- Coquerias y refino de petroleo','20.- Industria quimica','21.- Fabricacion de productos farmaceuticos','22.- Fabricacion de productos de caucho y plasticos','23.- Fabricacion de otros productos minerales no metalicos','24.- Metalurgia; fabricacion de productos de hierro, acero y ferroaleaciones','25.- Fabricacion de productos metalicos, excepto maquinaria y equipo','26.- Fabricacion de productos informaticos, electronicos y opticos','27.- Fabricacion de material y equipo electrico','28.- Fabricacion de maquinaria y equipo n.c.o.p.', '29.- Fabricacion de vehiculos de motor, remolques y semirremolques', '30.- Fabricacion de otro material de transporte', '31.- Fabricacion de muebles', '32.- Otras industrias manufactureras', '33.- Reparacion e instalacion de maquinaria y equipo'];
  indices['C']=['10','11','12','13','14','15','16','17','18','19','20','21','22','23','24','25','26','27','28','29','30','31','32','33'];
  subcategorias['D']=['35.- Suministro de energia electrica, gas, vapor y aire acondicionado'];
  indices['D']=['35'];
  subcategorias['E']=['36.- Captacion, depuracion y distribucion de agua','37.- Recogida y tratamiento de aguas residuales','38.- Recogida, tratamiento y eliminacion de residuos; valorizacion','39.- Actividades de descontaminacion y otros servicios de gestion de residuos'];
  indices['E']=['36','37','38','39'];
  subcategorias['F']=['41.- Construccion de edificios','42.- Ingenieria civil','43.- Actividades de construccion especializada'];
  indices['F']=['41','42','43'];
  subcategorias['G']=['45.- Venta y reparacion de vehiculos de motor y motocicletas','46.- Comercio al por mayor e intermediarios del comercio, excepto de vehiculos de motor y motocicletas','47.- Comercio al por menor, excepto de vehiculos de motor y motocicletas'];
  indices['G']=['45','46','47'];
  subcategorias['H']=['49.- Transporte terrestre y por tuberia','50.- Transporte maritimo y por vias navegables interiores','51.- Transporte aereo','52.- Almacenamiento y actividades anexas al transporte','53.- Actividades postales y de correos'];
  indices['H']=['49','50','51','52','53'];
  subcategorias['I']=['55.- Servicios de alojamiento','56.- Servicios de comidas y bebidas'];
  indices['I']=['55','56'];
  subcategorias['J']=['58.- Edicion','59.- Actividades cinematograficas, de video y de programas de television, grabacion de sonido y edicion musical','60.- Actividades de programacion y emision de radio y television','61.- Telecomunicaciones','62.- Programacion, consultoria y otras actividades relacionadas con la informatica','63.- Servicios de informacion'];
  indices['J']=['58','59','60','61','62','63'];
  subcategorias['K']=['64.- Servicios financieros, excepto seguros y fondos de pensiones','65.- Seguros, reaseguros y fondos de pensiones, excepto Seguridad Social obligatoria','66.- Actividades auxiliares a los servicios financieros y a los seguros'];
  indices['K']=['64','65','66'];
  subcategorias['L']=['68.- Actividades inmobiliarias'];
  indices['L']=['68'];
  subcategorias['M']=['69.- Actividades juridicas y de contabilidad','70.- Actividades de las sedes centrales; actividades de consultoria de gestion empresarial','71.- Servicios tecnicos de arquitectura e ingenieria; ensayos y analisis tecnicos','72.- Investigacion y desarrollo','73.- Publicidad y estudios de mercado','74.- Otras actividades profesionales, cientificas y tecnicas','75.- Actividades veterinarias'];
  indices['M']=['69','70','71','72','73','74','75'];
  subcategorias['N']=['77.- Actividades de alquiler','78.- Actividades relacionadas con el empleo','79.- Actividades de agencias de viajes, operadores turisticos, servicios de reservas y actividades relacionadas con los mismos','80.- Actividades de seguridad e investigacion','81.- Servicios a edificios y actividades de jardineria','82.- Actividades administrativas de oficina y otras actividades auxiliares a las empresas'];
  indices['N']=['77','78','79','80','81','82'];
  subcategorias['O']=['84.- Administracion Publica y defensa; Seguridad Social obligatoria'];
  indices['O']=['84'];
  subcategorias['P']=['85.- Educacion'];
  indices['P']=['85'];
  subcategorias['Q']=['86.- Actividades sanitarias','87.- Asistencia en establecimientos residenciales','88.- Actividades de servicios sociales sin alojamiento'];
  indices['Q']=['86','87','88'];
  subcategorias['R']=['90.- Actividades de creacion, artisticas y espectaculos','91.- Actividades de bibliotecas, archivos, museos y otras actividades culturales','92.- Actividades de juegos de azar y apuestas','93.- Actividades deportivas, recreativas y de entretenimiento'];
  indices['R']=['90','91','92','93'];
  subcategorias['S']=['94.- Actividades asociativas','95.- Reparacion de ordenadores, efectos personales y articulos de uso domestico','96.- Otros servicios personales'];
  indices['S']=['94','95','96'];
  subcategorias['T']=['97.- Actividades de los hogares como empleadores de personal domestico','98.- Actividades de los hogares como productores de bienes y servicios para uso propio'];
  indices['T']=['97','98'];
  subcategorias['U']=['99.- Actividades de organizaciones y organismos extraterritoriales'];
  indices['U']=['99'];
  ItDepend.options.length=0;
  ItActual=subcategorias[x.options[x.selectedIndex].value];
  NumActual=indices[x.options[x.selectedIndex].value];
  if(!ItActual){return;}
  ItDepend.options.length=ItActual.length;
  for(var i=0;i<ItActual.length;i++) {
    ItDepend.options[i].text=ItActual[i];
    ItDepend.options[i].value=NumActual[i];
  }
}

function copiar()
{
	elementCES=document.getElementById('categoriaEmpresaS');
	elementCE=document.getElementById('categoriaEmpresa');
	elementTAS=document.getElementById('tipoActividadS');
	elementTA=document.getElementById('tipoActividad');
	elementSCS=document.getElementById('subcategoriaS');
	elementSC=document.getElementById('subcategoria');
	elementCE.value=elementCES.options[elementCES.selectedIndex].value;
	elementTA.value=elementTAS.options[elementTAS.selectedIndex].value;
	elementSC.value=elementSCS.options[elementSCS.selectedIndex].value;
}

function cargar()
{
	elementCES=document.getElementById('categoriaEmpresaS');
	elementCE=document.getElementById('categoriaEmpresa');
	for(var i=0; i<elementCES.options.length; i++)
		if(elementCE.value==elementCES.options[i].value)
			elementCES.selectedIndex=i;
	elementTAS=document.getElementById('tipoActividadS');
	elementTA=document.getElementById('tipoActividad');
	for(var i=0; i<elementTAS.options.length; i++)
		if(elementTA.value==elementTAS.options[i].value)
			elementTAS.selectedIndex=i;
	Combos(elementTAS);
	elementSCS=document.getElementById('subcategoriaS');
	elementSC=document.getElementById('subcategoria');
	for(var i=0; i<elementSCS.options.length; i++)
		if(elementSC.value==elementSCS.options[i].value)
			elementSCS.selectedIndex=i;
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

<form  method="POST" action="editarPerfil.do" >
<table>
	<tr>
		<td align="right"> NIF </td>
		<td> <input type="text" name="nif" value="<%= usuario.getNif()%>" /> </td>
	</tr>
	<tr>
		<td align="right"> Nombre Empresa </td>
		<td> <input type="text" name="nombreEmpresa" value="<%= usuario.getNombreEmpresa()%>"/> </td>
	</tr>
	<tr>
		<td align="right"> Sede Social (direccion postal completa)</td>
		<td> <textarea name="sedeSocial" rows="4" cols="30"><%= usuario.getSedeSocial()%></textarea></td>
	</tr>
	<tr>
		<td align="right"> Telefono de contacto </td>
		<td> <input type="text" name="telefono" value="<%= usuario.getTelefono()%>"/> </td>
	</tr>
	<tr>
		<td align="right"> Email de contacto</td>
		<td> <input type="text" name="email" value="<%= usuario.getEmail()%>"/> </td>
	</tr>
	<tr><td><br></td></tr>
	<tr>
		<td align="right">Persona de contacto: </td>
	</tr>
	<tr>
		<td align="right"> Nombre </td>
		<td> <input type="text" name="nombreContacto" value="<%= usuario.getNombreContacto()%>"/> </td>
	</tr>
	<tr>
		<td align="right"> Apellidos </td>
		<td> <input type="text" name="apellidosContacto" value="<%= usuario.getApellidosContacto()%>"/> </td>
	</tr>
	<tr><td><br></td></tr>
	<tr>
		<td align="right"> Categoria de empresa </td>
		<td> 
			<select name="categoriaEmpresaS" id="categoriaEmpresaS" onchange="copiar()">
			<option value="empresa">empresa</option>
			<option value="autonomo">autonomo</option>
			</select>
		</td>
	</tr>
	<tr>
		<td align="right"> Tipo de Actividad </td>
		<td> 
			<select name="tipoActividadS" id="tipoActividadS" onchange="combos(this)">
			<option value="A">A.- Agricultura, ganader&iacute;a, silvicultura y pesca</option>
			<option value="B">B.- Industrias extractivas</option>
			<option value="C">C.- Industria manufacturera</option>
			<option value="D">D.- Suministro de energ&iacute;a el&eacute;ctrica, gas, vapor y aire acondicionado</option>
			<option value="E">E.- Suministro de agua, actividades de saneamiento, gesti&oacute;n de residuos y descontaminaci&oacute;n</option>
			<option value="F">F.- Construcci&oacute;n</option>
			<option value="G">G.- Comercio al por mayor y al por menor; reparaci&oacute;n de veh&iacute;culos de motor y motocicletas</option>
			<option value="H">H.- Transporte y almacenamiento</option>
			<option value="I">I.- Hosteler&iacute;a</option>
			<option value="J">J.- Informaci&oacute;n y comunicaciones</option>
			<option value="K">K.- Actividades financieras y de seguros</option>
			<option value="L">L.- Actividades inmobiliarias</option>
			<option value="M">M.- Actividades profesionales, cient&iacute;ficas y t&eacute;cnicas</option>
			<option value="N">N.- Actividades administrativas y servicios auxliares</option>
			<option value="O">O.- Administraci&oacute;n P&uacute;blica y defensa; Seguridad Social obligatoria</option>
			<option value="P">P.- Educaci&oacute;n</option>
			<option value="Q">Q.- Actividades sanitarias y de servicios sociales</option>
			<option value="R">R.- Actividades art&iacute;sticas, recreativas y de entrenimiento</option>
			<option value="S">S.- Otros servicios</option>
			<option value="T">T.- Actividades de los hogares como empleadores de personal dom&eacute;stico; actividades de los hogares como productores de bienes y servicios para uso propio</option>
			<option value="U">U.- Actividades de organizaciones y organismos extraterritoriales</option>
			</select>
		</td>
	</tr>
	<tr>
		<td align="right"> Subcategoria </td>
		<td> 
			<select name="subcategoriaS" id="subcategoriaS" onChange="copiar()" onFocus="combos(document.getElementById('tipoActividadS'))">
				<option value="01">01.- Agricultura, ganadería, caza y servicios relacionados con las mismas</option>
				<option value="02">02.- Silvicultura y explotación forestal</option>
				<option value="03">03.- Pesca y acuicultura</option>
			</select>
		</td>
		<input type="hidden" name="categoriaEmpresa" id="categoriaEmpresa" value="<%= usuario.getCategoriaEmpresa()%>"/>
		<input type="hidden" name="tipoActividad" id="tipoActividad" value="<%= usuario.getTipoActividad()%>"/>
		<input type="hidden" name="subcategoria" id="subcategoria" value="<%= usuario.getSubcategoria()%>"/>
	<tr>
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
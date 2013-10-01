package modelo;

public class Subvencion {

	private int id;
    private String titulo;
    private String categoria;
    private String condiciones;
    private String ambito;
    private String objeto;
    private String lugar;

    public Subvencion(String titulo, String categoria, String condiciones, String ambito, String objeto, String lugar)
    {
    	this.titulo=titulo;
    	this.categoria=categoria;
    	this.condiciones=condiciones;
    	this.ambito=ambito;
    	this.objeto=objeto;
    	this.lugar=lugar;
    }
    
    public Subvencion() {
	}

	public String getTitulo()
    {
    	return this.titulo;
    }
    
    public void setTitulo(String titulo)
    {
    	this.titulo=titulo;
    }
    
    public String getCategoria()
    {
    	return this.categoria;
    }
    
    public void setCategoria(String categoria)
    {
    	this.categoria=categoria;
    }
    
    public String getCondiciones()
    {
    	return this.condiciones;
    }
    
    public void setCondiciones(String condiciones)
    {
    	this.condiciones=condiciones;
    }
    
    public String getAmbito()
    {
    	return this.ambito;
    }
    
    public void setAmbito(String ambito)
    {
    	this.ambito=ambito;
    }
    
    public String getObjeto()
    {
    	return this.objeto;
    }
    
    public void setObjeto(String objeto)
    {
    	this.objeto=objeto;
    }
    
    public String getLugar()
    {
    	return this.lugar;
    }
    
    public void setLugar(String lugar)
    {
    	this.lugar=lugar;
    }

    public int getId()
    {
    	return this.id;
    }
    
    public void setId(int id)
    {
    	this.id=id;
    }
    
    public String getCategoriaString()
    {
    	int valor=Integer.parseInt(categoria);
    	switch(valor)
    	{
			case 1: return "Actividades culturales, lingüísticas y de deporte";
			case 2: return "Agrigultura, ganadería y pesca";
			case 3: return "Arqueología y Minería";
			case 4: return "Artesanía";
			case 5: return "Asesorías, Auditorías y Consultorías Externas";
			case 6: return "Asistencia a Ferias, Congresos y Material Promocional";
			case 7: return "Asociacionismo y Voluntariado";
			case 8: return "Audiovisual, Prensa y Publicaciones";
			case 9: return "Calidad";
			case 10: return "Comercio";
			case 11: return "Consumo";
			case 12: return "Cooperacion al Desarrollo e Inmigración / Emigración";
			case 13: return "Cooperacion Empresarial";
			case 14: return "Corporaciones Locales";
			case 15: return "Creaccion Nuevas Empresas";
			case 16: return "Desarrollo Rural";
			case 17: return "Educacion y Ciencia";
			case 18: return "Empleo";
			case 19: return "Equipamientos informaticos y Tecnología";
			case 20: return "Exportación / Internacionalización ";
			case 21: return "Financiación Preferente / Préstamos";
			case 22: return "Formación";
			case 23: return "I+D+i (Investigación+Desarrollo+Innovación)";
			case 24: return "Inversiones Materiales y Equipos ";
			case 25: return "Juventud";
			case 26: return "Medio Ambiente y Energía";
			case 27: return "Minusválidos / Discapacitados";
			case 28: return "Mujeres, Infancia y Ayudas Familiares ";
			case 29: return "Otras";
			case 30: return "Patrimonio Cultural y Arquitectura";
			case 31: return "Prevención de Riesgos Laborales";
			case 32: return "Recursos Humanos";
			case 33: return "Sanidad, Servicios Sociales y Mayores";
			case 34: return "Textil - Confección";
			case 35: return "Transporte";
			case 36: return "Turismo y Hostelería";
			case 37: return "Vivienda y Urbanismo";
    	}
		return "";
    }
    
    public String getAmbitoString()
    {
    	int valor=Integer.parseInt(ambito);
    	switch(valor)
    	{
    		case 1: return "Union Europea";
    		case 2: return "España";
    		case 3: return "Comunidad Autonoma";
    		case 4: return "Provincia";
    	}
    	return "";
    }
    
    public String getLugarString()
    {
    	if(ambito.equals("3"))
    	{
    		int valor=Integer.parseInt(lugar);
    		switch(valor)
    		{
    			case 1: return "Andalucia";
    			case 2: return "Aragon";
    			case 3: return "Canarias";
    			case 4: return "Cantabria";
    			case 5: return "Castilla y Leon";
    			case 6: return "Castilla-La Mancha";
    			case 7: return "Cataluna";
    			case 8: return "Ceuta";
    			case 9: return "Comunidad de Madrid";
    			case 10: return "Comunidad Valenciana";
    			case 11: return "Extremadura";
    			case 12: return "Galicia";
    			case 13: return "Islas Baleares"; 
    			case 14: return "La Rioja"; 
    			case 15: return "Melilla"; 
    			case 16: return "Navarra"; 
    			case 17: return "Pais Vasco"; 
    			case 18: return "Principado de Asturias"; 
    			case 19: return "Region de Murcia";
    		}
    		return "";
    	}
    	if(ambito.equals("4"))
    	{
    		int valor=Integer.parseInt(lugar);
    		switch(valor)
    		{
    			case 1: return "Alava"; 
    			case 2: return "Albacete"; 
    			case 3: return "Alicante"; 
    			case 4: return "Almeria"; 
    			case 5: return "Asturias"; 
    			case 6: return "Avila"; 
    			case 7: return "Badajoz"; 
    			case 8: return "Baleares"; 
    			case 9: return "Barcelona"; 
    			case 10: return "Burgos"; 
    			case 11: return "Caceres";
    			case 12: return "Cadiz";
    			case 13: return "Cantabria";
    			case 14: return "Castellon";
    			case 15: return "Ceuta";
    			case 16: return "Ciudad Real";
    			case 17: return "Cordoba";
    			case 18: return "Cuenca";
    			case 19: return "Gerona";
    			case 20: return "Granada";
    			case 21: return "Guadalajara";
    			case 22: return "Guipuzcoa";
    			case 23: return "Huelva"; 
    			case 24: return "Huesca"; 
    			case 25: return "Jaen";
    			case 26: return "La Coruna";
    			case 27: return "La Rioja"; 
    			case 28: return "Las Palmas";
    			case 29: return "Leon";
    			case 30: return "Lerida"; 
    			case 31: return "Lugo";
    			case 32: return "Madrid";
    			case 33: return "Malaga"; 
    			case 34: return "Melilla";
    			case 35: return "Murcia"; 
    			case 36: return "Navarra";
    			case 37: return "Orense";
    			case 38: return "Palencia";
    			case 39: return "Pontevedra"; 
    			case 40: return "Salamanca";
    			case 41: return "Segovia";
    			case 42: return "Sevilla"; 
    			case 43: return "Soria";
    			case 44: return "Tarragona";
    			case 45: return "Tenerife";
    			case 46: return "Teruel";
    			case 47: return "Toledo";
    			case 48: return "Valencia";
    			case 49: return "Valladolid";
    			case 50: return "Vizcaya"; 
    			case 51: return "Zamora";
    			case 52: return "Zaragoza";
    		}
    		return "";
    	}
    	return "";
    }
    
}

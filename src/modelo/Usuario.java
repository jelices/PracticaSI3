package modelo;

public class Usuario {
	
	public enum Privilegio{administrador, registrado, visitante};
	
	private String nombre;
	private String nif;
	private String nombreEmpresa;
	private String sedeSocial;
	private String telefono;
	private String email;
    
	private String nombreContacto;
	private String apellidosContacto;
	private String categoriaEmpresa;
	private String tipoActividad;
	private String subcategoria;
	
    private String informe;
    private String formato;
    private String catSubvenciones;
    private Privilegio tipoUsuario;
    
    public Usuario()
    {
    	this.tipoUsuario=Privilegio.visitante;
    }
    
    public Usuario (String nombre, String nif, String nombreEmpresa, String sedeSocial, String telefono, String email, String nombreContacto, String apellidosContacto, String categoriaEmpresa, String tipoActividad, String subcategoria, String informe,  String formato, String catSubvenciones){
    	this.setNombre(nombre);
    	this.setNif(nif);
    	this.setNombreEmpresa(nombreEmpresa);
    	this.setSedeSocial(sedeSocial);
    	this.setTelefono(telefono);
    	this.setEmail(email);
    	this.setNombreContacto(nombreContacto);
    	this.setApellidosContacto(apellidosContacto);
    	this.setCategoriaEmpresa(categoriaEmpresa);
    	this.setTipoActividad(tipoActividad);
    	this.setSubcategoria(subcategoria);
    	this.setInforme(informe);
    	this.setFormato(formato);
    	this.setCatSubvenciones(catSubvenciones);
    	this.tipoUsuario=Privilegio.registrado;
    }
	
    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
	
	public String getNif(){
        return this.nif;
    }

    public void setNif(String nif){
        this.nif = nif;
    }
    
    public String getNombreEmpresa(){
        return this.nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa){
        this.nombreEmpresa = nombreEmpresa;
    }
    
    public String getSedeSocial(){
        return this.sedeSocial;
    }

    public void setSedeSocial(String sedeSocial){
        this.sedeSocial = sedeSocial;
    }
    
    public String getTelefono(){
        return this.telefono;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    
    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }
    
    public String getNombreContacto(){
        return this.nombreContacto;
    }

    public void setNombreContacto(String nombreContacto){
        this.nombreContacto = nombreContacto;
    }
    
    public String getApellidosContacto(){
        return this.apellidosContacto;
    }

    public void setApellidosContacto(String apellidosContacto){
        this.apellidosContacto = apellidosContacto;
    }
    
    public String getCategoriaEmpresa(){
        return this.categoriaEmpresa;
    }

    public void setCategoriaEmpresa(String categoriaEmpresa){
        this.categoriaEmpresa = categoriaEmpresa;
    }
    
    public String getTipoActividad(){
        return this.tipoActividad;
    }

    public void setTipoActividad(String tipoActividad){
        this.tipoActividad = tipoActividad;
    }
    
    public String getSubcategoria(){
        return this.subcategoria;
    }

    public void setSubcategoria(String subcategoria){
        this.subcategoria = subcategoria;
    }
	
	public String getInforme(){
		return this.informe;
	}
	 
	public void setInforme(String informe){
		this.informe = informe;
	}
	
	public String getFormato(){
		return this.formato;
	}
	
	public void setFormato(String formato){
		this.formato = formato;
	}
	    
	public String getCatSubvenciones(){
		return this.catSubvenciones;
	}

	public void setCatSubvenciones(String catSubvenciones){
		this.catSubvenciones = catSubvenciones;
	}
	
	public Privilegio getTipoUsuario(){
		return this.tipoUsuario;
	}

	public void administrador(){
		tipoUsuario=Privilegio.administrador;
	}
	
	public void registrado(){
		tipoUsuario=Privilegio.registrado;
	}
	
}

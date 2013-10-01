package forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class BuscarForm extends ActionForm {

    private String titulo;
    private String categoria;
    private String ambito;
    private String lugar;

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
    
    public String getAmbito()
    {
    	return this.ambito;
    }
    
    public void setAmbito(String ambito)
    {
    	this.ambito=ambito;
    }
    
    public String getLugar()
    {
    	return this.lugar;
    }
    
    public void setLugar(String lugar)
    {
    	this.lugar=lugar;
    }
    
    public void reset(ActionMapping map, HttpServletRequest req)
    {
        titulo="";
        categoria="";
        ambito="";
        lugar="";
    }
}

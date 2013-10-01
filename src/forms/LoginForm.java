package forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.*;


public class LoginForm extends ActionForm {
	
	private String nombre;
	private String password;
	
	public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
	public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void reset(ActionMapping map, HttpServletRequest req){
        this.nombre = "";
        this.password = "";
    }
    
    public ActionErrors validate(ActionMapping map, HttpServletRequest req) {
    	ActionErrors errors = new ActionErrors();
    	if((nombre == null) || (nombre.length() < 1))
    		errors.add("nombre", new ActionMessage("error.nombre"));
    	if((password == null) || (password.length() < 1))
    		errors.add("password", new ActionMessage("error.password"));
    	return errors;
    }

}

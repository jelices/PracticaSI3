package forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class EditarForm extends ActionForm {
	private String indice;
	private String accion;
	
	public String getIndice(){
        return this.indice;
    }

    public void setIndice(String indice){
        this.indice = indice;
    }
    
	public String getAccion(){
        return this.accion;
    }

    public void setAccion(String accion){
        this.accion = accion;
    }
    
	public int getIndiceEntero(){
        return Integer.parseInt(this.indice);
    }
    
    public void reset(ActionMapping map, HttpServletRequest req){
    	this.indice="";
    	this.accion="";
    }
}

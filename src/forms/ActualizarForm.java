package forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class ActualizarForm extends ActionForm 
{
	private String pagina;
	
	public String getPagina()
	{
		return this.pagina;
	}
	    
	public void setPagina(String pagina)
	{
	    this.pagina=pagina;
	}
	
	 public void reset(ActionMapping map, HttpServletRequest req)
	 {
		 pagina="";
	 }
}

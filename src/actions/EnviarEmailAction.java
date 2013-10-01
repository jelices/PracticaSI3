package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.BaseDatos;
import modelo.generarEmails;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class EnviarEmailAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
		generarEmails g=new generarEmails();
		g.generarEmails(BaseDatos.getListaUsuarios(), BaseDatos.getListaNuevasSubvenciones());
		if(BaseDatos.envejecerSubvenciones())	
			return mapping.findForward("success");
		return mapping.findForward("failure");
	}
}

package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import forms.ActualizarForm;

public class ActualizarAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
		ActualizarForm forma=(ActualizarForm)form;
		HttpSession sesion=request.getSession(true);
		String atributo=forma.getPagina();
		if(atributo.equals("cerrarSesion"))
			sesion.invalidate();
		else
			sesion.setAttribute("principal", atributo+".jsp");
		return mapping.findForward("success");
	}

}

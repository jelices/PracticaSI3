package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.BaseDatos;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class EliminarUsuarioAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession sesion=request.getSession(true);
		sesion.setAttribute("listaUsuarios", BaseDatos.getListaUsuarios());
		sesion.setAttribute("principal", "eliminarUsuario.jsp");
		return mapping.findForward("success");
	}
}

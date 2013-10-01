package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.BaseDatos;
import modelo.Usuario;
import modelo.Usuario.Privilegio;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import forms.Registro3Form;

public class CambiarInformesAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
		Registro3Form forma = (Registro3Form) form;
		HttpSession sesion=request.getSession(true);
		if(sesion.getAttribute("usuario")==null)
		{
			sesion.setAttribute("error", "Error en la sesion");
			sesion.setAttribute("atras", "cambiarInformes");
			sesion.setAttribute("principal", "error.jsp");
			return mapping.findForward("failure");
		}
		Usuario u=(Usuario)sesion.getAttribute("usuario");
		if(u.getTipoUsuario()==Privilegio.administrador)
		{
			if(sesion.getAttribute("usuarioAEditar")==null)
			{
				sesion.setAttribute("error", "Error en la sesion");
				sesion.setAttribute("atras", "cambiarInformes");
				sesion.setAttribute("principal", "error.jsp");
				return mapping.findForward("failure");
			}
			u=(Usuario)sesion.getAttribute("usuarioAEditar");
		}
		u.setInforme(forma.getInforme());
		u.setFormato(forma.getFormato());
		u.setCatSubvenciones(forma.getCatSubvenciones());
		if(BaseDatos.modificarUsuario(u))
		{
			sesion.setAttribute("mensaje", "Informes a recibir modificados");
	    	sesion.setAttribute("principal", "exito.jsp");
	    	return mapping.findForward("success");
		}
		else
	    {
			sesion.setAttribute("error", "Fallo al actualizar la base de datos");
			sesion.setAttribute("atras", "cambiarInformes");
			sesion.setAttribute("principal", "error.jsp");
			return mapping.findForward("failure");
		}
	}
}

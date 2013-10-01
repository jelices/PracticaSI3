package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.BaseDatos;
import modelo.Usuario;
import modelo.Usuario.Privilegio;

import org.apache.struts.action.*;

import forms.CambiarPasswordForm;

public class CambiarPasswordAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
		CambiarPasswordForm forma=(CambiarPasswordForm)form;
		HttpSession sesion=request.getSession(true);
		if(!forma.getPasswordNuevo().equals(forma.getPasswordNuevo2()))
		{
			sesion.setAttribute("error", "El password y su copia no coinciden");
			sesion.setAttribute("atras", "cambiarPassword");
			sesion.setAttribute("principal", "error.jsp");
			return mapping.findForward("failure");
		}
		if(sesion.getAttribute("usuario")==null)
		{
			sesion.setAttribute("error", "Error en la sesion");
			sesion.setAttribute("atras", "cambiarPassword");
			sesion.setAttribute("principal", "error.jsp");
			return mapping.findForward("failure");
		}
		Usuario u=(Usuario)sesion.getAttribute("usuario");
		if(BaseDatos.comprobarLogin(u.getNombre(), forma.getPasswordPrevio()).getTipoUsuario()==Privilegio.visitante)
		{
			sesion.setAttribute("error", "El password previo es erroneo");
			sesion.setAttribute("atras", "cambiarPassword");
			sesion.setAttribute("principal", "error.jsp");
			return mapping.findForward("failure");
		}
		if(BaseDatos.cambiarPassword(u.getNombre(), forma.getPasswordNuevo()))
		{
			sesion.setAttribute("mensaje", "Password cambiado con exito");
	    	sesion.setAttribute("principal", "exito.jsp");
	    	return mapping.findForward("success");
		}
		else
		{
			sesion.setAttribute("error", "Fallo al actualizar la base de datos");
			sesion.setAttribute("atras", "cambiarPassword");
			sesion.setAttribute("principal", "error.jsp");
			return mapping.findForward("failure");
		}
		
	}
}

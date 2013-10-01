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

import forms.Registro2Form;

public class EditarPerfilAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
		// Recuperamos la forma
		Registro2Form forma = (Registro2Form) form;
		HttpSession sesion=request.getSession(true);
		if(sesion.getAttribute("usuario")==null)
		{
			sesion.setAttribute("error", "Error en la sesion");
			sesion.setAttribute("atras", "cambiarPerfil");
			sesion.setAttribute("principal", "error.jsp");
			return mapping.findForward("failure");
		}
		Usuario u=(Usuario)sesion.getAttribute("usuario");
		if(u.getTipoUsuario()==Privilegio.administrador)
		{
			if(sesion.getAttribute("usuarioAEditar")==null)
			{
				sesion.setAttribute("error", "Error al seleccionar usuario");
				sesion.setAttribute("atras", "cambiarPerfil");
				sesion.setAttribute("principal", "error.jsp");
				return mapping.findForward("failure");
			}
			u=(Usuario)sesion.getAttribute("usuarioAEditar");
		}
		u.setNif(forma.getNif());
		u.setNombreEmpresa(forma.getNombreEmpresa());
		u.setSedeSocial(forma.getSedeSocial());
		u.setTelefono(forma.getTelefono());
	    u.setEmail(forma.getEmail());	
	    
	    u.setNombreContacto(forma.getNombreContacto());
	    u.setApellidosContacto(forma.getApellidosContacto());
	    u.setCategoriaEmpresa(forma.getCategoriaEmpresa());
	    u.setTipoActividad(forma.getTipoActividad());
	    u.setSubcategoria(forma.getSubcategoria());
	    if(BaseDatos.modificarUsuario(u))
	    {
			sesion.setAttribute("mensaje", "Datos de empresa modificados");
	    	sesion.setAttribute("principal", "exito.jsp");
	    	return mapping.findForward("success");
		}
	    else
	    {
			sesion.setAttribute("error", "Fallo al actualizar la base de datos");
			sesion.setAttribute("atras", "cambiarPerfil");
			sesion.setAttribute("principal", "error.jsp");
			return mapping.findForward("failure");
		}
	}
}

package actions;

import org.apache.struts.action.*;

import forms.Registro2Form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Registro2Action extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
		// Recuperamos la forma
		Registro2Form forma = (Registro2Form) form;
		// Obtenemos los datos introducidos por el usuario
	    String nif=forma.getNif();
	    String nombreEmpresa=forma.getNombreEmpresa();
	    String sedeSocial=forma.getSedeSocial();
	    String telefono=forma.getTelefono();
	    String email=forma.getEmail();	
	    
	    String nombreContacto=forma.getNombreContacto();
	    String apellidosContacto=forma.getApellidosContacto();
	    String categoriaEmpresa=forma.getCategoriaEmpresa();
	    String tipoActividad=forma.getTipoActividad();
	    String subcategoria=forma.getSubcategoria();
	    

		HttpSession sesion=request.getSession(true);
		sesion.setAttribute("nif", nif);
		sesion.setAttribute("nombreEmpresa", nombreEmpresa);
		sesion.setAttribute("sedeSocial", sedeSocial);
		sesion.setAttribute("telefono", telefono);
		sesion.setAttribute("email", email);
		
		sesion.setAttribute("nombreContacto", nombreContacto);
		sesion.setAttribute("apellidosContacto", apellidosContacto);
		sesion.setAttribute("categoriaEmpresa", categoriaEmpresa);
		sesion.setAttribute("tipoActividad", tipoActividad);
		sesion.setAttribute("subcategoria", subcategoria);

		sesion.setAttribute("principal", "nuevoUsuario3.jsp");
		return mapping.findForward("success");

	}
}

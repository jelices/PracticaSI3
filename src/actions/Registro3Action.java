package actions;

import modelo.BaseDatos;
import modelo.Usuario;
import modelo.Usuario.Privilegio;

import org.apache.struts.action.*;

import forms.Registro3Form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Registro3Action extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
		// Recuperamos la forma
		Registro3Form forma = (Registro3Form) form;
		// Obtenemos los datos introducidos por el usuario
		HttpSession sesion=request.getSession(true);
		String usuario=(String) sesion.getAttribute("user");
		String password=(String) sesion.getAttribute("password");
		
		String nif=(String) sesion.getAttribute("nif");
	    String nombreEmpresa=(String) sesion.getAttribute("nombreEmpresa");
	    String sedeSocial=(String) sesion.getAttribute("sedeSocial");
	    String telefono=(String) sesion.getAttribute("telefono");
	    String email=(String) sesion.getAttribute("email");
	    
	    String nombreContacto=(String) sesion.getAttribute("nombreContacto");
	    String apellidosContacto=(String) sesion.getAttribute("apellidosContacto");
	    String categoriaEmpresa=(String) sesion.getAttribute("categoriaEmpresa");
	    String tipoActividad=(String) sesion.getAttribute("tipoActividad");
	    String subcategoria=(String) sesion.getAttribute("subcategoria");
		
	    String informe=forma.getInforme();
	    String formato=forma.getFormato();
	    String catSubvenciones=forma.getCatSubvenciones();
	    
		sesion.removeAttribute("user");
	    sesion.removeAttribute("password");
	    sesion.removeAttribute("nif");
		sesion.removeAttribute("nombreEmpresa");
		sesion.removeAttribute("sedeSocial");
		sesion.removeAttribute("telefono");
		sesion.removeAttribute("email");
		sesion.removeAttribute("nombreContacto");
		sesion.removeAttribute("apellidosContacto");
		sesion.removeAttribute("categoriaEmpresa");
		sesion.removeAttribute("tipoActividad");
		sesion.removeAttribute("subcategoria");
	    
	    Usuario u=new Usuario(usuario,nif, nombreEmpresa, sedeSocial, telefono, email, nombreContacto, apellidosContacto, categoriaEmpresa, tipoActividad, subcategoria, informe, formato, catSubvenciones);
	    if(BaseDatos.guardarUsuario(u, password))
	    {
	    	if(sesion.getAttribute("usuario")==null||((Usuario)sesion.getAttribute("usuario")).getTipoUsuario()!=Privilegio.administrador)
	    	{
	    		sesion.setAttribute("usuario", u);
	    	}
	    	sesion.setAttribute("mensaje", "Usuario guardado con exito");
	    	sesion.setAttribute("principal", "exito.jsp");
	    	return mapping.findForward("success");
	    }
	    else
	    {
	    	sesion.setAttribute("error", "Error al guardar en la base de datos");
	    	sesion.setAttribute("atras", "nuevoUsuario3");
	    	sesion.setAttribute("principal", "error.jsp");
	    	return mapping.findForward("failure");
	    }
	}
}

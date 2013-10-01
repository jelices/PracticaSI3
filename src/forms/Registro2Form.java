package forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;


public class Registro2Form extends ActionForm{

    private String nif;
    private String nombreEmpresa;
    private String sedeSocial;
    private String telefono;
    private String email;
    
    private String nombreContacto;
    private String apellidosContacto;
    private String categoriaEmpresa;
    private String tipoActividad;
    private String subcategoria;
    

    public String getNif(){
        return this.nif;
    }

    public void setNif(String nif){
        this.nif = nif;
    }
    
    public String getNombreEmpresa(){
        return this.nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa){
        this.nombreEmpresa = nombreEmpresa;
    }
    
    public String getSedeSocial(){
        return this.sedeSocial;
    }

    public void setSedeSocial(String sedeSocial){
        this.sedeSocial = sedeSocial;
    }
    
    public String getTelefono(){
        return this.telefono;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    
    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }
    
    public String getNombreContacto(){
        return this.nombreContacto;
    }

    public void setNombreContacto(String nombreContacto){
        this.nombreContacto = nombreContacto;
    }
    
    public String getApellidosContacto(){
        return this.apellidosContacto;
    }

    public void setApellidosContacto(String apellidosContacto){
        this.apellidosContacto = apellidosContacto;
    }
    
    public String getCategoriaEmpresa(){
        return this.categoriaEmpresa;
    }

    public void setCategoriaEmpresa(String categoriaEmpresa){
        this.categoriaEmpresa = categoriaEmpresa;
    }
    
    public String getTipoActividad(){
        return this.tipoActividad;
    }

    public void setTipoActividad(String tipoActividad){
        this.tipoActividad = tipoActividad;
    }
    
    public String getSubcategoria(){
        return this.subcategoria;
    }

    public void setSubcategoria(String subcategoria){
        this.subcategoria = subcategoria;
    }

    public void reset(ActionMapping map, HttpServletRequest req){
        nif="";
        nombreEmpresa="";
        sedeSocial="";
        telefono="";
        email="";
        nombreContacto="";
        apellidosContacto="";
        categoriaEmpresa="";
        tipoActividad="";
        subcategoria="";
    }
}

package forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;


public class Registro1Form extends ActionForm{

    private String nombre;
    private String password;
    private String password2;

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }
    
    public String getPassword2(){
        return this.password2;
    }

    public void setPassword2(String password2){
        this.password2 = password2;
    }

    public void reset(ActionMapping map, HttpServletRequest req){
        this.nombre = "";
        this.password="";
        this.password2="";
    }
}

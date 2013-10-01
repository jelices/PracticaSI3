package forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;

public class CambiarPasswordForm extends ActionForm {

    private String passwordPrevio;
    private String passwordNuevo;
    private String passwordNuevo2;

    public String getPasswordPrevio(){
        return this.passwordPrevio;
    }

    public void setPasswordPrevio(String passwordPrevio){
        this.passwordPrevio = passwordPrevio;
    }
    
    public String getPasswordNuevo(){
        return this.passwordNuevo;
    }

    public void setPasswordNuevo(String passwordNuevo){
        this.passwordNuevo = passwordNuevo;
    }
    
    public String getPasswordNuevo2(){
        return this.passwordNuevo2;
    }

    public void setPasswordNuevo2(String passwordNuevo2){
        this.passwordNuevo2 = passwordNuevo2;
    }

    public void reset(ActionMapping map, HttpServletRequest req){
        this.passwordPrevio = "";
        this.passwordNuevo="";
        this.passwordNuevo2="";
    }
}

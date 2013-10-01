package forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;


public class Registro3Form extends ActionForm{

    private String informe;
    private String formato;
    private String catSubvenciones;
    

    public String getInforme(){
        return this.informe;
    }

    public void setInforme(String informe){
        this.informe = informe;
    }
    
    public String getFormato(){
        return this.formato;
    }

    public void setFormato(String formato){
        this.formato = formato;
    }
    public String getCatSubvenciones(){
        return this.catSubvenciones;
    }

    public void setCatSubvenciones(String catSubvenciones){
        this.catSubvenciones = catSubvenciones;
    }
    
    public void reset(ActionMapping map, HttpServletRequest req){
    	informe="";
        formato="";
        catSubvenciones="";
    }
}

package utility;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.Date;

@ManagedBean
public class GrowlView {

    private String message1=" Необходимо выбрать или дату или период " ;

    public String getMessage2() {
        return message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

    private String message2=" Уточните дата или период " ;

    public int getErr() {
        return err;
    }

    public void setErr(int err) {
        this.err = err;
    }

    private int err=0;

    public String getMessage1() {
        return message1;
    }

    public void setMessage1(String message) {
        this.message1 = message;
    }

    public void addMessage1(Date dtNA,Date dtC,Date dtPO) {
        FacesContext context = FacesContext.getCurrentInstance();
        err=0;
 if (
     (dtNA!=null&dtC!=null)||(dtNA!=null&dtPO!=null)
         ) {
            context.addMessage(null, new FacesMessage("Error:", "Ошибка отчета: " + message1));
            err=1;
            //context.addMessage(null, new FacesMessage("Second Message", "Additional Message Detail"));
        }
    }

    public void addMessage2(Date dtNA,Date dtC,Date dtPO) {
        FacesContext context = FacesContext.getCurrentInstance();
        err=0;
        if (
                (dtNA!=null&dtC!=null)||(dtNA!=null&dtPO!=null)
                ) {
            context.addMessage(null, new FacesMessage("Error:", "Ошибка отчета: " + message1));
            err=1;
            //context.addMessage(null, new FacesMessage("Second Message", "Additional Message Detail"));
        }

        //err=0;
        if (
                (dtPO!=null&dtC==null)||(dtC!=null&dtPO==null)
                ) {
            context.addMessage(null, new FacesMessage("Error:", "Ошибка отчета: " + message2));
            err=1;
            //context.addMessage(null, new FacesMessage("Second Message", "Additional Message Detail"));
        }
    }

}

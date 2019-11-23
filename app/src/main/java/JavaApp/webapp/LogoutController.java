package JavaApp.webapp;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;




@Named
@RequestScoped
public class LogoutController {

    @Inject
    private HttpServletRequest request;

    public void l() {
        var session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
    public String logout() {
        l();
        return "login.xhtml?faces-redirect=true";
    }
}

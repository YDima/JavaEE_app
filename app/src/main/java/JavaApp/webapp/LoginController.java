package JavaApp.webapp;

import JavaApp.DataBase;
import JavaApp.login.LoginRequest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginController {

    @Inject
    private LoginRequest loginRequest;

    @Inject
    private DataBase dataBase;
    public void login() {

        if (dataBase.userExists(loginRequest.getUsername())) {

        }
        else

        System.out.println("Tried to log in using " + loginRequest.toString());

    }
}

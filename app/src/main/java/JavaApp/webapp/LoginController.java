package JavaApp.webapp;

import JavaApp.login.LoginRequest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginController {

    @Inject
    private LoginRequest LoginRequest;

    public String info(){
        return LoginRequest.toString();
    }

    public void login(){
        System.out.println("Welcome");
    }
}

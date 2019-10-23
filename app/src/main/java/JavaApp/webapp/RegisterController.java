package JavaApp.webapp;



import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
@Named
@RequestScoped

public class RegisterController {

    @Inject
    private JavaApp.register.RegisterRequest registerRequest;

    public void register(){
//        System.out.println("Hi, you are in app");

    }

}

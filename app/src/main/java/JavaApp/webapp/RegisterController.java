package JavaApp.webapp;



import JavaApp.auth.ProfileRepository;
import JavaApp.register.RegisterRequest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped

public class RegisterController {

    @Inject
    private RegisterRequest registerRequest;

    @Inject
    private ProfileRepository p;
    public void register(){
//        System.out.println("Hi, you are in app");
        p.sampleCodeWithPC();
    }

}

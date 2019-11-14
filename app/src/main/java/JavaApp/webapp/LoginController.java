package JavaApp.webapp;









import JavaApp.auth.ProfileRepository;
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
    private ProfileRepository profileRepository;


    public void login() {

        if (true) {
            profileRepository.sampleCodeWithPC();
        }
        else

        System.out.println("Tried to log in using " + loginRequest.toString());

    }

}

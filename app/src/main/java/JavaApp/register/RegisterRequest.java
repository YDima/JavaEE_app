package JavaApp.register;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Date;

@Named
@RequestScoped
public class RegisterRequest {


    private String NameSurname;
    private String username;
    private String password;
    private String email;
    private Date birthday;

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword (String password){
        this.password = password;
    }
    public String getNameSurname() {
        return NameSurname;
    }
    public void setNameSurname(String nameSurname) {
        NameSurname = nameSurname;
    }

    @Override
    public String toString() {
        return "RegisterRequest{" +
                "NameSurname='" + NameSurname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
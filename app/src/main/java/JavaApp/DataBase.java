package JavaApp;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.HashMap;

@Named
@ApplicationScoped
public class DataBase {

    private HashMap<String, String> map;
    public DataBase(){
        map = new HashMap<>();
        map.put("test", "test");
    }

    public void addUser(String username, String password){

        map.put(username, password);
    }

    public boolean userExists(String username){

        return map.containsKey(username);
    }

    public boolean correctCredentials(String username, String password){
        return map.containsKey(username) && map.get(username).equals(password);
    }

}

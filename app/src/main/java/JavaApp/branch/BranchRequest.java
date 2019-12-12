package JavaApp.branch;



import javax.enterprise.context.RequestScoped;

import javax.inject.Named;





@Named
@RequestScoped
public class BranchRequest {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BranchRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}

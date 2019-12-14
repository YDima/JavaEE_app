package JavaApp.category;


import JavaApp.sales.BranchEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;





@Named
@RequestScoped
public class CategoryRequest {
    private String name;
    private BranchEntity branch;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BranchEntity getBranch() {
        return branch;
    }

    public void setBranch(BranchEntity branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "CategoryRequest{" +
                "name='" + name + '\'' +
                ", branch=" + branch +
                '}';
    }
}

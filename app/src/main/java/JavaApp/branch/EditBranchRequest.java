package JavaApp.branch;


import JavaApp.sales.BranchEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;




@Named
@RequestScoped
public class EditBranchRequest {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EditBranchRequest() {
    }
    public EditBranchRequest(BranchEntity branch) {
        this.id = branch.getId();
        this.name = branch.getName();
    }

    public BranchEntity toBranch(){
        return new BranchEntity(id, name);
    }

}

package JavaApp.branch;


import JavaApp.sales.BranchEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;




@Named
@RequestScoped
public class EditBranchRequest {
    private Long id;
    private String name;
    private String newName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
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

package JavaApp.category;

import JavaApp.sales.Branch;
import JavaApp.sales.Category;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;




@Named
@RequestScoped
public class EditCategoryRequest {
    private Long id;
    private String name;
    private Branch branchId;

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

    public Branch getBranchId() {
        return branchId;
    }

    public void setBranchId(Branch branchId) {
        this.branchId = branchId;
    }

    public EditCategoryRequest() {

    }

    public EditCategoryRequest(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.branchId = category.getBranchId();
    }

}














































package JavaApp.category;

import JavaApp.sales.Category;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;




@Named
@RequestScoped
public class EditCategoryRequest {
    private Long id;
    private String name;
    private Long branchId;

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

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public EditCategoryRequest() {

    }

    public EditCategoryRequest(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.branchId = category.getBranch().getId();
    }

    @Override
    public String toString() {
        return "EditCategoryRequest{" +
                "name='" + name + '\'' +
                ", branch=" + branchId +
                '}';
    }
}

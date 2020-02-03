package JavaApp.category;

import JavaApp.sales.Category;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;




@Named
@RequestScoped
public class CategoryRequest {
    private Long id;
    private String name;
    private Long branch_id;

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

    public Long getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(Long branch_id) {
        this.branch_id = branch_id;
    }

    public CategoryRequest() {

    }

    public CategoryRequest(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.branch_id = category.getBranch_id();
    }

}














































package JavaApp.admin.category.create_edit;

import JavaApp.Retriever;
import JavaApp.admin.branch.BranchRepository;
import JavaApp.admin.category.CategoryService;
import JavaApp.sales.jpa.Category;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;


@Named
@RequestScoped
public class CategoryController implements Serializable {

   @Inject
   private CategoryRequest categoryRequest;

   @Inject
   private Retriever retriever;

   @Inject
   CategoryService categoryService;

   @Inject
   BranchRepository branchRepository;

    public CategoryRequest getCategoryRequest() {
        if (categoryRequest == null){
            categoryRequest = createCategoryRequest();
        }
        return categoryRequest;
    }

    private CategoryRequest createCategoryRequest() {
        if (retriever.contains("id")) {
            var id = retriever.getLong("id");
            var category = categoryService.findCategoryById(id);
            return new CategoryRequest(category);
        }
        return new CategoryRequest();
    }

     public String save() {

         var category = new Category(categoryRequest.getId(), categoryRequest.getName(), categoryRequest.getBranch_id());
         categoryService.save(category);
        return "/admin/admin.xhtml?faces-redirect=true";
     }

}




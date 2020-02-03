package JavaApp.category;

import JavaApp.Retriever;
import JavaApp.branch.BranchRepository;
import JavaApp.sales.Category;

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
   CategoryRepository categoryRepository;

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
            var category = categoryRepository.findCategoryById(id);
            return new CategoryRequest(category);
        }
        return new CategoryRequest();
    }

     public String save() {

         var category = new Category(categoryRequest.getId(), categoryRequest.getName(), categoryRequest.getBranch_id());
         categoryRepository.save(category);
        return "/admin/admin.xhtml?faces-redirect=true";
     }

}




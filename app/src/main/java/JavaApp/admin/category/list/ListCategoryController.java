package JavaApp.admin.category.list;

import JavaApp.admin.category.CategoryRepository;
import JavaApp.sales.jpa.Category;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;




@Named
@RequestScoped
public class ListCategoryController implements Serializable {
    @Inject
    CategoryRepository categoryRepository;

    public List<Category> getCategoryList() {

        return categoryRepository.findAllCategories();
    }

}

package JavaApp.category;

import JavaApp.sales.CategoryEntity;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;




@Named
@ViewScoped
public class ListCategoryController implements Serializable {
    @Inject
    CategoryRepository categoryRepository;

    private List<CategoryEntity> categoryList;

    public List<CategoryEntity> getCategoryList() {
        if (categoryList == null) {
            categoryList = categoryRepository.findAllCategories();
        }
        return categoryList;
    }

}

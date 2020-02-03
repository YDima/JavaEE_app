package JavaApp.admin.category;

import JavaApp.sales.jpa.Category;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@ApplicationScoped
public class CategoryService {
    @PersistenceContext
    EntityManager em;
    @Inject
    CategoryRepository categoryRepository;

    public Category findCategoryById(long id) {
        return categoryRepository.findCategoryById(id);
    }

    @Transactional
    public void save(Category category) {
        categoryRepository.save(category);
    }

}

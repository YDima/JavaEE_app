package JavaApp.category;

import JavaApp.sales.Category;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@ApplicationScoped
public class CategoryRepository {
    @PersistenceContext
    EntityManager em;

    public Category findCategoryById(long id) {
        var category = em.find(Category.class, id);
        return category;
    }

    public List<Category> findAllCategories() {
        return em.createQuery("from Category", Category.class).getResultList();
    }

    @Transactional
    public void save(Category category) {
        if (category.getId()==null && category.getBranchId()==null)
            em.persist(category);
        else
            em.merge(category);
    }

}

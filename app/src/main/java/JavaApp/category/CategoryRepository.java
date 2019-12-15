package JavaApp.category;

import JavaApp.sales.CategoryEntity;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;


@ApplicationScoped
public class CategoryRepository {
    @PersistenceContext
    EntityManager em;

    public List<CategoryEntity> findAllCategories() {
        return em.createQuery("from CategoryEntity", CategoryEntity.class).getResultList();
    }

    @Transactional
    public void save(@NotNull CategoryEntity category) {
        if (category.getId()==null)
            em.persist(category);
        else
            em.merge(category);
    }

}

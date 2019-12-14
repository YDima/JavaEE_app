package JavaApp.category;


import JavaApp.sales.BranchEntity;
import JavaApp.sales.CategoryEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;


@Named
@RequestScoped
public class CategoryController {
    @Inject
    CategoryRequest categoryRequest;
    @Inject
    EditCategoryRequest editCategoryRequest;

    @Inject
    private HttpServletRequest request;

    @PersistenceContext
    private EntityManager em;

    private BranchEntity branch;

    public BranchEntity getBranch() {
        return branch;
    }

    public void setBranch(BranchEntity branch) {
        this.branch = branch;
    }

    @Transactional
    public String createCategory(){
        CategoryEntity category= new CategoryEntity(categoryRequest.getName(), categoryRequest.getBranch());
        addCategory(category);
        return "/adminProfile.xhtml?faces-redirect=true";
    }



    @Transactional
    public String editCategory(){
        CategoryEntity category = new CategoryEntity(categoryRequest.getName());
        CategoryEntity edit = new CategoryEntity(editCategoryRequest.getName());

        editCategory(category, edit);
        return "/adminProfile.xhtml?faces-redirect=true";
    }

    public void addCategory(CategoryEntity category){
        if (ifCategoryExists(categoryRequest.getName())) {
            throw new IllegalStateException(String.format("Category %s already exists.", category.getName()));
        }
        else {
            em.persist(category);
        }
    }

    public boolean ifCategoryExists(String name) {
        CategoryEntity category = new CategoryEntity(name, getBranch());
        var list = em.createQuery("from CategoryEntity where name = :name", CategoryEntity.class)
                .setParameter("name", category.getName())
                .getResultList();
        if (list.isEmpty())
            return false;
        else
            return true;
    }

    public void editCategory(CategoryEntity category, CategoryEntity edit){

    }
}

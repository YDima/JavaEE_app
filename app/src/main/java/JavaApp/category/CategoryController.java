package JavaApp.category;


import JavaApp.branch.BranchRepository;
import JavaApp.sales.BranchEntity;
import JavaApp.sales.CategoryEntity;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@Named
@ViewScoped
public class CategoryController implements Serializable {

   @Inject
    private BranchRepository branchRepository;

   @Inject
    private CategoryRepository categoryRepository;

    private CategoryEntity category;

    private List<BranchEntity> branchList;

//    private Integer id;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

//    @Transactional
//    public String createCategory(){
//        CategoryEntity category= new CategoryEntity(categoryRequest.getName(), categoryRequest.getBranch());
//        addCategory(category);
//        return "/adminProfile.xhtml?faces-redirect=true";
//    }
//
//    public void addCategory(CategoryEntity category){
//        if (ifCategoryExists(categoryRequest.getName())) {
//            throw new IllegalStateException(String.format("Category %s already exists.", category.getName()));
//        }
//        else {
//            em.persist(category);
//        }
//    }
//
//    public boolean ifCategoryExists(String name) {
//        CategoryEntity category = new CategoryEntity(name, getBranch());
//        var list = em.createQuery("from CategoryEntity where name = :name", CategoryEntity.class)
//                .setParameter("name", category.getName())
//                .getResultList();
//        if (list.isEmpty())
//            return false;
//        else
//            return true;
//    }

    public List<BranchEntity> getBranchList() {
        if (branchList == null) {
            branchList = branchRepository.findAll();
        }
        return branchList;
    }

    public CategoryEntity getCategory() {
        if (category == null) {
            category = new CategoryEntity();
            }
        return category;
    }

    public String saveCategory() {
        categoryRepository.save(category);
        return "/adminProfile.xhtml?faces-redirect=true";
    }
}























package JavaApp.category;

import JavaApp.Retriever;
import JavaApp.branch.BranchRepository;
import JavaApp.sales.Branch;
import JavaApp.sales.Category;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;


@Named
@RequestScoped
public class CategoryController implements Serializable {

   @Inject
   private EditCategoryRequest editCategoryRequest;

   @Inject
   private Retriever retriever;

   @Inject
   CategoryRepository categoryRepository;

   @Inject
   BranchRepository branchRepository;

//    @Transactional
//    public String createCategory(){
//        Category category= new Category(categoryRequest.getName(), categoryRequest.getBranch());
//        addCategory(category);
//        return "/adminProfile.xhtml?faces-redirect=true";
//    }
//
//    public void addCategory(Category category){
//        if (ifCategoryExists(categoryRequest.getName())) {
//            throw new IllegalStateException(String.format("Category %s already exists.", category.getName()));
//        }
//        else {
//            em.persist(category);
//        }
//    }
//
//    public boolean ifCategoryExists(String name) {
//        Category category = new Category(name);
//        var list = em.createQuery("from Category where name = :name", Category.class)
//                .setParameter("name", category.getName())
//                .getResultList();
//        if (list.isEmpty())
//            return false;
//        else
//            return true;
//    }

//    public List<BranchEntity> getBranchList() {
//        if (branchList == null) {
//            branchList = branchRepository.findAll();
//        }
//        return branchList;
//    }
//
//    public CategoryEntity getCategory() {
//        if (category == null) {
//            category = new CategoryEntity();
//        }
//        return category;
//    }
//
//    public BranchEntity getBranch(){
//        if (branch == null) {
//            if (id == null) {
//                branch = new BranchEntity();
//            } else {
//                branch = branchRepository.findBranchById(id);
//            }
//        }
//        return branch;
//    }
//
//    public String saveCategory() {
//        categoryRepository.save(category);
//        return "/adminProfile.xhtml?faces-redirect=true";
//    }

    public EditCategoryRequest getEditCategoryRequest() {
        if (editCategoryRequest == null){
            editCategoryRequest = createEditCategoryRequest();
        }
        return editCategoryRequest;
    }

    private EditCategoryRequest createEditCategoryRequest() {
        if (retriever.contains("id")) {
            var id = retriever.getLong("id");
            var category = categoryRepository.findCategoryById(id);
            return new EditCategoryRequest(category);
        }
        return new EditCategoryRequest();
    }

     public String save() {
         Branch branch = branchRepository.findBranchById(editCategoryRequest.getBranchId());
         var category = new Category(editCategoryRequest.getName(), branch);
         categoryRepository.save(category);
         return "/adminProfile.xhtml?faces-redirect=true";
     }

}




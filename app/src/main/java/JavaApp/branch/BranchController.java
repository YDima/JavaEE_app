package JavaApp.branch;
import JavaApp.sales.BranchEntity;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class BranchController implements Serializable {

    @Inject
    BranchRepository branchRepository;

    private BranchEntity branch;

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //    @Transactional
//    public String createBranch(){
//        BranchEntity branch = new BranchEntity(branchRequest.getName());
//
//        addBranch(branch);
//        return "/adminProfile.xhtml?faces-redirect=true";
//    }
//
//    public void addBranch(BranchEntity branch){
//        if (ifBranchExists(branchRequest.getName())) {
//            throw new IllegalStateException(String.format("Branch %s already exists.", branch.getName()));
//        }
//        else {
//            branchRepository.save(branch);
//        }
//    }
//
//    public boolean ifBranchExists(String name) {
//        BranchEntity branch = new BranchEntity(name);
//        var list = em.createQuery("from BranchEntity where name = :name", BranchEntity.class)
//                .setParameter("name", branch.getName())
//                .getResultList();
//        if (list.isEmpty())
//            return false;
//        else
//            return true;
//    }
//
//    public EditBranchRequest getEditRequest() {
//        if (editBranchRequest == null) {
//            editBranchRequest = createEditBranchRequest();
//        }
//        return editBranchRequest;
//    }
//
//    public EditBranchRequest createEditBranchRequest(){
//        if (retriever.contains("branchId")) {
//            var branchId = retriever.getLong("branchId");
//            var branch = branchRepository.findBranchById(branchId).orElseThrow();
//            return new EditBranchRequest(branch);
//        }
//        return new EditBranchRequest();
//    }

    public BranchEntity getBranch(){
        if (branch == null) {
            if (id == null) {
                branch = new BranchEntity();
            } else {
                branch = branchRepository.findBranchById(id);
            }
        }
        return branch;
    }

    public String save() {
        branchRepository.save(branch);

        return "/adminProfile.xhtml?faces-redirect=true";
    }
}
























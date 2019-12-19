package JavaApp.branch;

import JavaApp.Retriever;
import JavaApp.sales.Branch;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class BranchController implements Serializable {

    @Inject
    BranchRepository branchRepository;

    @Inject
    private EditBranchRequest editBranchRequest;

    @Inject
    private Retriever retriever;


    //    @Transactional
//    public String createBranch(){
//        Branch branch = new Branch(branchRequest.getName());
//
//        addBranch(branch);
//        return "/adminProfile.xhtml?faces-redirect=true";
//    }
//
//    public void addBranch(Branch branch){
//        if (ifBranchExists(branchRequest.getName())) {
//            throw new IllegalStateException(String.format("Branch %s already exists.", branch.getName()));
//        }
//        else {
//            branchRepository.save(branch);
//        }
//    }
//
//    public boolean ifBranchExists(String name) {
//        Branch branch = new Branch(name);
//        var list = em.createQuery("from Branch where name = :name", Branch.class)
//                .setParameter("name", branch.getName())
//                .getResultList();
//        if (list.isEmpty())
//            return false;
//        else
//            return true;
//    }
//
    public EditBranchRequest getEditBranchRequest() {
        if (editBranchRequest == null) {
            editBranchRequest = createEditBranchRequest();
        }
        return editBranchRequest;
    }

    public EditBranchRequest createEditBranchRequest(){
        if (retriever.contains("id")) {
            var id = retriever.getLong("id");
            var branch = branchRepository.findBranchById(id);
            return new EditBranchRequest(branch);
        }
        return new EditBranchRequest();
    }

//    public Branch getBranch(){
//        if (branch == null) {
//            if (id == null) {
//                branch = new Branch();
//            } else {
//                branch = branchRepository.findBranchById(id);
//            }
//        }
//        return branch;
//    }

    public String save() {
        var branch = new Branch(editBranchRequest.getName());
        branchRepository.save(branch);

        return "/adminProfile.xhtml?faces-redirect=true";
    }
}
























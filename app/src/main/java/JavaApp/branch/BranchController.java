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
    private BranchRequest branchRequest;

    @Inject
    private Retriever retriever;


    //    @Transactional
//    public String createBranch(){
//        Branch branch = new Branch(branchRequest.getName());
//
//        addBranch(branch);
//        return "/admin.xhtml?faces-redirect=true";
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
    public BranchRequest getBranchRequest() {
        if (branchRequest == null) {
            branchRequest = createBranchRequest();
        }
        return branchRequest;
    }

    public BranchRequest createBranchRequest(){
        if (retriever.contains("id")) {
            var id = retriever.getLong("id");
            var branch = branchRepository.findBranchById(id);
            return new BranchRequest(branch);
        }
        return new BranchRequest();
    }

    public String save() {
        var branch = new Branch(branchRequest.getId(), branchRequest.getName());
        branchRepository.save(branch);

        return "/admin/admin.xhtml?faces-redirect=true";
    }
}
























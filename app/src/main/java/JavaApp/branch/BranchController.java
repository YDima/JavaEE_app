package JavaApp.branch;



import JavaApp.Retriever;
import JavaApp.sales.BranchEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Named
@RequestScoped
public class BranchController{
    @Inject
    BranchRequest branchRequest;

    @Inject
    BranchRepository branchRepository;

    @Inject
    Retriever retriever;

    @PersistenceContext
    private EntityManager em;

    private EditBranchRequest editBranchRequest;



    @Transactional
    public String createBranch(){
        BranchEntity branch = new BranchEntity(branchRequest.getName());

        addBranch(branch);
        return "/adminProfile.xhtml?faces-redirect=true";
    }

    @Transactional
    public String editBranch(){
        save();
        return "/adminProfile.xhtml?faces-redirect=true";
    }

    public void addBranch(BranchEntity branch){
        if (ifBranchExists(branchRequest.getName())) {
            throw new IllegalStateException(String.format("Branch %s already exists.", branch.getName()));
        }
        else {
            branchRepository.saveBranch(branch);
        }
    }

    public boolean ifBranchExists(String name) {
        BranchEntity branch = new BranchEntity(name);
        var list = em.createQuery("from BranchEntity where name = :name", BranchEntity.class)
                .setParameter("name", branch.getName())
                .getResultList();
        if (list.isEmpty())
            return false;
        else
            return true;
    }

    public EditBranchRequest getEditRequest() {
        if (editBranchRequest == null) {
            editBranchRequest = createEditBranchRequest();
        }
        return editBranchRequest;
    }

    public EditBranchRequest createEditBranchRequest(){
        if (retriever.contains("branchId")) {
            var branchId = retriever.getLong("branchId");
            var branch = branchRepository.findBranchById(branchId).orElseThrow();
            return new EditBranchRequest(branch);
        }
        return new EditBranchRequest();
    }

    public String save() {
        var branch = editBranchRequest.toBranch();
        branchRepository.saveBranch(branch);

        return "/adminProfile.xhtml?faces-redirect=true";
    }
}
























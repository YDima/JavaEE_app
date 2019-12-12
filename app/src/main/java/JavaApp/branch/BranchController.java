package JavaApp.branch;





import JavaApp.sales.BranchEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class BranchController {

    @Inject
    BranchRequest branchRequest;

    @Inject
    private HttpServletRequest request;

    @PersistenceContext
    private EntityManager em;

    public void addBranch(BranchEntity branch){
        if (ifBranchExists(branchRequest.getName())) {
            throw new IllegalStateException(String.format("Branch %s already exists.", branch.getName()));
        }
        else {
            em.persist(branch);
        }
    }

    public boolean ifBranchExists(String name) {
        BranchEntity branch = new BranchEntity(name);
        var list = em.createQuery("from User where name = :name", BranchEntity.class)
                .setParameter("name", branch.getName())
                .getResultList();
        if (list.isEmpty())
            return false;
        else
            return true;
    }
}

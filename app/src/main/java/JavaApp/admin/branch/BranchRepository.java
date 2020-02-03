package JavaApp.admin.branch;

import JavaApp.sales.jpa.Branch;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@ApplicationScoped
public class BranchRepository {
    @PersistenceContext
    EntityManager em;

    public Branch findBranchById(long branchId) {
        var branch = em.find(Branch.class, branchId);
        return branch;
    }

    @Transactional
    public void save (Branch branch) {
        if (branch.getId()==null)
            em.persist(branch);
        else
            em.merge(branch);
    }

    public List<Branch> findAll() {
        return em.createQuery("from Branch", Branch.class).getResultList();
    }

}

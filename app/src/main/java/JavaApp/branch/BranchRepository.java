package JavaApp.branch;

import JavaApp.sales.BranchEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;


@ApplicationScoped
public class BranchRepository {
    @PersistenceContext
    EntityManager em;

    public BranchEntity findBranchById(int branchId) {
        var branch = em.find(BranchEntity.class, branchId);
        return branch;
    }

    @Transactional
    public void save(@NotNull BranchEntity branch) {
        if (branch.getId()==null)
            em.persist(branch);
        else
            em.merge(branch);
    }

    public List<BranchEntity> findAll() {
        return em.createQuery("from BranchEntity", BranchEntity.class).getResultList();
    }

}

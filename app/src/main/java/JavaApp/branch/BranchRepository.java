package JavaApp.branch;

import JavaApp.sales.BranchEntity;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@ApplicationScoped
public class BranchRepository {
    @PersistenceContext
    EntityManager em;

    public Optional<BranchEntity> findBranchById(Long branchId) {
        var branch = em.find(BranchEntity.class, branchId);
        return Optional.ofNullable(branch);
    }

    @Transactional
    public BranchEntity saveBranch(BranchEntity branch) {
        if (branch.getId()==null)
            em.persist(branch);
        else
            branch = em.merge(branch);

        return branch;
    }


    public List<BranchEntity> findAll() {
        return em.createQuery("from BranchEntity", BranchEntity.class).getResultList();
    }
}

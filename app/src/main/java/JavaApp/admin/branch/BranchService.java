package JavaApp.admin.branch;

import JavaApp.sales.jpa.Branch;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@ApplicationScoped
public class BranchService {
    @PersistenceContext
    EntityManager em;
    @Inject
    BranchRepository branchRepository;

    public Branch findBranchById(long branchId) {
        return branchRepository.findBranchById(branchId);
    }

    @Transactional
    public void save (Branch branch) {
        branchRepository.save(branch);
    }

}

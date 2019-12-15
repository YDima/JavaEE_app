package JavaApp.branch;


import JavaApp.sales.BranchEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@Named
@RequestScoped
public class ListBranchController implements Serializable {
    @Inject
    BranchRepository branchRepository;
    private List<BranchEntity> branchEntityList;

    public List<BranchEntity> getBranchList() {
        if (branchEntityList == null)
            branchEntityList = branchRepository.findAll();

        return branchRepository.findAll();
    }
}

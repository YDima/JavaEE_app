package JavaApp.branch;


import JavaApp.sales.BranchEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;


@Named
@RequestScoped
public class ListBranchController {
    @Inject
    BranchRepository branchRepository;

    List<BranchEntity> getBranchList() {
        return branchRepository.findAll();
    }
}

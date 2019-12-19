package JavaApp.branch;


import JavaApp.sales.Branch;

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

    public List<Branch> getBranchList() {

        return branchRepository.findAll();
    }
}

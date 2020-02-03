package JavaApp.admin.branch.list;


import JavaApp.admin.branch.BranchRepository;
import JavaApp.sales.jpa.Branch;

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

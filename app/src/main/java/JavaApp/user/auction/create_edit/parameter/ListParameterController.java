package JavaApp.user.auction.create_edit.parameter;


import JavaApp.sales.jpa.Parameter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ListParameterController {

    @Inject
    ParameterService parameterService;

    public List<Parameter> getParameterList() {
        return parameterService.findAll();
    }
}

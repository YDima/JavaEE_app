package JavaApp.parameter;


import JavaApp.sales.Parameter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ListParameterController {

    @Inject
    ParameterRepository parameterRepository;

    public List<Parameter> getParameterList() {
        return parameterRepository.findAll();
    }
}

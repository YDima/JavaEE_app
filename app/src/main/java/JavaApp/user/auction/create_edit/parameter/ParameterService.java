package JavaApp.user.auction.create_edit.parameter;


import JavaApp.sales.jpa.Parameter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ParameterService {
    @PersistenceContext
    EntityManager em;
    @Inject
    ParameterRepository parameterRepository;

    public Parameter findParameterById(long parameterId) {
        return parameterRepository.findParameterById(parameterId);
    }

    @Transactional
    public void save(Parameter parameter) {
        parameterRepository.save(parameter);
    }

    public List<Parameter> findAll() { return parameterRepository.findAll(); }

}

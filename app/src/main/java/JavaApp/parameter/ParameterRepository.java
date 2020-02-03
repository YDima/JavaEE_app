package JavaApp.parameter;


import JavaApp.sales.Parameter;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ParameterRepository {
    @PersistenceContext
    EntityManager em;

    public Parameter findParameterById(long parameterId) {
        var parameter = em.find(Parameter.class, parameterId);
        return parameter;
    }

    @Transactional
    public void save(Parameter parameter) {
        if (parameter.getId() == null)
            em.persist(parameter);
        else
            em.merge(parameter);
    }

    public List<Parameter> findAll() { return em.createQuery("from Parameter", Parameter.class).getResultList(); }

}

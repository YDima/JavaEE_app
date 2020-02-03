package JavaApp.parameter;

import JavaApp.Retriever;
import JavaApp.sales.Parameter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class ParameterController {


        @Inject
        ParameterRequest parameterRequest;
        @Inject
        private HttpServletRequest request;
        @PersistenceContext
        private EntityManager em;
        @Inject
        private Retriever retriever;
        @Inject
        private ParameterRepository parameterRepository;


        public ParameterRequest getParameterRequest() {
            if (parameterRequest == null) {
                parameterRequest = createParameterRequest();
            }
            return parameterRequest;
        }

        public ParameterRequest createParameterRequest(){
            if (retriever.contains("id")) {
                var id = retriever.getLong("id");
                var parameter = parameterRepository.findParameterById(id);
                return new ParameterRequest(parameter);
            }
            return new ParameterRequest();
        }


        public String save() {
            var parameter = new Parameter(parameterRequest.getId(), parameterRequest.getName());
            parameterRepository.save(parameter);

            return "createParameter.xhtml?faces-redirect=true";
        }

    }













































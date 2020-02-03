package JavaApp.parameter;


import JavaApp.sales.Parameter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@Named
@RequestScoped
public class ParameterRequest {

    private Long id;

    private String name;

    public ParameterRequest(Parameter parameter) {
        this.id = parameter.getId();
        this.name = parameter.getName();
    }

    public ParameterRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }






}




















































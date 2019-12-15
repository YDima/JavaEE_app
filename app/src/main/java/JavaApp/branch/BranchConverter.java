package JavaApp.branch;

import JavaApp.sales.BranchEntity;
import javax.enterprise.context.Dependent;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;


@Dependent
@FacesConverter(forClass = BranchEntity.class, managed = true)
public class BranchConverter implements Converter<BranchEntity> {
    @Inject
    private BranchRepository branchRepository;

    @Override
    public BranchEntity getAsObject(FacesContext context, UIComponent component, String value) {
        return branchRepository.findBranchById(Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, BranchEntity value) {
        return value.getId().toString();
    }
}

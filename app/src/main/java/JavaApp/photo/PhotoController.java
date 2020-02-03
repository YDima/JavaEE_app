package JavaApp.photo;


import JavaApp.Retriever;
import JavaApp.sales.Photo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;


@Named
@RequestScoped
public class PhotoController {

    @Inject
    PhotoRequest photoRequest;

    @Inject
    private HttpServletRequest request;
    @PersistenceContext
    private EntityManager em;
    @Inject
    private Retriever retriever;

    @Inject
    PhotoRepository photoRepository;

    public PhotoRequest getPhotoRequest() {
        if (photoRequest == null)
            photoRequest = createPhotoRequest();

        return photoRequest;
    }

    public PhotoRequest createPhotoRequest() {
        if (retriever.contains("id")) {
            var id = retriever.getLong("id");
            var photo = photoRepository.findPhotoById(id);
            return new PhotoRequest(photo);
        }
        return new PhotoRequest();
    }


    public String save() {
        var photo = new Photo(photoRequest.getLink());
        photoRepository.save(photo);
        return "createParameter.xhtml?faces-redirect=true";

    }

}












































package JavaApp.photo;


import JavaApp.sales.Photo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ListPhotoController {

    @Inject
    PhotoRepository photoRepository;


    public List<Photo> getPhotoList() {
        return photoRepository.findAll();
    }
}

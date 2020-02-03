package JavaApp.user.auction.create_edit.photo;


import JavaApp.sales.jpa.Photo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ListPhotoController {

    @Inject
    PhotoService photoService;

    public List<Photo> getPhotoList() {
        return photoService.findAll();
    }
}

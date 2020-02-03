package JavaApp.photo;

import JavaApp.sales.Photo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;








@Named
@RequestScoped
public class PhotoRequest {

    private Long id;

    private String link;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public PhotoRequest() {
    }

    public PhotoRequest(Photo photo) {
        this.id = photo.getId();
        this.link = photo.getLink();
    }

}





















































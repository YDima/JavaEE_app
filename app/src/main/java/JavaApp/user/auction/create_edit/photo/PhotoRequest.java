package JavaApp.user.auction.create_edit.photo;

import JavaApp.sales.jpa.Photo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;








@Named
@RequestScoped
public class PhotoRequest {

    private Long id;

    private String link;

    private Long auction_id;

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

    public Long getAuction_id() {
        return auction_id;
    }

    public void setAuction_id(Long auction_id) {
        this.auction_id = auction_id;
    }

    public PhotoRequest() {
    }

    public PhotoRequest(Photo photo) {
        this.id = photo.getId();
        this.link = photo.getLink();
        this.auction_id = photo.getAuction_id();
    }

}





















































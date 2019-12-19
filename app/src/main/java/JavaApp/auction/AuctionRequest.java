package JavaApp.auction;


import JavaApp.sales.AuctionParameter;
import JavaApp.sales.Category;
import JavaApp.sales.Photo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.List;


@Named
@RequestScoped
public class AuctionRequest {
    private Category category;
    private String title;
    private String description;
    private BigDecimal price;
    private List<Photo> photos;
    private List<AuctionParameter> parameters;
    private Long ownerId;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public List<AuctionParameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<AuctionParameter> parameters) {
        this.parameters = parameters;
    }

    public Long getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "AuctionRequest{" +
                "category=" + category +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", photos=" + photos +
                ", parameters=" + parameters +
                ", ownerId=" + ownerId +
                '}';
    }
}

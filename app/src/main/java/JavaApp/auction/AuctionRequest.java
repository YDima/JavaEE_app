package JavaApp.auction;


import JavaApp.sales.AuctionParameterEntity;
import JavaApp.sales.CategoryEntity;
import JavaApp.sales.PhotoEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.List;


@Named
@RequestScoped
public class AuctionRequest {
    private CategoryEntity category;
    private String title;
    private String description;
    private BigDecimal price;
    private List<PhotoEntity> photos;
    private List<AuctionParameterEntity> parameters;
    private Long ownerId;

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
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

    public List<PhotoEntity> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotoEntity> photos) {
        this.photos = photos;
    }

    public List<AuctionParameterEntity> getParameters() {
        return parameters;
    }

    public void setParameters(List<AuctionParameterEntity> parameters) {
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

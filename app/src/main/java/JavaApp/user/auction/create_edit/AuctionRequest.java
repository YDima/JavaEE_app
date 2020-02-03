package JavaApp.user.auction.create_edit;


import JavaApp.sales.jpa.Auction;
import JavaApp.sales.jpa.AuctionParameter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.List;


@Named
@RequestScoped
public class AuctionRequest {
    private Long id;
    private Long category_id;
    private String title;
    private String description;
    private BigDecimal price;
    private List<AuctionParameter> parameters;
    private String owner_username;

    public AuctionRequest(Auction auction) {
        this.id = auction.getId();
        this.category_id = auction.getCategory_id();
        this.title = auction.getTitle();
        this.description = auction.getDescription();
        this.price = auction.getPrice();
        this.owner_username = auction.getOwner_username();
    }

    public AuctionRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
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

    public List<AuctionParameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<AuctionParameter> parameters) {
        this.parameters = parameters;
    }

    public String getOwner_username() {
        return owner_username;
    }
    public void setOwner_username(String owner_username) {
        this.owner_username = owner_username;
    }

    @Override
    public String toString() {
        return "AuctionRequest{" +
                "category=" + category_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", parameters=" + parameters +
                ", owner_username=" + owner_username +
                '}';
    }
}


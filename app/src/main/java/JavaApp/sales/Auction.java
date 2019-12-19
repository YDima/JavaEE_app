package JavaApp.sales;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;




@Entity
@Table(name="auction")
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @ManyToOne //many auctions have same category
    @JoinColumn(name="category_id", nullable = false)
    private Category category;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private BigDecimal price;

    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true, mappedBy = "auction")
//    @JoinColumn(name="auction_id", nullable = false)
    @OrderColumn(name="order")
    private List<Photo> photos;

    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true, mappedBy = "auction")
    private List<AuctionParameter> parameters;

    @Column(name="owner_id")
    private Long ownerId;

    public Auction() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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


    public Auction(Category category, String title, String description, BigDecimal price, List<Photo> photos, List<AuctionParameter> parameters, Long ownerId) {
        this.category = category;
        this.title = title;
        this.description = description;
        this.price = price;
        this.photos = photos;
        this.parameters = parameters;
        this.ownerId = ownerId;
    }
}

package JavaApp.sales;


import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name="auction")
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @JoinColumn(name="category_id", nullable = false)
    private Long category_id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private BigDecimal price;

    @Column(name="photo_id")
    private Long photo;

    @Column(name="owner_username")
    private String owner_username;


    public Auction() {

    }








    public Auction(Long id, Long category_id, String title, Long photo, String description, BigDecimal price, String username) {
        this.id = id;
        this.category_id = category_id;
        this.title = title;
        this.photo = photo;
        this.description = description;
        this.price = price;
        this.owner_username = username;
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

    public Long getPhoto() {
        return photo;
    }

    public void setPhoto(Long photo) {
        this.photo = photo;
    }


    public String getOwner_username() {
        return owner_username;
    }

    public void setOwner_username(String owner_username) {
        this.owner_username = owner_username;
    }


}

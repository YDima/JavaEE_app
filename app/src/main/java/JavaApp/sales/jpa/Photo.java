package JavaApp.sales.jpa;

import javax.persistence.*;











@Entity
@Table(name="photo")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="link")
    private String link;

    @Column(name="auction_id")
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


    public Photo() {
    }

    public Photo (String link, Long auction_id) {
        this.link = link;
        this.auction_id = auction_id;
    }

    public Long getAuction_id() {
        return auction_id;
    }

    public void setAuction_id(Long auction_id) {
        this.auction_id = auction_id;
    }
}





































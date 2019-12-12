package JavaApp.sales;

import javax.persistence.*;







@Entity
@Table(name="photo")
public class PhotoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="link")
    private Long link;

    @ManyToOne
    @JoinColumn(name="auction_id")
    private AuctionEntity auction;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLink() {
        return link;
    }

    public void setLink(Long link) {
        this.link = link;
    }

    public AuctionEntity getAuction() {
        return auction;
    }

    public void setAuction(AuctionEntity auction) {
        this.auction = auction;
    }
}

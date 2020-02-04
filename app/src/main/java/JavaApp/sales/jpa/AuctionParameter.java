package JavaApp.sales.jpa;

import javax.persistence.*;
import java.io.Serializable;






@Entity
@Table(name="auction_parameter")
public class AuctionParameter implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Id
    @Column(name="auction_id")
    private Long auction_id;

    @Id
    @Column (name = "parameter_id")
    private Long parameter_id;

    @Column(name = "value")
    private String value;

    public AuctionParameter(Long id, Long auction_id, Long parameter_id, String value) {
        this.id = id;
        this.auction_id = auction_id;
        this.parameter_id = parameter_id;
        this.value = value;
    }

    public AuctionParameter() {
    }

    public Long getAuction_id() {
        return auction_id;
    }

    public void setAuction_id(Long auction_id) {
        this.auction_id = auction_id;
    }

    public Long getParameter_id() {
        return parameter_id;
    }

    public void setParameter_id(Long parameter_id) {
        this.parameter_id = parameter_id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

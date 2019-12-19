package JavaApp.sales;

import javax.persistence.*;
import java.io.Serializable;






@Entity
@Table(name="auction_parameter")
public class AuctionParameter implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name="auction_id")
    private Auction auction;

    @Id
    @ManyToOne(optional = false)
    private Parameter parameter;

    @Column(name = "value")
    private String value;

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

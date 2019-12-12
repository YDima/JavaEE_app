package JavaApp.sales;

import javax.persistence.*;
import java.io.Serializable;






@Entity
@Table(name="auction_parameter")
public class AuctionParameterEntity implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name="auction_id")
    private AuctionEntity auction;

    @Id
    @ManyToOne(optional = false)
    private ParameterEntity parameter;

    @Column(name = "value")
    private String value;

    public AuctionEntity getAuction() {
        return auction;
    }

    public void setAuction(AuctionEntity auction) {
        this.auction = auction;
    }

    public ParameterEntity getParameter() {
        return parameter;
    }

    public void setParameter(ParameterEntity parameter) {
        this.parameter = parameter;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

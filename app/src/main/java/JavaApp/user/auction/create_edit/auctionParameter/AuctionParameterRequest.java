package JavaApp.user.auction.create_edit.auctionParameter;


import JavaApp.sales.jpa.AuctionParameter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@Named
@RequestScoped
public class AuctionParameterRequest {

    private Long auction_id;

    private Long parameter_id;

    private String value;

    public AuctionParameterRequest(AuctionParameter auctionParameter) {
        this.auction_id = auctionParameter.getAuction_id();
        this.parameter_id = auctionParameter.getParameter_id();
        this.value = auctionParameter.getValue();
    }

    public AuctionParameterRequest(Long auction_id, Long parameter_id, String value) {
        this.auction_id = auction_id;
        this.parameter_id = parameter_id;
        this.value = value;
    }

    public AuctionParameterRequest() {
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
}




















































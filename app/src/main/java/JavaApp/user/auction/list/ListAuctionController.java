package JavaApp.user.auction.list;


import JavaApp.sales.jpa.Auction;
import JavaApp.sales.jpa.AuctionParameter;
import JavaApp.sales.jpa.Photo;
import JavaApp.user.auction.create_edit.AuctionService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Named
@RequestScoped
public class ListAuctionController {

    @Inject
    AuctionService auctionService;
    @Inject
    HttpServletRequest request;

    public List<Auction> getAuctionListByUser() {
        var session = request.getSession(false);
        var username = session.getAttribute("username");
        return auctionService.findAuctionByUser( ( String ) username);
    }
    public List<Photo> getPhotoByAuctionId(Long auction_id) {
        return auctionService.getPhotoByAuctionId(auction_id);
    }

    public List<AuctionParameter> findByAuctionId(Long auction) {
        return auctionService.findByAuctionId(auction);
    }

    public List<Auction> getAuctionList() {
        return auctionService.findAll();
    }
}

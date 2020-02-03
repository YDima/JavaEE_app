package JavaApp.auction;



import JavaApp.sales.Auction;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Named
@RequestScoped
public class ListAuctionController {

    @Inject
    AuctionRepository auctionRepository;
    @Inject
    HttpServletRequest request;

    public List<Auction> getAuctionListByUser() {
        var session = request.getSession(false);
        var username = session.getAttribute("username");
        return auctionRepository.findAuctionByUser( ( String ) username);
    }

    public List<Auction> getAuctionList() {
        return auctionRepository.findAll();
    }
}

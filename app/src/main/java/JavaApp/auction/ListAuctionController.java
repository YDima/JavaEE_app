package JavaApp.auction;



import JavaApp.sales.Auction;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ListAuctionController {

    @Inject
    AuctionRepository auctionRepository;

    public List<Auction> getAuctionList() {
        return auctionRepository.findAll();
    }
}

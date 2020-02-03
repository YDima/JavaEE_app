package JavaApp.auction;


import JavaApp.Retriever;
import JavaApp.sales.Auction;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;



@Named
@RequestScoped
public class AuctionController {
    @Inject
    AuctionRequest auctionRequest;
    @Inject
    private HttpServletRequest request;
    @PersistenceContext
    private EntityManager em;
    @Inject
    private Retriever retriever;
    @Inject
    private AuctionRepository auctionRepository;


    public AuctionRequest getAuctionRequest() {
        if (auctionRequest == null) {
            auctionRequest = createAuctionRequest();
        }
        return auctionRequest;
    }

    public AuctionRequest createAuctionRequest(){
        if (retriever.contains("id")) {
            var id = retriever.getLong("id");
            var auction = auctionRepository.findAuctionById(id);
            return new AuctionRequest(auction);
        }
        return new AuctionRequest();
    }


    public String save() {
        var session = request.getSession(false);
        var username = session.getAttribute("username");
        var auction = new Auction(auctionRequest.getId(), auctionRequest.getCategory_id(), auctionRequest.getTitle(), auctionRequest.getPhoto(), auctionRequest.getDescription(), auctionRequest.getPrice(), ( String ) username);
        auctionRepository.save(auction);

        return "auctionParameters.xhtml?faces-redirect=true";
    }

}











































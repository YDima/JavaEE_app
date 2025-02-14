package JavaApp.user.auction.create_edit;


import JavaApp.Retriever;
import JavaApp.sales.jpa.Auction;

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
    private AuctionService auctionService;

    public AuctionRequest getAuctionRequest() {
        if (auctionRequest == null) {
            auctionRequest = createAuctionRequest();
        }
        return auctionRequest;
    }

    public AuctionRequest createAuctionRequest(){
        if (retriever.contains("id")) {
            var id = retriever.getLong("id");
            var auction = auctionService.findAuctionById(id);
            return new AuctionRequest(auction);
        }
        return new AuctionRequest();
    }



    public String save() {
        var session = request.getSession(false);
        var username = session.getAttribute("username");
        var auction = new Auction(auctionRequest.getId(), auctionRequest.getCategory_id(), auctionRequest.getTitle(), auctionRequest.getDescription(), auctionRequest.getPrice(), ( String ) username);
        auctionService.save(auction);

        return "createPhoto.xhtml?faces-redirect=true";
    }

    public String edit() {
        var session = request.getSession(false);
        var username = session.getAttribute("username");
        var auction = new Auction(auctionRequest.getId(), auctionRequest.getCategory_id(), auctionRequest.getTitle(), auctionRequest.getDescription(), auctionRequest.getPrice(), ( String ) username);
        auctionService.save(auction);

        return "editPhoto.xhtml?faces-redirect=true";
    }

}











































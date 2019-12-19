package JavaApp.auction;


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

    public String createAuction(){
        Auction auction = new Auction(auctionRequest.getCategory(), auctionRequest.getTitle(), auctionRequest.getDescription(), auctionRequest.getPrice(), auctionRequest.getPhotos(), auctionRequest.getParameters(), auctionRequest.getOwnerId());

        em.persist(auction);
        return "/profile.xhtml?faces-redirect=true";
    }

}

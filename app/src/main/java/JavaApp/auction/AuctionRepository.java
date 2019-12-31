package JavaApp.auction;











import JavaApp.sales.Auction;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class AuctionRepository {
    @PersistenceContext
    EntityManager em;

    public Auction findAuctionById(long auctionId) {
        var auction = em.find(Auction.class, auctionId);
        return auction;
    }

    @Transactional
    public void save(Auction auction) {
        if (auction.getId() == null)
            em.persist(auction);
        else
            em.merge(auction);
    }

    public List<Auction> findAll() { return em.createQuery("from Auction", Auction.class).getResultList(); }

}

package JavaApp.user.auction.create_edit;


import JavaApp.sales.jpa.Auction;

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
    public List<Auction> findAuctionByUser(String owner_username) {
        return em.createQuery("from Auction where owner_username=:owner_username order by id desc", Auction.class).setParameter("owner_username", owner_username).getResultList();
    }

    public List<Auction> findAll() { return em.createQuery("from Auction", Auction.class).getResultList(); }

}

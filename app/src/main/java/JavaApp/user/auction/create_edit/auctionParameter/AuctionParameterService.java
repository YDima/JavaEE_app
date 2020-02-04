package JavaApp.user.auction.create_edit.auctionParameter;


import JavaApp.sales.jpa.AuctionParameter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class AuctionParameterService {
    @PersistenceContext
    EntityManager em;
    @Inject
    AuctionParameterRepository auctionParameterRepository;

    public AuctionParameter findAuctionParameterById(long auctionParameterId) {
        var auctionParameter = em.find(AuctionParameter.class, auctionParameterId);
        return auctionParameter;
    }

    public List<AuctionParameter> findByAuctionId(Long auction) {
        return auctionParameterRepository.findByAuctionId(auction);
    }
    public List<AuctionParameter> findAll() { return em.createQuery("from AuctionParameter ", AuctionParameter.class).getResultList(); }

}

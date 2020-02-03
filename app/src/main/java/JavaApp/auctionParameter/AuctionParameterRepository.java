package JavaApp.auctionParameter;


import JavaApp.sales.AuctionParameter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class AuctionParameterRepository {
    @PersistenceContext
    EntityManager em;
    @Inject
    AuctionParameterRequest auctionParameterRequest;

    public AuctionParameter findAuctionParameterById(long auctionParameterId) {
        var auctionParameter = em.find(AuctionParameter.class, auctionParameterId);
        return auctionParameter;
    }

    @Transactional
    public void save(AuctionParameter auctionParameter) {
        if (auctionParameter.getValue() == null)
            em.persist(auctionParameter);
        else
            em.merge(auctionParameter);
    }

    public List<AuctionParameter> findByAuctionId() {

        return em.createQuery("from AuctionParameter where auction_id=:auction", AuctionParameter.class).setParameter("auction", auctionParameterRequest.getAuction_id()).getResultList();
    }

    public List<AuctionParameter> findAll() { return em.createQuery("from AuctionParameter ", AuctionParameter.class).getResultList(); }

}

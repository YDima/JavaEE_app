package JavaApp.user.auction.create_edit.auctionParameter;


import JavaApp.sales.jpa.AuctionParameter;

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

        return em.find(AuctionParameter.class, auctionParameterId);
    }

    @Transactional
    public void save(AuctionParameter auctionParameter) {
        var auctionParameters = find(auctionParameter.getAuction_id(), auctionParameter.getParameter_id(), auctionParameter.getValue());

        if (auctionParameter.getId()==null)
            em.persist(auctionParameter);
        else
            em.merge(auctionParameter);
    }

    public boolean find(Long auction, Long parameter, String value) {
        var list = em.createQuery("from AuctionParameter where auction_id=:auction and parameter_id =: parameter and value =: value", AuctionParameter.class)
                .setParameter("auction", auction)
                .setParameter("parameter", parameter)
                .setParameter("value", value).getResultList();

        if( !list.isEmpty() )
            return true;
        else
            return false;
    }

    public List<AuctionParameter> findByAuctionId(Long auction) {
        return em.createQuery("select ap from AuctionParameter ap join Parameter p on ap.parameter_id = p.id and  ap.auction_id =: auction", AuctionParameter.class)
                .setParameter("auction", auction).getResultList();
    }

    public List<AuctionParameter> findAll() { return em.createQuery("from AuctionParameter ", AuctionParameter.class).getResultList(); }

}

















































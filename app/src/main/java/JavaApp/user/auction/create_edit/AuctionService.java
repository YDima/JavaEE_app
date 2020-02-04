package JavaApp.user.auction.create_edit;


import JavaApp.sales.jpa.Auction;
import JavaApp.sales.jpa.AuctionParameter;
import JavaApp.sales.jpa.Photo;
import JavaApp.user.auction.create_edit.auctionParameter.AuctionParameterService;
import JavaApp.user.auction.create_edit.photo.PhotoService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class AuctionService {
    @PersistenceContext
    EntityManager em;
    @Inject
    AuctionRepository auctionRepository;
    @Inject
    PhotoService photoService;
    @Inject
    AuctionParameterService auctionParameterService;

    public Auction findAuctionById(long auctionId) {
        return auctionRepository.findAuctionById(auctionId);
    }

    public List<Photo> getPhotoByAuctionId(Long auction_id) {
        return photoService.getPhotoByAuctionId(auction_id);
    }

    public List<AuctionParameter> findByAuctionId(Long auction) {
        return auctionParameterService.findByAuctionId(auction);
    }

    @Transactional
    public void save(Auction auction) {
        auctionRepository.save(auction);
    }



    public List<Auction> findAuctionByUser(String owner_username) {
        return auctionRepository.findAuctionByUser(owner_username);
    }

    public List<Auction> findAll() { return auctionRepository.findAll(); }

}

package JavaApp.user.auction.create_edit;


import JavaApp.auth.User;
import JavaApp.sales.jpa.Auction;
import JavaApp.sales.jpa.Photo;
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

    public Auction findAuctionById(long auctionId) {
        return auctionRepository.findAuctionById(auctionId);
    }

    public List<Photo> getPhotoByAuctionId(Long auction_id) {
        return photoService.getPhotoByAuctionId(auction_id);
    }

    @Transactional
    public void save(Auction auction) {
        auctionRepository.save(auction);
    }

    public List<Auction> findAuctionByUser(String username) {
        User user = new User(username);
        var owner_username = user.getUsername();
        return auctionRepository.findAuctionByUser(owner_username);
    }

    public List<Auction> findAll() { return auctionRepository.findAll(); }

}

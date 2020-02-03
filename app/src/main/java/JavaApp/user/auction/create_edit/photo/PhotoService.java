package JavaApp.user.auction.create_edit.photo;


import JavaApp.sales.jpa.Photo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PhotoService {
    @PersistenceContext
    EntityManager em;
    @Inject
    PhotoRepository photoRepository;

    public List<Photo> getPhotoByAuctionId(Long auction_id) {
        return photoRepository.getPhotoByAuctionId(auction_id);
    }

    public Photo findPhotoById(Long photoId) {
        return photoRepository.findPhotoById(photoId);
    }

    @Transactional
    public void save(Photo photo) {
        photoRepository.save(photo);
    }

    public List<Photo> findAll() { return photoRepository.findAll(); }

}

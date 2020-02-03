package JavaApp.user.auction.create_edit.photo;


import JavaApp.sales.jpa.Photo;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PhotoRepository {
    @PersistenceContext
    EntityManager em;

    public List<Photo> getPhotoByAuctionId(Long auction_id) {
        return em.createQuery("from Photo where auction_id=:id", Photo.class).setParameter("id", auction_id).getResultList();
    }

    public Photo findPhotoById(Long photoId) {
        return em.find(Photo.class, photoId);
    }

    @Transactional
    public void save(Photo photo) {
        if (photo.getId() == null)
            em.persist(photo);
        else
            em.merge(photo);
    }

    public List<Photo> findAll() { return em.createQuery("from Photo", Photo.class).getResultList(); }

}

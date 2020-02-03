package JavaApp.photo;


import JavaApp.sales.Photo;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PhotoRepository {
    @PersistenceContext
    EntityManager em;

    public Photo findPhotoById(long photoId) {
        var photo = em.find(Photo.class, photoId);
        return photo;
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

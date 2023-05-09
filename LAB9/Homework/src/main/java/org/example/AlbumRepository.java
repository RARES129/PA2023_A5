package org.example;

import javax.persistence.EntityManager;
import java.util.List;

public class AlbumRepository extends AbstractRepository <Album, Integer>{
    private final String name = "Album";
    private EntityManager em = super.getEm();

    @Override
    public String getName() {
        return name;
    }

    public List<Album> findByArtist(String artist) {
        return em.createNamedQuery("Album.findByArtist")
                .setParameter("artist", artist)
                .getResultList();
    }

    public List<Album> findByGenre(String genre) {
        return em.createNamedQuery("Album.findByGenre")
                .setParameter("genre", genre)
                .getResultList();
    }
}
package org.example;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "artists")
@NamedQueries({
        @NamedQuery(name = "Artist.findAll",
                query = "select e from Artist e order by e.name"),
        @NamedQuery(name = "Artist.findByName",
                query = "SELECT e FROM Artist e WHERE e.name = :name")
})
public class Artist extends AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    private List<Album> albums;

    public Artist() {
    }

    public Artist(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Artist findById(Integer id){
        Artist returnVal;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamplePU");
        EntityManager em = emf.createEntityManager();
        try {
            returnVal = em.find(Artist.class, id);

            if (returnVal == null) {
                throw new EntityNotFoundException("Nu a fost gasit nici un artist care sa aibe id-ul : " + id);
            }
            return returnVal;
        } finally {
            em.close();
        }
    }

//    one to many -> un artist la mai multe albume
    public void oneToMany(String name){
        albums.clear();
        this.albums = new AlbumRepository().findByArtist(name);
    }

//    many to many -> mai multi artisti la mai multe albume
    public void manyToMany(List<Artist> artists){
        albums.clear();
        List<Album> albumsAux = null;
        var artistRepo = new AlbumRepository();

        for (var artist:artists) {
            albumsAux = artistRepo.findByArtist(artist.getName());

            albums.addAll(albumsAux);
            albumsAux.clear();
        }
    }

    public List<Album> getAlbums() {
        return albums;
    }
}
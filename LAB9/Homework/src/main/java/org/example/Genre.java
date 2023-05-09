package org.example;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "genres")
@NamedQueries({
        @NamedQuery(name = "Genre.findAll",
                query = "select e from Genre e order by e.name"),
        @NamedQuery(name = "Genre.findByName",
                query = "SELECT e FROM Genre e WHERE e.name = :name")
})
public class Genre extends AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    private List<Album> albums;

    public Genre() {
    }

    public Genre(String name) {
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
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Genre findById(Integer id){
        Genre returnVal;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamplePU");
        EntityManager em = emf.createEntityManager();
        try {
            returnVal = em.find(Genre.class, id);

            if (returnVal == null) {
                throw new EntityNotFoundException("Nu a fost gasit nici un gen care sa aibe id-ul : " + id);
            }
            return returnVal;
        } finally {
            em.close();
        }
    }

    public List<Album> getAlbums() {
        return albums;
    }

    //    one to many -> un gen la mai multe albume
    public void oneToMany(String name){
        albums.clear();
        this.albums = new AlbumRepository().findByGenre(name);
    }

    //    many to many -> mai multi gen la mai multe albume
    public void manyToMany(List<Genre> genres){
        albums.clear();
        List<Album> albumsAux = null;
        var artistRepo = new AlbumRepository();

        for (var genre:genres) {
            albumsAux = artistRepo.findByArtist(genre.getName());

            albums.addAll(albumsAux);
            albumsAux.clear();
        }
    }
}
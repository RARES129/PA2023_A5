package org.example;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "albumstable")
@NamedQueries({
        @NamedQuery(name = "Album.findAll",
                query = "select e from Album e order by e.name"),
        @NamedQuery(name = "Album.findByName",
                query = "SELECT e FROM Album e WHERE e.name = :name"),
        @NamedQuery(name = "Album.findByArtist",
                query = "SELECT e FROM Album e WHERE e.artist = :artist"),
        @NamedQuery(name = "Album.findByGenre",
                query = "SELECT e FROM Album e WHERE e.genre = :genre")
})

public class Album extends AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "releaseYear")
    private Integer releaseYear;

    @Column(name = "artist")
    private String artist;

    public Album(String name, Integer releaseYear, String artist, String genre) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.artist = artist;
        this.genre = genre;
    }

    @Column(name = "genre")
    private String genre;

    public Album() {
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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
        return "Album{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", releaseYear=" + releaseYear +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
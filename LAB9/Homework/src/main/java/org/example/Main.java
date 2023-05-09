package org.example;

import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamplePU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
//        Exemplu Default de pe slides
        Artist artist = new Artist("Despot");
//        System.out.println(artist.toString());
        em.persist(artist);

        Artist a = (Artist)em.createQuery(
                        "select e from Artist e where e.name='Despot'")
                .getSingleResult();
        a.setName("George");

//        Exemplu findById
        Artist artist2 = new ArtistRepository().findById(3380);
        System.out.println("Exemplu findById");
        System.out.println(artist2);

//        Exemplu findByName
        List<Artist> list = new ArrayList<>();
        var artistRepo = new ArtistRepository();
        list = artistRepo.findByName("George");
        System.out.println("Exemplu findByName:");
        System.out.println(list);

        insertArtists();
        insertAlbums();

        em.getTransaction().commit();
        em.close();
        emf.close();

        System.out.printf("Hello and welcome!");
    }

    private static void insertArtists() {
        long startTime = System.currentTimeMillis();
        int artists = 1000;

        Faker faker = new Faker();
        var artistRepo = new ArtistRepository();

        for (int i = 0; i < artists; i++){
            Artist artist = new Artist(faker.name().firstName());
            artistRepo.create(artist);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Am inserat " + artists + " artisti in: " + (endTime - startTime) + "ms");
    }

    private static void insertAlbums() {
        long startTime = System.currentTimeMillis();
        int albums = 1000;

        Faker faker = new Faker();
        var albumRepo = new AlbumRepository();

        for (int i = 0; i < albums; i++){
            Album album = new Album(faker.name().firstName(), faker.number().numberBetween(1900, 2023), faker.name().firstName(), faker.music().genre());
            albumRepo.create(album);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Am inserat " + albums + " albume in: " + (endTime - startTime) + "ms");
    }
}
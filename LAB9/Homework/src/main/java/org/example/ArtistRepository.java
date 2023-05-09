package org.example;

public class ArtistRepository extends AbstractRepository <Artist, Integer>{
    private final String name = "Artist";

    @Override
    public String getName() {
        return name;
    }
}
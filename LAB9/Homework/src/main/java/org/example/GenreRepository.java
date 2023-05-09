package org.example;

public class GenreRepository extends AbstractRepository <Genre, Integer>{
    private final String name = "Genre";

    @Override
    public String getName() {
        return name;
    }
}
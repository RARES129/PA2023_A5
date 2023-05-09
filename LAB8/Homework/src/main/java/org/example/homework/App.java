package org.example.homework;


import org.example.homework.AlbumDAO;
import org.example.homework.ArtistDAO;
import org.example.homework.Database;
import org.example.homework.GenreDAO;

import java.io.IOException;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        try {


            ImportTool.collectData("C:\\Users\\dasca\\Desktop\\GREEN_GUM\\JAVA\\PA2023_A5\\LAB8\\Homework\\src\\main\\java\\org\\example\\albumList.csv");
            ImportTool.importDataCollected();
            Database.getDataSource().getConnection().close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
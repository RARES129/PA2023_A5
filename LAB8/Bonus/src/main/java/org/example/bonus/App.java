package org.example.bonus;


import org.example.bonus.AlbumDAO;
import org.example.bonus.ArtistDAO;
import org.example.bonus.Database;
import org.example.bonus.GenreDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

public class App {
    public static void main(String[] args) throws SQLException {
        try {

            ImportTool.collectData("C:\\Users\\User\\IdeaProjects\\Lab8\\src\\main\\java\\org\\example\\albumList.csv");
            ImportTool.importDataCollected();

            Playlists p=new Playlists();
            p.generateUnrelatedPlaylists();




            Database.getDataSource().getConnection().close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
package org.example.bonus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GenreDAO implements DAOModifiersAndObtainersInterface {
    private static Connection con;
    private Boolean ok1 = false;

    public GenreDAO() {


    }

    public void create(ForHandleAndReturnObj args) throws SQLException {
        String name = args.getContains().get(0);
        if (ok1 == false) {
            con = Database.getDataSource().getConnection();
            ok1 = true;
        }
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into genres (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }

    public ForHandleAndReturnObj findByName(ForHandleAndReturnObj name) throws SQLException {
        String nameForQuery = name.getContains().get(0);

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from genres where name='" + nameForQuery + "'")) {
            return new ForHandleAndReturnObj(rs.next() ? rs.getInt(1) : null);
        }
    }

    public ForHandleAndReturnObj findById(ForHandleAndReturnObj id) throws SQLException {
        String idForQuery = id.getContains().get(0);

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from genres where id='" + idForQuery + "'")) {
            return new ForHandleAndReturnObj(rs.next() ? rs.getString(1) : null);
        }
    }


}

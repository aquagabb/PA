package com.company;


import java.sql.*;

public class AlbumController {

    private static final String SQL_INSERT = "INSERT INTO ALBUMS (NAME, ARTIST_ID,RELEASE_YEAR) VALUES (?,?,?)";


    public void create(String name,int artistId,int year) throws SQLException {
        Connection connect = Database.getConnection();
        PreparedStatement preparedStatement = connect.prepareStatement(SQL_INSERT);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, artistId);
        preparedStatement.setInt(3, year);
        preparedStatement.executeUpdate();

    }
    public void findByArtist(int artistId) throws SQLException {

        Connection connect = Database.getConnection();
        Statement statement = connect.createStatement();
        ResultSet resultSet = statement.executeQuery("select name from albums where id=" + artistId);
        System.out.println(resultSet.next() ? String.valueOf(resultSet.getString(1)) : null);


    }

}

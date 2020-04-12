package com.company;


import javax.xml.crypto.Data;
import java.sql.*;

public class ArtistController {

    private static final String SQL_INSERT = "INSERT INTO ARTISTS (NAME, COUNTRY) VALUES (?,?)";


    public void create(String name,String country) throws SQLException {
            Connection connect = Database.getConnection();
            PreparedStatement preparedStatement = connect.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, country);
            preparedStatement.executeUpdate();



        }

        public void findByName(String name) throws SQLException {

            Connection connect = Database.getConnection();
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("select name from artists where name='"+name+"'");
            System.out.println(resultSet.next() ? String.valueOf(resultSet.getString(1)) : null);


        }
}

package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Connection connect = null;


    private Database() {

    }

    public static Connection getConnection() {

        if (connect == null)
            createConnection();

        return connect;
    }

   private static Connection createConnection() {

       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/MusicAlbums", "dba", "sql");
           System.out.println("Connected Succesfully");
       }catch (SQLException | ClassNotFoundException ex){
           ex.printStackTrace();
       }

        return connect;


}

    public static void closeConnection(){

    if(connect !=null)
        try{
            connect.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

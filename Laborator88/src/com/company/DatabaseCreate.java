package com.company;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCreate {


    public void createTables(){

        Connection connect=null;
        Statement statement=null;

        try{
            connect=Database.getConnection();
            statement=connect.createStatement();

            statement.execute("create table artists (\n"+
                    "id integer not null auto_increment,\n"+
                    "name varchar(100),\n"+
                    "country varchar(100),\n"+
                    "primary key (id)\n"+
            ");");
            statement.execute("create table albums (\n"+
                    "id integer not null auto_increment,\n"+
                    "name varchar(100),\n"+
                    "artist_id integer not null references artists on delete restrict,\n"+
                    "release_year integer,\n"+
                     "primary key(id)\n"+
                    ");");

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if(statement !=null)
                try {
                    statement.close();
                }catch (SQLException e){
                    e.printStackTrace();

            }
        }
    }
}

package com.company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        //numele 88 e ca am inceput in Laborator8 si tot nu a iesit si am facut altul
        //am gasit multe chestii pe net,cele cu sql,am inteles care e ideea cu ele,am avut mici probleme la conectarea cu jar
        //DatabaseCreate creeaza tabelele album si artists
        //Databse stabileste conexiunea,am aflat ca singleton inseamna sa existe doar o instanta a clasei,sper sa fie bine cum am facut
        //ArtistController pot sa folosesc create si findByName()
        //Album Controller pot sa folosesc create si finyById()


         DatabaseCreate database=new DatabaseCreate();


         database.createTables();
         ArtistController artist=new ArtistController();
         AlbumController album=new AlbumController();

         artist.create("Alan Walker","Norvegia");
         artist.create("Selena Gomez","USA");

         album.create("Hello 2020",1,2020);
         album.create("Summer Hits",2,2019);
         artist.findByName("Alan Walker");
         album.findByArtist(1);
    }


}
package com.company;

import java.util.List;


public class Main {

    public static void main(String[] args) {


        Game game1= new Game();
        Board board1 = new Board();

        Player player1=new Player("Gabi");
        Player player2=new Player("Cristi");
        Player player3=new Player("Dumi");

        game1.addPlayer(player1);
        game1.addPlayer(player2);
        game1.addPlayer(player3);

        player1.setGame(game1);
        player2.setGame(game1);
        player3.setGame(game1);

        Token token1=new Token(1);
        Token token2=new Token(2);
        Token token3=new Token(3);
        Token token4=new Token(4);
        Token token5=new Token(5);
        Token token6=new Token(6);

        board1.addToken(token1);
        board1.addToken(token2);
        board1.addToken(token3);
        board1.addToken(token4);
        board1.addToken(token5);
        board1.addToken(token6);

        game1.setBoard(board1);

        game1.start();




    }
}

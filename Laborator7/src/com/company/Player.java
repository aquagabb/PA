package com.company;

import java.util.ArrayList;
import java.util.List;

public class Player implements Runnable {

    private Game game;
    private String name;
    private List<Token> tokenList;


    public Player() {
        this.name = "";
        this.tokenList = new ArrayList<>();
    }

    public Player(String name) {
        this.name = name;
        this.tokenList = new ArrayList<>();
    }

    public void addToken(Token token) {
        this.tokenList.add(token);
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public void selectToken(int val) {
        Token token;
        Board board = game.getBoard();
        token = board.selectToken(val);
        this.tokenList.add(token);
    }

    public synchronized boolean play() throws InterruptedException {
        Board board = game.getBoard();

        if (board.emptyBoard()) {
            return false;
        } else {
            selectToken(board.getTokenList().size() - 1);
        }
        return true;
    }

    @Override
    public void run() {
        try {
            while (play()) {
                System.out.println("Token ales de  " + this.getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Game OVER !");
    }
}


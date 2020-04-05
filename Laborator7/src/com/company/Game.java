package com.company;


import java.util.ArrayList;
import java.util.List;

public class Game {

    private Board board;
    private List<Player> playerList;

    public Game() {
        this.board=new Board();
        this.playerList=new ArrayList<Player>();
    }

    public Game(Board board) {
        this.board = board;
        this.playerList=new ArrayList<Player>();

    }
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void addPlayer(Player player){

        this.playerList.add(player);
    }

    public void start()
    {

        Thread[] thredArray=new Thread[playerList.size()];

        for (int j=0;j<playerList.size();j++)
        {
            thredArray[j]=new Thread((playerList.get(j)));
            thredArray[j].start();
        }
        for(Thread thread: thredArray)
        {
            try {
                thread.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
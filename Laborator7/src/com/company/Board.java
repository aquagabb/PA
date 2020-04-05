package com.company;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Board {
    private List<Token> tokenList;

    public Board() {
        this.tokenList = new ArrayList<Token>();
    }

    public void addToken(Token token) {
        this.tokenList.add(token);
    }

    public List<Token> getTokenList() {
        return this.tokenList;
    }

    public boolean emptyBoard() {
        if (getTokenList().isEmpty()) {
            return true;
        }
        return false;
    }

    public synchronized Token selectToken(int val) {
        if (!this.emptyBoard() && val < getTokenList().size()) {
            Token token = getTokenList().get(val);
            getTokenList().remove(getTokenList().get(val));
            try {
                sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return token;
        }
        return null;
    }


}


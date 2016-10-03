package com.company;

import javax.lang.model.element.Element;
import java.util.ArrayList;

/**
 * Created by jc320588 on 1/10/16.
 */
public class SuperTrumpTable {

    private ArrayList<SuperTrumpCard> table;
    private String trump;

    protected SuperTrumpTable() {
        table = new ArrayList<>();
    }

    public void addCard(SuperTrumpCard tableCard) {
        table.add(tableCard);
    }

    public void setTrump(String trump) {
        this.trump = trump;
    }

    public String getTrump() {
        return trump;
    }


    public ArrayList<SuperTrumpCard> getTableCards() {
        return table;
    }

    public SuperTrumpCard cardInPlay() {
        switch (table.size()) {
            case 0: {
                return null;
            }
            default: {
                return table.get(table.size() - 1);
            }
        }
    }
}

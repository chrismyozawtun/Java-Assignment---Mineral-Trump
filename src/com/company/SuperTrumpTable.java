package com.company;

import javax.lang.model.element.Element;
import java.util.ArrayList;

/**
 * Created by jc320588 on 1/10/16.
 */
public class SuperTrumpTable {

    private ArrayList<SuperTrumpCard> table;

    protected SuperTrumpTable(){
        table = new ArrayList<>();
    }

    public void addCard(SuperTrumpCard tableCard) {
        table.add(tableCard);
//        System.out.println("table cards: " + table);

//        return null;
    }

    public ArrayList<SuperTrumpCard> getTableCards(){
        return table;
    }

    public SuperTrumpCard cardInPlay() {
//        Element cardToShow = table.size() - 1;
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

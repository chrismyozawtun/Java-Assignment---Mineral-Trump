package com.company;

import java.util.ArrayList;
import java.util.StringJoiner;

/**
 * Created by jc320588 on 20/09/16.
 */
public class SuperTrumpCard {

    private int id;


    public SuperTrumpCard(int id){
        this.id = id;
    }

    public int getID(){
        return id;
    }
//, String fileName, String imageName, String cartType, String tittle, String chemistry, String classification, String cyrstalSystem, ArrayList occurence, int hardness, int specificGravity, String Cleavage, String crustalAbundance, String economicValue

    public String toString(){
        return "id = " + id;

    }
}

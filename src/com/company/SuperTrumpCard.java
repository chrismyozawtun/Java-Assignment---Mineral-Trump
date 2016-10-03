package com.company;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.StringJoiner;

/**
 * Created by jc320588 on 20/09/16.
 */
public class SuperTrumpCard {
    private int id;
private String fileName;
private String imageName;
private String card_type;
private String tittle;
private String chemistry;
private String classification;
private String crystal_system;
private String occurence;
private int hardness;
private Double specifc_gravity;
private String cleavage;
private String crustal_abundance;
private String economic_value;


    public SuperTrumpCard(int id, String fileName, String imageName,String card_type, String tittle, String chemistry, String classification, String crystal_system,int hardness, Double specifc_gravity, String cleavage, String crustal_abundance, String economic_value, String occurence)
    {
        this.id = id;
        this.fileName = fileName;
        this.imageName = imageName;
        this.card_type = card_type;
        this.tittle = tittle;
        this.chemistry = chemistry;
        this.classification =classification;
        this.crystal_system =crystal_system;
        this.hardness =hardness;
        this.specifc_gravity = specifc_gravity;
        this.cleavage = cleavage;
        this.crustal_abundance = crustal_abundance;
        this.economic_value = economic_value;
        this.occurence = occurence;
    }



    public int getID(){
        return id;
    }

    public String toString(){
        return "id = " + id;

    }

}

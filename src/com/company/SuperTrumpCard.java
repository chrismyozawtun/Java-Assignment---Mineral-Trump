package com.company;

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
private String hardness;
private String specifc_gravity;
private String cleavage;
private String crustal_abundance;
private String economic_value;
    private String subtitle;


    public SuperTrumpCard(int id, String fileName, String imageName,String card_type, String tittle, String chemistry, String classification, String crystal_system,String hardness, String specifc_gravity, String cleavage, String crustal_abundance, String economic_value, String occurence, String subtitle)
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
        this.subtitle = subtitle;

    }



    public int getID(){
        return id;
    }
    public String getFileName(){
        return fileName;
        }
    public String getImageName(){
            return imageName;
            }
    public String getCard_type(){
            return card_type;
            }
    public String gettittle(){
            return tittle;
            }
    public String getChemistry(){
            return chemistry;
            }
    public String getClassification(){
            return classification;
            }
    public String getCrystal_system(){
            return crystal_system;
            }
    public String getOccurence(){
            return occurence;
            }
    public String getHardness(){
            return hardness;
            }
    public String getSpecifc_gravity(){
            return specifc_gravity;
            }
    public String getCleavage(){
            return cleavage;
            }
    public String getCrustal_abundance(){
            return crustal_abundance;
            }
    public String getEconomic_value(){
        return economic_value;
        }


    public String toString(){
        return getCard_type() + " = " + gettittle();

    }

//    public String toString(){
//        return ;
//    }

}

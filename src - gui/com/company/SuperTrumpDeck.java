package com.company;

import jdk.nashorn.internal.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by jc320588 on 20/09/16.
 */
public class SuperTrumpDeck {
    private static final int INITIAL_NUM_CARDS = 60;
    private ArrayList<SuperTrumpCard> cards;

    public SuperTrumpDeck(){
        cards = new ArrayList<>();
        cards.add(new SuperTrumpCard(1, "images/Slide01.jpg","Slide01","play","Quartz",        "SiO_2",                                     "tectosilicate",    "hexagonal",    "7",          "2.65",       "poor/none",            "high",         "moderate", "igneous, metamorphic, sedimentary", null));
        cards.add(new SuperTrumpCard(2, "images/Slide02.jpg","Slide02","play","Plagioclase",   "Na Al Si_3 O_8 - Ca Al_2 Si_2 O_8",         "tectosilicate",    "triclinic",    "6-6.5",      "2.6-2.8",    "1 perfect, 1 good",    "very high",    "moderate", "igneous, metamorphic, sedimentary", null));
        cards.add(new SuperTrumpCard(3, "images/Slide03.jpg","Slide03","play","Orthoclase",    "K Al Si_3 O_3",                             "tectosilicate",    "monoclinic",   "6-6.5",      "2.5-2.6",    "1 perfect, 1 good",    "high",         "moderate", "igneous, metamorphic, sedimentary", null));
        cards.add(new SuperTrumpCard(4, "images/Slide04.jpg","Slide04","play","Biotite",       "K(Fe, Mg)_3 Al Si_3 O_10 (OH)_2",           "phyllosilicate",   "monoclinic",   "2.5-3",      "2.7-3.3",    "1 perfect",            "moderate",     "low",      "igneous, metamorphic", null));
        cards.add(new SuperTrumpCard(5, "images/Slide05.jpg","Slide05","play","Muscovite",     "K Al_3 Si_3 O_10 (O H)_2",                  "phyllosilicate",   "monoclinic",   "2.5-3",      "2.8-2.9",    "1 perfect",            "moderate",     "moderate", "igneous, metamorphic", null));
        cards.add(new SuperTrumpCard(6, "images/Slide06.jpg","Slide06","play","Hornblende",    "Ca_2 (Mg, Fe)_4 Al_2 Si_7 O_22 (OH)_2",     "inosilicate",      "monoclinic",   "5-6",        "3.0-3.5",    "2 good",               "moderate",     "trivial",  "igneous, metamorphic", null));
        cards.add(new SuperTrumpCard(7, "images/Slide07.jpg","Slide07","play","Actinolite",    "Ca_2 (Mg, Fe)_5 Si_8 O_22 (OH)_2",          "inosilicate",      "monoclinic",   "5-6",        "3.0-3.5",    "2 good",               "low",          "low",      "metamorphic", null));
        cards.add(new SuperTrumpCard(8, "images/Slide08.jpg","Slide08","play","Glaucophane",   "Na_2 (Mg, Fe)_3 Al_2 Si_8 O_22 (OH)_2",     "inosilicate",      "monoclinic",   "6",          "3.0-3.2",    "2 good",               "low",          "trivial",  "metamorphic", null));
        cards.add(new SuperTrumpCard(9, "images/Slide09.jpg","Slide09","play","Olivine",       "(Mg, Fe)_2 Si O_4",                         "nesosilicate",     "orthorhombic", "6.5-7",      "3.2-4.4",    "2 poor",               "high",         "low",      "igneous, metamorphic, mantle", null));
        cards.add(new SuperTrumpCard(10,"images/Slide10.jpg","Slide10","play","Garnet",        "(Fe, Mg, Ca, Mn)_3 (Al, Fe)_2 Si_3 O_12",   "nesosilicate",    "isometric",    "6-7.5",      "3.5-4.3",    "none",                 "moderate",     "moderate",  "igneous, metamorphic, mantle", null));
        cards.add(new SuperTrumpCard(11,"images/Slide11.jpg","Slide11","play","Titanite",      "Ca Ti Si O_5",                              "nesosilicate",    "monoclinic",   "5-5.5",      "3.4-3.6",    "3 good",               "low",          "low",       "igneous, metamorphic", null));
        cards.add(new SuperTrumpCard(12,"images/Slide12.jpg","Slide12","play","Zircon",        "Zr Si O_4",                                 "nesosilicate",    "tetragonal",   "7.5",        "4.6-4.7",    "2 poor",               "trace",        "moderate",  "igneous, metamorphic, sedimentary", null));
        cards.add(new SuperTrumpCard(13,"images/Slide13.jpg","Slide13","play","Augite",        "Ca (Mg, Fe) Si_2 O_6",                      "inosilicate",     "monoclinic",   "5.5-6.5",    "3.2-3.6",    "2 good",               "high",         "trivial",   "igneous, metamorphic", null));
        cards.add(new SuperTrumpCard(14,"images/Slide14.jpg","Slide14","play","Orthopyroxene", "(Mg, Fe)_2 Si_2 O_6",                       "inosilicate",     "orthorhombic", "5-6",        "3.2-3.9",    "2 good",               "high",         "trivial",   "igneous, metamorphic, mantle", null));
        cards.add(new SuperTrumpCard(15,"images/Slide15.jpg","Slide15","play","Chlorite",      "(Mg, Fe)_5 Al_2 Si_3 O_10 (OH)_8",          "phyllosilicate",  "monoclinic",   "2-3",        "2.6-3.3",    "1 perfect",            "moderate",     "low",       "metamorphic", null));
        cards.add(new SuperTrumpCard(16,"images/Slide16.jpg","Slide16","play","Antigorite",    "(Mg, Fe)_3 Si_2 O_5 (OH)_4",                "phyllosilicate",  "monoclinic",   "3.5-4",      "2.6",        "1 perfect",            "low",          "low",       "metamorphic, mantle", null));
        cards.add(new SuperTrumpCard(17,"images/Slide17.jpg","Slide17","play","Talc",          "Mg_3 Si_4 O_10 (OH)_2",                     "phyllosilicate",  "monoclinic",   "1",          "2.6-2.8",    "1 perfect",            "low",          "moderate",  "metamorphic", null));
        cards.add(new SuperTrumpCard(18,"images/Slide18.jpg","Slide18","play","Kaolinite",     "Al_2 Si_2 O_5 (OH)_4",                      "phyllosilicate",  "triclinic",    "1.5-2.5",    "2.6-2.7",    "1 perfect",            "moderate",     "high",      "sedimentary", null));
        cards.add(new SuperTrumpCard(19,"images/Slide19.jpg","Slide19","play","Andalusite",    "Al_2 Si O_5",                               "nesosilicate",    "orthorhombic", "6.5-7",      "3.15",       "2 good",               "low",          "moderate",  "metamorphic", null));
        cards.add(new SuperTrumpCard(20,"images/Slide20.jpg","Slide20","play","Kyanite",       "Al_2 Si O_5",                               "nesosilicate",    "triclinic",    "5.5-7",      "3.5-3.7",    "1 perfect, 1 good",    "trace",        "moderate",  "metamorphic", null));
        cards.add(new SuperTrumpCard(21,"images/Slide21.jpg","Slide21","play","Sillimanite",   "Al_2 Si O_5",                               "nesosilicate",    "orthorhombic", "6.5-7.5",    "3.25",       "1 perfect, 1 good",    "low",          "low",       "igneous, metamorphic", null));
        cards.add(new SuperTrumpCard(22,"images/Slide22.jpg","Slide22","play","Staurolite",    "(Fe, Mg)_2 Al_9 Si_4 O_22 (OH)_2'",         "nesosilicate",    "monoclinic",   "7",          "3.7-3.8",    "1 good",               "trace",        "low",       "metamorphic", null));
        cards.add(new SuperTrumpCard(23,"images/Slide23.jpg","Slide23","play","Epidote",       "Ca_2 (Al, Fe)_3 Si_3 O_12 (OH)",            "sorosilicate",    "monoclinic",   "6-6.5",      "3.2 - 3.5",  "1 perfect",            "moderate",     "trivial",   "igneous, metamorphic", null));
        cards.add(new SuperTrumpCard(24,"images/Slide24.jpg","Slide24","play","Tourmaline",    "Na (Mg, Fe)_3 Al_6 B_3 Si_6 O_27 (OH)_4",   "cyclosilicate",   "hexagonal",    "7-7.5",      "3.0 - 3.2",  "2 poor",               "trace",        "moderate",  "metamorphic", null));
        cards.add(new SuperTrumpCard(25,"images/Slide25.jpg","Slide25","play","Topaz",         "Al_2 Si O_4 (F, OH)_2",                     "nesosilicate",    "orthorhombic", "8",          "3.5 - 3.6",  "1 perfect",            "ultratrace",   "low",       "metamorphic, sedimentary", null));
        cards.add(new SuperTrumpCard(26,"images/Slide26.jpg","Slide26","play","Beryl",         "Be_3 Al_2 Si_6 O_18",                       "cyclosilicate",   "hexagonal",    "7.5-8",      "2.6 - 2.9",  "1 poor",               "trace",        "moderate",  "igneous, metamorphic", null));
        cards.add(new SuperTrumpCard(27,"images/Slide27.jpg","Slide27","play","Pyrite",        "Fe S_2",                                    "sulfide",         "isometric",    "6-6.5",      "5.0",        "2 poor",               "low",          "moderate",  "igneous, metamorphic", null));
        cards.add(new SuperTrumpCard(28,"images/Slide28.jpg","Slide28","play","Pyrrhotite",    "Fe_{1-x} S",                                "sulfide",         "monoclinic",   "3.5-4.5",    "4.6",        "none",                 "low",          "moderate",  "igneous, metamorphic", null));
        cards.add(new SuperTrumpCard(29,"images/Slide29.jpg","Slide29","play","Chalcopyrite",  "Cu Fe S_2",                                 "sulfide",         "tetragonal",   "3.5-4",      "4.1 - 4.3",  "2 poor",               "low",          "very high", "igneous, metamorphic", null));
        cards.add(new SuperTrumpCard(30,"images/Slide30.jpg","Slide30","play","Galena",        "Pb S",                                      "sulfide",         "isometric",    "2.5",        "7.5 - 7.6",  "3 perfect",            "trace",         "high",     "metamorphic", null));
        cards.add(new SuperTrumpCard(31,"images/Slide31.jpg","Slide31","play","Sphalerite",    "(Zn, Fe) S",                                "sulfide",         "isometric",    "3.5-4",      "3.9 - 4.1",  "6 perfect",            "trace",         "high",     "metamorphic", null));
        cards.add(new SuperTrumpCard(32,"images/Slide32.jpg","Slide32","play","Molybdenite",   "Mo S_2",                                    "sulfide",         "hexagonal",    "1-1.5",      "4.7",        "1 perfect",            "trace",         "high",     "igneous, metamorphic", null));
        cards.add(new SuperTrumpCard(33,"images/Slide33.jpg","Slide33","play","Gold",          "Au",                                        "native element ", "isometric",    "2.5-3",      "19.3",       "none",                 "ultratrace",    "I'm rich!","metamorphic, sedimentary", null));
        cards.add(new SuperTrumpCard(34,"images/Slide34.jpg","Slide34","play","Diamond",        "C",                                        "native element ", "isometric",    "10",         "3.5",        "4 perfect",            "ultratrace",    "I'm rich!","igneous, metamorphic, sedimentary", null));
        cards.add(new SuperTrumpCard(35,"images/Slide35.jpg","Slide35","play","Graphite",       "C",                                        "native element ", "hexagonal",    "1-2",        "2.2",        "1 perfect",            "trace",         "moderate", "metamorphic, sedimentary", null));
        cards.add(new SuperTrumpCard(36,"images/Slide36.jpg","Slide36","play","Halite",         "Na Cl",                                    "halide",          "isometric",    "2.5",        "2.2",        "3 perfect",            "trace",         "moderate", "sedimentary", null));
        cards.add(new SuperTrumpCard(37,"images/Slide37.jpg","Slide37","play","Fluorite",       "Ca F_2",                                   "halide",          "isometric",    "4",          "3.2",        "4 perfect",            "trace",         "moderate", "metamorphic", null));
        cards.add(new SuperTrumpCard(38,"images/Slide38.jpg","Slide38","play","Gypsum",         "Ca S O_4 (H_2 O)_2",                       "sulfate",         "monoclinic",   "2",          "2.3",        "1 perfect, 2 good",    "trace",         "high",     "metamorphic, sedimentary", null));
        cards.add(new SuperTrumpCard(39,"images/Slide39.jpg","Slide39","play","Barite",         "Ba S O_4",                                 "sulfate",         "orthorhombic", "3-3.5",      "4.5",        "2 perfect, 1 good",    "trace",         "moderate", "metamorphic, sedimentary", null));
        cards.add(new SuperTrumpCard(40,"images/Slide40.jpg","Slide40","play","Apatite",        "Ca_5 (P O_4)_3 (OH, F, Cl)",               "phosphate",       "hexagonal",    "5",          "3.1 - 3.2",  "2 poor",               "low",           "high",     "igneous, metamorphic, sedimentary", null));
        cards.add(new SuperTrumpCard(41,"images/Slide41.jpg","Slide41","play","Monazite",       "(La, Ce, Nd) P O_4",                       "phosphate",       "monoclinic",   "5",          "5.0 - 5.3",  "1 good, 1 poor",       "trace",         "moderate", "igneous, metamorphic, sedimentary", null));
        cards.add(new SuperTrumpCard(42,"images/Slide42.jpg","Slide42","play","Calcite",        "Ca C O_3",                                 "carbonate",       "hexagonal",    "3",          "2.7",        "3 perfect",            "moderate",      "high",     "igneous, metamorphic, sedimentary", null));
        cards.add(new SuperTrumpCard(43,"images/Slide43.jpg","Slide43","play","Dolomite",       "Ca Mg (C O_3)_2",                          "carbonate",       "hexagonal",    "3.5-4",      "2.9",        "3 perfect",            "low",           "low",      "metamorphic, sedimentary", null));
        cards.add(new SuperTrumpCard(44,"images/Slide44.jpg","Slide44","play","Magnesite",      "Mg C O_3",                                 "carbonate",       "hexagonal",    "4",          "3.0",        "3 perfect",            "low",           "moderate", "metamorphic, sedimentary", null));
        cards.add(new SuperTrumpCard(45,"images/Slide45.jpg","Slide45","play","Siderite",       "Fe C O_3",                                 "carbonate",       "hexagonal",    "4-4.5",      "4.0",        "3 perfect",            "trace",         "moderate", "metamorphic, sedimentary", null));
        cards.add(new SuperTrumpCard(46,"images/Slide46.jpg","Slide46","play","Magnetite",      "Fe_3 O_4",                                 "oxide (spinel)",  "isometric",    "5.5-6",      "5.2",        "none",                 "moderate",      "very high","igneous, metamorphic, sedimentary", null));
        cards.add(new SuperTrumpCard(47,"images/Slide47.jpg","Slide47","play","Hematite",       "Fe_2 O_3",                                 "oxide",           "hexagonal",    "5-6",        "5.3",        "none",                 "trace",         "high",     "metamorphic, sedimentary", null));
        cards.add(new SuperTrumpCard(48,"images/Slide48.jpg","Slide48","play","Chromite",       "(Fe, Mg) Cr_2 O_4",                        "oxide (spinel)",  "isometric",    "5.5",        "4.5 - 5.1",  "none",                 "low",           "high",     "igneous, sedimentary", null));
        cards.add(new SuperTrumpCard(49,"images/Slide49.jpg","Slide49","play","Ilmenite",       "Ti Fe O_3",                                "oxide",           "hexagonal",    "5-6",        "4.7 - 4.8",  "none",                 "low",           "moderate", "igneous, metamorphic, sedimentary", null));
        cards.add(new SuperTrumpCard(50,"images/Slide50.jpg","Slide50","play","Rutile",         "Ti O_2",                                   "oxide",           "tetragonal",   "6-6.5",      "4.3",        "2 good",               "low",           "high",     "metamorphic, sedimentary", null));
        cards.add(new SuperTrumpCard(51,"images/Slide51.jpg","Slide51","play","Corundum",       "Al_2 O_3",                                 "oxide",           "hexagonal",    "9",          "4.0",        "none",                 "trace",         "moderate", "metamorphic, sedimentary", null));
        cards.add(new SuperTrumpCard(52,"images/Slide52.jpg","Slide52","play","Cassiterite",    "Sn O_2",                                   "oxide",           "tetragonal",   "6-7",        "6.9 - 7.1",  "1 good, 1 poor",       "trace",         "high",     "igneous, metamorphic, sedimentary", null));
        cards.add(new SuperTrumpCard(53,"images/Slide53.jpg","Slide53","play","Gibbsite",       "Al (O H)_3",                               "hydroxide",       "monoclinic",   "2.5-3.5",    "2.4",        "1 perfect",            "low",           "high",     "metamorphic, sedimentary",null));
        cards.add(new SuperTrumpCard(54,"images/Slide54.jpg","Slide54","play","Goethite",       "Fe O (OH)",                                "hydroxide",       "orthorhombic", "5-5.5",      "4.3",        "1 perfect, 1 good",    "moderate",      "moderate", "sedimentary", null));
        cards.add(new SuperTrumpCard(55,"images/Slide55.jpg","Slide55","trump", "The Miner", null,null, null, null, null, null, null , null , null, "Economic Value"));
        cards.add(new SuperTrumpCard(56,"images/Slide56.jpg","Slide56","trump", "The Petrologist", null,null, null, null, null, null, null , null , null, "Crustal Abundance"));
        cards.add(new SuperTrumpCard(57,"images/Slide57.jpg","Slide57","trump", "The Gemmologist", null,null, null, null, null, null, null , null , null, "Hardness"));
        cards.add(new SuperTrumpCard(58,"images/Slide58.jpg","Slide58","trump", "The Mineralogist", null,null, null, null, null, null, null , null , null, "Cleavage"));
        cards.add(new SuperTrumpCard(59,"images/Slide59.jpg","Slide59","trump", "The Geophysicist", null,null, null, null, null, null, null , null , null, "Specific Gravity"));
        cards.add(new SuperTrumpCard(60,"images/Slide60.jpg","Slide60","trump", "The Geologist", null,null, null, null, null, null, null , null , null,"Change to trumps category of your choice"));
    }

    public ArrayList getCards(){
        return cards;
    }

    public SuperTrumpCard getOneCard(){
        int indx = new Random().nextInt(cards.size());
        return(cards.remove(indx));
    }

    public ArrayList<SuperTrumpCard> dealCards(int numCards) {
        ArrayList<SuperTrumpCard> retn = new ArrayList<SuperTrumpCard>();
        for (int i = 0; i < numCards; i++){
            int indx = new Random().nextInt(cards.size());
            SuperTrumpCard card = cards.remove(indx);
            retn.add(card);
        }
        return retn;
    }

    public void shuffleInTableCards(ArrayList<SuperTrumpCard> tableCards) {
        for (int i = 0; i < tableCards.size(); i++) {
            cards.add(tableCards.get(i));
        }
    }
}



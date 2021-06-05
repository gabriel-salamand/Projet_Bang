package fr.umontpellier.iut.bang.cards;

public class Volcanic extends WeaponCard {
    public Volcanic(int value, CardSuit suit) {
        super("Volcanic", value, suit);
    }

    /*
    *Effet : L'arme Volcanic permet de jouer autant de cartes Bang que l'on possède 
    */

    @Override
    public int getRange(){
        return 1;
    }

}

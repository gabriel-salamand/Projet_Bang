package fr.umontpellier.iut.bang.cards;

public class Colt45 extends WeaponCard {
    
    public Colt45(int value, CardSuit suit) {
        super("Colt45", value, suit);
    }
    /*
    *Effet/Fonction : L'arme Colt45 est l'arme de base que tout le monde possède au début du jeu,
    * Si quelqu'un perd son arme, par défaut il a un Colt45 (qui a une portee de 1);
    */

    @Override
    public int getRange(){
        return 1;
    }

}
package fr.umontpellier.iut.bang.cards;

public class Mustang extends BlueCard {

    public Mustang(int value, CardSuit suit) {
        super("Mustang", value, suit);
    }

    /* Effet : Le joueur qui pose cette carte devant lui s’éloigne
    * d’une distance de 1 des autres joueurs. Il continue cependant 
    * à voir les autres joueurs à la distance normale.
    */

}

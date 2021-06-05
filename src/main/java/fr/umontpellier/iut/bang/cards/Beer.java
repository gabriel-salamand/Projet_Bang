package fr.umontpellier.iut.bang.cards;

import fr.umontpellier.iut.bang.Player;

public class Beer extends OrangeCard {

    public Beer(int value, CardSuit suit) {
        super("Beer", value, suit);
    }

    public void playedBy(Player player) {
        super.playedBy(player);
        player.incrementHealth(1);
        player.discardFromHand(this);
    }

    /* Effet : ajoute un point de vie après utilisation si la 
    * vie du joueur n'est pas pleine. La carte est automatiquement 
    * utilisé lorsque vous venez de perdre votre dernier point de vie.
    * Les cartes "Beer" n'ont plus AUCUN EFFET, s'il ne reste plus 
    * que 2 joueurs en jeu.
    */
}

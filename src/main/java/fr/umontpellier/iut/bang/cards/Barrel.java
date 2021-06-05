package fr.umontpellier.iut.bang.cards;

import fr.umontpellier.iut.bang.Player;
import fr.umontpellier.iut.bang.Game;

import static fr.umontpellier.iut.bang.cards.CardSuit.*;

import java.util.List;

public class Barrel extends BlueCard {

    public Barrel(int value, CardSuit suit) {
        super("Barrel", value, suit);
    }

    @Override
    public void playedBy (Player player) {
        super.playedBy(player);
    }

    //Méthode peut-être inutile
    /**
    @return vrai si le joueur a tiré une carte de coeur
    */
    public boolean UsePower(Player player){
        Game game1 = player.getGame();
        Card drawedCard = game1.drawCard();

        if (drawedCard.getSuit() == CardSuit.HEART){
            game1.addToDiscard(drawedCard);
            return true;
        }
        else {
            game1.addToDiscard(drawedCard);
            return false;
        }

    }
    

}

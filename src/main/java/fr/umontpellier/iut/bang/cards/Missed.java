package fr.umontpellier.iut.bang.cards;

import fr.umontpellier.iut.bang.Game;
import fr.umontpellier.iut.bang.Player;

import java.util.List;

public class Missed extends OrangeCard {

    private Player currentPlayer;

    public Missed(int value, CardSuit suit) {
        super("Missed!", value, suit);
    }

    @Override
    public void playedBy(Player player) {
        super.playedBy(player);
        player.incrementHealth(1);
        player.discardFromHand(this);

    }
}

package fr.umontpellier.iut.bang.cards;

import fr.umontpellier.iut.bang.Player;

import java.util.List;

public class Gatling extends OrangeCard {

    public Gatling(int value, CardSuit suit) {
        super("Gatling", value, suit);
    }

    public void playedBy (Player player) {
        super.playedBy(player);
        List<Player> allPlayers = player.getOtherPlayers();
        for (Player player1 : allPlayers) {
            player1.decrementHealth(1, player);
        }
    }

}

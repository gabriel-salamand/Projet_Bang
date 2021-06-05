package fr.umontpellier.iut.bang.cards;

import fr.umontpellier.iut.bang.Player;

import java.util.ArrayList;
import java.util.List;

public class Duel extends OrangeCard {

    public Duel(int value, CardSuit suit) {
        super("Duel", value, suit);
    }

    @Override
    public void playedBy(Player player) {
        super.playedBy(player);
        List<Player> allPlayers = player.getOtherPlayers();
        Player playerDefied = player.choosePlayer("Choisis un joueur", allPlayers, false);

        Card c;
        int i = 1;
        String decision;
        List<String> choix = new ArrayList<>();
        choix.add("Bang!");

        while (true) {
            if (i % 2 != 0) {
                c = playerDefied.hasCardInHand("Bang!");
                if (c != null) {
                    decision = playerDefied.choose("Voulez-vous défausser votre carte bang ?", choix, true, true);
                    if (decision.equals("Bang!")) {
                        playerDefied.discardFromHand(c);
                    } else {
                        playerDefied.decrementHealth(1, playerDefied);
                        break;
                    }
                } else {
                    playerDefied.decrementHealth(1, playerDefied);
                    break;
                }
            } else {
                c = player.hasCardInHand("Bang!");
                if (c != null) {
                    decision = player.choose("Voulez-vous défausser votre carte bang ?", choix, true, true);
                    if (decision.equals("Bang!")) {
                        player.discardFromHand(c);
                    } else {
                        player.decrementHealth(1, player);
                        break;
                    }
                } else {
                    player.decrementHealth(1, player);
                    break;
                }
            }
            i++;
        }
    }
}

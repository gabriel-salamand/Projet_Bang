package fr.umontpellier.iut.bang.cards;

import fr.umontpellier.iut.bang.Player;

import java.util.ArrayList;
import java.util.List;

public class Indians extends OrangeCard {

    public Indians(int value, CardSuit suit) {
        super("Indians", value, suit);
    }

    @Override
    public void playedBy(Player player) {
        super.playedBy(player);
        List<Player> allPlayers = player.getOtherPlayers();
        allPlayers.remove(player);
        String decision;
        Player p;
        Card c;

        List<String> choix = new ArrayList<>();
        choix.add("Bang!");
        choix.add("");

        for (int i = 0; i < allPlayers.size(); i++) {
            p = allPlayers.get(i);
            c = p.hasCardInHand("Bang!");
            if (c != null) {
                decision = p.choose("Voulez-vous défausser votre carte bang ?", choix, true, true);
                if (decision.equals("Bang!")) {
                    p.discardFromHand(c);
                }
                else {
                    p.decrementHealth(1, player);
                }
            }
            else {
                p.decrementHealth(1, player);
            }
        }
    }
}

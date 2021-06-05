package fr.umontpellier.iut.bang.cards;

import fr.umontpellier.iut.bang.Player;

import java.util.List;

public class Jail extends BlueCard {
    public Jail(int value, CardSuit suit) {
        super("Jail", value, suit);
    }

    @Override
    public void playedBy(Player player) {
        super.playedBy(player);
        List<Player> allPlayers = player.getOtherPlayers();
        allPlayers.remove(player.getGame().getSheriffPlayer());

        Player playerSentToJail = player.choosePlayer("Choisis un joueur", allPlayers, false);

        if (playerSentToJail.hasCardInPlay2("Jail")) {
            while (playerSentToJail.hasCardInPlay2("Jail")) {
                playerSentToJail = player.choosePlayer("Ce joueur a déjà une carte prison en jeu, choisis-en un autre", allPlayers, false);
            }
        }

        playerSentToJail.addToInPlay(this);

    }
}

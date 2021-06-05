package fr.umontpellier.iut.bang.characters;

import fr.umontpellier.iut.bang.Game;
import fr.umontpellier.iut.bang.Player;
import fr.umontpellier.iut.bang.cards.Card;

import java.util.List;

public class CalamityJanet extends BangCharacter {

    public CalamityJanet() {
        super("Calamity Janet", 4);
    }

    @Override
    public void onStartTurn(Player player) {
        super.onStartTurn(player);
        Game game = player.getGame();
        List<Card> cardList = player.getHand();
        List<Player> playersList = game.getPlayers();

        for (Card c : cardList) {
            if (player.hasCardInPlay2("Bang!")) {

            }
        }

        }
}

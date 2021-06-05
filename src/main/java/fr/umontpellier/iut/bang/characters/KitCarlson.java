package fr.umontpellier.iut.bang.characters;

import fr.umontpellier.iut.bang.Player;
import fr.umontpellier.iut.bang.cards.Card;

import java.util.ArrayList;
import java.util.List;

public class KitCarlson extends BangCharacter {

    public KitCarlson() {
        super("Kit Carlson", 4);
    }

    @Override
    public void onStartTurn(Player player) {
        Card card1 = player.drawCard();
        Card card2 = player.drawCard();
        Card card3 = player.drawCard();

        List<Card> pioche = new ArrayList<>();

        pioche.add(card1);
        pioche.add(card2);
        pioche.add(card3);

        Card selectedCard = player.chooseCard("Carte à reposer dans la pioche : ", pioche,false,false);
        pioche.remove(selectedCard);
        player.getHand().add(pioche.get(0));
        player.getHand().add(pioche.get(1));
        player.getGame().getDrawPile().addFirst(selectedCard);


    }
}
package fr.umontpellier.iut.bang.characters;


import fr.umontpellier.iut.bang.Player;
import fr.umontpellier.iut.bang.cards.Card;

import java.util.ArrayList;
import java.util.List;


public class PedroRamirez extends BangCharacter {

    public PedroRamirez() {
        super("Pedro Ramirez", 4);
    }

    @Override
    public void onStartTurn(Player player) {
        List<String> choix = new ArrayList<>();
        choix.add(player.getGame().getTopOfDiscardPile().getName());
        choix.add("");

        String playerChoice = player.choose("Pioche ou première carte de la défausse ?", choix,false,false);
        if (playerChoice == player.getGame().getTopOfDiscardPile().getName()){
            player.addToHand(player.getGame().getTopOfDiscardPile());
            player.getGame().removeFromDiscard(player.getGame().getTopOfDiscardPile());
        }
        else{
            player.drawToHand();
        }
        player.drawToHand();

    }
}
package fr.umontpellier.iut.bang.characters;

import fr.umontpellier.iut.bang.Player;
import fr.umontpellier.iut.bang.cards.Card;

import java.util.ArrayList;
import java.util.List;

public class JesseJones extends BangCharacter {

    public JesseJones() {
        super("Jesse Jones", 4);
    }

    @Override
    public void onStartTurn(Player player) {
        Player p = player.choosePlayer("Choix du joueur à prendre la carte : ", player.getOtherPlayers(),true);

        if (p == null) {
            player.drawToHand();
        } else if (!p.getHand().isEmpty()) {
            Card card1 = selectCardFromPlayer(p);
            p.getHand().remove(card1);
            player.getHand().add(card1);
        } else {
            player.drawToHand();
            System.out.println("Le joueur ne possède aucune carte.");
        }
        player.drawToHand();
    }
    public Card selectCardFromPlayer(Player player){
        return player.getHand().get(0);
    }

    
}
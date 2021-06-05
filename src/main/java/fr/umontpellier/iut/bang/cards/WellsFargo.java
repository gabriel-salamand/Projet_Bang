package fr.umontpellier.iut.bang.cards;

import fr.umontpellier.iut.bang.Player;

public class WellsFargo extends OrangeCard {
    public WellsFargo(int value, CardSuit suit) {
        super("Wells Fargo", value, suit);
    }

    @Override
    public void playedBy(Player player) {
        super.playedBy(player);
        for (int i = 0; i < 3; i++) {
            player.drawToHand();
        }
    }
}

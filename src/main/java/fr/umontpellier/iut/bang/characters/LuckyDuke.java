package fr.umontpellier.iut.bang.characters;

import fr.umontpellier.iut.bang.Player;
import fr.umontpellier.iut.bang.cards.Card;

import java.util.ArrayList;

public class LuckyDuke extends BangCharacter {

    public LuckyDuke() {
        super("Lucky Duke", 4);

    }
    @Override
    public void onStartTurn(Player player){
        player.drawToHand();
        player.randomDraw();

    }

}

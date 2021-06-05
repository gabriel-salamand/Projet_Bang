package fr.umontpellier.iut.bang.cards;

import fr.umontpellier.iut.bang.Player;
import fr.umontpellier.iut.bang.Game;

import java.util.ArrayList;
import java.util.List;

public class CatBalou extends OrangeCard {

    public CatBalou(int value, CardSuit suit) {
        super("Cat Balou", value, suit);
    }

    /**
    * Effet : Force « n’importe quel joueur » à « défausser une carte », 
    * quelle que soit la distance.
    */

    @Override
    public boolean canPlayFromHand(Player player){
        if (PossibleTarget(player).size() < 1){
            return false;
        }
        return true;
    }

    @Override
    public void playedBy(Player player) {
        super.playedBy(player);

        List<Player> Players;
        String instructionCP;
        Card DiscardCard;

        String instructionCC;
        List<Card> InPlayCards;

        if (canPlayFromHand(player)) {
            // Etape 1 : le joueur A (joueur dont c'est le tour) choisit un joueur parmi les joueurs en jeu
            instructionCP = "Veuillez choisir un joueur parmi les joueurs en jeu";
            Players = PossibleTarget(player);
            Player ChosenPlayer = player.choosePlayer(instructionCP, Players, false);

            //boolean verif = Players.get(i).getInPlay() != 0

            // Etape 2 : le joueur B (le joueur choisi par le joueur A) choisit une carte à défausser
            instructionCC = "Veuillez choisir une carte à défausser parmi le jeu";
             InPlayCards = new ArrayList<>();
            InPlayCards.addAll(ChosenPlayer.getInPlay());

            DiscardCard = ChosenPlayer.chooseCard(instructionCC, InPlayCards, false, false);

            /*
             * Etape 3 : la carte à défausser choisit par le joueur B est défaussé de la main de ce dernier;
             * Si le joueur A a passé, une carte aléatoire de la main du joueur B est supprimé
             */
            if (DiscardCard != null) {
                ChosenPlayer.discard(DiscardCard);
                ChosenPlayer.getInPlay().remove(DiscardCard);
            } else {
                Card removedCard = ChosenPlayer.removeRandomCardFromHand();
                ChosenPlayer.discard(removedCard);
            }

        }

    }

    public ArrayList<Player> PossibleTarget (Player player){
        List<Player> OthersPlayers = player.getOtherPlayers();
        ArrayList<Player> PossiblePlayers = new ArrayList<>();

        for (Player p : OthersPlayers){
            if ((p.getHand().size() < 1 ) && ( p.getInPlay().size() < 1 )){
            }
            else {
                PossiblePlayers.add(p);
            }
        }
        return PossiblePlayers;
    }

}

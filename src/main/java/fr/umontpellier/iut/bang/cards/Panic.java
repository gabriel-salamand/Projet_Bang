package fr.umontpellier.iut.bang.cards;

import fr.umontpellier.iut.bang.Player;
import java.util.List;
import java.util.ArrayList;

public class Panic extends OrangeCard {

    public Panic(int value, CardSuit suit) {
        super("Panic!", value, suit);
    }

    /* 
    * Effet : « tirez une carte » dans la main (ou les cartes 
    * en jeu) « d’un joueur situé à une distance de 1 ».
    */

    @Override
    public void playedBy(Player player){
        super.playedBy(player);

        //Etape 1 : le joueur A (joueur dont c'est le tour) choisit un joueur parmi les joueurs
        // en jeu à distance 1 ou plus en fonction des cartes de inPlay

        String instructionCP = "Veuillez choisir un joueur parmi les joueurs en jeu à distance 1 de vous";
        List<Player> PlayerInRange = player.getPlayersInRange(1);

        Player ChosenPlayer = player.choosePlayer(instructionCP, PlayerInRange, false);

        //Etape 2 : le joueur A choisit une carte de la main du joueur B (le joueur choisi)

        String instructionCC = "Veuillez choisir une carte parmi la main du joueur choisi";
        List<Card> HandCards = ChosenPlayer.getHand();
        HandCards.add(ChosenPlayer.getWeapon());

        Card ChosenCard = ChosenPlayer.chooseCard(instructionCC, HandCards, false, false);

        // Etape 3 : on vérifie l'existance de la carte choisi

        //while (ChosenCard == null){
        //    ChosenCard = ChosenPlayer.chooseCard(instructionCC, HandCards, false, false);
        //}

        /* Etape 4 : la carte choisi est retirée de la main du joueur B
        * et la carte choisi est ajoutée à la main ju joueur A
        */
        if ( ChosenCard.equals(ChosenPlayer.getWeapon()) ){
            ChosenPlayer.setWeapon(null);
        }
        else {
            ChosenPlayer.removeFromHand(ChosenCard);
        }
        player.addToHand(ChosenCard);

    }

}

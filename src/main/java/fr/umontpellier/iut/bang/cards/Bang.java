package fr.umontpellier.iut.bang.cards;
import fr.umontpellier.iut.bang.Game;
import fr.umontpellier.iut.bang.Player;

import java.util.ArrayList;
import java.util.List;

public class Bang extends OrangeCard {

    public Bang(int value, CardSuit suit) {
        super("Bang!", value, suit);
    }

    @Override
    public void playedBy(Player player) {
        super.playedBy(player);
        //Phase 1 : le joueur choisit un joueur pour cible

        Game game = player.getGame();

        List<Player> PlayersInRange = player.getPlayersInRange(1); //liste des joueurs dans la range de 1
        List<String> choices = new ArrayList<String>();

        choices.add("Oui");
        choices.add("Non");
        String choix;

        Player bangedPlayer = player.choosePlayer("Choisis un joueur", PlayersInRange, false); //choix du BangedPlayer
        player.discardFromHand(this); //retire la carte du joueur qui l'a utilisé


        //Phase 2 : vérification des cartes en jeu et dans la main du joueur ciblé

        Card BangedPlayerHasBarrel = bangedPlayer.hasCardInPlay("Barrel");

        if ( BangedPlayerHasBarrel != null){
            System.out.println("Possède barrel");
            Card drawedCard = game.drawCard();
            if (drawedCard.getSuit() == CardSuit.HEART){
                game.addToDiscard(drawedCard);
            }
            else {
                game.addToDiscard(drawedCard);
                if (bangedPlayer.hasCardInHand("Missed!") != null) {
                    choix = bangedPlayer.choose("Vous avez été Bang! Voulez-vous utiliser votre carte Missed?", choices, true, false);
                    if (choix.equals("Oui")) {
                        bangedPlayer.playFromHand(bangedPlayer.hasCardInHand("Missed!"));
                    }
                } else {
                    bangedPlayer.decrementHealth(1, player); //retire du jeu le joueur s'il est mort
                }
            }
        }
        else {
            if ((BangedPlayerHasBarrel == null) && (bangedPlayer.hasCardInHand("Missed!") != null)) {
                choix = bangedPlayer.choose("Vous avez été Bang! Voulez-vous utiliser votre carte Missed?", choices, true, false);
                if (choix.equals("Oui")) {
                    bangedPlayer.playFromHand(bangedPlayer.hasCardInHand("Missed!"));
                }
            } else {
                bangedPlayer.decrementHealth(1, player); //retire du jeu le joueur s'il est mort
            }
        }
         //*/



        // Phase 3 : Récompenses et Pénalités en fonction du joueur attaquant et du joueur ciblé

        if (bangedPlayer.isDead()){
            player.PenaltyAndReward(bangedPlayer);
        }
    }

    public void reactToBang(Player player ){

    }
}

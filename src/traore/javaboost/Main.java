package traore.javaboost;

import traore.javaboost.logements.Appartement;
import traore.javaboost.logements.Chalet;
import traore.javaboost.logements.Logement;
import traore.javaboost.logements.Maison;
import traore.javaboost.reservations.*;
import traore.javaboost.utilisateurs.Hote;
import traore.javaboost.utilisateurs.Personne;
import traore.javaboost.utilisateurs.Voyageur;
import traore.javaboost.utilitaires.MaDate;
import traore.javaboost.utilitaires.Utilitaire;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String [] args){

        Hote hote = new Hote("Traore","Noor", 35, 1);

        Voyageur voyageur = new Voyageur("Traore","Fatoumata Zahra", 26);

        Maison maMaison1 = new Maison("Résidence Fatima", 500, "157 Boulevard de la Liberté, Lille", 200, 5, hote, 50, false);
        Appartement monAppartement1 = new Appartement("Alpha", 15, "157 Boulevard de la Liberté, Lille", 50, 2, hote, 3, 1);
        Chalet monChalet = new Chalet("La madrague", 40, "Bassam", 5, 2, hote, 10);

        MaDate dateSejour = new MaDate(14,11,2025);

        Reservation maReservation;

        Sejour monSejour;

        int nbVoyageur = Utilitaire.choix("le nombre de voyageurs", 1, 5);

        int nbNuit = Utilitaire.choix("le nombre de nuits", 1, 31);

        if(nbNuit == 2 && Utilitaire.verifDayOfWeek(dateSejour)){ //dateSejour.getDay()==5 => eqivalent de la méthode verifDayOfWeek()

            monSejour = new SejourWeekEnd(dateSejour,nbNuit, monChalet, nbVoyageur);

        } else if (nbNuit < 6) {

            monSejour = new SejourCourt(dateSejour,nbNuit, maMaison1, nbVoyageur);

        }else {

            monSejour = new SejourLong(dateSejour,nbNuit, monAppartement1, nbVoyageur);
        }

        try{
            maReservation = new Reservation(voyageur, monSejour);
            maReservation.afficher();
        }catch(Exception e){
            System.out.println("Impossible de créer la reservation car : "+e.getMessage());
        }

    }




}

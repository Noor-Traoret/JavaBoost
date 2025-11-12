package traore.javaboost;

import traore.javaboost.data.JavaBoostData;
import traore.javaboost.logements.Appartement;
import traore.javaboost.logements.Chalet;
import traore.javaboost.logements.Logement;
import traore.javaboost.logements.Maison;
import traore.javaboost.reservations.*;
import traore.javaboost.utilisateurs.Hote;
import traore.javaboost.utilisateurs.Personne;
import traore.javaboost.utilisateurs.Voyageur;
import traore.javaboost.utilitaires.LogementsXMLParser;
import traore.javaboost.utilitaires.MaDate;
import traore.javaboost.utilitaires.Utilitaire;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String [] args){

        JavaBoostData data = JavaBoostData.getInstance();

        Hote hote = data.getHotes().get(0);
        Logement logement = data.getLogements().get(0);

        Voyageur voyageur = new Voyageur("Traore","Fatoumata Zahra", 26);

        MaDate dateSejour = new MaDate(14,11,2025);

        int nbVoyageur = Utilitaire.choix("le nombre de voyageurs", 1, 5);

        int nbNuit = Utilitaire.choix("le nombre de nuits", 1, 31);

        Sejour monSejour = SejourFactory.creerSejour(dateSejour, logement, nbNuit, nbVoyageur);

        try{
            monSejour.setLogement(data.getLogements().get(1));
        }catch(Exception e){
            System.out.println("Impossible de modifier cet logement : "+e.getMessage());
        }


        //Le code ci-dessous est géré dans l classe SejourFactory
        /*if(nbNuit == 2 && Utilitaire.verifDayOfWeek(dateSejour)){ //dateSejour.getDay()==5 => eqivalent de la méthode verifDayOfWeek()

            monSejour = new SejourWeekEnd(dateSejour,nbNuit, monChalet, nbVoyageur);

        } else if (nbNuit < 6) {

            monSejour = new SejourCourt(dateSejour,nbNuit, maMaison1, nbVoyageur);

        }else {

            monSejour = new SejourLong(dateSejour,nbNuit, monAppartement1, nbVoyageur);
        }*/


        Reservation maReservation;
        try{
            maReservation = new Reservation(voyageur, monSejour);
            maReservation.afficher();
        }catch(Exception e){
            System.out.println("Impossible de créer la reservation car : "+e.getMessage());
        }

    }




}

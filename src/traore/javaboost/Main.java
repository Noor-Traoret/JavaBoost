package traore.javaboost;

import traore.javaboost.logements.Appartement;
import traore.javaboost.logements.Chalet;
import traore.javaboost.logements.Logement;
import traore.javaboost.logements.Maison;
import traore.javaboost.reservations.Reservation;
import traore.javaboost.reservations.Sejour;
import traore.javaboost.reservations.SejourCourt;
import traore.javaboost.reservations.SejourLong;
import traore.javaboost.utilisateurs.Hote;
import traore.javaboost.utilisateurs.Personne;
import traore.javaboost.utilisateurs.Voyageur;
import traore.javaboost.utilitaires.MaDate;
import traore.javaboost.utilitaires.Utilitaire;

import java.util.Date;

public class Main {
    public static void main(String [] args){

        Hote hote = new Hote("Traore","Noor", 35, 1);

        Voyageur voyageur = new Voyageur("Traore","Fatoumata Zahra", 26);

        Appartement monAppartement1 = new Appartement("Alpha", 15, "157 Boulevard de la Liberté, Lille", 50, 2, hote, 3, 1);

        Chalet monChalet = new Chalet("La madrague", 40, "Bassam", 5, 2, hote, 10);

        //Logement lgt1 = new Logement("Maison au calme", 25, "157 Boulevard de la Liberté, Lille", 100, 1, hote);

        MaDate dateSejour = new MaDate(15,11,2025);



        /**
         * Nous appliquons le principe du polymorphisme en passant en paramètre au lieu d'un objet
         * date, un objet fille de la classe date.
         */
        Maison maMaison1 = new Maison("Résidence Fatima", 500, "157 Boulevard de la Liberté, Lille", 200, 5, hote, 50, false);
        SejourCourt monSejourCourt = new SejourCourt(dateSejour,4, maMaison1, 2);
        SejourLong monSejourLong = new SejourLong(dateSejour,8, monAppartement1, 2);

        Reservation maReservation1 = new Reservation(voyageur, monSejourCourt);
        Reservation maReservation2 = new Reservation(voyageur, monSejourLong);
        maReservation2.afficher();

    }
}

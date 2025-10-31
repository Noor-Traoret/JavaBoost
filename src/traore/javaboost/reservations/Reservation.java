package traore.javaboost.reservations;

import traore.javaboost.utilisateurs.Voyageur;
import traore.javaboost.utilitaires.MaDate;

import java.util.Date;

public class Reservation {
    private Voyageur voyageur;
    private IReservable objetReservable;
    private Date dateDeReservation;

    public Reservation(Voyageur voyageur, IReservable objetReservable) {
        this.voyageur = voyageur;
        this.objetReservable = objetReservable;
        this.dateDeReservation = new MaDate();
    }


    public void afficher(){
        if(objetReservable.aUneDateArriveeCorrecte() && objetReservable.aUnNombreDeNuitsCorrect() && objetReservable.aUnNombreDeVoyageursCorrect()){
            //if(objetReservable instanceof Sejour sejour){}
            System.out.println("Réservation faite le " +dateDeReservation+ " par le voyageur " +voyageur.getNom()+" "+voyageur.getPrenoms()+"("+voyageur.getAge()+"ans)");
            System.out.print("Chez ");
            objetReservable.afficher();
        }else System.out.println("Impossible de reserver!");

    }
}

package traore.javaboost.reservations;

import traore.javaboost.utilisateurs.Voyageur;
import traore.javaboost.utilitaires.MaDate;

import java.util.Date;

public class Reservation {
    private Voyageur voyageur;
    private IReservable objetReservable;
    private Date dateDeReservation;

    /**
     * Construit une nouvelle instance de {@link Reservation} en associant un
     * {@link Voyageur} et un objet implémentant l’interface {@link IReservable}.
     * <p>
     * Ce constructeur vérifie la validité des informations de l’objet réservable avant
     * de créer la réservation :
     * </p>
     * <ul>
     *   <li>la date d’arrivée doit être correcte ;</li>
     *   <li>le nombre de nuits doit être valide ;</li>
     *   <li>le nombre de voyageurs doit être cohérent.</li>
     * </ul>
     * Si l’une de ces vérifications échoue, une exception est levée avec un message explicite.
     *
     * @param voyageur l’objet représentant le voyageur effectuant la réservation
     * @param objetReservable l’objet réservable (hébergement, activité, etc.) concerné
     *
     * @throws IllegalArgumentException  si la date d’arrivée, le nombre de nuits ou le nombre de voyageurs
     *                   ne sont pas corrects
     *
     * @see Voyageur
     * @see IReservable
     * @see MaDate
     */
    public Reservation(Voyageur voyageur, IReservable objetReservable) throws IllegalArgumentException  {
        if( !objetReservable.aUneDateArriveeCorrecte() ){
            IllegalArgumentException  exception = new IllegalArgumentException ("La date d'arrivée n'est pas correcte.");
            throw exception;
        }

        if( !objetReservable.aUnNombreDeNuitsCorrect() ){
            throw new IllegalArgumentException ("Le nombre de nuit n'est pas correct.");
        }

        if( !objetReservable.aUnNombreDeVoyageursCorrect() ){
            throw new IllegalArgumentException ("Le nombre de voyageur n'est pas correct.");

        }

        this.voyageur = voyageur;

        this.objetReservable = objetReservable;

        this.dateDeReservation = new MaDate();
    }


    public void afficher(){

        System.out.println("Réservation faite le " +dateDeReservation+ " par le voyageur " +voyageur.getNom()+" "+voyageur.getPrenoms()+"("+voyageur.getAge()+"ans)");

        System.out.print("Chez ");

        objetReservable.afficher();

    }
}

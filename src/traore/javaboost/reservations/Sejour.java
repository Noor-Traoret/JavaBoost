package traore.javaboost.reservations;

import traore.javaboost.logements.Logement;
import traore.javaboost.utilitaires.MaDate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


public abstract class Sejour implements IReservable {
    protected MaDate dateArrivee;
    protected int nbNuits;
    protected Logement logement;
    private int nbVoyageurs;
    protected int prix;

    Sejour(MaDate pDateArrivee, int pNbNuits, Logement pLogement, int pNbVoyageurs) {
        this.dateArrivee = pDateArrivee;
        this.nbNuits = pNbNuits;
        this.logement = pLogement;
        this.nbVoyageurs = pNbVoyageurs;
        this.miseAJourDuPrixDuSejour();
    }

    protected void afficherSejour(){
        logement.afficher();
        System.out.println(
                "La date d’arrivée est le "+this.dateArrivee+" pour "+this.nbNuits
                        +" nuit"+(nbNuits > 1 ?"s.":"."));
        /*if (logement instanceof Maison){
            Maison maMaison = (Maison)logement;
            System.out.println("Piscine d'intérieur : "+(maMaison.aUnePiscineInterieur() ? "Oui": "Non"));
        }*/
    }

    @Override
    public abstract void afficher();

    public abstract void miseAJourDuPrixDuSejour();

    /**
     * Vérifie si la date d'arrivée du séjour est valide en fonction du type de séjour.
     * <p>
     * Cette méthode contrôle la cohérence de la date d'arrivée selon les règles suivantes :
     * <ul>
     *   <li>Si l'objet courant est une instance de {@code SejourWeekEnd},
     *       la date d'arrivée doit être postérieure à la date actuelle
     *       <strong>et</strong> tomber un vendredi ({@code getDay() == 5}).</li>
     *   <li>Sinon, pour les autres types de séjour,
     *       la date d'arrivée doit simplement être postérieure à la date du jour.</li>
     * </ul>
     *
     * @return {@code true} si la date d'arrivée respecte les conditions définies
     *         selon le type de séjour ; {@code false} sinon.
     *
     * @see java.time.DayOfWeek
     * @see java.time.LocalDate
     * @see java.time.ZoneId
     */
    @Override
    public boolean aUneDateArriveeCorrecte() {
        /*if(this instanceof SejourWeekEnd ){

            //return this.dateArrivee.after(new Date()) && this.dateArrivee.getDay() == 5;
            LocalDate arrival = this.dateArrivee.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            return arrival.isAfter(LocalDate.now()) && arrival.getDayOfWeek() == DayOfWeek.FRIDAY;
        }*/
        return this.dateArrivee.after(new Date());
    }

    /**
     * Vérifie si le nombre de voyageurs du séjour est conforme
     * à la capacité maximale du logement associé.
     * <p>
     * Cette méthode compare le nombre de voyageurs réservés pour le séjour
     * avec la capacité maximale du logement. Elle garantit que le séjour
     * ne dépasse pas la limite autorisée par le logement.
     * </p>
     *
     * @return {@code true} si le nombre de voyageurs du séjour est inférieur ou égal
     *         à la capacité maximale du logement ; {@code false} sinon.
     *
     * @see #nbVoyageurs
     * @see Logement#getNbVoyageursMax()
     */
    @Override
    public boolean aUnNombreDeVoyageursCorrect() {
        return this.nbVoyageurs <= this.logement.getNbVoyageursMax();
    }
}

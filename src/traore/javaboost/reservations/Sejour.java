package traore.javaboost.reservations;

import traore.javaboost.logements.Logement;
import traore.javaboost.logements.Maison;
import traore.javaboost.utilitaires.Utilitaire;

import java.util.Date;

import static java.time.LocalTime.now;

public abstract class Sejour implements IReservable {
    private Date dateArrivee;
    protected int nbNuits;
    private Logement logement;
    private int nbVoyageurs;
    protected int prix;

    public Sejour(Date pDateArrivee, int pNbNuits, Logement pLogement, int pNbVoyageurs) {
        this.dateArrivee = pDateArrivee;
        this.nbNuits = pNbNuits;
        this.logement = pLogement;
        this.nbVoyageurs = pNbVoyageurs;
        this.prix = pLogement.getTarifParNuit()*pNbNuits;
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
     * aUneDateArriveeCorrecte : retourne vrai si la date d’arrivée est plus grande
     * que la date actuelle, faux sinon.
     * @return
     */
    @Override
    public boolean aUneDateArriveeCorrecte() {return this.dateArrivee.after(new Date());}

    /**
     * aUnNombreDeVoyageursCorrect : retourne vrai si le nombre de personnes du séjour
     * ne dépasse pas la capacité d’accueil du logement.
     * @return
     */
    @Override
    public boolean aUnNombreDeVoyageursCorrect() {
        return this.nbVoyageurs <= this.logement.getNbVoyageursMax();
    }
}

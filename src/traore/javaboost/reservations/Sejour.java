package traore.javaboost.reservations;

import traore.javaboost.logements.Logement;
import traore.javaboost.logements.Maison;
import traore.javaboost.utilitaires.Utilitaire;

import java.util.Date;

import static java.time.LocalTime.now;

public abstract class Sejour implements IReservable {
    protected Date dateArrivee;
    protected int nbNuits;
    protected Logement logement;
    private int nbVoyageurs;

    public Sejour(Date pDateArrivee, int pNbNuits, Logement pLogement, int pNbVoyageurs) {
        this.dateArrivee = pDateArrivee;
        this.nbNuits = pNbNuits;
        this.logement = pLogement;
        this.nbVoyageurs = pNbVoyageurs;
    }
    @Override
    public abstract void afficher();/*{
        logement.afficher();
        System.out.println(
                "La date d’arrivée est le "+this.dateArrivee+" pour "+this.nbNuits
                        +" nuit"+(nbNuits > 1 ?"s.":".")+"\nLe prix de ce séjour est de "+this.logement.getTarifParNuit()*this.nbNuits+"€.");
        if (logement instanceof Maison){
            Maison maMaison = (Maison)logement;
            System.out.println("Piscine d'intérieur : "+(maMaison.aUnePiscineInterieur() ? "Oui": "Non"));
        }
    }*/

    /**
     * aUneDateArriveeCorrecte : retourne vrai si la date d’arrivée est plus grande
     * que la date actuelle, faux sinon.
     * @return
     */
    @Override
    public boolean aUneDateArriveeCorrecte() {return this.dateArrivee.after(new Date());}

    /**
     * aUnNombreDeNuitsCorrecte : retourne vrai si le nombre de jours du séjour est compris
     * entre 1 et 31 (un jour minimum, un mois maximum), faux sinon.
     * @return
     */
    @Override
    public boolean aUnNombreDeNuitsCorrect() {
        return this.nbNuits >= 1 && this.nbNuits <= 31;
    }

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

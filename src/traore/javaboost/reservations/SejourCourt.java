package traore.javaboost.reservations;

import traore.javaboost.logements.Logement;

import java.util.Date;

public class SejourCourt extends Sejour{

    public SejourCourt(Date pDateArrivee, int pNbNuits, Logement pLogement, int pNbVoyageurs) {
        super(pDateArrivee, pNbNuits, pLogement, pNbVoyageurs);
    }

    /**
     * aUnNombreDeNuitsCorrecte : retourne vrai si le nombre de jours du séjour est compris
     * entre 1 et 31 (un jour minimum, un mois maximum), faux sinon.
     * @return
     */
    @Override
    public boolean aUnNombreDeNuitsCorrect() {
        return this.nbNuits >= 1 && this.nbNuits <= 5;
    }

    @Override
    public void afficher() {
        afficherSejour();

        System.out.println("Le prix de ce séjour court est de "+this.prix+"€.");
    }

    @Override
    public void miseAJourDuPrixDuSejour() {
        this.prix = logement.getTarifParNuit()*nbNuits;
    }
}

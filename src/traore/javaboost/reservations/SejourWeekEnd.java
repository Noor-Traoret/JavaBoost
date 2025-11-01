package traore.javaboost.reservations;

import traore.javaboost.logements.Logement;

import java.util.Date;

public class SejourWeekEnd extends Sejour{

    public SejourWeekEnd(Date pDateArrivee, int pNbNuits, Logement pLogement, int pNbVoyageurs) {
        super(pDateArrivee, pNbNuits, pLogement, pNbVoyageurs);
    }

    @Override
    public void afficher() {

    }

    /**
     * aUnNombreDeNuitsCorrecte : retourne vrai si le nombre de jours du séjour est compris
     * entre 1 et 31 (un jour minimum, un mois maximum), faux sinon.
     * @return
     */
    @Override
    public boolean aUnNombreDeNuitsCorrect() {
        return this.nbNuits == 2;
    }

    @Override
    public void miseAJourDuPrixDuSejour() {

    }
}

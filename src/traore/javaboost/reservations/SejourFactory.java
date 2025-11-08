package traore.javaboost.reservations;

import traore.javaboost.logements.Logement;
import traore.javaboost.utilitaires.MaDate;

import java.util.Date;

public final class SejourFactory {

    private SejourFactory() {
    }

    public static Sejour creerSejour(MaDate dateArrivee, Logement logement, int nbNuits, int nbVoyageurs){

        Sejour monSejour;

        if (nbNuits == 2 && dateArrivee.getDay() == 5) {
            // Sejour weekend
            monSejour = new SejourWeekEnd(dateArrivee, nbNuits, logement, nbVoyageurs);
        } else if (nbNuits < 6) {
            // Sejour court
            monSejour = new SejourCourt(dateArrivee, nbNuits, logement, nbVoyageurs);
        } else {
            // Sejour long
            monSejour = new SejourLong(dateArrivee, nbNuits, logement, nbVoyageurs);
        }
        return monSejour;
    }
}

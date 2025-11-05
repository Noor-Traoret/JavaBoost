package traore.javaboost.reservations;

import traore.javaboost.logements.Logement;

import java.util.Date;

public class SejourWeekEnd extends Sejour{

    public static final int PROMOTION = 50;

    //La visibilité du constructeur est passée à package, afin que seule une classe du même
    // package (ici la fabrique) ne pourra créer d’instances de classes filles.
     SejourWeekEnd(Date pDateArrivee, int pNbNuits, Logement pLogement, int pNbVoyageurs) {
        super(pDateArrivee, pNbNuits, pLogement, pNbVoyageurs);
    }

    @Override
    public void afficher() {
        afficherSejour();
        System.out.println("Le prix de ce séjour weekend est de "+prix+"€ (avec une promotion de "+PROMOTION+"€)");
    }

    /**
     * Vérifie si le nombre de nuits du séjour est conforme
     * à la durée attendue pour ce type de séjour.
     * <p>
     * Cette implémentation considère qu’un séjour valide doit durer
     * exactement deux nuits. Si le nombre de nuits diffère de cette valeur,
     * le séjour est considéré comme incorrect.
     * </p>
     *
     * @return {@code true} si le séjour comporte exactement deux nuits ;
     *         {@code false} sinon.
     *
     * @see #nbNuits
     */
    @Override
    public boolean aUnNombreDeNuitsCorrect() {
        return this.nbNuits == 2;
    }

    @Override
    public void miseAJourDuPrixDuSejour() {
        int prixInitial = logement.getTarifParNuit()*nbNuits;
        this.prix = prixInitial - PROMOTION;
    }
}

package traore.javaboost.reservations;

import traore.javaboost.logements.Logement;

import java.util.Date;

public class SejourLong extends Sejour{

    private int promotion;

    public static final int PROMOTION_EN_POURCENTAGE = 20;

    public SejourLong(Date pDateArrivee, int pNbNuits, Logement pLogement, int pNbVoyageurs) {
        super(pDateArrivee, pNbNuits, pLogement, pNbVoyageurs);
    }

    @Override
    public boolean aUnNombreDeNuitsCorrect() {
        return this.nbNuits >= 6 && this.nbNuits <= 31;
    }

    @Override
    public void afficher() {
        afficherSejour();

        System.out.println("Le prix de ce séjour long est de "+prix+"€ (avec une promotion de "+promotion+"€)");
    }

    @Override
    public void miseAJourDuPrixDuSejour() {
        int prixInitial =  logement.getTarifParNuit()*nbNuits;
        this.promotion = ((logement.getTarifParNuit()*nbNuits)*PROMOTION_EN_POURCENTAGE)/100;
        this.prix = prixInitial - promotion;
    }
}

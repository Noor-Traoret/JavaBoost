package traore.javaboost.reservations;

import traore.javaboost.logements.Logement;

import java.util.Date;

public class SejourLong extends Sejour{
    private int prix;

    private int promotion;

    int PROMOTION_EN_POURCENTAGE = 20;

    public SejourLong(Date pDateArrivee, int pNbNuits, Logement pLogement, int pNbVoyageurs) {
        super(pDateArrivee, pNbNuits, pLogement, pNbVoyageurs);
        this.promotion = ((this.logement.getTarifParNuit()*this.nbNuits)*PROMOTION_EN_POURCENTAGE)/100;
        this.prix = (this.logement.getTarifParNuit()*this.nbNuits) - promotion;

    }

    @Override
    public void afficher() {
        //super.afficher();
        logement.afficher();
        System.out.println(
                "La date d’arrivée est le "+this.dateArrivee+" pour "+this.nbNuits
                        +" nuit"+(nbNuits > 1 ?"s.":".")+"\nLe prix de ce séjour long est de "+prix+"€.(avec une promotion de"+this.promotion+"€)");
    }
}

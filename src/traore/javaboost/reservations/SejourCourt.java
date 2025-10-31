package traore.javaboost.reservations;

import traore.javaboost.logements.Logement;

import java.util.Date;

public class SejourCourt extends Sejour{

    private int prix;
    public SejourCourt(Date pDateArrivee, int pNbNuits, Logement pLogement, int pNbVoyageurs) {
        super(pDateArrivee, pNbNuits, pLogement, pNbVoyageurs);
        //this.prix = pLogement.getTarifParNuit()*pNbNuits;
        this.prix = this.logement.getTarifParNuit()*this.nbNuits;
    }

    /*@Override
    public boolean aUnNombreDeVoyageursCorrect() {
        return super.aUnNombreDeVoyageursCorrect();
    }

    @Override
    public boolean aUnNombreDeNuitsCorrect() {
        return super.aUnNombreDeNuitsCorrect();
    }

    @Override
    public boolean aUneDateArriveeCorrecte() {
        return super.aUneDateArriveeCorrecte();
    }*/

    @Override
    public void afficher() {
        //super.afficher();
        logement.afficher();
        System.out.println(
                "La date d’arrivée est le "+this.dateArrivee+" pour "+this.nbNuits
                        +" nuit"+(nbNuits > 1 ?"s.":".")+"\nLe prix de ce séjour court est de "+this.prix+"€.");
    }
}

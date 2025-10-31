package traore.javaboost.logements;

import traore.javaboost.utilisateurs.Hote;

public class Chalet extends Logement{
    private int altitude;
    public Chalet(String pNom, int pTarifParNuit, String pAdresse, int pSuperficie, int pNbVoyageursMax, Hote pHote, int pAltitude) {
        super(pNom, pTarifParNuit, pAdresse, pSuperficie, pNbVoyageursMax, pHote);
        this.altitude = pAltitude;
    }

    @Override
    public void afficher() {
        getHote().afficher();
        System.out.println("Le chalet ("+super.getNom()+") est situé à  "+super.getAdresse());
        System.out.println("Superficie : "+this.superficie+"m²");
        System.out.println("Altitude : "+this.altitude);

    }
}

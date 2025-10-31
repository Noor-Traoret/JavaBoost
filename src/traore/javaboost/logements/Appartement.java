package traore.javaboost.logements;

import traore.javaboost.utilisateurs.Hote;

public class Appartement extends Logement {
    private int superficieDuBalcon;
    private int numeroEtage;

    public Appartement(String pNom, int pTarifParNuit, String pAdresse, int pSuperficie, int pNbVoyageursMax, Hote pHote, int pSuperficieDuBalcon, int pNumeroEtage){
        super(pNom, pTarifParNuit, pAdresse, pSuperficie, pNbVoyageursMax, pHote);
        this.superficieDuBalcon = pSuperficieDuBalcon;
        this.numeroEtage = pNumeroEtage;
    }

    @Override
    public void afficher() {
        getHote().afficher();
        System.out.println("Le logement ("+super.getNom()+") est situé à  "+super.getAdresse());
        if(this.superficieDuBalcon == 0){
            System.out.println("au rez-de-chaussée.");
        } else if (this.superficieDuBalcon == 1) {
            System.out.println("au 1er étage.");
        }else{
            System.out.println("au "+this.numeroEtage+"ème étage.");
        }
        System.out.println("Superficie : "+this.superficie+"m² \nbalcon : "+(this.superficieDuBalcon > 0 ? "Oui ("+this.superficieDuBalcon+"m²)" : "Non"));
    }
}

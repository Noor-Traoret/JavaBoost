package traore.javaboost.logements;

import traore.javaboost.utilisateurs.Hote;

import java.util.Objects;

public class Maison extends Logement {
    private int superficieDuJardin;
    private boolean possedePiscine;

    public Maison(String pNom, int pTarifParNuit, String pAdresse, int pSuperficie, int pNbVoyageursMax, Hote pHote, int pSuperficieDuJardin, boolean pPossedePiscine) {
        super(pNom, pTarifParNuit, pAdresse, pSuperficie, pNbVoyageursMax, pHote);
        this.superficieDuJardin = pSuperficieDuJardin;
        this.possedePiscine = pPossedePiscine;
    }

    public boolean aUnePiscineInterieur(){
        return this.possedePiscine && superficieDuJardin == 0;
    }

    @Override
    public void afficher() {
        getHote().afficher();
        System.out.println("Le logement ("+super.getNom()+") est situé à  "+super.getAdresse());
        System.out.println("Superficie : "+this.superficie+"m² \nJardin : "+(this.superficieDuJardin > 0 ? "Oui ("+this.superficieDuJardin+"m²)" : "Non")+"\nPiscine : "+(this.possedePiscine ? "Oui" : "Non"));
    }
}

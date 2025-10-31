package traore.javaboost.logements;

import traore.javaboost.utilisateurs.Hote;
import traore.javaboost.utilisateurs.Personne;

/**
 * Class qui définit un logement.
 * @author Traore
 * @version 1.0.0
 */
public abstract class Logement {
    private String nom;
    private int tarifParNuit;
    private String adresse;
    protected int superficie;
    private int nbVoyageursMax;
    private Hote hote;

    /**
     * Constructeur de logement avec cinq paramètres.
     * @param pNom nom du logement
     * @param pTarifParNuit montant de la nuitée
     * @param pAdresse la localisation
     * @param pSuperficie la superficie du logement
     * @param pNbVoyageursMax nombre de personne maximal pour la chambre.
     */
    public Logement(String pNom, int pTarifParNuit, String pAdresse, int pSuperficie, int pNbVoyageursMax, Hote pHote){
        this.nom = pNom;
        this.tarifParNuit = pTarifParNuit;
        this.adresse = pAdresse;
        this.superficie = pSuperficie;
        this.nbVoyageursMax = pNbVoyageursMax;
        this.hote = pHote;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getTarifParNuit() {
        return tarifParNuit;
    }

    public void setTarifParNuit(int tarifParNuit) {
        this.tarifParNuit = tarifParNuit;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public int getNbVoyageursMax() {
        return nbVoyageursMax;
    }

    public void setNbVoyageursMax(int nbVoyageursMax) {
        this.nbVoyageursMax = nbVoyageursMax;
    }

    public Personne getHote() {
        return hote;
    }

    public abstract void afficher();
}

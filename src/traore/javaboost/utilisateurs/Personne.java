package traore.javaboost.utilisateurs;

/**
 * Cette class permet de définir une personne
 * @version 1.0.0
 * @author traore
 * @since 2025
 */
public class Personne {
    private final String nom;
    private final String prenoms;
    private final int age;

    /**
     * Ce constructeur permet d'initialiser une personne en passant en paramètre
     * le nom, le prenom et l'age.
     * @param pNom nom de la personne
     * @param pPrenoms prenoms de la personne
     * @param pAge de la personne
     */
    public Personne(String pNom, String pPrenoms, int pAge){
        this.nom = pNom;
        this.prenoms = pPrenoms;
        this.age = pAge;
    }

    public String getNom() {
        return nom;
    }

    /*public void setNom(String nom) {
        this.nom = nom;
    }*/

    public String getPrenoms() {
        return prenoms;
    }

   /*public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }*/

    public int getAge() {
        return age;
    }

    /*public void setAge(int age) {
        this.age = age;
    }*/

    /**
     * Cette methode affiche les informations d'une personne.
     */
    public void afficher(){
        System.out.print(this.nom+" "+this.prenoms+"("+this.age+")");
    }

    // NB : les attributs sont marqués par le mot clé final et les setters sont tous commentés
    // Afin de transformer les classes Personnes, Voyageur, Hote, Logement, Maison, Appartement
    // et Chalet en des classes immuables.(Aucun changement d'état après initialisation de l'objet).
}

package traore.javaboost.utilisateurs;

public class Hote extends Personne{
    int delaiDeReponse;
    public Hote(String pNom, String pPrenoms, int pAge, int pDelaiDeReponse){
            super(pNom, pPrenoms, pAge);
            this.delaiDeReponse = pDelaiDeReponse;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println(" qui s’engage à répondre dans "+(this.delaiDeReponse > 1 ?"les "+this.delaiDeReponse+" heures":"l’heure."));
    }
}

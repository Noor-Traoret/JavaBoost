package traore.javaboost.data;

import traore.javaboost.logements.Appartement;
import traore.javaboost.logements.Chalet;
import traore.javaboost.logements.Logement;
import traore.javaboost.logements.Maison;
import traore.javaboost.utilisateurs.Hote;

import java.util.ArrayList;

public class JavaBoostData {
    private static JavaBoostData instance = new JavaBoostData();
    private ArrayList<Hote> hotes ;
    private ArrayList<Logement> logements ;

    private JavaBoostData() {
        this.hotes = new ArrayList<>();
        this.logements = new ArrayList<>();

        initData();
    }

    private void initData() {
        Hote hote1 = new Hote("Traore","Noor", 35, 1);
        Hote hote2 = new Hote("Toure","Halima", 25, 1);
        Hote hote3 = new Hote("Kone","Noor", 31, 1);

        hotes.add(hote1);
        hotes.add(hote2);
        hotes.add(hote3);

        Maison maMaison = new Maison("Résidence Fatima", 500, "157 Boulevard de la Liberté, Lille", 200, 5, hote1, 50, false);
        Appartement monAppartement = new Appartement("Alpha", 15, "157 Boulevard de la Liberté, Lille", 50, 2, hote2, 3, 1);
        Chalet monChalet = new Chalet("La madrague", 40, "Bassam", 5, 2, hote3, 10);

        logements.add(maMaison);
        logements.add(monAppartement);
        logements.add(monChalet);
    }

    public ArrayList<Hote> getHotes() {
        return hotes;
    }

    public ArrayList<Logement> getLogements() {
        return logements;
    }

    public static JavaBoostData getInstance() {
        return instance;
    }
}

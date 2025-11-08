package traore.javaboost.data;

import traore.javaboost.logements.Appartement;
import traore.javaboost.logements.Chalet;
import traore.javaboost.logements.Logement;
import traore.javaboost.logements.Maison;
import traore.javaboost.utilisateurs.Hote;
import traore.javaboost.utilitaires.LogementsXMLParser;

import java.util.ArrayList;

/**
 * Classe singleton représentant les données de l'application JavaBoost.
 * <p>
 * Cette classe initialise et stocke une liste d'hôtes ({@link Hote}) ainsi qu'une
 * liste de logements ({@link Logement}). Elle fournit un accès global à ces données
 * via une instance unique accessible par la méthode {@link #getInstance()}.
 * </p>
 *
 * <p>
 * Les données sont initialisées dans la méthode privée {@link #initDataDepuisLeFichierXML()} qui crée
 * quelques exemples d'hôtes et de logements (Maison, Appartement, Chalet).
 * </p>
 *
 * @author Noor traoret
 * @version 1.0
 */
public class JavaBoostData {
    private static JavaBoostData instance = new JavaBoostData();
    private ArrayList<Hote> hotes ;
    private ArrayList<Logement> logements ;

    /**
     * Constructeur privé afin d'empêcher l'instanciation externe.
     * <p>
     * Initialise les listes d'hôtes et de logements, puis appelle {@link #initDataDepuisLeFichierXML()}
     * pour peupler les données par défaut.
     * </p>
     */
    private JavaBoostData() {
        this.hotes = new ArrayList<>();
        this.logements = new ArrayList<>();

        //initData();

        initDataDepuisLeFichierXML();
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


    /**
     * Initialise les données de démonstration de l'application.
     * <p>
     * Crée plusieurs instances de {@link Hote} et de {@link Logement} (dont
     * {@link Maison}, {@link Appartement}, et {@link Chalet}) et les ajoute
     * aux listes correspondantes.
     * </p>
     */
    private void initDataDepuisLeFichierXML() {

        String xmlPath = "res/logements.xml";

        try {
            LogementsXMLParser.parserFichier(xmlPath, hotes, logements);
            System.out.println("Nombre d'hôtes uniques : " + hotes.size());
            System.out.println("Nombre de logements : " + logements.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Hote> getHotes() {
        return hotes;
    }

    public ArrayList<Logement> getLogements() {
        return logements;
    }

    /**
     * Retourne l'instance unique de la classe.
     *
     * @return l'instance singleton de {@code JavaBoostData}
     */
    public static JavaBoostData getInstance() {
        return instance;
    }
}

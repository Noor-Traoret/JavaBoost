package traore.javaboost.utilitaires;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import traore.javaboost.logements.Appartement;
import traore.javaboost.logements.Logement;
import traore.javaboost.logements.Maison;
import traore.javaboost.utilisateurs.Hote;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe utilitaire permettant d'analyser un fichier XML contenant des données
 * relatives à des logements (Appartements et Maisons) ainsi qu'à leurs hôtes.
 *
 * <p>Cette classe fournit une méthode principale {@link #parserFichier(String, ArrayList, ArrayList)}
 * permettant d'extraire, à partir d'un fichier XML structuré, l'ensemble des informations
 * nécessaires à la création d'objets métiers {@link Hote}, {@link Appartement} et {@link Maison}.
 *
 * <p>Les hôtes présents dans le fichier sont indexés par une clé unique (nom + prénom + âge) afin
 * d'éviter les doublons lors de l'import. Les logements sont ensuite liés à leur hôte respectif
 * puis ajoutés à la liste de logements fournie.</p>
 *
 * <p>Cette classe ne stocke aucun état interne : les données extraites sont directement injectées
 * dans les listes fournies en paramètres.</p>
 *
 * <h3>Utilisation</h3>
 * <pre>
 *     LogementsXMLParser parser = new LogementsXMLParser();
 *     parser.parserFichier("logements.xml", listeHotes, listeLogements);
 * </pre>
 *
 * @see Hote
 * @see Appartement
 * @see Maison
 */
public class LogementsXMLParser {

    /**
     * Constructeur privé empêchant l'instanciation de la classe.
     *
     * <p>Cette classe est conçue pour être utilisée uniquement via ses méthodes
     * statiques ou utilitaires. Toute tentative d'instanciation déclenche une
     * {@link UnsupportedOperationException}.</p>
     *
     * @throws UnsupportedOperationException Toujours levée afin d'empêcher l'instanciation.
     */
    private LogementsXMLParser(){
        throw new UnsupportedOperationException();
    }

    /**
     * Parse un fichier XML contenant des informations sur des logements (Appartements et Maisons)
     * ainsi que leurs hôtes, puis remplit les listes passées en paramètres.
     *
     * <p>Le fichier XML doit contenir des balises <Appartement> et <Maison>. Chaque logement possède
     * un hôte décrit par une balise <hote>. Afin d'éviter la création de doublons, les hôtes sont
     * indexés selon une clé unique construite à partir de leur nom, prénom et âge.</p>
     *
     * <p>Les objets extraits sont ensuite ajoutés :
     * <ul>
     *     <li>À la liste {@code hotes} pour les hôtes</li>
     *     <li>À la liste {@code logements} pour les logements (Appartements et Maisons)</li>
     * </ul>
     * </p>
     *
     * @param cheminFichier    Chemin absolu ou relatif du fichier XML à parser.
     * @param hotes            Liste devant contenir les objets {@link Hote} extraits du fichier.
     *                         Les hôtes déjà existants ne seront pas dupliqués.
     * @param logements        Liste devant contenir les logements extraits ({@link Appartement} ou {@link Maison}).
     *
     * @throws Exception       Si le fichier est introuvable, mal formé ou si une erreur survient lors du parsing XML.
     */
    public static void parserFichier(String cheminFichier, ArrayList<Hote> hotes, ArrayList<Logement> logements) throws Exception {
        // Création du parser XML
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Chargement et parsing du fichier XML
        Document document = builder.parse(new File(cheminFichier));
        document.getDocumentElement().normalize();

        // Map pour éviter les doublons d'hôtes (clé = nom complet)
        Map<String, Hote> mapHotes = new HashMap<>();

        // Parser les appartements
        NodeList listeAppartements = document.getElementsByTagName("Appartement");
        for (int i = 0; i < listeAppartements.getLength(); i++) {
            Node noeudAppartement = listeAppartements.item(i);

            if (noeudAppartement.getNodeType() == Node.ELEMENT_NODE) {
                Element elementAppartement = (Element) noeudAppartement;

                // Extraction de l'hôte (imbriqué dans l'appartement)
                NodeList listeHotesElement = elementAppartement.getElementsByTagName("hote");
                Hote hote = null;

                if (listeHotesElement.getLength() > 0) {
                    Element elementHote = (Element) listeHotesElement.item(0);
                    String nom = getValeurElement(elementHote, "nom");
                    String prenom = getValeurElement(elementHote, "prenom");
                    int age = Integer.parseInt(getValeurElement(elementHote, "age"));
                    int delaiReponse = Integer.parseInt(getValeurElement(elementHote, "delaiReponse"));

                    // Créer une clé unique pour l'hôte
                    String cleHote = nom + "_" + prenom + "_" + age;

                    // Vérifier si l'hôte existe déjà
                    if (!mapHotes.containsKey(cleHote)) {
                        hote = new Hote(nom, prenom, age, delaiReponse);
                        mapHotes.put(cleHote, hote);
                        hotes.add(hote);
                    } else {
                        hote = mapHotes.get(cleHote);
                    }
                }

                // Extraction des données de l'appartement
                String nom = elementAppartement.getAttribute("name");
                int tarifParNuit = Integer.parseInt(getValeurElement(elementAppartement, "tarifParNuit"));
                String adresse = getValeurElement(elementAppartement, "adresse");
                int superficie = Integer.parseInt(getValeurElement(elementAppartement, "superficie"));
                int nbVoyageursMax = Integer.parseInt(getValeurElement(elementAppartement, "nbVoyageursMax"));
                int numeroEtage = Integer.parseInt(getValeurElement(elementAppartement, "numeroEtage"));
                int superficieBalcon = Integer.parseInt(getValeurElement(elementAppartement, "superficieBalcon"));

                // Création et ajout de l'appartement
                Appartement appartement = new Appartement(nom, tarifParNuit, adresse, superficie, nbVoyageursMax, hote, numeroEtage, superficieBalcon);
                logements.add(appartement);
            }
        }

        // Parser les maisons
        NodeList listeMaisons = document.getElementsByTagName("Maison");
        for (int i = 0; i < listeMaisons.getLength(); i++) {
            Node noeudMaison = listeMaisons.item(i);

            if (noeudMaison.getNodeType() == Node.ELEMENT_NODE) {
                Element elementMaison = (Element) noeudMaison;

                // Extraction de l'hôte (imbriqué dans la maison)
                NodeList listeHotesElement = elementMaison.getElementsByTagName("hote");
                Hote hote = null;

                if (listeHotesElement.getLength() > 0) {
                    Element elementHote = (Element) listeHotesElement.item(0);
                    String nom = getValeurElement(elementHote, "nom");
                    String prenom = getValeurElement(elementHote, "prenom");
                    int age = Integer.parseInt(getValeurElement(elementHote, "age"));
                    int delaiReponse = Integer.parseInt(getValeurElement(elementHote, "delaiReponse"));

                    // Créer une clé unique pour l'hôte
                    String cleHote = nom + "_" + prenom + "_" + age;

                    // Vérifier si l'hôte existe déjà
                    if (!mapHotes.containsKey(cleHote)) {
                        hote = new Hote(nom, prenom, age, delaiReponse);
                        mapHotes.put(cleHote, hote);
                        hotes.add(hote);
                    } else {
                        hote = mapHotes.get(cleHote);
                    }
                }

                // Extraction des données de la maison
                String nom = elementMaison.getAttribute("name");
                int tarifParNuit = Integer.parseInt(getValeurElement(elementMaison, "tarifParNuit"));
                String adresse = getValeurElement(elementMaison, "adresse");
                int superficie = Integer.parseInt(getValeurElement(elementMaison, "superficie"));
                int nbVoyageursMax = Integer.parseInt(getValeurElement(elementMaison, "nbVoyageursMax"));
                int superficieJardin = Integer.parseInt(getValeurElement(elementMaison, "superficieJardin"));
                boolean possedePiscine = getValeurElement(elementMaison, "possedePiscine").equals("1");

                // Création et ajout de la maison
                Maison maison = new Maison(nom, tarifParNuit, adresse, superficie, nbVoyageursMax, hote, superficieJardin, possedePiscine);
                logements.add(maison);
            }
        }
    }

    /**
     * Récupère la valeur textuelle d'une balise enfant dans un élément XML donné.
     *
     * <p>La méthode recherche la première occurrence d'une balise portant le nom spécifié,
     * puis retourne sa valeur textuelle si elle existe. Si la balise est absente ou vide,
     * une chaîne vide est renvoyée.</p>
     *
     * @param element   Élément XML parent dans lequel chercher la balise.
     * @param nomBalise Nom de la balise enfant dont on souhaite extraire la valeur.
     * @return La valeur textuelle de la balise trouvée, ou une chaîne vide si la balise
     *         n'existe pas ou ne contient pas de texte.
     */
    private static String getValeurElement(Element element, String nomBalise) {
        NodeList nodeList = element.getElementsByTagName(nomBalise);
        if (nodeList.getLength() > 0) {
            Node node = nodeList.item(0);
            if (node != null && node.getFirstChild() != null) {
                return node.getFirstChild().getNodeValue();
            }
        }
        return "";
    }

}


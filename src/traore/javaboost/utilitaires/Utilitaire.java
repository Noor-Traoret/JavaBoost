package traore.javaboost.utilitaires;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilitaire {
    /**
     * Ce constructeur à la visibilité private permet de ne pas pouvoir créer
     * une instance de cette classe.
     */
    private Utilitaire() {
    }

    /**
     * Cette methode permet de creer un objet date en lui passant en paramètre
     * des entiers.
     * @param day le jour : valeur entre 1-31
     * @param month le mois : valeur entre 0-11
     * @param year l'année : valeur ex 2024
     */
    public static Date creerDate(int day, int month, int year){
        Date maDate = new Date(year-1900, month-1, day);
        return maDate;
    }

    /**
     * Cette methode permet de formater une date
     * @param date la date à formater.
     * @return la date sous le format "jj/mm/aaaa".
     */
    public static StringBuilder formatDate(Date date){
        StringBuilder stringBuilder = new StringBuilder();
        if(date.getDate()<10)stringBuilder.append("0");
        stringBuilder.append(date.getDate()+"/");
        if((date.getMonth()+1)<10)stringBuilder.append("0");
        stringBuilder.append((date.getMonth()+1)+"/");
        stringBuilder.append(date.getYear()+1900);
        //return (date.getDate() < 10?"0":"")+date.getDate()+"/"+(date.getMonth() < 9?"0":"")+(date.getMonth()+1)+"/"+(date.getYear()+1900);
        return stringBuilder;
    }

    /**
     * Demande à l'utilisateur de saisir une valeur entière comprise entre une borne minimale et une borne maximale.
     * <p>
     * Cette méthode affiche une invite dans la console demandant une valeur pour une variable spécifique.
     * Elle vérifie que la valeur saisie est bien un entier et qu'elle se situe dans l'intervalle donné
     * (inclusivement). Tant qu'une valeur incorrecte est saisie (non entière ou hors bornes),
     * la saisie est redemandée.
     * Une fois une valeur valide entrée, elle est retournée.
     * </p>
     *
     * @param nomDeLaVariable le nom de la variable pour laquelle la saisie est demandée (actuellement non utilisé
     * dans l'affichage, mais utile pour une future personnalisation du message.)
     * @param valeurMin la valeur minimale autorisée (incluse)
     * @param valeurMax la valeur maximale autorisée (incluse)
     * @return la valeur entière saisie par l'utilisateur, garantie d'être comprise entre {@code valeurMin} et {@code valeurMax}
     *
     * @throws IllegalArgumentException si {@code valeurMin} est supérieur à {@code valeurMax}
     *
     * @example
     * <pre>
     * int nombreDeNuits = choix("nombreDeNuits", 1, 10);
     * </pre>
     *
     * @author [Traore nouhou]
     * @version 1.0
     */
    public static int choix(String nomDeLaVariable, int valeurMin, int valeurMax){
        Scanner scr = new Scanner(System.in);

        int valeurSaisie = 0 ;

        boolean choixCorrect = false;

        do{
            System.out.print("Saisir une valeur pour le nombre de nuits entre "+valeurMin+" et "+valeurMax+" : ");

            try {
                valeurSaisie = scr.nextInt();

                if(valeurSaisie < valeurMin || valeurSaisie > valeurMax){
                    System.out.println("Attention la valeur n’est pas entre "+valeurMin+" et "+valeurMax+" : ");
                }else{
                    choixCorrect = true;
                    scr.close();
                }
            } catch (InputMismatchException e) {
                System.out.println("Attention la valeur oups... n’est pas un entier. ");
                String error = scr.next();
            }
        } while (!choixCorrect);

        System.out.println("Ok on part pour "+valeurSaisie+" nuits !!");
        return valeurSaisie;
    }

    /**
     * Vérifie si une date donnée correspond à un vendredi postérieur à la date actuelle.
     * <p>
     * Cette méthode convertit un objet {@link java.util.Date} en {@link java.time.LocalDate}
     * en utilisant le fuseau horaire du système.
     * Elle renvoie {@code true} si la date correspond à un vendredi et se situe
     * strictement après la date du jour, sinon {@code false}.
     * </p>
     *
     * @param dateArrivee la date à vérifier (non {@code null})
     * @return {@code true} si {@code dateArrivee} est un vendredi futur,
     *         sinon {@code false}
     *
     * @throws NullPointerException si {@code dateArrivee} est {@code null}
     *
     * @see java.time.LocalDate
     * @see java.time.DayOfWeek
     * @see java.util.Date
     *
     * @author [Traore nouhou]
     */
    public static boolean verifDayOfWeek(Date dateArrivee){
        LocalDate arrival = dateArrivee.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return arrival.isAfter(LocalDate.now()) && arrival.getDayOfWeek() == DayOfWeek.FRIDAY;
    }
}

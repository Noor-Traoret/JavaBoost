package traore.javaboost.utilitaires;

import java.lang.annotation.AnnotationTypeMismatchException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

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
     * @return
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
     *
     * @param nomDeLaVariable correspondant au nom de la variable à initialiser (ça sera utile pour l’affichage)
     * @param valeurMin correspondant à la valeur du choix minimum possible.
     * @param valeurMax correspondant à la valeur du choix maximum possible.
     * @return retourne un entier si celui-ci est compris entre valeurMin et valeurMax
     * @throws Exception Si la valeur saisir n'est pas un entier
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
                }
            } catch (InputMismatchException e) {
                System.out.println("Attention la valeur oups... n’est pas un entier. ");
            }
        } while (!choixCorrect);

        System.out.println("Ok on part pour "+valeurSaisie+" nuits !!");
        return valeurSaisie;
    }
}

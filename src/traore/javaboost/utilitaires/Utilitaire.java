package traore.javaboost.utilitaires;

import java.util.Date;
import java.util.Objects;

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
}

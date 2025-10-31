package traore.javaboost.utilitaires;

import java.util.Date;

public class MaDate extends Date {


    public MaDate() {
        super();
    }

    public MaDate(int day, int month, int year) {
        super(year-1900, month-1, day);
    }


    /**
     * Cette méthode rédéfinie par héritage permet de formater la date sous le format
     * jj/mm/aaaa ie 15/10/2025
     * @return
     */
   @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if(this.getDate()<10)stringBuilder.append("0");
        stringBuilder.append(this.getDate()+"/");
        if((this.getMonth()+1)<10)stringBuilder.append("0");
        stringBuilder.append((this.getMonth()+1)+"/");
        stringBuilder.append(this.getYear()+1900);
        return stringBuilder.toString();
    }
}

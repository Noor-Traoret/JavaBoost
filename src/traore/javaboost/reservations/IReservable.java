package traore.javaboost.reservations;

public interface IReservable {

    boolean aUneDateArriveeCorrecte();

    boolean aUnNombreDeNuitsCorrect();

    boolean aUnNombreDeVoyageursCorrect();

    void afficher();
}

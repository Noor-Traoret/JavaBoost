package traore.javaboost.data;

public  class Recherche {

    public static final int NE_SE_PRONONCE_PAS = 0;
    public static final int OUI = 1;
    public static final int NON = 2;
    private final int nbVoyageurs;      //: Attribut obligatoire : le nombre de voyageurs.

    private final int tarifMinParNuit;  //: int - Attribut optionnel : le tarif minimum pour une nuit.

    private final int tarifMaxParNuit;  //: int - Attribut optionnel : le tarif maximum pour une nuit.

    private final int possedePiscine ;  //: int - Attribut optionnel : information si on souhaite une piscine dans le logement.

    private Recherche(Builder builder) {
        this.nbVoyageurs = builder.nbVoyageurBuilder;
        this.tarifMinParNuit = builder.tarifMinParNuitBuilder;
        this.tarifMaxParNuit = builder.tarifMaxParNuitBuilder;
        this.possedePiscine = builder.possedePiscineBuilder;
    }

    public void resultat(){}

    public static class Builder{

        private int nbVoyageurBuilder;
        private int tarifMinParNuitBuilder;
        private int tarifMaxParNuitBuilder;
        private int possedePiscineBuilder;


        public Builder(int nbVoyageurs) {
            nbVoyageurBuilder = nbVoyageurs;
            tarifMaxParNuitBuilder = Integer.MAX_VALUE;
            tarifMinParNuitBuilder = 0;
            possedePiscineBuilder = NE_SE_PRONONCE_PAS;

        }

        public Builder tarifMin(int tarifMin) {
            tarifMinParNuitBuilder = tarifMin;
            return this;
        }

        public Builder tarifMax(int tarifMax) {
            tarifMaxParNuitBuilder = tarifMax;
            return this;
        }

        public Builder possedePiscine(boolean pPossedePiscine) {
            possedePiscineBuilder = pPossedePiscine ? OUI : NON;
            return this;
        }

        public Recherche build(){
            return new Recherche(this);
        }
    }

    @Override
    public String toString() {
        return "Recherche{" +
                "nbVoyageurs=" + nbVoyageurs +
                ", tarifMinParNuit=" + tarifMinParNuit +
                ", tarifMaxParNuit=" + tarifMaxParNuit +
                ", possedePiscine=" + possedePiscine +
                '}';
    }
}

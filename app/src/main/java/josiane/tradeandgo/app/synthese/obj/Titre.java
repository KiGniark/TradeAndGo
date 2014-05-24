package josiane.tradeandgo.app.synthese.obj;

/**
 * Created by christelle on 23/05/2014.
 */
public class Titre {
    private String code;
    private double valeur;
    private double variation;

    public Titre(String acode, double avaleur, double avar){
        code = acode;
        valeur = avaleur;
        variation = avar;

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(float valeur) {
        this.valeur = valeur;
    }

    public double getVariation() {
        return variation;
    }

    public void setVariation(float variation) {
        this.variation = variation;
    }
}

package josiane.tradeandgo.app.synthese.obj;

/**
 * Created by christelle on 23/05/2014.
 */
public class Titre {
    private String code;
    private float valeur;
    private float variation;

    public Titre(String acode, float avaleur, float avar){
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

    public float getValeur() {
        return valeur;
    }

    public void setValeur(float valeur) {
        this.valeur = valeur;
    }

    public float getVariation() {
        return variation;
    }

    public void setVariation(float variation) {
        this.variation = variation;
    }
}

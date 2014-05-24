package josiane.tradeandgo.app.synthese.obj;

import josiane.tradeandgo.app.R;
import josiane.tradeandgo.app.util.data.titre.TypeTitre;

/**
 * Created by christelle on 23/05/2014.
 */
public class Titre {
    private String code;
    private double valeur;
    private double variation;
    private TypeTitre typeVariation;

    public Titre(String acode, double avaleur, float avar, TypeTitre typeVariation){
        this.code = acode;
        this.valeur = avaleur;
        this.variation = avar;
        this.typeVariation = typeVariation;
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

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public double getVariation() {
        return variation;
    }

    public void setVariation(double variation) {
        this.variation = variation;
    }

    public TypeTitre getTypeVariation() {
        return typeVariation;
    }

    public void setTypeVariation(TypeTitre typeVariation) {
        this.typeVariation = typeVariation;
    }

    public int getHumeur() {
        if (variation>0){
            return R.drawable.sun;
        }else if(variation<0){
            return R.drawable.sun;
        }
        return R.drawable.sun;
    }
}

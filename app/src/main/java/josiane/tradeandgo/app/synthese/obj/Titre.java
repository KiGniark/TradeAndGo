package josiane.tradeandgo.app.synthese.obj;

import java.util.Random;

import josiane.tradeandgo.app.R;
import josiane.tradeandgo.app.util.data.titre.TypeTitre;

/**
 * Created by christelle on 23/05/2014.
 */
public class Titre {
    private String code;
    private String nomValeur;
    private double valeur;
    private double variation;
    private TypeTitre typeVariation;
    private long nombre = Math.round(Math.random()*20);
    private long quantite = Math.round(Math.random()*400);

    public Titre(String acode, double avaleur, double avar, TypeTitre typeVariation){
        this(acode,avaleur,avar);
        this.typeVariation = typeVariation;
    }
// TO REMOVE
    public Titre(String acode, double avaleur, double avar){
        this.code = acode;
        this.valeur = avaleur;
        this.variation = avar;
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

    public long getNombre() {
        return nombre;
    }

    public void setNombre(long nombre) {
        this.nombre = nombre;
    }

    public long getQuantite() {
        return quantite;
    }

    public void setQuantite(long quantite) {
        this.quantite = quantite;
    }

}

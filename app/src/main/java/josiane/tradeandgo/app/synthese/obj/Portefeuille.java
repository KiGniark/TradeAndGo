package josiane.tradeandgo.app.synthese.obj;
import android.content.Context;

import java.util.ArrayList;

import josiane.tradeandgo.app.synthese.obj.Titre;
import josiane.tradeandgo.app.synthese.view.TitreCard;

/**
 * Created by christelle on 23/05/2014.
 */
public class Portefeuille {
    private ArrayList<Titre> mTitre;
    private String nom;


    public Portefeuille(String anom, ArrayList<Titre> titres){
        nom = anom;
        mTitre = titres;
    }

    public ArrayList<Titre> getTitre() {
        return mTitre;
    }

    public void setmTitre(ArrayList<Titre> mTitre) {
        this.mTitre = mTitre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

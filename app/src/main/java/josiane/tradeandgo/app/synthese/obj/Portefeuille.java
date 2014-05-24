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
    private ArrayList<TitreCard> mCards;
    private String nom;
    private int code;


    public Portefeuille(final Context context, String anom, ArrayList<Titre> titres){
        nom = anom;
        mTitre = titres;
    }

    private void createCards(Context context){
        mCards = new ArrayList<TitreCard>();
        for (int i=0; i < mTitre.size();i++)
            mCards.add(new TitreCard(context, mTitre.get(i)));
    }

    public int getCode() {
        return code;
    }
}

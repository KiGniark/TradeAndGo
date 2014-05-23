package josiane.tradeandgo.app.synthese.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import josiane.tradeandgo.app.R;
import josiane.tradeandgo.app.synthese.obj.Portefeuille;
import josiane.tradeandgo.app.synthese.obj.Titre;

/**
 * Created by christelle on 23/05/2014.
 */
public class PortefeuilleCard extends FrameLayout {

    public PortefeuilleCard(final Context context, Portefeuille portefeuille) {
        super(context);
        initView(context, portefeuille);
    }

    private void initView(final Context context, Portefeuille portefeuille){
        View view = LayoutInflater.from(context).inflate(R.layout.portefeuille_layout, null);
        ((TextView)view.findViewById(R.id.portefeuille_name)).setText(portefeuille.getCode());
        // Nuage
        // Variation
        //Valeur
        this.addView(view);
    }
}

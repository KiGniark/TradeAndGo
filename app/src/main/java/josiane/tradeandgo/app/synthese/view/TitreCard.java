package josiane.tradeandgo.app.synthese.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import josiane.tradeandgo.app.R;
import josiane.tradeandgo.app.synthese.obj.Titre;

/**
 * Created by christelle on 23/05/2014.
 */
public class TitreCard extends FrameLayout {


    /**
     *  Ctor
     */
    public TitreCard (final Context context, Titre titre){
        super(context);
        initView(context, titre);

    }

    private void initView(final Context context, Titre titre){
        View view = LayoutInflater.from(context).inflate(R.layout.activity_information, null);
        ((TextView)view.findViewById(R.id.info_nomTitre)).setText(titre.getCode());

        ((TextView)view.findViewById(R.id.info_variationTitre)).setText(""+titre.getVariation());
        ((TextView)view.findViewById(R.id.info_valeurTitre)).setText(""+titre.getValeur());
        this.addView(view);
    }
}


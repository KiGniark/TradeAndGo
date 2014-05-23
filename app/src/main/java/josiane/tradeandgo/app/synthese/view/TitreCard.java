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
        View view = LayoutInflater.from(context).inflate(R.layout.titre_layout, null);
        ((TextView)view.findViewById(R.id.title_name)).setText(titre.getCode());
        // Nuage
        // Variation
        //Valeur
        this.addView(view);
    }
}
}

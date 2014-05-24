package josiane.tradeandgo.app.info.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import josiane.tradeandgo.app.R;
import josiane.tradeandgo.app.synthese.obj.Titre;

/**
 * Created by Kevin on 24/05/2014.
 */
public class InfoTitre extends FrameLayout{
    public InfoTitre(Context context, Titre titre) {
        super(context);
        initView(context, titre);
        this.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                tappedCard();
            }
        });
    }

    private void initView(final Context context, Titre titre){
        View view = LayoutInflater.from(context).inflate(R.layout.activity_information, null);
        ((TextView)view.findViewById(R.id.info_nomTitre)).setText(titre.getCode());
        ((ImageView)view.findViewById(R.id.info_humeur)).setImageResource(titre.getHumeur());
        ((TextView)view.findViewById(R.id.info_valeurTitre)).setText(titre.getCode());
        ((TextView)view.findViewById(R.id.info_variationTitre)).setText(titre.getCode());
        this.addView(view);
    }
}

package josiane.tradeandgo.app.detail.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import josiane.tradeandgo.app.synthese.obj.Titre;

/**
 * Created by Kevin on 24/05/2014.
 */
public class Cell extends TextView {

    public Cell(Context context, String titre) {
        super(context);
        setText(titre);
    }
}

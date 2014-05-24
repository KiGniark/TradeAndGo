package josiane.tradeandgo.app.detail.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Kevin on 24/05/2014.
 */
public class ColumnHeader extends TextView {

    public ColumnHeader(Context context, String titre) {
        super(context);
        setText(titre);

    }
}

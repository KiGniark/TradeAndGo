package josiane.tradeandgo.app.synthese.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import josiane.tradeandgo.app.R;
import josiane.tradeandgo.app.synthese.obj.Portefeuille;

/**
 * Created by christelle on 24/05/2014.
 */
public class NotificationCard extends FrameLayout {

    public NotificationCard(Context context) {
        super(context);
        initView(context);
    }

    private void initView(final Context context){
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.layout);
        for (int i=0; i<5; i++) {
            View viewNotif = LayoutInflater.from(context).inflate(R.layout.notif_item, null);
            ((TextView) viewNotif.findViewById(R.id.notif_name)).setText("Notif "+i);
            linearLayout.addView(viewNotif);
        }
        View view = LayoutInflater.from(context).inflate(R.layout.notif_layout, null);
        this.addView(view);
    }
}

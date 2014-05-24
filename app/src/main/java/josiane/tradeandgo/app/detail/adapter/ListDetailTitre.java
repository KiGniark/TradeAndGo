package josiane.tradeandgo.app.detail.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.google.android.glass.widget.CardScrollAdapter;

import java.util.List;

import josiane.tradeandgo.app.info.view.InfoTitre;

/**
 * Created by Kevin on 24/05/2014.
 */
public class ListDetailTitre extends CardScrollAdapter {
    List<FrameLayout> details;

    public ListDetailTitre(List<FrameLayout> details) {
        this.details = details;
    }

    @Override
    public int getCount() {
        return details.size();
    }

    @Override
    public Object getItem(int i) {
        return details.get(i);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return details.get(i);
    }

    @Override
    public int getPosition(Object o) {
        return details.indexOf(o);
    }
}

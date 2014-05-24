package josiane.tradeandgo.app.detail.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.google.android.glass.widget.CardScrollAdapter;

import java.util.List;

import josiane.tradeandgo.app.info.view.InfoTitre;

/**
 * Created by Kevin on 24/05/2014.
 */
public class ListDetailTitre extends CardScrollAdapter {
    List<InfoTitre> titres;

    public ListDetailTitre(List<InfoTitre> titres) {
        this.titres = titres;
    }

    @Override
    public int getCount() {
        return titres.size();
    }

    @Override
    public Object getItem(int i) {
        return titres.get(i);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return titres.get(i);
    }

    @Override
    public int getPosition(Object o) {
        return titres.indexOf(o);
    }
}

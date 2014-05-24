package josiane.tradeandgo.app.info.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.google.android.glass.widget.CardScrollAdapter;

import java.util.ArrayList;
import java.util.List;

import josiane.tradeandgo.app.info.view.InfoTitre;

/**
 * Created by Kevin on 24/05/2014.
 */
public class ListInfoTitre extends CardScrollAdapter {
    List<InfoTitre> titres;

    public ListInfoTitre(List<InfoTitre> titres) {
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

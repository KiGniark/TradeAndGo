package josiane.tradeandgo.app.synthese.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollAdapter;

import java.util.ArrayList;

/**
 * Created by christelle on 23/05/2014.
 */
public class CustomScrollAdapter extends CardScrollAdapter {

    private ArrayList<FrameLayout> mCards = null;

    public CustomScrollAdapter(final ArrayList<FrameLayout> cards){
        this.mCards = cards;
    }

    @Override
    public int getPosition(Object item) {
        return mCards.indexOf(item);
    }

    @Override
    public int getCount() {
        if(mCards == null)
            return 0;
        return mCards.size();
    }

    @Override
    public Object getItem(int position) {
        return mCards.get(position);
    }

    /**
     * Returns the amount of view types.
     */
    @Override
    public int getViewTypeCount() {
        return Card.getViewTypeCount();
    }

    /**
     * Returns the view type of this card so the system can figure out
     * if it can be recycled.
     */
    @Override
    public int getItemViewType(int position){
        return 1;
    }

    @Override
    public View getView(int position, View convertView,
                        ViewGroup parent) {
        return  mCards.get(position);
    }
}

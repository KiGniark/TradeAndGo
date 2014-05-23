package josiane.tradeandgo.app.synthese;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.glass.widget.CardScrollView;

import java.util.ArrayList;

import josiane.tradeandgo.app.R;
import josiane.tradeandgo.app.synthese.adapter.CustomScrollAdapter;

/**
 * Created by Kevin on 23/05/2014.
 */
public class Synthese extends Activity{

    private ArrayList<FrameLayout> mCards;
    private CardScrollView mCardScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_synthese);
        createCards();

        mCardScrollView = new CardScrollView(this);
        CustomScrollAdapter adapter = new CustomScrollAdapter(mCards);
        mCardScrollView.setAdapter(adapter);
        mCardScrollView.activate();
        setContentView(mCardScrollView);
    }

    private void createCards() {
        mCards = new ArrayList<FrameLayout>();

        mCards.add(new CustomCard(this, R.drawable.cantine, R.string.sponsor_cantine));
        mCards.add(new CustomCard(this, R.drawable.arkea, R.string.sponsor_arkea));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.synthese, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

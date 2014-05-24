package josiane.tradeandgo.app.info;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.glass.widget.CardScrollView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import josiane.tradeandgo.app.R;
import josiane.tradeandgo.app.info.adapter.ListInfoTitre;
import josiane.tradeandgo.app.info.view.InfoTitre;
import josiane.tradeandgo.app.synthese.adapter.CustomScrollAdapter;
import josiane.tradeandgo.app.util.data.titre.TitreManager;

/**
 * Created by Kevin on 23/05/2014.
 */
public class Information extends Activity {

    private List<InfoTitre> mCards = new ArrayList<InfoTitre>();
    private CardScrollView mCardScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        createInfoTitre();

        mCardScrollView = new CardScrollView(this);
        ListInfoTitre adapter = new ListInfoTitre(mCards);
        mCardScrollView.setAdapter(adapter);
        mCardScrollView.activate();
        setContentView(mCardScrollView);


        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                int next = mCardScrollView.getSelectedItemPosition()+1;
                int size = mCards.size();
                if(next>size){
                    next = 0;
                }
                mCardScrollView.setSelection(next);
            }
        };
        timer.schedule(task,2000,2000);
    }

    private void createInfoTitre() {
        mCards.add(new InfoTitre(this, TitreManager.getInstance().getTitre("ACCOR")));
        mCards.add(new InfoTitre(this, TitreManager.getInstance().getTitre("ALU")));
        mCards.add(new InfoTitre(this, TitreManager.getInstance().getTitre("CAC 40")));
        mCards.add(new InfoTitre(this, TitreManager.getInstance().getTitre("SODA")));
        mCards.add(new InfoTitre(this, TitreManager.getInstance().getTitre("GOOG")));
        mCards.add(new InfoTitre(this, TitreManager.getInstance().getTitre("ARK")));
        mCards.add(new InfoTitre(this, TitreManager.getInstance().getTitre("GEEK")));
        mCards.add(new InfoTitre(this, TitreManager.getInstance().getTitre("MSC")));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
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

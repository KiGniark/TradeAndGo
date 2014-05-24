package josiane.tradeandgo.app.synthese;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollView;

import java.util.ArrayList;

import josiane.tradeandgo.app.R;
import josiane.tradeandgo.app.info.Information;
import josiane.tradeandgo.app.synthese.adapter.CustomScrollAdapter;
import josiane.tradeandgo.app.synthese.obj.Portefeuille;
import josiane.tradeandgo.app.synthese.obj.Titre;
import josiane.tradeandgo.app.synthese.rss.RSSListActivity;
import josiane.tradeandgo.app.synthese.view.NotificationCard;
import josiane.tradeandgo.app.synthese.view.PortefeuilleCard;
import josiane.tradeandgo.app.synthese.view.TitreCard;

/**
 * Created by Kevin on 23/05/2014.
 */
public class Synthese extends Activity{
private final int PORT_REEL = 0;
    private final int PORT_VIRTUEL = 1;
    private ArrayList<FrameLayout> mCards;
    private ArrayList<FrameLayout> tCards;
    private CardScrollView mCardScrollView;
    Portefeuille portReel;
    Portefeuille portVirtuel;
    Intent rssIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rssIntent = new Intent(getBaseContext(), RSSListActivity.class);
        startActivity(rssIntent);

        createPortefeuilleCards();

        mCardScrollView = new CardScrollView(this);
        CustomScrollAdapter adapter = new CustomScrollAdapter(mCards);
        mCardScrollView.setAdapter(adapter);
        mCardScrollView.activate();
        setContentView(mCardScrollView);
        mCardScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tappedCard();
            }
        });
    }

/*
* Crée les 2 portefeuilles contenant qq titres
 */

    private void createPortefeuilleCards() {

        //Titres reels
        ArrayList<Titre> al = new ArrayList<Titre>();
        Titre titre1 = new Titre("ALU", 10.5, 1.2);
        al.add(titre1);
        Titre titre2 = new Titre("EXP", 11.5, 15.2);
        al.add(titre2);
        portReel = new Portefeuille("Votre portefeuille réel", al);

        //Titres virtuels

        al = new ArrayList<Titre>();
        titre1 = new Titre("TRUC1", 10.5, 1.2);
        al.add(titre1);
        titre2 = new Titre("TRUC2", 11.5, 15.2);
        al.add(titre2);
        portVirtuel = new Portefeuille("Votre portefeuille virtuel", al);

        mCards = new ArrayList<FrameLayout>();
        mCards.add(new PortefeuilleCard(this, portReel));
        mCards.add(new PortefeuilleCard(this, portVirtuel));
        mCards.add(new NotificationCard(this));


    }

    /*private void createTitreCards(Portefeuille port) {
        tCards = new ArrayList<FrameLayout>();
        for (int i=0; i<port.getTitre().size();i++)
            tCards.add(new TitreCard(this, port.getTitre().get(i)));

        mCardScrollView = new CardScrollView(this);
        CustomScrollAdapter adapter = new CustomScrollAdapter(tCards);
        mCardScrollView.setAdapter(adapter);
        mCardScrollView.activate();
        setContentView(mCardScrollView);
    }*/

    private void tappedCard() {

       if (mCardScrollView.getSelectedItemPosition() == 2) {
           Intent intent = new Intent(getBaseContext(), Information.class);
           intent.putExtra("EXTRA_PORT", PORT_REEL);
           //startActivity(intent);
       }
        else if (mCardScrollView.getSelectedItemPosition() == 0) {
           Intent intent = new Intent(getBaseContext(), Information.class);
           intent.putExtra("EXTRA_PORT", PORT_VIRTUEL);
           //startActivity(intent);
       }

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

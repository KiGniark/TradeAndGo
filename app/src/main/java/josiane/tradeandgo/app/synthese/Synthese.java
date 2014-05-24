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

import com.google.android.glass.widget.CardScrollView;

import java.util.ArrayList;

import josiane.tradeandgo.app.R;
import josiane.tradeandgo.app.synthese.adapter.CustomScrollAdapter;
import josiane.tradeandgo.app.synthese.obj.Portefeuille;
import josiane.tradeandgo.app.synthese.obj.Titre;
import josiane.tradeandgo.app.synthese.view.PortefeuilleCard;
import josiane.tradeandgo.app.synthese.view.TitreCard;

/**
 * Created by Kevin on 23/05/2014.
 */
public class Synthese extends Activity{

    private ArrayList<FrameLayout> mCards;
    private ArrayList<FrameLayout> tCards;
    private CardScrollView mCardScrollView;
    Portefeuille portReel;
    Portefeuille portVirtuel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_synthese);
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



    private void createPortefeuilleCards() {

        //Titres reels
        ArrayList<Titre> al = new ArrayList<Titre>();
        Titre titre1 = new Titre("ALU", 10.5, 1.2);
        al.add(titre1);
        Titre titre2 = new Titre("EXP", 11.5, 15.2);
        al.add(titre2);
        portReel = new Portefeuille("Portefeuille réel", al);

        //Titres virtuels

        al = new ArrayList<Titre>();
        titre1 = new Titre("TRUC1", 10.5, 1.2);
        al.add(titre1);
        titre2 = new Titre("TRUC2", 11.5, 15.2);
        al.add(titre2);
        portVirtuel = new Portefeuille("Portefeuille virtuel", al);

        mCards = new ArrayList<FrameLayout>();

        mCards.add(new PortefeuilleCard(this, portReel));
        mCards.add(new PortefeuilleCard(this, portVirtuel));
    }

    private void createTitreCards(Portefeuille port) {
        tCards = new ArrayList<FrameLayout>();
        for (int i=0; i<port.getTitre().size();i++)
            tCards.add(new TitreCard(this, port.getTitre().get(i)));

        mCardScrollView = new CardScrollView(this);
        CustomScrollAdapter adapter = new CustomScrollAdapter(tCards);
        mCardScrollView.setAdapter(adapter);
        mCardScrollView.activate();
        setContentView(mCardScrollView);

    }

    private void tappedCard() {
        int i = mCardScrollView.getSelectedItemPosition();
        if (mCardScrollView.getSelectedItemPosition() != mCards.size() - 1) {
            Toast.makeText(this, "T'as tapé:" + i, Toast.LENGTH_SHORT).show();
        }
        else if (mCardScrollView.getSelectedItemPosition() == 0)
            createTitreCards(portReel);
        else if (mCardScrollView.getSelectedItemPosition() == 1)
            createTitreCards(portVirtual);

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

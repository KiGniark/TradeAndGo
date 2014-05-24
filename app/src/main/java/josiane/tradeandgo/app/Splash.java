package josiane.tradeandgo.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import josiane.tradeandgo.app.info.Information;
import josiane.tradeandgo.app.synthese.Synthese;
import josiane.tradeandgo.app.util.data.titre.TitreManager;


public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TitreManager.getInstance(); // instancie TitreManager pour initialiser les titres.

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startApp();
            }
        }, 2000);
    }

    private void startApp() {
        startActivity(new Intent(this,Synthese.class));
    }
}

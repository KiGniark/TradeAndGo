package josiane.tradeandgo.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                startApp();
            }
        };
        timer.schedule(task,R.string.splashDelay);
    }

    private void startApp() {
        startActivity(new Intent(this,Information.class));
    }
}

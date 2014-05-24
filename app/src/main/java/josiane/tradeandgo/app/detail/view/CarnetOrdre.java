package josiane.tradeandgo.app.detail.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import josiane.tradeandgo.app.R;
import josiane.tradeandgo.app.synthese.obj.Titre;
import josiane.tradeandgo.app.util.data.DataGenerator;
import josiane.tradeandgo.app.util.data.titre.TitreManager;

/**
 * Created by Kevin on 24/05/2014.
 */
public class CarnetOrdre extends FrameLayout {

    List<String> titresColonnes = Arrays.asList("Nb","Qte","Achat","Vente","Qte","Nb");

    GridLayout grid;
    private String titreId;

    public CarnetOrdre(Context context, String titreId) {
        super(context);
        this.titreId = titreId;
    }

    private void initView(final Context context, Titre titre){
        View view = LayoutInflater.from(context).inflate(R.layout.activity_carnet_ordre, null);
        grid = (GridLayout) view.findViewById(R.id.grid_carnet_ordre);
        initGrid(grid);
        this.addView(view);
    }

    private void initGrid(GridLayout grid) {
        grid.removeAllViews();
        grid.setColumnCount(6);
        for (String titre : titresColonnes){
            grid.addView(new ColumnHeader(getContext(),titre));
        }
        for (Titre titre : TitreManager.getInstance().titres.values()){
            grid.addView(new Cell(getContext(), String.valueOf(titre.getNombre())));
            grid.addView(new Cell(getContext(), String.valueOf(titre.getQuantite())));
            grid.addView(new Cell(getContext(), round(titre.getValeur())));
            grid.addView(new Cell(getContext(), round(titre.getValeur())));
            grid.addView(new Cell(getContext(), String.valueOf(titre.getQuantite())));
            grid.addView(new Cell(getContext(), String.valueOf(titre.getNombre())));
        }
    }

    public String round(double valeur){
        return String.valueOf(Math.nextAfter(valeur,3));
    }
}

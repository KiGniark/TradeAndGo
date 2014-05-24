package josiane.tradeandgo.app.util.data.titre;

import java.util.HashMap;
import java.util.Map;

import josiane.tradeandgo.app.synthese.obj.Titre;
import josiane.tradeandgo.app.util.data.DataGenerator;

/**
 * Created by Kevin on 24/05/2014.
 */
public class TitreManager {
    private static TitreManager instance = new TitreManager();
    public static TitreManager getInstance() {
        return instance;
    }
    private TitreManager(){
        String name = "ACCOR";
        titres.put(name,DataGenerator.titre().fx(name,.5));
        name = "ALU";
        titres.put(name,DataGenerator.titre().sin(name,15,.2));
        name = "CAC 40";
        titres.put(name, DataGenerator.titre().expo(name, .01));
    }
    Map<String, Titre> titres = new HashMap<String, Titre>();

    public Titre getTitre(String id){
        Titre titre = titres.get(id);
        if(null != titre){
            titres.put(id, DataGenerator.titre().generate(id,randomType()));
        }else{
            double lastValue = titre.getValeur();
            titre.setValeur(titre.getTypeVariation().nextValue());
            titre.setVariation(lastValue);
        }
        return titre;
    }


    public static TypeTitre randomType(){
        long v = Math.round(Math.floor(Math.random() * 3))+1;
        if(v==1){
            return new TypeTitre.EXPO(.2);
        }else if(v==2){
            return new TypeTitre.FX(.5);
        }else if(v==3){
            return new TypeTitre.SIN(15,.3);
        }
        return null;
    }
}

package josiane.tradeandgo.app.util.data;

import java.util.HashMap;
import java.util.Map;

import josiane.tradeandgo.app.synthese.obj.Titre;
import josiane.tradeandgo.app.util.data.titre.TypeTitre;

/**
 * Created by Kevin on 24/05/2014.
 */
public class DataGenerator {

    private static Map<String, Long> mapRand = new HashMap<String, Long>();

    private static double randomDouble(double min, double max) {
        return Math.random()*(max-min)+min;
    }

    /**
     * La valeur de retour change approximativement(system dependant) toutes les 0,5 secondes
     * @return
     */
    public static long getNewTime() {
        return System.currentTimeMillis()/500;
    }

    public static class TitreGenerator{

        public static TitreGenerator instance = new TitreGenerator();

        public Titre expo(String id, double amplitude){
            return generate(id, new TypeTitre.EXPO(amplitude));
        }

        public Titre fx(String id, double amplitude){
            return generate(id, new TypeTitre.FX(amplitude));
        }

        public Titre sin(String id, double amplitude, double vitesse){
            return generate(id, new TypeTitre.SIN(amplitude, vitesse));
        }

        public Titre generate(String id, TypeTitre typeTitre) {
            return new Titre(id, typeTitre.nextValue(),0,typeTitre);
        }
    }

    public static TitreGenerator titre(){
        return TitreGenerator.instance;
    }
}

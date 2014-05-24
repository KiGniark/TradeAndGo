package josiane.tradeandgo.app.util.data.titre;

import josiane.tradeandgo.app.util.data.DataGenerator;

/**
 * Created by Kevin on 24/05/2014.
 */
public interface TypeTitre {
    double nextValue();

    class EXPO implements TypeTitre{

        private long lastTime;
        private double amplitude;

        public EXPO(double amplitude) {
            this.lastTime = DataGenerator.getNewTime();
            this.amplitude = amplitude;
        }

        @Override
        public double nextValue() {
            return Math.exp(DataGenerator.getNewTime()-lastTime)*amplitude;
        }
    }
    class FX implements TypeTitre{
        private long lastTime;
        private double amplitude;

        public FX(double amplitude) {
            this.lastTime = DataGenerator.getNewTime();
            this.amplitude = amplitude;
        }

        @Override
        public double nextValue() {
            return (DataGenerator.getNewTime() -lastTime)*amplitude;
        }

    }
    class SIN implements TypeTitre{
        private double amplitude;
        private double vitesse;

        public SIN(double amplitude, double vitesse) {
            this.amplitude = amplitude;
            this.vitesse = vitesse;
        }

        @Override
        public double nextValue() {
            double amplitude2 = amplitude/2;
            return Math.sin(DataGenerator.getNewTime() *vitesse)*amplitude2+amplitude2+Math.random();
        }
    }
}

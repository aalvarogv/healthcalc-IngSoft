package healthcalc;

public class HealthCalcImpl implements CardiovascularMetrics, MetabolicMetrics {

    private static HealthCalcImpl instancia;

    private HealthCalcImpl() {}

    public static HealthCalcImpl getInstancia() {
        if (instancia == null) {
            instancia = new HealthCalcImpl();
        }
        return instancia;
    }


    @Override
    public double getIdealBodyWeight(Person user) throws Exception {

        float height = user.height();
        Gender gender = user.gender();
        
        // Cálculo de peso ideal
        if (gender.equals(Gender.MALE)) {
            float IW = height - 100 - (height - 150) / 4;

            // Peso ideal erróneo (hombre)
            if (IW < 0) {
                throw new IllegalArgumentException("El peso ideal calculado (hombre) es erróneo (menor que 0).");
            } else {return IW;}

        } else {
            float IW = height - 100 - (height - 150) / 2.5f;

            // Peso ideal erróneo (mujer)
            if (IW < 0) {
                throw new IllegalArgumentException("El peso ideal calculado (mujer) es erróneo (menor que 0).");
            } else {return IW;}
        }
    }

    @Override
    public double basalMetabolicRate(Person user) throws Exception {

        float height = user.height();
        float weight = user.weight();
        int age = user.age();
        Gender gender = user.gender();
        // Cálculo de tasa metabólica basal
        if (gender.equals(Gender.MALE)) {
            float BMR = 10 * weight + 6.25f * height - 5 * age + 5;

            // Tasa Metabólica Basal errónea (hombre)
            if (BMR < 0) {
                throw new IllegalArgumentException("La Tasa Metabólica Basal calculada (hombre) es errónea (menor que 0).");
            } else {return BMR;}

        } else {
            float BMR = 10 * weight + 6.25f * height - 5 * age - 161;

            // Tasa Metabólica Basal errónea (mujer)
            if (BMR < 0) {
                throw new IllegalArgumentException("La Tasa Metabólica Basal calculada (mujer) es errónea (menor que 0).");
            } else {return BMR;}
        }
    }

}
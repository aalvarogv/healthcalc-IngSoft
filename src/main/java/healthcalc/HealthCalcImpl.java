package healthcalc;

public class HealthCalcImpl implements HealthCalc {

    private static HealthCalcImpl instancia;

    private HealthCalcImpl() {}

    public static HealthCalcImpl getInstancia() {
        if (instancia == null) {
            instancia = new HealthCalcImpl();
        }
        return instancia;
    }


    @Override
    public float idealWeight(int height, char gender) throws Exception {
        
        // Altura introducida incorrecta (menor o igual a 0)
        if (height <= 0) {
            throw new IllegalArgumentException("La altura introducida debe ser > 0.");
        }

        Character genre = Character.toUpperCase(gender);
        // Género introducido incorrecto
        if (genre != 'M' && genre != 'W') {
            throw new IllegalArgumentException("El género introducido no es correcto. Debe ser 'M' (hombre) o 'W' (mujer)");
        
        } else {
            // Altura introducida incorrecta (hombre)
            if (genre == 'M' && height > 250) {
                throw new IllegalArgumentException("La altura introducida es incorrecta para un hombre.");
            }

            // Altura introducida incorrecta (mujer)
            if (genre == 'W' && height > 230) {
                throw new IllegalArgumentException("La altura introducida es incorrecta para una mujer.");
            }
        }

        // Cálculo de peso ideal
        if (genre == 'M') {
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
    public float basalMetabolicRate(float weight, int height, char gender, int age) throws Exception {

        // Altura introducida incorrecta (menor o igual a 0)
        if (height <= 0) {
            throw new IllegalArgumentException("La altura introducida debe ser > 0.");
        }

        // Peso introducido incorrecto (menor o igual a 0)
        if (weight <= 0) {
            throw new IllegalArgumentException("El peso introducido debe ser > 0.");
        }

        // Edad introducida incorrecta (negativa o mayor que 140)
        if (age <= 0) {
            throw new IllegalArgumentException("La edad introducida debe estar entre 0 y 140.");
        }

        Character genre = Character.toUpperCase(gender);
        // Género introducido incorrecto
        if (genre != 'M' && genre != 'W') {
            throw new IllegalArgumentException("El género introducido no es correcto. Debe ser 'M' (hombre) o 'W' (mujer)");
        
        } else {
            // Altura introducida incorrecta (hombre)
            if (genre == 'M' && height > 250) {
                throw new IllegalArgumentException("La altura introducida es incorrecta para un hombre.");
            }

            // Altura introducida incorrecta (mujer)
            if (genre == 'W' && height > 230) {
                throw new IllegalArgumentException("La altura introducida es incorrecta para una mujer.");
            }
        }

        // Cálculo de tasa metabólica basal
        if (genre == 'M') {
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
package healthcalc;

public class HealthHospitalAdapter  implements HealthHospital {

    private static HealthCalcImpl calc;

    private HealthHospitalAdapter() {
        calc = HealthCalcImpl.getInstancia();
    }

    @Override
    public int pesoIdeal(Gender genero, float altura) {
       
        float alturacm = altura * 100;

        try {
            float pesoIdeal = calc.idealWeight(new Usuario((int) alturacm, 1, 1, genero));
            return (int) pesoIdeal;

        } catch (Exception e) {
            System.err.println("Ocurrió un error: " + e.getMessage());
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public double bmr(Gender genero, int edad, float altura, int peso) {

        float alturacm = altura * 100;
        float pesokg = peso / 1000;
        
        try {
            float bmr = calc.basalMetabolicRate(new Usuario((int) alturacm, pesokg, edad, genero));
            return (double) bmr;

        } catch (Exception e) {
            System.err.println("Ocurrió un error: " + e.getMessage());
            e.printStackTrace();
            return 0;
        }
    }
}
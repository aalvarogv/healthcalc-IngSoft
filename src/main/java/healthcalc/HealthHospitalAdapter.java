package healthcalc;

public class HealthHospitalAdapter  implements HealthHospital {

    private static HealthCalc calc;

    private HealthHospitalAdapter() {
        calc = HealthCalcImpl.getInstancia();
    }

    @Override
    public int pesoIdeal(char genero, float altura) {
       
        float alturacm = altura * 100;

        try {
            float pesoIdeal = calc.idealWeight((int) alturacm, genero);
            return (int) pesoIdeal;

        } catch (Exception e) {
            System.err.println("Ocurrió un error: " + e.getMessage());
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public double bmr(char genero, int edad, float altura, int peso) {

        float alturacm = altura * 100;
        float pesokg = peso / 1000;
        
        try {
            float bmr = calc.basalMetabolicRate(pesokg, (int) alturacm, genero, edad);
            return (double) bmr;

        } catch (Exception e) {
            System.err.println("Ocurrió un error: " + e.getMessage());
            e.printStackTrace();
            return 0;
        }
    }
}
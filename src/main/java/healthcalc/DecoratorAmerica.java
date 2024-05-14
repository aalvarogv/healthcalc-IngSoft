package healthcalc;

public class DecoratorAmerica extends Decorator {

    public static String[] medidas = {"pies", "libras"};

    public DecoratorAmerica(HealthStatsProxy calc) {
        super(calc);
    }

    @Override
    public int pesoIdeal(char genero, float altura) {
        float alturaM = altura / 3.2808f;              // 1 metro = 3.2808 pies
        return calc.pesoIdeal(genero, alturaM);
    }

    @Override
    public double bmr(char genero, int edad, float altura, int peso) {
        float alturaM = altura / 3.2808f;              // 1 metro = 3.2808 pies
        int pesoG = (int) (peso * 1000 / 2.20462);     // 1 kg = 2.20462 libras
        return calc.bmr(genero, edad, alturaM, pesoG);
    }

    public String[] medidas() {
        return medidas;
    }
}

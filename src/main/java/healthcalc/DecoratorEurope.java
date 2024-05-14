package healthcalc;

public class DecoratorEurope extends Decorator {

    public static String[] medidas = {"metros", "gramos"};

    public DecoratorEurope(HealthStatsProxy calc) {
       super(calc);
    }

    @Override
    public int pesoIdeal(char genero, float altura) {
        return calc.pesoIdeal(genero, altura);
    }

    @Override
    public double bmr(char genero, int edad, float altura, int peso) {
        return calc.bmr(genero, edad, altura, peso);
    }

    public String[] medidas() {
        return medidas;
    }
}
package healthcalc;

public class DecoratorAmerica implements HealthHospital {

    private HealthStatsProxy calc;
    public static String[] medidas = new String[2];

    public DecoratorAmerica(HealthStatsProxy calc) {
        this.calc = calc;
        medidas[0] = "pies";
        medidas[1] = "libras";
    }

    @Override
    public int pesoIdeal(char genero, float altura) {
        return calc.pesoIdeal(genero, altura);
    }

    @Override
    public double bmr(char genero, int edad, float altura, int peso) {
        return calc.bmr(genero, edad, altura, peso);
    }

    public String[] unidades() {
        return medidas;
    }
}

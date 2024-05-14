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
        double bmr = calc.bmr(genero, edad, altura, peso);
        mensaje(altura, peso, bmr);
        return bmr;
    }

    public void mensaje(float altura, int peso, double bmr) {
        System.out.println("La persona con altura " +
            altura + " " + medidas[0].toString() + " y " +
            peso + " " + medidas[1].toString() + " tiene un BMR de " + 
            Double.toString(bmr));
    }

    public String[] medidas() {
        return medidas;
    }
}
package healthcalc;

public class DecoratorAmerica extends Decorator {

    public static String[] medidas = {"pies", "libras"};

    public DecoratorAmerica(HealthStatsProxy calc) {
        super(calc);
    }

    @Override
    public int pesoIdeal(Gender genero, float altura) {
        float alturaM = altura / 3.2808f;              // 1 metro = 3.2808 pies
        return calc.pesoIdeal(genero, alturaM);
    }

    @Override
    public double bmr(Gender genero, int edad, float altura, int peso) {
        float alturaM = altura / 3.2808f;              // 1 metro = 3.2808 pies
        int pesoG = (int) (peso * 1000 / 2.20462);     // 1 kg = 2.20462 libras
        double bmr = calc.bmr(genero, edad, alturaM, pesoG);
        mensaje(alturaM, pesoG, bmr);
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

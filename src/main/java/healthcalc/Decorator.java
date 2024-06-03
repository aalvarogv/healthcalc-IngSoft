package healthcalc;

public class Decorator implements HealthHospital {

    public HealthStatsProxy calc;
    public static String[] medidas = {"centímetros", "kilogramos"};

    public Decorator(HealthStatsProxy calc) {
        this.calc = calc;
    }

    @Override
    public int pesoIdeal(Gender genero, float altura) {
        float alturaM = altura * 1000;          // 1 metro = 1000 cm
        return calc.pesoIdeal(genero, alturaM);
    }

    @Override
    public double bmr(Gender genero, int edad, float altura, int peso) {
        float alturaM = altura * 1000;          // 1 metro = 1000 cm
        int pesoG = peso / 1000;                // 1 kg = 1000 g
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

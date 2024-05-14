package healthcalc;

public class Decorator implements HealthHospital {

    public HealthStatsProxy calc;
    public static String[] medidas = {"centímetros", "kilogramos"};

    public Decorator(HealthStatsProxy calc) {
        this.calc = calc;
    }

    @Override
    public int pesoIdeal(char genero, float altura) {
        float alturaM = altura * 1000;          // 1 metro = 1000 cm
        return calc.pesoIdeal(genero, alturaM);
    }

    @Override
    public double bmr(char genero, int edad, float altura, int peso) {
        float alturaM = altura * 1000;          // 1 metro = 1000 cm
        int pesoG = peso / 1000;                // 1 kg = 1000 g
        return calc.bmr(genero, edad, alturaM, pesoG);
    }
    
    public String[] medidas() {
        return medidas;
    }
}

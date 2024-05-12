package healthcalc;

public class DecoratorEurope implements HealthHospital {

    private HealthStatsProxy calc;

    public DecoratorEurope(HealthStatsProxy calc) {
        this.calc = calc;
    }

    @Override
    public int pesoIdeal(char genero, float altura) {
        return calc.pesoIdeal(genero, altura);
    }

    @Override
    public double bmr(char genero, int edad, float altura, int peso) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bmr'");
    }
    

}
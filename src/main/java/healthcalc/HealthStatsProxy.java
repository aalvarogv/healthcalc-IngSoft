package healthcalc;

public class HealthStatsProxy  implements HealthHospital, HealthStats {

    private HealthHospital calc;
    private float alturaMediaIW;
    private float alturaMediaBMR;
    private float pesoMedio;
    private float edadMedia;
    private float bmrMedio;
    private int numHIW;
    private int numHBMR;
    private int numMIW;
    private int numMBMR; 

    private HealthStatsProxy(HealthHospital calc) {
        this.calc = calc;
        alturaMediaIW = 0;
        alturaMediaBMR = 0;
        pesoMedio = 0;
        edadMedia = 0;
        bmrMedio = 0;
        numHIW = 0;
        numHBMR = 0;
        numMIW = 0;
        numMBMR = 0;
    }

    @Override   // Método pesoIdeal() de la interfaz HealthHospital
    public int pesoIdeal(char genero, float altura) {
       
        if (genero == 'M') {numHIW++;}
        else if (genero == 'W') {numMIW++;}
        alturaMediaIW += altura;

        return calc.pesoIdeal(genero, altura);
    }

    @Override   // Método bmr() de la interfaz HealthHospital
    public double bmr(char genero, int edad, float altura, int peso) {

        if (genero == 'M') {numHIW++;}
        else if (genero == 'W') {numMIW++;}
        edadMedia += edad;
        alturaMediaBMR += altura;
        pesoMedio += peso;
        bmrMedio += calc.bmr(genero, edad, altura, peso);

        return calc.bmr(genero, edad, altura, peso);
    }

    @Override   // Método alturaMedia() de la interfaz HealthStats
    public float alturaMedia() {
        return (alturaMediaBMR + alturaMediaIW) / (numMIW + numHIW + numHBMR + numMBMR);
    }

    @Override   // Método pesoMedio() de la interfaz HealthStats
    public float pesoMedia() {
        return (pesoMedio) / (numHBMR + numMBMR);
    }

    @Override   // Método edadMedia() de la interfaz HealthStats
    public float edadMedia() {
        return (edadMedia) / (numHBMR + numMBMR);
    }

    @Override   // Método bmrMedio() de la interfaz HealthStats
    public float bmrMedio() {
        return (bmrMedio) / (numHBMR + numMBMR);
    }

    @Override   // Método numSexoH() de la interfaz HealthStats
    public int numSexoH() {
        return (numHIW + numHBMR);
    }

    @Override   // Método numSexoM() de la interfaz HealthStats
    public int numSexoM() {
        return (numMIW + numMBMR);
    }

    @Override   // Método numTotalPacientes() de la interfaz HealthStats
    public int numTotalPacientes() {
        return (numHBMR + numMBMR);
    }
}
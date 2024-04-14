package healthcalc.Interfaz;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import healthcalc.HealthCalcImpl;

public class Controlador implements ActionListener {
    
    private Vista vista;
    private char genero = '-';
	private int edad = 0;
    private int altura = 0;
	private float peso = 0;
	private HealthCalcImpl calc = new HealthCalcImpl();
	
	public Controlador(HealthCalcImpl calc, Vista vista) {
		this.calc = calc;
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent act) {
		String comando = act.getActionCommand();

        if (comando == "checkMasc") {
            vista.getMascCheckBox().setSelected(true);
            vista.getFemCheckBox().setSelected(false);
            //vista.getMascCheckBox().setBackground(new Color(244, 182, 194));
			//vista.getFemCheckBox().setBackground(Color.WHITE);
			genero = 'm';
        }
        else if (comando == "checkFem"){
            vista.getMascCheckBox().setSelected(false);
            vista.getFemCheckBox().setSelected(true);
            //vista.getFemCheckBox().setBackground(new Color(244, 182, 194));
			//vista.getMascCheckBox().setBackground(Color.WHITE);
		    genero = 'w';
        }
        else if (comando == "getBMR"){
            try {
                edad = Integer.parseInt(vista.getEdad().getText());
                altura = Integer.parseInt(vista.getAltura().getText());
                peso = Float.parseFloat(vista.getPeso().getText());
                
                try {
                    float BMR = this.calc.basalMetabolicRate(peso, altura, genero, edad);
                    vista.setBMR(BMR);
                } catch (Exception eBMR) {
                    vista.inputsError(eBMR.getMessage());
                }
            } catch (Exception e) {
                vista.noInputsError();
            }
        }
        else if (comando == "getIdealWeight") {
            try {
                altura = Integer.parseInt(vista.getAltura().getText());
                
                try {
                    float idealWeight = this.calc.idealWeight(altura, genero);
                    vista.setIdealWeight(idealWeight);
                } catch (Exception eIW) {
                    vista.inputsError(eIW.getMessage());
                } 
            } catch (Exception e) {
                vista.noInputsError();
            }
        }
	}

}

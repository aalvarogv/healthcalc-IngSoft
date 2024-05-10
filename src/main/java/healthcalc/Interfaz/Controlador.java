package healthcalc.Interfaz;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import healthcalc.HealthCalcImpl;

public class Controlador implements ActionListener {
    
    private HealthCalcImpl modelo = HealthCalcImpl.getInstancia();
    private Vista vista;
    private char genero = '-';
	private int edad = 0;
    private int altura = 0;
	private float peso = 0;
	
	public Controlador(HealthCalcImpl modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent act) {
		String comando = act.getActionCommand();

        if (comando.equals("checkMasc")) {
            vista.getMascCheckBox().setSelected(true);
            vista.getFemCheckBox().setSelected(false);
            genero = 'm';
        }
        else if (comando.equals("checkFem")){
            vista.getMascCheckBox().setSelected(false);
            vista.getFemCheckBox().setSelected(true);
            genero = 'w';
        }
        else if (comando.equals("getBMR")) {
            try {
                edad = Integer.parseInt(vista.getEdad().getText());
                altura = Integer.parseInt(vista.getAltura().getText());
                peso = Float.parseFloat(vista.getPeso().getText());
                
                try {
                    float BMR = this.modelo.basalMetabolicRate(peso, altura, genero, edad);
                    vista.setBMR(BMR);
                } catch (Exception eBMR) {
                    vista.inputsError(eBMR.getMessage());
                }
            } catch (Exception e) {
                vista.noInputsError();
            }
        }
        else if (comando.equals("getIdealWeight")) {
            try {
                altura = Integer.parseInt(vista.getAltura().getText());
                
                try {
                    float idealWeight = this.modelo.idealWeight(altura, genero);
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

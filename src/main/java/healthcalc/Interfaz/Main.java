package healthcalc.Interfaz;

import java.awt.EventQueue;
import healthcalc.HealthCalcImpl;

public class Main {
    public static void main(String[] args) {
		EventQueue.invokeLater( new Runnable()
			{
			public void run() {
				try {
					HealthCalcImpl calc = new HealthCalcImpl();			// Modelo
					Vista vista = new Vista();							// Vista
					Controlador act = new Controlador(calc, vista);		// Controlador
					vista.control(act);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			}
		);
	}
}

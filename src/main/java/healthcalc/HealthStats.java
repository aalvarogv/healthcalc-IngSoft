package healthcalc;

public interface HealthStats {
	
	/**
	 * @return 	 	    La altura media (cm)
	 */
	public float alturaMedia();
	
	/**
	 * @return	  		El peso medio (kg)
	 */
	public float pesoMedia();

    /**
	 * @return	  		La edad media (años))
	 */
	public float edadMedia();

    /**
	 * @return	  		El bmr medio (kcal)
	 */
	public float bmrMedio();

    /**
	 * @return	  		El número de personas con sexo H
	 */
	public int numSexoH();

    /**
	 * @return	  		El número de personas con sexo M
	 */
	public int numSexoM();

    /**
	 * @return	  		El número total de pacientes
	 */
	public int numTotalPacientes();
}
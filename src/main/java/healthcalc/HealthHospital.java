package healthcalc;

/**
 * Calculator of some health parameters of persons.
 *
 */
public interface HealthHospital {
	
	/**
	 * @param genero 	Gender of the person ('m' or 'w').
	 * @param altura	Height of the person (m).
	 * @return 		 	The ideal weight of the person (g).
	 */
	public int pesoIdeal(Gender genero, float altura);
	
	/**
     * @param genero	Gender of the person ('m' or 'w').
     * @param edad		Age of the person.
     * @param altura 	Height of the person (m).
	 * @param peso		Weight of the person (g).
	 * @return	  		The Basal Metabolic Rate of the person.
	 */
	public double bmr(Gender genero, int edad, float altura, int peso);
}
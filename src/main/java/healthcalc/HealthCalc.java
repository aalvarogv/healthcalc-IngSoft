package healthcalc;

/**
 * Calculator of some health parameters of persons.
 * 
 * @author ISA
 *
 */
public interface HealthCalc {
	
	/**
	 * Calculate the ideal weight (IW) of a person following the Lorentz formula:
	 * For men: IW = height - 100 - (height - 150) / 4)
	 * For women: IW = height - 100 - (height - 150) / 2.5)
	 *
	 * @param usuario	Parámetros de la persona (altura y género)
	 * @return 		 	The ideal weight of the person (kg).
	 * @throws Exception 
	 */
	public float idealWeight(Person usuario) throws Exception;
	
	/**
	 * Calculate the Basal Metabolic Rate (BMR) of a person with the following formula:
	 * For men: BMR = 10 * weight + 6.25 * height - 5 * age + 5
	 * For women: BMR = 10 * weight + 6.25 * height - 5 * age - 161
	 *   
	 * @param usuario	Parámetros de la persona (altura, peso, edad y género)
	 * @return	  		The Basal Metabolic Rate of the person.
	 * @throws Exception
	 */
	public float basalMetabolicRate(Person usuario) throws Exception;
}

package healthcalc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests para la calculadora de salud.")
public class HealthCalcTest {

	private final HealthCalcImpl calc = HealthCalcImpl.getInstancia();

    // HealthCalcImpl.idealWeight()

	@Test
    @DisplayName("Test altura igual a cero (idealWeight)")
    public void testAlturaCeroIdealWeight() {
        assertThrows(IllegalArgumentException.class, () ->
            new Usuario(0, 1, 1, Gender.FEMALE),
		    "La altura introducida debe ser > 0."
        );
    }

    @Test
    @DisplayName("Test altura negativa (idealWeight)")
    public void testAlturaNegativaIdealWeight() {
        assertThrows(IllegalArgumentException.class, () ->
            new Usuario(-4, 1, 1, Gender.FEMALE),
		    "La altura introducida debe ser > 0."
        );
    }

    @Test
    @DisplayName("Test altura incorrecta hombre (idealWeight)")
    public void testAlturaIncorrectaMIdealWeight() {
        assertThrows(IllegalArgumentException.class, () ->
            new Usuario(257, 1, 1, Gender.MALE),
		    "La altura introducida es incorrecta para un hombre."
        );
    }

    @Test
    @DisplayName("Test altura incorrecta mujer (idealWeight)")
    public void testAlturaIncorrectaWIdealWeight() {
        assertThrows(IllegalArgumentException.class, () ->
            new Usuario(231, 1, 1, Gender.FEMALE),
		    "La altura introducida es incorrecta para una mujer."
        );
    }

    @Test
    @DisplayName("Test género incorrecto (idealWeight)")
    public void testGeneroIncorrectoIdealWeight() {
        assertThrows(IllegalArgumentException.class, () ->
            new Usuario(2, 1, 1, null),
		    "El género introducido no es correcto. Debe ser 'M' (hombre) o 'W' (mujer)"
        );
    }

    @Test
    @DisplayName("Test peso ideal incorrecto hombre")
    public void testPesoIdealIncorrectoM() {
        assertThrows(IllegalArgumentException.class, () ->
            new Usuario(47, 1, 1, Gender.MALE),
		    "El peso ideal calculado (hombre) es erróneo (menor que 0)."
        );
    }

    @Test
    @DisplayName("Test peso ideal incorrecto mujer")
    public void testPesoIdealIncorrectoW() {
        assertThrows(IllegalArgumentException.class, () ->
            new Usuario(35, 1, 1, Gender.FEMALE),
		    "El peso ideal calculado (mujer) es erróneo (menor que 0)."
        );
    }

    @Test
    @DisplayName("Test peso ideal correcto hombre")
    public void testPesoIdealCorrectoM() throws Exception {
        int height = 165;
        Gender gender = Gender.MALE;
        float expected = height - 100 - (height - 150) / 4;
        assertEquals(expected, new Usuario(height, 1, 1, gender), 
		"El cálculo del peso ideal (hombre) es incorrecto.");
    }

    @Test
    @DisplayName("Test peso ideal correcto mujer")
    public void testPesoIdealCorrectoW() throws Exception {
        int height = 150;
        Gender gender = Gender.FEMALE;
        float expected = height - 100 - (height - 150) / 2.5f;
        assertEquals(expected, new Usuario(height, 1, 1, gender), 
    	"El cálculo del peso ideal (mujer) es incorrecto.");
    }

    // HealthCalcImpl.basalMetabolicRate()

    @Test
    @DisplayName("Test altura igual a cero (basalMetabolicRate)")
    public void testAlturaCeroBasalMetabolicRate() {
        assertThrows(IllegalArgumentException.class, () ->
            calc.basalMetabolicRate(new Usuario(0, 59, 18, Gender.MALE)), 
		    "La altura introducida debe ser > 0."
        );
    }

    @Test
    @DisplayName("Test altura negativa (basalMetabolicRate)")
    public void testAlturaNegativaBasalMetabolicRate() {
        assertThrows(IllegalArgumentException.class, () ->
            calc.basalMetabolicRate(new Usuario(-3, 90, 25, Gender.FEMALE)), 
		    "La altura introducida debe ser > 0."
        );
    }

    @Test
    @DisplayName("Test altura incorrecta hombre (basalMetabolicRate)")
    public void testAlturaIncorrectaMBasalMetabolicRate() {
        assertThrows(IllegalArgumentException.class, () ->
            calc.basalMetabolicRate(new Usuario(253, 120, 30, Gender.MALE)), 
		    "La altura introducida es incorrecta para un hombre."
        );
    }

    @Test
    @DisplayName("Test altura incorrecta mujer (basalMetabolicRate)")
    public void testAlturaIncorrectaWBasalMetabolicRate() {
        assertThrows(IllegalArgumentException.class, () ->
            calc.basalMetabolicRate(new Usuario(246, 140, 28, Gender.FEMALE)), 
		    "La altura introducida es incorrecta para una mujer."
        );
    }

    @Test
    @DisplayName("Test género incorrecto (basalMetabolicRate)")
    public void testGeneroIncorrectoBasalMetabolicRate() {
        assertThrows(IllegalArgumentException.class, () ->
            calc.basalMetabolicRate(new Usuario(130, 45, 12, null)), 
		    "El género introducido no es correcto. Debe ser 'M' (hombre) o 'W' (mujer)"
        );
    }

    @Test
    @DisplayName("Test peso incorrecto")
    public void testPesoIncorrecto() {
        assertThrows(IllegalArgumentException.class, () ->
            calc.basalMetabolicRate(new Usuario(46, -5, 2, Gender.FEMALE)), 
		    "El peso introducido debe ser > 0."
        );
    }

    @Test
    @DisplayName("Test edad incorrecta")
    public void testEdadIncorrecta() {
        assertThrows(IllegalArgumentException.class, () ->
            calc.basalMetabolicRate(new Usuario(179, 80, -3, Gender.MALE)), 
		    "La edad introducida debe estar entre 0 y 140."
        );
    }

    @Test
    @DisplayName("Test tasa metabolica basal incorrecta hombre")
    public void testBasalMetabolicRateIncorrectoM() {
        assertThrows(IllegalArgumentException.class, () ->
            calc.basalMetabolicRate(new Usuario(5, 3, 45, Gender.MALE)), 
		    "La Tasa Metabólica Basal calculada (hombre) es errónea (menor que 0)."
        );
    }

    @Test
    @DisplayName("Test tasa metabolica basal incorrecta mujer")
    public void testBasalMetabolicRateIncorrectoW() {
        assertThrows(IllegalArgumentException.class, () ->
            calc.basalMetabolicRate(new Usuario(7, 1, 60, Gender.FEMALE)), 
		    "La Tasa Metabólica Basal calculada (mujer) es errónea (menor que 0)."
        );
    }

    @Test
    @DisplayName("Test tasa metabolica basal correcta hombre")
    public void testBasalMetabolicRateCorrectoM() throws Exception {
        int weight = 50;
        int height = 140;
        Gender gender = Gender.MALE;
        int age = 15;
        float expected = 10 * weight + 6.25f * height - 5 * age + 5;
        assertEquals(expected, calc.basalMetabolicRate(new Usuario(height, weight, age, gender)),
	    "El cálculo de la tasa metabólica basal (hombre) es incorrecto");
    }

    @Test
    @DisplayName("Test tasa metabolica basal correcta mujer")
    public void testBasalMetabolicRateCorrectoW() throws Exception{
        int weight = 65;
        int height = 175;
        Gender gender = Gender.FEMALE;
        int age = 27;
        float expected = 10 * weight + 6.25f * height - 5 * age - 161;
        assertEquals(expected, calc.basalMetabolicRate(new Usuario(height, weight, age, gender)),
	    "El cálculo de la tasa metabólica basal (mujer) es incorrecto");
    }
}

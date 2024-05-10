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
            calc.idealWeight(0, 'w'), 
		    "La altura introducida debe ser > 0."
        );
    }

    @Test
    @DisplayName("Test altura negativa (idealWeight)")
    public void testAlturaNegativaIdealWeight() {
        assertThrows(IllegalArgumentException.class, () ->
            calc.idealWeight(-4, 'w'), 
		    "La altura introducida debe ser > 0."
        );
    }

    @Test
    @DisplayName("Test altura incorrecta hombre (idealWeight)")
    public void testAlturaIncorrectaMIdealWeight() {
        assertThrows(IllegalArgumentException.class, () ->
            calc.idealWeight(257, 'm'), 
		    "La altura introducida es incorrecta para un hombre."
        );
    }

    @Test
    @DisplayName("Test altura incorrecta mujer (idealWeight)")
    public void testAlturaIncorrectaWIdealWeight() {
        assertThrows(IllegalArgumentException.class, () ->
            calc.idealWeight(231, 'w'), 
		    "La altura introducida es incorrecta para una mujer."
        );
    }

    @Test
    @DisplayName("Test género incorrecto (idealWeight)")
    public void testGeneroIncorrectoIdealWeight() {
        assertThrows(IllegalArgumentException.class, () ->
            calc.idealWeight(2, 'x'), 
		    "El género introducido no es correcto. Debe ser 'M' (hombre) o 'W' (mujer)"
        );
    }

    @Test
    @DisplayName("Test peso ideal incorrecto hombre")
    public void testPesoIdealIncorrectoM() {
        assertThrows(IllegalArgumentException.class, () ->
            calc.idealWeight(47, 'w'), 
		    "El peso ideal calculado (hombre) es erróneo (menor que 0)."
        );
    }

    @Test
    @DisplayName("Test peso ideal incorrecto mujer")
    public void testPesoIdealIncorrectoW() {
        assertThrows(IllegalArgumentException.class, () ->
            calc.idealWeight(35, 'w'), 
		    "El peso ideal calculado (mujer) es erróneo (menor que 0)."
        );
    }

    @Test
    @DisplayName("Test peso ideal correcto hombre")
    public void testPesoIdealCorrectoM() throws Exception {
        int height = 165;
        char gender = 'm';
        float expected = height - 100 - (height - 150) / 4;
        assertEquals(expected, calc.idealWeight(height, gender), 
		"El cálculo del peso ideal (hombre) es incorrecto.");
    }

    @Test
    @DisplayName("Test peso ideal correcto mujer")
    public void testPesoIdealCorrectoW() throws Exception {
        int height = 150;
        char gender = 'w';
        float expected = height - 100 - (height - 150) / 2.5f;
        assertEquals(expected, calc.idealWeight(height, gender), 
    	"El cálculo del peso ideal (mujer) es incorrecto.");
    }

    // HealthCalcImpl.basalMetabolicRate()

    @Test
    @DisplayName("Test altura igual a cero (basalMetabolicRate)")
    public void testAlturaCeroBasalMetabolicRate() {
        assertThrows(IllegalArgumentException.class, () ->
            calc.basalMetabolicRate(59, 0, 'm', 18), 
		    "La altura introducida debe ser > 0."
        );
    }

    @Test
    @DisplayName("Test altura negativa (basalMetabolicRate)")
    public void testAlturaNegativaBasalMetabolicRate() {
        assertThrows(IllegalArgumentException.class, () ->
            calc.basalMetabolicRate(90, -3, 'w', 25), 
		    "La altura introducida debe ser > 0."
        );
    }

    @Test
    @DisplayName("Test altura incorrecta hombre (basalMetabolicRate)")
    public void testAlturaIncorrectaMBasalMetabolicRate() {
        assertThrows(IllegalArgumentException.class, () ->
            calc.basalMetabolicRate(120, 253, 'm', 30), 
		    "La altura introducida es incorrecta para un hombre."
        );
    }

    @Test
    @DisplayName("Test altura incorrecta mujer (basalMetabolicRate)")
    public void testAlturaIncorrectaWBasalMetabolicRate() {
        assertThrows(IllegalArgumentException.class, () ->
            calc.basalMetabolicRate(140, 246, 'w', 28), 
		    "La altura introducida es incorrecta para una mujer."
        );
    }

    @Test
    @DisplayName("Test género incorrecto (basalMetabolicRate)")
    public void testGeneroIncorrectoBasalMetabolicRate() {
        assertThrows(IllegalArgumentException.class, () ->
            calc.basalMetabolicRate(45, 130, 'x', 12), 
		    "El género introducido no es correcto. Debe ser 'M' (hombre) o 'W' (mujer)"
        );
    }

    @Test
    @DisplayName("Test peso incorrecto")
    public void testPesoIncorrecto() {
        assertThrows(IllegalArgumentException.class, () ->
            calc.basalMetabolicRate(-5, 46, 'w', 2), 
		    "El peso introducido debe ser > 0."
        );
    }

    @Test
    @DisplayName("Test edad incorrecta")
    public void testEdadIncorrecta() {
        assertThrows(IllegalArgumentException.class, () ->
            calc.basalMetabolicRate(80, 179, 'm', -3), 
		    "La edad introducida debe estar entre 0 y 140."
        );
    }

    @Test
    @DisplayName("Test tasa metabolica basal incorrecta hombre")
    public void testBasalMetabolicRateIncorrectoM() {
        assertThrows(IllegalArgumentException.class, () ->
            calc.basalMetabolicRate(3, 5, 'm', 45), 
		    "La Tasa Metabólica Basal calculada (hombre) es errónea (menor que 0)."
        );
    }

    @Test
    @DisplayName("Test tasa metabolica basal incorrecta mujer")
    public void testBasalMetabolicRateIncorrectoW() {
        assertThrows(IllegalArgumentException.class, () ->
            calc.basalMetabolicRate(1, 7, 'w', 60), 
		    "La Tasa Metabólica Basal calculada (mujer) es errónea (menor que 0)."
        );
    }

    @Test
    @DisplayName("Test tasa metabolica basal correcta hombre")
    public void testBasalMetabolicRateCorrectoM() throws Exception {
        int weight = 50;
        int height = 140;
        char gender = 'm';
        int age = 15;
        float expected = 10 * weight + 6.25f * height - 5 * age + 5;
        assertEquals(expected, calc.basalMetabolicRate(weight, height, gender, age),
	    "El cálculo de la tasa metabólica basal (hombre) es incorrecto");
    }

    @Test
    @DisplayName("Test tasa metabolica basal correcta mujer")
    public void testBasalMetabolicRateCorrectoW() throws Exception{
        int weight = 65;
        int height = 175;
        char gender = 'w';
        int age = 27;
        float expected = 10 * weight + 6.25f * height - 5 * age - 161;
        assertEquals(expected, calc.basalMetabolicRate(weight, height, gender, age),
	    "El cálculo de la tasa metabólica basal (mujer) es incorrecto");
    }
}

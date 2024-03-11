package healthcalc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests para la calculadora de salud.")
public class HealthCalcTest {

	private final HealthCalcImpl calc = new HealthCalcImpl();

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
    public void testAlturaIncorrectaMdealWeight() {
        assertThrows(IllegalArgumentException.class, () ->
            calc.idealWeight(257, 'm'), 
		    "La altura introducida es incorrecta para un hombre."
        );
    }

    @Test
    @DisplayName("Test altura incorrecta mujer (idealWeight)")
    public void testAlturaIncorrectaWdealWeight() {
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
}

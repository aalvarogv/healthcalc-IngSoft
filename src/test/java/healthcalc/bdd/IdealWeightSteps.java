package healthcalc.bdd;

import org.junit.jupiter.api.Assertions;

import healthcalc.HealthCalcImpl;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IdealWeightSteps {
    private int height;
    private char gender;
    private float IdealWeight;
    private HealthCalcImpl calc;
    private String error_msg;

    @Before
    public void initialization() {
        this.height = 0;
        this.gender = ' ';
        this.IdealWeight = 0;
        this.calc = null;
        this.error_msg = "";
    }

    @Given("I am a health calculator user")
    public void i_am_a_health_calculator_user() {
        calc = new HealthCalcImpl();
    }

    @When("I introduce my height as {int} and gender as {char} values correctly")
    public void i_introduce_my_height_and_my_gender_values_correctly(int height, char gender) {
        this.height = height;
        this.gender = gender;
        try {
            IdealWeight = calc.idealWeight(height, gender); 
        } catch (Exception e) {
            this.error_msg = e.getMessage().toLowerCase();
        }
    }

    @When("I introduce my height as {int} and gender as {char} values incorrectly")
    public void i_introduce_my_height_and_my_gender_values_incorrectly(int height, char gender) {
        try {
            IdealWeight = calc.idealWeight(height, gender);
        } catch (Exception e) {
            if (height <= 0) {
                error_msg = "La altura introducida debe ser > 0";
            } else {
                error_msg = "El género introducido no es correcto";
            }     
        } 
    }

    @Then("the calculator will calculate my ideal weight as {float}")
    public void the_calculator_will_calculate_my_ideal_weight(float expIdealWeight) {
        Assertions.assertEquals(expIdealWeight, IdealWeight); 
    }

    @Then("the calculator will send me an error message as {error_msg}")
    public void the_calculator_will_send_me_an_error_message() {
        boolean err;
        if (height <= 0) {
            error_msg = "La altura introducida debe ser > 0";
            err = true;
        } else {
            error_msg = "El género introducido no es correcto";
            err = true;
        }
        Assertions.assertTrue(err);
    }
}

package healthcalc.cucumberSteps;

import org.junit.jupiter.api.Assertions;

import healthcalc.HealthCalcImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IdealWeightSteps {
    private int height          = 0;
    private char gender         = ' ';
    private float IdealWeight   = 0;
    private HealthCalcImpl calc = null;
    private boolean error_msg   = false;
    private String except_msg   = "";

    @Given("I am a health calculator user")
    public void i_am_a_health_calculator_user() {
        calc = new HealthCalcImpl();
    }

    @When("I introduce my height as {int} and my gender as {string} values correctly")
    public void i_introduce_my_height_and_my_gender_values_correctly(int height, String gender) {
        this.height = height;
        char genderChar = gender.charAt(0);
        this.gender = genderChar;
        try {
            IdealWeight = calc.idealWeight(height, genderChar); 
        } catch (Exception e) {
            this.except_msg = e.getMessage().toLowerCase();
            error_msg = true;
        }
    }

    @When("I introduce my height as {int} and my gender as {string} values incorrectly")
    public void i_introduce_my_height_and_my_gender_values_incorrectly(int height, String gender) {
        this.height = height;
        char genderChar = gender.charAt(0);
        this.gender = genderChar;
        try {
            IdealWeight = calc.idealWeight(height, genderChar);
        } catch (Exception e) {
            if (height <= 0) {
                this.except_msg = "La altura introducida debe ser > 0";
            } else {
                this.except_msg = "El género introducido no es correcto";
            }    
            error_msg = true;
        } 
    }

    @Then("The calculator will calculate my ideal weight as {float}")
    public void the_calculator_will_calculate_my_ideal_weight(float ideal_weight) {
        Assertions.assertEquals(ideal_weight, IdealWeight); 
    }

    @Then("The calculator will send me an error message")
    public void the_calculator_will_send_me_an_error_message() {
        if (this.except_msg.contains("altura") || this.except_msg.contains("género")) {
            this.error_msg = true;
        }
        Assertions.assertTrue(error_msg);
    }
}

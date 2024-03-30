package healthcalc.cucumberSteps;

import org.junit.jupiter.api.Assertions;

import healthcalc.HealthCalcImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BasalMetabolicRateSteps {
    private int weight               = 0;
    private int height               = 0;
    private int age                  = 0;
    private char gender              = ' ';
    private float BasalMetabolicRate = 0;
    private HealthCalcImpl calc      = null;
    private boolean error_msg        = false;
    private String except_msg        = "";

    @Given("I am another health calculator user")
    public void i_am_a_health_calculator_user() {
        calc = new HealthCalcImpl();
    }

    @When("I introduce my weight as {int}, my height as {int}, my gender as {string} and my age as {int} values correctly")
    public void i_introduce_my_weight_my_height_my_gender_and_my_age_values_correctly(int weight, int height, String gender, int age) {
        this.weight = weight;
        this.height = height;
        char genderChar = gender.charAt(0);
        this.gender = genderChar;
        this.age = age;
        try {
            BasalMetabolicRate = calc.basalMetabolicRate(weight, height, genderChar, age); 
        } catch (Exception e) {
            this.except_msg = e.getMessage().toLowerCase();
            this.error_msg = true;
        }
    }

    @When("I introduce my weight as {int}, my height as {int}, my gender as {string} and my age as {int} values incorrectly")
    public void i_introduce_my_weight_my_height_my_gender_and_my_age_values_incorrectly(int weight, int height, String gender, int age) {
        this.weight = weight;
        this.height = height;
        char genderChar = gender.charAt(0);
        this.gender = genderChar;
        this.age = age;
        try {
            BasalMetabolicRate = calc.basalMetabolicRate(weight, height, genderChar, age);
        } catch (Exception e) {
            if (weight <= 0) { 
                except_msg = "El peso introducido debe ser > 0";
            } else if (height <= 0) {
                except_msg = "La altura introducida debe ser > 0";
            } else if (age < 0 || age > 140) {
                except_msg = "La edad introducida debe estar entre 0 y 140";
            } else {
                except_msg = "El género introducido no es correcto";
            }
            error_msg = true;
        } 
    }

    @Then("The calculator will calculate my basal metabolic rate as {float}")
    public void the_calculator_will_calculate_my_basal_metabolic_rate(float basal_metabolic_rate) {
        Assertions.assertEquals(basal_metabolic_rate, BasalMetabolicRate); 
    }

    @Then("The calculator will send me another error message")
    public void the_calculator_will_send_me_another_error_message() {
        if (this.except_msg.contains("peso") ||
            this.except_msg.contains("altura") ||
            this.except_msg.contains("edad") ||
            this.except_msg.contains("género")) {
            this.error_msg = true;
        }
        Assertions.assertTrue(error_msg);
    }
}
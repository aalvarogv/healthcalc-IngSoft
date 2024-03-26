package healthcalc.bdd;

import org.junit.jupiter.api.Assertions;

import healthcalc.HealthCalcImpl;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BasalMetabolicRateSteps {
    private int weight;
    private int height;
    private int age;
    private char gender;
    private float BasalMetabolicRate;
    private HealthCalcImpl calc;
    private String error_msg;

    @Before
    public void initialization() {
        this.weight = 0;
        this.height = 0;
        this.gender = ' ';
        this.age = 0;
        this.BasalMetabolicRate = 0;
        this.calc = null;
        this.error_msg = "";
    }

    @Given("I am a health calculator user")
    public void i_am_a_health_calculator_user() {
        calc = new HealthCalcImpl();
    }

    @When("I introduce my weight as {int}, my height as {int}, my age as {int} and gender as {char} values correctly")
    public void i_introduce_my_weight_my_height_my_age_and_my_gender_values_correctly(int height, char gender) {
        this.weight = weight;
        this.height = height;
        this.gender = gender;
        this.age = age;
        try {
            BasalMetabolicRate = calc.basalMetabolicRate(weight, height, gender, age); 
        } catch (Exception e) {
            this.error_msg = e.getMessage().toLowerCase();
        }
    }

    @When("I introduce my weight as {int}, my height as {int}, my age as {int} and gender as {char} values incorrectly")
    public void i_introduce_my_weight_my_height_my_age_and_my_gender_values_incorrectly(int height, char gender) {
        try {
            BasalMetabolicRate = calc.basalMetabolicRate(weight, height, gender, age);
        } catch (Exception e) {
            if (weight <= 0) { 
                error_msg = "El peso introducido debe ser > 0";
            } else if (height <= 0) {
                error_msg = "La altura introducida debe ser > 0";
            } else if (age < 0 || age > 140) {
                error_msg = "La edad introducida debe estar entre 0 y 140";
            } else {
                error_msg = "El género introducido no es correcto";
            }     
        } 
    }

    @Then("the calculator will calculate my basal metabolic rate as {float}")
    public void the_calculator_will_calculate_my_basal_metabolic_rate(float expBasalMetabolicRate) {
        Assertions.assertEquals(expBasalMetabolicRate, BasalMetabolicRate); 
    }

    @Then("the calculator will send me an error message as {error_msg}")
    public void the_calculator_will_send_me_an_error_message() {
        boolean err;
        if (weight <= 0) { 
            error_msg = "El peso introducido debe ser > 0";
            err = true;
        } else if (height <= 0) {
            error_msg = "La altura introducida debe ser > 0";
            err = true;
        } else if (age < 0 || age > 140) {
            error_msg = "La edad introducida debe estar entre 0 y 140";
            err = true;
        } else {
            error_msg = "El género introducido no es correcto";
            err = true;
        } 
        Assertions.assertTrue(err);
    }
}

package atm;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepositStepdefs {

    private ATM atm;
    private int customerId;
    private int customerPin;
    private double initialBalance;

    @Given("I am logged in as customer number {int} with PIN {int}")
    public void i_am_logged_in_as_with_PIN(int id, int pin) {
        atm = new ATM(new Bank("K plus", new DataSourceDB()));
        customerId = id;
        customerPin = pin;
    }

    @When("I deposit ${double}")
    public void i_deposit(Double amount) {
        atm.validateCustomer(customerId, customerPin);
        atm.deposit(amount);
    }

    @Then("my account balance should be ${double}")
    public void my_account_balance_should_be(Double expectedBalance) {
        double actualBalance = atm.getBalance();
        assertEquals(expectedBalance, actualBalance, 0.01);  // Adjust the delta as needed
    }

    
}

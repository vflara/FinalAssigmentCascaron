package selenium_cucumber.selenium_cucumber.goheavy.driver;

//import java.io.InputStream;
import io.cucumber.java.en.*;
import selenium_cucumber.selenium_cucumber.general.*;
import selenium_cucumber.selenium_cucumber.goheavy.vehicles.VehicleStep;
import selenium_cucumber.selenium_cucumber.goheavy.vehicles.VehicleStepDefinition;

@SuppressWarnings("unused")
public class DriverStepDefinition {
	private GeneralSteps generalSteps;
	private DriverStep driverSteps;
	private String email;
	private String status;
	private VehicleStep vehicleStep;
	private VehicleStepDefinition vehicleStepDefinition;

	public DriverStepDefinition() {
		generalSteps = new GeneralSteps();
		driverSteps = new DriverStep();
	}

	@Given("User Add a {string} from Drivers List")
	public void user_add_a_driver(String driver) {
		driverSteps.user_inserts_valid_data_add();
	}

	@Given("User Add a {string}")
	public void user_add_a_vehicle(String status) {
		driverSteps.user_search_for_added_driver(email);
		driverSteps.userClicksOnVehicles();
		vehicleStep.userClicksOnAddVehicleButton();
		vehicleStep.hoverOverImageComponent();
		vehicleStepDefinition.the_user_inserts_valid_data_and_clicks_done_button();
		driverSteps.system_creates_driver_on_status(status);
	}
	@Given("User go to {string}")
	public void userGoToDocuments(String documents) {
		driverSteps.systemOpensAddDriverView();
		driverSteps.user_clicks_on_documents_button();
	}

	@Given("User approves {string}")
	public void user_approves_documents(String documents) {
		driverSteps.user_clicks_on_approve_button();
	}


	@When("User clicks on {string} button.")
	public void userClicksOnButton(String documents) {
		driverSteps.userClickEdit();
	}

	@And("User updates the Status.")
	public void user_updates_the_status() {
		driverSteps.user_updates_the_status();
	}

	@Then("The driver is set to GoHeavy Ready.")
	public void the_driver_is_set_to_goheavy_ready() {
		driverSteps.the_driver_is_set_to_goheavy_ready();
	}

}

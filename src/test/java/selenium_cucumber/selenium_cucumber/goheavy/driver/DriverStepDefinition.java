package selenium_cucumber.selenium_cucumber.goheavy.driver;

//import java.io.InputStream;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import selenium_cucumber.selenium_cucumber.general.*;

@SuppressWarnings("unused")
public class DriverStepDefinition {
	private GeneralSteps generalSteps;
	private DriverStep driverSteps;
	private String fName;
	private String status;

	public DriverStepDefinition() {
		generalSteps = new GeneralSteps();
		driverSteps = new DriverStep();
	}

	@Given("User Add a {string} from Drivers List")
	public void user_add_a_driver(String driver) {
		driverSteps.user_inserts_valid_data_add();
	}

	@Given("User Add a {string} from Vehicles & Insurance List")
	public void user_add_a_vehicle(String vehicle) {
		driverSteps.systemOpensAddDriverView();
		driverSteps.user_search_for_added_driver(fName);
		driverSteps.userClicksOnAddDriverButton();
		driverSteps.system_creates_driver_on_status(status);
	}

	@Given("User approves {string}")
	public void user_approves_documents(String documents) {
		driverSteps.systemOpensAddDriverView();
		driverSteps.user_clicks_on_approve_button();
	}

	@And("The user inserts valid data.")
	public void user_inserts_valid_data() {
		driverSteps.user_inserts_valid_data_add();
	}

	@Then("The System Creates a new Driver in {string} status.")
	public void system_creates_driver_on_status(String status) {
		driverSteps.system_creates_driver_on_status(status);
	}
	

	@Then("The system displays the {string} view.")
	public void system_displays_documents_for_driver(String goheavy_view) {
		driverSteps.system_displays_documents_for_driver();
	}
	
	@Then("The system Saves Changes and goes back to the {string} view.")
	public void the_system_saves_and_goes(String goheavy_view) {
		driverSteps.the_system_saves_and_goes();
	}
	
	@When("User clicks on \"Edit Driver\" button.")
	public void user_click_edit() {
		driverSteps.userClickEdit();
	}


	@Then("The System displays message {string}")
	public void theSystemDisplaysMessage(String arg0) { driverSteps.the_system_saves_and_goes();
	}

	@And("System returns to the {string} view")
	public void systemReturnsToTheView(String arg0) { driverSteps.systemOpensAddDriverView();
	}

	@When("User clicks on the {string} icon that belong to a driver.")
	public void user_clicks_on_documents_button() {
		driverSteps.user_clicks_on_documents_button();
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

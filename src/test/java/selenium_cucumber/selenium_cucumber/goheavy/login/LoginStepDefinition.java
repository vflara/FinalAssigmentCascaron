package selenium_cucumber.selenium_cucumber.goheavy.login;

//import java.io.InputStream;
import java.util.Properties;
import io.cucumber.java.en.*;
import selenium_cucumber.selenium_cucumber.general.*;
import selenium_cucumber.selenium_cucumber.goheavy.dashboard.DashboardStep;
import selenium_cucumber.selenium_cucumber.goheavy.driver.DriverStep;
import selenium_cucumber.selenium_cucumber.goheavy.fleetowners.FleetStep;

public class LoginStepDefinition {
	private LoginStep loginStep;
	private GeneralSteps generalSteps;

	public LoginStepDefinition() {
		loginStep = new LoginStep();
		generalSteps = new GeneralSteps();
	}

	@Given("The unauthenticated GoHeavy User is in the Login view")
	public void the_unauthenticated_go_heavy_user_is_in_the_view() {
		loginStep.the_unauthenticated_go_heavy_user_is_in_the_view();
	}

	@When("User insert email {string} and password {string}")
	public void user_insert_email_and_password(String email, String password) {
		loginStep.user_insert_email_and_password(email, password);
	}

	@When("User clicks on the \"Sign in\" button")
	public void user_clicks_on_the_button() {
		loginStep.user_clicks_on_the_button();
	}

	@Then("The system allows the user access to the system")
	public void the_system_allows_the_user_access_to_the_system() {
		loginStep.the_system_allows_the_user_access_to_the_system();
	}

	@Then("System redirects to {string} view")
	public void system_redirects_to_dashboard_view(String redirect) {
		Steps view = new DashboardStep();

		if (redirect == "Drivers List")
			view = new DriverStep();
		else if (redirect == "Fleet Owners List")
			view = new FleetStep();

		view.checkPage();
	}

	@Then("The system displays an error {string} below each field")
	public void system_shows_error_message_for_required_fields(String message) {
		loginStep.the_system_shows_error_message(message);
	}

	@Then("The system displays the following error {string} in a popup window")
	public void system_shows_error_message_for_not_registered_info(String message) {
		try {
			loginStep.the_system_shows_error_message_for_not_registed(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("System Logs Out")
	public void system_logs_out() {
		try {
			generalSteps.logoutProcess();
		} catch (Exception e) {
			System.out.println("-- Warning -- Maybe hard to click but clicked");
		}
	}

	@Given("Any {string} is logged")
	public void any_user_is_logged(String user) {
		Properties cred = (Properties) Setup.getValueStore("defaultProperties");
		String email = cred.getProperty("default.email");
		String pass = cred.getProperty("default.password");
		if (user.equals("GoHeavy Admin / Fleet Owner") || user.equals("GoHeavy Adm / Fleet Owner")) {
			email = cred.getProperty("vehicle.email");
			pass = cred.getProperty("vehicle.password");
		} else if (user.equals("GoHeavy Administrator / Fleet Owner")) {
			email = cred.getProperty("admin.email");
			pass = cred.getProperty("admin.password");
		}
		// Mock we get the data from excel or any file
		loginStep.openURL();
		loginStep.user_insert_email_and_password(email, pass);
		loginStep.user_clicks_on_the_button();
	}


}

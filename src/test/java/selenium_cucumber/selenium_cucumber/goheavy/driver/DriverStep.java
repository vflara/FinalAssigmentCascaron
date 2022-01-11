package selenium_cucumber.selenium_cucumber.goheavy.driver;

import org.junit.Assert;

import org.openqa.selenium.By;
import selenium_cucumber.selenium_cucumber.general.Setup;
import selenium_cucumber.selenium_cucumber.general.Steps;
import selenium_cucumber.selenium_cucumber.goheavy.driver.pages.DriverPage;

@SuppressWarnings("unused")
public class DriverStep extends Steps{
	private DriverPage driverListPage;
	private DriverPage driverPage;

	public DriverStep() {

		driverListPage = new DriverPage();
		driverPage = new DriverPage();
	}

	public void checkPage() {
		String path = driverListPage.getPagePath().toLowerCase();
		Assert.assertTrue(" The path provided is not correct in the url. path: " + path,
				driverListPage.getCurrentUrl().toLowerCase().contains(path));
	}

	public void goToView() {
		try {
			Assert.assertTrue(driverListPage.goToView());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void userClicksOnAddDriverButton() {
		try {
			Assert.assertTrue(driverListPage.userClickOnAddDriver());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void systemOpensAddDriverView() {
		try {
			Assert.assertNotNull(driverListPage.systemOpensAddDriverView());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void user_inserts_valid_data_add() {
		driverPage.clickOnElement(driverPage.getDriver().findElement(By.xpath("//span[text()='Add Driver']/ancestor::button[@class='ant-btn ant-btn-primary']")), true);
		try {
			Assert.assertTrue(driverListPage.userInsertsValidDataAdd());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void system_creates_driver_on_status(String status) {
		try {
			Assert.assertNotNull(driverListPage.systemCreatesDriverOnStatus(status));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void user_clicks_on_documents_button() {
		try {
			Assert.assertTrue(driverListPage.userClicksOnDocumentsButton());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void system_displays_documents_for_driver() {
		try {
			Assert.assertNotNull(driverListPage.systemDisplaysDocuments());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void user_clicks_on_approve_button() {
		try {
			Assert.assertTrue(driverListPage.userClicksOnApproveButton());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public boolean the_system_saves_and_goes() {
		this.checkPage();
		return true;
	}

	public void userClickEdit() {
		try {
			Assert.assertTrue(driverListPage.userClicksEdit());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void user_updates_the_status() {
		try {
			Assert.assertTrue(driverListPage.userClicksUpdatesStatus());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void the_driver_is_set_to_goheavy_ready(){
		try {
			Assert.assertTrue(driverListPage.driverIsSetToGoheavyReady());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void user_search_for_added_driver(String fName) {
		try {
			driverListPage.searchForAddedDriver(fName);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void goToAccountSettingsView() {
		try {
			Setup.getWait().thread(500);
			Assert.assertTrue(driverPage.goToVehiclesInsuranceListView());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

}

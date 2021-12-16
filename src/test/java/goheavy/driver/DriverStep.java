package goheavy.driver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import general.PageObject;
import general.Setup;
import general.Steps;
import goheavy.driver.pages.DriverPage;

@SuppressWarnings("unused")
public class DriverStep extends Steps{
	private DriverPage driverListPage;

	public DriverStep() {
		driverListPage = new DriverPage();
	}

	public void checkPage() {
		String path = driverListPage.getPagePath().toLowerCase();
		Assert.assertTrue(" The path provided is not correct in the url. path: " + path,
				driverListPage.getCurrentUrl().toLowerCase().contains(path));
	}

	public void goToView() {
		Assert.assertTrue(driverListPage.goToView());
	}

}

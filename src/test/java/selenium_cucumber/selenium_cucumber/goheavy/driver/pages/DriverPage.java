package selenium_cucumber.selenium_cucumber.goheavy.driver.pages;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import selenium_cucumber.selenium_cucumber.general.PageObject;
import selenium_cucumber.selenium_cucumber.general.Setup;

@SuppressWarnings("unused")
public class DriverPage extends PageObject {
	private String menuDriversLink;
	private String addDriverButton;
	private String AddDriverTitle;
	private String AddButton;
	private String updateBtn = "//span[text()='Update']";
	private String driver_experience="//input[@placeholder='Enter Years of experience']";
	private String driver_mobile="//input[@placeholder='Enter Mobile Number']";
	private String driver_email="//input[@placeholder='Enter Email Address']";
	private String driver_address="//textarea[@placeholder='Address']";
	private String driver_zipCode="//input[@placeholder='Enter ZIP Code']";
	private String driver_City="//input[@placeholder='Enter City']";
	private String driver_Country="//input[@id='addressCountryId']";
	private String vehicles = "//span[@class='anticon anticon-car' and @aria-label='car' and @cursor='pointer']";

	public DriverPage() {
		super();
		this.urlpath = "/driver";
		setMenuDriversLink("//span[text()='Drivers']/ancestor::span[@class='ant-menu-title-content']");
		setAddDriverButton("//span[text()='Add Driver']/ancestor::button[@class='ant-btn ant-btn-primary']");
		setAddDriverTitle("//span[text()='Add Driver']/ancestor::div[@class='ant-row ant-row-space-between ant-row-middle']");
	}

	private String getAddButton() {
		return AddButton;
	}

	private void setAddButton(String addButton) {
		AddButton = addButton;
	}

	private String getVehicles() {
		return vehicles;
	}

	private void setVehicles(String vehicles) {
		AddButton = vehicles;
	}

	private String getAddDriverTitle() {
		return AddDriverTitle;
	}

	private void setAddDriverTitle(String addDriverTitle) {
		AddDriverTitle = addDriverTitle;
	}
	public String getUpdateBtn(){return updateBtn;}
	/*private String getDriver_LicenseNumber() {
		return driver_LicenseNumber;
	}
	private void setDriver_LicenseNumber(String driver_LicenseNumber) {
		driver_LicenseNumber = driver_LicenseNumber;
	}

	private String getDriver_Photo() {
		return AddDriverTitle;
	}*/
	private void setDriver_Photo(String driver_Photo) {
		driver_Photo = driver_Photo;
	}

	private String getDriver_firstName() {
		return AddDriverTitle;
	}
	private void setDriver_firstName(String driver_firstName) {
		driver_firstName = driver_firstName;
	}

	private String getDriver_lastName() {
		return AddDriverTitle;
	}
	private void setDriver_lastName(String driver_lastName) {
		driver_lastName = driver_lastName;
	}

	private String getDriver_experience() {
		return driver_experience;
	}
	private void setDriver_experience(String driver_experience) {
		driver_experience = driver_experience;
	}

	private String getDriver_mobile() {
		return driver_mobile;
	}
	private void setDriver_mobile(String driver_mobile) {
		driver_mobile = driver_mobile;
	}

	private String getDriver_email() {
		return driver_email;
	}
	private void setDriver_email(String driver_email) {
		driver_email = driver_email;
	}

	private String getDriver_address() {
		return driver_address;
	}
	private void setDriver_address(String driver_address) {
		driver_address = driver_address;
	}

	private String getDriver_zipCode() {
		return driver_zipCode;
	}
	private void setDriver_zipCode(String driver_zipCode) {
		driver_zipCode = driver_zipCode;
	}

	private String getDriver_City() {
		return driver_City;
	}
	private void setDriver_City(String driver_City) {
		driver_City = driver_City;
	}

	private String getDriver_Country() {
		return driver_Country;
	}
	private void setDriver_Country(String driver_Country) {
		driver_Country = driver_Country;
	}

	private String getAddDriverButton() {
		return addDriverButton;
	}

	private void setAddDriverButton(String addDriverButton) {
		this.addDriverButton = addDriverButton;
	}

	private String getMenuDriversLink() {
		return menuDriversLink;
	}

	private void setMenuDriversLink(String menuDriversLink) {
		this.menuDriversLink = menuDriversLink;
	}

	public boolean goToView() {
		try {
			waitForSpinningElementDissapear();
			waitAddittionalTime();
			clickOnElement(getWebElement(By.xpath(getMenuDriversLink())), true);
			return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public void waitAddittionalTime() {
		Setup.getWait().thread(5000);
	}
	
	public void waitAddittionalShortTime() {
		Setup.getWait().thread(1000);
	}
	
	public void clickOnElement(WebElement element, boolean waitForSpinner) {
		if (waitForSpinner)
			waitForSpinningElementDissapear();
		Setup.getActions().moveToElement(element).build().perform();
		Setup.getActions().click(element).build().perform();
		if (waitForSpinner)
			waitForSpinningElementDissapear();
	}

	public boolean userClickOnVehicles() {
		try {
			waitForSpinningElementDissapear();
			Setup.getWait().thread(1000);
			clickOnElement(getWebElement(By.xpath("//span[@class='anticon anticon-car' and @aria-label='car' and @cursor='pointer']")), true);
			return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public WebElement systemOpensAddDriverView() {
		try {
			waitForSpinningElementDissapear();
			waitAddittionalTime();
			return getWebElement(By.xpath(getAddDriverTitle()));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public void interactAndRandomSelectFromDropDown(String id_dropdown, String id_options) {
		try {
			WebElement element = getWebElement(By.xpath("//input[@id='" + id_dropdown +"' and @role='combobox']"));
			Setup.getActions().moveToElement(element).build().perform();
			Setup.getActions().click(element).build().perform();
			String xpath = "//div[@role='listbox' and @id='" + id_options + "']/ancestor::div[contains(@class, "
					+ "'ant-select-dropdown')]/descendant::div[@class='ant-select-item-option-content']";
			List<WebElement> select_elements = getWebElements(By.xpath(xpath));
			WebElement option_element = select_elements.get(
					getFaker().number().numberBetween(2, 5));
			Setup.getActions().moveToElement(option_element).build().perform();
			Setup.getActions().click(option_element).build().perform();
			//print(select_elements.size());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void clear_element_text(WebElement element) {
		int length = element.getAttribute("value").length();
		for (int i = 0;i <= length;i++) {
			Setup.getActions().sendKeys(element, Keys.BACK_SPACE).perform();
		}	
	}
	
	public void sendDataToInputByWebElement(WebElement element, String data) {
		clear_element_text(element);
		Setup.getActions().moveToElement(element).build().perform();
		Setup.getActions().sendKeys(element, data).build().perform();
	}

	public String userInsertsValidDataAdd() {
			waitForSpinningElementDissapear();
			CheckUploadImageComponent("(//input[@type='file'])[1]","//span[text()='Add']");

			//First Name
			Setup.getActions().click(getWebElement(By.xpath("//input[@placeholder='Enter First Name']"))).build().perform();
			sendDataToInput(getWebElement(By.xpath("//input[@placeholder='Enter First Name']")), getFaker().name().firstName(),null);
			//String firstName = Setup.getDriver().findElement(By.xpath("//input[@placeholder='Enter First Name']")).getAttribute("value");

			//Last Name
			sendDataToInput(getWebElement(By.xpath("//input[@placeholder='Enter Last Name']")), getFaker().name().lastName(),null);

			//B.Day
			Setup.getActions().moveToElement(getWebElement(By.xpath("//input[@id='birthAt']"))).build().perform();
			Setup.getActions().click(getWebElement(By.xpath("//input[@id='birthAt']"))).build().perform();
			Setup.getWait().thread(2000);
			Setup.getActions().sendKeys("12/01/1999").build().perform();
			Setup.getWait().thread(2000);
			Setup.getActions().sendKeys(Keys.ENTER).build().perform();

			sendDataToInput(getWebElement(By.xpath(driver_experience)), "4", null);
			sendDataToInput(getWebElement(By.xpath(driver_mobile)), getFaker().number().digits(10), null);
			sendDataToInput(getWebElement(By.xpath(driver_email)), getFaker().internet().emailAddress(), null);
			String email = Setup.getDriver().findElement(By.xpath(driver_email)).getAttribute("value");

			//T-Shirt Size
			Setup.getActions().moveToElement(getWebElement(By.xpath("//input[@id='tShirtSize']"))).build().perform();
			Setup.getActions().click(getWebElement(By.xpath("//input[@id='tShirtSize']"))).build().perform();
			Setup.getWait().thread(2000);
			Setup.getActions().sendKeys("M").build().perform();
			Setup.getWait().thread(2000);
			Setup.getActions().sendKeys(Keys.ENTER).build().perform();

			sendDataToInput(getWebElement(By.xpath(driver_address)), getFaker().address().streetName(), null);
			sendDataToInput(getWebElement(By.xpath(driver_zipCode)), getFaker().address().zipCode(), null);

			sendDataToInput(getWebElement(By.xpath(driver_City)), getFaker().address().city(), null);

			//State
			Setup.getActions().moveToElement(getWebElement(By.xpath("//input[@id='addressStateId']"))).build().perform();
			Setup.getActions().click(getWebElement(By.xpath("//input[@id='addressStateId']"))).build().perform();
			Setup.getWait().thread(2000);
			Setup.getActions().sendKeys("Florida").build().perform();
			Setup.getWait().thread(2000);
			Setup.getActions().sendKeys(Keys.ENTER).build().perform();

			CheckUploadImageComponent("(//input[@type='file'])[2]","//span[text()='Add']");
			CheckUploadImageComponent("(//input[@type='file'])[3]","//span[text()='Add']");

			//Driver's License (DL) Number
			sendDataToInput(getWebElement(By.xpath("//input[@placeholder='Enter DL number']")), getFaker().number().digits(7), null);

			//Dl Issue Date
			Setup.getActions().moveToElement(getWebElement(By.xpath("//input[@id='dlIssuedDate']"))).build().perform();
			Setup.getActions().click(getWebElement(By.xpath("//input[@id='dlIssuedDate']"))).build().perform();
			Setup.getWait().thread(2000);
			Setup.getActions().sendKeys("12/01/2015").build().perform();
			Setup.getWait().thread(2000);
			Setup.getActions().sendKeys(Keys.ENTER).build().perform();

			//DL Expiration Date
			Setup.getActions().moveToElement(getWebElement(By.xpath("//input[@id='dlExpirationDate']"))).build().perform();
			Setup.getActions().click(getWebElement(By.xpath("//input[@id='dlExpirationDate']"))).build().perform();
			Setup.getWait().thread(2000);
			Setup.getActions().sendKeys("12/31/2025").build().perform();
			Setup.getWait().thread(2000);
			Setup.getActions().sendKeys(Keys.ENTER).build().perform();

			//DL Class Type
			Setup.getActions().moveToElement(getWebElement(By.xpath("//input[@id='dlClassType']"))).build().perform();
			Setup.getActions().click(getWebElement(By.xpath("//input[@id='dlClassType']"))).build().perform();
			Setup.getWait().thread(2000);
			Setup.getActions().sendKeys("M").build().perform();
			Setup.getWait().thread(2000);
			Setup.getActions().sendKeys(Keys.ENTER).build().perform();

			Setup.getWait().thread(1500);
			Setup.getActions().moveToElement(getWebElement(By.xpath("//span[text()='Add']"))).build().perform();
			Setup.getActions().click(getWebElement(By.xpath("//span[text()='Add']"))).build().perform();

			return email;
	}


	public String message_FailedUploadFiles(File file) {
		waitForSpinningElementDissapear();
		WebElement alert = getWebElement(By.xpath("//div[@class='ant-notification ant-notification-topRight']"));
		Wait<WebDriver> wait = new FluentWait<WebDriver>(Setup.getDriver())
				.withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

		WebDriver driver = Setup.getDriver();
		WebElement msg = wait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				Assert.assertNotNull(alert.getText());
				return alert;
			}
		});
		//Assert.assertEquals(msg.getText(), message);
		return msg.getText();
	}

	public void CheckUploadImageComponent(String fileInputButton, String nextBtn) {
			waitForSpinningElementDissapear();

			File valid_file_PNG = new File("src/test/resources/file2.jpg");
			List<File> paths = new ArrayList<File>();

			paths.add(valid_file_PNG);
			for (File file : paths) {
				Setup.getDriver().findElement(By.xpath(fileInputButton)).sendKeys(file.getAbsolutePath());

				try {
					if (file.getName().contains("JPG") && file.getName().contains("JPEG") && file.getName().contains("PNG")) {
						Assert.assertEquals(message_FailedUploadFiles(file), "You can only upload JPG/JPEG/PNG files");
						if (file.length() >= 5242880) {
							Assert.assertEquals(message_FailedUploadFiles(file), "The image must be smaller than 5 MB");
						} else {
							Assert.assertTrue(Setup.getDriver().findElement(By.xpath("//div[@class='styles__ImagePreviewActionsStyled-sc-1qjgkf9-12 kxeirt']")).isDisplayed());
							Assert.assertEquals(Setup.getDriver().findElement(By.xpath("//span[@class='styles__ItemStatusStyled-sc-1qjgkf9-14 gDWxff item-status']")).getText(),"Assessing");
						}

					}
				} catch (Exception e) {
					Assert.fail(e.getMessage());
				}
			}
		}

	public WebElement systemCreatesDriverOnStatus(String status) {
		try {
			waitForSpinningElementDissapear();
			waitAddittionalTime();
			waitAddittionalShortTime();
			String class_value;
			if (status.equals("Clear"))
				class_value = "ant-tag ant-tag-green";
			else if (status.equals("GoHeavy Ready"))
				class_value = "ant-tag ant-tag-geekblue";
			else
				class_value = "ant-tag ant-tag-blue";

			/*if (Boolean.valueOf(Setup.getValueStore("clearDriver").toString())) {
				status = "Clear";
				class_value = "ant-tag ant-tag-green";
			}*/

			Setup.getActions().sendKeys(getWebElement(By.xpath("//input[@placeholder='Search...' and @type='text' and @class='ant-input']")),
					(String) Setup.getValueStore("driverName")).build().perform();

			Setup.getWait().thread(500);

			Setup.getActions().click(getWebElement(By.xpath("//button[@class='ant-btn ant-btn-icon-only ant-input-search-button']"))).build().perform();

			Setup.getWait().thread(1000);

			String status_xpath = "//span[@class='" + class_value + "' and text()='" + status + "']";
			WebElement element = getWebElement(By.xpath(status_xpath));

			return element;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public boolean userClicksOnDocumentsButton() {
		try {
			waitForSpinningElementDissapear();
			for (int i = 0;i <2;i++)
				clickOnElement(getWebElement(By.xpath("//span[text()='Creation Date']")), true);
			Setup.getWait().thread(500);
			clickOnElement(getWebElement(By.xpath("//span[@class='ant-tag ant-tag-blue' and text()='On-boarding']"
					+ "/ancestor::tr[contains(@class, 'ant-table-row')]/descendant::span[@class='anticon anticon-file-text' "
					+ "and @role='img']")), true);
			
			waitForSpinningElementDissapear();			
			return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public Object systemDisplaysDocuments() {
		try {
			waitAddittionalTime();
			waitForSpinningElementDissapear();
			return getWebElement(By.xpath("//span[@class='ant-breadcrumb-link']/ancestor::div"
					+ "[contains(@class, 'ant-breadcrumb')]/descendant::span[text()='Documents']"));
		} catch(Exception e) {
			print(e.getMessage());
			return null;
		}
	}

	public boolean userClicksOnApproveButton() {
		try {
			waitAddittionalTime();
			waitForSpinningElementDissapear();
			
			List<WebElement> elements = getWebElements(By.xpath("//span[not(contains(text(), 'Clear')) "
					+ "and contains(@class, 'ant-tag')]/ancestor::tr[contains(@class, 'ant-table-row')]/"
					+ "descendant::span[@role='img' and @class='anticon anticon-check-circle']"));
			
			for (int i = 0;i < elements.size();i++) {
				clickOnElement(elements.get(i), true);
				manageClearDocument();
			}
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	private void manageClearDocument() {
		waitForSpinningElementDissapear();
		clickOnElement(getWebElement(By.xpath("//button[@type='submit']")), true);
	}

	public boolean userClicksEdit() {
		try {
			waitForSpinningElementDissapear();
			clickOnElement(getWebElement(By.xpath("//span[@class='anticon anticon-edit' and @aria-label='edit' and @cursor='pointer']")), true);

			List<WebElement> elements = getWebElements(By.xpath("//span[@class='anticon anticon-edit' and @aria-label='edit' and @cursor='pointer']"));

			for (int i = 0;i < elements.size();i++) {
				clickOnElement(elements.get(i), true);
				manageClearDocument();
			}
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	public boolean userClicksUpdatesStatus() {
		try {
			waitForSpinningElementDissapear();
			waitAddittionalTime();
			for (int i = 0;i <2;i++)
				clickOnElement(getWebElement(By.xpath("//div[text()='GoHeavy Ready' and @class='ant-select-item-option-content']")), true);
			Setup.getWait().thread(500);
			clickOnElement(getWebElement(By.xpath("//span[text()='Update']")), true);
			
			waitForSpinningElementDissapear();			
			return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean driverIsSetToGoheavyReady() {
		try {
			waitForSpinningElementDissapear();

			for (int i = 0;i <2;i++)
			clickOnElement(getWebElement(By.xpath("//span[text()='GoHeavy Ready' and @class='ant-tag ant-tag-geekblue']")), true);
			Setup.getWait().thread(500);

			waitForSpinningElementDissapear();
			return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean searchForAddedDriver(String driver_email) {
		waitForSpinningElementDissapear();
		try {
			if (driver_email.equals(Setup.getDriver().findElement(By.xpath(driver_email)).getAttribute("value"))){
			Setup.getActions().sendKeys(Setup.getDriver().findElement(By.xpath("//input[@placeholder='Search...' and @type='text' and @class='ant-input']")), driver_email).build().perform();
			Setup.getActions().click(Setup.getDriver().findElement(By.xpath("//button[@class=\"ant-btn ant-btn-icon-only ant-input-search-button\"]"))).build().perform();
			waitForSpinningElementDissapear();
			return true;
			} else return false;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean goToVehiclesInsuranceListView() {
		try {
			waitForSpinningElementDissapear();
			Setup.getWait().thread(500);
			WebElement element = getWebElement(By.xpath("//span[text()='Drivers']/ancestor::li[contains(@class, 'ant-menu-item')]"));
			clickOn(element);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}

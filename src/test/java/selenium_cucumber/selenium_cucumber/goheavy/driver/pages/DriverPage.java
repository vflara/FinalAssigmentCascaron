package selenium_cucumber.selenium_cucumber.goheavy.driver.pages;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import selenium_cucumber.selenium_cucumber.general.InputType;
import selenium_cucumber.selenium_cucumber.general.PageObject;
import selenium_cucumber.selenium_cucumber.general.Setup;

@SuppressWarnings("unused")
public class DriverPage extends PageObject {
	private String menuDriversLink;
	private String addDriverButton;
	private String AddDriverTitle;
	private String AddButton;
	private String search = "//input[@placeholder='Search...' and @type='text' and @class='ant-input']";
	private String searchB = "//button[@class=\"ant-btn ant-btn-icon-only ant-input-search-button\"]";

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

	private String getAddDriverTitle() {
		return AddDriverTitle;
	}

	private void setAddDriverTitle(String addDriverTitle) {
		AddDriverTitle = addDriverTitle;
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

	public boolean userClickOnAddDriver() {
		try {
			waitForSpinningElementDissapear();
			waitAddittionalTime();
			clickOnElement(getWebElement(By.xpath(getAddDriverButton())), true);
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
		//tShirtSize
		//tShirtSize_list
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

	public boolean userInsertsValidDataAdd() {
		try {
			waitForSpinningElementDissapear();
			
			String title = "Driver Photo (including shoulders)";
			setImageImproved(title, null);
			
			String formId = "driver-form";
			
			String name = getFaker().name().firstName();
			Setup.setKeyValueStore("driverName", name);

			sendDataToInputImproved("First Name", (String) Setup.getValueStore("driverName"), null, 
					InputType.input, true, formId, 40);
			//waitAddittionalShortTime();
			
			sendDataToInputImproved("Last Name", getFaker().name().lastName(), null,  InputType.input, true, formId, 40);
			//waitAddittionalShortTime();
			
			int min_val = 22;
			int max_val = 55;
			
			ThreadLocalRandom tlr = ThreadLocalRandom.current();
	        int randomNum = tlr.nextInt(min_val, max_val + 1);
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			String date_compare = dtf.format(LocalDateTime.now().plusYears(randomNum * -1));
			
			sendDataToInputImproved("Birth Date", date_compare.toString(), null,  
					InputType.input, true, formId, 40);
			waitAddittionalShortTime();
			sendDataToInputImproved("Birth Date", null, Keys.RETURN,  
					InputType.input, true, formId, 40);
			waitAddittionalShortTime();
			
			sendDataToInputImproved("Experience", String.valueOf(getFaker().number().numberBetween(3, 8)), null,  
					InputType.input, true, formId, 40);
			waitAddittionalShortTime();
			
			sendDataToInputImproved("Mobile", "53" + (String) getFaker().number().digits(8), null,  
					InputType.input, true, formId, 40);
			waitAddittionalShortTime();
			
			sendDataToInputImproved("Email", getFaker().internet().emailAddress(), null,  
					InputType.input, true, formId, 40);
			waitAddittionalShortTime();
			
			//tShirtSize
			//tShirtSize_list
			interactAndRandomSelectFromDropDown("tShirtSize", "tShirtSize_list");
			
			sendDataToInputImproved("Address", getFaker().address().streetName(), null,  InputType.textarea, true, formId, 210);
			waitAddittionalShortTime();
			
			//addressStateId
			//addressStateId_list
			interactAndRandomSelectFromDropDown("addressStateId", "addressStateId_list");
			
			sendDataToInputImproved("City", getFaker().address().cityName(), null,  InputType.input, true, formId, 210);
			waitAddittionalShortTime();
			
			sendDataToInputImproved("ZIP Code", getFaker().address().zipCode(), null,  InputType.input, true, formId, 210);
			waitAddittionalShortTime();
			
			//Driver's License Photo (Front)
			title = "Driver's License Photo (Front)";
			setImageImproved(title, null);

			//Driver's License Photo (Back)
			title = "Driver's License Photo (Back)";
			setImageImproved(title, null);
		
			sendDataToInputImproved("Driver's License (DL) Number", "1" + String.valueOf(getFaker().number().digits(6)), null,  
					InputType.input, true, formId, 40);
			waitAddittionalShortTime();
			
			formScrollImproved(formId, Integer.valueOf(Setup.getTimeouts().get("pageLoad").toString()));
			
			//dlClassType
			//dlClassType_list
			interactAndRandomSelectFromDropDown("dlClassType", "dlClassType_list");
			
			min_val = 2;
			max_val = 5;
			
	        randomNum = tlr.nextInt(min_val, max_val + 1);
			
			dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			date_compare = dtf.format(LocalDateTime.now().plusMonths((randomNum * -1)));
			
			sendDataToInputImproved("DL Issued Date", date_compare.toString(), null,  
					InputType.input, true, formId, 40);
			waitAddittionalShortTime();
			sendDataToInputImproved("DL Issued Date", null, Keys.RETURN,  
					InputType.input, true, formId, 40);
			
			date_compare = dtf.format(LocalDateTime.now().plusMonths((randomNum)));
			
			sendDataToInputImproved("DL Expiration Date", date_compare.toString(), null,  
					InputType.input, true, formId, 40);
			waitAddittionalShortTime();
			sendDataToInputImproved("DL Expiration Date", null, Keys.RETURN,  
					InputType.input, true, formId, 40);
			
			String xpath = "//*[@type='submit']";
			Setup.getActions().click(getWebElement(By.xpath(xpath))).build().perform();
			clickOn(getWebElement(By.xpath("//span[text()='Add']")));
			//submitForm(formId);
			return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public WebElement systemCreatesDriverOnStatus(String status) {
		try {
			waitForSpinningElementDissapear();
			waitAddittionalTime();
			
			String class_value = "ant-tag ant-tag-blue";

			Setup.getActions().sendKeys(getWebElement(By.xpath(""
					+ "//input[@placeholder='Search...' and @type='text' and @class='ant-input']")), 
					(String) Setup.getValueStore("driverName")).build().perform();
			
			Setup.getWait().thread(500);
			
			Setup.getActions().click(getWebElement(By.xpath(""
					+ "//button[@class='ant-btn ant-btn-icon-only ant-input-search-button']"))).build().perform();
			
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

	public boolean searchForAddedDriver(String fName) {
		waitForSpinningElementDissapear();
		try {
			Setup.getActions().sendKeys(Setup.getDriver().findElement(By.xpath(search)),fName).build().perform();
			Setup.getActions().click(Setup.getDriver().findElement(By.xpath(searchB))).build().perform();

			waitForSpinningElementDissapear();
			return true;
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

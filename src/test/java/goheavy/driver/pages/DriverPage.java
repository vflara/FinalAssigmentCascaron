package goheavy.driver.pages;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.text.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import general.InputType;
import general.PageObject;
import general.Setup;

@SuppressWarnings("unused")
public class DriverPage extends PageObject {
	private String menuDriversLink;
	private String addDriverButton;
	private String AddDriverTitle;

	public DriverPage() {
		super();
		this.urlpath = "/driver";
		setMenuDriversLink("//span[text()='Drivers']/ancestor::span[@class='ant-menu-title-content']");
		setAddDriverButton("//span[text()='Add Driver']/ancestor::button[@class='ant-btn ant-btn-primary']");
		setAddDriverTitle("//span[text()='Add Driver']/ancestor::div[@class='ant-row ant-row-space-between ant-row-middle']");
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



}

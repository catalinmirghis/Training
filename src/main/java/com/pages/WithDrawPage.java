package com.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@DefaultUrl("http://192.168.1.68:9080/web/java-department")
public class WithDrawPage extends PageObject {
	
	@FindBy(css = "input[value='Withdrawn']")
	private WebElementFacade withDraw;

	public void clickNewVacationMenu() {
		withDraw.click();
	}

	public void verifyThatYouAreOnNewVacationPage() {
		WebElement vacation = getDriver().findElement(
				By.cssSelector("li[class='nav-header']:nth-child(1)"));
		Assert.assertTrue("You are not logged in!", vacation.isDisplayed());
	}

}
package com.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@DefaultUrl("http://192.168.1.68:9080/web/java-department")
public class HomePage extends PageObject {
	
	@FindBy(css = "ul[class='main-menu'] a[href='http://192.168.1.68:9080/web/java-department/new-vacation']")
	private WebElementFacade newVacation;

	public void clickNewVacationMenu() {
		newVacation.click();
	}

	public void verifyThatYouAreOnNewVacationPage() {
		WebElement vacation = getDriver().findElement(
				By.cssSelector("li[class='nav-header']:nth-child(1)"));
		Assert.assertTrue("You are not logged in!", vacation.isDisplayed());
	}

}
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
	private WebElementFacade NewVacation;

	public void click_SignIn() {
		NewVacation.click();
	}

	public void verifyThatYouAreOnNewVacationPage() {
		WebElement vacation = getDriver().findElement(
				By.cssSelector("li[class='nav-header']"));
		Assert.assertTrue("You are not logged in!", vacation.isDisplayed());
	}

}
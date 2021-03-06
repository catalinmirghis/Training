package com.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@DefaultUrl("http://192.168.1.68:9080/web/java-department/new-vacation")
public class MyFreeDaysPage extends PageObject {

//	@FindBy(id = "_58_login")
//	private WebElementFacade ScreeName;
//
//	@FindBy(id = "_58_password")
//	private WebElementFacade Password;

	@FindBy(css = ".nav-list a[href*='menuItem=my-free-days']")
	private WebElementFacade MyFreeDays;

//	public void enter_ScreenName_keywords(String keyword) {
//		ScreeName.type(keyword);
//	}
//
//	public void enter_Password_keywords(String keyword) {
//		Password.type(keyword);
//	}

	public void click_freeDays() {
		MyFreeDays.click();
	}

	public void verifyThatYouAreLogIn() {
		WebElement dockBar = getDriver()
				.findElement(By.cssSelector("#dockbar"));
		Assert.assertTrue("You are not logged in!", dockBar.isDisplayed());
	}

}
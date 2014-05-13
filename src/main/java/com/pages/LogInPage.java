package com.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@DefaultUrl("http://192.168.1.68:9080/login/")
public class LogInPage extends PageObject {

	@FindBy(id = "_58_login")
	private WebElementFacade ScreeName;

	@FindBy(id = "_58_password")
	private WebElementFacade Password;

	@FindBy(css = "span[class='aui-button-content'] input[class='aui-button-input aui-button-input-submit']")
	private WebElementFacade SignIn;

	public void enter_ScreenName_keywords(String keyword) {
		ScreeName.type(keyword);
	}

	public void enter_Password_keywords(String keyword) {
		Password.type(keyword);
	}

	public void click_SignIn() {
		SignIn.click();
	}

	public void verifyThatYouAreLogIn() {
		WebElement dockBar = getDriver()
				.findElement(By.cssSelector("#dockbar"));
		Assert.assertTrue("You are not logged in!", dockBar.isDisplayed());
	}

}
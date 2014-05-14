package com.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@DefaultUrl("http://192.168.1.68:9080/web/java-department/new-vacation")
public class InboxPage extends PageObject {

	@FindBy(css = ".nav-list a[href*='menuItem=inbox']")
	private WebElementFacade Inbox;

	@FindBy(css = "li[class='active'] a")
	private WebElementFacade AssignedToOthers;

	public void click_inbox() {
		Inbox.click();
	}

	public void click_assignedToOthers() {
		AssignedToOthers.click();
	}

	public void verifyThatYouAreLogIn() {
		WebElement dockBar = getDriver()
				.findElement(By.cssSelector("#dockbar"));
		Assert.assertTrue("You are not logged in!", dockBar.isDisplayed());
	}

}
package com.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@DefaultUrl("http://192.168.1.68:9080/web/java-department")
public class WithdrawVacationRequestPage extends PageObject {
	
	@FindBy(css = "input[value='Withdrawn']")
	private WebElementFacade withDraw;

	public void clickWithdraw() {
		withDraw.click();
	}



}
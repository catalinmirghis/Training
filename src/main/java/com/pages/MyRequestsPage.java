package com.pages;

import java.util.List;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@DefaultUrl("http://192.168.1.68:9080/web/java-department/new-vacation?p_p_id=evovacation_WAR_EvoVacationportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_evovacation_WAR_EvoVacationportlet_backURL=%2Fweb%2Fjava-department%2Fnew-vacation&_evovacation_WAR_EvoVacationportlet_menuItem=my-requests")
public class MyRequestsPage extends PageObject {

	@FindBy(css = "i[class='icon-book']")
	private WebElementFacade MyRequests;

	@FindBy(id = "_evovacation_WAR_EvoVacationportlet_applyButton")
	private WebElementFacade Applybtn;
	
	@FindBy(css = "a[href='http://192.168.1.68:9080/web/java-department/new-vacation?p_p_id=evovacation_WAR_EvoVacationportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_evovacation_WAR_EvoVacationportlet_menuItem=my-requests&_evovacation_WAR_EvoVacationportlet_myRequestState=view-vacation&_evovacation_WAR_EvoVacationportlet_backMenuItem=my-requests&_evovacation_WAR_EvoVacationportlet_vacationId='")
	private WebElementFacade requestID;
	
	public void click_Apply_Button() {
		Applybtn.click();
	}
	
	public void click_MyRequests_Page() {
		MyRequests.click();
	}

	public void verifyThatYouAreOnMyRequestsPage() {
		WebElement myrequests = getDriver().findElement(
				By.cssSelector("span[class='aui-button-content'] input[class='aui-button-input']"));
		Assert.assertTrue("You are not logged in!", myrequests.isDisplayed());
	}
	
	public void selectCreatedRequest(){
		

	}

}
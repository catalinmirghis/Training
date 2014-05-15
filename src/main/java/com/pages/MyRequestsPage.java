package com.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.steps.NewVacationRequestSteps;

@DefaultUrl("http://192.168.1.68:9080/web/java-department/new-vacation?p_p_id=evovacation_WAR_EvoVacationportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_evovacation_WAR_EvoVacationportlet_backURL=%2Fweb%2Fjava-department%2Fnew-vacation&_evovacation_WAR_EvoVacationportlet_menuItem=my-requests")
public class MyRequestsPage extends PageObject {

	@FindBy(css = "i[class='icon-book']")
	private WebElementFacade MyRequests;

	@FindBy(id = "_evovacation_WAR_EvoVacationportlet_applyButton")
	private WebElementFacade Applybtn;

	@FindBy(css = "aui-field-input aui-field-input-select aui-field-input-menu")
	private WebElementFacade pageDropDownFilter;

	@FindBy(css = "select[class='aui-field-input aui-field-input-select aui-field-input-menu'] option[value='75']")
	private WebElementFacade selectValueFromDropDown;

	public void click_Apply_Button() {
		Applybtn.click();
	}

	public void click_MyRequests_Page() {
		MyRequests.click();
	}

	public void click_NextPage() {
		// boolean found = false;
		String noOfPagesContainer = getDriver()
				.findElement(
						By.cssSelector("span[class='aui-paginator-current-page-report aui-paginator-total']"))
				.getText().trim();

		int noOfPages = tools.StringUtils.getAllIntegerNumbersFromString(
				noOfPagesContainer).get(1);
		System.out.println(noOfPages);
		for (int i = 0; i <= noOfPages; i++) {
			if (i <= noOfPages) {
				getDriver()
						.findElement(
								By.cssSelector(".aui-paginator-link.aui-paginator-next-link"))
						.click();
			}
		}
	}

	public void verifyThatYouAreOnMyRequestsPage() {
		WebElement myrequests = getDriver()
				.findElement(
						By.cssSelector("span[class='aui-button-content'] input[class='aui-button-input']"));
		Assert.assertTrue("You are not logged in!", myrequests.isDisplayed());
	}

	public void clickOnARequestIsInTheTableList(String vacationId) {
		getDriver().findElement(
				By.cssSelector("a[href*=vacation=" + vacationId + "']"))
				.click();
	}

	public void clickPageDropDownFilter() {
		pageDropDownFilter.click();
		selectValueFromDropDown.click();

	}
}
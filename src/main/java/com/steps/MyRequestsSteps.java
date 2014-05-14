package com.steps;

import java.util.List;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.steps.ScenarioSteps;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.pages.MyRequestsPage;

public class MyRequestsSteps extends ScenarioSteps {

	public String var;
	MyRequestsPage myrequestspage;

	@Step
	public void click_MyRequestPage() {
		myrequestspage.click_MyRequests_Page();
	}

	@Step
	public void click_Apply_Button() {
		myrequestspage.click_Apply_Button();
	}

	@Step
	public void verifyMyRequestsPage() {
		myrequestspage.verifyThatYouAreOnMyRequestsPage();
	}

	@Step
	public void selectAFilterType(String vacationType) {
		switch (vacationType) {
		case "Holiday":
			var = "HOLIDAYCheckbox";
			break;
		case "Vacation Without Payment":
			var = "VACATION_WITHOUT_PAYMENTCheckbox";
			break;
		case "Special Vacation":
			var = "SPECIAL_VACATIONCheckbox";
			break;
		case "Sick Leave":
			var = "SICK_LEAVECheckbox";
			break;
		case "Show only future vacations":
			var = "futureVacationsCheckbox";
		}
		WebElement element = getDriver()
				.findElement(
						By.cssSelector(String
								.format("#_evovacation_WAR_EvoVacationportlet_"
										+ var)));
		if (!(element.isSelected()))
			element.click();

	}
}

// @StepGroup
// public void myReqests_Filter(){
// click_MyRequestPage();
// verifyMyRequestsPage();
// selectAVacationType("dads");
//


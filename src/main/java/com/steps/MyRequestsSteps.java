package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import org.openqa.selenium.WebElement;

import com.pages.MyRequestsPage;
import com.pages.NewVacationRequestPage;

public class MyRequestsSteps extends ScenarioSteps {
	
	public MyRequestsSteps(Pages pages) {
		super(pages);
	}

	public String var;
	MyRequestsPage myrequestspage;
	NewVacationRequestPage newVacationRequestPage;

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
	public void selectAFilterRequest_VacationType(String vacationType) {
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
			break;
		default:
		 var="ALLCheckbox";	
		}
		WebElement element = getDriver()
				.findElement(
						By.cssSelector(String
								.format("#_evovacation_WAR_EvoVacationportlet_"
										+ var)));
		if (!(element.isSelected()))
			element.click();

	}

	@Step
	public void selectAFilterRequest_DaysNumber(String vacationDays) {
		switch (vacationDays) {
		case "1-5":
			var = "FIFTHCheckbox";
			break;
		case "6-10":
			var = "TENTHCheckbox";
			break;
		case "11-20":
			var = "TWENTIETHCheckbox";
			break;
		case "21-50":
			var = "FIFTIETHCheckbox";
			break;
		case "51+":
			var = "RESTCheckbox";
			break;
			default:
			 var="ALLCheckbox";		
		}
		WebElement element = getDriver()
				.findElement(
						By.cssSelector(String
								.format("#_evovacation_WAR_EvoVacationportlet_"
										+ var)));
		if (!(element.isSelected()))
			element.click();

	}

	@Step
	public void selectAFilterRequest_VacationStatus(String vacationStatus) {
		switch (vacationStatus) {
		case "Pending":
			var = "PENDINGCheckbox";
			break;
		case "Approved":
			var = "APPROVEDCheckbox";
			break;
		case "Rejected":
			var = "REJECTEDCheckbox";
			break;
		case "Withdrawn":
			var = "WITHDRAWNCheckbox";
			break;
		case "Canceled":
			var = "CANCELEDCheckbox";
			break;
			default:
			 var="ALLCheckbox";	
			
		}
		WebElement element = getDriver()
				.findElement(
						By.cssSelector(String
								.format("#_evovacation_WAR_EvoVacationportlet_"
										+ var)));
		if (!(element.isSelected()))
			element.click();

	}
	
	@Step
	public void selectRequest(String vacationId){
		myrequestspage.clickOnARequestIsInTheTableList(vacationId);
	}

	@StepGroup
	public void myReqests_Filter_Apply(String selectVacationType, String selectDaysNumber, String selectVacationStatus) {
		click_MyRequestPage();
		verifyMyRequestsPage();
		selectAFilterRequest_VacationType(selectVacationType);
		selectAFilterRequest_DaysNumber(selectDaysNumber);
		selectAFilterRequest_VacationStatus(selectVacationStatus);
		click_Apply_Button();
	}
	
	@StepGroup
	public void clickPageDropDownFilter(){
		myrequestspage.clickPageDropDownFilter();
	}
}

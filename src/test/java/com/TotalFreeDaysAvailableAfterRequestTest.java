package com;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;

import org.openqa.selenium.WebDriver;

import com.steps.HomeSteps;
import com.steps.LogInSteps;
import com.steps.NewVacationRequestSteps;


public class TotalFreeDaysAvailableAfterRequestTest {
	int startMonth, startDay, startYear, endMonth, endDay, endYear;

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9080/")
	public Pages pages;

	@Steps
	public LogInSteps endUser;

	@Steps
	public HomeSteps homeSteps;

	@Steps
	public NewVacationRequestSteps newRequest;

	public void TotalFreeDaysAvailableAfterRequest() throws Exception
	{
		endUser.loginSteps("nina.ramadan", "monkey");
		homeSteps.goNewVacation();
		homeSteps.verifyNewVacationPage();
		newRequest.makeANewVacation("Vacation without payment", "ăîșț",
				"șșșțțță", 07, 01, 2014, 07, 03, 2014, "șșșț", "", "");
		newRequest
		.checkSuccesfullMessage("Your request completed successfully.");
		newRequest.checkErrorMessage("Your request failed to complete.");
		
		
		
	}


}

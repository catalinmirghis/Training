package com;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.requirements.Application;
import com.steps.HomeSteps;
import com.steps.LogInSteps;
import com.steps.NewVacationRequestSteps;

/**
 * @author ninaramadan
 * 
 */
@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom("newrequest.csv")
public class NewVacationRequestTestDataDriven {
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

	@Test
	public void new_request_data_driven() throws Exception {
		endUser.loginSteps("nina.ramadan", "monkey");
		homeSteps.goNewVacation();
		homeSteps.verifyNewVacationPage();
		newRequest.makeANewVacation("Special vacation", "aaa", "bbb",
				startMonth, startDay, startYear, endMonth, endDay, endYear,
				"fff", "Funeral", "a");
		newRequest
				.checkSuccesfullMessage("Your request completed successfully.");

	}

}

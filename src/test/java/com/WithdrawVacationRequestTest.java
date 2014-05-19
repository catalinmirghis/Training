package com;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.requirements.Application;
import com.steps.HomeSteps;
import com.steps.LogInSteps;
import com.steps.NewVacationRequestSteps;
import com.steps.WithdrawVacationRequestSteps;


@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesRunner.class)
public class WithdrawVacationRequestTest {
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
	@Steps  
	public WithdrawVacationRequestSteps withDraw;

	@Test
	public void succesfull_enter_comment_duration_and_institution_international_characters()
			throws Exception {
		endUser.loginSteps("nina.ramadan", "monkey");
		homeSteps.goNewVacation();
		homeSteps.verifyNewVacationPage();
		newRequest.makeANewVacation("Holiday", "ăîșț",
				"șșșțțță", 07, 14, 2015, 07, 15, 2015, "Other","a");
		newRequest.checkSuccesfullMessage("Your request completed successfully.");
		withDraw.clickOnWithDraw();
//		newRequest.checkErrorMessage("Evo Vacation Portlet is temporarily unavailable.");
		

	}
}

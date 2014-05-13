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

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesRunner.class)
public class NewVacationRequestTest {

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
	public void login_successfully() {
		endUser.loginSteps("daniel.mocan", "monkey");
		homeSteps.goNewVacation();
		homeSteps.verifyNewVacationPage();
		newRequest.click_signin_newrequest();
		newRequest.selectavacation("Sick leave");
		newRequest.click_comment();
		newRequest.enter_a_comment("aaaa");
		newRequest.click_input_Startdate();
		newRequest.click_input_Enddate();
		newRequest.click_buttonsave();
	}
}

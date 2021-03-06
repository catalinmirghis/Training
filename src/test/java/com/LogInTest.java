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
import com.steps.FreeDaysHistorySteps;
import com.steps.HomeSteps;
import com.steps.LogInSteps;
import com.steps.MyFreeDaysSteps;

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesRunner.class)
public class LogInTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9080/")
	public Pages pages;

	@Steps
	public LogInSteps endUser;
	@Steps
	public HomeSteps homeSteps;
	@Steps
	public MyFreeDaysSteps myFreeDays; 
	
	@Steps
	public FreeDaysHistorySteps freeDaysHistory; 

	@Test
	public void login_successfully() {
		endUser.loginSteps("daniel.mocan", "monkey");
		homeSteps.goNewVacation();
		homeSteps.verifyNewVacationPage();
		endUser.loginSteps("evoportal.dmunu", "monkey");
		endUser.goNewVacation();
	    myFreeDays.clickMyFreeDays();
//		freeDaysHistory.clickFreeDaysHistory();
	}
}

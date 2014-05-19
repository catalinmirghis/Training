package com;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;
import net.thucydides.junit.runners.ThucydidesRunner;

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
@RunWith(ThucydidesRunner.class)
public class NewVacationRequestTest {
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
	public void succesfull_enter_comment_duration_and_institution_international_characters()
			throws Exception {
		endUser.loginSteps("nina.ramadan", "monkey");
		homeSteps.goNewVacation();
		homeSteps.verifyNewVacationPage();
		newRequest.makeANewVacation("Holiday", "ăîșț",
				"șșșțțță", 07, 14, 2014, 07, 15, 2014, "Other","a");
		newRequest
				.checkSuccesfullMessage("Your request completed successfully.");
		
		newRequest.checkErrorMessage("Evo Vacation Portlet is temporarily unavailable.");
	}
    @Test
    public void failed_enter_comment_duration_and_institution_international_characters()
			throws Exception {
		
		homeSteps.goNewVacation();
		homeSteps.verifyNewVacationPage();
		newRequest.makeANewVacation("Sick leave", "ăîșț",
				"șșșțțță", 07, 14, 2014, 07, 15, 2014, "Other","a");
		newRequest.checkErrorMessage("Your request failed to complete.");
	}
    
    
    
	@Test
	public void a_new_request_successfully() throws Exception {

		homeSteps.goNewVacation();
		homeSteps.verifyNewVacationPage();
		newRequest.makeANewVacation("Special vacation", "aaa", "bbb", 1, 10,
				2014, 20, 1, 2014, "Funeral","a");
		newRequest.checkSuccesfullMessage("Your request completed successfully.");
	}

	@Test
	public void a_new_request_failed() throws Exception {

		homeSteps.goNewVacation();
		newRequest.makeANewVacation("Special vacation", "aaa", "bbb", 1, 10,
				2014, 20, 1, 2014, "Funeral","a");
		newRequest.checkErrorMessage("Your request failed to complete.");
	}

}

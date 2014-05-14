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

/**
 * @author ninaramadan
 *
 */
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
	public void new_request_successfully() throws Exception {
		endUser.loginSteps("nina.ramadan", "monkey");
		homeSteps.goNewVacation();
		homeSteps.verifyNewVacationPage();
		//newRequest.click_signin_newrequest();
		//newRequest.selectAVacation("Special vacation","aaa","ddd","Funeral","a");
		//newRequest.enterStartDate(7, 28, 2013);
		//newRequest.enterEndDate(7, 29, 2013);
		//newRequest.click_buttonsave();	
		//newRequest.checkSuccesfullMessage("Your request completed successfully.");
		newRequest.makeANewVacation("Special vacation", "aaa", "bbb", 1, 10, 2014, 20, 1, 2014, "fff","Funeral","a");
		newRequest.checkSuccesfullMessage("Your request completed successfully.");}
	
	@Test
	public void new_request_failed() throws Exception {
		
		homeSteps.goNewVacation();
		homeSteps.verifyNewVacationPage();
		/*newRequest.click_signin_newrequest();
		newRequest.selectAVacation("Special vacation","aaa","ddd","Funeral","a");
		newRequest.enterStartDate(7, 28, 2013);
		newRequest.enterEndDate(7, 29, 2013);
		newRequest.click_buttonsave();	
		newRequest.checkSuccesfullMessage("Your request failed to complete.");*/
		newRequest.makeANewVacation("Special vacation", "aaa", "bbb", 1, 10, 2014, 20, 1, 2014, "fff","Funeral","a");
		newRequest.checkErrorMessage("Your request failed to complete.");
	}
	
}

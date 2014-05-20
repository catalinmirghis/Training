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

import tools.ReadMail;

import com.requirements.Application;
import com.steps.LogInSteps;
import com.steps.NewVacationRequestSteps;

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesRunner.class)
public class NewVacationRequestEmailVerifyTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9080/")
	public Pages pages;

	@Steps
	public NewVacationRequestSteps newRequest;

	@Steps
	public LogInSteps endUser;
	
	@Steps
	public ReadMail readEmail;

	@Test
	public void verifyIfTheRequestWasSent() throws Exception {
		endUser.loginSteps("catalin.mirghis", "monkey");
		endUser.goNewVacation();
		newRequest.makeANewVacation("Holiday", "aaa", "bbb", 1, 18, 2016, 1,
				20, 2016, "fff", "Funeral");
		newRequest.checkSuccesfullMessage("Your request completed successfully.");
		Thread.sleep(10000);
		readEmail.readLastMails();
		readEmail.verifyIfTheMailContentsMatch("18/1/2016","20/1/2016");

	}
}
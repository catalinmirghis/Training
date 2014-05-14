package com;

import net.thucydides.core.annotations.Issue;
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
import com.steps.LogInSteps;
import com.steps.MyRequestsSteps;

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesRunner.class)
public class MyRequestsTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9080/")
	public Pages pages;

	@Steps
	public LogInSteps endUser;

	@Steps
	public MyRequestsSteps myRequestsSteps;

	@Issue("#WIKI-1")
	@Test
	public void filter_MyRequests() {
		endUser.loginSteps("daniel.mocan", "monkey");
		myRequestsSteps.click_MyRequestPage();
		myRequestsSteps.verifyMyRequestsPage();
		myRequestsSteps.selectAFilterType("Holiday");
	}
}

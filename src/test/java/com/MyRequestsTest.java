package com;

import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.requirements.Application;
import com.steps.LogInSteps;
import com.steps.MyRequestsSteps;
import com.steps.NewVacationRequestSteps;

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesRunner.class)
public class MyRequestsTest {
	
	@Before
	public void SetUp(){
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		
		webdriver = new ChromeDriver();
	}

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9080/")
	public Pages pages;
	
	@Steps
	public LogInSteps endUser;

	@Steps
	public MyRequestsSteps myRequestsSteps;
	
	@Steps
	public NewVacationRequestSteps newRequest;

	@Issue("#WIKI-1")
	@Test
	public void filter_MyRequests() throws Exception {
		endUser.loginSteps("daniel.mocan", "monkey");
		endUser.goNewVacation();
		
		newRequest.click_signin_newrequest();
		newRequest.enterStartDate(8, 28, 2013);
		newRequest.selectAVacation("Sick leave","aaa","bbb","Funeral","a");
		newRequest.click_comment();
		newRequest.enter_a_comment("aaaa");
		newRequest.enterEndDate(9, 20, 2013);
		newRequest.click_buttonsave();
		
		myRequestsSteps.myReqests_Filter_Apply("Holiday");

	}
	
	@After
	public void tearDown(){
		webdriver.quit();
	}
}

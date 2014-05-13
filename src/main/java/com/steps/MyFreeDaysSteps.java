package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.HomePage;
import com.pages.LogInPage;
import com.pages.MyFreeDaysPage;

public class MyFreeDaysSteps extends ScenarioSteps {

	LogInPage loginPage;
	HomePage homePage;
	MyFreeDaysPage freeDayPage;

	@Step
	public void enterScreenName(String keyword) {
		loginPage.enter_ScreenName_keywords(keyword);

	}

	@Step
	public void enterPassword(String keyword) {
		loginPage.enter_Password_keywords(keyword);
	}

	@Step
	public void signButton() {
		loginPage.click_SignIn();
	}

	@Step
	public void is_the_home_page() {
		loginPage.open();
		getDriver().manage().window().maximize();
	}

	@Step
	public void verifyIfYouAreLoginIn() {
		loginPage.verifyThatYouAreLogIn();
	}

	@Step
	public void clickOnSignIn() {
		loginPage.click_SignIn();
	}

	@Step
	public void verifyNewVacationPage() {
		homePage.verifyThatYouAreOnNewVacationPage();
	}
	
	@Step
	public void clickMyFreeDays (){
		freeDayPage.click_freeDays();
	}
	
	
	@StepGroup
	public void loginSteps(String ScreenName, String Password) {
		is_the_home_page();
		enterScreenName(ScreenName);
		enterPassword(Password);
		signButton();
		verifyIfYouAreLoginIn();
		clickOnSignIn();
		verifyNewVacationPage();
		clickMyFreeDays();

	}
}
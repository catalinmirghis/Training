package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.FreeDaysHistoryPage;
import com.pages.HomePage;
import com.pages.LogInPage;
import com.pages.MyFreeDaysPage;

public class FreeDaysHistorySteps extends ScenarioSteps {

	LogInPage loginPage;
	HomePage homePage;
//	MyFreeDaysPage freeDayPage;
	FreeDaysHistoryPage freeDayHistoryPage;

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
	public void goNewVacation() {
		homePage.click_SignIn();
	}

	@Step
	public void verifyNewVacationPage() {
		homePage.verifyThatYouAreOnNewVacationPage();
	}
	
	@Step
	public void clickFreeDaysHistory (){
		freeDayHistoryPage.click_freeDaysHistory();
	}
	
	@Step
	public void click_anniversaryCheckbox(){
		freeDayHistoryPage.click_anniversaryCheckbox();
	}
	
	@Step
	public void click_applyButton(){
		freeDayHistoryPage.click_applyButton();
	}
	
//	@Step
//	public void clickMyFreeDays (){
//		freeDayPage.click_freeDays();
//	}
//	
	
	@StepGroup
	public void loginSteps(String ScreenName, String Password) {
		is_the_home_page();
		enterScreenName(ScreenName);
		enterPassword(Password);
		signButton();
		verifyIfYouAreLoginIn();
		goNewVacation();
		verifyNewVacationPage();
//		clickMyFreeDays();
		clickFreeDaysHistory();

	}
}
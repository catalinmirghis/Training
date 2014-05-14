package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.HomePage;

/**
 * @author ninaramadan
 *
 */
public class HomeSteps extends ScenarioSteps {
	private static final long serialVersionUID = 1L;
	HomePage homePage;
	@Step
	public void goNewVacation() {
		homePage.clickNewVacationMenu();
	}

	@Step
	public void verifyNewVacationPage() {
		homePage.verifyThatYouAreOnNewVacationPage();
	}
}
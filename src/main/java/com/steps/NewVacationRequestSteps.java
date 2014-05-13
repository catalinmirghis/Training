package com.steps;

import org.junit.Assert;

import com.pages.DictionaryPage;
import com.pages.NewVacationRequestPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import static ch.lambdaj.Lambda.join;
import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

public class NewVacationRequestSteps extends ScenarioSteps {

	NewVacationRequestPage newVacationRequest;

	@Step
	public void click_signin_newrequest() {
		newVacationRequest.click_SignIn();
	}

	

	@Step
	public void click_input_Startdate() {
		newVacationRequest.click_input_startdate();
	}

	@Step
	public void click_input_Enddate() {
		newVacationRequest.click_input_enddate();
	}

	@Step
	public void selectavacation(String vacationType) {
		newVacationRequest.selectAVacationType(vacationType);
	}

	@Step
	public void click_comment() {
		newVacationRequest.Click_comment();
	}

	@Step
	public void enter_a_comment(String keyword) {
		newVacationRequest.enter_comment(keyword);
	}

	@Step
	public void click_buttonsave() {
		newVacationRequest.click_Save();
	}

	@Step
	public void click_buttoncancel() {
		newVacationRequest.click_Cancel();
	}
}

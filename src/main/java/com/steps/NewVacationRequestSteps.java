package com.steps;

import org.junit.Assert;

import com.pages.CalendarPage;
import com.pages.DictionaryPage;
import com.pages.NewVacationRequestPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import static ch.lambdaj.Lambda.join;
import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

/**
 * @author ninaramadan
 *
 */
public class NewVacationRequestSteps extends ScenarioSteps {

	NewVacationRequestPage newVacationRequest;
	CalendarPage calendarPage;

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

	@Step
	public void enterStartDate(int month, int day, int year) throws Exception {

		newVacationRequest.click_input_startdate();
		calendarPage.setDate(month, day, year);

		Thread.sleep(3000);
	}

	@Step
	public void enterEndDate(int month, int day, int year) throws Exception {

		newVacationRequest.click_input_enddate();
		calendarPage.setDate(month, day, year);

		Thread.sleep(3000);
	}

	/*
	 * @StepGroup public void newRequestSteps(String vacationType,String
	 * keyword){ click_signin_newrequest(); click_input_Startdate();
	 * 
	 * click_input_Enddate(); selectavacation(vacationType); click_comment();
	 * enter_a_comment(keyword); click_buttonsave(); }
	 */
}

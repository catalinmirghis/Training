package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.CalendarPage;
import com.pages.NewVacationRequestPage;

/**
 * @author ninaramadan
 * 
 */
public class NewVacationRequestSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;
	NewVacationRequestPage newVacationRequest;
	CalendarPage calendarPage;
	HomeSteps homeSteps;

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
	public void selectAVacation(String vacationType, String keywordDomain,
			String KeywordInstitution, String value,String com) {
		newVacationRequest.selectAVacationType(vacationType, keywordDomain,
				KeywordInstitution, value,com);
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
	public void click_buttoncancel() {
		newVacationRequest.click_Cancel();
	}

	@Step
	public void enterStartDate(int month, int day, int year) throws Exception {

		click_input_Startdate();
		calendarPage.setDate(month, day, year);

		Thread.sleep(3000);
	}

	@Step
	public void enterEndDate(int month, int day, int year) throws Exception {

		newVacationRequest.click_input_enddate();
		calendarPage.setDate(month, day, year);

		Thread.sleep(3000);
	}

	@Step
	public void click_dropDown(String value) throws Exception {
		newVacationRequest.click_a_special_vacation(value);
		Thread.sleep(4000);
	}

	@Step
	public void checkErrorMessage(String message) {
		newVacationRequest.checkThatYouReceiveTheErrorMessage(message);
	}

	@Step
	public void checkSuccesfullMessage(String message) {
		newVacationRequest.checkThatYouReceiveTheSuccessMessage(message);
	}

	@Step
	public void click_buttonsave() throws Exception {
		newVacationRequest.click_Save();
		// return newVacationRequest.getVacationId();
//		String Vacationd = newVacationRequest.getVacationId();
	}

	@Step
	public String getID() {
		return newVacationRequest.getVacationId();
	}
	
	@Step
	public void findRequest(String VacationId){
		newVacationRequest.findRequest(VacationId);
		
	}

	@StepGroup
	public void makeANewVacation(String vacationType, String keywordDomain,
			String KeywordInstitution, int startMonth, int startDay,
			int startYear, int endMonth, int endDay, int endYear,
			 String typeOfSpecialVacation,String com) throws Exception {
		click_signin_newrequest();
		selectAVacation(vacationType, keywordDomain, KeywordInstitution, typeOfSpecialVacation,com
				);
		enterStartDate(startMonth, startDay, startYear);
		enterEndDate(endMonth, endDay, endYear);
		click_buttonsave();
		 
	}

}

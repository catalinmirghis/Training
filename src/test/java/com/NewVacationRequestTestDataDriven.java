package com;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;
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
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom("request.csv")
public class NewVacationRequestTestDataDriven {
	String vacationType, keywordDomain, KeywordInstitution, com,
			typeOfSpecialVacation;
	int startMonth, startDay, startYear, endMonth, endDay, endYear;
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

	@Qualifier
	public String getVacationType() {
		return vacationType;
	}

	public void setVacationType(String vacationType) {
		this.vacationType = vacationType;
	}

	public String getKeywordDomain() {
		return keywordDomain;
	}

	public void setKeywordDomain(String keywordDomain) {
		this.keywordDomain = keywordDomain;
	}

	public String getKeywordInstitution() {
		return KeywordInstitution;
	}

	public void setKeywordInstitution(String keywordInstitution) {
		KeywordInstitution = keywordInstitution;
	}

	

	public String getCom() {
		return com;
	}

	public void setCom(String com) {
		this.com = com;
	}

	public String getTypeOfSpecialVacation() {
		return typeOfSpecialVacation;
	}

	public void setTypeOfSpecialVacation(String typeOfSpecialVacation) {
		this.typeOfSpecialVacation = typeOfSpecialVacation;
	}

	

	@Test
	public void failed_new_request_data_driven() throws Exception {
		
		homeSteps.goNewVacation();
		homeSteps.verifyNewVacationPage();
		newRequest.makeANewVacation(vacationType, keywordDomain,
				KeywordInstitution, startMonth, startDay, startYear, endMonth,
				endDay, endYear, typeOfSpecialVacation,com);
		newRequest.checkErrorMessage("Your request failed to complete.");
		
	}
	@Test
	public void succesfull_new_request_data_driven() throws Exception {
		endUser.loginSteps("nina.ramadan", "monkey");
		homeSteps.goNewVacation();
		homeSteps.verifyNewVacationPage();
	newRequest.makeANewVacation(vacationType, keywordDomain,
				KeywordInstitution, startMonth, startDay, startYear, endMonth,
				endDay, endYear, typeOfSpecialVacation, com);
		newRequest
			.checkSuccesfullMessage("Your request completed successfully.");
	
}
//
//	 @Test
//	public void new_request_data_driven() throws Exception {
//		endUser.loginSteps("nina.ramadan", "monkey");
//		homeSteps.goNewVacation();
//		homeSteps.verifyNewVacationPage();
//		newRequest.makeANewVacation("Special vacation", "aaa", "bbb",
//				startMonth, startDay, startYear, endMonth, endDay, endYear,
//				"Funeral", "a");
//		newRequest
//				.checkSuccesfullMessage("Your request completed successfully.");
//
//	}

}

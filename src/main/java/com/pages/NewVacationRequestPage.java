package com.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author ninaramadan
 * 
 */
@DefaultUrl("http://192.168.1.68:9080/web/java-department/new-vacation")
public class NewVacationRequestPage extends PageObject {

	@FindBy(css = "i[class='icon-home']")
	private WebElementFacade NewVacationRequest;

	@FindBy(id = "_evovacation_WAR_EvoVacationportlet_startDate")
	private WebElementFacade StartDate;

	@FindBy(id = "_evovacation_WAR_EvoVacationportlet_endDate")
	private WebElementFacade EndDate;

	@FindBy(id = "_evovacation_WAR_EvoVacationportlet_newVacationComment")
	private WebElementFacade Comment;

	@FindBy(css = "textarea[name='commentContent']")
	private WebElementFacade InputComment;

	@FindBy(id = "_evovacation_WAR_EvoVacationportlet_saveButton")
	private WebElementFacade SaveButton;

	@FindBy(id = "_evovacation_WAR_EvoVacationportlet_cancelButton")
	private WebElementFacade CancelButton;

	@FindBy(css = "#_evovacation_WAR_EvoVacationportlet_duration input")
	private WebElementFacade Durationinput;

	@FindBy(css = "#_evovacation_WAR_EvoVacationportlet_institution input")
	private WebElementFacade InstitutionInput;

	
	@FindBy(css = "select[name='specialReason']")
	private WebElementFacade ChooseASpecialVacation;

	public void click_SignIn() {
		element(NewVacationRequest).click();
	}

	public void click_input_startdate() {
		StartDate.click();
	}

	public void click_input_enddate() {
		EndDate.click();
	}

	public void enter_duration_domain(String keyword) {
		Durationinput.type(keyword);
	}

	public void enter_institutionname(String keyword) {
		InstitutionInput.type(keyword);

	}

	public void click_a_special_vacation(String value) {
		ChooseASpecialVacation.selectByVisibleText(value);
	}

	public void selectAVacationType(String vacationType, String keywordDomain,
			String KeywordInstitution, String value,String com) {
		String var;
		switch (vacationType) {
		case "Holiday": {
			var = "CO";
			WebElement element = getDriver().findElement(
					By.cssSelector("#_evovacation_WAR_EvoVacationportlet_type_"
							+ var));
			element.click();
			Click_comment();
			enter_comment(com);
			break;
		}
		case "Vacation without payment": {
			var = "CF";
			WebElement element = getDriver().findElement(
					By.cssSelector("#_evovacation_WAR_EvoVacationportlet_type_"
							+ var));
			element.click();
			enter_duration_domain(keywordDomain);
			enter_institutionname(KeywordInstitution);
			Click_comment();
			enter_comment(com);
			break;
		}
		case "Special vacation": {
			var = "CS";
			WebElement element = getDriver().findElement(
					By.cssSelector("#_evovacation_WAR_EvoVacationportlet_type_"
							+ var));
			element.click();
			click_a_special_vacation(value);
			Click_comment();
			enter_comment(com);
			break;
		}
		case "Sick leave":
			var = "CM";
			WebElement element = getDriver().findElement(
					By.cssSelector("#_evovacation_WAR_EvoVacationportlet_type_"
							+ var));
			element.click();
			Click_comment();
			enter_comment(com);
			break;
		}
	}

	public void Click_comment() {
		Comment.click();
	}

	public void enter_comment(String com) {
		InputComment.type(com);
	}

	public void click_Save() {
		SaveButton.click();

	}

	public void click_Cancel() {
		CancelButton.click();
	}

	public void checkThatYouReceiveTheErrorMessage(String message) {

		String elementText = getDriver()
				.findElement(
						By.cssSelector(".portlet-body >.portlet-msg-error"))
				.getText().trim();
//		if (!elementText.toLowerCase().contains(message.toLowerCase())) {
			Assert.assertTrue("Thef containerf does not contain message!" + message,elementText.toLowerCase().contains(message.toLowerCase()));
			System.out.println(message);
		
	}

	public void checkThatYouReceiveTheSuccessMessage(String message) {
		String elementText = getDriver()
				.findElement(By.cssSelector(".portlet-msg-success")).getText()
				.trim();
		if (!elementText.toLowerCase().contains(message.toLowerCase())) {
			Assert.fail(String.format(
					"Thef containerf does not contain message!", message));
			System.out.println(message);
		}
	}


	public void findRequest(String VacationId) {
		getDriver()
				.get("http://192.168.1.68:9080/web/lt/new-vacation?p_p_auth=nt6olSiz&p_p_id=evovacation_WAR_EvoVacationportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&_evovacation_WAR_EvoVacationportlet_menuItem=my-requests&_evovacation_WAR_EvoVacationportlet_myRequestState=view-vacation&_evovacation_WAR_EvoVacationportlet_backMenuItem=my-requests&_evovacation_WAR_EvoVacationportlet_vacationId=2312");
	}

	public String getVacationId() {
		String[] urlList = getDriver().getCurrentUrl().split("=");
		return urlList[urlList.length - 1];
	}

}

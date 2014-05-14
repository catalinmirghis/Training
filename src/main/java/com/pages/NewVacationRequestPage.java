package com.pages;

import java.util.List;

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
	
	@FindBy(id="_evovacation_WAR_EvoVacationportlet_newVacationComment")
	private WebElementFacade Comment;
	
	@FindBy(id="_evovacation_WAR_EvoVacationportlet_commentContent")
	private WebElementFacade InputComment;
	
	@FindBy(id="_evovacation_WAR_EvoVacationportlet_saveButton")
	private WebElementFacade SaveButton;
	
	@FindBy(id="_evovacation_WAR_EvoVacationportlet_cancelButton")
	private WebElementFacade CancelButton;

	public void click_SignIn() {
		element(NewVacationRequest).click();
	}

	
	public void click_input_startdate() {
		StartDate.click();
	}
	public void click_input_enddate(){
		EndDate.click();
	}

	public void selectAVacationType(String vacationType) {
		String var;
		switch(vacationType){
		case "Holiday": var = "CO";
		case "Vacation without payment" : var = "CF";
		case "Special vacation" : var = "CS"; 
		case "Sick leave" : var = "CM";
		WebElement element = getDriver().findElement(By.cssSelector(String.format("#_evovacation_WAR_EvoVacationportlet_type_"+ var)));
		if(!(element.isSelected()))
			element.click();
		break;
		}
		}
	
	
	public void Click_comment()
	{Comment.click();
	}
	
	public void enter_comment(String keyword){
		InputComment.type(keyword);
	}
	
	public void click_Save(){
		SaveButton.click();
	}
	public void click_Cancel(){
		CancelButton.click();
	}
	
}
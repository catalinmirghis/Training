package com.steps;

import java.util.List;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.steps.ScenarioSteps;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.pages.MyRequestsPage;

public class MyRequestsSteps extends ScenarioSteps {

	MyRequestsPage myrequestspage;

	@Step
	public void click_MyRequestPage() {
		myrequestspage.click_MyRequests_Page();
	}

	@Step
	public void verifyMyRequestsPage() {
		myrequestspage.verifyThatYouAreOnMyRequestsPage();
	}

	@Step
	 public void selectAFilterType(String vacationType) {
		  String var;
		  switch(vacationType){
		  case "Holiday": var = "HOLIDAYCheckbox";
		  case "Vacation without payment" : var = "VACATION_WITHOUT_PAYMENTCheckbox";
		  case "Special vacation" : var = "SPECIAL_VACATIONCheckbox"; 
		  case "Sick leave" : var = "SICK_LEAVE";
		  case "Show only future vacations" : var = "futureVacationsCheckbox";
		  //System.out.println(vacationType);
		  System.out.println(vacationType);
		  WebElement element = getDriver().findElement(By.cssSelector(String.format("_evovacation_WAR_EvoVacationportlet_"+ var)));
		  if (element.getAttribute("value").toString().toLowerCase()
			.contains(vacationType.toLowerCase()))
			  System.out.println(element);
		  if(!(element.isSelected()))
			  System.out.println(vacationType);
		   element.click();
		  break;
		  }
	}
//	public void selectAFilterType(String vacationType) {
//		boolean found = false;
//		List<WebElement> elements = getDriver().findElements(
//				By.cssSelector("span[class='aui-field-content'] label[class='aui-choice-label']"));
//		for (WebElement element : elements) {
//			System.out.println(element);
//			if (element.getAttribute("value").toString().toLowerCase()
//					.contains(vacationType.toLowerCase()))
//				System.out.println(element);
//			if (!(element.isSelected()))
//				element.findElement(
//						By.cssSelector("span[class='aui-field-element aui-field-label-right'] input[id='_evovacation_WAR_EvoVacationportlet_futureVacationsCheckbox']"))
//						.click();
//			found = true;
//		}
//
//		Assert.assertTrue("The vacation type was not founded", found);
//
//	}

	// @StepGroup
	// public void myReqests_Filter(){
	// click_MyRequestPage();
	// verifyMyRequestsPage();
	// selectAVacationType("dads");
	// }

}
package com.steps;

import java.util.List;
import java.util.ArrayList;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.pages.MyRequestsPage;
import com.pages.NewVacationRequestPage;

public class MyRequestsSteps extends ScenarioSteps {

	public MyRequestsSteps(Pages pages) {
		super(pages);
	}

	public String var;
	MyRequestsPage myrequestspage;
	NewVacationRequestPage newVacationRequestPage;

	@Step
	public void click_MyRequestPage() {
		myrequestspage.click_MyRequests_Page();
	}

	@Step
	public void click_Apply_Button() {
		myrequestspage.click_Apply_Button();
	}

	@Step
	public void verifyMyRequestsPage() {
		myrequestspage.verifyThatYouAreOnMyRequestsPage();
	}

	@Step
	public void selectAFilterRequest_VacationType(String vacationType) {
		switch (vacationType) {
		case "Holiday":
			var = "HOLIDAYCheckbox";
			break;
		case "Vacation Without Payment":
			var = "VACATION_WITHOUT_PAYMENTCheckbox";
			break;
		case "Special Vacation":
			var = "SPECIAL_VACATIONCheckbox";
			break;
		case "Sick Leave":
			var = "SICK_LEAVECheckbox";
			break;
		case "Show only future vacations":
			var = "futureVacationsCheckbox";
			break;
		default:
			var = "ALLCheckbox";
		}
		WebElement element = getDriver()
				.findElement(
						By.cssSelector(String
								.format("#_evovacation_WAR_EvoVacationportlet_"
										+ var)));
		if (!(element.isSelected()))
			element.click();

	}

	@Step
	public void selectAFilterRequest_DaysNumber(String vacationDays) {
		switch (vacationDays) {
		case "1-5":
			var = "FIFTHCheckbox";
			break;
		case "6-10":
			var = "TENTHCheckbox";
			break;
		case "11-20":
			var = "TWENTIETHCheckbox";
			break;
		case "21-50":
			var = "FIFTIETHCheckbox";
			break;
		case "51+":
			var = "RESTCheckbox";
			break;
		default:
			var = "ALLCheckbox";
		}
		WebElement element = getDriver()
				.findElement(
						By.cssSelector(String
								.format("#_evovacation_WAR_EvoVacationportlet_"
										+ var)));
		if (!(element.isSelected()))
			element.click();

	}

	@Step
	public void selectAFilterRequest_VacationStatus(String vacationStatus) {
		switch (vacationStatus) {
		case "Pending":
			var = "PENDINGCheckbox";
			break;
		case "Approved":
			var = "APPROVEDCheckbox";
			break;
		case "Rejected":
			var = "REJECTEDCheckbox";
			break;
		case "Withdrawn":
			var = "WITHDRAWNCheckbox";
			break;
		case "Canceled":
			var = "CANCELEDCheckbox";
			break;
		default:
			var = "ALLCheckbox";

		}
		WebElement element = getDriver()
				.findElement(
						By.cssSelector(String
								.format("#_evovacation_WAR_EvoVacationportlet_"
										+ var)));
		if (!(element.isSelected()))
			element.click();

	}

	@Step
	public void selectRequest(String vacationId) {
		myrequestspage.clickOnARequestIsInTheTableList(vacationId);
	}

	// @Step
	// public void click_NextPage(){
	// myrequestspage.click_NextPage();
	// }

	public void verifySearchResultsContainsID(String VacationId) {
		boolean found = false;

		String noOfPagesContainer = getDriver()
				.findElement(
						By.cssSelector("div.page-links > span.aui-paginator-current-page-report.aui-paginator-total"))
						.getText().trim();

		int noOfPages = tools.StringUtils.getAllIntegerNumbersFromString(
				noOfPagesContainer).get(1);

		System.out.println(noOfPages);

		for (int i = 0; i < noOfPages; i++) {
			List<WebElement> searchResults1 = getDriver()
					.findElements(
							By.cssSelector(".portlet-section-body.results-row .align-left.col-1"));
			// List<WebElement> searchResults2 =
			// getDriver().findElements(By.cssSelector(".portlet-section-body.results-row.last"));
			List<WebElement> searchResults3 = getDriver()
					.findElements(
							By.cssSelector(".portlet-section-alternate.results-row.alt .align-left.col-1"));

			List<WebElement> searchResults = new ArrayList<WebElement>();
			searchResults.addAll(searchResults1);
			// searchResults.addAll(searchResults2);
			searchResults.addAll(searchResults3);

			for (WebElement searchResult : searchResults) {
				boolean containsTerms = false;
				System.out.println(searchResult.getText());
				// $(searchResult).waitUntilVisible();
				List<WebElement> urls = getDriver()
						.findElements(
								By.cssSelector(".portlet-section-alternate.results-row.alt .align-left.col-1 a"));
				for (WebElement url : urls) {
					if (url.getAttribute("href").contains(
							VacationId.toLowerCase())) {
						containsTerms = true;
						
						searchResult.click();
						System.out.println(VacationId + " element found");

					}

					if (containsTerms) {
						found = true;
						// searchResult.click();
						System.out.println(VacationId + " element not found");
						if (i <= noOfPages && !found) {
							getDriver()
							.findElement(
									By.cssSelector(".aui-paginator-link.aui-paginator-next-link"))
									.click();
							waitABit(2000);
						}
					}
				}

			}
			Assert.assertTrue("Element was not found!", found);
		}
	}

	public void click_NextPage() {
		// boolean found = false;
		String noOfPagesContainer = getDriver()
				.findElement(
						By.cssSelector("span[class='aui-paginator-current-page-report aui-paginator-total']"))
						.getText().trim();

		int noOfPages = tools.StringUtils.getAllIntegerNumbersFromString(
				noOfPagesContainer).get(1);
		System.out.println(noOfPages);
		for (int i = 0; i <= noOfPages; i++) {
			if (i <= noOfPages) {
				getDriver()
				.findElement(
						By.cssSelector(".aui-paginator-link.aui-paginator-next-link"))
						.click();
			}
		}
	}

	@StepGroup
	public void myReqests_Filter_Apply(String selectVacationType,
			String selectDaysNumber, String selectVacationStatus) {
		click_MyRequestPage();
		verifyMyRequestsPage();
		selectAFilterRequest_VacationType(selectVacationType);
		selectAFilterRequest_DaysNumber(selectDaysNumber);
		selectAFilterRequest_VacationStatus(selectVacationStatus);
		click_Apply_Button();
	}

	@StepGroup
	public void clickPageDropDownFilter() {
		myrequestspage.clickPageDropDownFilter();
	}
}

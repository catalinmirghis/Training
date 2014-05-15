package com.pages;

import java.util.ArrayList;
import java.util.List;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@DefaultUrl("http://192.168.1.68:9080/web/java-department/new-vacation")
public class InboxPage extends PageObject {

	@FindBy(css = ".nav-list a[href*='menuItem=inbox']")
	private WebElementFacade Inbox;

	@FindBy(css = "ul[class='nav nav-tabs'] li:nth-child(2) a")
	private WebElementFacade AssignedToOthers;

	@FindBy(name = "_evovacation_WAR_EvoVacationportlet_allRowIds")
	private WebElementFacade CheckAll;

	@FindBy(id = "_evovacation_WAR_EvoVacationportlet_multipleApproveButton")
	private WebElementFacade ApproveAll;
	
	@FindBy (css = ".aui-button:nth-child(1).aui-button input")
	private WebElementFacade ApproveRequest;

	public void click_inbox() {
		Inbox.click();
	}

	public void click_assignedToOthers() {
		AssignedToOthers.click();
		AssignedToOthers.click();
	}

	public void click_checkAll() {
		CheckAll.click();
	}

	public void click_approveAll() {
		ApproveAll.click();

	}

	public void click_approveRequest(){
		ApproveRequest.click();
		ApproveRequest.click();
		
	}
	
	public static List<Integer> getAllIntegerNumbersFromString(String text) {
		List<Integer> listOfIntegers = new ArrayList<Integer>();
		String intNumber = "";
		char[] characters = text.toCharArray();
		for (int i = 0; i < characters.length; i++) {
			char ch = characters[i];
			if (Character.isDigit(ch)) {
				intNumber += ch;
				if (i == characters.length - 1) {
					listOfIntegers.add(Integer.parseInt(intNumber));
				}
			} else {
				if (intNumber != "") {
					listOfIntegers.add(Integer.parseInt(intNumber));
					intNumber = "";
				}
			}
		}
		Assert.assertTrue(
				"No matching integer was found in the provided string!",
				listOfIntegers.size() > 0);
		System.out.println(listOfIntegers.size());
		return listOfIntegers;
	}

	public void clickOnAnEmployeeLink(String... employeeName) {
		String noOfPagesContainer = getDriver()
				.findElement(
						By.cssSelector("span[class='aui-paginator-current-page-report aui-paginator-total']"))
				.getText().trim();
		int noOfPages = getAllIntegerNumbersFromString(noOfPagesContainer).get(
				2);
		System.out.println(noOfPages);
		boolean foundTerms = false;
		for (int i = 0; i < noOfPages; i++) {
			List<WebElement> searchResults = getDriver()
					.findElements(
							By.cssSelector("td[class='align-left col-2 col-employee-name  valign-middle'] > a"));
			for (WebElement searchResult : searchResults) {
				boolean containsTerms = true;
				$(searchResult).waitUntilVisible();
				for (String term : employeeName) {
					if (!searchResult.getText().toLowerCase()
							.contains(term.toLowerCase())) {
						containsTerms = false;
						break;
					}
				}
				if (containsTerms) {
					foundTerms = true;
					searchResult.click();
					waitABit(2000);
					break;
				}
			}

			if (i < (noOfPages - 1) && !foundTerms) {
				getDriver()
						.findElement(
								By.cssSelector("span[class='aui-paginator-link aui-paginator-next-link']"))
						.click();
			} else
				break;
		}
		Assert.assertTrue(
				"No record containing the searched terms was found in the table!",
				foundTerms);
	}

	public void openRequest(String requestID) {
		getDriver().findElement(
				By.cssSelector("a[href*='vacationId=" + requestID + "']"))
				.click();

	}

	public void verifyThatYouAreLogIn() {
		WebElement dockBar = getDriver()
				.findElement(By.cssSelector("#dockbar"));
		Assert.assertTrue("You are not logged in!", dockBar.isDisplayed());
	}

}
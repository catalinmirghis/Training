package com.steps;

import com.pages.WithdrawVacationRequestPage;

import net.thucydides.core.annotations.Step;

public class WithdrawVacationRequestSteps {
	WithdrawVacationRequestPage withDrawVacationPage;

	@Step
	public void clickOnWithDraw() {
		withDrawVacationPage.clickWithdraw();
	}

}

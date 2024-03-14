package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.LandingPage;
import testBase.BaseClass;
import utilities.DataProviders;

//
public class TC_002_HomeLoanDDT extends BaseClass {
	@Test(priority = 1, dataProvider = "HomeLoanVerificationData", dataProviderClass = DataProviders.class)

	// dataProvider will pass data in method arguments
	public void homeLoanTest(String LoanAmount, String InterestRate, String LoanTenure, String LoanEMI,
			String TotalInterestPayable, String TotalPayment) throws IOException {
		BasePage bp = new BasePage(driver);
		bp.logger.info("*** Starting TC_002_HomeLoanDDT :homeLoanTest ***");
		try {
			LandingPage l = new LandingPage(driver);

			l.clickHomeLoanTab();
			l.setLoanAmount(LoanAmount);
			l.setLoanIntrest(InterestRate);
			l.setLoanTenure(LoanTenure);

			timeUnitSleep(3);
			
			
			scrollPageToElement(l.scrollPointElement1);
			if (l.getEmiAmountValue().contains(LoanEMI) && l.getTotalInterestValue().contains(TotalInterestPayable)
					&& l.getTotalPaymentValueLink().contains(TotalPayment)) {
				bp.logger.info("validation Checked Successfully");
				l.extractDataFromTable("HomeLoan");
				scrollPageToElement(l.scrollPointElement2);
				l.clickYearTableExapnd();
				l.extractYearMontlyDataFromTable("HomeLoanInDetails");
				timeUnitSleep(3);
				Assert.assertTrue(true);
			} else {
				bp.logger.info("validation Checking Failed");
				Assert.assertTrue(false);
			}
			bp.logger.info("*** Finishing TC_002_HomeLoanDDT :homeLoanTest ***");
		} catch (Exception e) {
			System.out.println(e);
			bp.logger.error("TC_002_HomeLoanDDT :homeLoanTest Failed due to " + e);
			Assert.fail();
		}
	}
}

package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.LandingPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_001_CarLoanDDT extends BaseClass {

	@Test(priority = 0, dataProvider = "CarLoanVerificationData", dataProviderClass = DataProviders.class)
	public void carLoanTest(String CarLoanAmount, String InterestRate, String LoanTenure, String LoanEMI,
			String TotalInterestPayable, String TotalPayment) throws IOException {
		BasePage bp = new BasePage(driver);
		bp.logger.info("*** Starting TC_001_CarLoanTest :carLoanTest ***");
		try {
			LandingPage l = new LandingPage(driver);
			l.clickCarLoanTab();
			l.setLoanAmount(CarLoanAmount);
			l.setLoanIntrest(InterestRate);
			l.setLoanTenure(LoanTenure);

			timeUnitSleep(3);
			
			scrollPageToElement(l.scrollPointElement1);
			if (l.getEmiAmountValue().contains(LoanEMI) && l.getTotalInterestValue().contains(TotalInterestPayable)
					&& l.getTotalPaymentValueLink().contains(TotalPayment)) {
				bp.logger.info("validation Checked Successfully");
				l.extractDataFromTable("CarLoan");
				scrollPageToElement(l.scrollPointElement2);
				l.clickYearTableExapnd();
				l.extractYearMontlyDataFromTable("CarLoanInDetails");
				timeUnitSleep(3);
				Assert.assertTrue(true);
			} else {
				bp.logger.info("validation Check Failed");
				Assert.assertTrue(false);
			}
			bp.logger.info("*** Finishing TC_001_CarLoanTest :carLoanTest ***");

		} catch (Exception e) {
			System.out.println(e);
			bp.logger.error("TC_001_CarLoanTest :carLoanTest Failed due to " + e);
			Assert.fail();
		}

	}

}

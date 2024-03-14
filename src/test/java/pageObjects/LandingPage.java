package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.ExcelDataFile;

public class LandingPage extends BasePage {
	JavascriptExecutor javascriptExecutor;

	// passing driver to parent class BasePage
	public LandingPage(WebDriver driver) throws IOException {
		super(driver);
		javascriptExecutor = (JavascriptExecutor) driver;

	}

	//menu bar
	@FindBy(xpath = "//a[@id='menu-item-dropdown-2696']")
	WebElement menuItemCalculatorLink;

	//loan calculator in menu
	@FindBy(xpath = "//a[text()='Loan Calculator']")
	WebElement loanCalculatorLink;

	//car loan calculator
	@FindBy(xpath = "//li[@id='car-loan']//a")
	public
	WebElement carLoanTabLink;

	//home loan calculator
	@FindBy(xpath = "//li[@id='home-loan']//a")
	public
	WebElement homeLoanTabLink;

	//input loan amount
	@FindBy(xpath = "//input[@id='loanamount']")
	WebElement loanAmountInputLink;

	//input loan interest
	@FindBy(xpath = "//input[@id='loaninterest']")
	WebElement loanInterestInputLink;

	//input loan tenure 
	@FindBy(xpath = "//input[@id='loanterm']")
	WebElement loanTenureInputLink;

	//year button 
	@FindBy(xpath = "//input[@id='loanyears']")
	WebElement loanYearLink;

	//month button
	@FindBy(xpath = "//input[@id='loanmonths']")
	WebElement loanMonthLink;

	//loan emi amount per month
	@FindBy(xpath = "//div[@id='emiamount']/p/span")
	WebElement emiAmountValueLink;

	//total interest amount for loan
	@FindBy(xpath = "//div[@id='emitotalinterest']/p/span")
	WebElement totalInterestValueLink;

	//total amount to pay 
	@FindBy(xpath = "//div[@id='emitotalamount']/p/span")
	public WebElement totalPaymentValueLink;

	//expand the table years
	@FindBy(xpath = "//td[contains(@class,'paymentyear')]")
	List<WebElement> yearTableExapndLink;

	// class was common so tr[1]
	//table header row
	@FindBy(xpath = "//div[@id='emipaymenttable']/table/tbody/tr[1]")
	WebElement emiPaymentTableHeaderRow;

	//year wise list
	@FindBy(xpath = "//div[@id='emipaymenttable']/table/tbody/tr[contains(@class, 'yearlypaymentdetails')]")
	List<WebElement> emiPaymentTableDataRows;

	//margin for every year
	@FindBy(xpath = "//div[@id='emipaymenttable']//tr[contains(@class,'monthlypaymentdetails')]")
	List<WebElement> emiPaymentTableMonthlyDataRows;
	
	//monthly data list
	@FindBy(xpath = "//div[@id='emipaymenttable']//tr[contains(@class,'monthlypaymentdetails')]//tr")
	List<WebElement> emiPaymentTableMonthlyDataRows1;
	
	//every element in the table
	@FindBy(xpath = "//div[@id='emipaymenttable']//tr[contains(@class,'monthlypaymentdetails')]//tr//td")
	List<WebElement> emiPaymentTableMonthlyDataRows2;
	
	@FindBy(id = "loantermsteps")
	public WebElement scrollPointElement1;

	@FindBy(id = "yearheader")
	public WebElement scrollPointElement2;
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	//click on car loan tab
	public void clickCarLoanTab() {
		try {
			carLoanTabLink.click();
			logger.info("car loan tab clicked");
		} catch (Exception e) {
			logger.info("car loan tab clicking failed");
		}
	}

	//click on home loan tab 
	public void clickHomeLoanTab() {
		try {
			homeLoanTabLink.click();
			logger.info("home loan tab clicked");
		} catch (Exception e) {
			logger.info("home loan tab clicking failed");
		}
	}

	//click on menu 
	public void clickMenuItemCalculator() {
		try {
			menuItemCalculatorLink.click();
			logger.info("MenuItem Calculator clicked");
		} catch (Exception e) {
			logger.info("MenuItem Calculator clicking failed");
		}
	}

	//after clicking menu select loan calculator
	public void clickLoanCalculator() {
		try {
			loanCalculatorLink.click();
			logger.info("Loan Calculator clicked");
		} catch (Exception e) {
			logger.info("Loan Calculator clicking failed");
		}
	}

	//input in loan amount
	public void setLoanAmount(String amount) {
		try {
			loanAmountInputLink.clear();
			loanAmountInputLink.sendKeys(amount);
			logger.info("Loan Ammount setting done");
		} catch (Exception e) {
			logger.info("Loan Ammount setting failed");
		}

	}

	//input in loan interest
	public void setLoanIntrest(String interestRate) {
		try {
			javascriptExecutor.executeScript("arguments[0].value='" + interestRate + "'", loanInterestInputLink);
			loanInterestInputLink.click();
			logger.info("Loan Interest setting done");
		} catch (Exception e) {
			logger.info("Loan Interest setting failed");
		}
	}

	//input in loan tenure
	public void setLoanTenure(String tenure) {
		try {
			loanTenureInputLink.clear();
			javascriptExecutor.executeScript("arguments[0].value='" + tenure + "'", loanTenureInputLink);
			loanTenureInputLink.click();
			logger.info("Loan Tenure setting done");
		} catch (Exception e) {
			logger.info("Loan Tenure setting failed");
		}
	}

	//click on year
	public void clickLoanYear() {
		try {
			loanYearLink.click();
			logger.info("Loan Year Clicked");
		} catch (Exception e) {
			logger.info("Loan Year Clicking failed");
		}

	}

	//click on month
	public void clickLoanMonth() {
		try {
			loanMonthLink.click();
			logger.info("Loan Month Clicked");
		} catch (Exception e) {
			logger.info("Loan Month Clicking failed");
		}

	}

	//get the emi amount 
	public String getEmiAmountValue() {
		try {
			String emiAmount = emiAmountValueLink.getText();
			logger.info("Emi Ammount got successfully ");
			return emiAmount;
		} catch (Exception e) {
			logger.info("Emi Ammount got failed ");
			return "";
		}
	}

	//get the total interest amount
	public String getTotalInterestValue() {
		try {
			String totalInterestValue = totalInterestValueLink.getText();
			logger.info("Total Interest Value got successfully");
			return totalInterestValue;
		} catch (Exception e) {
			logger.info("Total Interest Value got failed ");
			return "";
		}
	}

	//get the total amount with interest to pay
	public String getTotalPaymentValueLink() {
		try {
			String totalPaymentValue = totalPaymentValueLink.getText();
			logger.info("Total Payment Value got successfully");
			return totalPaymentValue;
		} catch (Exception e) {
			logger.info("Total Payment Value got failed ");
			return "";
		}
	}

	//expanding the table by clicking on the years 
	public void clickYearTableExapnd() throws InterruptedException {
		try {
			for (WebElement w : yearTableExapndLink) {
				w.click();
				timeUnitSleepMili(1000);
			}
			logger.info("Year Table Expanded");
		} catch (Exception e) {
			logger.info("Year Table Expand failed");
		}
	}

	//extracting data for the table in years basis
	public void extractDataFromTable(String sheetName) {
		try {
			ExcelDataFile excelfile = new ExcelDataFile(
					System.getProperty("user.dir") + "\\TestData\\TestOutputData.xlsx");

			if (excelfile.isSheetExist(sheetName)) {
				excelfile.removeSheet(sheetName);
			}
			excelfile.addSheet(sheetName);

			List<WebElement> columns = emiPaymentTableHeaderRow.findElements(By.tagName("th"));

			// we are printing the headers or table attribute names
			// only 1st row data input
			int colNum = 1;
			System.out.println("columns.size() :" + columns.size());
			for (int i = 0; i < columns.size(); i++) {
				if (!(columns.get(i).getText().isBlank() || columns.get(i).getText().isEmpty())) {
					System.out.println(columns.get(i).getText());
					excelfile.setCellData(sheetName, colNum, 1, columns.get(i).getText());
					colNum++;
				}
			}

			//here we are getting the data from the table and adding the rows
			for (int i = 0; i < emiPaymentTableDataRows.size(); i++) {
				columns = emiPaymentTableDataRows.get(i).findElements(By.tagName("td"));
				for (int j = 0; j < columns.size(); j++) {
					System.out.println(columns.get(j).getText());
					excelfile.setCellData(sheetName, j + 1, i + 2, columns.get(j).getText());
				}
			}
			logger.info(" Yearly Data From Table extracted successfully");

		} catch (Exception e) {
			System.out.println(e);
			logger.info("Yearly Data extraction From Table failed");
		}
	}

	//extracting data for the table in monthly basis
	public void extractYearMontlyDataFromTable(String sheetName) {
		try {
			ExcelDataFile excelfile = new ExcelDataFile(
					System.getProperty("user.dir") + "\\TestData\\TestOutputData.xlsx");

			if (excelfile.isSheetExist(sheetName)) {
				excelfile.removeSheet(sheetName);
			}
			excelfile.addSheet(sheetName);

			List<WebElement> columns = emiPaymentTableHeaderRow.findElements(By.tagName("th"));

			// we are printing the headers or table attribute names
			// only 1st row data input
			int colNum = 1;
			System.out.println("columns.size() :" + columns.size());
			for (int i = 0; i < columns.size(); i++) {

				if (!(columns.get(i).getText().isBlank() || columns.get(i).getText().isEmpty())) {
					System.out.println(columns.get(i).getText());
					excelfile.setCellData(sheetName, colNum, 1, columns.get(i).getText());
					colNum++;
				}
			}

			//here we are getting the data from the table and adding the rows
			List<String> list = new ArrayList<String>();
			for (WebElement e : emiPaymentTableMonthlyDataRows2) {
				list.add(e.getText());
			}
			System.out.println(list.size());
			int col = 6;
			int row = list.size() / col;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					System.out.print(list.get(i * 6 + j) + " ");
					excelfile.setCellData(sheetName, j + 1, i + 2, list.get(i * 6 + j));
				}
				System.out.println();
			}
			logger.info("Monthly Data From Table extracted successfully");

		} catch (Exception e) {
			System.out.println(e);
			logger.info("Monthly Data extraction From Table failed");
		}
	}

	public void sendStatus(String sheetName, String status) {
//		ExcelUtils excelUtils =new E
	}

}

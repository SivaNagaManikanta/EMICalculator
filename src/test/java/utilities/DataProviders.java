package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
	
	@DataProvider(name = "CarLoanVerificationData")
	public static String[][]  getCarLoanVerificationData() throws IOException {

		String path = ".\\TestData\\TestInputData.xlsx";
		ExcelDataFile xlUtils = new ExcelDataFile(path);

		int totalrows = xlUtils.getRowCount("CarLoanDataInput");
		int totalcols = xlUtils.getCellCount("CarLoanDataInput", 1);
		String loanVerificationData[][] = new String[totalrows][totalcols];
		
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				loanVerificationData[i - 1][j] = xlUtils.getCellData("CarLoanDataInput", i, j);
			}
		}
		return loanVerificationData;

	}
	
	
	@DataProvider(name = "HomeLoanVerificationData")
	public static String[][]  getHomeLoanVerificationData() throws IOException {

		String path = ".\\TestData\\TestInputData.xlsx";
		ExcelDataFile xlUtils = new ExcelDataFile(path);

		int totalrows = xlUtils.getRowCount("HomeLoanDataInput");
		int totalcols = xlUtils.getCellCount("HomeLoanDataInput", 1);
		String loanVerificationData[][] = new String[totalrows][totalcols];
		
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				loanVerificationData[i - 1][j] = xlUtils.getCellData("HomeLoanDataInput", i, j);
			}
		}
		return loanVerificationData;
	}
	
	
	@DataProvider(name = "LoanCalculatorVerificationData")
	public static String[][]  getLoanCalculatorVerificationData() throws IOException {

		String path = ".\\TestData\\TestInputData.xlsx";
		ExcelDataFile xlUtils = new ExcelDataFile(path);

		int totalrows = xlUtils.getRowCount("LoanCalculatorDataInput");
		int totalcols = xlUtils.getCellCount("LoanCalculatorDataInput", 1);
		String loanVerificationData[][] = new String[totalrows][totalcols];
		
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				loanVerificationData[i - 1][j] = xlUtils.getCellData("LoanCalculatorDataInput", i, j);
			}

		}
		return loanVerificationData;
	}
	
	
	@DataProvider(name = "yearMonthData")
	public static String[][]  getYearMonthData() throws IOException {

		String path = ".\\TestData\\TestInputData.xlsx";
		ExcelDataFile xlUtils = new ExcelDataFile(path);

		int totalrows = xlUtils.getRowCount("YearMonthData");
		int totalcols = xlUtils.getCellCount("YearMonthData", 1);
		String yearMonthData[][] = new String[totalrows][totalcols];
		
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				yearMonthData[i - 1][j] = xlUtils.getCellData("YearMonthData", i, j);
			}
		}
		return yearMonthData;
	}
}

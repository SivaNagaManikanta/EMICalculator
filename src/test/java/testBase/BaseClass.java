package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {

	static public WebDriver driver;
//	public Logger logger;
	public Properties p;
	
	@BeforeTest
	@Parameters({ "browser" })
	public void setUp(String br) throws InterruptedException, IOException {

		// loading properties file
		FileInputStream file = new FileInputStream(".//src/test/resources/application.properties");
		p = new Properties();
		p.load(file);
		
		if(br.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else {
			System.out.println("No matching browser...");
		}

		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		timeUnitSleep(5);
		implicitWait(5);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	public String getTitle(String expectedTitle) {
		return driver.getTitle();
	}

	public void scrollPage(int pixels) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + pixels + ")");
	}

	public void scrollPageToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}

	public void timeUnitSleep(int time) throws InterruptedException {
		TimeUnit.SECONDS.sleep(time);
	}

	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		// rename the existing file
		sourceFile.renameTo(targetFile);

		// return the string path
		return targetFilePath;

	}

}

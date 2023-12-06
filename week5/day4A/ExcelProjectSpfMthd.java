package week5.day4A;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class ExcelProjectSpfMthd {

	public RemoteWebDriver driver;
	public String excelFileName;
	
	@Parameters({"url", "browser"})
	@BeforeMethod
	public void preCondition(String url, String browser) {
		
		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;

		default:
			driver = new ChromeDriver();
			break;
		}
	
		
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	  @AfterMethod 
	  public void postCondition() { 
		  driver.close();
	}
	 
	@DataProvider(name = "fetchData")
	public String[][] getData() throws IOException {
		
		return DataLibrary.readData(excelFileName);
		
		
	}
}

package week5.day1.tcA;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SequentialExecutionAssignment {
	
	@Test
	public void sequentially() {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://github.com/TestLeafPages/testcases");
		driver.close();
		
	}


}

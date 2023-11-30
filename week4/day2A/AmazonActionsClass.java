package week4.day2A;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonActionsClass {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//input[@id = 'twotabsearchtextbox']")).sendKeys("oneplus 9 pro");
		driver.findElement(By.xpath("//input[@id = 'nav-search-submit-button']")).click();
		String price1st = driver.findElement(By.xpath("//span[@class = 'a-price-whole']")).getText();
		System.out.println("1st product price : "+ price1st);
		String rating1st = driver.findElement(By.xpath("//div[@class ='a-row a-size-small']")).getText();
		System.out.println("coustemer rating : "+ rating1st);

		driver.findElement(By.xpath("//img[@class ='s-image']")).click();
		
		String windowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String string : windowHandles) {
			driver.switchTo().window(string);
			
		}
		
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File location1 = new File("./snap/beforeclick1.png");
		FileUtils.copyFile(screenshotAs, location1);
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		File screenShot2 = driver.getScreenshotAs(OutputType.FILE);
		File location2 = new File("./snaps/afterclick.png");
		FileUtils.copyFile(screenShot2, location2);
		Actions act = new Actions(driver);
		WebElement subTotal = driver.findElement(By.xpath("//b[text()='Cart subtotal']/following::span[2]"));
		Thread.sleep(3000);
		String subTot = subTotal.getText();
		System.out.println("The subtotal is : " + subTot);
		subTot = subTot.replaceAll(".00", "");
		subTot = subTot.replaceAll("₹", "");
		if(price1st.equals(subTot))	
		{
			System.out.println("The price values are matching");
		}else
		{
			System.out.println("The price values are not matching");
		}
		Thread.sleep(3000);
		driver.switchTo().window(windowHandle).close();
		driver.quit();
	}

}
